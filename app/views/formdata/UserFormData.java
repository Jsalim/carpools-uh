package views.formdata;

import models.User;

public class UserFormData {
  
  //User's ID
  public long id = 0;
  //User's name
  public String name = "";
  //User's uh login/email
  public String uhLogin = "";
  //User's origin
  public String location = "";
  //User's phone
  public String phone = "";
  //User's comment
  public String comment = "";
  //User's personal picture
  public String picSelf = "";
  //User's car picture
  public String picCar = "";
  
  /**
   * Creates a User.
   * @param id Users id.
   * @param name Users name.
   * @param uhLogin Users login/email.
   * @param location Users origin
   * @param phone Users phone number.
   * @param comment Users extra comment.
   */
  public UserFormData(String name, String uhLogin, String location, String phone, String comment, String picSelf, String picCar){
    this.name = name;
    this.uhLogin = uhLogin;
    this.location = location;
    this.phone = phone;
    this.comment = comment;
    this.picSelf = picSelf;
    this.picCar = picCar;
  }
  
  /**
   * 
   * @param user
   */
  public UserFormData(User user){
    this.id = user.getId();
    this.name = user.getName();
    this.uhLogin = user.getUhLogin();
    this.location = user.getLocation();
    this.phone = user.getPhone();
    this.comment = user.getComment();
    this.picSelf = user.getPicSelf();
    this.picCar = user.getPicCar();
  }

}
