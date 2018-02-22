package org.dongtech.datastructures;

/**
 * @author Fuqiang
 * Created on 22/02/2018.
 */
public class NameComparator implements Comparator<Student> {
  public int compare(Student a1, Student a2) {
    return a1.getName().compareTo(a2.getName());
  }
}
