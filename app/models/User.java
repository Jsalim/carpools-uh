package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import models.formdata.UserFormData;

public class User {

  /*
   * User database management. Static scope.
   **************************************************************************/

  /** Map of users. */
  private static Map<String, User> users = new HashMap<String, User>();
  /** Used to keep track of the id for new Users. Needed because CAS login does not provide the userid. */
  private static long _id = 0;

  /**
   * Adds a new <code>User</code> to the database. Sets default values for most properties.
   * @param username UH username.
   * @param name
   * @return Returns the added <code>User</code>. If a <code>User</code> with the given <code>username</code> already exists, returns the existing <code>User</code>.
   */
  public static User add(String username, String name) {
    return User.add(username, name, "", "");
  }

  /**
   * Adds a new <code>User</code> to the database.
   * @param username UH username.
   * @param name
   * @param isDriver
   * @param origin
   * @param comment
   * @return Returns the added <code>User</code>. If a <code>User</code> with the given <code>username</code> already exists, returns the existing <code>User</code>.
   */
  public static User add(String username, String name, String origin, String comment) {
    return User.add(username, name, false, "", "", "", "");
  }

  /**
   * Adds a new <code>User</code> to the database.
   * @param username UH username.
   * @param name
   * @param isDriver
   * @param origin
   * @param comment
   * @return Returns the added <code>User</code>. If a <code>User</code> with the given <code>username</code> already exists, returns the existing <code>User</code>.
   */
  public static User add(String username, String name, boolean isDriver, String origin, String comment, String userImage, String vehicleImage) {
    User user = users.get(username);
    if(user == null) {
      long id = User._id++;
      user = new User(id, username, name, isDriver, origin, comment);
      user.userImage(userImage);
      user.vehicleImage(vehicleImage);
      users.put(username, user);
    }
    return user;
  }

  /**
   * Gets a <code>User</code> by their <code>username</code>.
   * @return Returns the <code>User</code> with the given <code>username</code>. If the <code>User</code> does not exists, returns null.
   */
  public static User get(String username) {
    return users.get(username);
  }

  /**
   * Gets the first <code>User</code>.
   * @return Returns the first <code>User</code>.
   */
  public static User getFirst() {
    return (User) users.entrySet().iterator().next().getValue();
  }

  /**
   * Gets all <code>User</code>s.
   * @return Returns a <code>List</code> of <code>User</code>s.
   */
  public static List<User> getAll() {
    return new ArrayList<User>(users.values());
  }

  /**
   * Gets all <code>User</code>s that are drivers.
   * @return Returns a <code>List</code> of <code>User</code>s that are drivers.
   */
  public static List<User> getAllDrivers() {
    List<User> drivers = new ArrayList<User>();
    for(User user : users.values()) {
      if(user.isDriver()) {
        drivers.add(user);
      }
    }
    return drivers;
  }

  /**
   * Saves a <code>User</code> based on the <code>UserFormData</code> given.
   */
  public static User save(UserFormData formData) {
    User user = User.get(formData.username);
    user.name(formData.name);
    user.isDriver(formData.isDriver);
    user.origin(formData.origin);
    user.comment(formData.comment);

    user.userImage(formData.userImage);
    user.vehicleImage(formData.vehicleImage);
    
    user.noSmoking(formData.noSmoking);
    user.noEating(formData.noEating);
    user.noDrinking(formData.noDrinking);

    user.arrivalM(formData.arrivalM);
    user.arrivalT(formData.arrivalT);
    user.arrivalW(formData.arrivalW);
    user.arrivalR(formData.arrivalR);
    user.arrivalF(formData.arrivalF);

    user.returnM(formData.returnM);
    user.returnT(formData.returnT);
    user.returnW(formData.returnW);
    user.returnR(formData.returnR);
    user.returnF(formData.returnF);
    
    user.hideAlerts(formData.hideAlerts);

    return user;
  }

  /**
   * Gets all locations that are in use.
   */
  public static List<String> getLocations() {
    List<String> locations = new ArrayList<String>();
    for(User user : users.values()) {
      String location = user.origin();
      if(location.trim().length() > 0 && !locations.contains(location)) {
        locations.add(location);
      }
    }
    return locations;
  }

  /*
   * User instance scope.
   **************************************************************************/

  private long id;
  /** UH username */
  private String username;
  private String name;
  private boolean isDriver;
  private String origin;
  private String comment;
  // images
  private String userImage;
  private String vehicleImage;
  // preferences
  private boolean noSmoking;
  private boolean noEating;
  private boolean noDrinking;
  public boolean hideAlerts;
  // times
  private String arrivalM;
  private String arrivalT;
  private String arrivalW;
  private String arrivalR;
  private String arrivalF;
  private String returnM;
  private String returnT;
  private String returnW;
  private String returnR;
  private String returnF;

  /**
   * Constructor. Used internally. Should <strong>NOT</strong> be called directly.
   */
  public User(long id, String username, String name, boolean isDriver, String origin, String comment){
    this.id = id;
    this.username = username;
    this.name = name;
    this.isDriver = isDriver;
    this.origin = origin;
    this.comment = comment;

    this.userImage = "";
    this.vehicleImage = "";
    
    this.noSmoking = true;
    this.noEating = true;
    this.noDrinking = true;
    this.hideAlerts = false;

    this.arrivalM = this.arrivalT = this.arrivalW = this.arrivalR = this.arrivalF = "";
    this.returnM = this.returnT = this.returnW = this.returnR = this.returnF = "";
  }

  /** Getter for id. */
  public long id() { return this.id; }

  /** Getter for username. */
  public String username() { return this.username; }
  /** Setter for username. */
  public String username(String value) { return (this.username = value); }

  /** Getter for name. */
  public String name() { return this.name; }
  /** Setter for name. */
  public String name(String value) { return (this.name = value); }

  /** Getter for isDriver. */
  public boolean isDriver() { return this.isDriver; }
  /** Setter for isDriver. */
  public boolean isDriver(boolean value) { return (this.isDriver = value); }

  /** Getter for origin. */
  public String origin() { return this.origin; }
  /** Setter for origin. */
  public String origin(String value) { return (this.origin = value); }

  /** Getter for comment. */
  public String comment() { return this.comment; }
  /** Setter for comment. */
  public String comment(String value) { return (this.comment = value); }

  /** Getter for userImage. */
  public String userImage() { return this.userImage; }
  /** Setter for userImage. */
  public String userImage(String value) { return (this.userImage = value); }

  /** Getter for vehicleImage. */
  public String vehicleImage() { return this.vehicleImage; }
  /** Setter for vehicleImage. */
  public String vehicleImage(String value) { return (this.vehicleImage = value); }

  /** Getter for noSmoking. */
  public boolean noSmoking() { return this.noSmoking; }
  /** Setter for noSmoking. */
  public boolean noSmoking(boolean value) { return (this.noSmoking = value); }

  /** Getter for noEating. */
  public boolean noEating() { return this.noEating; }
  /** Setter for noEating. */
  public boolean noEating(boolean value) { return (this.noEating = value); }

  /** Getter for noDrinking. */
  public boolean noDrinking() { return this.noDrinking; }
  /** Setter for noDrinking. */
  public boolean noDrinking(boolean value) { return (this.noDrinking = value); }

  /** Getter for hideAlerts. */
  public boolean hideAlerts() { return hideAlerts; }
  /** Setter for hideAlerts. */
  public boolean hideAlerts(boolean value) { return (this.hideAlerts = value); }

  /** Getter for arrivalM. */
  public String arrivalM() { return this.arrivalM; }
  /** Setter for arrivalM. */
  public String arrivalM(String value) { return (this.arrivalM = value); }
  
  /** Getter for arrivalT. */
  public String arrivalT() { return this.arrivalT; }
  /** Setter for arrivalT. */
  public String arrivalT(String value) { return (this.arrivalT = value); }
  
  /** Getter for arrivalW. */
  public String arrivalW() { return this.arrivalW; }
  /** Setter for arrivalW. */
  public String arrivalW(String value) { return (this.arrivalW = value); }
  
  /** Getter for arrivalR. */
  public String arrivalR() { return this.arrivalR; }
  /** Setter for arrivalR. */
  public String arrivalR(String value) { return (this.arrivalR = value); }
  
  /** Getter for arrivalF. */
  public String arrivalF() { return this.arrivalF; }
  /** Setter for arrivalF. */
  public String arrivalF(String value) { return (this.arrivalF = value); }

  /** Getter for returnM. */
  public String returnM() { return this.returnM; }
  /** Setter for returnM. */
  public String returnM(String value) { return (this.returnM = value); }
  
  /** Getter for returnT. */
  public String returnT() { return this.returnT; }
  /** Setter for returnT. */
  public String returnT(String value) { return (this.returnT = value); }
  
  /** Getter for returnW. */
  public String returnW() { return this.returnW; }
  /** Setter for returnW. */
  public String returnW(String value) { return (this.returnW = value); }
  
  /** Getter for returnR. */
  public String returnR() { return this.returnR; }
  /** Setter for returnR. */
  public String returnR(String value) { return (this.returnR = value); }
  
  /** Getter for returnF. */
  public String returnF() { return this.returnF; }
  /** Setter for returnF. */
  public String returnF(String value) { return (this.returnF = value); }
}
