
/** Required package class namespace */
package testing.cs42sib;

/** Required imports */
//import io.JOptionPane;
import io.System;
import collections.LinkedList;
import io.FileHandler;
import io.Simulator;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
//import javax.swing.JFileChooser;
import io.JFileChooser;
import testing.testclass.TestClass;



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
        
        // Write one piece of data to that permanent file......................
        Simulator.comment("Write one piece of data to that permanent file");
        
        try {            
            // Create instance (objects) of file classes.......................
            // and connect the 2 classes with the file name....................
            Simulator.comment("Create instance (objects) of file classes");
            Simulator.comment("and connect the 2 classes with the file name");
            
            FileWriter  writer  = new FileWriter(name);     // First object
            PrintWriter printer = new PrintWriter(writer);  // Second object
            
            // Now Write to the file...........................................
            Simulator.comment("Now Write to the file");
            
            printer.print(word);                            // Write to file
            
            // Sever (close) the connection to the file........................
            Simulator.comment("Sever (close) the connection to the file");
            
            printer.close();                                // Close connection
        } 
        catch (IOException error) {                         // catch error
            System.out.println("File write error");         // output message
        }
        
        // Now involve the user in naming the file.............................
        Simulator.comment("Now involve the user in naming the file");  
        // Simpliest input from a scanner or dialog...
        // Scanner scanner = new Scanner(System.in);        
        // name = scanner.nextLine();
        // name = JOptionPane.showInputDialog("Enter name");        
        // Use a fancier input designed for files..............................
        Simulator.comment("Use a fancier input designed for files"); 
        
        JFileChooser chooser = new JFileChooser();
        chooser.showSaveDialog(null);           // Showing a dialog to user
        
        // Use a File class to work with as well...............................
        Simulator.comment("Use a File class to work with as well"); 
        
        File file = chooser.getSelectedFile();  // Get the name from the user
        
        // Check the file......................................................
        Simulator.comment("Check the file"); 
        
        if (file != null || file.exists()) {    // Error check on the file         
            try {                               // Now the try catch block...   
                FileWriter  writer  = new FileWriter(file);    // Connect file
                PrintWriter printer = new PrintWriter(writer); // Connect writer
                for (String line : poem) {      // Enhanced loop through array
                    printer.println(line);      // Writing one array index 
                }
                printer.close();                // Sever (close) file connection
            } 
            catch (IOException error) {                 // Catch error
                System.out.println("File save error");  // Message user
            }                        
        }
        
        // Now open files (for one line).......................................
        Simulator.comment("Now open files (for one line)"); 
        
        chooser.showOpenDialog(null);                               // Dialog
        file = chooser.getSelectedFile();                           // Get file
        if (file != null || file.exists()) {                        // Check
            name = file.getAbsolutePath();                          // Name
            try {                                                   // block
                FileReader     reader = new FileReader(name);       // Connect
                BufferedReader buffer = new BufferedReader(reader); // Connect
                String line = buffer.readLine();                    // Read
                buffer.close();                                     // Close
                System.out.println(line);                           // Output
            } 
            catch (IOException error) {                             // Catch
                System.out.println("File open error");              // Message
            }
        }
        
        // Do it again with the array (multiple lines).........................
        Simulator.comment("Do it again with the array (multiple lines)");
        
        chooser.showOpenDialog(null);
        file = chooser.getSelectedFile();
        if (file != null || file.exists()) { 
            try {
                FileReader     reader = new FileReader(file);
                BufferedReader buffer = new BufferedReader(reader);
                String line = buffer.readLine();    // Read first line
                while (line != null) {              // Keep reading til no input
                    System.out.println(line);       // Output line
                    line = buffer.readLine();       // Read next line
                }
                buffer.close();
            } 
            catch (IOException error) {
                System.out.println("File open error");
            }
        }
        
        // Now save and open without the user involved.........................
        Simulator.comment("Now save and open without the user involved ");                 
        // Create a constant for the size of the list..........................
        Simulator.comment("Create a constant for the size of the list");
        
        final int SIZE = 10;
        
        // Create and fill a list of random objects............................
        Simulator.comment("Create and fill a list of random objects");
        
        LinkedList<TestClass> before = new LinkedList<>();  // Create list
        for (int i = 0; i < SIZE; i++) {                    // Traverse list
            before.add(new TestClass(SIZE));                // Add object
        }
            
        // output the list (before saving)
        System.out.println(before.toString());
        
        try {
            
            // Create a temporary file object on the system....................
            Simulator.comment("Create a temporary file object on the system");
            file = new File("data3");                   
            
            // Make sure it exists, or create it...............................
            Simulator.comment("Make sure it exists, or create it");
            if (!file.exists()) file.createNewFile();   

            // Create the filehandler object...................................
            Simulator.comment("Create the filehandler object");
            FileHandler<LinkedList<TestClass>> handler = new FileHandler<>();
            
            // Use the handler to save the entire list of class objects........
            Simulator.comment("Use handler to save entire class objects list");
            handler.saveObject(before, file);
            
            // Use to open the entire list (return it).........................
            Simulator.comment("Use to open the entire list (return it)");
            LinkedList<TestClass> after = handler.openObject(file);
            
            // Output the new lit to compare with original.....................
            Simulator.comment("Output the new lit to compare with original");
            System.out.println(after.toString());

            // Delete the file we were using from the system...................
            Simulator.comment("Delete the file we were using from the system");
            file.delete();                            
        }
        catch (IOException error) {
            System.out.println("Error " + error.toString());
        }
        
        // Create objects that could be useful from this project...............
        Simulator.comment("Objects that could be useful from this project");
        //Dialogs dialog  = new Dialogs();
        //Numbers numbers = new Numbers();
        //Text    text    = new Text();
          
        Simulator.header("Permanent Storage Test completed!");
    }   

}
