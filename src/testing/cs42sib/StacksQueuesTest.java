
/** Required package class namespace */
package testing.cs42sib;

/** Required imports */
import collections.LinkedList;
import collections.Queue;
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
        
//        // Test the stack object...............................................
//        Simulator.comment("Test the stack object...");
//        
//        Stack stack = new Stack();
//        
//        // Test toString, size, isEmpty, and push methods......................
//        Simulator.comment("Test toString, size, isEmpty, and push methods...");
//        
//        System.out.println("Empty = "  + stack.isEmpty() +
//                           "\tSize = " + stack.size() +
//                           "\t"        + stack.toString());        
//        for (int i = 0; i < MAX; i++) {            
//            String word = text.randomWord(WORD_SIZE);
//            Box<String> box = new Box<>(word);
//            stack.push(box);            
//            System.out.println("Empty = "  + stack.isEmpty() +
//                               "\tSize = " + stack.size() +
//                               "\t"        + stack.toString());
//        }
//        
//        // Test clone method...................................................
//        Simulator.comment("Test clone method...");
//        
//        Stack copy = stack.clone();
//        System.out.println("Clone Stack \t\t\t" + copy.toString());
//        
//        // Test equals method..................................................
//        Simulator.comment("Test equals method...");
//        
//        if (stack.equals(copy)) System.out.println(stack + "\n==\n" + copy);
//        else                    System.out.println(stack + "\n!=\n" + copy);        
//        // Now change the copy
//        Simulator.comment("Now change the copy");
//        copy.finalize();
//        copy.push(new Box(text.randomWord(WORD_SIZE)));        
//        // Now check again
//        Simulator.comment("Now check again");
//        if (stack.equals(copy)) System.out.println(stack + "\n==\n" + copy);
//        else                    System.out.println(stack + "\n!=\n" + copy);
//        
//        // Re-clone the stack, and output
//        Simulator.comment("Re-clone the stack, and output");
//        copy = stack.clone();
//        System.out.println(copy.toString());
//        
//        // Text the pop method.................................................
//        Simulator.comment("Text the pop method...");
//        
//        System.out.println("Clone stack:" + 
//                           "\tEmpty = " + copy.isEmpty() +
//                           "\tSize = "  + copy.size() +
//                           "\t"         + copy.toString());
//        for (int i = 0; i < MAX+1; i++) { 
//            System.out.println("Popped -> " + copy.pop() + 
//                               "\tEmpty = " + copy.isEmpty() +
//                               "\tSize = "  + copy.size() +
//                               "\t"         + copy.toString());
//        }
//        
//        // Test peek (top is wrapper no testing needed)........................
//        Simulator.comment("Test peek (top is wrapper no testing needed)...");
//        
//        System.out.println("Clone Top = " + copy.top());
//        System.out.println("Stack Top = " + stack.top());
//        
//        // Test to array and to linked list....................................
//        Simulator.comment("Test to array and to linked list...");
//        
//        LinkedList<Box> list = stack.toLinkedList();
//        Box[] array = new Box[1];
//        array = (Box[])stack.toArray(array);        
//        System.out.println(list);
//        System.out.println(text.toString(array));
//        
//        // Test our constructors...............................................
//        Simulator.comment("Test our constructors...");
//        
//        Stack stackFromArray = new Stack(array);
//        Stack stackFromList  = new Stack(list);        
//        System.out.println(stackFromArray);
//        System.out.println(stackFromList);
        
        // Now we look at Queues...............................................        
        Simulator.comment("Test the Queue object...");
        
                
        Queue queue = new Queue();
        
        // Test toString, size, isEmpty, and push methods......................
        Simulator.comment("Test toString, size, isEmpty, and enqueue methods...");
        
        System.out.println("Empty = "  + queue.isEmpty() +
                           "\tSize = " + queue.size() +
                           "\t"        + queue.toString());        
        for (int i = 0; i < MAX; i++) {            
            String word = text.randomWord(WORD_SIZE);
            Box<String> box = new Box<>(word);
            queue.enqueue(box);            
            System.out.println("Empty = "  + queue.isEmpty() +
                               "\tSize = " + queue.size() +
                               "\t"        + queue.toString());
        }
        
        
        
        // Text the dequeue method...................................
        
        System.out.println("~~~~~~");
        System.out.println("Queue:" + 
                           "\tEmpty = " + queue.isEmpty() +
                           "\tSize = "  + queue.size() +
                           "\t"         + queue.toString());
        System.out.println("~~~~~~");
        for (int i = 0; i < MAX+1; i++) { 
            System.out.println("Dequeue -> " + queue.dequeue() +
                               "\tEmpty = " + queue.isEmpty() +
                               "\tSize = "  + queue.size() +
                               "\t"         + queue.toString());
        }
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
                
        Simulator.header("Stacks and Queues Test completed!");
    }   

}
