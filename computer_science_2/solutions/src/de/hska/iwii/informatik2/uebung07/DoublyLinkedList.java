package de.hska.iwii.informatik2.uebung07;

/**
 * Contains non or several list elements.
 */
public class DoublyLinkedList<E> {

  private DoublyLinkedListElement<E> firstElement;
  private DoublyLinkedListElement<E> lastElement;
  private DoublyLinkedListElement<E> elementPointer;
  int size;

  /**
   * Creates an empty list.
   */
  public DoublyLinkedList() {
    this.firstElement = null;
    this.lastElement = null;
    this.elementPointer = null;
    this.size = 0;
  }

  /**
   * Adds the element at the first position of the list.
   * 
   * @param value
   *          Wert des neuen Objekts
   */
  public void addFirst(E value) {
    this.add(0, value);
  }

  /**
   * Appends the element at the last position of the list.
   * 
   * @param value
   *          Wert des neuen Objekts
   */
  public void addLast(E value) {
    this.add(this.getSize(), value);
  }

  /**
   * Adds an element at the specified position of the list.
   * 
   * @param index
   *          Index des neuen Objekts in der Liste
   * @param value
   *          Wert des neuen Objekts
   */
  public void add(int index, E value) {
    if (this.firstElement == null) { /* insert if list is empty */
      this.firstElement = new DoublyLinkedListElement<E>(value);
      this.lastElement = this.firstElement;
      this.size++;
    } else {
      if (index == 0) { /* insert at beginning of list */
        DoublyLinkedListElement<E> elementTemp = this.firstElement;
        this.firstElement = new DoublyLinkedListElement<E>(value, null, elementTemp);
        this.firstElement.getNextElement().setPreviousElement(this.firstElement);
        this.size++;
      } else if (index >= this.getSize()) { /* insert at end of list */
        this.lastElement
            .setNextElement(new DoublyLinkedListElement<E>(value, this.lastElement, null));
        this.lastElement = this.lastElement.getNextElement();
        this.size++;
      } else {
        if (this.getSize() / 2 < index) { /* insert element between first element and middle */
          this.elementPointer = this.firstElement;
          for (int i = 0; i < index; i++) {
            this.elementPointer = this.next();
          }
          this.elementPointer.setNextElement(new DoublyLinkedListElement<E>(value,
              this.elementPointer, this.elementPointer.getNextElement()));
          this.elementPointer.getNextElement().getNextElement()
              .setPreviousElement(this.elementPointer.getNextElement());
          this.size++;
        } else { /* insert element between middle and last element */
          this.elementPointer = this.lastElement;
          for (int i = this.getSize(); i > index; i--) {
            this.elementPointer = this.previous();
          }
          this.elementPointer.setNextElement(new DoublyLinkedListElement<E>(value,
              this.elementPointer, this.elementPointer.getNextElement()));
          this.elementPointer.getNextElement().getNextElement()
              .setPreviousElement(this.elementPointer.getNextElement());
          this.size++;
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
  public Object get(int index) {
    if (this.getSize() / 2 < index) { /* decide to start at first or last element */
      this.elementPointer = this.firstElement;
      for (int i = 0; i < index; i++) {
        this.elementPointer = this.next();
      }
    } else {
      this.elementPointer = this.lastElement;
      for (int i = this.getSize() - 1; i > index; i--) {
        this.elementPointer = this.previous();
      }
    }

    return elementPointer.getValue();
  }

  /**
   * Removes the first element of the list.
   * 
   * @return
   */
  public E removeFirst() {
    return this.remove(0);
  }

  /**
   * Remove the last element of the list.
   * 
   * @return
   */
  public E removeLast() {
    return this.remove(this.getSize() - 1);
  }

  /**
   * Remove the element at a given position and return its value.
   * 
   * @param index
   *          Index des Objekts in der Liste
   * @return Wert des Objektes vorm entfernen
   */
  public E remove(int index) {
    E value;
    if (this.firstElement == null) { /* list empty */
      throw new IllegalArgumentException("List is empty.");
    } else {
      if (this.getSize() - 1 < index) { /* list shorter than given index */
        throw new IllegalArgumentException("List is too short.");
      } else {
        if (index == 0) { /* remove first element */
          value = this.firstElement.getValue();
          this.firstElement.getNextElement().setPreviousElement(null);
          this.firstElement = this.firstElement.getNextElement();
          this.size--;
        } else if (index == this.getSize() - 1) { /* remove last element */
          value = this.lastElement.getValue();
          this.lastElement.getPreviousElement().setNextElement(null);
          this.lastElement = this.lastElement.getPreviousElement();
          this.size--;
        } else {
          if (this.getSize() / 2 < index) { /* remove element between first element and middle */
            this.elementPointer = this.firstElement;
            for (int i = 0; i < index; i++) {
              this.elementPointer = this.next();
            }
            value = this.elementPointer.getValue();
            this.elementPointer.getPreviousElement()
                .setNextElement(this.elementPointer.getNextElement());
            this.elementPointer.getNextElement()
                .setPreviousElement(this.elementPointer.getPreviousElement());
            this.size--;
          } else { /* remove element between middle and last element */
            this.elementPointer = this.lastElement;
            for (int i = this.getSize() - 1; i > index; i--) {
              this.elementPointer = this.previous();
            }
            value = this.elementPointer.getValue();
            this.elementPointer.getPreviousElement()
                .setNextElement(this.elementPointer.getNextElement());
            this.elementPointer.getNextElement()
                .setPreviousElement(this.elementPointer.getPreviousElement());
            this.size--;
          }
        }
      }
    }
    return value;
  }

  /**
   * Returns the number of elements in the list.
   * 
   * @return Size of the list
   */
  public int getSize() {
    return this.size;
  }

  /**
   * Next element of the iterator.
   */
  private DoublyLinkedListElement<E> next() {
    if (elementPointer.getNextElement() != null) {
      elementPointer = elementPointer.getNextElement();
    }
    return elementPointer;
  }

  /**
   * Next element of the iterator.
   */
  private DoublyLinkedListElement<E> previous() {
    if (elementPointer.getPreviousElement() != null) {
      elementPointer = elementPointer.getPreviousElement();
    }
    return elementPointer;
  }

}
