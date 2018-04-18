
/** required package class namespace */
package testing.cs42sib;


import io.Output;

/**
 * ComputerScience42SIBTest.java - description here...
 *
 * @author Mr. Wachs (login: lawrence.wachs)
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
