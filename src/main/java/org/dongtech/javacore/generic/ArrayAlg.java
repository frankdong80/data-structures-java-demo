package org.dongtech.javacore.generic;

/**
 * @author Fuqiang
 * Created on 31/01/2018.
 */
public class ArrayAlg {
  public static <T extends Comparable<? super T>> Pair<T> minmax(T[] a) {
    if (a == null || a.length == 0) {
      return null;
    }
    T min = a[0];
    T max = a[0];
    for (int i = 1; i < a.length; i++) {
      if (min.compareTo(a[i]) > 0) {
        min = a[i];
      }
      if (max.compareTo(a[i]) < 0) {
        max = a[i];
      }
    }
    return new Pair<T>(min, max);
  }

  public static <T> T getMiddle(T[] a) {
    return a[a.length / 2];
  }

  public static <T extends Comparable<? super T>> T min(T[] a) {
    if (a == null || a.length == 0) {
      return null;
    }

    T smallest = a[0];
    for (int i = 1; i < a.length; i++) {
      if (smallest.compareTo(a[i]) > 0) {
        smallest = a[i];
      }
    }
    return smallest;
  }

}
