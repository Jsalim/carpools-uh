package controllers;

import play.mvc.Http.Context;
import play.mvc.Result;
import play.mvc.Security;

/**
 * Authenticator for the application.
 * See the <code>http://www.playframework.com/documentation/2.2.x/api/java/index.html</code> for more info.
 */
public class Secured extends Security.Authenticator {

  @Override
  public String getUsername(Context ctx) {
    return ctx.session().get("username");
  }

  @Override
  public Result onUnauthorized(Context ctx) {
    return redirect(routes.Application.home());
  }
}