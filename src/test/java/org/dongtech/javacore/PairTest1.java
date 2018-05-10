package org.dongtech.javacore;

import org.dongtech.javacore.generic.ArrayAlg;
import org.dongtech.javacore.generic.Pair;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * @author Fuqiang
 * Created on 29/01/2018.
 */
public class PairTest1 {
  public static void main(String[] args) {
    Class clazz = Integer.class;

    String[] words = {"Mary", "had", "a", "little", "lamb"};
    Pair<String> mm = ArrayAlg.minmax(words);
    System.out.println("min=" + mm.getFirst());
    System.out.print("max=" + mm.getSecond());

    String[] names = {"John", "Q.", "Public"};
    String middle = ArrayAlg.getMiddle(names);
    assert middle.equals("Q.");

    GregorianCalendar[] birthdays = {
        new GregorianCalendar(1906, Calendar.DECEMBER, 9),
        new GregorianCalendar(1815, Calendar.DECEMBER, 10),
        new GregorianCalendar(1903, Calendar.DECEMBER, 3),
        new GregorianCalendar(1910, Calendar.JUNE, 22)
    };

    Pair<GregorianCalendar> mm1 = ArrayAlg.minmax(birthdays);
    System.out.println("min=" + mm1.getFirst());
    System.out.print("max=" + mm1.getSecond());
  }
}


