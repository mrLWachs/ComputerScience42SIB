
/** required package class namespace */
package testing.sampleIA.memedatabase;

/** required imports */
import testing.sampleIA.userinterfaces.MainUI;


/**
 * MemeDatabase.java - an application to database internet "memes". It allows
 * users to find images and enter information about the date created, the 
 * author of the meme, and keywords describing the meme. These memes are stored
 * in a database that can be saved to a file, opened, sorted, searched, and 
 * modified.
 *
 * @author Mr. Wachs
 * @since Mar. 2, 2020, 9:56:01 a.m.
 */
public class MemeDatabase 
{

    /**
     * Main method for the project
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new MainUI();               // instantiate main user interface
    }

}
