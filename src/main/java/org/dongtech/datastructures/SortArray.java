package org.dongtech.datastructures;


/**
 * @author Fuqiang
 * Created on 29/01/2018.
 */
public class SortArray {
  private static int MIN_SIZE = 4;

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
   * 快速排序递归实现
   *
   * @param a
   * @param first
   * @param last
   * @param <T>
   */
  public static <T extends Comparable<? super T>> void quickSort(T[] a, int first, int last) {
    if (last - first + 1 < MIN_SIZE) {
      insertionSort(a, first, last);
    } else {
      int pivotIndex = partition(a, first, last);
      quickSort(a, first, pivotIndex - 1);
      quickSort(a, pivotIndex, last);
    }
  }

  /**
   * 将数组划分为由支点分隔的两个子数组，左边数组的所有元素小于等于支点，右边数组的所有元素大于等于支点
   *
   * @param a
   * @param first
   * @param last
   * @param <T>
   * @return
   */
  private static <T extends Comparable<? super T>> int partition(T[] a, int first, int last) {
    int mid = (first + last) / 2;
    sortFirstMiddleLast(a, first, mid, last);
    swap(a, mid, last - 1);
    int pivotIndex = last - 1;
    T pivot = a[pivotIndex];
    int indexFromLeft = first + 1;
    int indexFromRight = last - 2;
    boolean done = false;
    while (!done) {
      while (a[indexFromLeft].compareTo(pivot) < 0) {
        indexFromLeft++;
      }
      while (a[indexFromRight].compareTo(pivot) > 0) {
        indexFromRight--;
      }
      assert a[indexFromLeft].compareTo(pivot) >= 0 && a[indexFromRight].compareTo(pivot) <= 0;

      if (indexFromLeft < indexFromRight) {
        swap(a, indexFromLeft, indexFromRight);
        indexFromLeft++;
        indexFromRight--;
      } else {
        done = true;
      }
    }
    swap(a, pivotIndex, indexFromLeft);
    pivotIndex = indexFromLeft;
    return pivotIndex;
  }

  /**
   * 三点取中值支点选择法
   *
   * @param a
   * @param first
   * @param middle
   * @param last
   * @param <T>
   */
  private static <T extends Comparable<? super T>> void sortFirstMiddleLast(T[] a, int first, int middle, int last) {
    order(a, first, middle);
    order(a, middle, last);
    order(a, first, middle);
  }

  private static <T extends Comparable<? super T>> void order(T[] a, int i, int j) {
    if (a[i].compareTo(a[j]) > 0) {
      swap(a, i, j);
    }
  }

  /**
   * 归并排序递归实现，效率O(n logn)
   *
   * @param a
   * @param first
   * @param last
   * @param <T>
   */
  public static <T extends Comparable<? super T>> void mergeSort(T[] a, int first, int last) {
    T[] tempArray = (T[]) new Comparable[a.length];
    mergeSort(a, tempArray, first, last);
  }

  private static <T extends Comparable<? super T>> void mergeSort(T[] a, T[] tempArray, int first, int last) {
    if (first < last) {
      int mid = (first + last) / 2;
      mergeSort(a, tempArray, first, mid);
      mergeSort(a, tempArray, mid + 1, last);
      merge(a, tempArray, first, mid, last);
    }
  }

  private static <T extends Comparable<? super T>> void merge(T[] a, T[] tempArray, int first, int mid, int last) {
    if (a[mid].compareTo(a[mid + 1]) <= 0) {
      //如果左边有序数组的最大值小于等于右边有序数组的最小值,则不执行归并.
      return;
    }
    int beginHalf1 = first;
    int beginHalf2 = mid + 1;
    int index = 0;
    while (beginHalf1 <= mid && beginHalf2 <= last) {
      if (a[beginHalf1].compareTo(a[beginHalf2]) < 0) {
        tempArray[index++] = a[beginHalf1++];
      } else {
        tempArray[index++] = a[beginHalf2++];
      }
    }
    while (beginHalf1 <= mid) {
      tempArray[index++] = a[beginHalf1++];
    }
    while (beginHalf2 <= last) {
      tempArray[index++] = a[beginHalf2++];
    }
    index = 0;
    while (first <= last) {
      a[first++] = tempArray[index++];
    }

  }

  /**
   * 一个可以自定定义比较器的冒泡排序法
   *
   * @param a
   * @param comparator
   * @param <T>
   */
  public static <T> void sort(T[] a, Comparator<T> comparator) {
    for (int i = a.length; i >= 0; i--) {
      for (int j = 1; j < i; j++) {
        if (comparator.compare(a[j - 1], a[j]) > 0) {
          swap(a, j - 1, j);
        }
      }
    }
  }

  private static void swap(Object[] a, int i, int j) {
    if (i != j) {
      Object tmp = a[i];
      a[i] = a[j];
      a[j] = tmp;
    }
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

  /**
   * 希尔排序
   * @param a
   * @param n
   * @param <T>
   */
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

  /**
   * 检测给定的数组是否有序，左小右大
   *
   * @param a
   * @param <T>
   * @return
   */
  public static <T extends Comparable<? super T>> boolean isSorted(T[] a) {
    for (int i = 1; i < a.length; i++) {
      if (a[i - 1].compareTo(a[i]) > 0) {
        return false;
      }
    }
    return true;
  }

  /**
   * 基数排序,效率O(n)
   *
   * @param a
   * @param first
   * @param last
   * @param maxDigits
   */
  public static void radixSort(int[] a, int first, int last, int maxDigits) {
    int length = last - first + 1;
    int[][] buckets = new int[10][length];
    int[] bucketIndex = new int[10];
    int digit = 0;//当前位
    while (digit < maxDigits) {
      int index = first;
      while (index <= last) {
        int element = a[index];
        int digitValue = (element / (int) Math.pow(10, digit)) % 10;
        buckets[digitValue][bucketIndex[digitValue]] = element;
        bucketIndex[digitValue]++;
        index++;
      }
      index = first;
      for (int i = 0; i < 10; i++) {
        for (int j = 0; j < bucketIndex[i]; j++) {
          a[index] = buckets[i][j];
          index++;
        }
      }
      buckets = new int[10][length];//清空
      bucketIndex=new int[10];//清空
      digit++;
    }
  }
}
