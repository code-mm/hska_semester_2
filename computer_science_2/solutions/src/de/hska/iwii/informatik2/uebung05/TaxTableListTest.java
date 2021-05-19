package de.hska.iwii.informatik2.uebung05;

import junit.framework.TestCase;

public class TaxTableListTest extends TestCase {

  /**
   * Tests if constructor creates tax class and returns zero if no class matches.
   */
  public void testTaxTableList() {
    TaxTableList list = new TaxTableList(new TaxTableListElement(0, 10, 0.1));
    assertEquals(0.5, list.getTaxRate(5));
    assertEquals(0.0, list.getTaxRate(15));
  }

  /**
   * Tests if tax class value correctly returned.
   */
  public void testGetTaxRate() {
    TaxTableList list = new TaxTableList(new TaxTableListElement(0, 10, 0.1));
    assertEquals(0.5, list.getTaxRate(5));
    assertEquals(0.0, list.getTaxRate(15));
  }

}
