
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
        Simulator.comment("Learn about 'error traps'........................");
        
        try {  
            // Opening the "try" block (means "try this code"), this is the 
            // "trap" we set to "try" some code, and if an error occurs (of 
            // the type we are catching for) we "catch" that error and the  
            // program keeps running
            Simulator.comment("Opening the 'try' block (means 'try this ");
            Simulator.comment("code'), this is the 'trap' we set to ");
            Simulator.comment("'try' some code, and if an error occurs (of");
            Simulator.comment("the type we are catching for) we 'catch' that");
            Simulator.comment("error and the program keeps running");
                        
            double number = 3 / 0;
            int[] a = {1,2,3};
            a[5] = 0;            
        }
        catch(ArrayIndexOutOfBoundsException error) { 
            // Open the "catch" block, so if an error occurs in the "try" block
            // of the type we defined (array out of bounds..) the program will 
            // not shut down, instead it will jump (branch) to this block (the 
            // catch block)
            Simulator.comment("Open the 'catch' block, so if an error occurs");
            Simulator.comment("in the 'try' block of the type we defined");
            Simulator.comment("(array out of bounds..) the program will not");
            Simulator.comment("shut down, instead it will jump (branch) to");
            Simulator.comment("this block (the catch block");
                        
            System.out.println(error.toString());            
        }
        catch (ArithmeticException error) {
            // You can add multiple "catch" blocks
            Simulator.comment("You can add multiple 'catch' blocks");
            
            System.out.println(error.toString());
        }
          
        // Now some file handling..............................................
        Simulator.comment("Now some file handling");                
        // Create data to use..................................................
        Simulator.comment("Create data to use"); 
        
        String[] poem = {
            "There once was a GME stock",
            "As it aged it sank like a rock",
            "A hedge fund wanted to profit",
            "But the stock rose like a rocket"
        };                                                  // Student poem
        String word = "acolyte";                            // Student word
        
        // Let's create a proper file name.....................................
        Simulator.comment("Let's create a proper file name");
        
        String first  = "C:\\Users\\lawrence.wachs\\Desktop\\"; // File path
        String middle = "data";                                 // File name
        String last   = ".txt";                                 // Extention
        String name   = first + middle + last;                  // Full name
        
        // Write one piece of data to that permanent file......................
        Simulator.comment("Write one piece of data to that permanent file");
        
        
        
        
        
        
        
        
        
        
        
        
        Simulator.header("Permanent Storage Test completed!");
    }   

}
