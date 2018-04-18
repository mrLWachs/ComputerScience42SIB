
package testing.cs30s;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Graphics3 extends JFrame
{
    
    private JLabel label;
    private JTextField textbox;
    private JButton button;
    
    public Graphics3() {
        setFrameProperties();
        setControls();
        setLayout();
        addControls();
        addActions();
        setVisible(true);
    }

    private void setFrameProperties() {
        setSize(330,230);
        setResizable(false);
        setTitle("Graphics 3");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void setControls() {
        label = new JLabel();
        textbox = new JTextField();
        button = new JButton();
    }

    private void setLayout() {
        getContentPane().setLayout(null);
    }
    
    private void addControls() {
        getContentPane().add(label);
        getContentPane().add(textbox);
        getContentPane().add(button);        
        label.setBounds(10,10,300,50);
        textbox.setBounds(10,70,300,50);
        button.setBounds(10,130,300,50);        
    }
        
    private void addActions() {        
        // actions for the button...
        ActionListener buttonClick = new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText("Clicked!");
            }
        };        
        button.addActionListener(buttonClick);        
        // action for the textbox...        
        textbox.addKeyListener( new KeyListener()
        {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {                
                label.setText("Key " + e.getKeyChar());                
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        }  );        
        // add action for the label        
        label.addMouseListener(new MouseListener()
        {
            public void mouseClicked(MouseEvent e) { }
            public void mousePressed(MouseEvent e) { }
            public void mouseReleased(MouseEvent e) { }
            public void mouseEntered(MouseEvent e) {
                hover(true,e);
            }
            public void mouseExited(MouseEvent e) {
                hover(false,e);
            }
        });        
    }
    
    private void hover(boolean isOver, MouseEvent event) {
        if (isOver) {
            textbox.setText("Over " + event.getX() + "," +
                    event.getY());
        }
        else {
            textbox.setText("Out " + event.getX() + "," +
                    event.getY());
        }
    }
    
}