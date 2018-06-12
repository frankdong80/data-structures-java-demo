package org.dongtech.javacore.generic;

import org.dongtech.javacore.Manager;

/**
 * @author Fuqiang
 * Created on 2018/6/12.
 */
public class Pair4<T extends Comparable<? extends T>> {
  public static void main(String[] args) {
//    Pair4<Employee> employeePair4 = new Pair4<>();//error
    Pair4<Manager> managerPair4 = new Pair4<>();
//    Pair4<Boss> bossPair4 = new Pair4<Boss>(); //error
  }
}
