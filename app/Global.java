import models.User;
import play.Application;
import play.GlobalSettings;

public class Global extends GlobalSettings{

  /**
   * Initializes Users on startup
   */
  public void onStart(Application app) {
    
    //       username     name                    driver  comment
    User.add("awood",     "Andrew-Pearson Wood",  true,   "Salt Lake",  "No smokers. Let me know what your interests are so we can chat.");
    User.add("awang",     "Alvin Wang",           true,   "Millilani",  "No smoking or eating please try to be on time.");
    User.add("eshek",     "Eva Shek",             true,   "Kaneohe",    "");
    User.add("shonda",    "Scott Honda",          true,   "Honolulu",   "Need gas money. Be clean. I won't wait for you if you are late.");
    User.add("tkennedy",  "Taylor Kennedy",       false,  "Pearl City", "");
    User.add("tpascua",   "Tyler Pascua",         false,  "Waianai",    "");
    User.add("aprieto",   "Alvin Prieto",         true,   "Manoa",      "");
    User.add("egamiao",   "Eduard Gamiao",        true,   "Haleiwa",    "");
    User.add("ekomiyama", "Evan Komiyama",        true,   "Waipahu",    "");
    User.add("nsmith",    "Nicholas Smith",       true,   "Salt Lake",  "I expect you to be sober.");
    User.add("lli",       "Leo Li",               true,   "Millilani",  "Must have good hygiene please.");
    User.add("tchida",    "Terrance Chida",       true,   "Salt Lake",  "");
    User.add("jknaus",    "Jaki Knaus",           true,   "Waipahu",    "");
    User.add("jlee",      "Janis Lee",            false,  "Aiea",       "");
  }
}
