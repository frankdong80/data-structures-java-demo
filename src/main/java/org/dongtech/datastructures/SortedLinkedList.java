package org.dongtech.datastructures;

/**
 * @author Fuqiang
 * Created on 24/02/2018.
 */
public class SortedLinkedList<T extends Comparable<? super T>> extends LinkedChainBase<T> implements
    SortedListInterface<T> {

  @Override
  public boolean add(T newEntry) {
    Node newNode = new Node(newEntry);
    Node nodeBefore = getNodeBefore(newEntry);
    if (nodeBefore == null) {
      addFirstNode(newNode);
    } else {
      addAfterNode(nodeBefore, newNode);
    }
    return true;
 /*
    firstNode = add(newEntry, firstNode);
    length++;
    return true;
    */
/*
    Node newNode = new Node(newEntry);
    Node nodeBefore = getNodeBefore(newEntry);
    if (null == nodeBefore) {
      newNode.setNext(firstNode);
      firstNode = newNode;
    } else {
      Node nodeAfter = nodeBefore.getNext();
      newNode.setNext(nodeAfter);
      nodeBefore.setNext(newNode);
    }
    length++;
    return true;
*/
/*
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
*/
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

  private Node getNodeBefore(T entity) {
    Node current = getFirstNode();
    Node nodeBefore = null;
    while (current != null && entity.compareTo(current.getData()) > 0) {
      nodeBefore = current;
      current = current.getNext();
    }
    return nodeBefore;
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

/*
  private Node add(T newEntry, Node currentNode) {
    if (null == currentNode || newEntry.compareTo(currentNode.getData()) <= 0) {
      currentNode = new Node(newEntry, currentNode);
    } else {
      Node nodeAfter = add(newEntry, currentNode.getNext());
      currentNode.setNext(nodeAfter);
    }
    return currentNode;
  }
*/

  @Override
  public String toString() {
    Node current = getFirstNode();
    StringBuilder sb = new StringBuilder();
    while (null != current) {
      sb.append(current.toString()).append(",");
      current = current.getNext();
    }
    sb.deleteCharAt(sb.length() - 1);
    return "SortedLinkedList{" + sb.toString() + "}";
  }
}
