package de.hska.iwii.informatik2.uebung05;

import junit.framework.TestCase;

public class PopulationGroupOfficialTest extends TestCase {

  /**
   * Test if tax is calculated correct for different tax classes.
   */
  public void testGetTax() {
    PopulationGroupOfficial official = new PopulationGroupOfficial(12000.00);
    assertEquals(1200, official.getTax());
    official.setSalary(24000.00);
    assertEquals(6000, official.getTax());
    official.setSalary(50000.00);
    assertEquals(15000, official.getTax());
    official.setSalary(75000.00);
    assertEquals(30000, official.getTax());
    official.setSalary(75001.00);
    assertEquals(37500, official.getTax());
  }

  /**
   * Test if social tax returns zero.
   */
  public void testGetSocialTax() {
    PopulationGroupOfficial official = new PopulationGroupOfficial(100.00);
    assertEquals(0, official.getSocialTax());
  }

  /**
   * Test if constructor sets the salary and free tax amount correct.
   */
  public void testPopulationGroupOfficial() {
    PopulationGroupOfficial official = new PopulationGroupOfficial(100.00);
    assertEquals(100.00, official.getSalary());
    assertEquals(0.00, official.getTaxFreeAmount());
  }

}
