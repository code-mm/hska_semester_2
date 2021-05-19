package de.hska.iwii.informatik2.uebung07;

/**
 * Single element of a list.
 */
public class DoublyLinkedListElement<E> {

  private E value;
  private DoublyLinkedListElement<E> previousElement;
  private DoublyLinkedListElement<E> nextElement;

  DoublyLinkedListElement(E value) {
    this.previousElement = null;
    this.nextElement = null;
    this.value = value;
  }

  DoublyLinkedListElement(E value, DoublyLinkedListElement<E> previousElement,
      DoublyLinkedListElement<E> nextElement) {
    this.value = value;
    this.previousElement = previousElement;
    this.nextElement = nextElement;
  }

  void setPreviousElement(DoublyLinkedListElement<E> previousElement) {
    this.previousElement = previousElement;
  }

  DoublyLinkedListElement<E> getPreviousElement() {
    return this.previousElement;
  }

  void setNextElement(DoublyLinkedListElement<E> nextElement) {
    this.nextElement = nextElement;
  }

  DoublyLinkedListElement<E> getNextElement() {
    return this.nextElement;
  }

  E getValue() {
    return this.value;
  }

}
