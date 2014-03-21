import models.User;
import play.Application;
import play.GlobalSettings;

public class Global extends GlobalSettings{

  /**
   * Initializes Users on startup
   */
  public void onStart(Application app) {
    
    //       id  username     name                    driver  comment
    User.add(-1, "awood",     "Andrew-Pearson Wood",  true,   "No smokers. Let me know what your interests are so we can chat.");
    User.add(-1, "awang",     "Alvin Wang",           true,   "No smoking or eating please try to be on time.");
    User.add(-1, "eshek",     "Eva Shek",             true,   "");
    User.add(-1, "shonda",    "Scott Honda",          true,   "Need gas money. Be clean. I won't wait for you if you are late.");
    User.add(-1, "tkennedy",  "Taylor Kennedy",       false,  "");
    User.add(-1, "tpascua",   "Tyler Pascua",         false,  "");
    User.add(-1, "aprieto",   "Alvin Prieto",         true,   "");
    User.add(-1, "egamiao",   "Eduard Gamiao",        true,   "");
    User.add(-1, "ekomiyama", "Evan Komiyama",        true,   "");
    User.add(-1, "nsmith",    "Nicholas Smith",       true,   "I expect you to be sober.");
    User.add(-1, "lli",       "Leo Li",               true,   "Must have good hygiene please.");
    User.add(-1, "tchida",    "Terrance Chida",       true,   "");
    User.add(-1, "jknaus",    "Jaki Knaus",           true,   "");
    User.add(-1, "jlee",      "Janis Lee",            false,  "");
  }
}
