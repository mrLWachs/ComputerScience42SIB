
/** required package class namespace */
package testing.cs42sib;


import io.Output;

/**
 * ComputerScience42SIBTest.java - the large in class example we continue to 
 * work on in each unit adding example code on the new concepts of each unit 
 * along with any in class requests for code examples that might come up 
 * over the course
 *
 * @author Mr. Wachs 
 * @since Mar 2, 2018 
 * @instructor Mr. Wachs
 */
public class ComputerScience42SIBTest 
{

    /** 
     * Default constructor for the class 
     */
    public ComputerScience42SIBTest() {
        Output.header("Computer Science 42SIB course test",true,false);
        new StacksAndQueuesTest();
        new SearchingAndSortingTest();
        Output.header("Computer Science 42SIB course test",false,false);
    }
    
}
