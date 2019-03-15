
/** required package class namespace */
package io;

import java.awt.Component;
import javax.swing.Icon;


/**
 * JOptionPane.java - 
 *
 * @author Mr. Wachs 
 * @since 15-Mar-2019 
 */
public class JOptionPane 
{

    /**
     * Type meaning Look and Feel should not supply any options -- only
     * use the options from the <code>JOptionPane</code>.
     */
    public static final int         DEFAULT_OPTION = -1;
    /** Type used for <code>showConfirmDialog</code>. */
    public static final int         YES_NO_OPTION = 0;
    /** Type used for <code>showConfirmDialog</code>. */
    public static final int         YES_NO_CANCEL_OPTION = 1;
    /** Type used for <code>showConfirmDialog</code>. */
    public static final int         OK_CANCEL_OPTION = 2;

    //
    // Return values.
    //
    /** Return value from class method if YES is chosen. */
    public static final int         YES_OPTION = 0;
    /** Return value from class method if NO is chosen. */
    public static final int         NO_OPTION = 1;
    /** Return value from class method if CANCEL is chosen. */
    public static final int         CANCEL_OPTION = 2;
    /** Return value form class method if OK is chosen. */
    public static final int         OK_OPTION = 0;
    /** Return value from class method if user closes window without selecting
     * anything, more than likely this should be treated as either a
     * <code>CANCEL_OPTION</code> or <code>NO_OPTION</code>. */
    public static final int         CLOSED_OPTION = -1;

    //
    // Message types. Used by the UI to determine what icon to display,
    // and possibly what behavior to give based on the type.
    //
    /** Used for error messages. */
    public static final int  ERROR_MESSAGE = 0;
    /** Used for information messages. */
    public static final int  INFORMATION_MESSAGE = 1;
    /** Used for warning messages. */
    public static final int  WARNING_MESSAGE = 2;
    /** Used for questions. */
    public static final int  QUESTION_MESSAGE = 3;
    /** No icon is used. */
    public static final int   PLAIN_MESSAGE = -1;
    
    
    public static void showMessageDialog(Component parentComponent, 
            Object message) {
        System.out.dialog(message);
    }

    public static void showMessageDialog(Component parentComponent,
        Object message, String title, int messageType) {
        System.out.dialog(message);
    }
    
    public static void showMessageDialog(Component parentComponent,
        Object message, String title, int messageType, Icon icon) {
        System.out.dialog(message);
    }
    
    public static int showConfirmDialog(Component parentComponent,
        Object message) {
        System.out.dialog(message);
        return -1;
    }

    public static int showConfirmDialog(Component parentComponent,
        Object message, String title, int optionType) {
        System.out.dialog(message);
        return -1;
    }

    public static int showConfirmDialog(Component parentComponent,
        Object message, String title, int optionType, int messageType) {
        System.out.dialog(message);
        return -1;
    }

    public static int showConfirmDialog(Component parentComponent,
        Object message, String title, int optionType,
        int messageType, Icon icon) { 
        System.out.dialog(message);
        return -1;
    }

    public static int showOptionDialog(Component parentComponent,
        Object message, String title, int optionType, int messageType,
        Icon icon, Object[] options, Object initialValue) {
        System.out.dialog(message);
        return -1;
    }
    
    public static String showInputDialog(Object message) {
        System.out.dialog(message);
        return "-1";
    }

    public static String showInputDialog(Object message, 
            Object initialSelectionValue) {
        return showInputDialog(message);
    }

    public static String showInputDialog(Component parentComponent,
        Object message) {
        return showInputDialog(message);
    }
    
    public static String showInputDialog(Component parentComponent, 
            Object message, Object initialSelectionValue) {
        return showInputDialog(message);
    }

    public static String showInputDialog(Component parentComponent,
        Object message, String title, int messageType) {
        return showInputDialog(message);
    }

    public static Object showInputDialog(Component parentComponent,
        Object message, String title, int messageType, Icon icon,
        Object[] selectionValues, Object initialSelectionValue) {
        return showInputDialog(message);
    }

}
