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
    return ok(Home.render("Carpools UH"));
  }

}
