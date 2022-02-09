
/** Required package class namespace */
package testing;

/** Required imports */
import io.Simulator;
import testing.cs30s.ComputerScience30S;
import testing.cs40s.ComputerScience40S;
import testing.cs42sib.ComputerScience42SIB;


/**
 * Tester.java - the unit testing class that drives the various unit tests
 *
 * @author Mr. Wachs 
 * @since Feb. 9, 2022, 8:01:03 a.m.
 */
public class Tester 
{

    /**
     * Default class constructor, runs on instantiation
     */
    public Tester() {
        Simulator.header("Mr. Wachs Computer Science testing started...");
//        new ComputerScience30S();
//        new ComputerScience40S();
        new ComputerScience42SIB();
        Simulator.header("Mr. Wachs Computer Science testing complete!");
    }
    
}