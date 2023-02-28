
/** Required package class namespace */
package testing.cs42sib;

/** Required API imports */
import io.Simulator;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JFileChooser;


/**
 * PermanentStorageTest.java - tests the concepts learned in this unit. Apps 
 * you have previously created stored data in memory as primitive data 
 * structures (e.g. variables and arrays), more advanced data structures 
 * (e.g. classes), or even abstract dynamic data structures (e.g. 
 * collections). Problem with this is that they are only temporary (once the 
 * device’s power is off the data is lost - called “volatile” data). To save 
 * permanently, we need to create or open a file on the device’s file system 
 * and write data from data structures into that file (called “non-volatile” 
 * data). Once your app restarts, it opens the file and reads the data out 
 * and back into the memory data structures of the app. Every computing 
 * device (e.g. desktop, laptop, tablet, smart phone, game console, smart 
 * car, etc.) has a file system which is organized and controlled by that 
 * device’s operating system (OS). Most of these OS file systems access a 
 * permanent (non-volatile) medium (like a hard drive, etc.) which can store 
 * non-volatile data. Although each OS has unique qualities, many of the 
 * protocols (rules) used are similar. For example, the way files are named 
 * must be unique. Files are separate from your application but connected 
 * to it (to read/write data to/from the file). Complex apps can be 
 * associated with multiple files that might be reading and/or writing to 
 * multiple files at the same time – and, multiple applications might access 
 * the same file(s). 
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
               
        // Create data to use..................................................        
        String[] poem = {
            "I look at my watch for the hour",
            "But I find it has run out of power",
            "I yell out Oh No!",
            "I have got to go!",
            "For I fear that the milk has gone sour"
        };                                                  // Student poem....
        String word = "Defenestration";                     // Student word....     
                
        // Let's create a proper file NAME.....................................
        String first  = "C:\\temp\\";   // File "Path" (e.g. "c:/my docs...")
        String middle = "data";         // File name (e.g. "essay")
        String last   = ".txt";         // File extention (e.g. ".doc" ".txt")
        String name   = first + middle + last; // Full Name (3 parts concatinated)
        
        // Write ONE piece of data (the word) to that permanent file............
        
        try {
            // Create instance (object) of the classes needed and connect the 
            // 2 classes with the file name we just made........................
            FileWriter  writer  = new FileWriter(name);   // First object
            PrintWriter printer = new PrintWriter(writer);
            // Now write to the file............................................
            printer.print(word);        // Call class method to write to file..   
            // Sever (disconnect) from the file.................................
            printer.close();                                // Close connection
        } 
        catch (IOException error) {                         // catch error.....
            System.out.println("File write error");        // output message..
        }
        
        // Now involve the user in naming of a file.............................
        
        // We could get input from the user using very simple input like 
        // Scanner or a simple JOptionPane input dialog like this...............
        
        // Scanner scanner = new Scanner(System.in);
        // name = scanner.nextLine();
        // name = JOptionPane.showInputDialog("Enter name");
                
        // Or we could build a GUI and use a textbox, but instead, we will use
        // something new that is already built for ths..........................
        
        JFileChooser chooser = new JFileChooser();
        chooser.showSaveDialog(null);           // Showing a dialog to user....
        
        // We will also use a "File" class object to work with as well.........
        File file = chooser.getSelectedFile();  // Get the name from the user
                
        // Check the file the user just selected...............................
        if (file == null) {                     // Error check on the file.....   
            // Means the user hit cancel or ok without selecting, etc..........
            System.out.println("Please name a file");
        }
        else {
            if (!file.exists()) {
                // The file does not exist so we create it......................
                try {
                    FileWriter  writer  = new FileWriter(file);    // Link file
                    PrintWriter printer = new PrintWriter(writer); // and writer
                    // Use the enhanced for loop - which you can read as...
                    // "for every line in poem"
                    for (String line : poem) {  // Enhanced loop through array..  
                        printer.println(line);      // Writing one array index..
                    }
                    printer.close();            // Sever (close) file connection  
                } 
                catch (IOException error) {                 // Catch error.....
                    System.out.println("File save error");  // Message user....
                }
            }
            else {
                // The file already does exist.................................    
                System.out.println("File alread exists!");
            }
        }     
                
               
        
        
        
        
        
        
        
        
        
        
        
                
                
                
                
        
        Simulator.header("Permanent Storage Test completed!");
    }   

}
