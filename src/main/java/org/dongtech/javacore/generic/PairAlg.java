package org.dongtech.javacore.generic;

/**
 * @author Fuqiang
 * Created on 31/01/2018.
 */
public class PairAlg {
  public static boolean hasNull(Pair<?> p) {
    return p.getFirst() == null || p.getSecond() == null;
  }

  public static void swap(Pair<?> p){
    swapHelper(p);
  }

  public static <T> void swapHelper(Pair<T> p){
    T t = p.getFirst();
    p.setFirst(p.getSecond());
    p.setSecond(t);
  }
}
