package org.dongtech.datastructures;

import org.dongtech.datastructures.*;
import org.dongtech.datastructures.list.SortArray;

import java.util.Arrays;


/**
 * @author Fuqiang
 * Created on 22/02/2018.
 */
public class SortByComparatorTest {
  public static void main(String[] args) {
    int i = 5;
    Student[] students = new Student[i];
    for (int j = 0; j < i; j++) {
      Student s = new Student("s" + j, (int) (Math.random() * 10), "00" + (int) (Math.random() * 100), Math.random
          () * 100);
      students[j] = s;
    }

    SortArray.sort(students, new NameComparator());
    System.out.println(Arrays.toString(students));
    SortArray.sort(students, new GradeComparator());
    System.out.println(Arrays.toString(students));
    SortArray.sort(students, new CodeComparator());
    System.out.println(Arrays.toString(students));
    SortArray.sort(students, new ScoreComparator());
    System.out.println(Arrays.toString(students));
  }
}
