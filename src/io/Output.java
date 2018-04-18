
/** required package class namespace */
package io;

import collections.LinkedList;
import java.awt.Color;
import java.io.File;

/**
 * Output.java - description here...
 *
 * @author lawrence.wachs 
 * @since Nov 14, 2017 
 * @instructor Mr. Wachs
 */
public class Output
{
      
    private static UI ui = new UI(); 
    private static FileHandler<String> fileHandler;
    private static LinkedList<String> outputLines;
    private static File tempFile;
    
    
    public static void init() {
        outputLines = new LinkedList<>();
        fileHandler = new FileHandler<>();
        String filename = System.getProperty("user.dir") + "\\outputData.txt";       
        tempFile = new File(filename);
    }
    
    private final static String[] FONTS = {
        "Consolas",
        "Trebuchet MS",
        "Tahoma",
        "Bookman Old Style",
    };
       
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
    
    public static void comment(Object object) {
        if (object == null) return;
        String text = object.toString();  
        add("// " + text + " ...",FONTS[0],Color.green);
    }
        
    public static void show(Object object) {
        if (object == null) object = new String("null");
        add(object.toString(),FONTS[0],Color.white);
    }
    
    public static void dialog(Object object) {
        if (object == null) object = new String("null");
        add("~~~SIMULATED DIALOG: " + object.toString(),FONTS[0],Color.magenta);
    }
    
    public static void ui(Object object) {
        if (object == null) object = new String("null");
        add("~~~SIMULATED USER INTERFACE: " + object.toString(),FONTS[0],Color.cyan);
    }
    
    public static void error(String errorType) {
        System.out.println(errorType + " error has occured!");
    }
    
    public static void flush() {  
        fileHandler.save(outputLines, tempFile);
        for (int i = 0; i < outputLines.size(); i++) {
            ui.add(outputLines.get(i));
        }
        ui.setVisible(true);
    }    
    
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
    
    private static String htmlFormat(String text, String fontFamily, Color color) {
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
    
    public static<T> String arrayToString(T[] array) {
        String text = "[";
        for (int i = 0; i < array.length-1; i++) {
            text += array[i].toString() + ",";
        }
        return text + array[array.length-1].toString() + "]";
    }    
        
}










        
        
