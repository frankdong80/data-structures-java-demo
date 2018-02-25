package org.dongtech.datastructures;

/**
 * @author Fuqiang
 * Created on 24/02/2018.
 */
public class SortedLinkedList<T extends Comparable<? super T>> implements SortedListInterface<T> {
  private Node firstNode;
  private int length = 0;

  @Override
  public boolean add(T newEntry) {
    Node current = firstNode;
    Node preNode = null;
    while (null != current && current.getData().compareTo(newEntry) < 0) {
      preNode = current;
      current = current.getNext();
    }
    Node newNode = new Node(newEntry, current);
    if (null == preNode) {
      firstNode = newNode;
    } else {
      preNode.setNext(newNode);
    }
    length++;
    return true;
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

  @Override
  public String toString() {
    Node current = firstNode;
    StringBuilder sb = new StringBuilder();
    while (null != current) {
      sb.append(current.toString()).append(",");
      current = current.getNext();
    }
    sb.deleteCharAt(sb.length() - 1);
    return "SortedLinkedList{" + sb.toString() + "}";
  }

  private class Node {
    private T data;
    private Node next;

    Node(T data, Node next) {
      this.data = data;
      this.next = next;
    }

    T getData() {
      return data;
    }

    void setData(T data) {
      this.data = data;
    }

    Node getNext() {
      return next;
    }

    void setNext(Node next) {
      this.next = next;
    }

    @Override
    public String toString() {
      return data.toString();
    }
  }
}
