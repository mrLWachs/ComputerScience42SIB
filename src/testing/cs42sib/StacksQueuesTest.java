
/** Required package class namespace */
package testing.cs42sib;

/** Required imports */
import collections.LinkedList;
import collections.Stack;
import collections.Queue;
import tools.Text;
import io.System;
import io.Simulator;

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
        
        // Create objects for testing..........................................        
        final int MAX       = 10;           // Constant for size of our objects
        final int WORD_SIZE = 5;            // Constant for size of random words
        
        Text text = new Text();             // Create text object for use
        
        // Test the stack object...............................................        
        Stack stack = new Stack();          // Instantiate stack object
        
        // Test toString, size, isEmpty, and push methods......................        
        System.out.println("Empty = "  + stack.isEmpty() +
                           "\tSize = " + stack.size() +
                           "\t"        + stack.toString()); // Output data
        
        // Loop through adding random values...................................
        for (int i = 0; i < MAX; i++) {                         // Traverse 
            String word = text.randomWord(WORD_SIZE);           // Random word
            stack.push(word);                                   // Add to stack
            System.out.println("Empty = "  + stack.isEmpty() +
                               "\tSize = " + stack.size() +
                               "\t"        + stack.toString()); // Output data
        }
        
        // Test clone method...................................................        
        Stack copy = stack.clone();                                 // Clone
        System.out.println("Clone Stack \t\t\t" + copy.toString()); // Output
        
        // Test equals method..................................................        
        if (stack.equals(copy)) System.out.println(stack + "\n==\n" + copy);
        else                    System.out.println(stack + "\n!=\n" + copy); 
        
        // Now change the copy.................................................
        copy.finalize();                            // Wipe out stack
        copy.push(text.randomWord(WORD_SIZE));      // Add random word
        
        // Now check again.....................................................
        if (stack.equals(copy)) System.out.println(stack + "\n==\n" + copy);
        else                    System.out.println(stack + "\n!=\n" + copy);
        
        // Re-clone the stack, and output......................................
        copy = stack.clone();                                   // Clone
        System.out.println(copy.toString());                    // Output
        
        // Test the pop method.................................................
        System.out.println("Clone stack:" + 
                           "\tEmpty = " + copy.isEmpty() +
                           "\tSize = "  + copy.size() +
                           "\t"         + copy.toString()); // Output data
        
        // Loop through removing values........................................
        for (int i = 0; i < MAX+1; i++) {                       // Traverse
            System.out.println("Popped -> " + copy.pop() + 
                               "\tEmpty = " + copy.isEmpty() +
                               "\tSize = "  + copy.size() +
                               "\t"         + copy.toString()); // Output data
        }
        
        // Test peek (top is wrapper no testing needed)........................
        System.out.println("Clone Top = " + copy.top());        // Show top
        System.out.println("Stack Top = " + stack.top());       // Show top
        
        // Test to array and to linked list....................................
        LinkedList<String> list = stack.toLinkedList();     // Convert to list
        String[] array = new String[0];                     // Create array
        array = (String[])stack.toArray(array);             // Convert to array
        System.out.println("List from Stack  \t" + list);   // Output both
        System.out.println("Array from Stack \t\t\t" + text.toString(array));
        
        // Test our constructors...............................................
        Stack stackFromArray = new Stack(array);        // Construct from array
        Stack stackFromList  = new Stack(list);         // Construct from list
        System.out.println("From Array\t" + stackFromArray);    // Output both
        System.out.println("From List \t" + stackFromList);
        
        
        // Now we look at Queues...............................................
        Queue queue = new Queue();          // Instantiate queue object
        
        // Test toString,size,isEmpty, and enqueue methods.....................
        System.out.println("Empty = "  + queue.isEmpty() +
                           "\tSize = " + queue.size() +
                           "\t"        + queue.toString());    // Output data
        
        // Loop through adding random values...................................       
        for (int i = 0; i < MAX; i++) {                         // Traverse            
            String word = text.randomWord(WORD_SIZE);           // Random word
            queue.enqueue(word);                                // Add to queue
            System.out.println("Empty = "  + queue.isEmpty() +
                               "\tSize = " + queue.size() +
                               "\t"        + queue.toString()); // Output data
        }
        
        // Test clone method...................................................
        Queue duplicate = queue.clone();                            // Clone
        System.out.println("Clone Queue \t\t\t" + duplicate.toString());
        
        // Test equals method..................................................
        if (queue.equals(duplicate)) 
            System.out.println(queue + "\n==\n" + duplicate);
        else                    
            System.out.println(queue + "\n!=\n" + duplicate);    
        
        // Now change the duplicate............................................
        duplicate.finalize();                            // Wipe out queue
        duplicate.enqueue(text.randomWord(WORD_SIZE));   // Add random word
        
        // Now check again.....................................................
        if (duplicate.equals(duplicate)) 
            System.out.println(queue + "\n==\n" + duplicate);
        else                    
            System.out.println(queue + "\n!=\n" + duplicate);
        
        // Re-clone the queue, and output......................................
        duplicate = queue.clone();                                  // Clone
        System.out.println(duplicate.toString());                   // Output
        
        // Test the dequeue method.............................................
        System.out.println("Clone queue:" + 
                           "\tEmpty = " + duplicate.isEmpty() +
                           "\tSize = "  + duplicate.size() +
                           "\t"         + duplicate.toString()); // Output data
        
        // Loop through removing values........................................
        for (int i = 0; i < MAX+1; i++) {                        // Traverse
            System.out.println("Dequeued -> " + duplicate.dequeue()+ 
                               "\tEmpty = " + duplicate.isEmpty() +
                               "\tSize = "  + duplicate.size() +
                               "\t"         + duplicate.toString()); // Output
        }
        
        // Test front and back.................................................
        System.out.println("Clone Front = " + duplicate.front());   // Fronts
        System.out.println("Queue Front = " + queue.front());
        System.out.println("Clone Back  = " + duplicate.back());    // Backs
        System.out.println("Queue Back  = " + queue.back());
                
        // Test to array and to linked list....................................
        list = queue.toLinkedList();                // Convert to list
        array = new String[1];                      // Re-dimension array
        array = (String[])queue.toArray(array);     // Convert to Array
        System.out.println("List from Queue  \t" + list);       // Output both
        System.out.println("Array from Queue \t\t\t" + text.toString(array));
        
        // Test our constructors...............................................
        Queue queueFromArray = new Queue(array);        // Construct from array
        Queue queueFromList  = new Queue(list);         // Construct from list 
        System.out.println("From Array\t" + queueFromArray);    // Output both
        System.out.println("From List \t" + queueFromList);
        
        // Test constructors from stack to queue (and back)....................
        Stack fromQueueStack = new Stack(queue);
        Queue fromStackQueue = new Queue(fromQueueStack);
        System.out.println(queue          + "\t into \t" + fromQueueStack);
        System.out.println(fromQueueStack + "\t into \t" + fromStackQueue);
        
        Simulator.header("Stacks and Queues Test completed!");
    }   

}
