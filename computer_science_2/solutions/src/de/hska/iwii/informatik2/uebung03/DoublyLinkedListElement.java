package de.hska.iwii.informatik2.uebung03;

/**
 * Single element of a list.
 */
public class DoublyLinkedListElement {

  private String value;
  private DoublyLinkedListElement previousElement;
  private DoublyLinkedListElement nextElement;

  DoublyLinkedListElement(String value) {
    this.previousElement = null;
    this.nextElement = null;
    this.value = value;
  }

  DoublyLinkedListElement(String value, DoublyLinkedListElement previousElement,
      DoublyLinkedListElement nextElement) {
    this.value = value;
    this.previousElement = previousElement;
    this.nextElement = nextElement;
  }

  void setPreviousElement(DoublyLinkedListElement previousElement) {
    this.previousElement = previousElement;
  }

  DoublyLinkedListElement getPreviousElement() {
    return this.previousElement;
  }

  void setNextElement(DoublyLinkedListElement nextElement) {
    this.nextElement = nextElement;
  }

  DoublyLinkedListElement getNextElement() {
    return this.nextElement;
  }

  String getValue() {
    return this.value;
  }

}
