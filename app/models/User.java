package models;

import models.formdata.UserFormData;
import java.util.Iterator;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class User {

  /*
   * User database management. Static scope.
   **************************************************************************/

  /** Map of users. */
  private static Map<Long, User> users = new HashMap<Long, User>();
  /** Used to keep track of the id for new Users. Needed because CAS login does not provide the userid. */
  private static long _id = 0;

  /**
   * Adds a new <code>User</code> to the database.
   * @param username UH username.
   * @param name
   * @param isDriver
   * @param origin
   * @return Returns the added <code>User</code>. If a <code>User</code> with the given <code>id</code> already exists, returns the existing <code>User</code>.
   */
  public static User add(String username, String name, boolean isDriver, String origin, String comment) {
    long id = User._id++;
    User user = users.get(id);
    if(user == null) {
      user = new User(id, username, name, isDriver, origin, comment);
      users.put(id, user);
    }
    return user;
  }

  public static User add(String username, String name) {
    return User.add(username, name, false, "", "");
  }

  /**
   * Gets a <code>User</code> by <code>id</code>.
   * @return Returns the <code>User</code> with the given <code>id</code>. If the <code>User</code> does not exists, returns null.
   */
  public static User get(long id) {
    User user = users.get(id);
    return user;
  }

  /**
   * Gets a <code>User</code> by their <code>username</code>.
   * @return Returns the <code>User</code> with the given <code>username</code>. If the <code>User</code> does not exists, returns null.
   */
  public static User get(String username) {
    Iterator<User> iterator = users.values().iterator();
    while(iterator.hasNext()) {
      User user = iterator.next();
      if(user.username().equals(username)) {
        return user;
      }
    }
    return null;
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
    User user = users.get(formData.id);
    user.name(formData.name);
    user.isDriver(formData.isDriver);
    //...
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
  // preferences
  private boolean noSmoking;
  private boolean noEating;
  private boolean noDrinking;
  private boolean sameGender;

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
    this.noSmoking = true;
    this.noEating = true;
    this.noDrinking = true;
    this.sameGender = false;
  }

  /** Getter for id. */
  public long id() {
    return this.id;
  }

  /** Getter for username. */
  public String username() {
    return this.username;
  }

  /** Setter for username. */
  public String username(String value) {
    return (this.username = value);
  }

  /** Getter for name. */
  public String name() {
    return this.name;
  }

  /** Setter for name. */
  public String name(String value) {
    return (this.name = value);
  }

  /** Getter for isDriver. */
  public boolean isDriver() {
    return this.isDriver;
  }

  /** Setter for isDriver. */
  public boolean isDriver(boolean value) {
    return (this.isDriver = value);
  }

  /** Getter for origin. */
  public String origin() {
    return this.origin;
  }

  /** Setter for origin. */
  public String origin(String value) {
    return (this.origin = value);
  }

  /** Getter for comment. */
  public String comment() {
    return this.comment;
  }

  /** Setter for comment. */
  public String comment(String value) {
    return (this.comment = value);
  }

  /** Getter for noSmoking. */
  public boolean noSmoking() {
    return this.noSmoking;
  }

  /** Setter for noSmoking. */
  public boolean noSmoking(boolean value) {
    return (this.noSmoking = value);
  }

  /** Getter for noEating. */
  public boolean noEating() {
    return this.noEating;
  }

  /** Setter for noEating. */
  public boolean noEating(boolean value) {
    return (this.noEating = value);
  }

  /** Getter for noDrinking. */
  public boolean noDrinking() {
    return this.noDrinking;
  }

  /** Setter for noDrinking. */
  public boolean noDrinking(boolean value) {
    return (this.noDrinking = value);
  }

  /** Getter for sameGender. */
  public boolean sameGender() {
    return this.sameGender;
  }

  /** Setter for sameGender. */
  public boolean sameGender(boolean value) {
    return (this.sameGender = value);
  }
}
