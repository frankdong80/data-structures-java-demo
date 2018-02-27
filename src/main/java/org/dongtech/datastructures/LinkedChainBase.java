package org.dongtech.datastructures;

import java.io.Serializable;

/**
 * @author Fuqiang
 * Created on 28/02/2018.
 */
public abstract class LinkedChainBase<T> implements Serializable {
  private Node firstNode;
  private int length;

  public LinkedChainBase() {
    clear();
  }

  public void clear() {

  }

  public int getLength() {
    return length;
  }

  public boolean isEmpty() {
    return false;
  }

  public boolean isFull() {
    return false;
  }

  public void display() {

  }

  protected final Node getNodeAt(int position) {
    return null;
  }

  protected final void addFirstNode(Node newNode) {
    assert newNode != null : "null argument in addFirstNode";
    newNode.setNext(firstNode);
    firstNode = newNode;
    length++;
  }

  protected final void addAfterNode(Node nodeBefore, Node newNode) {
    newNode.setNext(nodeBefore.getNext());
    nodeBefore.setNext(newNode);
  }

  protected final T removeFirstNode() {
    Node nodeToRemove = firstNode;
    firstNode = nodeToRemove.getNext();
    return nodeToRemove.getData();
  }

  protected final T removeAfterNode(Node nodeBefore) {
    Node currentNode = nodeBefore.getNext();
    if (null != currentNode) {
      nodeBefore.setNext(currentNode.getNext());
      return currentNode.getData();
    }
    return null;
  }

  protected final Node getFirstNode() {
    return firstNode;
  }

  protected class Node implements Serializable {
    private T data;
    private Node next;

    protected Node(T data) {
      this.data = data;
    }

    private Node(T dataPortion, Node nextNode) {
      data = dataPortion;
      next = nextNode;
    }

    protected T getData() {
      return data;
    }

    private void setData(T data) {
      this.data = data;
    }

    protected Node getNext() {
      return next;
    }

    private void setNext(Node next) {
      this.next = next;
    }
  }
}
