package org.dongtech.datastructures;

import org.dongtech.datastructures.list.SortArray;

/**
 * @author Fuqiang
 * Created on 23/02/2018.
 */
public class QuickSortTest extends BaseTest{
  public static void main(String[] args) {
    int length = 1000000;
    int index = 0;
    Integer[] a = new Integer[length];

    while (index < length) {
      a[index++] = (int) (Math.random() * length);
    }

    log("Quick Sort Start...");
    long start = System.currentTimeMillis();
    SortArray.quickSort(a, 0, length - 1);
    long end = System.currentTimeMillis();
    log("Quick Sort End.");
    log("Result: " + (SortArray.isSorted(a) ? "Success" : "Fail"));
    log("Duration: " + (end - start) + " ms");
  }
}
