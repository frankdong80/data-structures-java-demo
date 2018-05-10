package org.dongtech.test.datastructures;

import org.dongtech.datastructures.list.SortArray;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author Fuqiang
 * Created on 22/02/2018.
 */
public class SortArrayTest {
  @Test
  public void bubbleSort(){
    String[] arr = {"9", "6", "2", "4", "8"};
    SortArray.bubbleSort(arr, 5);
    System.out.print(Arrays.toString(arr));
  }
}
