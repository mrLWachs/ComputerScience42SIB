
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
        
        Simulator.comment("Learn about error traps");                
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
            "There once was a GME stock",
            "As it aged it sank like a rock",
            "A hedge fund wanted to profit",
            "But the stock rose like a rocket"
        };
        
        String word = "acolyte";
        
        try {
            // Creating instances (objects) of file handling classes
            String first  = "C:\\Users\\lawrence.wachs\\Desktop\\";
            String middle = "data";
            String last   = ".txt";
            String name   = first + middle + last;
            // connect the two classes with the file name
            FileWriter  writer  = new FileWriter(name);
            PrintWriter printer = new PrintWriter(writer);
            // Now Write to the file
            printer.print(word);
            // Sever (close) the connection to the file
            printer.close();
        } 
        catch (Exception e) {
            
        }
        
        
        
        
        
        
        
        
        
        
        
                        
        Simulator.header("Permanent Storage Test completed!");
    }   

}
