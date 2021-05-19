package de.hska.iwii.informatik2.uebung03;

import junit.framework.TestCase;

public class DoublyLinkedListElementTest extends TestCase {

  /**
   * Checks creation of element with only the value.
   */
  public void testDoublyLinkedListElementString() {
    DoublyLinkedListElement element = new DoublyLinkedListElement("element");
    assertEquals(element.getValue(), "element");
    assertEquals(element.getPreviousElement(), null);
    assertEquals(element.getNextElement(), null);
  }

  /**
   * Checks creation of element with value and previous/next reference.
   */
  public void testDoublyLinkedListElementStringDoublyLinkedListElementDoublyLinkedListElement() {
    DoublyLinkedListElement element1 = new DoublyLinkedListElement("elemen1");
    DoublyLinkedListElement element3 = new DoublyLinkedListElement("elemen3");
    DoublyLinkedListElement element2 = new DoublyLinkedListElement("element2", element1, element3);
    assertEquals("element2", element2.getValue());
    assertEquals(element1, element2.getPreviousElement());
    assertEquals(element3, element2.getNextElement());
  }

  /**
   * Check if set of previous element reference correct.
   */
  public void testSetPreviousElement() {
    DoublyLinkedListElement element1 = new DoublyLinkedListElement("element1");
    DoublyLinkedListElement element2 = new DoublyLinkedListElement("element2");
    element2.setPreviousElement(element1);
    assertEquals(element1, element2.getPreviousElement());
  }

  /**
   * Checks if element returns next previous reference.
   */
  public void testGetPreviousElement() {
    DoublyLinkedListElement element1 = new DoublyLinkedListElement("element1");
    DoublyLinkedListElement element2 = new DoublyLinkedListElement("element2");
    element2.setPreviousElement(element1);
    assertEquals(element1, element2.getPreviousElement());
  }

  /**
   * Check if set of next element reference correct.
   */
  public void testSetNextElement() {
    DoublyLinkedListElement element1 = new DoublyLinkedListElement("element1");
    DoublyLinkedListElement element2 = new DoublyLinkedListElement("element2");
    element1.setNextElement(element2);
    assertEquals(element2, element1.getNextElement());
  }

  /**
   * Checks if element returns next element reference.
   */
  public void testGetNextElement() {
    DoublyLinkedListElement element1 = new DoublyLinkedListElement("element1");
    DoublyLinkedListElement element2 = new DoublyLinkedListElement("element2");
    element1.setNextElement(element2);
    assertEquals(element2, element1.getNextElement());
  }

  /**
   * Check the return of the element value.
   */
  public void testGetValue() {
    DoublyLinkedListElement element = new DoublyLinkedListElement("test");
    assertEquals("test", element.getValue());
  }

}
