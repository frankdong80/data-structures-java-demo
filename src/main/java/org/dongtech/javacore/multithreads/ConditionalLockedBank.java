package org.dongtech.javacore.multithreads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Fuqiang
 * Created on 2018/5/12.
 */
public class ConditionalLockedBank implements Bank {
  private final double[] accounts;
  private Lock bankLock = new ReentrantLock();
  private Condition sufficientFunds;

  public ConditionalLockedBank(int n, double initialBalance) {
    this.sufficientFunds = bankLock.newCondition();
    accounts = new double[n];
    for (int i = 0; i < accounts.length; i++) {
      accounts[i] = initialBalance;
    }
  }

  @Override
  public void transfer(int from, int to, double amount) throws InterruptedException {
    if (this.accounts[from] < amount) {
      return;
    }
    this.bankLock.lock();
    try {
      while (accounts[from] < amount) {
        this.sufficientFunds.await();
      }
      this.accounts[from] -= amount;
      this.accounts[to] += amount;
      System.out.printf("%s\t\t%.2f from %d to %d Total Balance: %10.2f%n", Thread.currentThread(), amount, from, to,
          this.getTotalBalance());
      sufficientFunds.signalAll();
    } finally {
      bankLock.unlock();
    }

  }

  @Override
  public double getTotalBalance() {
    double sum = 0;
    for (double a : this.accounts) {
      sum += a;
    }
    return sum;
  }

  @Override
  public int size() {
    return this.accounts.length;
  }

  @Override
  public double getBalance(int account) {
    return this.accounts[account];
  }
}
