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

  /**
   * Adds a new <code>User</code> to the database.
   * @param id The <code>User</code>'s UH id. Must be unique.
   * @param username The <code>User</code>'s UH username.
   * @param firstName The <code>User</code>'s first name.
   * @param lastName The <code>User</code>'s last name.
   * @param isDriver If the <code>User</code> is a driver.
   * @return Returns the added <code>User</code>. If a <code>User</code> with the given <code>id</code> already exists, returns null.
   */
  public static User add(long id, String username, String firstName, String lastName, boolean isDriver, String comment) {
    if(users.get(id) == null) {
      User user = new User(id, username, firstName, lastName, isDriver, comment);
      users.put(id, user);
      return user;
    }
    return null;
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

  public static User save(UserFormData formData) {
    User user = users.get(formData.id);
    user.setFirstName(formData.firstName);
    //...
    return user;
  }


  /*
   * User instance scope.
   **************************************************************************/

  /** UH user ID */
  private long id;
  /** UH username */
  private String username;
  private String firstName;
  private String lastName;
  private boolean isDriver;
  private String comment;

  /**
   * Constructor. Used internally. Should <strong>NOT</strong> be called directly.
   */
  public User(long id, String username, String firstName, String lastName, boolean isDriver, String comment){
    this.id = id;
    this.username = username;
    this.firstName = firstName;
    this.lastName = lastName;
    this.isDriver = isDriver;
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
   * @return Full name, first and last.
   */
  public String getFullName() {
    return this.firstName + " " + this.lastName;
  }

  /**
   * @return First name.
   */
  public String getFirstName() {
    return this.firstName;
  }

  /**
   * Sets the first name.
   */
  public void setFirstName(String value) {
    this.firstName = value;
  }

  /**
   * @return Last name.
   */
  public String getLastName() {
    return this.lastName;
  }

  /**
   * Sets the last name.
   */
  public void setLastName(String value) {
    this.lastName = value;
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
