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
    
    //name,uh-login,location,phone,comment,pic-self,pic-car
    UserDB.addUser(new UserFormData("Andrew-Pearson Wood","awood","Kaneohe","(808) 232-5196","No smokers. Let me know what your interests are so we can chat.","",""));
    UserDB.addUser(new UserFormData("Alvin Wang","awang","Honolulu","(808) 578-6520","No smoking or eating please try to be on time.","",""));
    UserDB.addUser(new UserFormData("Eva Shek","eshek","Mililani","(808) 930-6402","","",""));
    UserDB.addUser(new UserFormData("Scott Honda","shonda","Millilani","(808) 843-0046","Need gas money. Be clean. I won't wait for you if you are late.","",""));
    UserDB.addUser(new UserFormData("Taylor Kennedy","tkennedy","Kaimuki","(808) 855-0019","","",""));
    UserDB.addUser(new UserFormData("Tyler Pascua","tpascua","Millilani","(808) 966-3848","","",""));
    UserDB.addUser(new UserFormData("Alvin Prieto","aprieto","Waipahu","(808) 642-6222","","",""));
    UserDB.addUser(new UserFormData("Eduard Gamiao","egamiao","Waipahu","(808) 763-1787","","",""));
    UserDB.addUser(new UserFormData("Evan Komiyama","ekomiyama","Waipahu","(808) 689-9078","","",""));
    UserDB.addUser(new UserFormData("Nicholas Smith","nsmith","Mililani","(808) 892-9673","I expect you to be sober.","",""));
    UserDB.addUser(new UserFormData("Leo Li","lli","Kaimuki","(808) 772-0089","Must have good hygiene please.","",""));
    UserDB.addUser(new UserFormData("Terrance Chida","tchida","Salt Lake","(808) 773-1009","","",""));
    UserDB.addUser(new UserFormData("Jaki Knaus","jknaus","Millilani","(808) 753-0422","","",""));
    UserDB.addUser(new UserFormData("Janis Lee","jlee","Salt Lake","(808) 700-2507","","",""));
    UserDB.addUser(new UserFormData("","","","","","",""));
  }
}
