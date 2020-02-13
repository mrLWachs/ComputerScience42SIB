
/** required package class namespace */
package io;

/** required imports */
import java.io.File;
import javax.swing.JFrame;

 
/**
 * JFileChooser.java - this class simulates the java.swing class that does the 
 * dialogs and user interfaces and redirects the outputs to a custom output
 *
 * @author Mr. Wachs
 * @since Feb. 11, 2020, 12:58:16 p.m.
 */
public class JFileChooser 
{

    /**
     * Default constructor, set class properties
     */
    public JFileChooser() { }

    /**
     * Re-directs the dialog to custom output
     * 
     * @param parent the parent component of the dialog 
     */
    public void showSaveDialog(JFrame parent) {
        Simulator.showSaveDialog(parent);
    }

    /**
     * Re-directs the dialog to custom output
     * 
     * @param parent the parent component of the dialog 
     */
    public void showOpenDialog(JFrame parent) {
        Simulator.showOpenDialog(parent);
    }
    
    /**
     * Uses a simulated user selected file
     * 
     * @return a simulated file object
     */
    public File getSelectedFile() {
        return Simulator.getFile();
    }

}
