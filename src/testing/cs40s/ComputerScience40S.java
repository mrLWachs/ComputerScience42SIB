
/** Required package class namespace */
package testing.cs40s;

/** Required imports */
import io.Simulator;


/**
 * ComputerScience40S.java - the large in class example we continue to work 
 * on in each unit adding example code on the new concepts of each unit 
 * along with any in class requests for code examples that might come up 
 * over the course
 *
 * @author Mr. Wachs 
 * @since Feb. 9, 2022, 8:01:03 a.m. 
 */
public class ComputerScience40S 
{

    /**
     * Default constructor for the class, sets class properties
     */
    public ComputerScience40S() {
        Simulator.header("Computer Science 40S starting..."); 
        RecursionTest       unit1 = new RecursionTest(); 
        AdvancedClassesTest unit2 = new AdvancedClassesTest(); 
        CollectionsTest     unit3 = new CollectionsTest();       
        Simulator.header("Computer Science 40S complete!");
    }
    
}