

/** required package class namespace */
package testing.sampleIA.userinterfaces;

import java.awt.List;
import javax.swing.JLabel;
import javax.swing.JTextField;

 
/**
 * MainUIController.java - description
 *
 * @author Mr. Wachs
 * @since Mar. 2, 2020, 10:20:16 a.m.
 */
public class MainUIController 
{
    
    private JLabel     memeImageLabel;
    private JTextField dateCreatedTextbox;
    private JTextField authorTextbox;
    private JTextField keywordTextbox;
    private List       keywordsList;
    private List       memesList;
    
    

    /**
     * Default constructor, set class properties
     */
    public MainUIController(
            JLabel     memeImageLabel, 
            JTextField dateCreatedTextbox, 
            JTextField authorTextbox, 
            JTextField keywordTextbox, 
            List       keywordsList, 
            List       memesList, 
            MainUI     userInterface) {
        this.memeImageLabel     = memeImageLabel;
        this.dateCreatedTextbox = dateCreatedTextbox;
        this.authorTextbox      = authorTextbox;
        this.keywordTextbox     = keywordTextbox;
        this.keywordsList       = keywordsList;
        this.memesList          = memesList;        
        userInterface.setSize(600, 750);
        userInterface.setResizable(false);
        userInterface.setLocationRelativeTo(null);
        userInterface.setVisible(true);
    }

    void selectImage() {
    }

    void enterKeyword() {
    }

    void deleteSelectedKeyword() {
    }

    void saveMeme() {
    }

    void clearFields() {
    }

    void editSelectedMeme() {
    }

    void deleteSelectedMeme() {
    }

    void sortMemes() {
    }

    void searchMemes() {
    }

    void saveMemeList() {
    }

    void openMemeList() {
    }

}
