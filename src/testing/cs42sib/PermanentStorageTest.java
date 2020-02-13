
/** required package class namespace */
package testing.cs42sib;

/** required imports */
import io.JFileChooser;
import io.Scanner;
import collections.LinkedList;
import io.FileHandler;
import io.Simulator;
import io.System;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
//import javax.swing.JFileChooser;
//import java.util.Scanner;
import testing.cs40s.advancedclasses.Genie;
import tools.Text;


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
        
        Simulator.comment("File handling example...");   
        Simulator.comment("Create some data to use...");
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
        Simulator.comment("Please type in phrase below:");  
        Scanner scanner = new Scanner(java.lang.System.in);   // create scanner
        String  phrase  = scanner.nextLine();                 // read in a line
        
        Simulator.comment("A dialog for choosing the file to save to...");
        JFileChooser chooser = new JFileChooser();      // graphic dialog object
        chooser.showSaveDialog(null);                   // show the save dialog
        File file = chooser.getSelectedFile();          // get the user file 
        if (file != null || file.exists()) {            // error check
            try {                                              
                FileWriter writer = new FileWriter(file);
                PrintWriter print = new PrintWriter(writer);
                print.println(phrase);                          // save to file
                print.close();                                  // close file
            } 
            catch (IOException e) {
                System.out.println("Save error");
            }
        }
        
        Simulator.comment("Now use another dialog to open the same file...");       
        chooser.showOpenDialog(null);                   // show the open dialog
        file = chooser.getSelectedFile();               // get the user file
        if (file != null && file.exists()) {            // error check
            try {
               FileReader     reader = new FileReader(file);
               BufferedReader buffer = new BufferedReader(reader);
               phrase = buffer.readLine();                      // read file      
               buffer.close();                                  // close file
            } catch (IOException e) {
                System.out.println("Open error");
            }            
        }
        System.out.println(phrase);                             // output data
        
        Simulator.comment("Create some complete objects to save and open...");
        Text text = new Text();                         // for random names
        LinkedList<Genie> genies = new LinkedList<>();  // collection of genies
        for (int i = 0; i < 100; i++) {                 // loop 100 times
            String name = text.randomWord();            // random name for genie
            genies.add(new Genie(name));                // add new genie to list
        }
        FileHandler handler = new FileHandler();        // filehandler object
        handler.saveObject(genies, "genies.abc");       // save collection
        LinkedList<Genie> jeans = 
                (LinkedList<Genie>)handler.openObject("genies.abc");    // open
        System.out.println(genies.toString());          // output both lists
        System.out.println(jeans.toString());           // to compare
        System.out.println(genies.equals(jeans));
        
        Simulator.comment("Some other methods from the FileHandler class...");
        Simulator.comment("Create some new sample data to use..."); 
        String before                 = "word";
        String after                  = "";
        String add                    = "more";
        String filename               = "file1.txt";
        File   dataFile               = new File("file2.txt");
        String[] beforeArray          = { before, before };
        String[] afterArray           = null;
        LinkedList<String> beforeList = new LinkedList<>(beforeArray);
        LinkedList<String> afterList  = null;
        
        Simulator.comment("Save one piece of data to file, and open...");
        handler.save(before, filename);
        after = handler.open(filename);
        System.out.println("before = " + before);
        System.out.println("after  = " + after);
        
        Simulator.comment("Save an array of data to file, and open...");
        handler.save(beforeArray, dataFile);
        afterArray = handler.openArray(dataFile);
        System.out.println("before = " + text.toString(beforeArray));
        System.out.println("after  = " + text.toString(afterArray));
        
        Simulator.comment("Save a list of data to file, and open...");
        handler.save(beforeList, dataFile);
        afterList = handler.openList(dataFile);        
        System.out.println("before = " + beforeList.toString());
        System.out.println("after  = " + afterList.toString());
        
        Simulator.comment("Now test append (single data and list) to file..");
        handler.append(add, filename);
        handler.append(add, dataFile);
        
        after     = handler.open(filename);
        afterList = handler.openList(dataFile);
        
        System.out.println("Before = " + before);
        System.out.println("After  = " + after);
        System.out.println("Before = " + beforeList.toString());
        System.out.println("After  = " + afterList.toString());
        
        Simulator.comment("Opening files as ASCII characters...");
        
        Simulator.comment("The ASCII integer values...");
        LinkedList<Integer> ascii = handler.openASCIICollection(filename);
        System.out.println(ascii.toString());
        
        Simulator.comment("The ASCII character values...");
        LinkedList<Character> characters = handler.openCharCollection(dataFile);        
        for (int i = 0; i < characters.size(); i++) {
            System.out.println(i + " = " + characters.get(i));
        }
                        
        Simulator.header("Permanent Storage Test completed!");
    }   

}
