package org.dongtech.javacore;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author Fuqiang
 * Created on 29/01/2018.
 */
public class Employee {
  private String name;
  private double salary;
  private Date hireDay;

  public Employee(String n, double s, int year, int month, int day) {
    name = n;
    salary = s;
    GregorianCalendar calendar = new GregorianCalendar(year, month - 1, day);
    hireDay = calendar.getTime();
  }

  public void raiseSalary(Double byPercent) {
    double raise = salary * byPercent / 100;
    salary += raise;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getSalary() {
    return salary;
  }

  public void setSalary(double salary) {
    this.salary = salary;
  }

  public Date getHireDay() {
    return hireDay;
  }

  public void setHireDay(Date hireDay) {
    this.hireDay = hireDay;
  }
}
