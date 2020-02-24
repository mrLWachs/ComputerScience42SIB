
/** required package class namespace */
package testing.cs42sib;

/** required imports */
import collections.Stack;
import io.Simulator;
import io.System;
import testing.cs40s.advancedclasses.Box;


/**
 * PermanentStorageTest.java - tests the concepts learned in this unit
 *
 * @author Mr. Wachs
 * @since Jan. 14, 2020, 8:01:03 a.m.
 */
public class StacksQueuesTest 
{

    /**
     * Default constructor, set class properties
     */
    public StacksQueuesTest() {
        Simulator.header("Stacks and Queues Test started...");
        
        Simulator.comment("Test the Stack....");
        Simulator.comment("Create a Stack....");
        
        Stack stack = new Stack();
        
        System.out.println(stack.toString());
        System.out.println("Size  = " + stack.size());
        System.out.println("Empty = " + stack.isEmpty());
                
        
        
        
        Simulator.header("Stacks and Queues Test completed!");
    }   

}
