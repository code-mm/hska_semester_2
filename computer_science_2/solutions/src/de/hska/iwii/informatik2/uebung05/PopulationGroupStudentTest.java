package de.hska.iwii.informatik2.uebung05;

import junit.framework.TestCase;

public class PopulationGroupStudentTest extends TestCase {

  /**
   * Test if tax is calculated correct for different tax classes.
   */
  public void testGetTax() {
    PopulationGroupStudent student = new PopulationGroupStudent(12000.00);
    assertEquals(1200, student.getTax());
    student.setSalary(24000.00);
    assertEquals(6000, student.getTax());
    student.setSalary(50000.00);
    assertEquals(15000, student.getTax());
    student.setSalary(75000.00);
    assertEquals(30000, student.getTax());
    student.setSalary(75001.00);
    assertEquals(37500, student.getTax());
  }

  /**
   * Test if tax free amount is respected.
   */
  public void testGetTaxLimit() {
    PopulationGroupStudent student = new PopulationGroupStudent(6000.00);
    assertEquals(0, student.getTax());
    student.setSalary(6001.00);
    assertEquals(600, student.getTax());
  }

  /**
   * Test if social tax returns zero.
   */
  public void testGetSocialTax() {
    PopulationGroupStudent student = new PopulationGroupStudent(100.00);
    assertEquals(0, student.getSocialTax());
  }

  /**
   * Test if constructor sets the salary and free tax amount correct.
   */
  public void testPopulationGroupStudent() {
    PopulationGroupStudent student = new PopulationGroupStudent(100.00);
    assertEquals(100.00, student.getSalary());
    assertEquals(6000.00, student.getTaxFreeAmount());
  }

}
