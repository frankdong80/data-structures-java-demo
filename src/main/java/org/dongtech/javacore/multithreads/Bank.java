package org.dongtech.javacore.multithreads;

/**
 * @author Fuqiang
 * Created on 2018/5/11.
 */
public interface Bank {
  void transfer(int from,int to,double amount) throws InterruptedException;

  double getTotalBalance();

  int size();

  double getBalance(int account);
}
