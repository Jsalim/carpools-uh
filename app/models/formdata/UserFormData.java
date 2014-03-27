package models.formdata;

import models.User;

public class UserFormData {

  public String username;
  public String name;
  public boolean isDriver;
  public String origin;
  public String comment;

  public String userImage;
  public String vehicleImage;

  public boolean noSmoking;
  public boolean noEating;
  public boolean noDrinking;
  public boolean sameGender;

  public String arrivalM;
  public String arrivalT;
  public String arrivalW;
  public String arrivalR;
  public String arrivalF;
  public String returnM;
  public String returnT;
  public String returnW;
  public String returnR;
  public String returnF;

  /**
   * Constructor. Used internally. Should <strong>NOT</strong> be called directly.
   */
  public UserFormData() {
    this.username = "";
    this.name = "";
    this.isDriver = false;
    this.origin = "";
    this.comment = "";

    this.userImage = "";
    this.vehicleImage = "";

    this.noSmoking = false;
    this.noEating = false;
    this.noDrinking = false;
    this.sameGender = false;

    this.arrivalM = this.arrivalT = this.arrivalW = this.arrivalR = this.arrivalF = "";
    this.returnM = this.returnT = this.returnW = this.returnR = this.returnF = "";
  }

  /**
   * Constructor. Fills the form data with the data from the <code>User</code> given.
   */
  public UserFormData(User user) {
    this.username = user.username();
    this.name = user.name();
    this.isDriver = user.isDriver();
    this.origin = user.origin();
    this.comment = user.comment();

    this.userImage = user.userImage();
    this.vehicleImage = user.vehicleImage();

    this.noSmoking = user.noSmoking();
    this.noEating = user.noEating();
    this.noDrinking = user.noDrinking();
    this.sameGender = user.sameGender();

    this.arrivalM = user.arrivalM();
    this.arrivalT = user.arrivalT();
    this.arrivalW = user.arrivalW();
    this.arrivalR = user.arrivalR();
    this.arrivalF = user.arrivalF();
    this.returnM = user.returnM();
    this.returnT = user.returnT();
    this.returnW = user.returnW();
    this.returnR = user.returnR();
    this.returnF = user.returnF();
  }
}
