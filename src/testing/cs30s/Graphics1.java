
/** class package */
package testing.cs30s;

/** required imports */
import java.awt.Container;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * Graphics1.java - example of a user interface (UI)
 * 
 * @author Mr. Wachs
 * @since December 12, 2017
 */
public class Graphics1 extends JFrame
{
// inheritance means that Graphics1 "is a" container (from JFrame class)
    
    // controls (properties)
    private JLabel text;    
    private JLabel image;
    
    /** 
     * Default constructor for the class 
     */
    public Graphics1() {
        // setting the properties of the form
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);   // operation when closed
        this.setSize(500,500);                          // change frame size
        this.setTitle("Example 1");                     // change frame title
        this.setResizable(false);                       // remove minimize/maximize
        this.setLocationRelativeTo(null);               // centers frame on screen
        
        // set layout rules
        Container container = this.getContentPane();
        container.setLayout(new FlowLayout());
        
        // setting up the controls        
        text = new JLabel("Hello World");
        image = new JLabel(new ImageIcon("C:\\Users\\"
                + "lawrence.wachs\\Desktop\\Wachs Stuff\\"
                + "Programming (2017-2018)\\Java\\"
                + "ComputerScience30Examples\\src\\"
                + "computerscience30examples\\"
                + "giphy.gif"));
        
        // add the controls into the container
        container.add(text);
        container.add(image);
        
        // finally reveal the form
        this.setVisible(true);                          // display frame to user
    }    

}
