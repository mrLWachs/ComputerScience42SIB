/** required package class namespace */
package testing;

/** required imports */
import testing.cs30s.CS30STest;
import testing.cs40s.CS40STest;
import testing.cs42sib.CS42SIBTest;
import io.System;


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
        System.init();    
        System.out.header("All testing started...");
        new CS30STest();
        new CS40STest();
        new CS42SIBTest();
        System.out.header("All testing complete!");
        System.flush();
    }
    
}