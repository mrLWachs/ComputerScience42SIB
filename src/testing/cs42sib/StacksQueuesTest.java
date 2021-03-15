
/** required package class namespace */
package testing.cs42sib;

/** required imports */
import collections.Stack;
import io.Simulator;
import testing.cs40s.advancedclasses.Box;
import tools.Text;


/**
 * StacksQueuesTest.java - tests the concepts learned in this unit
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
        
        // Create objects for testing..........................................        
        Simulator.comment("Create objects for testing...");
        
        final int MAX       = 10;
        final int WORD_SIZE = 5;
        
        Text text = new Text();
        
        // Test the stack object...............................................
        Simulator.comment("Test the stack object...");
        
        Stack stack = new Stack();
        
        // Test toString, size, isEmpty, and push methods......................
        Simulator.comment("Test toString, size, isEmpty, and push methods...");
        
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
        
        // Test clone method...................................................
        Simulator.comment("Test clone method...");
        
        Stack copy = stack.clone();
        System.out.println("Clone Stack \t\t\t" + copy.toString());
        
        // Test equals method..................................................
        Simulator.comment("Test equals method...");
        
        if (stack.equals(copy)) System.out.println(stack + "\n==\n" + copy);
        else                    System.out.println(stack + "\n!=\n" + copy);        
        // Now change the copy
        Simulator.comment("Now change the copy");
        copy.finalize();
        copy.push(new Box(text.randomWord(WORD_SIZE)));        
        // Now check again
        Simulator.comment("Now check again");
        if (stack.equals(copy)) System.out.println(stack + "\n==\n" + copy);
        else                    System.out.println(stack + "\n!=\n" + copy);
        
        // Re-clone the stack, and output
        Simulator.comment("Re-clone the stack, and output");
        copy = stack.clone();
        System.out.println(copy.toString());
        
        // Text the pop method.................................................
        Simulator.comment("Text the pop method...");
        
        System.out.println("Clone stack:" + 
                           "\tEmpty = " + stack.isEmpty() +
                           "\tSize = "  + stack.size() +
                           "\t"         + stack.toString());
        for (int i = 0; i < MAX+1; i++) { 
            System.out.println("Popped -> " + stack.pop() + 
                               "\tEmpty = " + stack.isEmpty() +
                               "\tSize = "  + stack.size() +
                               "\t"         + stack.toString());
        }
        
        
        
                
        Simulator.header("Stacks and Queues Test completed!");
    }   

}
