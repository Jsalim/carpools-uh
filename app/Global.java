import models.User;
import models.UserDB;
import play.Application;
import play.GlobalSettings;
import play.Play;
import views.formdata.UserFormData;

/**
 * Initializes Users on startup
 *
 */
public class Global extends GlobalSettings{

  public void onStart(Application app) {
    
  
    UserDB.addUser(new UserFormData("","","","","","",""));
    UserDB.addUser(new UserFormData("","","","","","",""));
    UserDB.addUser(new UserFormData("","","","","","",""));
    UserDB.addUser(new UserFormData("","","","","","",""));
    UserDB.addUser(new UserFormData("","","","","","",""));
    UserDB.addUser(new UserFormData("","","","","","",""));
    UserDB.addUser(new UserFormData("","","","","","",""));
    UserDB.addUser(new UserFormData("","","","","","",""));
    UserDB.addUser(new UserFormData("","","","","","",""));
    UserDB.addUser(new UserFormData("","","","","","",""));
    UserDB.addUser(new UserFormData("","","","","","",""));
    UserDB.addUser(new UserFormData("","","","","","",""));
    UserDB.addUser(new UserFormData("","","","","","",""));
    UserDB.addUser(new UserFormData("","","","","","",""));
    UserDB.addUser(new UserFormData("","","","","","",""));
  }
}
