
/** required package class namespace */
package testing.sampleIA.userinterfaces;

/** required imports */
import java.awt.List;
import java.io.File;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;
import testing.sampleIA.collections.LinkedList;
import testing.sampleIA.io.Dialogs;
import testing.sampleIA.io.FileHandler;
import testing.sampleIA.memedatabase.Meme;
import testing.sampleIA.tools.Search;
import testing.sampleIA.tools.Sort;

 
/**
 * MainUIController.java - this is a class that "controls" the main user 
 * interface logic. By separating this logic from the user interfaces visual 
 * (or "view") we are following a pattern like the "MVC" software design 
 * pattern which is commonly used for developing user interfaces which divides 
 * the related program logic. This is done to separate internal representations 
 * of information from the ways information is presented to and accepted from 
 * the user. This is one style of programming paradigm that is expanded on in 
 * post secondary studies in Computer Science (but is not necessary for I.B. or
 * high school Computer Science in general).
 *
 * @author Mr. Wachs
 * @since Mar. 2, 2020, 10:20:16 a.m.
 */
public class MainUIController 
{
    
    // properties linked from the view 
    private JLabel     memeImageLabel;      // label for pictures
    private JTextField dateCreatedTextbox;  // textbox for date
    private JTextField authorTextbox;       // textbox for author name
    private JTextField keywordTextbox;      // textbox to enter a keyword
    private List       keywordsList;        // listbox for all entered keywords
    private List       memesList;           // listbox for all entered memes
    private MainUI     userInterface;       // the frame user interface
    
    // properties for use when one meme is created
    private File               file     = null;     // stores the picture file
    private String             keyword  = null;     // stores a keyword
    private String             author   = null;     // stores the author name
    private String             date     = null;     // stores the date
    private LinkedList<String> keywords = null;     // stores all keywords
    
    // property to store all memes in a dynamic list
    private LinkedList<Meme> list = new LinkedList<>();
    
    // properties for functions like searching, sorting, dialogs, files, etc.
    private Dialogs                       dialog      = new Dialogs("Meme database",userInterface);
    private Search                        search      = new Search();
    private Sort                          sort        = new Sort();    
    private FileHandler<LinkedList<Meme>> fileHandler = new FileHandler<>();

    
    /**
     * Class constructor, set class properties
     * 
     * @param memeImageLabel label for pictures
     * @param dateCreatedTextbox textbox for date
     * @param authorTextbox textbox for author name
     * @param keywordTextbox textbox to enter a keyword
     * @param keywordsList listbox for all entered keywords
     * @param memesList listbox for all entered memes
     * @param userInterface the frame user interface
     */
    public MainUIController(
            JLabel     memeImageLabel, 
            JTextField dateCreatedTextbox, 
            JTextField authorTextbox, 
            JTextField keywordTextbox, 
            List       keywordsList, 
            List       memesList, 
            MainUI     userInterface) {
        // connect (link) all parameters to global properties
        this.memeImageLabel     = memeImageLabel;
        this.dateCreatedTextbox = dateCreatedTextbox;
        this.authorTextbox      = authorTextbox;
        this.keywordTextbox     = keywordTextbox;
        this.keywordsList       = keywordsList;
        this.memesList          = memesList; 
        this.userInterface      = userInterface;
        // set some values for the user interface and display
        userInterface.setSize(600, 750);                // set size
        userInterface.setResizable(false);              // no resizing
        userInterface.setTitle("Meme database");        // set title
        userInterface.setLocationRelativeTo(null);      // center on screen
        userInterface.setVisible(true);                 // display frame
    }

    /**
     * User has clicked a button and wants to select a meme image
     */
    public void selectImage() {
        file = dialog.openFile(userInterface);      // get file from open dialog 
        if (file != null) {                         // valid file selected
            String path = file.getAbsolutePath();   // get path to the file
            Icon   icon = new ImageIcon(path);      // create icon to display
            memeImageLabel.setIcon(icon);           // assign icon to label
        }
    }

    /**
     * User has clicked a button to enter a keyword into the list of keywords
     */
    public void enterKeyword() {
        keyword = keywordTextbox.getText();             // get text from textbox
        if (keyword != null && !keyword.equals("")) {       // valid text
            if (keywords == null || keywords.isEmpty()) {   // list is empty
                keywords = new LinkedList<>();              // create list
            }
            keywords.add(keyword);                      // add to list
            keywordsList.add(keyword);                  // add to listbox
            keywordTextbox.setText("");                 // set textbox empty
            keywordTextbox.requestFocus();              // set focus to textbox
            keyword = null;                             // set property to null
        }
    }

    public void deleteSelectedKeyword() {
        int index = keywordsList.getSelectedIndex();
        
    }

    public void saveMeme() {
        
    }

    public void clearFields() {
        
    }

    public void editSelectedMeme() {
        
    }

    public void deleteSelectedMeme() {
        
    }

    public void sortMemes() {
                
    }

    public void searchMemes() {
        
    }

    public void saveMemeList() {
        
    }

    public void openMemeList() {
        
    }

}
