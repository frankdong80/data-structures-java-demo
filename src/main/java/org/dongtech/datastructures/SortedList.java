package org.dongtech.datastructures;

/**
 * @author Fuqiang
 * Created on 24/02/2018.
 */
public class SortedList<T extends Comparable<? super T>> implements SortedListInterface<T> {
  @Override
  public boolean add(T newEntry) {
    return false;
  }

  @Override
  public boolean remove(T anEntry) {
    return false;
  }

  @Override
  public int getPosition(T anEntry) {
    return 0;
  }

  @Override
  public T getEntry(int givenPosition) {
    return null;
  }

  @Override
  public boolean contains(T anEntry) {
    return false;
  }

  @Override
  public T remove(int givenPosition) {
    return null;
  }

  @Override
  public void clear() {

  }

  @Override
  public int getLength() {
    return 0;
  }

  @Override
  public boolean isEmpty() {
    return false;
  }

  @Override
  public boolean isFull() {
    return false;
  }

  @Override
  public void display() {

  }
}
