package org.dongtech.test.datastructures;

import org.dongtech.datastructures.list.SortArray;

import java.util.Arrays;

/**
 * @author Fuqiang
 * Created on 13/02/2018.
 */
public class ShellSortTest {
  public static void main(String... args) {
    String[] arr = {"9", "6", "2", "4", "8"};
    SortArray.shellSort(arr, arr.length);
    System.out.print(Arrays.toString(arr));
  }
}
