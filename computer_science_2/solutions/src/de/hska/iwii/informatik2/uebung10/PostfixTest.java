package de.hska.iwii.informatik2.uebung10;

import junit.framework.TestCase;

public class PostfixTest extends TestCase {

  /**
   * Test if addition calculates correct.
   */
  public void testCalculateValueAddition() {
    assertEquals(6, Postfix.calculateValue("4 2 +").intValue());
  }

  /**
   * Test if subtraction calculates correct.
   */
  public void testCalculateValueSubtraction() {
    assertEquals(2, Postfix.calculateValue("4 2 -").intValue());
  }

  /**
   * Test if multiplication calculates correct.
   */
  public void testCalculateValueMultiplication() {
    assertEquals(8, Postfix.calculateValue("4 2 *").intValue());
  }

  /**
   * Test if the calculation from the worksheet is calculated correct.
   */
  public void testCalculateValueFromWorksheet() {
    assertEquals(34365, Postfix.calculateValue("15 42 18 + 61 24 - * 71 + *").intValue());
  }

  /**
   * Test if expression contains not allowed characters.
   */
  public void testCalculateValueInvalidCharacter() {
    try {
      Postfix.calculateValue("4 2 +.");
    } catch (IllegalArgumentException e) {
      assertEquals("Illegal character in argument, allowed are numbers and the operators +, -, *.",
          e.getMessage());
    }
  }

  /**
   * Test if expression contains too much operators.
   */
  public void testCalculateValueTooMuchOperator() {
    try {
      Postfix.calculateValue("4 2 + *");
    } catch (IllegalArgumentException e) {
      assertEquals("Stack contains not enough elements for arithmetic operation.", e.getMessage());
    }

  }

}
