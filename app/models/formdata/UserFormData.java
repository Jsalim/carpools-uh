package models.formdata;

import models.User;

public class UserFormData {

  /** UH user ID */
  public long id;
  public String name;
  public boolean isDriver;
  public String origin;
  public String comment;

  /**
   * Constructor. Used internally. Should <strong>NOT</strong> be called directly.
   */
  public UserFormData() {
    this.id = 0;
    this.name = "";
    this.isDriver = false;
    this.origin = "";
    this.comment = "";
  }

  /**
   * Constructor. Fills the form data with the data from the <code>User</code> given.
   */
  public UserFormData(User user) {
    this.id = user.getId();
    this.name = user.getName();
    this.isDriver = user.getIsDriver();
    this.origin = user.getOrigin();
    this.comment = user.getComment();
  }
}
