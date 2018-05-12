package org.dongtech.javacore.multithreads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

interface Bank {
  void transfer(int from, int to, double amount) throws InterruptedException;

  double getTotalBalance();

  int size();

  double getBalance(int account);
}

/**
 * @author Fuqiang
 * Created on 2018/5/12.
 */
public class TransferRunnableTest {
  public static void main(String[] args) {
    int nAccounts = 100;
    double initialBalance = 1000;
//    Bank bank = new MyBank(nAccounts, initialBalance);
    Bank bank = new SynchronizedBank(nAccounts, initialBalance);
    int i;
    for (i = 0; i < nAccounts; i++) {
      Runnable r = new TransferRunnable(bank, i, 2 * initialBalance);
      Thread t = new Thread(r);
      t.start();
    }
  }
}

class TransferRunnable implements Runnable {
  private Bank bank;
  private int fromAccount;
  private double maxAmount;
  private int DELAY = 10;

  TransferRunnable(Bank bank, int fromAccount, double maxAmount) {
    this.bank = bank;
    this.fromAccount = fromAccount;
    this.maxAmount = maxAmount;
  }

  @Override
  public void run() {
    try {
      while (true) {
        int toAccount = (int) (bank.size() * Math.random());
        double amount = maxAmount * Math.random();
        bank.transfer(fromAccount, toAccount, amount);
        Thread.sleep((int) (this.DELAY * Math.random()));
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}

class SynchronizedBank implements Bank {
  private final double[] accounts;

  public SynchronizedBank(int n, double initialBalance) {
    accounts = new double[n];
    for (int i = 0; i < accounts.length; i++) {
      accounts[i] = initialBalance;
    }
  }

  @Override
  public synchronized void transfer(int from, int to, double amount) throws InterruptedException {
    if (this.accounts[from] < amount) {
      return;
    }
    while (accounts[from] < amount) {
      wait();
    }
    this.accounts[from] -= amount;
    this.accounts[to] += amount;
    System.out.printf("%s\t\t%.2f from %d to %d Total Balance: %10.2f%n", Thread.currentThread(), amount, from, to,
        this.getTotalBalance());
    notifyAll();
  }

  @Override
  public synchronized double getTotalBalance() {
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

class ConditionalLockedBank implements Bank {
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
    bankLock.lock();
    try {
      double sum = 0;
      for (double a : this.accounts) {
        sum += a;
      }
      return sum;
    } finally {
      bankLock.unlock();
    }
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

class LockedBank implements Bank {
  private final double[] accounts;
  private Lock bankLock = new ReentrantLock();

  public LockedBank(int n, double initialBalance) {
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
    this.bankLock.lock();
    try {
      this.accounts[from] -= amount;
      this.accounts[to] += amount;
      System.out.printf("%s\t\t%.2f from %d to %d Total Balance: %10.2f%n", Thread.currentThread(), amount, from, to,
          this.getTotalBalance());
    } finally {
      bankLock.unlock();
    }

  }

  @Override
  public double getTotalBalance() {
    bankLock.lock();
    try {
      double sum = 0;
      for (double a : this.accounts) {
        sum += a;
      }
      return sum;
    } finally {
      bankLock.unlock();
    }
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

class MyBank implements Bank {
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