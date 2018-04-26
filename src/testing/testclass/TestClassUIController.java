
/** required package class namespace */
package testing.testclass;

/** required imports */
import collections.LinkedList;
import collections.Queue;
import collections.Stack;
import io.Dialogs;
import io.FileHandler;
import java.awt.Color;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.border.TitledBorder;

/**
 * TestClassUIController.java - user interface controller logic for the 
 * test class user interface model
 * 
 * @author Mr. Wachs
 * @since Jan 13, 2017
 * @instructor Mr. Wachs
 */
public class TestClassUIController 
{
    
    private JPanel                   panel;
    private JLabel[]                 textLabels;
    private JTextField[]             textboxes; 
    private JComboBox[]              comboboxes;
    private JButton[]                buttons;
    private JList                    listbox;    
    private DefaultListModel<String> listModel;
    private DefaultComboBoxModel[]   comboModels;;  
    private TestClassUI              ui;    
    
    private TestClass               testClass;
    private FileHandler<LinkedList> fileHandler;   
    private Dialogs                 dialog;
    private String                  filename;
    private String                  dataObject;    
    private LinkedList              linkedList;
    private Stack                   stack;
    private Queue                   queue;
//    private Tree<TestClass>         tree;
            
    private final String[] DATA_OBJECTS     = {"LinkedList","Stack","Queue","Tree"};
    private final String   FRAME_TITLE      = "Testing...";
    private final int      FRAME_WIDTH      = 707;
    private final int      FRAME_HEIGHT     = 650;
    private final Color    FRAME_BACKGROUND = Color.white;
    private final Color    FRAME_FOREGROUND = Color.black;   
    private final Font     FRAME_FONT       = new Font("Consolas",Font.PLAIN,11);
    private final int      ITEMS_TO_ADD     = 10;
    
            
    /**
     * Class constructor sets class property data
     * 
     * @param panel the user interface panel object
     * @param textLabels all labels on the user interface
     * @param textboxes all text boxes on the user interface
     * @param comboboxes all combo boxes on the user interface
     * @param buttons all buttons on the user interface
     * @param listbox the list box on the user interface
     * @param ui the user interface
     */
    public TestClassUIController(JPanel panel, JLabel[] textLabels, 
                                 JTextField[] textboxes, JComboBox[] comboboxes, 
                                 JButton[] buttons, JList listbox, TestClassUI ui) {  
        this.panel      = panel;
        this.textLabels = textLabels;
        this.textboxes  = textboxes;
        this.comboboxes = comboboxes;
        this.buttons    = buttons;
        this.listbox    = listbox;
        this.ui         = ui;
        initDataStructures();
        initUIComponents();
    }   

    /**
     * Creates a random test object and displays on the user interface
     */
    public void createRandomObject() {
        clearObjectArea();
        testClass = new TestClass();
        displayTestClass();
    }

    /**
     * Adds the new test object to the linked list
     */
    public void addRandomObjectToList() {  
        if (textboxes[0].getText().equals("")) return;
        dataObject = DATA_OBJECTS[0];
        linkedList.add(testClass);    
        fillList("Added Object to ");
    }

    /**
     * Adds the new test object to the stack
     */
    public void addRandomObjectToStack() {
        if (textboxes[0].getText().equals("")) return;
        dataObject = DATA_OBJECTS[1];
        stack.push(testClass);
        fillList("Added Object to ");    
    }

    /**
     * Adds the new test object to the queue
     */
    public void addRandomObjectToQueue() {
        if (textboxes[0].getText().equals("")) return;
        dataObject = DATA_OBJECTS[2];
        queue.enqueue(testClass);
        fillList("Added Object to ");
    }

    /**
     * Adds the new test object to the tree
     */
    public void addRandomObjectToTree() {
        if (textboxes[0].getText().equals("")) return;
        dataObject = DATA_OBJECTS[3];
        dialog.show(dataObject + " not yet implemented!");
    }
        
    /**
     * Adds a number of new test objects to the data structure
     */
    public void createRandomObjects() {
        for (int i = 0; i < ITEMS_TO_ADD; i++) {
            createRandomObject();
            if (dataObject.equals(DATA_OBJECTS[0])) 
                addRandomObjectToList();
            else if (dataObject.equals(DATA_OBJECTS[1])) 
                addRandomObjectToStack();
            else if (dataObject.equals(DATA_OBJECTS[2])) 
                addRandomObjectToQueue();
            else if (dataObject.equals(DATA_OBJECTS[3])) {
                addRandomObjectToTree();  
                return;
            }
        }
        fillList("Added " + ITEMS_TO_ADD + " Objects to ");
    }
    
    /**
     * Saves the linked list to the permanent file object
     */
    public void saveListToFile() {        
        LinkedList list = getLinkedist();
        if (list == null) {
            dialog.show(dataObject + " not yet implemented!");
            return;
        }
        fileHandler.saveObject(list, filename);
        listModel.removeAllElements();
        listModel.addElement(dataObject + " saved to file...");
        clearObjectArea();
    }

    /**
     * Opens the permanent file object and displays in on the user interface
     */
    public void openListFromFile() {
        LinkedList list = fileHandler.openObject(filename);        
        if (dataObject.equals(DATA_OBJECTS[0])) 
            linkedList = list.clone();
        else if (dataObject.equals(DATA_OBJECTS[1])) 
            stack = new Stack(list);
        else if (dataObject.equals(DATA_OBJECTS[2])) 
            queue = new Queue(list);
        else if (dataObject.equals(DATA_OBJECTS[3])) 
            dialog.show(dataObject + " not yet implemented!");  //tree = new Tree<>(list); 
        fillList("Opening from file, data object ");        
    }
    
    /**
     * Displays the clicked upon test object from the linked list
     */
    public void listboxClick() {
        LinkedList list = getLinkedist();
        int index = listbox.getSelectedIndex() - 1;
        if (index < 0) return;
        testClass = (TestClass)list.get(index);
        displayTestClass();
    }
        
    /**
     * Sort the contents of the list box (and data structure)
     */
    public void sortListBox() {
        dialog.show("Feature not yet implemented!");
    }

    /**
     * Search the contents of the list box (and data structure)
     */
    public void searchListBox() {
        dialog.show("Feature not yet implemented!");
    }
    
    /**
     * Initializes all the data structures
     */
    private void initDataStructures() {
        fileHandler = new FileHandler<>();        
        filename    = System.getProperty("user.dir") + "\\data.txt";      
        dialog      = new Dialogs(FRAME_FONT,FRAME_BACKGROUND,
                                  FRAME_FOREGROUND,FRAME_TITLE);
        linkedList  = new LinkedList();
        stack       = new Stack();
        queue       = new Queue();     
        dataObject  = DATA_OBJECTS[0];
    }

    /**
     * Initializes the look and feel of all user interface components and 
     * containers
     */
    private void initUIComponents() {        
        listModel = new DefaultListModel<>();
        this.listbox.setModel(listModel);
        comboModels = new DefaultComboBoxModel[comboboxes.length];
        for (int i = 0; i < comboModels.length; i++) {
            comboModels[i] = (DefaultComboBoxModel)this.comboboxes[i].getModel();
            comboboxes[i].setBackground(FRAME_BACKGROUND);
            comboboxes[i].setForeground(FRAME_FOREGROUND);            
            comboboxes[i].setFont(FRAME_FONT);
        }
        for (JLabel textLabel : textLabels) {
            textLabel.setBackground(FRAME_BACKGROUND);
            textLabel.setForeground(FRAME_FOREGROUND); 
            textLabel.setFont(FRAME_FONT);
        }
        for (JTextField textbox : textboxes) {
            textbox.setBackground(FRAME_BACKGROUND);
            textbox.setForeground(FRAME_FOREGROUND);
            textbox.setFont(FRAME_FONT);
        }
        for (JButton button : buttons) {
            button.setBackground(FRAME_BACKGROUND);
            button.setForeground(FRAME_FOREGROUND);
            button.setFont(FRAME_FONT);
        }
        listbox.setFont(FRAME_FONT);
        listbox.setBackground(FRAME_BACKGROUND);
        listbox.setForeground(FRAME_FOREGROUND);
        panel.setBackground(FRAME_BACKGROUND); 
        panel.setForeground(FRAME_FOREGROUND);
        ((TitledBorder)panel.getBorder()).setTitleFont(FRAME_FONT);        
        panel.setFont(FRAME_FONT);
        ui.getContentPane().setBackground(FRAME_BACKGROUND);
        ui.setBackground(FRAME_BACKGROUND);
        ui.setTitle(FRAME_TITLE);
        ui.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        ui.setResizable(false);
        ui.setLocationRelativeTo(null);
        textLabels[0].requestFocus();
        ui.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        clearObjectArea();
    }
    
    /**
     * Clears the display area on the user interface
     */
    private void clearObjectArea() {
        for (JTextField textbox : textboxes) {
            textbox.setText("");
        }
        for (DefaultComboBoxModel comboModel : comboModels) {
            comboModel.removeAllElements();
        }
    }

    /**
     * Populates the list box with all objects in the current data structure
     */
    private void fillList(String text) {  
        listModel.removeAllElements();
        listModel.addElement(text + dataObject + ":");
        LinkedList list = getLinkedist();
        if (list == null || list.isEmpty()) {
            listModel.addElement("Empty " + dataObject + "!");
            return;
        }         
        for (int i = 0; i < list.size(); i++) {  
            testClass = (TestClass)list.get(i);
            listModel.addElement("(" + i + ") " + testClass.toString());
        }
        clearObjectArea();
    }

    /**
     * Display the current test object on the user interface
     */
    private void displayTestClass() {
        textboxes[0].setText("" + testClass.data1);
        textboxes[1].setText("" + testClass.data2);
        textboxes[2].setText("" + testClass.data3);
        textboxes[3].setText("" + testClass.data4);
        textboxes[4].setText("" + testClass.associateTestClass.toString());          
        for (int i = 0; i < comboModels.length; i++) {
            comboModels[i].removeAllElements();
        }
        for (int i = 0; i < testClass.list1.length; i++) {
            comboModels[0].addElement(testClass.list1[i]);
        }    
        for (int i = 0; i < testClass.list2.length; i++) {
            comboModels[1].addElement(testClass.list2[i]);
        }
        for (int i = 0; i < testClass.list3.length; i++) {
            comboModels[2].addElement(testClass.list3[i]);
        }  
        for (int i = 0; i < testClass.list4.length; i++) {
            comboModels[3].addElement(testClass.list4[i]);
        } 
        for (int i = 0; i < testClass.list5.length; i++) {
            comboModels[4].addElement(testClass.list5[i]);
        }
    }
    
    /**
     * Turns the current data object into a LinkedList
     * 
     * @return a LinkedList version of the current data object
     */
    private LinkedList getLinkedist() {      
        if (dataObject.equals(DATA_OBJECTS[0])) 
            return linkedList.clone();
        else if (dataObject.equals(DATA_OBJECTS[1])) 
            return stack.toLinkedList();
        else if (dataObject.equals(DATA_OBJECTS[2])) 
            return queue.toLinkedList();
        else if (dataObject.equals(DATA_OBJECTS[3])) 
            dialog.show(dataObject + " not yet implemented!");  //list = tree.toLinkedList();
        return null;
    }

}
