package org.dongtech.javacore.generic;

import org.dongtech.javacore.Boss;
import org.dongtech.javacore.Employee;

/**
 * @author Fuqiang
 * Created on 2018/6/12.
 */
public class Pair1<T extends Employee> {
  public static void main(String[] args) {
    Pair1<Boss> bossPair1 = new Pair1<>();
  }

  private T first;
  private T second;

  public Pair1() {
  }

  public Pair1(T first, T second) {
    this.first = first;
    this.second = second;
  }

  public T getFirst() {
    return first;
  }

  public void setFirst(T first) {
    this.first = first;
  }

  public T getSecond() {
    return second;
  }

  public void setSecond(T second) {
    this.second = second;
  }
}
