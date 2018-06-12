package org.dongtech.javacore;

/**
 * @author Fuqiang
 * Created on 31/01/2018.
 */
public class Manager extends Employee  implements Comparable<Manager>{
  private double bonus;

  public Manager() {
  }

  public Manager(String n, double s, int year, int month, int day) {
    super(n, s, year, month, day);
    bonus = 0;
  }

  @Override
  public int compareTo(Manager o) {
    return 0;
  }

  @Override
  public double getSalary() {
    double baseSalary = super.getSalary();
    return baseSalary + bonus;
  }

  public double getBonus() {
    return bonus;
  }

  public void setBonus(double bonus) {
    this.bonus = bonus;
  }
}
