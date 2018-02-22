package org.dongtech.datastructures;

/**
 * @author Fuqiang
 * Created on 22/02/2018.
 */
public class ScoreComparator implements Comparator<Student> {
  public int compare(Student s1, Student s2) {
    return s1.getAvgScore().compareTo(s2.getAvgScore());
  }
}
