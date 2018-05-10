package org.dongtech.test.datastructures;

import org.dongtech.datastructures.list.SortArray;

import java.util.Arrays;

/**
 * @author Fuqiang
 * Created on 01/02/2018.
 */
public class SelectionSortTest {
  public static void main(String... args) {
    String[] arr = {"9", "6", "2", "4", "8"};
    SortArray.selectionSort2(arr, 5);
    System.out.print(Arrays.toString(arr));
  }
}
