
/** required package class namespace */
package testing;

import testing.cs30s.ComputerScience30STest;
import testing.cs40s.ComputerScience40STest;
import testing.cs42sib.ComputerScience42SIBTest;
import testing.exampleinternalassessment.MainUI;
import testing.testclass.TestClassUI;

/**
 * Tester.java - description here...
 *
 * @author Mr. Wachs (login: lawrence.wachs)
 * @since Feb 15, 2018 
 * @instructor Mr. Wachs
 */
public class Tester 
{

    /** 
     * Default constructor for the class 
     */
    public Tester() {   
//        new MainUI();
//        new TestClassUI(null,false);
        inClassContent();
    }
    
    private void inClassContent() {
        Output.init();
        Output.header("All unit testing",true,true);
        new ComputerScience30STest();
        new ComputerScience40STest();        
        new ComputerScience42SIBTest();
        Output.header("All unit testing",false,true);        
        Output.flush();
    }
    
}
