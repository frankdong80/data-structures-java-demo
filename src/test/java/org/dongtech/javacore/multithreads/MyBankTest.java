package org.dongtech.javacore.multithreads;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Fuqiang
 * Created on 2018/5/11.
 */
class MyBankTest {
  private Bank bank;

  @BeforeEach
  void setUp() {
    this.bank = new MyBank(10, 150);
  }

  @Test
  void transfer() {
    this.bank.transfer(0, 1, 100);
    assertEquals(50, this.bank.getBalance(0));
  }

  @Test
  void getTotalBalance() {
    this.bank.getTotalBalance();
  }

  @Test
  void size() {
    int size = this.bank.size();
    assertEquals(10, size);
  }
}
