
/** required package class namespace */
package testing;

import io.Output;
import testing.cs30s.ComputerScience30STest;
import testing.cs40s.ComputerScience40STest;
import testing.cs42sib.ComputerScience42SIBTest;

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
        Output.init();
        Output.header("All unit testing",true,true);
//        new ComputerScience30STest();
//        new ComputerScience40STest();        
        new ComputerScience42SIBTest();
        Output.header("All unit testing",false,true);        
        Output.flush();
    }
    
}
