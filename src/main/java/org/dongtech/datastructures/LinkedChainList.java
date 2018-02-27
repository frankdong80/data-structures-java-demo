package org.dongtech.datastructures;

/**
 * @author Fuqiang
 * Created on 11/02/2018.
 */
public class LinkedChainList<T extends Comparable<? super T>> implements ListInterface<T> {
  int length;
  private Node firstNode;

  public void insertionSort() {
    if (length > 1) {
      assert firstNode != null;
      Node unsortedPart = firstNode.getNextNode();
      assert unsortedPart != null;
      firstNode.setNextNode(null);

      while (unsortedPart != null) {
        Node nodeToInsert = unsortedPart;
        unsortedPart = unsortedPart.getNextNode();
        insertInOrder(nodeToInsert);
      }
    }
  }

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

  private void insertInOrder(Node nodeToInsert) {
    T item = nodeToInsert.getData();
    Node currentNode = firstNode;
    Node previousNode = null;

    while (currentNode != null && item.compareTo(currentNode.getData()) > 0) {
      previousNode = currentNode;
      currentNode = currentNode.getNextNode();
    }
    nodeToInsert.setNextNode(currentNode);
    if (previousNode != null) {
      previousNode.setNextNode(nodeToInsert);
    } else {
      firstNode = nodeToInsert;
    }

  }

  private class Node {
    private T data;
    private Node nextNode;

    public Node getNextNode() {
      return nextNode;
    }

    public void setNextNode(Node nextNode) {
      this.nextNode = nextNode;
    }

    public T getData() {
      return data;
    }

    public void setData(T data) {
      this.data = data;
    }
  }
}
