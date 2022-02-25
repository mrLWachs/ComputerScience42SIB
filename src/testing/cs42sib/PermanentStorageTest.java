
/** Required package class namespace */
package testing.cs42sib;

/** Required imports */
import collections.LinkedList;
import io.Dialogs;
import io.FileHandler;
import io.Simulator;
import io.JFileChooser;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
//import javax.swing.JFileChooser;
import testing.cs40s.advancedclasses.Doctor;
import tools.Text;


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
            int[] a = {1,2,3};
            a[5] = 0;            
        }
        catch(ArrayIndexOutOfBoundsException error) {             
            // Open the "catch" block, so if an error occurs in the "try" block
            // of the type we defined (array out of bounds..) the program will 
            // not shut down, instead it will jump (branch) to this block (the 
            // catch block)....................................................            
            System.out.println(error.toString());            
        }
        catch (ArithmeticException error) {            
            // You can add multiple "catch" blocks.............................            
            System.out.println(error.toString());
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
        
        // Let's create a proper file name.....................................        
        String first  = "C:\\Users\\lawrence.wachs\\Desktop\\"; // File path...
        String middle = "data";                                 // File name...
        String last   = ".txt";                                 // Extention...
        String name   = first + middle + last;                  // Full name...
        
        // Write one piece of data to that permanent file......................        
        try {
            // Create instance (object) of the classes needed and connect the 
            // 2 classes with the file name....................................            
            FileWriter  writer  = new FileWriter(name);     // First object....
            PrintWriter printer = new PrintWriter(writer);  // Second object...            
            // Now write to the file...........................................            
            printer.print(word);        // Call class method to write to file..            
            // Sever (close) the connection to the file........................            
            printer.close();                                // Close connection            
        } 
        catch (IOException error) {                         // catch error.....
            System.out.println("File write error");         // output message..
        }
        
        // Now involve our user in naming the file.............................
        
        // We could get input from the user using very simple input like using
        // Scanner or a simple JOptionPane input dialog like this..............
        
        // Scanner scanner = new Scanner(System.in);
        // name = scanner.nextLine();
        // name = JOptionPane.showInputDialog("Enter name");
        
        // Or we could build a GUI and use a textbox, but instead, we will use 
        // something new that is already built for this........................ 
        JFileChooser chooser = new JFileChooser();
        chooser.showSaveDialog(null);           // Showing a dialog to user....
        
        // We will also use a File class object to work with as well...........        
        File file = chooser.getSelectedFile();  // Get the name from the user
              
        // Check the file......................................................        
        if (file == null) {                     // Error check on the file.....            
            // Means the user hit a cancel or similar..........................            
            System.out.println("Please name a file");
        }
        else {
            if (!file.exists()) {                
                // The file does not exist so we create it.....................                
                try {
                    FileWriter  writer  = new FileWriter(file);    // Link file
                    PrintWriter printer = new PrintWriter(writer); // and writer
                    // Read as "for every line in poem" or we could have:
                    // "for (int i = 0; i < poem.length; i++) ".................                        
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
                System.out.println("File already Exits!");
            }
        }
        
        // Now open the files (for the one with one line)......................        
        try {                                                   // Open try....
            FileReader     reader = new FileReader(name);       // Connect.....
            BufferedReader buffer = new BufferedReader(reader); // Connect..... 
            String line = buffer.readLine();                    // Read line...
            System.out.println("line read was " + line);        // Output line.
            buffer.close();                                     // Close connect
        } catch (IOException e) {}    // You do not need to respond to the error      
        
        // Do it again with the array (multiple lines).........................        
        try {                                                   // Open try....
            chooser.showOpenDialog(null);
            file = chooser.getSelectedFile();
            FileReader     reader = new FileReader(file);       // Connect.....
            BufferedReader buffer = new BufferedReader(reader); // Connect.....            
            String line = buffer.readLine();                    // Read line...       
            while (line != null) {                  // Loop until no inputs left
                System.out.println("This line read was " + line); // Output....
                line = buffer.readLine();                       // Read again..
            }
            buffer.close();                                     // Close connect            
        } catch (IOException e) {}    // You do not need to respond to the error
        
        // We can use a pre-built class (from Mr. Wachs but you can modify it
        // or not use it) to to the same thing (save and open).................
        
        // Instantiate (make an object) the file handler.......................        
        FileHandler fileHandler = new FileHandler();
        
        // We can call any of the methods to do what we need...................        
        fileHandler.save(word, name);        
        String newWord = fileHandler.open(name);
        
        // Compare the before and after........................................        
        System.out.println("Before: " + word);
        System.out.println("After : " + newWord);
        
        // Now with the array of data, we create a save dialog (using another 
        // class available to you).............................................        
        Dialogs dialog = new Dialogs();
        file = dialog.saveFile(null);
        fileHandler.save(poem, file);
        file = dialog.openFile(null);
        String[] newPoem = fileHandler.openArray(file);
        
        // Compare the before and after (and use another class "tool" to help).        
        Text text = new Text();
        System.out.println("Before: " + text.toString(poem));
        System.out.println("After : " + text.toString(newPoem));
        
        // Now we want to save "anything" to a file (for save and open)........
        
        // Make a variable of "anything", or array of ("anythings", or a 
        // collection (LinkedList) of "anythings"..............................
        
        // Create a Doctor object..............................................        
        Doctor doctor = new Doctor();
        
        // Save this class object data to a file, open it, and compare.........                
        fileHandler.saveObject(doctor, name);
        Doctor newDoctor = (Doctor) fileHandler.openObject(name);        
        System.out.println("Before: " + doctor.toString());
        System.out.println("After : " + newDoctor.toString());        
        
        // Now take it up to an entire collection of class level objects all 
        // put into a linked list collection and then dave the entire list to
        // a file, open the entire list, and compare the two lists.............                
        LinkedList<Doctor> doctors = new LinkedList<>();
        
        // Traverse up to 100 doctor objects (instances), creating Doctor 
        // objects, assign them random names, and then adding that instance to
        // the list............................................................        
        for (int i = 0; i < 100; i++) {
            Doctor doc = new Doctor();
            doc.name = text.randomWord();
            doctors.add(doc);
        }
        
        // Save the list to the file, open the list, and compare...............        
        fileHandler.saveObject(doctors, file);
        LinkedList<Doctor> newDoctors;
        newDoctors = (LinkedList<Doctor>)fileHandler.openObject(file);        
        System.out.println("Before: " + doctors.toString());
        System.out.println("After : " + newDoctors.toString());
        
        // End of file handling................................................
        Simulator.header("Permanent Storage Test completed!");
    }   

}
