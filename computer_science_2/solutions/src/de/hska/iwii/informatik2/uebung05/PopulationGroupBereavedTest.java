package de.hska.iwii.informatik2.uebung05;

import junit.framework.TestCase;

public class PopulationGroupBereavedTest extends TestCase {

  /**
   * Test if tax is calculated as zero for different tax classes.
   */
  public void testGetTax() {
    PopulationGroupBereaved bereaved = new PopulationGroupBereaved(12000.00);
    assertEquals(0, bereaved.getTax());
    bereaved.setSalary(24000.00);
    assertEquals(0, bereaved.getTax());
    bereaved.setSalary(50000.00);
    assertEquals(0, bereaved.getTax());
    bereaved.setSalary(75000.00);
    assertEquals(0, bereaved.getTax());
    bereaved.setSalary(75001.00);
    assertEquals(0, bereaved.getTax());
  }

  /**
   * Test if social tax returns correct value.
   */
  public void testGetSocialTax() {
    PopulationGroupBereaved bereaved = new PopulationGroupBereaved(100.00);
    assertEquals(28, bereaved.getSocialTax());
  }

  /**
   * Test if constructor sets the salary and free tax amount correct.
   */
  public void testPopulationGroupBereaved() {
    PopulationGroupBereaved bereaved = new PopulationGroupBereaved(100.00);
    assertEquals(100.00, bereaved.getSalary());
    assertEquals(0.0, bereaved.getTaxFreeAmount());
  }

}
