
/** required package class namespace */
package testing.cs42sib;

/** required imports */
//import io.JOptionPane;
import io.Simulator;
import java.io.File;
//import io.System;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;



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
        
        String first  = "C:\\Users\\lawrence.wachs\\Desktop\\"; // File path
        String middle = "data";                                 // File name
        String last   = ".txt";                                 // Extention
        String name   = first + middle + last;                  // Full name
        
        Simulator.comment("Write one piece of data to that permanent file");
        try {
            
            // Create instance (objects) of file classes
            // and connect the 2 classes with the file name 
            Simulator.comment("Create instance (objects) of file classes");
            Simulator.comment("and connect the 2 classes with the file name");
            
            FileWriter  writer  = new FileWriter(name);     // First object
            PrintWriter printer = new PrintWriter(writer);  // Second object
            
            // Now Write to the file
            Simulator.comment("Now Write to the file");
            
            printer.print(word);                            // Write to file
            
            // Sever (close) the connection to the file
            Simulator.comment("Sever (close) the connection to the file");
            
            printer.close();                                // Close connection
        } 
        catch (IOException e) {
            System.out.println("File write error");
        }
        
        // Now involve the user in naming the file
        // get the file name from the user
        
        // Simpliest input from a scanner or dialog...
        // Scanner scanner = new Scanner(System.in);        
        // name = scanner.nextLine();
        // name = JOptionPane.showInputDialog("Enter name");
        
        // Use a fancier input designed for files        
        JFileChooser chooser = new JFileChooser();
        chooser.showSaveDialog(null);
        
        // Use a File class to work with as well
        File file = chooser.getSelectedFile();
        
        // check the file
        if (file != null || file.exists()) {
            
            // Now the try catch block...            
            try {
                
                
            } 
            catch (IOException e) {
                System.out.println("File save error");
            }
                        
        }
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        // Example continues...
        Simulator.comment("Example continues...");
        
        Simulator.header("Permanent Storage Test completed!");
    }   

}
