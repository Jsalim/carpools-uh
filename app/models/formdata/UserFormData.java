package models.formdata;

public class UserFormData {

  /** UH user ID */
  public long id;
  public String name;
  public boolean isDriver;
  public String comment;

  /**
   * Constructor. Used internally. Should <strong>NOT</strong> be called directly.
   */
  public UserFormData() {
    this.id = 0;
    this.name = "";
    this.isDriver = false;
    this.comment = "";
  }
}
