
/** Required package class namespace */
package testing.cs42sib.collections.example;

/** Required imports */
import collections.LinkedList;
import io.Dialogs;
import io.FileHandler;
import java.io.File;
import tools.Numbers;


/**
 * Example.java - This is a simple example of how to use the in-class 
 * developed to demonstrate the use of:
 *      - LinkedList class (ADT storing a list)
 *      - Dialogs class (for input/output user dialogs)
 *      - Numbers class (for random numbers)
 *      - FileHandler class (for saving and opening files for permanent storage)
 *
 * @author Mr. Wachs 
 * @since Mar. 10, 2021 
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
        Dialogs dialog  = new Dialogs(); 
        Numbers numbers = new Numbers();
        FileHandler<LinkedList<Integer>> handler = new FileHandler<>(); 
        
        // Create instances of the lists (ADTs)        
        LinkedList<Integer> before = new LinkedList<>();
        LinkedList<Integer> after  = new LinkedList<>();
        
        // Loop through and fill the first list with random values        
        final int MAX = 10;
        for (int i = 0; i < MAX; i++) {
            Integer number = numbers.random(-MAX, MAX);
            before.add(number);
        }        
            
        // Ask the user for a file and save the first list
        File file1 = dialog.saveFile(null);        
        handler.saveObject(before, file1);    
        
        // Ask the user for a file to open and fill the second list
        File file2 = dialog.openFile(null);        
        after = (LinkedList<Integer>)handler.openObject(file2); 
        
        // Output the two lists to compare them
        System.out.println("Before: " + before.toString()); 
        System.out.println("After:  " + after.toString());
    }

}
