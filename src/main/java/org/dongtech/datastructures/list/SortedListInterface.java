package org.dongtech.datastructures.list;

/**
 * @author Fuqiang
 * Created on 24/02/2018.
 */
public interface SortedListInterface<T extends Comparable<? super T>> {
  boolean add(T newEntry);

  boolean remove(T anEntry);

  int getPosition(T anEntry);

  T getEntry(int givenPosition);

  boolean contains(T anEntry);

  T remove(int givenPosition);

  void clear();

  int getLength();

  boolean isEmpty();

  boolean isFull();

  void display();
}
