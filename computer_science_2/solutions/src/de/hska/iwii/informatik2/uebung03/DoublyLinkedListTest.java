package de.hska.iwii.informatik2.uebung03;

import junit.framework.TestCase;

public class DoublyLinkedListTest extends TestCase {

  /**
   * checks the insert on the first position of the list.
   */
  public void testAddFirst() {
    DoublyLinkedList list = new DoublyLinkedList();
    list.addFirst("element1");
    list.addFirst("element2");
    assertEquals("element2", list.get(0));
    assertEquals("element1", list.get(1));
  }

  /**
   * checks the insert on the first position of the list.
   */
  public void testAddLast() {
    DoublyLinkedList list = new DoublyLinkedList();
    list.addLast("element1");
    assertEquals("element1", list.get(0));
    list.addLast("element2");
    assertEquals("element2", list.get(1));
  }

  /**
   * checks the add of an element at the specified position of the list.
   */
  public void testAdd() {
    DoublyLinkedList list = new DoublyLinkedList();
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
    DoublyLinkedList list = new DoublyLinkedList();
    list.add(0, "element1");
    list.add(1, "element2");
    assertEquals("element1", list.get(0));
    assertEquals("element2", list.get(1));
  }

  /**
   * Checks the remove of the first element of the list.
   */
  public void testRemoveFirst() {
    DoublyLinkedList list = new DoublyLinkedList();
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
    DoublyLinkedList list = new DoublyLinkedList();
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
    DoublyLinkedList list = new DoublyLinkedList();
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
    DoublyLinkedList list = new DoublyLinkedList();
    assertEquals(0, list.getSize());
    list.add(0, "element0");
    assertEquals(1, list.getSize());
  }

}
