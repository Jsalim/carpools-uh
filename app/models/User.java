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
   * @param id The <code>User</code>'s UH id. Must be unique.
   * @param username The <code>User</code>'s UH username.
   * @param name The <code>User</code>'s name.
   * @param isDriver If the <code>User</code> is a driver.
   * @return Returns the added <code>User</code>. If a <code>User</code> with the given <code>id</code> already exists, returns the existing <code>User</code>.
   */
  public static User add(long id, String username, String name, boolean isDriver, String location, String comment) {
    if(id == -1) {
      id = User._id++;
    }
    User user = users.get(id);
    if(user == null) {
      user = new User(id, username, name, isDriver, location, comment);
      users.put(id, user);
    }
    return user;
  }

  public static User add(long id, String username, String name) {
    return User.add(id, username, name, false, "", "");
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
      if(user.getUsername().equals(username)) {
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
      if(user.getIsDriver()) {
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
    user.setName(formData.name);
    //...
    return user;
  }

  /**
   * Gets all locations that are in use.
   */
  public static List<String> getLocations() {
    List<String> locations = new ArrayList<String>();
    for(User user : users.values()) {
      String location = user.getLocation();
      if(location.trim().length() > 0 && !locations.contains(location)) {
        locations.add(location);
      }
    }
    return locations;
  }

  /*
   * User instance scope.
   **************************************************************************/

  /** UH user ID */
  private long id;
  /** UH username */
  private String username;
  private String name;
  private boolean isDriver;
  private String location;
  private String comment;

  /**
   * Constructor. Used internally. Should <strong>NOT</strong> be called directly.
   */
  public User(long id, String username, String name, boolean isDriver, String location, String comment){
    this.id = id;
    this.username = username;
    this.name = name;
    this.isDriver = isDriver;
    this.location = location;
    this.comment = comment;
  }

  /**
   * @return UH id.
   */
  public long getId() {
    return this.id;
  }

  /**
   * @return UH username.
   */
  public String getUsername() {
    return this.username;
  }

  /**
   * @return Name.
   */
  public String getName() {
    return this.name;
  }

  /**
   * Sets the name.
   */
  public void setName(String value) {
    this.name = value;
  }

  /**
   * @return If the <code>User</code> is a driver.
   */
  public boolean getIsDriver() {
    return this.isDriver;
  }

  /**
   * Sets if this <code>User</code> is a driver.
   */
  public void setIsDriver(boolean value) {
    this.isDriver = value;
  }

  /**
   * @return location.
   */
  public String getLocation() {
    return this.location;
  }

  /**
   * Sets the location.
   */
  public void setLocation(String value) {
    this.location = value;
  }

  /**
   * @return Comment.
   */
  public String getComment() {
    return this.comment;
  }

  /**
   * Sets the comment.
   */
  public void setComment(String value) {
    this.comment = value;
  }
}
