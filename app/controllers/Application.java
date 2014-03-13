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
