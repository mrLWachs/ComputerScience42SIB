

/** required package class namespace */
package io;

import collections.LinkedList;
import java.awt.Color;
import java.io.File;



/**
 * System.java - 
 *
 * @author Mr. Wachs 
 * @since 8-Mar-2019 
 */
public class System 
{

    private static UI                  ui; 
    private static FileHandler<String> fileHandler;
    private static LinkedList<String>  outputLinesUI;
    private static LinkedList<String>  outputLinesFile;
    private static File                tempFile;
    
    private final static String[] FONTS = {
        "Consolas",
        "Trebuchet MS",
        "Tahoma",
        "Bookman Old Style",
    };
    
    // Reset
    public static final String RESET = "\033[0m";  // Text Reset

    // Regular Colors
    public static final String BLACK = "\033[0;30m";   // BLACK
    public static final String RED = "\033[0;31m";     // RED
    public static final String GREEN = "\033[0;32m";   // GREEN
    public static final String YELLOW = "\033[0;33m";  // YELLOW
    public static final String BLUE = "\033[0;34m";    // BLUE
    public static final String PURPLE = "\033[0;35m";  // PURPLE
    public static final String CYAN = "\033[0;36m";    // CYAN
    public static final String WHITE = "\033[0;37m";   // WHITE

    // Bold
    public static final String BLACK_BOLD = "\033[1;30m";  // BLACK
    public static final String RED_BOLD = "\033[1;31m";    // RED
    public static final String GREEN_BOLD = "\033[1;32m";  // GREEN
    public static final String YELLOW_BOLD = "\033[1;33m"; // YELLOW
    public static final String BLUE_BOLD = "\033[1;34m";   // BLUE
    public static final String PURPLE_BOLD = "\033[1;35m"; // PURPLE
    public static final String CYAN_BOLD = "\033[1;36m";   // CYAN
    public static final String WHITE_BOLD = "\033[1;37m";  // WHITE

    // Underline
    public static final String BLACK_UNDERLINED = "\033[4;30m";  // BLACK
    public static final String RED_UNDERLINED = "\033[4;31m";    // RED
    public static final String GREEN_UNDERLINED = "\033[4;32m";  // GREEN
    public static final String YELLOW_UNDERLINED = "\033[4;33m"; // YELLOW
    public static final String BLUE_UNDERLINED = "\033[4;34m";   // BLUE
    public static final String PURPLE_UNDERLINED = "\033[4;35m"; // PURPLE
    public static final String CYAN_UNDERLINED = "\033[4;36m";   // CYAN
    public static final String WHITE_UNDERLINED = "\033[4;37m";  // WHITE

    // Background
    public static final String BLACK_BACKGROUND = "\033[40m";  // BLACK
    public static final String RED_BACKGROUND = "\033[41m";    // RED
    public static final String GREEN_BACKGROUND = "\033[42m";  // GREEN
    public static final String YELLOW_BACKGROUND = "\033[43m"; // YELLOW
    public static final String BLUE_BACKGROUND = "\033[44m";   // BLUE
    public static final String PURPLE_BACKGROUND = "\033[45m"; // PURPLE
    public static final String CYAN_BACKGROUND = "\033[46m";   // CYAN
    public static final String WHITE_BACKGROUND = "\033[47m";  // WHITE

    // High Intensity
    public static final String BLACK_BRIGHT = "\033[0;90m";  // BLACK
    public static final String RED_BRIGHT = "\033[0;91m";    // RED
    public static final String GREEN_BRIGHT = "\033[0;92m";  // GREEN
    public static final String YELLOW_BRIGHT = "\033[0;93m"; // YELLOW
    public static final String BLUE_BRIGHT = "\033[0;94m";   // BLUE
    public static final String PURPLE_BRIGHT = "\033[0;95m"; // PURPLE
    public static final String CYAN_BRIGHT = "\033[0;96m";   // CYAN
    public static final String WHITE_BRIGHT = "\033[0;97m";  // WHITE

    // Bold High Intensity
    public static final String BLACK_BOLD_BRIGHT = "\033[1;90m"; // BLACK
    public static final String RED_BOLD_BRIGHT = "\033[1;91m";   // RED
    public static final String GREEN_BOLD_BRIGHT = "\033[1;92m"; // GREEN
    public static final String YELLOW_BOLD_BRIGHT = "\033[1;93m";// YELLOW
    public static final String BLUE_BOLD_BRIGHT = "\033[1;94m";  // BLUE
    public static final String PURPLE_BOLD_BRIGHT = "\033[1;95m";// PURPLE
    public static final String CYAN_BOLD_BRIGHT = "\033[1;96m";  // CYAN
    public static final String WHITE_BOLD_BRIGHT = "\033[1;97m"; // WHITE

    // High Intensity backgrounds
    public static final String BLACK_BACKGROUND_BRIGHT = "\033[0;100m";// BLACK
    public static final String RED_BACKGROUND_BRIGHT = "\033[0;101m";// RED
    public static final String GREEN_BACKGROUND_BRIGHT = "\033[0;102m";// GREEN
    public static final String YELLOW_BACKGROUND_BRIGHT = "\033[0;103m";// YELLOW
    public static final String BLUE_BACKGROUND_BRIGHT = "\033[0;104m";// BLUE
    public static final String PURPLE_BACKGROUND_BRIGHT = "\033[0;105m"; // PURPLE
    public static final String CYAN_BACKGROUND_BRIGHT = "\033[0;106m";  // CYAN
    public static final String WHITE_BACKGROUND_BRIGHT = "\033[0;107m";   // WHITE
    
    
   
    public static class out {
        
        public static void println(Object object) {
            output(object,true);
        }
       
        public static void println(boolean object) {
            println(new Boolean(object));
        }
        
        public static void println(int object) {
            println(new Integer(object));
        }
        
        public static void println(long object) {
            println(new Long(object));
        }
        
        public static void println(float object) {
            println(new Float(object));
        }
        
        public static void println(double object) {
            println(new Double(object));
        }
        
        public static void print(Object object) {
            output(object,true);
        }
        
        public static void print(boolean object) {
            print(new Boolean(object));
        }
        
        public static void print(int object) {
            print(new Integer(object));
        }
        
        public static void print(long object) {
            print(new Long(object));
        }
        
        public static void print(float object) {
            print(new Float(object));
        }
        
        public static void print(double object) {
            print(new Double(object));
        }
        
        public static void header(Object object) {   
            if (object == null) return;
            String text = object.toString() + line(); 
            simpleOutput("\n");
            simpleColorOutput(text, "", BLUE, RESET);
            simpleOutput("\n");
            add(text,FONTS[0],Color.blue);
        }
        
        public static void comment(Object object) {  
            if (object == null) object = new String("null"); 
            String text = "// " + object.toString();
            simpleColorOutput(text, "", YELLOW, RESET);
            add(text,FONTS[0],Color.green);
        }
        
        
        public static void dialog(Object object) {
            if (object == null) object = new String("null");
            String message = "~~~SIMULATED DIALOG: ";  
            String text    = object.toString();
            simpleColorOutput(message, text, GREEN, RESET);            
            add(message + object.toString(),FONTS[0],Color.magenta);
        }
        
        public static void ui(Object object) {
            if (object == null) object = new String("null");
            String message = "~~~SIMULATED USER INTERFACE: ";
            String text    = object.toString();
            simpleColorOutput(message, text, CYAN, RESET);            
            add(message + object.toString(),FONTS[0],Color.cyan);
        }
                
        private static void output(Object object, boolean newLine) {
            if (newLine) { 
                simpleOutput(object.toString() + "\n");
            }
            else {
                simpleOutput(object.toString());
            }
            if (object == null) object = new String("null");
            add(object.toString(),FONTS[0],Color.white);
        }
        
        private static void simpleColorOutput(String message, String text, 
                String start, String end) {
            simpleOutput("");
            simpleOutput(start + message + end);
            simpleOutput(text);
            simpleOutput("\n");
        }
        
        private static void simpleOutput(String text) {
            java.lang.System.out.print(text);
        }
        
        private static String line() {
            String text = ".";
            for (int i = 0; i < 50; i++) text += ".";
            return text;
        }
        
    }    


    /**
     * Initialize the class data structures
     */
    public static void init() {
        java.lang.System.out.println("Initializing output stream...\n\n\n");
        createDataFile();
//        createUserInterface();
    }


    /**
     * Adds all the output to the user interface and saves all the output
     * to the save file as well
     */
    public static void flush() {  
        saveDataToFile();
        outputDataToUserInterface();
        java.lang.System.out.println("\n\n\nFlushing output stream...");
    }    
    
    private static void createDataFile() {
        outputLinesUI   = new LinkedList<>();
        outputLinesFile = new LinkedList<>();
        fileHandler     = new FileHandler<>();
        String filename = java.lang.System.getProperty("user.dir") + 
                "\\outputData.html"; 
        tempFile = new File(filename);
        String pageHeader = "<html><head></head><body"
                + " style=\""
                + "background-color: black;"
                + ""
                + "\""
                + "><ol style=\""
                + "color: pink;"
                + "font-family: Consolas;"
                + "\">";
        outputLinesFile.add(pageHeader);
    }
    
    private static void createUserInterface() {
        ui = new UI();
    }
    
    private static void outputDataToUserInterface() {
        if (ui == null) return;
        for (int i = 0; i < outputLinesUI.size(); i++) {
            ui.add(outputLinesUI.get(i));
        }
        ui.setVisible(true);
    }
    
    private static void saveDataToFile() {
        if (fileHandler == null) return;
        if (outputLinesUI == null) return;
        if (tempFile == null) return;  
        outputLinesFile.add("</ol></body></html>");
        fileHandler.save(outputLinesFile, tempFile);
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
        String fileFormattedText = "";
        String uiFormattedText = "";
        
        if (text == null) {
//            formattedText = htmlFormat(text,fontFamily,color);
            outputLinesUI.add("null");
        }     
        else if (text.contains("\n")) {            
            String[] lines = text.split("[\n]");
            for (String line : lines) {
//                text = htmlFormat(text,fontFamily,color);
//                outputLinesUI.add(line);
//                
                uiFormattedText = htmlFormat(text,fontFamily,color);
                outputLinesUI.add(uiFormattedText);
                fileFormattedText = htmlLine(text,fontFamily,color);
                outputLinesFile.add("<li>" + fileFormattedText + "</li>");
            }
        }
        else {
            uiFormattedText = htmlFormat(text,fontFamily,color);
            outputLinesUI.add(uiFormattedText);
            fileFormattedText = htmlLine(text,fontFamily,color);
            outputLinesFile.add("<li>" + fileFormattedText + "</li>");
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
                    + htmlLine(text, fontFamily, color)
                + "</body>"
             + "</html>";
        return text;
    }
    
    private static String htmlLine(String text, String fontFamily, 
            Color color) {
        text = "<span style=\""
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
             + "</span>";
        return text;
    }
    
}
