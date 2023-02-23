
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

        // Learn about "error traps"...........................................   
        
        try {
            // Opening the "try" block (means "try this code"), this is the 
            // "trap" we set to "try" some code, and if an error occurs (of 
            // the type we are catching for) we "catch" that error and the  
            // program keeps running.......................................... 
            double number = 3 / 0;
            int[] a = { 1, 2, 3 };
            a[5] = 0;
        }
        catch (ArithmeticException error) {
            // Open the "catch" block, so if an error occurs in the "try" block
            // of the type we defined (divide by zero..) the program will 
            // not shut down, instead it will jump (branch) to this block (the 
            // catch block).................................................... 
            System.out.println("Divide by zero -> " + error.toString());
        }
        catch (ArrayIndexOutOfBoundsException error) {
            // You can add multiple "catch" blocks.............................    
            System.out.println("Array was out of bounds -> " + error.toString());
        }       
                
        // Now some file handling..............................................
               
                
                
                
                
                
                
                
                
                
                
                
                
                
                
        
        Simulator.header("Permanent Storage Test completed!");
    }   

}
