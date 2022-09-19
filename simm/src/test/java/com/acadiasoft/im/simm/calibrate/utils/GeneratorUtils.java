package com.acadiasoft.im.simm.calibrate.utils;

public class GeneratorUtils {

  public static String quoteIfNeeded(String s) {
    return s.contains("\"") ? s : "\"" + s + "\"";
  }

  public static String printNumber(String s) {
    String replaceAll = s.replaceAll(",", "").replaceAll(" ", "");
    if ("-".equals(replaceAll))
      return "\"0\"";
    else
      return replaceAll;
  }

}
