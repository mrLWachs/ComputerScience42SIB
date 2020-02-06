
/** required package class namespace */
package testing.cs42sib;

/** required imports */
import collections.LinkedList;
import io.Simulator;
import io.System;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JFileChooser;
import java.util.Scanner;


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
        
        Simulator.comment("Error trap examples, using the try...catch block");        
        try {                                               // open try block
            double number = Math.PI / 0;                    // try for error
            int[] a = { 1, 2, 3 };                          // create array
            a[5] = 5;                                       // try for error
        }                                                   // close try block
        catch (ArithmeticException error) {                 // catch clause
            System.out.println(error.toString());           // output error
        }
        catch (ArrayIndexOutOfBoundsException error) {      // catch clause
            System.out.println(error.toString());           // output error
        }
        
        Simulator.comment("File handling example, by creating data to use");        
        String[] poem = {
          "I should probably sleep",  
          "And you should too",
          "But who needs sleep",
          "When you have nothing to do"
        };                                                  // student poem        
        String word = "Sneezel";                            // student word
        
        Simulator.comment("First we try to write data to the file (save)...");
        try {                                               // open try block
            // creating instances (objects) of file handling classes
            FileWriter  writer  = new FileWriter("data.txt");  
            PrintWriter printer = new PrintWriter(writer);
            printer.println(word);                          // write to file
            for (String line : poem) {                      // traverse array
                printer.println(line);                      // write to file
            }
            printer.close();                        // close connection to file
        } catch (IOException e) {                           // error clause
            System.out.println("File writing error");       // output error
        }
        
        Simulator.comment("Now we read the same data from the file (open)...");
        try {
            FileReader     reader = new FileReader("data.txt");
            BufferedReader buffer = new BufferedReader(reader);
            LinkedList<String> lines = new LinkedList<>();      // to hold lines
            String line = buffer.readLine();                    // read a line
            while (line != null) {                  // read until no more lines
                lines.add(line);                                // add to list
                line = buffer.readLine();                    // read next line
            }
            System.out.println(lines.toString());               // output list
            buffer.close();                        // close connection to file
        } catch (IOException e) {                               // error clause
            System.out.println("File read error");              // input error
        }
        
        Simulator.comment("Now we will involve the user...");
        Simulator.comment("Using basic standard input (scanner)");        
        Scanner scanner = new Scanner(java.lang.System.in);   // create scanner
        String  phrase  = scanner.nextLine();                 // read in a line
        
        Simulator.comment("A dialog for choosing the file to save to...");
        JFileChooser chooser = new JFileChooser();
        chooser.showSaveDialog(null);
        
        // output the phrase again
        System.out.println(phrase);
       
        
        
        Simulator.header("Permanent Storage Test completed!");
    }   

}
