package org.dongtech.datastructures;

/**
 * @author Fuqiang
 * Created on 29/01/2018.
 */
public class SortArray {
  /**
   * 定义一个泛型方法，该方法要求泛型的实例是一个实现了Comparable接口的类型
   * Comparable<? super T> 表示，这个实例可以不直接实现Comparable接口，而是通过其父类实现Comparable接口
   *
   * @param a
   * @param n
   * @param <T>
   */
  public static <T extends Comparable<? super T>> void sort(T[] a, int n) {

  }


  /**
   * 冒泡排序
   *
   * @param a
   * @param n
   * @param <T>
   */
  public static <T extends Comparable<? super T>> void bubbleSort(T[] a, int n) {
//    for (int i = n; i >= 0; i--) {
//      for (int j = 1; j < i; j++) {
//        if (a[j - 1].compareTo(a[j]) > 0) {
//          swap(a, j - 1, j);
//        }
//      }
//    }
    bubbleSort(a, 0, n - 1);
  }

  public static <T extends Comparable<? super T>> void bubbleSort(T[] a, int first, int last) {
    if (first < last) {
      int index = bubble(a, first, last);
      bubbleSort(a, first, index);
    }
  }

  /**
   *
   * @param a
   * @param first
   * @param last
   * @param <T>
   * @return 返回最后一次交换中，左边元素的索引
   */
  private static <T extends Comparable<? super T>> int bubble(T[] a, int first, int last) {
    int index = first;
    for (int i = first; i < last; i++) {
      if (a[i].compareTo(a[i + 1]) > 0) {
        swap(a, i, i + 1);
        index = i;
      }
    }
    return index;
  }

  private static void swap(Object[] a, int i, int j) {
    if (i != j) {
      Object tmp = a[i];
      a[i] = a[j];
      a[j] = tmp;
    }
  }

  public static <T extends Comparable<? super T>> void shellSort(T[] a, int n) {
    shellSort(a, 0, n - 1);
  }

  public static <T extends Comparable<? super T>> void shellSort(T[] a, int first, int last) {
    if (first < last) {
      int n = last - first + 1;
      for (int space = n / 2; space > 0; space = space / 2) {
        int tmp = space % 2 == 0 ? space + 1 : space;
        for (int begin = first; begin < first + tmp; begin++) {
          incrementalInsertionSort(a, begin, last, tmp);
        }
      }
    }
  }

  private static <T extends Comparable<? super T>> void incrementalInsertionSort(T[] a, int first, int last, int
      space) {
    int unsorted, index;
    for (unsorted = first + space; unsorted <= last; unsorted = unsorted + space) {
      T firstUnsorted = a[unsorted];
      for (index = unsorted - space; (index >= first) && (firstUnsorted.compareTo(a[index]) < 0); index = index -
          space) {
        a[index + space] = a[index];
      }
      a[index + space] = firstUnsorted;
    }

  }

  /**
   * insertion sort
   *
   * @param a
   * @param n
   * @param <T>
   */
  public static <T extends Comparable<? super T>> void insertionSort(T[] a, int n) {
    insertionSort(a, 0, n - 1);
  }

  private static <T extends Comparable<? super T>> void insertionSort(T[] a, int first, int last) {
//    for (int i = first + 1; i <= last; i++) {
//      T firstUnsorted = a[i];
//      insertInOrder(firstUnsorted, a, first, i);
//    }
    if (first < last) {
//      T firstUnsorted = a[first + 1];
//      insertInOrder(firstUnsorted, a, 0, first);
//      insertionSort(a,first+1,last);
      insertionSort(a, first, last - 1);
      insertInOrder(a[last], a, first, last - 1);
    }
  }

  private static <T extends Comparable<? super T>> void insertInOrder(T element, T[] a, int first, int last) {
//    for (int i = last; i >= first; i--) {
//      if (element.compareTo(a[i]) < 0) {
//        a[i + 1] = a[i];
//      } else {
//        a[i + 1] = element;
//        break;
//      }
//    }

//    int index = last;
//    while (index >= first && element.compareTo(a[index]) < 0) {
//      a[index + 1] = a[index];
//      index--;
//    }
//    a[index + 1] = element;
    if (element.compareTo(a[last]) >= 0) {
      a[last + 1] = element;
    } else {
      a[last + 1] = a[last];
      if (first < last) {
        insertInOrder(element, a, first, last - 1);
      } else {
        a[last] = element;
      }
    }
  }

  /**
   * 优化的选择排序，每次选择中，选出最大值与最小值，分别与数组的首尾元素交换位置
   *
   * @param a
   * @param n
   * @param <T>
   */
  public static <T extends Comparable<? super T>> void selectionSort2(T[] a, int n) {
    selectionSort2(a, 0, n - 1);
  }

  private static <T extends Comparable<? super T>> void selectionSort2(T[] a, int first, int last) {
    if (last > first) {
      int min = first;
      int max = first;
      for (int i = first + 1; i < last; i++) {
        if (a[i].compareTo(a[min]) < 0) {
          min = i;
        } else if (a[i].compareTo(a[max]) > 0) {
          max = i;
        }
      }
      swap(a, first, min);
      if (first == max) {
        max = min;
      }
      swap(a, last, max);
      selectionSort2(a, first + 1, last - 1);
    }
  }

  /**
   * selection sort
   *
   * @param a
   * @param n
   * @param <T>
   */
  public static <T extends Comparable<? super T>> void selectionSort(T[] a, int n) {
//    for (int index = 0; index < n - 1; index++) {
//      int indexOfNextSmallest = getIndexOfSmallest(a, index, n - 1);
//      swap(a, index, indexOfNextSmallest);
//    }
    selectionSort(a, 0, n - 1);
  }

  private static <T extends Comparable<? super T>> void selectionSort(T[] a, int first, int last) {
    if (first < last) {
      int indexOfNextSmallest = getIndexOfSmallest(a, first, last);
      swap(a, first, indexOfNextSmallest);
      selectionSort(a, ++first, last);
    }
  }

  private static <T extends Comparable<? super T>> int getIndexOfSmallest(T[] a, int first, int last) {
    T min = a[first];
    int indexOfMin = first;
    for (int index = first + 1; index <= last; index++) {
      if (min.compareTo(a[index]) > 0) {
        min = a[index];
        indexOfMin = index;
      }
    }
    return indexOfMin;
  }
}
