package models;

import java.util.Date;
import java.util.Map;
import java.util.HashMap;
import models.formdata.RequestFormData;

public class Request {

  /*
   * User database management. Static scope.
   **************************************************************************/
  
  /** Map of requests. */
  private static Map<Long, Request> requests = new HashMap<Long, Request>();
  private static long _id = 0;

  /**
   * Adds a new <code>Request</code> to the database.
   * Uses the data from the form to populate fields.
   */
  public static Request add(RequestFormData formData) {
    long id = Request._id++;
    Request request = new Request(id, formData.requesterUsername, formData.driverUsername,
                                      formData.arrivalM, formData.arrivalT, formData.arrivalW, formData.arrivalR, formData.arrivalF,
                                      formData.returnM,  formData.returnT,  formData.returnW,  formData.returnR,  formData.returnF,
                                      formData.message);
    
    requests.put(id, request);
    return request;
  }

  /*
   * User instance scope.
   **************************************************************************/

  private long id;
  private String requesterUsername;
  private String driverUsername;

  private boolean arrivalM;
  private boolean arrivalT;
  private boolean arrivalW;
  private boolean arrivalR;
  private boolean arrivalF;

  private boolean returnM;
  private boolean returnT;
  private boolean returnW;
  private boolean returnR;
  private boolean returnF;

  private String message;
  private long timestamp;

  public Request(long id, String requesterUsername, String driverUsername,
                 boolean arrivalM, boolean arrivalT, boolean arrivalW, boolean arrivalR, boolean arrivalF,
                 boolean returnM,  boolean returnT,  boolean returnW,  boolean returnR,  boolean returnF,
                 String message) {
    this.id = id;
    this.requesterUsername = requesterUsername;
    this.driverUsername = driverUsername;

    this.arrivalM = arrivalM;
    this.arrivalT = arrivalT;
    this.arrivalW = arrivalW;
    this.arrivalR = arrivalR;
    this.arrivalF = arrivalF;

    this.returnM = returnM;
    this.returnT = returnT;
    this.returnW = returnW;
    this.returnR = returnR;
    this.returnF = returnF;

    this.message = message;
    this.timestamp = (new Date()).getTime();
  }

  public long id() {
    return this.id;
  }

  public String message() {
    return this.message;
  }
  public String message(String value) {
    return (this.message = value);
  }
  
  public long timestamp() {
    return this.timestamp;
  }
}
