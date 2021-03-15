
/** required package class namespace */
package testing.cs42sib;

/** required imports */
import collections.Stack;
import io.Simulator;
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
        
        // Test the stack object...
        
        final int MAX       = 10;
        final int WORD_SIZE = 5;
        
        Text  text  = new Text();
        Stack stack = new Stack();
        
        // Test toString, size, isEmpty, and push methods
        
        System.out.println("Empty = "  + stack.isEmpty() +
                           "\tSize = " + stack.size() +
                           "\t"        + stack.toString());
        
        for (int i = 0; i < MAX; i++) {            
            String word = text.randomWord(WORD_SIZE);
            Box<String> box = new Box<>(word);
            stack.push(box);            
            System.out.println("Empty = "  + stack.isEmpty() +
                               "\tSize = " + stack.size() +
                               "\t"        + stack.toString());
        }
        
        
                
        Simulator.header("Stacks and Queues Test completed!");
    }   

}
