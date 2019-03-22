
/** required package class namespace */
package testing.cs42sib;

/** required imports */
import testing.cs42sib.stacksqueues.StacksQueuesTest;
import io.System;
import testing.cs42sib.iasimple.InternalAssessmentCSIB;
import testing.cs42sib.trees.TreeTest;

/**
 * CS42SIBTest.java - the large in class example we continue to work 
 * on in each unit adding example code on the new concepts of each unit 
 * along with any in class requests for code examples that might come up 
 * over the course
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
        StacksQueuesTest       learnStacksQueues = new StacksQueuesTest();
        TreeTest               learnBinaryTrees  = new TreeTest();        
        InternalAssessmentCSIB simpleIAExample   = new InternalAssessmentCSIB();
        System.out.header("Computer Science 42SIB course completed!");
    }
   
}
