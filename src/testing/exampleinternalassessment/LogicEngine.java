
/** required package class namespace */
package testing.exampleinternalassessment;

/** required imports */
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * LogicEngine.java - the main logic engine for the application
 * 
 * @author Mr. Wachs
 * @since Mar 13, 2017
 * @instructor Mr. Wachs
 */
public class LogicEngine 
{

    private DataController    dataController;
    private UIController      uiController; 
      
    
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
    public LogicEngine(
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
            MainUI   mainUI) {          
        uiController = new UIController(
                exitButton,
                saveEntryButton,
                cancelButton,
                editSelectedButton,
                deleteSelectedButton,
                newEntryButton,
                openEntriesButton,
                sortEntriesButton,
                saveEntriesButton,
                nameLabel,
                informationLabel,
                ageLabel,
                entriesList,
                maleRadio,
                femaleRadio,
                informationScrollPane,
                entriesScrollPane,
                ageSpinner,
                informationText,
                nameText,
                mainUI);   
        dataController = new DataController(uiController);                      
    }
    
    /** exits the application */
    public void exit() {        
        uiController.exit();
    }
    
    /** adds a new entry to the database */
    public void newEntry() {
        uiController.addEntry();
    }

    /** selects a male entry */
    public void maleSelected() {
        uiController.setGender(true);
    }

    /** selects a female entry */
    public void femaleSelected() {
        uiController.setGender(false);
    }
    
    /** cancels creating a new/edited entry */
    public void cancel() {
        dataController.cancel();
    }
    
    /** saves the new/edited entry to the database */
    public void saveEntry() {
        dataController.saveEntry();
    }
    
    /** edits the selected entry */
    public void editSelected() {
        dataController.editSelected();
    }

    /** deletes the selected entry */
    public void deleteSelected() {
        dataController.deleteSelected();
    }
    
    /** saves all entries to a permanent file */
    public void saveEntries() {
        dataController.saveEntries();
    }

    /** sorts all the entries into ascending order */
    public void sortEntries() {
        dataController.sortEntries();
    }
    
    /** opens a permanent file of saved entries */
    public void openEntries() {
        dataController.openEntries();
    }
    
}
