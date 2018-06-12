package org.dongtech.javacore.generic;

import org.dongtech.javacore.Manager;

/**
 * @author Fuqiang
 * Created on 2018/6/12.
 */
public class Pair2<T extends Comparable<T>> {
  public static void main(String[] args) {
//    Pair2<Employee> pair2 = new Pair2<>();//error
    Pair2<Manager> managerPair2 = new Pair2<>();
//    Pair2<Boss> bossPair2 = new Pair2<>();//error
  }
}
