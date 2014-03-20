package controllers;

import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import models.*;
import models.formdata.*;
import org.w3c.dom.Document;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.*;

public class Application extends Controller {
  
  private static final String CAS_LOGIN = "https://cas-test.its.hawaii.edu/cas/login";
  private static final String CAS_VALIDATE = "https://cas-test.its.hawaii.edu/cas/serviceValidate";

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
   * This page does not do anything as CAS login is currently not available.
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
          return redirect(routes.Application.appInterface());
        }
      }
      return redirect(routes.Application.home());
    }
  }

  /**
   * This is the Logout page.
   * This is basically the logout section no page as of yet.
   */
  public static Result logout() {
    session().clear();
    return redirect(routes.Application.home());
  }
  
  /**
   * This is the main interface page.
   */
  public static Result appInterface() {
    Data data = new Data();
    data.set("pageTitle", "Carpools UH");
    data.set("user", User.get(session().get("username")));
    data.set("drivers", User.getAllDrivers());
    return ok(AppInterface.render(data));
  }

  /**
   * This is the profile page.
   */
  public static Result appProfile() {
    Data data = new Data();
    data.set("pageTitle", "Carpools UH");
    
    return ok(AppProfile.render(data));
  }

  /**
   * Save the profile information.
   */
  public static Result saveProfile() {
    Form<UserFormData> userForm = Form.form(UserFormData.class);
    if(userForm.hasErrors()) {
      Data data = new Data();
      data.set("pageTitle", "Carpools UH");
      data.set("user", User.get(session().get("username")));
      return badRequest(AppProfile.render(data));
    } else {
      UserFormData userFormData = userForm.bindFromRequest().get();
      User.save(userFormData); 
    }
    return redirect(routes.Application.appProfile());
  }

  /**
   * This is the profile page.
   */
  public static Result appHistory() {
    Data data = new Data();
    data.set("pageTitle", "Carpools UH");
    data.set("user", User.get(session().get("username")));
    return ok(AppHistory.render(data));
  }

}
