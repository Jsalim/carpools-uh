package models.formdata;

import java.util.ArrayList;
import java.util.List;
import play.data.validation.ValidationError;
import models.User;

public class UserFormData {
 
  public String username;
  public String name;
  public boolean isDriver;
  public String origin;
  public String comment;

  public String userImage;
  public String vehicleImage;
  public boolean userImageRemove;
  public boolean vehicleImageRemove;

  public boolean noSmoking;
  public boolean noEating;
  public boolean noDrinking;
  public boolean sameGender;
  public boolean hideAlerts;

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
    this.userImageRemove = false;
    this.vehicleImageRemove = false;

    this.noSmoking = false;
    this.noEating = false;
    this.noDrinking = false;
    this.sameGender = false;
    this.hideAlerts = false;

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
    this.userImageRemove = false;
    this.vehicleImageRemove = false;

    this.noSmoking = user.noSmoking();
    this.noEating = user.noEating();
    this.noDrinking = user.noDrinking();
    this.hideAlerts = user.hideAlerts();

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
  
  public List<ValidationError> validate() {
    List<ValidationError> errors = new ArrayList<>();
    Time12HoursValidator time12HoursValidator;
    time12HoursValidator = new Time12HoursValidator();
    boolean validAM = time12HoursValidator.validate(this.arrivalM);
    boolean validAT = time12HoursValidator.validate(this.arrivalT);
    boolean validAW = time12HoursValidator.validate(this.arrivalW);
    boolean validAR = time12HoursValidator.validate(this.arrivalR);
    boolean validAF = time12HoursValidator.validate(this.arrivalF);
    boolean validRM = time12HoursValidator.validate(this.returnM);
    boolean validRT = time12HoursValidator.validate(this.returnT);
    boolean validRW = time12HoursValidator.validate(this.returnW);
    boolean validRR = time12HoursValidator.validate(this.returnR);
    boolean validRF= time12HoursValidator.validate(this.returnF);
    
    
    if(this.isDriver) {
      if(this.name.isEmpty()) {
        errors.add(new ValidationError("name", "Name is required if you want to be a driver."));        
      }
      if(this.origin.isEmpty()) {
        errors.add(new ValidationError("origin", "Origin is required if you want to be a driver."));
      }
      if(this.userImage.isEmpty()) {
        errors.add(new ValidationError("userImage", "User Picture is required if you want to be a driver."));
      }
      if(this.vehicleImage.isEmpty()) {
        errors.add(new ValidationError("vehicleImage", "Vehicle image is required if you want to be a driver."));
      }
      if(this.arrivalM.isEmpty() && this.arrivalT.isEmpty() && this.arrivalW.isEmpty() && this.arrivalR.isEmpty() && this.arrivalF.isEmpty() 
          && this.returnM.isEmpty() && this.returnT.isEmpty() && this.returnW.isEmpty() && this.returnR.isEmpty() && this.returnF.isEmpty()) {
        errors.add(new ValidationError("returnM", "At least one time must be entered if you want to be a driver"));
      }
      if(validAM == false && !this.arrivalM.isEmpty()) {
        errors.add(new ValidationError("arrivalM", "You entered a invalid time format e.g. '12:00am'"));
      }
      if(validAT == false && !this.arrivalT.isEmpty()) {
        errors.add(new ValidationError("arrivalT", "You entered a invalid time format e.g. '12:00am'"));
      }
      if(validAW == false && !this.arrivalW.isEmpty()) {
        errors.add(new ValidationError("arrivalW", "You entered a invalid time format e.g. '12:00am'"));
      }
      if(validAR == false && !this.arrivalR.isEmpty()) {
        errors.add(new ValidationError("arrivalR", "You entered a invalid time format e.g. '12:00am'"));
      }
      if(validAF == false && !this.arrivalF.isEmpty()) {
        errors.add(new ValidationError("arrivalF", "You entered a invalid time format e.g. '12:00am'"));
      }
      if(validRM == false && !this.returnM.isEmpty()) {
        errors.add(new ValidationError("returnM", "You entered a invalid time format e.g. '12:00am'"));
      }
      if(validRT == false && !this.returnT.isEmpty()) {
        errors.add(new ValidationError("returnT", "You entered a invalid time format e.g. '12:00am'"));
      }
      if(validRW == false && !this.returnW.isEmpty()) {
        errors.add(new ValidationError("returnW", "You entered a invalid time format e.g. '12:00am'"));
      }
      if(validRR == false && !this.returnR.isEmpty()) {
        errors.add(new ValidationError("returnR", "You entered a invalid time format e.g. '12:00am'"));
      }
      if(validRF == false && !this.returnF.isEmpty()) {
        errors.add(new ValidationError("returnF", "You entered a invalid time format e.g. '12:00am'"));
      }
    }

    return errors.isEmpty() ? null : errors;
  }
}
