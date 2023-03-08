
/** Required package class namespace */
package testing.cs42sib;

/** Required imports */
import collections.Stack;
import io.Simulator;
import testing.cs40s.advancedclasses.Box;
import tools.Text;


/**
 * StacksQueuesTest.java - tests the concepts learned in this unit
 *
 * @author Mr. Wachs
 * @since Feb. 9, 2022, 8:01:03 a.m.
 */
public class StacksQueuesTest 
{

    /**
     * Default constructor, set class properties
     */
    public StacksQueuesTest() {
        Simulator.header("Stacks and Queues Test started...");
        
        // Create some objects for testing.....................................
        Simulator.comment("Create objects for testing...");
        
        final int MAX       = 10;       // For the number of objects to create
        final int WORD_SIZE = 5;        // For random words made in the objects
        
        Text text = new Text();         // For making random text
        
        // Create and test a Stack object.......................................
        Simulator.comment("Create and Test a stack object...");
        
        Stack stack = new Stack();
        
        // Test toString, size, isEmpty, and push methods......................
        Simulator.comment("Test toString, size, isEmpty, and push methods...");
        
        System.out.println("Empty = "  + stack.isEmpty() +
                           "\tSize = " + stack.size() +
                           "\t"        + stack.toString());
        
        // Loop through adding random values...................................
        Simulator.comment("Loop through adding random values");
        
        for (int i = 0; i < MAX; i++) {                 // Traverse to test edge
            String word = text.randomWord(WORD_SIZE);   // Create random word
            Box<String> box = new Box<>(word);
            stack.push(box);
            System.out.println("Empty = "  + stack.isEmpty() +
                               "\tSize = " + stack.size() +
                               "\t"        + stack.toString());
        }
        
        // Test clone method...................................................
        Simulator.comment("Test clone method...");
        
        Stack copy = stack.clone();
        System.out.println("Clone stack: " + copy.toString());
        
        
        
        
        
        
        
        
        // Loop through removing values........................................
        Simulator.comment("Loop through removing values");
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        Simulator.header("Stacks and Queues Test completed!");
    }   

}
