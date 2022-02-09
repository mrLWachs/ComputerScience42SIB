
/** Required package class namespace */
package testing.cs30s;

/** Required imports */
import io.System;
import io.Simulator;

 
/**
 * LearnGraphics.java - a class object (instance) to launch a constructor to
 * learn about graphics and graphical user interfaces (GUI) by instantiating
 * other objects
 *
 * @author Mr. Wachs
 * @since Feb. 9, 2022, 8:01:03 a.m.
 */
public class LearnGraphics 
{

    /**
     * Constructor method for when an object of this class is instantiated
     */
    public LearnGraphics() {
        System.out.println("Start Learning Graphics and User Interfaces (UI)");
        // Create class objects for different examples
        Simulator.showFrame(null,"Graphics1");
        Simulator.showFrame(null,"Graphics2");
        Simulator.showFrame(null,"Graphics3");
//        Graphics1 graphics1 = new Graphics1();
//        Graphics2 graphics2 = new Graphics2();
//        Graphics3 graphics3 = new Graphics3();        
        System.out.println("Completed Learning Graphics and UI!");
    }

}