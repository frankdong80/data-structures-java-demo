package org.dongtech.javacore.generic;

import org.dongtech.javacore.Boss;
import org.dongtech.javacore.Employee;
import org.dongtech.javacore.Manager;

/**
 * @author Fuqiang
 * Created on 2018/6/12.
 */
public class Pair5 {

  public void printBuddies(Pair<? extends Manager> pair) {
    Pair<Employee> employeePair = new Pair<>();
//    printBuddies(employeePair); //error

    Pair<Manager> managerPair = new Pair<>();
    printBuddies(managerPair);

    Pair<Boss> bossPair = new Pair<>();
    printBuddies(bossPair);
  }

  public void printBuddies2(Pair<? super Manager> pair) {

    Pair<Employee> employeePair = new Pair<>();
    printBuddies2(employeePair);

    Pair<Manager> managerPair = new Pair<>();
    printBuddies2(managerPair);

    Pair<Boss> bossPair = new Pair<>();
//    printBuddies2(bossPair); //error
  }

  public void printBuddies3(Pair<?> pair) {
    Pair<Employee> employeePair = new Pair<>();
    printBuddies3(employeePair);

    Pair<Manager> managerPair = new Pair<>();
    printBuddies3(managerPair);

    Pair<Boss> bossPair = new Pair<>();
    printBuddies3(bossPair);
  }

}
