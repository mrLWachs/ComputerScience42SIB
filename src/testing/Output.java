
/** required package class namespace */
package testing;

import collections.LinkedList;
import io.FileHandler;
import java.awt.Color;
import java.io.File;

/**
 * Output.java - used to create outputs for testing concepts as an
 * alternative to system outputs
 *
 * @author Mr. Wachs 
 * @since Nov 14, 2017 
 * @instructor Mr. Wachs
 */
public class Output
{
      
    private static UI ui = new UI(); 
    private static FileHandler<String> fileHandler;
    private static LinkedList<String> outputLines;
    private static File tempFile;
    
    private final static String[] FONTS = {
        "Consolas",
        "Trebuchet MS",
        "Tahoma",
        "Bookman Old Style",
    };
    
    
    /**
     * Initialize the class data structures
     */
    public static void init() {
        outputLines = new LinkedList<>();
        fileHandler = new FileHandler<>();
        String filename = System.getProperty("user.dir") + "\\outputData.txt";       
        tempFile = new File(filename);
    }
    
    /**
     * Create a header output for the start or ending
     * 
     * @param object the object to output
     * @param start whether this is a starting head (true) or not (false)
     * @param isMasterHeader is this a master header (true) or not (false)
     */
    public static void header(Object object, 
                              boolean start, 
                              boolean isMasterHeader) {
        if (object == null) return;
        String text = object.toString(); 
        Color color = Color.black;
        String fontFamily = FONTS[0];
        if (isMasterHeader) {
            color = Color.red;
            fontFamily = FONTS[1];
        }
        else {
            color = Color.blue;
            fontFamily = FONTS[2];
        }
        if (start) add(text + " started...............",fontFamily,color);
        else       add(text + " complete..............",fontFamily,color);
    }
    
    /**
     * Create an output comment 
     * 
     * @param object the object to output
     */
    public static void comment(Object object) {
        if (object == null) return;
        String text = object.toString();  
        add("// " + text + " ...",FONTS[0],Color.green);
    }
      
    /**
     * Create an output  
     * 
     * @param object the object to output
     */
    public static void show(Object object) {
        if (object == null) object = new String("null");
        add(object.toString(),FONTS[0],Color.white);
    }
    
    /**
     * Create a output to simulate a dialog box
     * 
     * @param object the object to output
     */
    public static void dialog(Object object) {
        if (object == null) object = new String("null");
        add("~~~SIMULATED DIALOG: " + object.toString(),
                FONTS[0],Color.magenta);
    }
    
    /**
     * Create a output to simulate a user interface
     * 
     * @param object the object to output
     */
    public static void ui(Object object) {
        if (object == null) object = new String("null");
        add("~~~SIMULATED USER INTERFACE: " + object.toString(),
                FONTS[0],Color.cyan);
    }
    
    /**
     * An error has been trapped and output to the system out
     * 
     * @param errorType the type of error trapped
     */
    public static void error(String errorType) {
        System.out.println(errorType + " error has occured!");
    }
    
    /**
     * Adds all the output to the user interface and saves all the output
     * to the save file as well
     */
    public static void flush() {  
        fileHandler.save(outputLines, tempFile);
        for (int i = 0; i < outputLines.size(); i++) {
            ui.add(outputLines.get(i));
        }
        ui.setVisible(true);
    }    
    
    /**
     * Adds the current text to the output LinkedList for later use in the 
     * user interface and formats the output appropriately
     * 
     * @param text the text to add to the output LinkedList
     * @param fontFamily the type of font to use
     * @param color the color of the text to use
     */
    private static void add(String text, String fontFamily, Color color) {        
        if (text == null) {
            text = htmlFormat(text,fontFamily,color);
            outputLines.add("null");
        }     
        else if (text.contains("\n")) {            
            String[] lines = text.split("[\n]");
            for (String line : lines) {
                text = htmlFormat(text,fontFamily,color);
                outputLines.add(line);
            }
        }
        else {
            text = htmlFormat(text,fontFamily,color);
            outputLines.add(text);
        }
    }    
    
    /**
     * Formats the passed text into an appropriate HTML format
     * 
     * @param text the text to format
     * @param fontFamily the font to use
     * @param color the color to use
     * @return the HTML formatted text
     */
    private static String htmlFormat(String text, String fontFamily, 
                                                  Color color) {
        text = "<html>"
                + "<head>"
                + "</head>"
                + "<body>"
                    + "<span style=\""
                       + "color: rgb("
                           + color.getRed() + "," 
                           + color.getGreen() + "," 
                           + color.getBlue()
                       + ");"
                       + "font-family: "
                           + fontFamily 
                       + ";"
                    + "\">" 
                    + text 
                    + "</span>"
                + "</body>"
             + "</html>";
        return text;
    }
    
    /**
     * Formats the generic array into an output able string format
     * 
     * @param <T> the generic data type
     * @param array the array to format
     * @return a formatted array for output
     */
    public static<T> String arrayToString(T[] array) {
        String text = "[";
        for (int i = 0; i < array.length-1; i++) {
            text += array[i].toString() + ",";
        }
        return text + array[array.length-1].toString() + "]";
    }    
        
}

