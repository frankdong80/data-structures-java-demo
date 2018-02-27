package org.dongtech.datastructures;

/**
 * @author Fuqiang
 * Created on 27/02/2018.
 */
public class LList<T extends Comparable<? super T>> implements ListInterface<T> {
  @Override
  public boolean add(int position, T newEntry) {
    return false;
  }

  @Override
  public T remove(int position) {
    return null;
  }

  @Override
  public int getLength() {
    return 0;
  }

  @Override
  public T getEntry(int position) {
    return null;
  }

  @Override
  public void clear() {

  }
}
