
/** Required package class namespace */
package testing.cs42sib;

/** Required imports */
import io.Simulator;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JFileChooser;


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
            "I look at my watch for the hour",
            "But I find it has run out of power",
            "I yell out Oh No!",
            "I have got to go!",
            "For I fear that the milk has gone sour"
        };                                                  // Student poem
        String word = "Defenestration";                     // Student word
        
        // Let's create a proper file name.....................................
        Simulator.comment("Let's create a proper file name");
        
        String first  = "C:\\Users\\lawrence.wachs\\Desktop\\"; // File path
        String middle = "data";                                 // File name
        String last   = ".txt";                                 // Extention
        String name   = first + middle + last;                  // Full name
        
        // Write one piece of data to that permanent file......................
        Simulator.comment("Write one piece of data to that permanent file");
        
        try {
            // Create instance (object) of the classes needed
            // and connect the 2 classes with the file name
            
            FileWriter  writer  = new FileWriter(name);
            PrintWriter printer = new PrintWriter(writer);
            
            // Now write to the file            
            printer.print(word);
            
            // Sever (close) the coonection to the file
            printer.close();
            
        } 
        catch (IOException e) {
            System.out.println("File write error");
        }
        
        // Now involve our user in naming the file
        
        // Simpliest input from the user with Scanner or dialog...
        
        // Scanner scanner = new Scanner(System.in);
        // name = scanner.nextLine();
        // name = JOptionPane.showInputDialog("Enter name");
        // Or we could build a GUI and use a textbox...
        // We will use something already built for this
        
        JFileChooser chooser = new JFileChooser();
        chooser.showSaveDialog(null);
        
        // Use a File class object to work with as well
        
        File file = chooser.getSelectedFile();
                
        // Check the file
        
        if (file == null) {
            // Means the user hit a cancel or similar
            System.out.println("Please name a file");
        }
        else {
            if (!file.exists()) {
                // The file does not exist so we create it
                try {
                    FileWriter  writer  = new FileWriter(file);
                    PrintWriter printer = new PrintWriter(writer);                    
                    for (String line : poem) {
                        // Read as "for every line in poem"
                        // could have used 
                        // "for (int i = 0; i < poem.length; i++) "                        
                        printer.println(line);
                    }
                    printer.close();                    
                }
                catch (IOException e) {
                    System.out.println("Error");
                }                
            }
            else {
                // The file already does exit!
                System.out.println("File already Exits!");
            }
        }
        
        // Now open the files (for the one with one line)
        
        try {
            FileReader     reader = new FileReader(name);
            BufferedReader buffer = new BufferedReader(reader);            
            String line = buffer.readLine();            
            System.out.println("line read was " + line);            
            buffer.close();            
        } catch (IOException e) {} // You could not respond to the error      
        
        // Do it again with the array (multiple lines)
        
        try {
            chooser.showOpenDialog(null);
            file = chooser.getSelectedFile();
            FileReader     reader = new FileReader(file);
            BufferedReader buffer = new BufferedReader(reader);            
            String line = buffer.readLine();       
            while (line != null) {
                System.out.println("This line read was " + line); 
                line = buffer.readLine();
            }
            buffer.close();            
        } catch (IOException e) {} // You could not respond to the error
        
        
        
        
        
        
        
        
        
        
        
        
        Simulator.header("Permanent Storage Test completed!");
    }   

}
