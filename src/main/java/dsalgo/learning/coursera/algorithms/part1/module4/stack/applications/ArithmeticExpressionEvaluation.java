package dsalgo.learning.coursera.algorithms.part1.module4.stack.applications;

import java.util.Stack;

// Using Dijkstra's Two Stack Algorithm
public class ArithmeticExpressionEvaluation {
    public static void main(String[] args) {
        Stack<String> operatorStack = new Stack<>();
        Stack<String> valueStack = new Stack<>();

        String expression = "(1+((2+3)*(4*5)))";

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            String input = String.valueOf(ch);

            if (input.equals("("))
                continue;
            else if (isNumber(input))
                valueStack.push(input);
            else if (isOperator(input))
                operatorStack.push(input);
            else {
                String operator = operatorStack.pop();
                Integer value1 = Integer.parseInt(valueStack.pop());
                Integer value2 = Integer.parseInt(valueStack.pop());

                int result = 0;
                if (operator.equals("+"))
                    result = value2 + value1;
                else if (operator.equals("-"))
                    result = value2 - value1;
                else if (operator.equals("*"))
                    result = value2 * value1;
                else
                    result = value2 / value1;

                valueStack.push(String.valueOf(result));
            }
        }

        System.out.println(valueStack.pop());

    }

    private static boolean isNumber(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException exception) {
            return false;
        }
    }

    private static boolean isOperator(String input) {
        return input.equals("+") || input.equals("-") || input.equals("*") || input.equals("/");
    }
}
