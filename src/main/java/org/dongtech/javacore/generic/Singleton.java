package org.dongtech.javacore.generic;

/**
 * @author Fuqiang
 * Created on 30/01/2018.
 */
public class Singleton<T> {

  public static <T> T getSingleInstance(T a) {
    return a;
  }
}
