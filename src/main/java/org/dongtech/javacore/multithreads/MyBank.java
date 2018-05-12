package org.dongtech.javacore.multithreads;

/**
 * @author Fuqiang
 * Created on 2018/5/11.
 */
public class MyBank implements Bank {
  private final double[] accounts;

  public MyBank(int n, double initialBalance) {
    accounts = new double[n];
    for (int i = 0; i < accounts.length; i++) {
      accounts[i] = initialBalance;
    }
  }

  @Override
  public void transfer(int from, int to, double amount) {
    if (this.accounts[from] < amount) {
      return;
    }
    this.accounts[from] -= amount;
    this.accounts[to] += amount;
    System.out.printf("%s\t\t%.2f from %d to %d Total Balance: %10.2f%n", Thread.currentThread(), amount, from, to, this
        .getTotalBalance());

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
