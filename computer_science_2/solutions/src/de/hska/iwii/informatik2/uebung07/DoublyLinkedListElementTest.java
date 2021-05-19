package de.hska.iwii.informatik2.uebung07;

import junit.framework.TestCase;

public class DoublyLinkedListElementTest extends TestCase {

  /**
   * Checks creation of element with only the value.
   */
  public void testDoublyLinkedListElementString() {
    DoublyLinkedListElement<String> element = new DoublyLinkedListElement<String>("element");
    assertEquals(element.getValue(), "element");
    assertEquals(element.getPreviousElement(), null);
    assertEquals(element.getNextElement(), null);
  }

  /**
   * Checks creation of element with value and previous/next reference.
   */
  public void testDoublyLinkedListElementStringDoublyLinkedListElementDoublyLinkedListElement() {
    DoublyLinkedListElement<String> element1 = new DoublyLinkedListElement<String>("elemen1");
    DoublyLinkedListElement<String> element3 = new DoublyLinkedListElement<String>("elemen3");
    DoublyLinkedListElement<String> element2 =
        new DoublyLinkedListElement<String>("element2", element1, element3);
    assertEquals("element2", element2.getValue());
    assertEquals(element1, element2.getPreviousElement());
    assertEquals(element3, element2.getNextElement());
  }

  /**
   * Check if set of previous element reference correct.
   */
  public void testSetPreviousElement() {
    DoublyLinkedListElement<String> element1 = new DoublyLinkedListElement<String>("element1");
    DoublyLinkedListElement<String> element2 = new DoublyLinkedListElement<String>("element2");
    element2.setPreviousElement(element1);
    assertEquals(element1, element2.getPreviousElement());
  }

  /**
   * Checks if element returns next previous reference.
   */
  public void testGetPreviousElement() {
    DoublyLinkedListElement<String> element1 = new DoublyLinkedListElement<String>("element1");
    DoublyLinkedListElement<String> element2 = new DoublyLinkedListElement<String>("element2");
    element2.setPreviousElement(element1);
    assertEquals(element1, element2.getPreviousElement());
  }

  /**
   * Check if set of next element reference correct.
   */
  public void testSetNextElement() {
    DoublyLinkedListElement<String> element1 = new DoublyLinkedListElement<String>("element1");
    DoublyLinkedListElement<String> element2 = new DoublyLinkedListElement<String>("element2");
    element1.setNextElement(element2);
    assertEquals(element2, element1.getNextElement());
  }

  /**
   * Checks if element returns next element reference.
   */
  public void testGetNextElement() {
    DoublyLinkedListElement<String> element1 = new DoublyLinkedListElement<String>("element1");
    DoublyLinkedListElement<String> element2 = new DoublyLinkedListElement<String>("element2");
    element1.setNextElement(element2);
    assertEquals(element2, element1.getNextElement());
  }

  /**
   * Check the return of the element value.
   */
  public void testGetValue() {
    DoublyLinkedListElement<String> element = new DoublyLinkedListElement<String>("test");
    assertEquals("test", element.getValue());
  }
  
  /**
   * Check if different datatypes as elements recognized.
   */
  public void testDifferentDatatypes() {
    // Integer
    DoublyLinkedListElement<Integer> element1 =
        new DoublyLinkedListElement<Integer>(new Integer(5));
    assertEquals(new Integer(5), element1.getValue());
    
    // Double
    DoublyLinkedListElement<Double> element2 = new DoublyLinkedListElement<Double>(new Double(5.0));
    assertEquals(new Double(5.0), element2.getValue());
  }

}
