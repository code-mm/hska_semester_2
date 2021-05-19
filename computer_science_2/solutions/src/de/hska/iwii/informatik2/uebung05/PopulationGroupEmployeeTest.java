package de.hska.iwii.informatik2.uebung05;

import junit.framework.TestCase;

public class PopulationGroupEmployeeTest extends TestCase {

  /**
   * Test if tax is calculated correct for different tax classes.
   */
  public void testGetTax() {
    PopulationGroupEmployee employee = new PopulationGroupEmployee(12000.00);
    assertEquals(0, employee.getTax());
    employee.setSalary(24000.00);
    assertEquals(6000, employee.getTax());
    employee.setSalary(50000.00);
    assertEquals(15000, employee.getTax());
    employee.setSalary(75000.00);
    assertEquals(30000, employee.getTax());
    employee.setSalary(75001.00);
    assertEquals(37500, employee.getTax());
  }

  /**
   * Test if tax free amount is respected.
   */
  public void testGetTaxLimit() {
    PopulationGroupEmployee employee = new PopulationGroupEmployee(12000.00);
    assertEquals(0, employee.getTax());
    employee.setSalary(12001.00);
    assertEquals(3000, employee.getTax());
  }

  /**
   * Test if social tax returns correct value.
   */
  public void testGetSocialTax() {
    PopulationGroupEmployee employee = new PopulationGroupEmployee(100.00);
    assertEquals(28, employee.getSocialTax());
  }

  /**
   * Test if constructor sets the salary and free tax amount correct.
   */
  public void testPopulationGroupEmployee() {
    PopulationGroupEmployee employee = new PopulationGroupEmployee(100.00);
    assertEquals(100.00, employee.getSalary());
    assertEquals(12000.00, employee.getTaxFreeAmount());
  }

}
