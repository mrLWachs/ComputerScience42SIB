
/** required package class namespace */
package testing.exampleinternalassessment;

/** required imports */
import collections.LinkedList;
import io.Dialogs;
import java.io.File;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * UIController.java - controls the logic engine for the user interface
 * 
 * @author Mr. Wachs
 * @since Mar 13, 2017
 * @instructor Mr. Wachs
 */
public class UIController 
{

    private JButton                  exitButton;
    private JButton                  saveEntryButton;
    private JButton                  cancelButton;
    private JButton                  editSelectedButton;
    private JButton                  deleteSelectedButton;
    private JButton                  newEntryButton;
    private JButton                  openEntriesButton;
    private JButton                  sortEntriesButton;
    private JButton                  saveEntriesButton;
    private JLabel                   nameLabel;
    private JLabel                   informationLabel;
    private JLabel                   ageLabel;
    private JList<String>            entriesList;
    private JRadioButton             maleRadio;
    private JRadioButton             femaleRadio;
    private JScrollPane              informationScrollPane;
    private JScrollPane              entriesScrollPane;
    private JSpinner                 ageSpinner;
    private JTextArea                informationText;
    private JTextField               nameText;
    private MainUI                   mainUI;  
    private DefaultListModel<String> listModel;
    private Dialogs                  dialogs;
    private boolean                  isNewEntry; 
    private boolean                  isListOpen;
    private final int                FRAME_WIDTH  = 790;
    private final int                FRAME_HEIGHT = 320;    
    private final String             APP_TITLE    = "Database";
         
    
    /**
     * class constructor sets class properties
     * 
     * @param exitButton reference to the exit button
     * @param saveEntryButton reference to the save button
     * @param cancelButton reference to the cancel button
     * @param editSelectedButton reference to the edit selected button
     * @param deleteSelectedButton reference to the delete selected button
     * @param newEntryButton reference to the new entry button
     * @param openEntriesButton reference to the open entries button
     * @param sortEntriesButton reference to the sort entries button
     * @param saveEntriesButton reference to the save entries button
     * @param nameLabel reference to the name label 
     * @param informationLabel reference to the information label
     * @param ageLabel reference to the age label
     * @param entriesList reference to the entries list box
     * @param maleRadio reference to the male radio button
     * @param femaleRadio reference to the female radio button
     * @param informationScrollPane reference to the information scroll pane
     * @param entriesScrollPane reference to the entries scroll pane
     * @param ageSpinner reference to the age spinner
     * @param informationText reference to the information text area
     * @param nameText reference to the name text field
     * @param mainUI reference to the main user interface frame
     */
    public UIController(
            JButton exitButton,
            JButton saveEntryButton,
            JButton cancelButton, 
            JButton editSelectedButton, 
            JButton deleteSelectedButton, 
            JButton newEntryButton, 
            JButton openEntriesButton, 
            JButton sortEntriesButton, 
            JButton saveEntriesButton, 
            JLabel nameLabel, 
            JLabel informationLabel, 
            JLabel ageLabel, 
            JList<String> entriesList, 
            JRadioButton maleRadio, 
            JRadioButton femaleRadio, 
            JScrollPane informationScrollPane, 
            JScrollPane entriesScrollPane, 
            JSpinner ageSpinner, 
            JTextArea informationText, 
            JTextField nameText, 
            MainUI mainUI) {
        this.exitButton            = exitButton;
        this.saveEntryButton       = saveEntryButton;
        this.cancelButton          = cancelButton;
        this.editSelectedButton    = editSelectedButton;
        this.deleteSelectedButton  = deleteSelectedButton;
        this.newEntryButton        = newEntryButton;
        this.openEntriesButton     = openEntriesButton;
        this.sortEntriesButton     = sortEntriesButton;
        this.saveEntriesButton     = saveEntriesButton;
        this.nameLabel             = nameLabel;
        this.informationLabel      = informationLabel;
        this.ageLabel              = ageLabel;
        this.entriesList           = entriesList;
        this.maleRadio             = maleRadio;
        this.femaleRadio           = femaleRadio;
        this.informationScrollPane = informationScrollPane;
        this.entriesScrollPane     = entriesScrollPane;
        this.ageSpinner            = ageSpinner;
        this.informationText       = informationText;
        this.nameText              = nameText;
        this.mainUI                = mainUI;          
        dialogs                    = new Dialogs(APP_TITLE);
        listModel                  = new DefaultListModel<>();        
        isListOpen                 = false;
        isNewEntry                 = false;
        entriesList.setModel(listModel);
        updateUI(null);
        mainUI.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        mainUI.setResizable(false);
        mainUI.setTitle(APP_TITLE);
        mainUI.setLocationRelativeTo(null);
        mainUI.setVisible(true);
    }

    /**
     * sets the gender radio buttons to the gender
     * 
     * @param isMale true means a male, false a female
     */
    public void setGender(boolean isMale) {
        if (isMale) {
            maleRadio.setSelected(true);
            femaleRadio.setSelected(false);
        }
        else {
            maleRadio.setSelected(false);
            femaleRadio.setSelected(true);
        }
    }
    
    /**
     * gets the name text from the text field
     * 
     * @return text in the name text field
     */
    public String getName() {
        return nameText.getText();
    }
    
    /**
     * gets the gender from the radio buttons
     * 
     * @return true (male) or false (female)
     */
    public boolean getGender() {
        return maleRadio.isSelected();
    }
    
    /**
     * gets the age integer from the spinner
     * 
     * @return age in the spinner
     */
    public int getAge() {
        return (Integer)ageSpinner.getValue();
    }

    /**
     * gets the information text from the text area
     * 
     * @return text in the information text area
     */
    public String getInformation() {
        return informationText.getText();
    }
    
    /**
     * gets the item selected in the list box
     * 
     * @return the selected entry in the list box (or null)
     */
    public int getSelectedEntry() {
        return entriesList.getSelectedIndex();
    }
    
    /**
     * determines if the user has completed the entry area properly
     * 
     * @return has been completed (true) or not (false)
     */
    public boolean isValidEntry() {
        if (nameText.getText() == null ||
            nameText.getText().equals("")) {
            dialogs.show("Name value must be filled in!");
            return false;
        }        
        else if (maleRadio.isSelected() == false &&
                 femaleRadio.isSelected() == false) {
            dialogs.show("A gender must be selected!");
            return false;
        }
        else if ((Integer)ageSpinner.getValue() <= 0) {
            dialogs.show("A valid age must be selected!");
            return false;
        }
        if (informationText.getText() == null ||
            informationText.getText().equals("")) {
            dialogs.show("Information must be filled in!");
            return false;
        } 
        return true;
    }
    
    /**
     * determines if the user has selected an entry from the list box
     * properly
     * 
     * @return has been selected (true) or not (false)
     */
    public boolean isValidSelected() {
        int selected = entriesList.getSelectedIndex();
        if (selected == -1) {
            dialogs.show("Please select an entry to edit!");
            return false;
        }
        else {
            return true;            
        }
    }
    
    /**
     * determines if this is a new entry or an edited entry
     * 
     * @return new entry (true) or edited entry (false)
     */
    public boolean isNewEntry() {
        return isNewEntry;
    }

    /**
     * determines if a list has been created or opened
     * 
     * @return list has been created or opened (true) or not (false)
     */
    public boolean isValidList() {
        return isListOpen;
    }
       
    /**
     * updates all user interface areas when not entering/editing an entry
     * 
     * @param entries the data for all the entries
     */
    public void updateUI(LinkedList<Entry> entries) {
        nameText.setText("");                       // reset entry fields
        setGender(true);
        ageSpinner.setValue(0);
        informationText.setText("");  
        newEntryButton.setEnabled(true);            // enable some actions
        openEntriesButton.setEnabled(true); 
        saveEntriesButton.setEnabled(false);        // disable list/actions
        sortEntriesButton.setEnabled(false); 
        saveEntryButton.setEnabled(false);          // disable entry actions
        cancelButton.setEnabled(false);
        editSelectedButton.setEnabled(false);       // disable list/actions
        deleteSelectedButton.setEnabled(false);
        entriesList.setEnabled(false);
        nameLabel.setEnabled(false);                // disable entry fields
        ageLabel.setEnabled(false);
        informationLabel.setEnabled(false);
        nameText.setEnabled(false);                 // disable entry fields
        maleRadio.setEnabled(false);
        femaleRadio.setEnabled(false);
        ageSpinner.setEnabled(false);
        informationText.setEnabled(false);
        if (entries == null || entries.isEmpty()) { // update list area
            isListOpen = false;
        }
        else {
            saveEntriesButton.setEnabled(true);     // enable main list actions
            sortEntriesButton.setEnabled(true); 
            editSelectedButton.setEnabled(true);    // enable list/actions
            deleteSelectedButton.setEnabled(true);
            entriesList.setEnabled(true);
            isListOpen = true;                      // flag list as open
            listModel.removeAllElements();          // traverse, add entries
            for (int i = 0; i < entries.size(); i++) {
                listModel.addElement(entries.get(i).toString());
            }
            int length = listModel.getSize()-1;
            entriesList.ensureIndexIsVisible(length);                        
        }        
    }
    
    /** sets the user interface for a new entry */
    public void addEntry() {
        addEntry("",true,0,"",true);
    }
        
    /**
     * sets the user interface for adding/editing an entry
     * @param name the name to set to the text field
     * @param isMale the gender to set the radio button to
     * @param age the age to set the spinner to
     * @param information the information to set to the text area
     * @param isNewEntry a new entry (true) or edited entry (false)
     */
    public void addEntry(String name, boolean isMale, 
            int age, String information, boolean isNewEntry) {
        this.isNewEntry = isNewEntry;
        nameText.setText(name);                 // reset entry fields
        setGender(isMale);
        ageSpinner.setValue(age);
        informationText.setText(information);  
        newEntryButton.setEnabled(false);       // disable some main actions
        openEntriesButton.setEnabled(false);   
        saveEntriesButton.setEnabled(false);    // disable main list actions
        sortEntriesButton.setEnabled(false); 
        saveEntryButton.setEnabled(true);       // enable entry actions
        cancelButton.setEnabled(true);
        editSelectedButton.setEnabled(false);   // disable list/actions
        deleteSelectedButton.setEnabled(false);
        entriesList.setEnabled(false);
        nameLabel.setEnabled(true);             // enable entry fields
        ageLabel.setEnabled(true);
        informationLabel.setEnabled(true);
        nameText.setEnabled(true);              // enable entry fields
        maleRadio.setEnabled(true);
        femaleRadio.setEnabled(true);
        ageSpinner.setEnabled(true);
        informationText.setEnabled(true);
    }
    
    /** exits the application */
    public void exit() {
        System.exit(0);
    }
        
    /**
     * gets a file name to open using a dialog
     * 
     * @return the user selected file name
     */
    public String getOpenFile() {
        File file = dialogs.openFile(mainUI);
        return file.getAbsolutePath();
    }

    /**
     * gets a file name to save using a dialog
     * 
     * @return the user selected file name
     */
    public String getSaveFile() {
        File file = dialogs.saveFile(mainUI);
        return file.getAbsolutePath();
    }
    
    /**
     * determines if the user wants to deleted the selected entry from
     * the list box using a dialog
     * 
     * @return does want to delete (true) or not (false)
     */
    public boolean confirmDelete() {
        return dialogs.question("Are you sure you want to delete this?");
    }
    
}
    
    
    