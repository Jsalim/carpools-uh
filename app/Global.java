import models.User;
import play.Application;
import play.GlobalSettings;

public class Global extends GlobalSettings{

  /**
   * Initializes Users on startup
   */
  public void onStart(Application app) {
    
    //       id        username     first name          last name   driver  comment
    User.add(19364585, "awood",     "Andrew-Pearson",   "Wood",     true,   "No smokers. Let me know what your interests are so we can chat.");
    User.add(20684685, "awang",     "Alvin",            "Wang",     false,  "No smoking or eating please try to be on time.");
    User.add(21463264, "eshek",     "Eva",              "Shek",     true,   "");
    User.add(20335325, "shonda",    "Scott",            "Honda",    true,   "Need gas money. Be clean. I won't wait for you if you are late.");
    User.add(19256456, "tkennedy",  "Taylor",           "Kennedy",  false,  "");
    User.add(20123698, "tpascua",   "Tyler",            "Pascua",   false,  "");
    User.add(19535632, "aprieto",   "Alvin",            "Prieto",   true,   "");
    User.add(20325562, "egamiao",   "Eduard",           "Gamiao",   true,   "");
    User.add(19545646, "ekomiyama", "Evan",             "Komiyama", true,   "");
    User.add(20835762, "nsmith",    "Nicholas",         "Smith",    false,  "I expect you to be sober.");
    User.add(19253652, "lli",       "Leo",              "Li",       false,  "Must have good hygiene please.");
    User.add(20242554, "tchida",    "Terrance",         "Chida",    true,   "");
    User.add(19234322, "jknaus",    "Jaki",             "Knaus",    true,   "");
    User.add(20111113, "jlee",      "Janis",            "Lee",      false,  "");
    User.add(19685041, "kpaek",     "Kevin",            "Paek",     false,  "");
  }
}
