
/** required package class namespace */
package testing.cs42sib;

/** required imports */
import collections.Stack;
import io.Simulator;
import io.System;
import testing.cs40s.advancedclasses.Box;
import tools.Text;


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
        
        Simulator.comment("Test the Stack class....");
        
        Simulator.comment("Create a new Stack....");        
        Stack stack = new Stack();
        
        Simulator.comment("Test toString(), size(), and isEmpty()");
        System.out.println("Empty = "  + stack.isEmpty() +
                           "\tSize = " + stack.size() + 
                           "\t"        + stack.toString());
                
        Text text = new Text();
        final int MAX = 10;
        
        for (int i = 0; i < MAX; i++) {
            Box<String> box = new Box<>(text.randomWord());
            stack.push(box);
            System.out.println("Empty = "  + stack.isEmpty() +
                               "\tSize = " + stack.size() + 
                               "\t"        + stack.toString());
        }
        
        
        Simulator.header("Stacks and Queues Test completed!");
    }   

}
