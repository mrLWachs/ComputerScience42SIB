/** required package class namespace */
package io;

/** required imports */
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.io.File;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 * Dialogs.java - a collection of useful methods for working with dialogs
 *
 * @author Mr. Wachs
 * @since Dec 12, 2017
 * @instructor Mr. Wachs
 */
public class Dialogs
{

    private final Font DEFAULT_FONT
            = new JOptionPane().getFont();
    private final Color DEFAULT_BACKGROUND_COLOR
            = new JOptionPane().getBackground();
    private final Color DEFAULT_FOREGROUND_COLOR
            = new JOptionPane().getForeground();
    private final String DEFAULT_TITLE = "";
    private final Component DEFAULT_COMPONENT = null;
    private final ImageIcon DEFAULT_ICON = null;
    private final int DEFAULT_TYPE
            = JOptionPane.PLAIN_MESSAGE;
    private final int DEFAULT_OPTION_TYPE
            = JOptionPane.YES_NO_OPTION;

    private JTextArea area;

    /** 
     * Font used for displaying in the dialogs 
     */
    public Font font;
    /**
     * Background color used for displaying in the dialogs
     */
    public Color backgroundColor;
    /**
     * Foreground (text) color used for displaying in the dialogs
     */
    public Color foregroundColor;
    /**
     * Top dialog title used
     */
    public String dialogTitle;
    /**
     * Frame or other component the dialog parents (centers) with
     */
    public Component parent;
    /**
     * Type of icon used in the dialogs
     */
    public int type;
    /**
     * Type of button options used in the dialogs
     */
    public int optionType;
    /**
     * Custom icon (image) used in the dialogs
     */
    public Icon icon;

    /**
     * Class constructor sets class properties
     *
     * @param dialogTitle The title used on any dialog in the class
     */
    public Dialogs(String dialogTitle) {
        defaults();
        this.dialogTitle = dialogTitle;
        this.parent = null;
        init();
    }

    /**
     * Class constructor sets class properties
     *
     * @param dialogTitle The title used on any dialog in the class
     * @param parent the component to parent the dialogs to
     */
    public Dialogs(String dialogTitle, Component parent) {
        defaults();
        this.dialogTitle = dialogTitle;
        this.parent = parent;
        init();
    }

    /**
     * Class constructor sets passed properties
     *
     * @param font font used in dialogs
     * @param backgroundColor background color used in dialogs
     * @param foregroundColor foreground (text) color used in dialogs
     * @param dialogTitle top dialog title used
     */
    public Dialogs(Font font,
                   Color backgroundColor,
                   Color foregroundColor,
                   String dialogTitle) {
        defaults();
        this.font = font;
        this.backgroundColor = backgroundColor;
        this.foregroundColor = foregroundColor;
        this.dialogTitle = dialogTitle;
        init();
    }

    /**
     * Class constructor sets passed properties
     *
     * @param parent frame the dialog parents (centers) with
     * @param type type of icon used in the dialogs
     * @param icon custom icon (image) used in the dialogs
     * @param font font used in dialogs
     * @param backgroundColor background color used in dialogs
     * @param foregroundColor foreground (text) color used in dialogs
     * @param dialogTitle top dialog title used
     */
    public Dialogs(Component parent,
                   int type,
                   Icon icon,
                   Font font,
                   Color backgroundColor,
                   Color foregroundColor,
                   String dialogTitle) {
        defaults();
        this.parent = parent;
        this.type = type;
        this.icon = icon;
        this.font = font;
        this.backgroundColor = backgroundColor;
        this.foregroundColor = foregroundColor;
        this.dialogTitle = dialogTitle;
        init();
    }

    /**
     * Outputs the passed text in a dialog
     *
     * @param text the text to display
     */
    public void show(String text) {
        area.setText(text);
        JOptionPane.showMessageDialog(parent, area, dialogTitle, type, icon);
    }

    /**
     * Outputs the passed text in a dialog, and gets typed user input
     *
     * @param text the text to display
     * @return the text the user types in
     */
    public String input(String text) {
        area.setText(text);
        Object object = JOptionPane.showInputDialog(parent, area,
                dialogTitle, type, icon, null, null);
        if (object == null) {
            return null;
        }
        return object.toString();
    }

    /**
     * Outputs the passed text in a dialog and a set of choices in a drop down
     * selection area
     *
     * @param choices the choices to display for the user
     * @param text the text to display
     * @return the choice the user selects from the drop down
     */
    public String options(String[] choices, String text) {
        area.setText(text);
        Object object = JOptionPane.showInputDialog(parent, area,
                dialogTitle, type, icon, choices, choices[0]);
        if (object == null) {
            return null;
        }
        return object.toString();
    }

    /**
     * Outputs the passed text in a dialog and two 'yes' and 'no' buttons for
     * the user to click on
     *
     * @param text the text to display
     * @return true if they clicked 'yes' or false for 'no'
     */
    public boolean question(String text) {
        area.setText(text);
        return JOptionPane.showConfirmDialog(parent,
                area, dialogTitle, optionType,
                type, icon) == JOptionPane.YES_OPTION;
    }

    /**
     * Outputs the passed text in a dialog and creates buttons with the text
     * from the choices on each for the user to click on
     *
     * @param choices the text choices for each button
     * @param text the text to display
     * @return the text on which button the user clicked on
     */
    public String choices(String[] choices, String text) {
        area.setText(text);
        int value = JOptionPane.showOptionDialog(parent,
                area, dialogTitle, optionType, type,
                icon, choices, choices[0]);
        return choices[value];
    }

    /**
     * Open file dialog parented to the passed frame
     *
     * @param frame the frame to parent to
     * @return the file object selected (or a null)
     */
    public File openFile(JFrame frame) {
        JFileChooser chooser = new JFileChooser(dialogTitle);
        chooser.showOpenDialog(frame);
        return chooser.getSelectedFile();
    }

    /**
     * Save file dialog parented to the passed frame
     *
     * @param frame the frame to parent to
     * @return the file object selected (or a null)
     */
    public File saveFile(JFrame frame) {
        JFileChooser chooser = new JFileChooser(dialogTitle);
        chooser.showSaveDialog(frame);
        return chooser.getSelectedFile();
    }

    /**
     * Open file dialog parented to the passed frame
     *
     * @param frame the frame to parent to
     * @return the file object selected (or a null)
     */
    public File openFileFrame(JDialog frame) {
        JFileChooser chooser = new JFileChooser(dialogTitle);
        chooser.showOpenDialog(frame);
        return chooser.getSelectedFile();
    }

    /**
     * Save file dialog parented to the passed frame
     *
     * @param frame the frame to parent to
     * @return the file object selected (or a null)
     */
    public File saveFileFrame(JDialog frame) {
        JFileChooser chooser = new JFileChooser(dialogTitle);
        chooser.showSaveDialog(frame);
        return chooser.getSelectedFile();
    }

    /**
     * Sets class properties to default values
     */
    private void defaults() {
        this.font = DEFAULT_FONT;
        this.backgroundColor = DEFAULT_BACKGROUND_COLOR;
        this.foregroundColor = DEFAULT_FOREGROUND_COLOR;
        this.dialogTitle = DEFAULT_TITLE;
        this.parent = DEFAULT_COMPONENT;
        this.type = DEFAULT_TYPE;
        this.optionType = DEFAULT_OPTION_TYPE;
        this.icon = DEFAULT_ICON;
        this.area = new JTextArea();
    }

    /**
     * Initializes the text area for the dialogs
     */
    private void init() {
        area.setFont(font);
        area.setBackground(backgroundColor);
        area.setForeground(foregroundColor);
    }

}
