package de.hska.iwii.informatik2.uebung05;

import junit.framework.TestCase;

public class TaxTableListElementTest extends TestCase {

  /**
   * Test constructor for valid element.
   */
  @SuppressWarnings("unused")
  public void testTaxTableListElement() {
    TaxTableListElement element = new TaxTableListElement(1, 10, 0.10);
  }

  /**
   * Test constructor for invalid element.
   */
  @SuppressWarnings("unused")
  public void testTaxTableListElementInvalid() {
    try {
      TaxTableListElement element1 = new TaxTableListElement(10, 5, 0.10);
    } catch (IllegalArgumentException e) {
      assertEquals("Max value must be greater than min value.", e.getMessage());
    }

    try {
      TaxTableListElement element2 = new TaxTableListElement(1, 10, 1.01);
    } catch (IllegalArgumentException e) {
      assertEquals("Tax value must be lower or equal than 100% value.", e.getMessage());
    }
  }

  /**
   * Test return value of tax value.
   */
  public void testGetTaxPercentage() {
    TaxTableListElement element = new TaxTableListElement(1, 10, 0.10);
    assertEquals(0.10, element.getTaxPercentage());
  }

  /**
   * Test if salary is recognized for tax class.
   */
  public void testInSalaryClass() {
    TaxTableListElement element = new TaxTableListElement(1, 10, 0.10);
    assertTrue(element.inSalaryClass(5));
  }

}
