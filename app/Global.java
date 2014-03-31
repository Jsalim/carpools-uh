import java.util.Random;
import models.User;
import play.Application;
import play.GlobalSettings;

public class Global extends GlobalSettings{

  /**
   * Initializes Users on startup
   */
  public void onStart(Application app) {
    
    //       username     name                    comment
    User.add("awood",     "Andrew-Pearson Wood",  "Salt Lake",  "No smokers. Let me know what your interests are so we can chat.",
              "images/profile/user/andrew.jpg",     "images/profile/vehicle/1.jpg");
    User.add("awang",     "Alvin Wang",           "Millilani",  "No smoking or eating please try to be on time.",
              "images/profile/user/alvinw.jpg",     "images/profile/vehicle/2.jpg");
    User.add("eshek",     "Eva Shek",             "Kaneohe",    "",
              "images/profile/user/evashek.jpg",    "images/profile/vehicle/3.jpg");
    User.add("shonda",    "Scott Honda",          "Honolulu",   "Need gas money. Be clean. I won't wait for you if you are late.",
              "images/profile/user/scott.jpg",      "images/profile/vehicle/4.jpg");
    User.add("tkennedy",  "Taylor Kennedy",       "Pearl City", "",
              "images/profile/user/taylor.jpg",     "images/profile/vehicle/5.jpg");
    User.add("tpascua",   "Tyler Pascua",         "Waianai",    "",
              "images/profile/user/tyler.jpg",      "images/profile/vehicle/6.jpg");
    User.add("aprieto",   "Alvin Prieto",         "Manoa",      "",
              "images/profile/user/alvin.jpg",      "images/profile/vehicle/7.jpg");
    User.add("egamiao",   "Eduard Gamiao",        "Haleiwa",    "",
              "images/profile/user/eduard.jpg",     "images/profile/vehicle/8.jpg");
    User.add("ekomiyama", "Evan Komiyama",        "Waipahu",    "",
              "images/profile/user/evan.jpg",       "images/profile/vehicle/9.jpg");
    User.add("nsmith",    "Nicholas Smith",       "Salt Lake",  "I expect you to be sober.",
              "images/profile/user/nick.jpg",       "images/profile/vehicle/10.jpg");
    User.add("lli",       "Leo Li",               "Millilani",  "Must have good hygiene please.",
              "images/profile/user/leo.jpg",        "images/profile/vehicle/11.jpg");
    User.add("tchida",    "Terrance Chida",       "Salt Lake",  "",
              "images/profile/user/terrance.jpg",   "images/profile/vehicle/12.jpg");
    User.add("jknaus",    "Jaki Knaus",           "Waipahu",    "",
              "images/profile/user/jaki.jpg",       "images/profile/vehicle/13.jpg");
    User.add("jlee",      "Janis Lee",            "Aiea",       "",
              "images/profile/user/janis.jpg",      "images/profile/vehicle/14.jpg");

    Random rand = new Random();
    for(User user : User.getAll()) {
      if(Math.random() < 0.5) {
        user.arrivalM((rand.nextInt(5) + 6) + ":" + (rand.nextInt(4) * 10 + 10) + "a");
      }
      if(Math.random() < 0.5) {
        user.arrivalT((rand.nextInt(5) + 6) + ":" + (rand.nextInt(4) * 10 + 10) + "a");
      }
      if(Math.random() < 0.5) {
        user.arrivalW((rand.nextInt(5) + 6) + ":" + (rand.nextInt(4) * 10 + 10) + "a");
      }
      if(Math.random() < 0.5) {
        user.arrivalR((rand.nextInt(5) + 6) + ":" + (rand.nextInt(4) * 10 + 10) + "a");
      }
      if(Math.random() < 0.5) {
        user.arrivalF((rand.nextInt(5) + 6) + ":" + (rand.nextInt(4) * 10 + 10) + "a");
      }

      if(Math.random() < 0.5) {
        user.returnM((rand.nextInt(3) + 2) + ":" + (rand.nextInt(4) * 10 + 10) + "p");
      }
      if(Math.random() < 0.5) {
        user.returnT((rand.nextInt(3) + 2) + ":" + (rand.nextInt(4) * 10 + 10) + "p");
      }
      if(Math.random() < 0.5) {
        user.returnW((rand.nextInt(3) + 2) + ":" + (rand.nextInt(4) * 10 + 10) + "p");
      }
      if(Math.random() < 0.5) {
        user.returnR((rand.nextInt(3) + 2) + ":" + (rand.nextInt(4) * 10 + 10) + "p");
      }
      if(Math.random() < 0.5) {
        user.returnF((rand.nextInt(3) + 2) + ":" + (rand.nextInt(4) * 10 + 10) + "p");
      }
    }
  }
}
