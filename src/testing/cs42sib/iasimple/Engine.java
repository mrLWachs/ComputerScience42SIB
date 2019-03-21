
/** required package class namespace */
package testing.cs42sib.iasimple;

/** required imports */
import collections.LinkedList;
import io.Dialogs;
import io.FileHandler;
import java.awt.List;
import javax.swing.JTextField;
import tools.Sorter;


/**
 * Engine.java - the logic engine running the logic behind the user interface
 *
 * @author Mr. Wachs 
 * @since 21-Mar-2019 
 */
public class Engine 
{
    
    private LinkedList<Player> players;
    private Sorter             sorter;
    private FileHandler        file;
    private Dialogs            dialog;    
    private JTextField         txtName;
    private JTextField         txtNumber;
    private JTextField         txtPhoneNumber;
    private List               playersList;
    
    private final String FILENAME = "data.txt";
    
    /**
     * Constructor for the class, sets class properties
     * 
     * @param ui the user interface for the program
     * @param txtName the name text box on the user interface
     * @param txtNumber the number text box on the user interface
     * @param txtPhoneNumber the phone number text box on the user interface
     * @param playersList the players list box on the user interface
     */
    public Engine(InternalAssessmentCSIB ui, 
            JTextField txtName, 
            JTextField txtNumber,
            JTextField txtPhoneNumber, 
            List playersList) {
        players = new LinkedList<>();
        sorter  = new Sorter();
        dialog  = new Dialogs("Roster Maker", ui);
        file    = new FileHandler(dialog);
        this.txtName        = txtName;
        this.txtNumber      = txtNumber;
        this.txtPhoneNumber = txtPhoneNumber;
        this.playersList    = playersList;  
        read();        
        ui.setSize(550, 450);
        ui.setResizable(false);
        ui.setLocationRelativeTo(null);
        ui.setVisible(true);
    }

    /**
     * Adds the player form the usr interface information to the list
     */
    public void add() {
        String name        = txtName.getText();
        String number      = txtNumber.getText();
        String phoneNumber = txtPhoneNumber.getText();
        if (name == null || number == null || phoneNumber == null ||
            name.equals("") || number.equals("") || phoneNumber.equals("")) {
            dialog.show("You must fill out all fields to add a player!");
        }
        else {
            Player player = new Player(name, number, phoneNumber);
            playersList.add(player.toString());
            players.add(player);    
            txtName.setText("");
            txtNumber.setText("");
            txtPhoneNumber.setText("");
            txtName.requestFocus();
        }
    }

    /**
     * Edits the selected player from the list
     */
    public void edit() {
        int index = playersList.getSelectedIndex();
        if (index == -1) {
            dialog.show("You must first select a player from the list!");
        }
        else {
            Player player = players.get(index);
            txtName.setText(player.getName());
            txtNumber.setText(player.getNumber());
            txtPhoneNumber.setText(player.getPhoneNumber());
            players.remove(index);
            playersList.remove(index);
        }
    }

    /**
     * Deletes the selected player from the list
     */
    public void delete() {
        int index = playersList.getSelectedIndex();
        if (index == -1) {
            dialog.show("You must first select a player from the list!");
        }
        else {
            players.remove(index);
            playersList.remove(index);
        }
    }

    /**
     * Sorts all the players and updates the list
     */
    public void sort() {
        if (players.isEmpty()) return;
        sorter.quick(players);
        playersList.removeAll();
        for (int i = 0; i < players.size(); i++) {
            playersList.add(players.get(i).toString());
        }
    }

    /**
     * Saves the player list to a permanent file
     */
    public void save() {
        if (players.isEmpty()) return;
        file.saveObject(players, FILENAME);
    }

    /**
     * Opens the permanent file and reads in all the players saved and 
     * updates the list
     */
    private void read() {        
        players = (LinkedList<Player>)file.openObject(FILENAME);
        if (players == null) {
            players = new LinkedList<>();
        }
        playersList.removeAll();
        for (int i = 0; i < players.size(); i++) {
            playersList.add(players.get(i).toString());
        }
    }
    
}
