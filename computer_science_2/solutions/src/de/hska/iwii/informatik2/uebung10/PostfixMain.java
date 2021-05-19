package de.hska.iwii.informatik2.uebung10;

public class PostfixMain {

  public static void main(String[] args) {
    System.out.println((Postfix.calculateValue("15 42 18 + 61 24 - * 71 + *")).intValue());
  }

}
