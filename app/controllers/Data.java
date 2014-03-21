package controllers;

import models.User;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class Data {

  private Map<String, Object> data;

  public Data() {
    data = new HashMap<String, Object>();
  }

  /**
   * Store the value with the given key. Overwrites pre-existing value.
   */
  public void set(String key, Object value) {
    data.put(key, value);
  }

  /**
   * Retrieves the value as an <code>Object</code>.
   */
  public Object get(String key) {
    return data.get(key);
  }

  /**
   * Retrieves the value as a <code>User</code>.
   */
  public User getUser(String key) {
    return (User) data.get(key);
  }

  /**
   * Retrieves the value as a <code>List</code> of <code>User</code>s.
   */
  public List<User> getUsers(String key) {
    return (List<User>) data.get(key);
  }

  /**
   * Retrieves the value as a <code>List</code> of <code>String</code>s.
   */
  public List<String> getStrings(String key) {
    return (List<String>) data.get(key);
  }

}
