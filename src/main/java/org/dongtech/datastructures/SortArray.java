package org.dongtech.datastructures;

/**
 * @author Fuqiang
 * Created on 29/01/2018.
 */
public class SortArray {
  public static void main(String[] args){
    Gadget[] gadgets = new Gadget[10];
    SortArray.sort(gadgets,10);
  }
  /**
   * 定义一个泛型方法，该方法要求泛型的实例是一个实现了Comparable接口的类型
   * Comparable<? super T> 表示，这个实例可以不直接实现Comparable接口，而是通过其父类实现Comparable接口
   * @param a
   * @param n
   * @param <T>
   */
  public static <T extends Comparable<? super T>> void sort(T[] a, int n) {

  }
}
