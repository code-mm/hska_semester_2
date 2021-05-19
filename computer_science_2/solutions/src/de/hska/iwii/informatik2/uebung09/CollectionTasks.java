package de.hska.iwii.informatik2.uebung09;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.TreeSet;
import java.util.Vector;
import java.util.stream.Stream;

public class CollectionTasks {
  private final int elementCounter = 100000;
  private Vector<Integer> appendVector;
  private ArrayList<Integer> appendArrayList;
  private LinkedList<Integer> appendLinkedList;
  private HashSet<Integer> appendHashSet;
  private TreeSet<Integer> appendTreeSet;
  private Vector<Integer> prependVector;
  private ArrayList<Integer> prependArrayList;
  private LinkedList<Integer> prependLinkedList;
  private ArrayList<Integer> randomArrayList;

  /**
   * 1 - Append integer numbers from 0 to 99.999.
   */
  public void task1(boolean verbose) {

    if (verbose) {
      System.out.println("--> Start of Task 1.");
    }

    // Vector
    TimeMeasure tm1 = new TimeMeasure();
    tm1.setStartTime();

    this.appendVector = new Vector<Integer>();
    for (int i = 0; i < elementCounter; i++) {
      this.appendVector.add(new Integer(i));
    }

    tm1.setEndTime();
    if (verbose) {
      System.out.println("Append to data structure \"Vector\" took: " + tm1.getDuration() + " ms.");
    }

    // ArrayList
    TimeMeasure tm2 = new TimeMeasure();
    tm2.setStartTime();

    this.appendArrayList = new ArrayList<Integer>();
    for (int i = 0; i < elementCounter; i++) {
      this.appendArrayList.add(new Integer(i));
    }

    tm2.setEndTime();
    if (verbose) {
      System.out
          .println("Append to data structure \"ArrayList\" took: " + tm2.getDuration() + " ms.");
    }

    // LinkedList
    TimeMeasure tm3 = new TimeMeasure();
    tm3.setStartTime();

    this.appendLinkedList = new LinkedList<Integer>();
    for (int i = 0; i < elementCounter; i++) {
      this.appendLinkedList.add(new Integer(i));
    }

    tm3.setEndTime();
    if (verbose) {
      System.out
          .println("Append to data structure \"LinkedList\" took: " + tm3.getDuration() + " ms.");
    }

    // HashSet
    TimeMeasure tm4 = new TimeMeasure();
    tm4.setStartTime();

    this.appendHashSet = new HashSet<Integer>();
    for (int i = 0; i < elementCounter; i++) {
      this.appendHashSet.add(new Integer(i));
    }

    tm4.setEndTime();
    if (verbose) {
      System.out
          .println("Append to data structure \"HashSet\" took: " + tm4.getDuration() + " ms.");
    }

    // TreeSet
    TimeMeasure tm5 = new TimeMeasure();
    tm5.setStartTime();

    this.appendTreeSet = new TreeSet<Integer>();
    for (int i = 0; i < elementCounter; i++) {
      this.appendTreeSet.add(new Integer(i));
    }

    tm5.setEndTime();
    if (verbose) {
      System.out
          .println("Append to data structure \"TreeSet\" took: " + tm5.getDuration() + " ms.");
    }

    // Vector with predefined size
    TimeMeasure tm6 = new TimeMeasure();
    tm6.setStartTime();

    this.appendVector = new Vector<Integer>(elementCounter);
    for (int i = 0; i < elementCounter; i++) {
      this.appendVector.add(new Integer(i));
    }

    tm6.setEndTime();
    if (verbose) {
      System.out.println("Append to data structure \"Vector\" with predefined size took: "
          + tm6.getDuration() + " ms.");
    }

    // ArrayList with predefined size
    TimeMeasure tm7 = new TimeMeasure();
    tm7.setStartTime();

    this.appendArrayList = new ArrayList<Integer>();
    for (int i = 0; i < elementCounter; i++) {
      this.appendArrayList.add(new Integer(i));
    }

    tm7.setEndTime();
    if (verbose) {
      System.out.println("Append to data structure \"ArrayList\" with predefined size took: "
          + tm7.getDuration() + " ms.");

      System.out.println("--> End of Task 1.\n");
    }

  }

  /**
   * 2 - Prepend integer numbers from 0 to 99.999.
   */
  public void task2(boolean verbose) {

    if (verbose) {
      System.out.println("--> Start of Task 2.");
    }

    // Vector
    TimeMeasure tm1 = new TimeMeasure();
    tm1.setStartTime();

    this.prependVector = new Vector<Integer>();
    for (int i = 0; i < elementCounter; i++) {
      this.prependVector.add(0, new Integer(i));
    }

    tm1.setEndTime();
    if (verbose) {
      System.out
          .println("Prepend to data structure \"Vector\" took: " + tm1.getDuration() + " ms.");
    }

    // ArrayList
    TimeMeasure tm2 = new TimeMeasure();
    tm2.setStartTime();

    this.prependArrayList = new ArrayList<Integer>();
    for (int i = 0; i < elementCounter; i++) {
      this.prependArrayList.add(0, new Integer(i));
    }

    tm2.setEndTime();
    if (verbose) {
      System.out
          .println("Prepend to data structure \"ArrayList\" took: " + tm2.getDuration() + " ms.");
    }

    // LinkedList
    TimeMeasure tm3 = new TimeMeasure();
    tm3.setStartTime();

    this.prependLinkedList = new LinkedList<Integer>();
    for (int i = 0; i < elementCounter; i++) {
      this.prependLinkedList.add(0, new Integer(i));
    }

    tm3.setEndTime();
    if (verbose) {
      System.out
          .println("Prepend to data structure \"LinkedList\" took: " + tm3.getDuration() + " ms.");
    }

    // Vector with predefined size
    TimeMeasure tm4 = new TimeMeasure();
    tm4.setStartTime();

    this.prependVector = new Vector<Integer>(elementCounter);
    for (int i = 0; i < elementCounter; i++) {
      this.prependVector.add(0, new Integer(i));
    }

    tm4.setEndTime();
    if (verbose) {
      System.out.println("Prepend to data structure \"Vector\" with predefined size took: "
          + tm4.getDuration() + " ms.");
    }

    // ArrayList with predefined size
    TimeMeasure tm5 = new TimeMeasure();
    tm5.setStartTime();

    this.prependArrayList = new ArrayList<Integer>();
    for (int i = 0; i < elementCounter; i++) {
      this.prependArrayList.add(0, new Integer(i));
    }

    tm5.setEndTime();
    if (verbose) {
      System.out.println("Prepend to data structure \"ArrayList\" with predefined size took: "
          + tm5.getDuration() + " ms.");

      System.out.println("--> End of Task 2.\n");
    }

  }

  /**
   * 3 - Search with the iterator the last inserted value.
   */
  public void task3(boolean verbose) {

    if (verbose) {
      System.out.println("--> Start of Task 3.");
    }

    // Vector - append
    TimeMeasure tm1 = new TimeMeasure();
    tm1.setStartTime();

    for (Iterator<Integer> it = this.appendVector.iterator(); it.hasNext();) {
      if (it.next() == elementCounter - 1) {
        break;
      }
    }
    tm1.setEndTime();
    if (verbose) {
      System.out
          .println("Search for last added element in appended data structure \"Vector\" took: "
              + tm1.getDuration() + " ms.");
    }

    // Vector - prepend
    TimeMeasure tm2 = new TimeMeasure();
    tm2.setStartTime();

    for (Iterator<Integer> it = this.prependVector.iterator(); it.hasNext();) {
      if (it.next() == elementCounter - 1) {
        break;
      }
    }
    tm2.setEndTime();
    if (verbose) {
      System.out
          .println("Search for last added element in prepended data structure \"Vector\" took: "
              + tm2.getDuration() + " ms.");
    }

    // ArrayList - append
    TimeMeasure tm3 = new TimeMeasure();
    tm3.setStartTime();

    for (Iterator<Integer> it = this.appendArrayList.iterator(); it.hasNext();) {
      if (it.next() == elementCounter - 1) {
        break;
      }
    }
    tm3.setEndTime();
    if (verbose) {
      System.out
          .println("Search for last added element in appended data structure \"ArrayList\" took: "
              + tm3.getDuration() + " ms.");
    }

    // ArrayList - prepend
    TimeMeasure tm4 = new TimeMeasure();
    tm4.setStartTime();

    for (Iterator<Integer> it = this.prependArrayList.iterator(); it.hasNext();) {
      if (it.next() == elementCounter - 1) {
        break;
      }
    }
    tm4.setEndTime();
    if (verbose) {
      System.out
          .println("Search for last added element in prepended data structure \"ArrayList\" took: "
              + tm4.getDuration() + " ms.");
    }

    // LinkedList - append
    TimeMeasure tm5 = new TimeMeasure();
    tm5.setStartTime();

    for (Iterator<Integer> it = this.appendLinkedList.iterator(); it.hasNext();) {
      if (it.next() == elementCounter - 1) {
        break;
      }
    }
    tm5.setEndTime();
    if (verbose) {
      System.out
          .println("Search for last added element in appended data structure \"LinkedList\" took: "
              + tm5.getDuration() + " ms.");
    }

    // LinkedList - prepend
    TimeMeasure tm6 = new TimeMeasure();
    tm6.setStartTime();

    for (Iterator<Integer> it = this.prependLinkedList.iterator(); it.hasNext();) {
      if (it.next() == elementCounter - 1) {
        break;
      }
    }
    tm6.setEndTime();
    if (verbose) {
      System.out
          .println("Search for last added element in prepended data structure \"LinkedList\" took: "
              + tm6.getDuration() + " ms.");
    }

    // HashSet - append
    TimeMeasure tm7 = new TimeMeasure();
    tm7.setStartTime();

    for (Iterator<Integer> it = this.appendHashSet.iterator(); it.hasNext();) {
      if (it.next() == elementCounter - 1) {
        break;
      }
    }
    tm7.setEndTime();
    if (verbose) {
      System.out
          .println("Search for last added element in appended data structure \"HashSet\" took: "
              + tm7.getDuration() + " ms.");
    }

    // TreeSet - append
    TimeMeasure tm8 = new TimeMeasure();
    tm8.setStartTime();

    for (Iterator<Integer> it = this.appendArrayList.iterator(); it.hasNext();) {
      if (it.next() == elementCounter - 1) {
        break;
      }
    }
    tm8.setEndTime();
    if (verbose) {
      System.out
          .println("Search for last added element in appended data structure \"TreeSet\" took: "
              + tm8.getDuration() + " ms.");

      System.out.println("--> End of Task 3.\n");
    }
  }

  /**
   * 4 - Binary search the last inserted value.
   */
  public void task4(boolean verbose) {

    if (verbose) {
      System.out.println("--> Start of Task 4.");
    }

    // Vector - append
    TimeMeasure tm1 = new TimeMeasure();
    tm1.setStartTime();

    Collections.binarySearch(this.appendVector, this.elementCounter - 1);

    tm1.setEndTime();
    if (verbose) {
      System.out.println(
          "Binary search for last added element in appended data structure \"Vector\" took: "
              + tm1.getDuration() + " ms.");
    }

    // Vector - prepend
    TimeMeasure tm2 = new TimeMeasure();
    tm2.setStartTime();

    Collections.binarySearch(this.prependVector, this.elementCounter - 1);

    tm2.setEndTime();
    if (verbose) {
      System.out.println(
          "Binary search for last added element in prepended data structure \"Vector\" took: "
              + tm2.getDuration() + " ms.");
    }

    // ArrayList - append
    TimeMeasure tm3 = new TimeMeasure();
    tm3.setStartTime();

    Collections.binarySearch(this.appendArrayList, this.elementCounter - 1);

    tm3.setEndTime();
    if (verbose) {
      System.out.println(
          "Binary search for last added element in appended data structure \"ArrayList\" took: "
              + tm3.getDuration() + " ms.");
    }

    // ArrayList - prepend
    TimeMeasure tm4 = new TimeMeasure();
    tm4.setStartTime();

    Collections.binarySearch(this.prependArrayList, this.elementCounter - 1);

    tm4.setEndTime();
    if (verbose) {
      System.out.println(
          "Binary search for last added element in prepended data structure \"ArrayList\" took: "
              + tm4.getDuration() + " ms.");

      System.out.println("--> End of Task 4.\n");
    }
  }

  /**
   * 5 - Search with the data structure methods for the last inserted value.
   */
  public void task5(boolean verbose) {

    if (verbose) {
      System.out.println("--> Start of Task 5.");
    }

    // Vector - append
    TimeMeasure tm1 = new TimeMeasure();
    tm1.setStartTime();

    this.appendVector.contains(new Integer(this.elementCounter - 1));

    tm1.setEndTime();
    if (verbose) {
      System.out.println(
          "Bultin search for last added element in appended data structure \"Vector\" took: "
              + tm1.getDuration() + " ms.");
    }

    // Vector - prepend
    TimeMeasure tm2 = new TimeMeasure();
    tm2.setStartTime();

    this.prependVector.contains(new Integer(this.elementCounter - 1));

    tm2.setEndTime();
    if (verbose) {
      System.out.println(
          "Bultin search for last added element in prepended data structure \"Vector\" took: "
              + tm2.getDuration() + " ms.");
    }

    // ArrayList - append
    TimeMeasure tm3 = new TimeMeasure();
    tm3.setStartTime();

    this.appendArrayList.contains(new Integer(this.elementCounter - 1));

    tm3.setEndTime();
    if (verbose) {
      System.out.println(
          "Bultin search for last added element in appended data structure \"ArrayList\" took: "
              + tm3.getDuration() + " ms.");
    }

    // ArrayList - prepend
    TimeMeasure tm4 = new TimeMeasure();
    tm4.setStartTime();

    this.prependArrayList.contains(new Integer(this.elementCounter - 1));

    tm4.setEndTime();
    if (verbose) {
      System.out.println(
          "Bultin search for last added element in prepended data structure \"ArrayList\" took: "
              + tm4.getDuration() + " ms.");
    }

    // LinkedList - append
    TimeMeasure tm5 = new TimeMeasure();
    tm5.setStartTime();

    this.appendArrayList.contains(new Integer(this.elementCounter - 1));

    tm5.setEndTime();
    if (verbose) {
      System.out.println(
          "Bultin search for last added element in appended data structure \"LinkedList\" took: "
              + tm5.getDuration() + " ms.");
    }

    // LinkedList - prepend
    TimeMeasure tm6 = new TimeMeasure();
    tm6.setStartTime();

    this.prependArrayList.contains(new Integer(this.elementCounter - 1));

    tm6.setEndTime();
    if (verbose) {
      System.out.println(
          "Bultin search for last added element in prepended data structure \"LinkedList\" took: "
              + tm6.getDuration() + " ms.");
    }

    // HashSet - append
    TimeMeasure tm7 = new TimeMeasure();
    tm7.setStartTime();

    this.appendHashSet.contains(new Integer(this.elementCounter - 1));

    tm7.setEndTime();
    if (verbose) {
      System.out.println(
          "Bultin search for last added element in appended data structure \"HashSet\" took: "
              + tm7.getDuration() + " ms.");
    }

    // TreeSet - append
    TimeMeasure tm8 = new TimeMeasure();
    tm8.setStartTime();

    this.appendTreeSet.contains(new Integer(this.elementCounter - 1));

    tm8.setEndTime();
    if (verbose) {
      System.out.println(
          "Bultin search for last added element in appended data structure \"TreeSet\" took: "
              + tm8.getDuration() + " ms.");

      System.out.println("--> End of Task 5.\n");
    }
  }

  /**
   * 6 - Create an ArrayList with random numbers between 0 and 9999.
   */
  public void task6(boolean verbose) {

    if (verbose) {
      System.out.println("--> Start of Task 6.");
    }

    TimeMeasure tm = new TimeMeasure();
    tm.setStartTime();
    this.randomArrayList = new ArrayList<Integer>();
    Stream<Integer> randomInteger = Stream.generate(() -> (int) (Math.random() * 1000));

    randomInteger.limit(elementCounter).forEach(this.randomArrayList::add);

    tm.setEndTime();
    if (verbose) {
      System.out.println("Generate random numbers stream for data structure \"ArrayList\" took: "
          + tm.getDuration() + " ms.");

      System.out.println("--> End of Task 6.\n");
    }
  }

  /**
   * 7 - Sum up all even numbers from the generated random numbers.
   */
  public void task7(boolean verbose) {

    if (verbose) {
      System.out.println("--> Start of Task 7.");
    }

    TimeMeasure tm = new TimeMeasure();
    tm.setStartTime();

    int sum = this.randomArrayList.parallelStream().filter(x -> x % 2 == 0)
        .mapToInt(i -> i.intValue()).sum();

    tm.setEndTime();
    if (verbose) {
      System.out.println("Generate random numbers stream for data structure \"ArrayList\" took: "
          + tm.getDuration() + " ms and returned value " + sum + ".");

      System.out.println("--> End of Task 7.\n");
    }
  }

}
