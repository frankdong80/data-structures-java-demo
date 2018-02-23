package org.dongtech.test.datastructures;

import org.dongtech.datastructures.SortArray;

/**
 * @author Fuqiang
 * Created on 23/02/2018.
 */
public class MergeSortTest {
  public static void main(String[] args) {
    int length = 1000000;
    int index = 0;
    Integer[] a = new Integer[length];

    while (index < length) {
      a[index++] = (int) (Math.random() * length);
    }
    long start = System.currentTimeMillis();
    SortArray.mergeSort(a, 0, length - 1);
    long end = System.currentTimeMillis();
    System.out.println("isSorted? " + SortArray.isSorted(a));
    System.out.println("duration: " + (end - start) + " ms");

  }
}
