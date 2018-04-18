
/** required package class namespace */
package testing.cs40s;

/** required imports */
import collections.LinkedList;
import io.Dialogs;
import io.FileHandler;
import io.Output;
import java.io.File;
import testing.cs40s.advancedclasses.FireFighter;
import testing.cs40s.advancedclasses.SpiderMan;

/**
 * PermanentStorageTest.java - tests the concepts learned in this unit
 *
 * @author Mr. Wachs  
 * @since Dec 6, 2017 
 * @instructor Mr. Wachs
 */
public class PermanentStorageTest 
{

    /** 
     * Default constructor for the class 
     */
    public PermanentStorageTest() {
        Output.header("Permanent Storage unit test",true,false);   
        Output.comment("simple string save and open");        
        FileHandler fileHandler = new FileHandler();
        String text = "Thusly";
        String fileName = "C:\\Users\\lawrence.wachs"
                + "\\Desktop\\essay.txt";        
        fileHandler.save(text,fileName);        
        String newText = fileHandler.open(fileName);        
        Output.show(text);
        Output.show(newText);        
        Output.comment("string array save and open");
        fileName = "C:\\Users\\lawrence.wachs"
                + "\\Desktop\\poem.txt";
        String[] poem = {
        "The cat",
        "sat on",
        "a hat!"
        };        
        fileHandler.save(poem, fileName);        
        String[] lines = fileHandler.openArray(fileName);        
        String output = "";
        for (String line : poem) {
            output += line + ",";
        }        
        Output.show("Before: " + output);
        output = "";
        for (String line : lines) {
            output += line + ",";
        }
        Output.show("After: " + output);                
        Output.comment("string LinkedList save and open");
        LinkedList<String> list = new LinkedList<>();
        list.add("Littler littler");
        list.add("I don't know");
        list.add("Bigger, bigger");
        list.add("Roses are red");
        Output.show(list);
        fileHandler.save(list, fileName);
        fileHandler.append("HayZus", fileName);        
        LinkedList<String> changed = fileHandler.openList(fileName);
        Output.show(changed);        
        Output.comment("Open and save dialogs test");
        Dialogs dialog = new Dialogs("Testing...");
        text = "Calvin \n Rules";        
        Output.dialog("Save dialog");
        File saveFile = new File(fileName); //dialog.saveFile(null);
        fileHandler.save(text, saveFile);
        Output.dialog("Open dialog");
        File openFile = new File(fileName); //dialog.openFile(null);
        newText = fileHandler.open(openFile);        
        Output.show(text);
        Output.show(newText);        
        Output.comment("Open as ASCII collection test");  
        LinkedList<Integer> characters = 
                fileHandler.openASCIICollection(openFile);        
        Output.show(characters);        
        LinkedList<Character> values = 
                fileHandler.openCharCollection(openFile);
        Output.show(values);                
        Output.comment("Object saving and opening");        
        Output.dialog("Save dialog");
        saveFile = new File(fileName); //dialog.saveFile(null);
        FireFighter tom = new FireFighter();        
        fileHandler.saveObject(tom, saveFile);        
        FireFighter dirk = (FireFighter) 
                fileHandler.openObject(saveFile);        
        Output.show(tom);
        Output.show(dirk);
        LinkedList<SpiderMan> spiderPeople = new LinkedList<>();
        for (int i = 0; i < 100; i++) {
            spiderPeople.add(new SpiderMan(17));
        }
        Output.dialog("Save dialog");
        saveFile = new File(fileName); //dialog.saveFile(null);
        fileHandler.saveObject(spiderPeople, saveFile);
        LinkedList<SpiderMan> spiders = 
                (LinkedList<SpiderMan>) fileHandler.openObject(saveFile);        
        Output.show(spiderPeople);
        Output.show(spiders);                
        Output.header("Permanent Storage unit test",false,false);         
    }
    
}
