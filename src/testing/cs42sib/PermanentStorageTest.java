
/** required package class namespace */
package testing.cs42sib;

/** required imports */
import io.Simulator;
import io.System;



/**
 * PermanentStorageTest.java - tests the concepts learned in this unit
 *
 * @author Mr. Wachs
 * @since Jan. 14, 2020, 8:01:03 a.m.
 */
public class PermanentStorageTest 
{

    /**
     * Default constructor, set class properties
     */
    public PermanentStorageTest() {
        Simulator.header("Permanent Storage Test started...");
        
        Simulator.comment("learn about error traps");                
        try {
            int[] a = {1,2,3};
            a[5] = 0;            
            double number = 3 / 0;
        }
        catch (ArrayIndexOutOfBoundsException error) {
            System.out.println(error.toString());
        }
        catch (ArithmeticException error) {
            System.out.println("Math error");
        }
        
        Simulator.comment("Now some file handling");
        
        Simulator.comment("Create data to use");        
        String[] poem = {
            "I should probably sleep",  
            "And you should too",
            "But who needs sleep",
            "When you have nothing to do"
        };
        
        String word = "Sneezel";
        
        
        
        
        
        
        
        
        
        
        
        
        
                        
        Simulator.header("Permanent Storage Test completed!");
    }   

}
