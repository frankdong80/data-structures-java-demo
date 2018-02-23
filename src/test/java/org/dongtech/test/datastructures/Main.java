package org.dongtech.test.datastructures;

import org.dongtech.datastructures.ListInterface;

/**
 * @author Fuqiang
 * Created on 29/01/2018.
 */
public class Main {
  public static void main(String... args) {
    Thread t1 = new Thread(new Runnable() {
      public void run() {
        while (true) {
          System.out.println("t1 " + Math.random());
//          try {
//            Thread.sleep(500);
//          } catch (InterruptedException e) {
//            e.printStackTrace();
//          }
        }
      }
    });
    t1.run();
    Thread t2 = new Thread(new Runnable() {
      public void run() {
        while (true) {
          System.out.println("t2 " + Math.random());
//          try {
//            Thread.sleep(100);
//          } catch (InterruptedException e) {
//            e.printStackTrace();
//          }
        }
      }
    });

    t2.run();
  }

  public static <T> void displayList(ListInterface<T> list) {

  }
}
