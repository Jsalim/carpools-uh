package models;

import java.util.List;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;

public class User extends Model{

  /**
   * 
   */
  private static final long serialVersionUID = -5255740610156537447L;
  
  
  //User's ID
  private long id;
  //User's name
  private String name;
  //User's uh login/email
  private String uhLogin;
  //User's origin
  private String location;
  //User's phone
  private String phone;
  //User's comment
  private String comment;
  //User's personal picture
  private String picSelf;
  //User's car picture
  private String picCar;
  
  /**
   * The EBean ORM finder method for database queries.
   * 
   * @return The finder method for Surfers.
   */
  public static Finder<Long, User> find() {
    return new Finder<Long, User>(Long.class, User.class);
  }
  
  /**
   * Creates a User.
   * @param id Users id.
   * @param name Users name.
   * @param uhLogin Users login/email.
   * @param location Users origin
   * @param phone Users phone number.
   * @param comment Users extra comment.
   */
  public User(long id, String name, String uhLogin, String location, String phone, String comment, String picSelf, String picCar){
    this.id = id;
    this.name = name;
    this.uhLogin = uhLogin;
    this.location = location;
    this.phone = phone;
    this.comment = comment;
    this.picSelf = picSelf;
    this.picCar = picCar;
  }
  
  public User(String name, String uhLogin, String location, String phone, String comment, String picSelf, String picCar){
    this.name = name;
    this.uhLogin = uhLogin;
    this.location = location;
    this.phone = phone;
    this.comment = comment;
    this.picSelf = picSelf;
    this.picCar = picCar;
  }

  /**
   * @return the id
   */
  public long getId() {
    return id;
  }

  /**
   * @param id the id to set
   */
  public void setId(long id) {
    this.id = id;
  }

  /**
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * @param name the name to set
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * @return the uhLogin
   */
  public String getUhLogin() {
    return uhLogin;
  }

  /**
   * @param uhLogin the uhLogin to set
   */
  public void setUhLogin(String uhLogin) {
    this.uhLogin = uhLogin;
  }

  /**
   * @return the location
   */
  public String getLocation() {
    return location;
  }

  /**
   * @param location the location to set
   */
  public void setLocation(String location) {
    this.location = location;
  }

  /**
   * @return the phone
   */
  public String getPhone() {
    return phone;
  }

  /**
   * @param phone the phone to set
   */
  public void setPhone(String phone) {
    this.phone = phone;
  }

  /**
   * @return the comment
   */
  public String getComment() {
    return comment;
  }

  /**
   * @param comment the comment to set
   */
  public void setComment(String comment) {
    this.comment = comment;
  }

  /**
   * @return the picSelf
   */
  public String getPicSelf() {
    return picSelf;
  }

  /**
   * @param picSelf the picSelf to set
   */
  public void setPicSelf(String picSelf) {
    this.picSelf = picSelf;
  }

  /**
   * @return the picCar
   */
  public String getPicCar() {
    return picCar;
  }

  /**
   * @param picCar the picCar to set
   */
  public void setPicCar(String picCar) {
    this.picCar = picCar;
  }
  
}
