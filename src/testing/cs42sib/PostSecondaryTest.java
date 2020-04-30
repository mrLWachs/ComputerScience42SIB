
/** required package class namespace */
package testing.cs42sib;

/** required imports */
import io.Simulator;

 
/**
 * PostSecondaryTest.java - tests the student chosen concepts 
 *
 * @author Mr. Wachs
 * @since 30-Apr-2020, 1:43:41 PM
 */
public class PostSecondaryTest 
{

    /**
     * Default constructor, set class properties
     */
    public PostSecondaryTest() {
        Simulator.header("Post Secondary Test started...");
        
        Simulator.header("Examining Dynamic programming..."); 
        
        Simulator.comment("Creating constants...");  
        final int    START  = 1;
        final int    STOP   = 45;
        final double FACTOR = 0.001;
                
        System.out.println("We will compare two different Fibonacci"
                + " methods up to the maximum of " + STOP + "\n");
           
        Simulator.comment("Creating first time marker...");
        long start1 = System.currentTimeMillis();
        
        Simulator.comment("Testing first Fibonacci algorithm ...");        
        for (int n = START; n <= STOP; n++) {
            int a = fibonacci(n);
            System.out.println("f1(" + n + ")=" + a);
        }
        
        Simulator.comment("Ending first time marker...");
        long end1 = System.currentTimeMillis();
        double seconds1 = (end1 - start1) * FACTOR;
                
        Simulator.comment("Creating second time marker...");        
        long start2 = System.currentTimeMillis();
        
        Simulator.comment("Testing second Fibonacci algorithm ...");        
        for (int n = START; n <= STOP; n++) {
            int a = fibonacciDynamic(n);
            System.out.println("f2(" + n + ")=" + a);
        }
        
        Simulator.comment("Ending second time marker...");
        long end2 = System.currentTimeMillis();
        double seconds2 = (end2 - start2) * FACTOR;
                
        Simulator.comment("Calculating total time...");  
        System.out.println("First Fibonacci took  " + seconds1 + " seconds");
        System.out.println("Second Fibonacci took " + seconds2 + " seconds");
        double difference = seconds1 - seconds2;
        System.out.println("A difference of " + difference + " seconds");
        
        Simulator.header("Post Secondary Test completed!");
    }

    /**
     * Fibonacci sequence calculated using a recursive method
     * 
     * @param number the value to calculate up to
     * @return the Fibonacci value of the number parameter
     */
    private int fibonacci(int number) {
        if (number == 1 || number == 2) {                   // base case
            return 1;
        }
        else {                                              // recursive case
            return fibonacci(number-1) + fibonacci(number-2);   
        }
    }

    /**
     * Fibonacci sequence calculated using a dynamic programming method
     * 
     * @param number the value to calculate up to
     * @return the Fibonacci value of the number parameter
     */
    private int fibonacciDynamic(int number) {
        Integer array[] = new Integer[number+1];    // create empty array
        return fibonacciWrapper(number,array);      // call wrapper method
    }

    /**
     * Fibonacci sequence calculated using a wrapper method for dynamic 
     * programming 
     * 
     * @param number the value to calculate up to
     * @param array the array used to store results
     * @return the Fibonacci value of the number parameter
     */
    private int fibonacciWrapper(int number, Integer[] array) {
        int result = 0;                                 // store result
        if (array[number] != null) {                    // already calculated
            return array[number];
        }
        if (number == 1 || number == 2) {               // base case
            result = 1;
        }
        else {                                          // recursive case
            result = fibonacciWrapper(number-1,array) + 
                     fibonacciWrapper(number-2,array);      
        }
        array[number] = result;                         // store result
        return result;                                  // return result
    }
             
}
