package org.dongtech.datastructures;

import java.util.Date;

/**
 * @author Fuqiang
 * Created on 23/02/2018.
 */
public abstract class BaseTest {
  static void log(String s) {
    System.out.println(new Date() + " " + s);
  }
}
