package de.hska.iwii.informatik2.uebung06;

public class Student implements Comparable<Student> {

  private int matriculationNumber;
  private String firstname;
  private String lastname;

  /**
   * Constructs a student.
   * 
   * @param matriculationNumber
   *          Matriculation number of the student
   * @param firstName
   *          Firstname of the student
   * @param lastName
   *          Lastname of the student
   */
  public Student(int matriculationNumber, String firstName, String lastName) {
    setMatriculationNumber(matriculationNumber);
    setFirstname(firstName);
    setLastname(lastName);
  }

  /**
   * Set the matriculation number of the student.
   * 
   * @param matriculationNumber
   *          Matriculation number
   */
  public void setMatriculationNumber(int matriculationNumber) {
    this.matriculationNumber = matriculationNumber;
  }

  /**
   * Returns the matriculation number of the student.
   * 
   * @return Matriculation number
   */
  public int getMatriculationNumber() {
    return this.matriculationNumber;
  }

  /**
   * Set the firstname of the student.
   * 
   * @param firstname
   *          Firstname
   */
  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  /**
   * Returns the firstname of the student.
   * 
   * @return Firstname
   */
  public String getFirstname() {
    return this.firstname;
  }

  /**
   * Set the lastname of the student.
   * 
   * @param lastname
   *          Lastname
   */
  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  /**
   * Returns the lastname of the student.
   * 
   * @return Lastname
   */
  public String getLastname() {
    return this.lastname;
  }

  /**
   * Compare two students.
   */
  @Override
  public int compareTo(Student student) {
    if (this.lastname.compareTo(student.getLastname()) != 0) {
      return this.lastname.compareTo(student.getLastname());
    } else if (this.firstname.compareTo(student.getFirstname()) != 0) {
      return this.firstname.compareTo(student.getFirstname());
    } else if (((Integer) this.matriculationNumber)
        .compareTo((Integer) student.getMatriculationNumber()) != 0) {
      return ((Integer) this.matriculationNumber)
          .compareTo((Integer) student.getMatriculationNumber());
    } else {
      throw new IllegalArgumentException("Two students are identical.");
    }
  }

}
