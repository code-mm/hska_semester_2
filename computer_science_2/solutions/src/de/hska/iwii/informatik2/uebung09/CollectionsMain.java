package de.hska.iwii.informatik2.uebung09;

public class CollectionsMain {

  /**
   * Main method for output of class "Collections".
   * 
   * @param args
   *          Standard arguments for main class
   */
  public static void main(String[] args) {
    CollectionTasks coll = new CollectionTasks();
    
    boolean runTestsTwice = true;
    
    // run tests twice
    if (runTestsTwice) {
      coll.task1(false);
      coll.task2(false);
      coll.task3(false);
      coll.task4(false);
      coll.task5(false);
      coll.task6(false);
      coll.task7(false);
    }
    
    
    coll.task1(true);
    coll.task2(true);
    coll.task3(true);
    coll.task4(true);
    coll.task5(true);
    coll.task6(true);
    coll.task7(true);
  }

}
