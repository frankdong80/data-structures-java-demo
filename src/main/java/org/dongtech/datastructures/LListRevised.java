package org.dongtech.datastructures;

import java.io.Serializable;

/**
 * @author Fuqiang
 * Created on 27/02/2018.
 */
public class LListRevised<T> extends LinkedChainBase<T> implements ListInterface<T>, Serializable {
  private Node firstNode;
  private int length = 0;

  public LListRevised() {
    clear();
  }

  @Override
  public boolean add(int position, T newEntry) {
    return false;
  }

  @Override
  public T remove(int position) {
    T result = null;
    if (position >= 1 && position <= getLength()) {
      assert !isEmpty();
      if (position == 1) {
        result = removeFirstNode();
      } else {
        Node nodeBefore = getNodeAt(position - 1);
        result = removeAfterNode(nodeBefore);
      }
    }
    return result;
  }

  @Override
  public T getEntry(int position) {
    return null;
  }

  @Override
  public void clear() {
    firstNode = null;
    length = 0;
  }

  @Override
  public int getLength() {
    return length;
  }

  @Override
  public boolean isEmpty() {
    return false;
  }


}
