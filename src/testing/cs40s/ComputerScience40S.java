
/** required package class namespace */
package testing.cs40s;

/** required imports */
import io.Simulator;
import io.System;


/**
 * ComputerScience40S.java - the large in class example we continue to work 
 * on in each unit adding example code on the new concepts of each unit 
 * along with any in class requests for code examples that might come up 
 * over the course
 *
 * @author Mr. Wachs 
 * @since 7-Sep-2018 
 */
public class ComputerScience40S 
{

    /**
     * Default constructor for the class, sets class properties
     */
    public ComputerScience40S() {
        Simulator.header("Computer Science 40S starting..."); 
        new RecursionTest(); 
        new AdvancedClassesTest(); 
        new CollectionsTest();       
        Simulator.header("Computer Science 40S complete!");
    }
    
}