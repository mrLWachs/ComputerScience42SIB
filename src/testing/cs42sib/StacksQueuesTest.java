
/** required package class namespace */
package testing.cs42sib;

/** required imports */
import collections.LinkedList;
import collections.Queue;
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
        
        Simulator.comment("Testing the Stack...");
        Simulator.comment("Test the Stack constructor....");
        
        final int MAX       = 10;
        final int WORD_SIZE = 5;
                
        Stack stack = new Stack();
        Text  text  = new Text();
        
        Simulator.comment("Test toString, size, isEmpty, and push...");        
        System.out.println("Empty = "  + stack.isEmpty() +
                           "\tSize = " + stack.size() + 
                           "\t"        + stack.toString());        
        for (int i = 0; i < MAX; i++) {
            Box<String> box = new Box<>(text.randomWord(WORD_SIZE));
            stack.push(box);
            System.out.println("Empty = "  + stack.isEmpty() +
                               "\tSize = " + stack.size() + 
                               "\t"        + stack.toString());
        }
        
        Simulator.comment("Test clone......");
        Stack copy = stack.clone();
        System.out.println("Empty = "  + copy.isEmpty() +
                           "\tSize = " + copy.size() + 
                           "\t"        + copy.toString());
        
        Simulator.comment("Test equals......");
        if (stack.equals(copy)) System.out.println("stack == copy");
        else                    System.out.println("stack != copy");
        
        Simulator.comment("Test pop......");
        for (int i = 0; i < MAX; i++) {
            Box box = (Box)copy.pop();
            System.out.print(box.toString() + "\t->\t");
            System.out.println("Empty = "  + copy.isEmpty() +
                               "\tSize = " + copy.size() + 
                               "\t"        + copy.toString());
        }
        
        Simulator.comment("Test equals (again)......");
        if (stack.equals(copy)) System.out.println("stack == copy");
        else                    System.out.println("stack != copy");
        
        Simulator.comment("Test peek (or top)......");
        System.out.println(stack.peek() + "\t -> \t" + stack.toString());
        System.out.println(copy.peek()  + "\t -> \t" + copy.toString());
        
        Simulator.comment("Test toLinkedList...");  
        LinkedList<Box> boxList = stack.toLinkedList();
        System.out.println(boxList.toString());
        
        Simulator.comment("Test toArray...");
        Box[] boxArray = new Box[0];
        boxArray = (Box[])stack.toArray(boxArray);
        System.out.println("Array \t" + text.toString(boxArray));
        
        Simulator.comment("Test LinkedList constructors...");
        copy = new Stack(boxList);
        System.out.println(copy.toString());
        
        Simulator.comment("Test Array constructors...");
        copy = new Stack(boxArray);
        System.out.println(copy.toString());        
        
        ///////////////////////////////////////////////////////////////////
        
        Simulator.comment("Testing the Queue...");
        Simulator.comment("Test the Queue constructor....");
                        
        Queue queue = new Queue();
        
        Simulator.comment("Test toString, size, isEmpty, and enqueue...");        
        System.out.println("Empty = "  + queue.isEmpty() +
                           "\tSize = " + queue.size() + 
                           "\t"        + queue.toString());        
        for (int i = 0; i < MAX; i++) {
            Box<String> box = new Box<>(text.randomWord(WORD_SIZE));
            queue.enqueue(box);
            System.out.println("Empty = "  + queue.isEmpty() +
                               "\tSize = " + queue.size() + 
                               "\t"        + queue.toString());
        }
        
        Simulator.comment("Test clone......");
        Queue duplicate = queue.clone();
        System.out.println("Empty = "  + duplicate.isEmpty() +
                           "\tSize = " + duplicate.size() + 
                           "\t"        + duplicate.toString());
        
        Simulator.comment("Test equals......");
        if (queue.equals(duplicate)) System.out.println("queue == duplicate");
        else                         System.out.println("queue != duplicate");
        
        Simulator.comment("Test dequeue......");
        for (int i = 0; i < MAX; i++) {
            Box box = (Box)duplicate.dequeue();
            System.out.print(box.toString() + "\t->\t");
            System.out.println("Empty = "  + duplicate.isEmpty() +
                               "\tSize = " + duplicate.size() + 
                               "\t"        + duplicate.toString());
        }
        
        Simulator.comment("Test equals (again)......");
        if (queue.equals(duplicate)) System.out.println("queue == duplicate");
        else                         System.out.println("queue != duplicate");
        
        Simulator.comment("Test peek (or top)......");
        System.out.println(queue.front()     + "\t -> \t" + queue.toString());
        System.out.println(duplicate.front() + "\t -> \t" + duplicate.toString());
        
        Simulator.comment("Test toLinkedList...");          
        boxList = queue.toLinkedList();
        System.out.println(boxList.toString());
        
        Simulator.comment("Test toArray...");
        boxArray = new Box[0];
        boxArray = (Box[])queue.toArray(boxArray);
        System.out.println("Array \t" + text.toString(boxArray));
        
        Simulator.comment("Test LinkedList constructors...");
        duplicate = new Queue(boxList);
        System.out.println(duplicate.toString());
        
        Simulator.comment("Test Array constructors...");
        duplicate = new Queue(boxArray);
        System.out.println(duplicate.toString());        
        
        ///////////////////////////////////////////////////////////////////
        
        Simulator.comment("Testing Stack to Queue constructors...");
        duplicate = new Queue(stack);
        System.out.println(stack.toString());  
        System.out.println(duplicate.toString());  
        
        Simulator.comment("Testing Queue to Stack constructors...");
        copy = new Stack(queue);
        System.out.println(queue.toString());  
        System.out.println(copy.toString()); 
                
        Simulator.header("Stacks and Queues Test completed!");
    }   

}
