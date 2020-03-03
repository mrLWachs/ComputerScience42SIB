
/** required package class namespace */
package testing.sampleIA.userinterfaces;

/** required imports */
import java.awt.List;
import java.io.File;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;
import collections.LinkedList;
import io.Dialogs;
import io.FileHandler;
import tools.Search;
import tools.Sort;
import tools.Images;
import testing.sampleIA.memedatabase.Meme;

 
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
    private FileHandler<LinkedList<Meme>> fileHandler = new FileHandler<>(dialog);
    
    
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
            Images.resizeToContainer(memeImageLabel);   // resize to label
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

    /**
     * User has clicked a button to delete the keyword selected in the listbox
     */
    public void deleteSelectedKeyword() {
        int index = keywordsList.getSelectedIndex();    // index selected
        if (index != -1) {                              // valid index
            if (dialog.yesNo("Are you sure you want to "
                           + "delete the selected keyword?")) { // confirm
                keywordsList.remove(index);             // remove from listbox
                if (keywords != null) keywords.remove(index);   // and from list
            }
        }
    }

    /**
     * User has clicked a button to save all meme information into the meme list
     */
    public void saveMeme() {
        date   = dateCreatedTextbox.getText();      // get text from the textbox
        author = authorTextbox.getText();           // get text from the textbox
        if (date == null) {                         // date is not valid
            dialog.output("Please enter a date!");  // dialog to user
            dateCreatedTextbox.requestFocus();      // set focus to textbox
        }
        else if (author == null) {                  // author is not valid
            dialog.output("Please enter an author!");   // dialog to user
            authorTextbox.requestFocus();           // set focus to textbox
        }
        else if (file == null) {                    // image file is not valid
            dialog.output("Please select an image file!");  // dialog to user
            memeImageLabel.requestFocus();          // set focus to textbox
        }
        else {                                      // all entries valid
            Meme meme = new Meme(file, author, date, keywords); // create meme
            list.add(meme);                         // add meme to list
            memesList.add(meme.toString());         // add meme to listbox
            clearFields();                          // clear all fields
        }
    }

    /**
     * User has clicked a button to clear all the fields for making a new 
     * meme (to start over)
     */
    public void clearFields() {
        memeImageLabel.setIcon(null);       // remove any image from label
        dateCreatedTextbox.setText("");     // clear out textboxes
        authorTextbox.setText("");
        keywordTextbox.setText("");
        keywordsList.removeAll();           // clear out the listbox
        date   = null;                      // set global properties to nulls
        author = null;
        file   = null;
        if (keywords != null) {             // clear and set list to null
            keywords.clear();
            keywords = null;
        }
    }

    /**
     * User has clicked a button to edit a meme, so it returns to the creation 
     * area so the user can change values and then save it again
     */
    public void editSelectedMeme() {
        int index = memesList.getSelectedIndex();       // index selected
        if (index != -1) {                              // valid index
            clearFields();                              // clear out fields
            Meme meme = list.get(index);                // get meme from list
            file   = meme.pictureFile;                  // get meme properties
            author = meme.author;
            date   = meme.dateCreated;
            if (meme.keywords != null) {                // get keywords if valid
                keywords = new LinkedList<>();          // instantiate
                for (int i = 0; i < meme.keywords.size(); i++) {    // traverse
                    keywords.add(meme.keywords.get(i));     // assign to list
                }
            }
            String path = file.getAbsolutePath();   // get path to the file
            Icon   icon = new ImageIcon(path);      // create icon to display
            memeImageLabel.setIcon(icon);           // assign icon to label
            Images.resizeToContainer(memeImageLabel);   // resize to label
            dateCreatedTextbox.setText(date);       // set date to textbox
            authorTextbox.setText(author);          // set author to textbox
            if (keywords != null) {                 // keywords list is valid
                for (int i = 0; i < keywords.size(); i++) { // traverse
                    keywordsList.add(keywords.get(i));  // add to listbox
                }
            }
            memesList.remove(index);                // remove from memes listbox
            list.remove(index);                     // remove from memes list
        }   
    }

    /**
     * User has clicked a button to delete the meme selected in the listbox
     */
    public void deleteSelectedMeme() {
        int index = memesList.getSelectedIndex();       // index selected
        if (index != -1) {                              // index is valid
            if (dialog.yesNo("Are you sure you want to "
                           + "delete the selected meme?")) {    // confirm
                memesList.remove(index);                // remove from listbox
                list.remove(index);                     // remove from list
            }
        }
    }

    /**
     * User has clicked a button to sort the memes list into alpha order
     */
    public void sortMemes() {
        sort.bubble(list);                          // sort into alpha order
        memesList.removeAll();                      // clear out listbox
        for (int i = 0; i < list.size(); i++) {     // traverse list
            memesList.add(list.get(i).toString());  // add to listbox
        }
    }

    /**
     * User has clicked a button to search all memes in the list for a keyword
     */
    public void searchMemes() {
        String searchText = dialog.input("Enter word to search for");   // word
        searchText = searchText.toLowerCase();      // convert to lowercase
        int index = -1;                             // assume not found
        for (int i = 0; i < list.size(); i++) {     // traverse list
            Meme meme = list.get(i);                // get a meme from list
            String words = meme.toString();         // convert meme to string
            words = words.toLowerCase();            // convert to lowercase
            if (words.contains(searchText)) {       // see if word is in text
                index = i;                          // meme location found
                i = list.size();                    // exit loop
            }
        }
        if (index != -1) memesList.select(index);   // select found in listbox
        else             dialog.output(searchText + " not found!"); // prompt
    }

    /**
     * User has clicked a button to save the memes list to a permanent file
     */
    public void saveMemeList() {
        file = dialog.saveFile(userInterface);  // dialog and save list to file
        if (file != null && list != null) fileHandler.saveObject(list, file);
    }

    /**
     * User has clicked a button to open a memes list from a permanent file
     */
    public void openMemeList() {
        file = dialog.openFile(userInterface);  // dialog and file to open list
        if (file != null) {                     // valid file chosen
            list = (LinkedList<Meme>)fileHandler.openObject(file);  // get list
            if (list != null) {                 // valid list
                memesList.removeAll();          // clear out listbox
                for (int i = 0; i < list.size(); i++) {     // traverse list
                    Meme   meme = list.get(i);              // get meme
                    String text = meme.toString();          // convert to text
                    memesList.add(text);                    // add to listbox
                }
            }
        }
    }

}
