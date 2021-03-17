
/** required package class namespace */
package testing.cs42sib;

/** required imports */
import io.Simulator;
import testing.cs42sib.collections.CollectionsTest;
import testing.testclass.Test;


/**
 * ComputerScience42SIB.java - the large in class example we continue to work 
 * on in each unit adding example code on the new concepts of each unit 
 * along with any in class requests for code examples that might come up 
 * over the course
 *
 * @author Mr. Wachs 
 * @since 7-Sep-2018 
 */
public class ComputerScience42SIB 
{

    /**
     * Default constructor for the class, sets class properties
     */
    public ComputerScience42SIB() {
//        Simulator.header("Computer Science 42SIB starting...");         
//        new PermanentStorageTest();
//        new SearchSortTest();        
//        new CollectionsTest();        
        new StacksQueuesTest();
//        new TreesTest();   
//        Test.run();
//        Simulator.header("Computer Science 42SIB complete!");
    }
    
}