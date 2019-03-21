
/** required package class namespace */
package testing.cs40s.permanentstorage;

/** required imports */
import collections.LinkedList;
import io.FileHandler;
import testing.cs40s.advancedclasses.Athlete;
import io.System;
import io.JOptionPane;
import tools.Calculator;

/**
 * PermanentStorageTest.java - the unit test to test the concept of permanent 
 * storage
 *
 * @author Mr. Wachs 
 * @since 22-Feb-2019 
 */
public class PermanentStorageTest 
{

    /**
     * Default constructor for the class, sets class properties
     */
    public PermanentStorageTest() {
                
        System.out.header("Permanent storage starting...");
                
        String firstName  = "C:\\Users\\lawrence.wachs\\Desktop\\";
        String middleName1 = "data1";
        String middleName2 = "data2";
        String middleName3 = "data3";
        String middleName4 = "data4";
        
        String lastName   = ".txt"; //.jmetb";
        
        String filename1   = firstName + middleName1 + lastName;
        String filename2   = firstName + middleName2 + lastName;
        String filename3   = firstName + middleName3 + lastName;
        String filename4   = firstName + middleName4 + lastName;
        
        String data       = "word";
        
        FileHandler fileHandler = new FileHandler();
        
        fileHandler.save(data,filename1);        
        String newData = fileHandler.open(filename1);
        
        System.out.println(data);
        System.out.println(newData);
        
        System.out.println("...");
        
        String lines[] = {
            "The cat sat",
            " on a red mat",
            " with a fat",
            " bat on it's lap!"
        };
        
        fileHandler.save(lines,filename2);        
        String newLines[] = fileHandler.openArray(filename2);
        
        for (String newLine : newLines) {
            System.out.println(newLine);
        }
        
        LinkedList<String> list = new LinkedList<>();
        list.add("Wachs teaches the best");
        list.add("or the worst");
        list.add("at Sturgeon");
        
        fileHandler.save(list, filename3);
        
        LinkedList<String> newList = fileHandler.openList(filename3);
        
        for (int i = 0; i < newList.size(); i++) {
            System.out.println(newList.get(i));
        }
        
        JOptionPane.simulateJFileChoser("Simulating saving and opening "
                + "with a file chooser");
//        String information = JOptionPane.showInputDialog("Enter data");    
//        JFileChooser chooser = new JFileChooser();
//        chooser.showSaveDialog(null);
//        File file = chooser.getSelectedFile();
//        fileHandler.save(information, file);        
//        chooser.showOpenDialog(null);
//        File newFile = chooser.getSelectedFile();        
//        String newInformation = fileHandler.open(newFile);
//        System.out.println(information);
//        System.out.println(newInformation);        
        
        System.out.println("Trying to save an object...\n\n");

        LinkedList<Athlete> athletes = new LinkedList<>();
        for (int i = 0; i < 500; i++) {
            String  name   = Calculator.random(5);
            int     age    = Calculator.random(18, 29);
            boolean gender = Calculator.random();
            int     number = Calculator.random(100,999);
            Athlete athlete = new Athlete(name,age,gender,number);
            athletes.add(athlete);
        }
        
        fileHandler.saveObject(athletes, filename4);
        
        LinkedList<Athlete> newAthletes = 
                (LinkedList<Athlete>)fileHandler.openObject(filename4);
        
        System.out.println(athletes);
        System.out.println(newAthletes);
        
        System.out.header("Permanent storage complete!");
    }

}
