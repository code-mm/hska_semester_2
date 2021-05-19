package de.hska.iwii.informatik2.uebung10;

import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Postfix {

  /**
   * Returns the value of the expression.
   * 
   * @return value of the expression
   */
  public static Integer calculateValue(String expression) {
    LinkedList<String> convertedExpression = convertExpression(expression);
    return calculateExpression(convertedExpression);
  }

  /**
   * Remove spaces and tabs in expression and separate in LinkedList.
   * 
   * @param expression
   *          expression to clean
   * @return cleaned list
   */
  private static LinkedList<String> convertExpression(String expression) {
    LinkedList<String> convertedExpression = new LinkedList<String>();
    StringTokenizer st = new StringTokenizer(expression);

    while (st.hasMoreTokens()) {
      convertedExpression.add(st.nextToken());
    }

    return convertedExpression;
  }

  /**
   * Calculate the value of the expression.
   * 
   * @param expression
   *          Expression to calculate
   * @return Value of the expression
   */
  private static Integer calculateExpression(LinkedList<String> expression) {
    Stack<Integer> stack = new Stack<Integer>();

    while (expression.size() > 0) {
      if (expression.get(0).matches("^[0-9]+$")) {
        stack.push(new Integer(Integer.parseInt(expression.get(0))));
      } else {
        if ((expression.get(0).equals("+") | expression.get(0).equals("-")
            | expression.get(0).equals("*")) && stack.size() == 1) {
          throw new IllegalArgumentException(
              "Stack contains not enough elements for arithmetic operation.");
        }

        Integer number1 = stack.pop();
        Integer number2 = stack.pop();

        if (expression.get(0).equals("+")) {
          stack.push(new Integer(number2.intValue() + number1.intValue()));
        } else if (expression.get(0).equals("-")) {
          stack.push(new Integer(number2.intValue() - number1.intValue()));
        } else if (expression.get(0).equals("*")) {
          stack.push(new Integer(number2.intValue() * number1.intValue()));
        } else {
          throw new IllegalArgumentException(
              "Illegal character in argument, allowed are numbers and the operators +, -, *.");
        }
      }
      expression.removeFirst();
    }
    return stack.pop();
  }
  
}
