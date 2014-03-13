package controllers;

import java.util.Iterator;
import java.util.Map;
import java.util.HashMap;

public class Data {

  private Map<String, Object> data;

  public Data() {
    data = new HashMap<String, Object>();
  }

  public void set(String key, Object value) {
    data.put(key, value);
  }

  public Object get(String key) {
    return data.get(key);
  }

}
