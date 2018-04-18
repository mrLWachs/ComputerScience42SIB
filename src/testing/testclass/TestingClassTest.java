
/** required package class namespace */
package testing.testclass;

/**
 * SampleProjectTest.java - test class for the test class and it's user interface
 * 
 * @author Mr. Wachs
 * @since Jan 13, 2017
 * @instructor Mr. Wachs
 */
public class TestingClassTest 
{
    
    /** 
     * Default constructor 
     */
    public TestingClassTest() {
        TestClassUI ui = new TestClassUI(new javax.swing.JFrame(), true);
        System.exit(0);
    }

}
