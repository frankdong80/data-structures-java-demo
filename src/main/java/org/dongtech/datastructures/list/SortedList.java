package org.dongtech.datastructures.list;

/**
 * @author Fuqiang
 * Created on 24/02/2018.
 */
public class SortedList<T extends Comparable<? super T>> extends LList<T> implements SortedListInterface<T> {

  @Override
  public boolean add(T newEntry) {
    int newPosition = Math.abs(getPosition(newEntry));
    return super.add(newPosition, newEntry);
  }

  @Override
  public boolean remove(T anEntry) {
    boolean result = false;
    int position = getPosition(anEntry);
    if (position > 0) {
      super.remove(position);
      result = true;
    }
    return result;
  }

  @Override
  public int getPosition(T anEntry) {
    int position = 1;
    int length = super.getLength();
    while (position <= length && anEntry.compareTo(super.getEntry(position)) > 0) {
      position++;
    }
    if (position > length || super.getEntry(position).compareTo(anEntry) != 0) {
      position = -position;
    }
    return position;
  }

  @Override
  public T getEntry(int givenPosition) {
    return super.getEntry(givenPosition);
  }

  @Override
  public boolean contains(T anEntry) {
    int position = getPosition(anEntry);
    return position >= 0;
  }

  @Override
  public T remove(int givenPosition) {
    return null;
  }

  @Override
  public void clear() {
    super.clear();
  }

  @Override
  public int getLength() {
    return super.getLength();
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
