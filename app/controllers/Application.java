package controllers;

import play.*;
import play.mvc.*;
import views.html.*;

public class Application extends Controller {
  
  /**
   *  This is the home page.
   *  This page basically a static page with information and a login button.
   */
  public static Result home() {
    Data data = new Data();
    data.set("pageTitle", "Carpools UH");
    return ok(Home.render(data));
  }
  
  /**
   *  This is the Login page.
   *  This page does not do anything as CAS login is currently not available.
   */
  public static Result login() {
    return redirect("/app");
  }
  
  /**
   *  This is the Logout page.
   *  This is basically the logout section no page as of yet.
   */
  public static Result logout() {
    return redirect("/");
  }
  
  /**
   *  This is the main interface page.
   */
  public static Result appInterface() {
    Data data = new Data();
    data.set("pageTitle", "Carpools UH");
    data.set("username", "jsmith");
    return ok(AppInterface.render(data));
  }

  /**
   *  This is the profile page.
   */
  public static Result appProfile() {
    Data data = new Data();
    data.set("pageTitle", "Carpools UH");
    data.set("username", "jsmith");
    return ok(AppProfile.render(data));
  }

  /**
   *  This is the profile page.
   */
  public static Result appHistory() {
    Data data = new Data();
    data.set("pageTitle", "Carpools UH");
    data.set("username", "jsmith");
    return ok(AppHistory.render(data));
  }

}
