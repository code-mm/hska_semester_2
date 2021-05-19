package de.hska.iwii.informatik2.uebung07;

import junit.framework.TestCase;

public class DoublyLinkedListTest extends TestCase {

  /**
   * checks the insert on the first position of the list.
   */
  public void testAddFirst() {
    DoublyLinkedList<String> list = new DoublyLinkedList<String>();
    list.addFirst("element1");
    list.addFirst("element2");
    assertEquals("element2", list.get(0));
    assertEquals("element1", list.get(1));
  }

  /**
   * checks the insert on the first position of the list.
   */
  public void testAddLast() {
    DoublyLinkedList<String> list = new DoublyLinkedList<String>();
    list.addLast("element1");
    assertEquals("element1", list.get(0));
    list.addLast("element2");
    assertEquals("element2", list.get(1));
  }

  /**
   * checks the add of an element at the specified position of the list.
   */
  public void testAdd() {
    DoublyLinkedList<String> list = new DoublyLinkedList<String>();
    list.add(0, "element1");
    assertEquals("element1", list.get(0));
    list.add(1, "element2");
    assertEquals("element2", list.get(1));
    list.add(1, "element3");
    assertEquals("element3", list.get(1));
  }

  /**
   * Checks the return value of the element at given position.
   */
  public void testGet() {
    DoublyLinkedList<String> list = new DoublyLinkedList<String>();
    list.add(0, "element1");
    list.add(1, "element2");
    assertEquals("element1", list.get(0));
    assertEquals("element2", list.get(1));
  }

  /**
   * Checks the remove of the first element of the list.
   */
  public void testRemoveFirst() {
    DoublyLinkedList<String> list = new DoublyLinkedList<String>();
    list.addFirst("element1");
    list.addLast("element2");
    list.addLast("element3");
    list.removeFirst();
    assertEquals("element2", list.get(0));
    assertEquals("element3", list.get(1));
  }

  /**
   * Checks the remove of the last element of the list.
   */
  public void testRemoveLast() {
    DoublyLinkedList<String> list = new DoublyLinkedList<String>();
    list.addFirst("element1");
    list.addLast("element2");
    list.addLast("element3");
    list.removeLast();
    assertEquals("element1", list.get(0));
    assertEquals("element2", list.get(1));
  }

  /**
   * Checks the remove of the element at a given position and the returned value.
   */
  public void testRemove() {
    DoublyLinkedList<String> list = new DoublyLinkedList<String>();
    list.addFirst("element1");
    list.addLast("element2");
    list.addLast("element3");
    assertEquals("element2", list.remove(1));
    assertEquals("element1", list.get(0));
    assertEquals("element3", list.get(1));
  }

  /**
   * Checks the return of the number of elements in the list.
   */
  public void testGetSize() {
    DoublyLinkedList<String> list = new DoublyLinkedList<String>();
    assertEquals(0, list.getSize());
    list.add(0, "element0");
    assertEquals(1, list.getSize());
    list.addLast("element1");
    list.addLast("element2");
    assertEquals(3, list.getSize());
  }
  
  /**
   * Check if different datatypes as elements recognized.
   */
  public void testDifferentDatatypes() {
    // Integer
    DoublyLinkedList<Integer> list1 = new DoublyLinkedList<Integer>();
    list1.addFirst(new Integer(5));
    assertEquals(new Integer(5), list1.get(0));
    // Double
    DoublyLinkedList<Double> list2 = new DoublyLinkedList<Double>();
    list2.addFirst(new Double(5.0));
    assertEquals(new Double(5.0), list2.get(0));
  }

}
