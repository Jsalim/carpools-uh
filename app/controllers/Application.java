package controllers;


import java.io.File;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.util.Date;
import java.util.Map;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import models.Request;
import models.User;
import models.formdata.RequestFormData;
import models.formdata.UserFormData;
import org.apache.commons.codec.binary.Base64;
import org.w3c.dom.Document;
import play.Play;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Http.MultipartFormData;
import play.mvc.Http.MultipartFormData.FilePart;
import play.mvc.Result;
import play.mvc.Security;
import views.html.AppInterface;
import views.html.AppProfile;
import views.html.AppRequests;
import views.html.Home;

public class Application extends Controller {
  
  private static final String CAS_LOGIN = "https://cas-test.its.hawaii.edu/cas/login";
  private static final String CAS_VALIDATE = "https://cas-test.its.hawaii.edu/cas/serviceValidate";
  private static final String CAS_LOGOUT = "https://cas-test.its.hawaii.edu/cas/logout";
  
  private static final String UPLOADS_DIRECTORY = "uploads";

  /**
   * This is the home page.
   * This page basically a static page with information and a login button.
   */
  public static Result home() {
    Data data = new Data();
    data.set("pageTitle", "Carpools UH");
    return ok(Home.render(data));
  }
  
  /**
   * This is the Login page.
   * Redirects to CAS login, verifies the user, and redirects to the app interface
   */
  public static Result login() throws Exception {
    Map<String, String[]> query = request().queryString();
    String serviceURL = routes.Application.login().absoluteURL(request());
    serviceURL = URLEncoder.encode(serviceURL, "UTF-8");
    if(query.size() == 0) {
      return redirect(CAS_LOGIN + "?service=" + serviceURL);
    } else {
      String[] tickets = query.get("ticket");
      if(tickets.length > 0) {
        String ticket = tickets[0];
        String validateURL = CAS_VALIDATE + "?service=" + serviceURL + "&ticket=" + ticket;
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(new URL(validateURL).openStream());
        doc.getElementsByTagName("cas:serviceResponse");
        boolean success = doc.getElementsByTagName("cas:authenticationSuccess").getLength() > 0;
        if(success) {
          String username = doc.getElementsByTagName("cas:user").item(0).getTextContent();
          session().clear();
          session("username", username);
          User.add(username, "");
          return redirect(routes.Application.appInterface());
        }
      }
      return redirect(routes.Application.home());
    }
  }

  /**
   * This is the Logout page.
   * Clears the session and redirects to the home page.
   */
  public static Result logout() throws Exception {
    session().clear();
    String serviceURL = routes.Application.home().absoluteURL(request());
    serviceURL = URLEncoder.encode(serviceURL, "UTF-8");
    return redirect(CAS_LOGOUT + "?service=" + serviceURL);
  }
  
  /**
   * This is the main interface page.
   */
  @Security.Authenticated(Secured.class)
  public static Result appInterface() {
    Data data = new Data();
    data.set("pageTitle", "Carpools UH");
    data.set("user", User.get(session().get("username")));
    data.set("drivers", User.getAllDrivers());
    data.set("locations", User.getLocations());
    return ok(AppInterface.render(data));
  }

  /**
   * This is the profile page.
   */
  @Security.Authenticated(Secured.class)
  public static Result appProfile() {
    User user = User.get(session().get("username"));
    Data data = new Data();
    data.set("pageTitle", "Carpools UH");
    data.set("user", user);
    Form<UserFormData> userForm = Form.form(UserFormData.class).fill(new UserFormData(user));
    return ok(AppProfile.render(data, userForm));
  }

  /**
   * Save the profile information.
   * @throws IOException 
   */
  @Security.Authenticated(Secured.class)
  public static Result saveProfile() throws IOException {
    User user = User.get(session().get("username"));
    Data data = new Data();
    data.set("pageTitle", "Carpools UH");
    data.set("user", user);
    
    Form<UserFormData> userForm = Form.form(UserFormData.class).bindFromRequest();
    if(userForm.hasErrors()) {
      return badRequest(AppProfile.render(data, userForm));
    }

    UserFormData userFormData = userForm.get();
    MultipartFormData multipartFormData = request().body().asMultipartFormData();
    if(userFormData.userImageRemove) {
      userFormData.userImage = "";
    } else {
      userFormData.userImage = Application.uploadImage(multipartFormData, "userImage", user.userImage());
    }
    if(userFormData.vehicleImageRemove) {
      userFormData.vehicleImage = "";
    } else {
      userFormData.vehicleImage = Application.uploadImage(multipartFormData, "vehicleImage", user.vehicleImage());
    }
    User.save(userFormData);
    flash().put("success", "Changes saved.");
    return redirect(routes.Application.appProfile());
  }

  /**
   * This is the requests page.
   */
  @Security.Authenticated(Secured.class)
  public static Result appRequests() {
    Data data = new Data();
    data.set("pageTitle", "Carpools UH");
    data.set("user", User.get(session().get("username")));
    data.set("drivers", User.getAllDrivers());
    return ok(AppRequests.render(data));
  }

  /**
   * Creates a new request.
   */
  @Security.Authenticated(Secured.class)
  public static Result sendRequest() {
    // Get data from request form
    Form<RequestFormData> requestFrom = Form.form(RequestFormData.class).bindFromRequest();
    if(requestFrom.hasErrors()) {

    } else {
      // Add a new request to the Database
      RequestFormData requestFormData = requestFrom.get();
      Request.add(requestFormData);
      flash("success", "Request successfully sent to " + User.get(requestFormData.driverUsername).name());
    }
    return redirect(routes.Application.appInterface());
  }
  
  /**
   * Uploads a file if a file has been uploaded by the user.
   * @param multipartFormData
   * @param name
   * @param defaultValue
   * @return Returns the resulting location of the file. If the user did not upload a file, return defaultValue.
   * @throws IOException If fails to save file.
   */
  private static String uploadImage(MultipartFormData multipartFormData, String name, String defaultValue) throws IOException {
    FilePart userImageFilePart = multipartFormData.getFile(name);
    if(userImageFilePart != null) {
      String contentType = userImageFilePart.getContentType();
      if(contentType.indexOf("image") != -1) {
        byte[] bytes = loadFile(userImageFilePart.getFile());
        byte[] encoded = Base64.encodeBase64(bytes);
        return "data:" + contentType + ";base64," + (new String(encoded));
      }
    }
    return defaultValue;
  }

  private static byte[] loadFile(File file) throws IOException {
    InputStream is = new FileInputStream(file);

    long length = file.length();
    if (length > Integer.MAX_VALUE) {
      // File is too large
    }
    byte[] bytes = new byte[(int)length];
    
    int offset = 0;
    int numRead = 0;
    while (offset < bytes.length && (numRead=is.read(bytes, offset, bytes.length-offset)) >= 0) {
      offset += numRead;
    }

    if (offset < bytes.length) {
      throw new IOException("Could not completely read file "+file.getName());
    }

    is.close();
    return bytes;
  }
}
