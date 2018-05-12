package org.dongtech.javacore.multithreads;

/**
 * @author Fuqiang
 * Created on 2018/5/12.
 */
public class TransferRunnable implements Runnable {
  private Bank bank;
  private int fromAccount;
  private double maxAmount;
  private int DELAY = 10;

  public static void main(String[] args) {
    int nAccounts = 100;
    double initialBalance = 1000;
//    Bank bank = new MyBank(nAccounts, initialBalance);
    Bank bank = new LockedBank(nAccounts, initialBalance);
    int i;
    for (i = 0; i < nAccounts; i++) {
      Runnable r = new TransferRunnable(bank, i, initialBalance);
      Thread t = new Thread(r);
      t.start();
    }
  }

  public TransferRunnable(Bank bank, int fromAccount, double maxAmount) {
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
