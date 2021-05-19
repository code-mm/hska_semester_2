package de.hska.iwii.informatik2.uebung06;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

  /**
   * for testing.
   */
  public static void main(String[] args) {
    ArrayList<Student> list = new ArrayList<Student>();
    list.add(new Student(1, "Hans", "Schneider"));
    list.add(new Student(2, "Albert", "Kiefer"));
    list.add(new Student(4, "Marvin", "Schmidt"));
    list.add(new Student(3, "Marvin", "Schmidt"));
    list.add(new Student(5, "Hans", "Mueller"));
    list.add(new Student(5, "Ernst", "Mueller"));

    Collections.sort(list);

    for (int i = 0; i < list.size(); i++) {
      System.out.println(list.get(i).getMatriculationNumber() + ", " + list.get(i).getLastname()
          + ", " + list.get(i).getFirstname());
    }
  }

}
