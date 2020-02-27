
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
        
        Simulator.comment("Test toLinkedList, toArray, and constructors...");        
        LinkedList<Box> boxList = stack.toLinkedList();
        System.out.println(boxList.toString());
        Box[] boxArray = new Box[0];
        boxArray = (Box[])stack.toArray(boxArray);
        System.out.println("Array \t" + text.toString(boxArray));
        copy = new Stack(boxList);
        System.out.println(copy.toString());
        copy = new Stack(boxArray);
        System.out.println(copy.toString());        
        
        
        
        Queue queue = new Queue(copy);
        copy = new Stack(queue);
        
        System.out.println(queue.toString());
        System.out.println(copy.toString());
        
        
        
        
        Simulator.header("Stacks and Queues Test completed!");
    }   

}
