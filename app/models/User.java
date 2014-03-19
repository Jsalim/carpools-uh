package models;

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
   * @param lastName The <code>User</code>'s last name
   * @return Returns the added <code>User</code>. If a <code>User</code> with the given <code>id</code> already exists, returns null.
   */
  public static User add(String id, String username, String firstName, String lastName) {
    if(users.get(id) == null) {
      User user = new User(id, username, firstName, lastName);
      users.put(id, user); 
      return user;
    }
    return null;
  }

  /**
   * Gets a <code>User</code> by <code>id</code>.
   * @return Returns the <code>User</code> with the given <code>id</code>. If the <code>User</code> does not exists, returns null.
   */
  public static User get(String id) {
    User user = users.get(id);
    return user;
  }

  /**
   * Gets all <code>User</code>s.
   * @return Returns a List of <code>User</code>s.
   */
  public static List<User> getAll() {
    return new ArrayList<User>(users.values());
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

  /**
   * Constructor. Used internally. Should <strong>NOT</strong> be called directly.
   */
  public User(long id, String username, String firstName, String lastName){
    this.id = id;
    this.username = username;
    this.firstName = firstName;
    this.lastName = lastName;
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
  public long getUsername() {
    return this.username;
  }

  /**
   * @return Full name, first and last.
   */
  public String getName() {
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
}
