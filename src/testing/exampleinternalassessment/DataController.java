
/** required package class namespace */
package testing.exampleinternalassessment;

/** required imports */
import collections.LinkedList;
import io.FileHandler;
import searchsort.Sorter;

/**
 * DataController.java - controls the logic engine for the database data
 * 
 * @author Mr. Wachs
 * @since Mar 13, 2017
 * @instructor Mr. Wachs
 */
public class DataController 
{

    private UIController      uiController;   
    private LinkedList<Entry> entries;
    private FileHandler       fileHandler;
    private Sorter            sorter;
           
    
    /**
     * class constructor sets class properties
     * 
     * @param uiController the user interface controller object
     */
    public DataController(UIController uiController) {
        this.uiController = uiController;
        entries           = new LinkedList<Entry>();
        fileHandler       = new FileHandler<LinkedList<Entry>>();
        sorter            = new Sorter();
    }

    /** saves the new/edited entry to the database data */
    public void saveEntry() {
        if (uiController.isValidEntry()) {
            String  name        = uiController.getName();
            boolean isMale      = uiController.getGender();
            int     age         = uiController.getAge();
            String  information = uiController.getInformation();
            Entry   entry       = new Entry(name,isMale,age,information);            
            if (uiController.isNewEntry()) {
                entries.add(entry);
            }
            else {
                int selected = uiController.getSelectedEntry();
                entries.set(selected,entry);
            }
            uiController.updateUI(entries);
        }
    }

    /** edits the selected entry */
    public void editSelected() {
        if (uiController.isValidSelected()) {
            int     selected    = uiController.getSelectedEntry();
            Entry   entry       = entries.get(selected);
            String  name        = entry.getName();
            boolean isMale      = entry.getIsMale();
            int     age         = entry.getAge();
            String  information = entry.getInformation(); 
            uiController.addEntry(name,isMale,age,information,false);
        }
    }

    /** deletes the selected entry */
    public void deleteSelected() {
        if (uiController.isValidSelected()) {
            if (uiController.confirmDelete()) {
                int selected = uiController.getSelectedEntry();
                entries.remove(selected);
                uiController.updateUI(entries);
            }
        }
    }

    /** saves the database data to a permanent file */
    public void saveEntries() {
        if (uiController.isValidList()) {
            String filename = uiController.getSaveFile();
            fileHandler.saveObject(entries, filename);
            uiController.updateUI(entries);
        }
    }

    /** sorts the database data into ascending order */
    public void sortEntries() {
        if (uiController.isValidList()) {
            sorter.quick(entries);
            uiController.updateUI(entries);
        }
    }

    /** opens the database data from a permanent file */
    public void openEntries() {
        String filename = uiController.getOpenFile();
        entries = (LinkedList<Entry>)fileHandler.openObject(filename);
        uiController.updateUI(entries);
    }

    /** cancels the new/edit entry */
    public void cancel() {
        uiController.updateUI(entries);
    }
     
}
