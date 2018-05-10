package org.dongtech.datastructures.list;

/**
 * @author Fuqiang
 * Created on 29/01/2018.
 */
public interface ListInterface<T> {
  boolean add(int position, T newEntry);

  T remove(int position);

  int getLength();

  T getEntry(int position);

  void clear();

  boolean isEmpty();
}
