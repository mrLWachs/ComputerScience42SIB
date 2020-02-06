
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
        
        Simulator.comment("Error trap examples...");
        
        try {
            double number = Math.PI / 0;            
            int[] a = { 1, 2, 3 };
            a[5] = 5;  
        }
        catch (ArithmeticException error) {
            System.out.println(error.toString());
        }
        catch (ArrayIndexOutOfBoundsException error) {
            System.out.println(error.toString());
        }
        
        Simulator.comment("File handling...");
        
        String[] poem = {
          "I should probably sleep",  
          "And you should too",
          "But who needs sleep",
          "When you have nothing to do"
        };
        
        String word = "Sneezel";
        
        // set up the error trap
       
        try {
            // creating instances (objects) of class
            FileWriter  writer  = new FileWriter("data.txt");
            PrintWriter printer = new PrintWriter(writer);
            printer.println(word);
            for (String line : poem) {
                printer.println(line);
            }
            printer.close();            
        } catch (IOException e) {
            System.out.println("File error");
        }
        
        // now read the data from the file (open)
        
        try {
            FileReader     reader = new FileReader("data.txt");
            BufferedReader buffer = new BufferedReader(reader);
            LinkedList<String> lines = new LinkedList<>();
            String line = buffer.readLine();
            while (line != null) {
                lines.add(line);
                line = buffer.readLine();
            }
            System.out.println(lines.toString());
            buffer.close();            
        } catch (IOException e) {
            System.out.println("File error");
        }
        
        // involve the user        
        Scanner scanner = new Scanner(java.lang.System.in);
        String  phrase  = scanner.nextLine();
        
        // now we need a file to save it in
        JFileChooser chooser = new JFileChooser();
        chooser.showSaveDialog(null);
        
        // output the phrase again
        System.out.println(phrase);
       
        
        
        Simulator.header("Permanent Storage Test completed!");
    }   

}
