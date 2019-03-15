
/** required package class namespace */
package testing.cs42sib;

import testing.cs42sib.stacksqueues.StacksQueuesTest;

import io.System;

/**
 * CS42SIBTest.java - 
 *
 * @author Mr. Wachs 
 * @since 5-Mar-2019 
 */
public class CS42SIBTest 
{

    /**
     * Default constructor for the class, sets class properties
     */
    public CS42SIBTest() {
        System.out.header("Computer Science 42SIB course started...");
        StacksQueuesTest unit6 = new StacksQueuesTest();
        System.out.header("Computer Science 42SIB course completed!");
    }
   
}
