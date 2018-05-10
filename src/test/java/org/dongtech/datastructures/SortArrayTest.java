package org.dongtech.datastructures;

import org.dongtech.datastructures.list.SortArray;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Fuqiang
 * Created on 22/02/2018.
 */
class SortArrayTest {
  private String[] arr;

  @BeforeEach
  void setUp() {
    this.arr = new String[]{"9", "6", "2", "4", "8"};
  }

  @Test
  void sort() {
  }

  @Test
  void quickSort() {
  }

  @Test
  void mergeSort() {
  }

  @Test
  void sort1() {
  }

  @Test
  void shellSort() {
  }

  @Test
  void shellSort1() {
  }

  @Test
  void insertionSort() {
  }

  @Test
  void selectionSort2() {
  }

  @Test
  void selectionSort() {
  }

  @Test
  void isSorted() {
  }

  @Test
  void radixSort() {
  }

  @Test
  void bubbleSort() {
    SortArray.bubbleSort(this.arr, 5);
  }

  @Test
  void bubbleSort1() {
    SortArray.bubbleSort(this.arr, 0, 4);
  }
}
