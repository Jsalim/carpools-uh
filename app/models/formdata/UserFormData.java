package models.formdata;

import models.User;

public class UserFormData {

  public long id;
  public String name;
  public boolean isDriver;
  public String origin;
  public String comment;

  public boolean noSmoking;
  public boolean noEating;
  public boolean noDrinking;
  public boolean sameGender;

  /**
   * Constructor. Used internally. Should <strong>NOT</strong> be called directly.
   */
  public UserFormData() {
    this.id = 0;
    this.name = "";
    this.isDriver = false;
    this.origin = "";
    this.comment = "";

    this.noSmoking = false;
    this.noEating = false;
    this.noDrinking = false;
    this.sameGender = false;
  }

  /**
   * Constructor. Fills the form data with the data from the <code>User</code> given.
   */
  public UserFormData(User user) {
    this.id = user.id();
    this.name = user.name();
    this.isDriver = user.isDriver();
    this.origin = user.origin();
    this.comment = user.comment();

    this.noSmoking = user.noSmoking();
    this.noEating = user.noEating();
    this.noDrinking = user.noDrinking();
    this.sameGender = user.sameGender();
  }
}
