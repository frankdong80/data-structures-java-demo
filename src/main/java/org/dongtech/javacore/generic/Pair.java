package org.dongtech.javacore.generic;

/**
 * @author Fuqiang
 * Created on 29/01/2018.
 */
public class Pair<T> {
  private T first;
  private T second;

  public Pair() {
    first = null;
    second = null;
  }

  public static <T> Pair<T> makePair(Class<T> c) throws IllegalAccessException, InstantiationException {
    return new Pair<T>(c.newInstance(),c.newInstance());
  }

  public Pair(T first, T second) {
    this.first = first;
    this.second = second;
  }

  public T getFirst() {
    return first;
  }

  public void setFirst(T newValue) {
    first = newValue;
  }

  public T getSecond() {
    return second;
  }

  public void setSecond(T newValue) {
    second = newValue;
  }
}
