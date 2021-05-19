package de.hska.iwii.informatik2.uebung06;

import java.util.Comparator;

public class StudentComparator implements Comparator<Student> {

  @Override
  public int compare(Student student1, Student student2) {
    return student1.compareTo(student2);
  }
  
}
