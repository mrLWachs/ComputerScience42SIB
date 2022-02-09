
/** Required package class namespace */
package testing.cs42sib.collections.example;

/** Required imports */
import collections.LinkedList;
import io.Dialogs;
import io.FileHandler;
import java.io.File;
import tools.Numbers;
import tools.Text;


/**
 * Example.java - This is a simple example of how to use the in-class 
 * developed to demonstrate the use of:
 *      - LinkedList class (ADT storing a list)
 *      - Dialogs class (for input/output user dialogs)
 *      - Numbers class (for random numbers)
 *      - Text class (for random words)
 *      - FileHandler class (for saving and opening files for permanent storage)
 *
 * @author Mr. Wachs 
 * @since Feb. 9, 2022, 8:01:03 a.m.
 */
public class Example 
{

    /**
     * Main method for the application
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Create instances of the object to use...        
        Numbers numbers = new Numbers();
        Text    text    = new Text();
        Dialogs dialog  = new Dialogs(); 
        FileHandler<LinkedList<String>> handler = new FileHandler<>(); 
        
        // Create instances of the lists (ADTs)        
        LinkedList<String> before = new LinkedList<>();
        LinkedList<String> after  = new LinkedList<>();
        
        // Loop through and fill the first list with random values        
        final int MAX = 100;
        for (int i = 0; i < MAX; i++) {
            Integer number = numbers.random(1, 5);
            String  word   = text.random(number);
            before.add(word);
        }        
            
        // Ask the user for a file and save the first list
        File file1 = dialog.saveFile(null);        
        handler.saveObject(before, file1);    
        
        // Ask the user for a file to open and fill the second list
        File file2 = dialog.openFile(null);        
        after = (LinkedList<String>)handler.openObject(file2); 
        
        // Output the two lists to compare them
        System.out.println("Before: " + before); 
        System.out.println("After:  " + after);
    }

}
