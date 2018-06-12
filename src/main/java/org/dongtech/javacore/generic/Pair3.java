package org.dongtech.javacore.generic;

import org.dongtech.javacore.Boss;
import org.dongtech.javacore.Manager;

/**
 * @author Fuqiang
 * Created on 2018/6/12.
 */
public class Pair3<T extends Comparable<? super T>> {
  public static void main(String[] args) {
//    Pair3<Employee> pair3 = new Pair3<>(); //error
    Pair3<Manager> managerPair3 = new Pair3<>();
    Pair3<Boss> bossPair3 = new Pair3<>();
  }
}
