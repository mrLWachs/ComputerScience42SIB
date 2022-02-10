
/** Required package class namespace */
package testing.cs42sib;

/** Required imports */
import io.Simulator;


/**
 * PermanentStorageTest.java - tests the concepts learned in this unit
 *
 * @author Mr. Wachs
 * @since Feb. 9, 2022, 8:01:03 a.m.
 */
public class PermanentStorageTest 
{

    /**
     * Default constructor, set class properties
     */
    public PermanentStorageTest() {
        Simulator.header("Permanent Storage Test started...");
        
        // Learn about "error traps"................................
        
        try {       // Opening the "try" block (means "try this code")
            // This is the "trap" we set to "try" some code, and if
            // an error occurs (of the type we are catching for) we
            // "catch" that error and program keeps running
            double number = 3 / 0;
            int[] a = {1,2,3};
            a[5] = 0;            
        }
        catch(ArrayIndexOutOfBoundsException error) {   // catch block
            // so if an erro occurs in the "try" block of the type we
            // defined (array out of bounds..) the program will not shut down,
            // instead it will jump (branch) to this block (the catch block)
            System.out.println(error.toString());            
        }
        catch (ArithmeticException error) {
            // You can add multiple "catch" blocks
            System.out.println(error.toString());
        }
          
        // Now some file handling.............................................
        
        String[] poem = {
            "There once was a GME stock",
            "As it aged it sank like a rock",
            "A hedge fund wanted to profit",
            "But the stock rose like a rocket"
        };
        
        String word = "acolyte";
        
        
        // Let's create a proper file name
        
        String first  = "C:\\Users\\lawrence.wachs\\Desktop\\";
        String middle = "data";
        String last   = ".txt";
        
        String name = first + middle + last;
        
        
        
        
        
        
        
        
        
        
        
        Simulator.header("Permanent Storage Test completed!");
    }   

}
