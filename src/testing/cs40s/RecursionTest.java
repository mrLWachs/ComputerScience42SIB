
/** required package class namespace */
package testing.cs40s;

/** required imports */
import numbers.Calculator;
import testing.Output;

/**
 * RecursionTest.java - tests the concepts learned in this unit
 *
 * @author Mr. Wachs 
 * @since Sep 19, 2017 
 * @instructor Mr. Wachs
 */
public class RecursionTest 
{

    /** 
     * Default constructor for the class 
     */
    public RecursionTest() {
        Output.header("Recursion unit test",true,false);
        Output.show("Recursive Factorial:");
        final int MIN_FACORIAL = -1;
        final int MAX_FACORIAL = 21;
        for (int i = MIN_FACORIAL; i <= MAX_FACORIAL; i++) {
            long number = Calculator.factorial(i);
            Output.show(i + " factorial = " + number);
        }
        Output.show("Recursive Powers:");
        final int MIN_POWER = -10;
        final int MAX_POWER = 10;
        for (int base = MIN_POWER; base <= MAX_POWER; base++) {
            for (int exponent = MIN_POWER; exponent <= MAX_POWER; exponent++) {
                double answer = Calculator.power(base, exponent);
                Output.show(base + " to the power of " +
                        exponent + " = " + answer);
            }
        }
        Output.header("Recursion unit test",false,false);
    }

}
