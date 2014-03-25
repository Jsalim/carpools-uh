package models.formdata;

import java.util.List;
import java.util.ArrayList;
import models.Request;

public class RequestFormData {

  public String requesterUsername;
  public String driverUsername;

  public boolean arrivalM;
  public boolean arrivalT;
  public boolean arrivalW;
  public boolean arrivalR;
  public boolean arrivalF;

  public boolean returnM;
  public boolean returnT;
  public boolean returnW;
  public boolean returnR;
  public boolean returnF;

  public String message;

  /**
   * Constructor. Used internally. Should <strong>NOT</strong> be called directly.
   */
  public RequestFormData() {
    requesterUsername = "";
    driverUsername = "";

    arrivalM = false;
    arrivalT = false;
    arrivalW = false;
    arrivalR = false;
    arrivalF = false;

    returnM = false;
    returnT = false;
    returnW = false;
    returnR = false;
    returnF = false;

    message = "";
  }
}
