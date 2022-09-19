package com.acadiasoft.im.simm.calibrate.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MapUtils {

  public static <T, X> void safeAdd(Map<T, List<X>> map, T key, X value) {
    if (!map.containsKey(key)) {
      map.put(key, new ArrayList<>());
    }
    map.get(key).add(value);
  }
}
