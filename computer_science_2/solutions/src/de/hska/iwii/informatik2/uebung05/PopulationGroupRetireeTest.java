package de.hska.iwii.informatik2.uebung05;

import junit.framework.TestCase;

public class PopulationGroupRetireeTest extends TestCase {

  /**
   * Test if tax is calculated as zero for different tax classes.
   */
  public void testGetTax() {
    PopulationGroupRetiree retiree = new PopulationGroupRetiree(12000.00);
    assertEquals(0, retiree.getTax());
    retiree.setSalary(24000.00);
    assertEquals(0, retiree.getTax());
    retiree.setSalary(50000.00);
    assertEquals(0, retiree.getTax());
    retiree.setSalary(75000.00);
    assertEquals(0, retiree.getTax());
    retiree.setSalary(75001.00);
    assertEquals(0, retiree.getTax());
  }

  /**
   * Test if social tax returns zero.
   */
  public void testGetSocialTax() {
    PopulationGroupRetiree retiree = new PopulationGroupRetiree(100.00);
    assertEquals(0, retiree.getSocialTax());
  }

  /**
   * Test if constructor sets the salary and free tax amount correct.
   */
  public void testPopulationGroupRetiree() {
    PopulationGroupRetiree retiree = new PopulationGroupRetiree(100.00);
    assertEquals(100.00, retiree.getSalary());
    assertEquals(0.00, retiree.getTaxFreeAmount());
  }

}
