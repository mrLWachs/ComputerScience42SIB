
/** required package class namespace */
package testing.cs40s.permanentstorage;

import collections.LinkedList;
import io.FileHandler;
import io.Output;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import testing.cs40s.advancedclasses.Athlete;
import tools.Randomizer;



/**
 * PermanentStorageTest.java - 
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
        
        
        Output.show("\nFiles starting...\n");
        
        
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
        
        Output.show(data);
        Output.show(newData);
        
        Output.show("...");
        
        String lines[] = {
            "The cat sat",
            " on a red mat",
            " with a fat",
            " bat on it's lap!"
        };
        
        fileHandler.save(lines,filename2);        
        String newLines[] = fileHandler.openArray(filename2);
        
        for (String newLine : newLines) {
            Output.show(newLine);
        }
        
        LinkedList<String> list = new LinkedList<>();
        list.add("Wachs teaches the best");
        list.add("or the worst");
        list.add("at Sturgeon");
        
        fileHandler.save(list, filename3);
        
        LinkedList<String> newList = fileHandler.openList(filename3);
        
        for (int i = 0; i < newList.size(); i++) {
            Output.show(newList.get(i));
        }
        
        String information = JOptionPane.showInputDialog("Enter data");        
        JFileChooser chooser = new JFileChooser();
        chooser.showSaveDialog(null);
        File file = chooser.getSelectedFile();
        fileHandler.save(information, file);        
        chooser.showOpenDialog(null);
        File newFile = chooser.getSelectedFile();        
        String newInformation = fileHandler.open(newFile);
        Output.show(information);
        Output.show(newInformation);
        
        
        Output.show("Trying to save an object...\n\n");

        LinkedList<Athlete> athletes = new LinkedList<>();
        for (int i = 0; i < 500; i++) {
            String  name   = Randomizer.generate(5);
            int     age    = Randomizer.generate(18, 29);
            boolean gender = Randomizer.generate();
            int     number = Randomizer.generate(100,999);
            Athlete athlete = new Athlete(name,age,gender,number);
            athletes.add(athlete);
        }
        
        fileHandler.saveObject(athletes, filename4);
        
        LinkedList<Athlete> newAthletes = (LinkedList<Athlete>)fileHandler.openObject(filename4);
        
        Output.show(athletes);
        Output.show(newAthletes);
        
        
        
        Output.show("\nFiles complete!\n");
    }

}
