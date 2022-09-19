package com.acadiasoft.im.simmple.util;

import java.util.List;

public class StringUtils {

  public static boolean containsIgnoreCase(List<String> stringList, String s) {
    if (stringList != null && !stringList.isEmpty()) {
      for (String string : stringList) {
        if (string != null && string.equalsIgnoreCase(s)) {
          return true;
        }
      }
    }
    return false;
  }

}
