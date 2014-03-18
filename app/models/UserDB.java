package models;

import java.util.HashMap;
import java.util.Map;
import views.formdata.UserFormData;

public class UserDB {

  private static Map<String, User> users = new HashMap<>();

  /**
   * Adds a User.
   * 
   * @param formData form for data.
   */
  public static void addUser(UserFormData formData) {
    String id = formData.uhLogin;
    User user =
        new User(formData.name, formData.uhLogin, formData.location, 
            formData.phone, formData.comment, formData.picSelf, formData.picCar);
    users.put(id, user);
  }
}
