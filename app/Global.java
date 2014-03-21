import models.User;
import play.Application;
import play.GlobalSettings;

public class Global extends GlobalSettings{

  /**
   * Initializes Users on startup
   */
  public void onStart(Application app) {
    
    //       id  username     name                    driver  comment
    User.add(-1, "awood",     "Andrew-Pearson Wood",  true,   "Salt Lake",  "No smokers. Let me know what your interests are so we can chat.");
    User.add(-1, "awang",     "Alvin Wang",           true,   "Millilani",  "No smoking or eating please try to be on time.");
    User.add(-1, "eshek",     "Eva Shek",             true,   "Kaneohe",    "");
    User.add(-1, "shonda",    "Scott Honda",          true,   "Honolulu",   "Need gas money. Be clean. I won't wait for you if you are late.");
    User.add(-1, "tkennedy",  "Taylor Kennedy",       false,  "Pearl City", "");
    User.add(-1, "tpascua",   "Tyler Pascua",         false,  "Waianai",    "");
    User.add(-1, "aprieto",   "Alvin Prieto",         true,   "Manoa",      "");
    User.add(-1, "egamiao",   "Eduard Gamiao",        true,   "Haleiwa",    "");
    User.add(-1, "ekomiyama", "Evan Komiyama",        true,   "Waipahu",    "");
    User.add(-1, "nsmith",    "Nicholas Smith",       true,   "Salt Lake",  "I expect you to be sober.");
    User.add(-1, "lli",       "Leo Li",               true,   "Millilani",  "Must have good hygiene please.");
    User.add(-1, "tchida",    "Terrance Chida",       true,   "Salt Lake",  "");
    User.add(-1, "jknaus",    "Jaki Knaus",           true,   "Waipahu",    "");
    User.add(-1, "jlee",      "Janis Lee",            false,  "Aiea",       "");
  }
}
