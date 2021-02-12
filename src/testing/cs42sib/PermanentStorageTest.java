
/** required package class namespace */
package testing.cs42sib;

/** required imports */
import io.Simulator;
import io.System;
import java.io.FileWriter;
import java.io.PrintWriter;



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
        
        // Learn about error traps............................................
        Simulator.comment("Learn about error traps"); 
        
        try {                                               // Open try block
            double number = 3 / 0;                          // Try for an error
            int[] a = {1,2,3};                              // Create array
            a[5] = 0;                                       // Try another error            
        }                                                   // Close try block
        catch (ArrayIndexOutOfBoundsException error) {      // Catch clause
            System.out.println(error.toString());           // Output error
        }
        catch (ArithmeticException error) {                 // Catch clause
            System.out.println("Math error");               // Output error
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
        
        String first  = "C:\\Users\\lawrence.wachs\\Desktop\\";
        String middle = "data";
        String last   = ".txt";
        String name   = first + middle + last;
        
        Simulator.comment("Write one piece of data to that permanent file");
        try {
            
            // Create instance (objects) of file classes
            // and connect the 2 classes with the file name 
            Simulator.comment("Create instance (objects) of file classes");
            Simulator.comment("and connect the 2 classes with the file name");
            
            FileWriter  writer  = new FileWriter(name);     // first object
            PrintWriter printer = new PrintWriter(writer);  // second object
            
            // Now Write to the file
            Simulator.comment("Now Write to the file");
            
            printer.print(word);                            // Write to file
            
            // Sever (close) the connection to the file
            Simulator.comment("Sever (close) the connection to the file");
            
            printer.close();                                // Close connection
        } 
        catch (Exception e) {
            
        }
        
        
        
                        
        Simulator.header("Permanent Storage Test completed!");
    }   

}
