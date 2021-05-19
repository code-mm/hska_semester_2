package de.hska.iwii.informatik2.uebung03;

/**
 * Contains non or several list elements.
 */

public class DoublyLinkedList {

  private DoublyLinkedListElement firstElement;
  private DoublyLinkedListElement elementPointer;

  /**
   * Creates an empty list.
   */
  public DoublyLinkedList() {
    this.firstElement = null;
    this.elementPointer = null;
  }

  /**
   * Adds the element at the first position of the list.
   * @param value Wert des neuen Objekts
   */
  public void addFirst(String value) {
    this.add(0, value);
  }

  /**
   * Appends the element at the last position of the list.
   * @param value Wert des neuen Objekts
   */
  public void addLast(String value) {
    this.add(this.getSize(), value);
  }

  /**
   * Adds an element at the specified position of the list.
   * @param index Index des neuen Objekts in der Liste
   * @param value Wert des neuen Objekts
   */
  public void add(int index, String value) {
    if (this.firstElement == null) {
      this.firstElement = new DoublyLinkedListElement(value);
    } else {
      if (index == 0) {
        DoublyLinkedListElement elementTemp = this.firstElement;
        this.firstElement = new DoublyLinkedListElement(value, null, elementTemp);
        this.firstElement.getNextElement().setPreviousElement(this.firstElement);
      } else {
        this.elementPointer = this.firstElement;

        for (int i = 0; i < index - 1; i++) {
          this.elementPointer = this.next();
        }

        if (this.elementPointer.getNextElement() == null) {
          this.elementPointer.setNextElement(
              new DoublyLinkedListElement(value, this.elementPointer, null));
        } else {
          this.elementPointer.setNextElement(
              new DoublyLinkedListElement(value, this.elementPointer,
                  this.elementPointer.getNextElement()));
          this.elementPointer.getNextElement().getNextElement()
              .setPreviousElement(this.elementPointer.getNextElement());
        }
      }
    }
  }

  /**
   * Returns the value of the element at given position.
   * 
   * @param index
   *          Index des Objektes in der Liste
   * @return Wert des Objekts in der Liste
   */
  public String get(int index) {
    this.elementPointer = this.firstElement;
    for (int i = 0; i < index; i++) {
      this.next();
    }

    return elementPointer.getValue();
  }

  /**
   * Removes the first element of the list.
   * 
   * @return
   */
  public String removeFirst() {
    return this.remove(0);
  }

  /**
   * Remove the last element of the list.
   * 
   * @return
   */
  public String removeLast() {
    return this.remove(this.getSize() - 1);
  }

  /**
   * Remove the element at a given position and return its value.
   * 
   * @param index
   *          Index des Objekts in der Liste
   * @return Wert des Objektes vorm entfernen
   */
  public String remove(int index) {
    String value;
    if (this.firstElement == null) {
      throw new IllegalArgumentException("List is empty.");
    } else {
      if (this.getSize() - 1 < index) {
        throw new IllegalArgumentException("List is too short.");
      } else {
        this.elementPointer = this.firstElement;
        for (int i = 0; i < index; i++) {
          this.elementPointer = this.next();
        }
        value = this.elementPointer.getValue();
        if (index == 0) {
          this.firstElement = elementPointer.getNextElement();
          this.elementPointer.getNextElement().setPreviousElement(null);
        } else if (this.elementPointer.getNextElement() == null) {
          this.elementPointer.getPreviousElement().setNextElement(null);
        } else {
          this.elementPointer.getPreviousElement()
            .setNextElement(this.elementPointer.getNextElement());
          this.elementPointer.getNextElement()
            .setPreviousElement(this.elementPointer.getPreviousElement());
        }
      }
    }
    return value;
  }

  /**
   * Returns the number of elements in the list.
   * @return  Size of the list
   */
  public int getSize() {
    int listSize = 1;

    if (this.firstElement == null) {
      return 0;
    } else {
      this.elementPointer = firstElement;
      while (this.hasNext()) {
        listSize++;
        this.next();
      }
    }
    return listSize;
  }

  /**
   * Next element of the iterator.
   */
  private DoublyLinkedListElement next() {
    if (elementPointer.getNextElement() != null) {
      elementPointer = elementPointer.getNextElement();
    }
    return elementPointer;
  }

  /**
   * Check if next element exists.
   */
  private boolean hasNext() {
    return !(elementPointer.getNextElement() == null);
  }

}
