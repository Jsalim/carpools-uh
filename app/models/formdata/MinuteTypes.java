package models.formdata;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents surfer types.
 */

public class MinuteTypes {
  
  private static String[] types = {"10","20","30","40","50","00"};
  
  /**
   * Returns an initialized Map of surfer types (when no type is selected).
   * @return The surfer type map.
   */
  public static Map<String, Boolean> getTypes() {
    Map<String, Boolean> typeMap = new HashMap<>();
    for (String type : types) {
      typeMap.put(type, false);
    }
    return typeMap;
  }
  
  /**
   * Returns a Map of the selected surfer type.
   * @param surfType The type of surfer.
   * @return The surfer type map.
   */
  public static Map<String, Boolean> getTypes(String timeType) {
    Map<String, Boolean> typeMap = MinuteTypes.getTypes();
    if (isType(timeType)) {
      typeMap.put(timeType,  true);
    }
    return typeMap;
  }

  /**
   * Returns true if surfType is valid type.
   * @param surfType The surfer type.
   * @return True if valid, else false.
   */
  public static boolean isType(String timeType) {
    return MinuteTypes.getTypes().keySet().contains(timeType);
  }
}
