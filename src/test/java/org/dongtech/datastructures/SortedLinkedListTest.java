package org.dongtech.datastructures;

import org.dongtech.datastructures.list.SortedLinkedList;
import org.dongtech.datastructures.list.SortedListInterface;

/**
 * @author Fuqiang
 * Created on 24/02/2018.
 */
public class SortedLinkedListTest extends BaseTest {
  public static void main(String[] args) {
    SortedListInterface<String> strings = new SortedLinkedList<>();
    strings.add("Jamie");
    strings.add("Brenda");
    strings.add("Sarah");
    strings.add("Tom");
    strings.add("Carlos");
    log(strings.toString());
  }

}
