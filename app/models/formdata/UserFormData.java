package models.formdata;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class UserFormData {

  /** UH user ID */
  public long id;
  public String firstName;
  public String lastName;
  public boolean isDriver;
  public String comment;

  /**
   * Constructor. Used internally. Should <strong>NOT</strong> be called directly.
   */
  public UserFormData() {
    this.id = 0;
    this.firstName = "";
    this.lastName = "";
    this.isDriver = false;
    this.comment = "";
  }
}
