
/** required package class namespace */
package numbers;

/** required imports */
import collections.Stack;

/**
 * Equations.java - a collection of useful methods for working with 
 * math equations
 * @author Mr. Wachs
 * @since Feb 23, 2017
 * @instructor Mr. Wachs
 */
public class Equations 
{
    
    private static final int EQUAL_PRIORITY  = 0;
    private static final int LOWER_PRIORITY  = -1;
    private static final int HIGHER_PRIORITY = 1;
    
    /**
     * tests the infix equation to ensure proper brace placement
     * @param infix the equation to test
     * @return the equation braces are nested properly (true) or not (false)
     */
    public static boolean braceNestingText(String infix) { 
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < infix.length(); i++) {
            Character character = infix.charAt(i);
            if (isLeftBrace(character)) {
                stack.push(character);
            }
            else if (isRightBrace(character)) {
                if (stack.isEmpty()) return false;
                else {
                    Character match = stack.top();
                    if (isMatchingBrace(match, character)) {
                        stack.pop();
                    }
                    else {
                        return false;
                    }
                }
            }
        }       
        if (!stack.isEmpty()) return false;
        return true;
    }
        
    /**
     * converts a infix equation (1 digit values) to postfix
     * @param infix the infix equation to convert
     * @return a postfix equation
     */
    public static String toPostfix(String infix) {
        String postfix = "";
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < infix.length(); i++) {
            Character character = infix.charAt(i);
            if (isBrace(character)) {
                if (isLeftBrace(character)) {
                    stack.push(character);
                } 
                else if (isRightBrace(character)) {
                    boolean done = false;
                    while (!stack.isEmpty() && !done) {
                        Character operator = stack.pop();
                        if (isOperator(operator)) {
                            postfix += operator;
                        } 
                        else if (isMatchingBrace(operator, character)) {
                            done = true;
                        }
                    }
                } 
            }
            else if (isOperator(character)) {
                boolean done = false;
                while (!stack.isEmpty() && !done) {
                    Character operator = stack.top();
                    if (isOperator(operator)) {
                        int result = isHigherPriority(character,operator);
                        if (result == HIGHER_PRIORITY ||
                            result == EQUAL_PRIORITY) {
                            operator = stack.pop();
                            postfix += operator;
                        }
                        else if (result == LOWER_PRIORITY) {
                            done = true;
                        }
                    }
                    else {
                        done = true;
                    }
                }
                stack.push(character);
            } 
            else {
                postfix += character; // operand 
            }
        }
        postfix += stack.pop();
        return postfix;
    }
    
    /**
     * converts a postfix equation (1 digit values) to prefix
     * @param postfix the postfix equation to convert
     * @return a prefix equation
     */
    public static String toPrefix(String postfix) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < postfix.length(); i++) {
            Character character = postfix.charAt(i);
            if (isOperator(character)) {
                String item1 = stack.pop();
                String item2 = stack.pop();
                String combined = character + item2 + item1;
                stack.push(combined);
            }
            else {
                String item = "" + character;
                stack.push(item);
            }
        }
        return stack.pop();
    }

    /**
     * solves a postfix equation (1 digit values)
     * @param equation the postfix equation to evaluate
     * @return the solution to the equation
     */
    public static double solvePostfix(String equation) {
        Stack<Double> stack = new Stack<>();
        for (int i = 0; i < equation.length(); i++) {
            Character character = equation.charAt(i);
            if (isOperator(character)) {
                String value1 = "" + stack.pop();
                String value2 = "" + stack.pop();
                double operand1 = Double.parseDouble(value1);                
                double operand2 = Double.parseDouble(value2);
                double answer = 0;
                if      (character == '+') answer = operand2 + operand1;
                else if (character == '-') answer = operand2 - operand1;
                else if (character == '*') answer = operand2 * operand1;
                else if (character == '/') answer = operand2 / operand1;
                stack.push(answer);
            }
            else {
                String value = "" + character;
                double operand = Double.parseDouble(value);
                stack.push(operand);
            }
        }
        String value = "" + stack.pop();
        double operand = Double.parseDouble(value);
        return operand;
    }
    
    /**
     * solves a postfix equation (1 digit values)
     * @param equation the postfix equation to evaluate
     * @return the solution to the equation
     */
    public static double solvePrefix(String equation) {
        Stack<Double> stack = new Stack<>();
        for (int i = equation.length()-1; i >= 0; i--) {
            Character character = equation.charAt(i);
            if (isOperator(character)) {
                String value1 = "" + stack.pop();
                String value2 = "" + stack.pop();
                double operand1 = Double.parseDouble(value1);                
                double operand2 = Double.parseDouble(value2);
                double answer = 0;
                if      (character == '+') answer = operand1 + operand2;
                else if (character == '-') answer = operand1 - operand2;
                else if (character == '*') answer = operand1 * operand2;
                else if (character == '/') answer = operand1 / operand2;
                stack.push(answer);
            }
            else {
                String value = "" + character;
                double operand = Double.parseDouble(value);
                stack.push(operand);
            }             
        }
        String value = "" + stack.pop();
        double operand = Double.parseDouble(value);
        return operand;
    }
    
    /**
     * determines if the character is a math operator
     * @param character the character to check
     * @return is a math operator (true) or not (false)
     */
    private static boolean isOperator(Character character) {
        if      (character == '+') return true;
        else if (character == '-') return true;
        else if (character == '*') return true;
        else if (character == '/') return true;
        else                       return false;
    }

    /**
     * determines if the character is a math opening brace ( { [
     * @param character the character to check
     * @return is math opening brace (true) or not (false)
     */
    private static boolean isLeftBrace(Character character) {
        if      (character == '(') return true;
        else if (character == '{') return true;
        else if (character == '[') return true;
        else                       return false;
    }
    
    /**
     * determines if the character is a math closing brace ) } ]
     * @param character the character to check
     * @return is math closing brace (true) or not (false)
     */
    private static boolean isRightBrace(Character character) {
        if      (character == ')') return true;
        else if (character == '}') return true;
        else if (character == ']') return true;
        else                       return false;
    }

    /** 
     * determines if to brace characters are matching brace types
     * @param opening the opening brace ( { [
     * @param closing the closing brace ) } ]
     * @return they match (true) or not (false)
     */
    private static boolean isMatchingBrace(Character opening, Character closing) {
        if      (opening == '(' && closing == ')') return true;
        else if (opening == '{' && closing == '}') return true;
        else if (opening == '[' && closing == ']') return true;
        else                                       return false;
    }

    /**
     * compares if the source operator is of higher priority (using math
     * order of operations) than the target operator (*,/,+,-)
     * @param source the source math operator 
     * @param target the target math operator 
     * @return the source is higher priority (true) or not (false)
     */
    private static int isHigherPriority(Character source, Character target) {        
        if (source == '*') {
            if      (target == '*') return EQUAL_PRIORITY; 
            else if (target == '/') return EQUAL_PRIORITY;
            else if (target == '+') return HIGHER_PRIORITY;
            else if (target == '-') return HIGHER_PRIORITY;
            else                    return LOWER_PRIORITY;
        }
        else if (source == '/') {
            if      (target == '*') return EQUAL_PRIORITY; 
            else if (target == '/') return EQUAL_PRIORITY;
            else if (target == '+') return HIGHER_PRIORITY;
            else if (target == '-') return HIGHER_PRIORITY;
            else                    return LOWER_PRIORITY;
        }
        if (source == '+') {
            if      (target == '*') return LOWER_PRIORITY; 
            else if (target == '/') return LOWER_PRIORITY;
            else if (target == '+') return EQUAL_PRIORITY;
            else if (target == '-') return EQUAL_PRIORITY;
            else                    return LOWER_PRIORITY;
        }
        if (source == '-') {
            if      (target == '*') return LOWER_PRIORITY; 
            else if (target == '/') return LOWER_PRIORITY;
            else if (target == '+') return EQUAL_PRIORITY;
            else if (target == '-') return EQUAL_PRIORITY;
            else                    return LOWER_PRIORITY;
        }        
        return HIGHER_PRIORITY;
    }

    /**
     * determines if the character is a math brace () {} []
     * @param character the character to check
     * @return is a math brace (true) or not (false)
     */
    private static boolean isBrace(Character character) {
        if (isLeftBrace(character) || 
            isRightBrace(character)) return true;
        else return false;
    }
        
}
