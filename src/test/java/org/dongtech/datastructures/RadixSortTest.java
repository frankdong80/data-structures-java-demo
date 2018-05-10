package org.dongtech.datastructures;

import org.dongtech.datastructures.list.SortArray;

import java.util.Arrays;

/**
 * @author Fuqiang
 * Created on 24/02/2018.
 */
public class RadixSortTest extends BaseTest {
  public static void main(String[] args) {
    int length = 1000000;
    int index = 0;
    int[] a = new int[length];

    while (index < length) {
      a[index++] = (int) (Math.random() * 1000);
    }

    log("Radix Sort Start...");
    long start = System.currentTimeMillis();
    SortArray.radixSort(a, 0, length - 1, 3);
    long end = System.currentTimeMillis();
    log("Radix Sort End.");
//    log("Result: " + (SortArray.isSorted(a) ? "Success" : "Fail"));
    log("Result: " + Arrays.toString(a));
    log("Duration: " + (end - start) + " ms");
  }
}
