/** required package class namespace */
package testing;

import testing.cs42sib.CS42SIBTest;


/**
 * Tester.java - the unit testing class that drives the various unit tests
 *
 * @author Mr. Wachs 
 * @since 24-Sep-2018 
 */
public class Tester 
{

    /**
     * Default class constructor, runs on instantiation
     */
    public Tester() {
//        Output.init();
//        Output.header("All unit testing",true,true);  
        
//        new CS30STest();
//        new CS40STest();
        
        new CS42SIBTest();
        
//        Output.header("All unit testing",false,true);        
//        Output.flush();
    }
    
}