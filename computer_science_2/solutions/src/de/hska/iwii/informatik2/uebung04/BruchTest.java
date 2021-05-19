package de.hska.iwii.informatik2.uebung04;

import de.hska.iwii.informatik2.uebung01.Bruch;
import junit.framework.TestCase;

public class BruchTest extends TestCase {
  /**
   * Leerer konstruktor.
   */
  public void testKonstruktorLeer() {
    Bruch bruch = new Bruch();
    assertTrue(bruch.getZaehler() == 1 & bruch.getNenner() == 1);
  }

  /**
   * Konstruktor mit nenner = 0.
   */
  @SuppressWarnings("unused")
  public void testKonstruktorNennerNull() {
    try {
      Bruch bruch = new Bruch(1, 0);
      fail("Keine Fehlermeldung");
    } catch (IllegalArgumentException e) {
      assertEquals("Nenner darf nicht Null sein!", e.getMessage());
    }
  }

  /**
   * Konstruktor mit validen Werten.
   */
  public void testKonstruktorValide() {
    Bruch bruch = new Bruch(1, 2);

    assertEquals(1, bruch.getZaehler());
    assertEquals(2, bruch.getNenner());
  }
  
  /**
   * Konstruktor mit validen negativen Werten.
   */
  public void testKonstruktorValideNegativ() {
    Bruch bruch1 = new Bruch(-2, 4);
    assertEquals(-1, bruch1.getZaehler());
    assertEquals(2, bruch1.getNenner());
    
    Bruch bruch2 = new Bruch(2, -4);
    assertEquals(1, bruch2.getZaehler());
    assertEquals(-2, bruch2.getNenner());
  }

  /**
   * Test des Rückgabewertes von getZaehler().
   */
  public void testGetZaehler() {
    Bruch bruch = new Bruch(1, 2);
    assertEquals(1, bruch.getZaehler());
  }

  /**
   * Test des Rückgabewertes von getNenner().
   */
  public void testGetNenner() {
    Bruch bruch = new Bruch(1, 2);
    assertEquals(2, bruch.getNenner());
  }

  /**
   * Test auf korrekte Addition.
   */
  public void testAddition() {
    Bruch bruch1 = new Bruch(1, 2);
    Bruch bruch2 = new Bruch(1, 4);

    Bruch bruch3 = Bruch.addition(bruch1, bruch2);

    assertEquals(3, bruch3.getZaehler());
    assertEquals(4, bruch3.getNenner());
  }
  
  /**
   * Test auf korrekte Addition mit negativen Zahlen.
   */
  public void testAdditionNegativeZahlen() {
    Bruch bruch1 = new Bruch(-1, 2);
    Bruch bruch2 = new Bruch(1, 4);

    Bruch bruch3 = Bruch.addition(bruch1, bruch2);

    assertEquals(-1, bruch3.getZaehler());
    assertEquals(4, bruch3.getNenner());
  }

  /**
   * Test auf korrekte Subtraktion.
   */
  public void testSubtraktion() {
    Bruch bruch1 = new Bruch(1, 2);
    Bruch bruch2 = new Bruch(1, 4);

    Bruch bruch3 = Bruch.subtraktion(bruch1, bruch2);

    assertEquals(1, bruch3.getZaehler());
    assertEquals(4, bruch3.getNenner());
  }
  
  /**
   * Test auf korrekte Subtraktion mit negativen Zahlen.
   */
  public void testSubtraktionNegativeZahlen() {
    Bruch bruch1 = new Bruch(1, 2);
    Bruch bruch2 = new Bruch(-1, 4);

    Bruch bruch3 = Bruch.subtraktion(bruch1, bruch2);

    assertEquals(3, bruch3.getZaehler());
    assertEquals(4, bruch3.getNenner());
  }

  /**
   * Test auf korrekte Multiplikation.
   */
  public void testMultiplikation() {
    Bruch bruch1 = new Bruch(1, 2);
    Bruch bruch2 = new Bruch(1, 4);

    Bruch bruch3 = Bruch.multiplikation(bruch1, bruch2);

    assertEquals(1, bruch3.getZaehler());
    assertEquals(8, bruch3.getNenner());
  }
  
  /**
   * Test auf korrekte Multiplikation mit negativen Zahlen.
   */
  public void testMultiplikationNegativeZahlen() {
    Bruch bruch1 = new Bruch(1, -2);
    Bruch bruch2 = new Bruch(-1, 4);

    Bruch bruch3 = Bruch.multiplikation(bruch1, bruch2);

    assertEquals(-1, bruch3.getZaehler());
    assertEquals(-8, bruch3.getNenner());
  }

  /**
   * Test auf korrekte Division.
   */
  public void testDivision() {
    Bruch bruch1 = new Bruch(1, 2);
    Bruch bruch2 = new Bruch(1, 4);

    Bruch bruch3 = Bruch.division(bruch1, bruch2);

    assertEquals(2, bruch3.getZaehler());
    assertEquals(1, bruch3.getNenner());
  }
  
  /**
   * Test auf korrekte Division mit negativen Zahlen.
   */
  public void testDivisionNegativeZahlen() {
    Bruch bruch1 = new Bruch(-1, 2);
    Bruch bruch2 = new Bruch(1, -4);

    Bruch bruch3 = Bruch.division(bruch1, bruch2);

    assertEquals(2, bruch3.getZaehler());
    assertEquals(1, bruch3.getNenner());
  }
  
}
