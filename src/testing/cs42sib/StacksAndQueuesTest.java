
/** required package class namespace */
package testing.cs42sib;

import collections.LinkedList;
import collections.Queue;
import collections.Stack;
import io.Output;
import testing.testclass.TestClass;

/**
 * StacksAndQueuesTest.java - description here...
 *
 * @author Mr. Wachs (login: lawrence.wachs)
 * @since Feb 15, 2018 
 * @instructor Mr. Wachs
 */
public class StacksAndQueuesTest 
{

    /** 
     * Default constructor for the class 
     */
    public StacksAndQueuesTest() {
        Output.header("Stacks and Queues unit test",true,false);
        stacksTest();
        queuesTest();
        Output.header("Stacks and Queues unit test",false,false);
    }

    /**
     * Tests the Stack object and methods
     */
    private void stacksTest() {        
        Output.header("Stack Testing",true,false);         
        final int SIZE = 10;        
        Output.comment("Create stack and display");
        Stack stack = new Stack();
        Output.show(stack.toString());        
        Output.comment("Check if empty, and size");
        Output.show("Empty = " + stack.isEmpty() + " and size = " + stack.size());        
        Output.comment("Push " + SIZE + " items onto the stack, and display");
        for (int i = 0; i < SIZE; i++) {            
            stack.push(new TestClass());
        }
        Output.show(stack.toString());        
        Output.comment("Check if empty, and size");
        Output.show("Empty = " + stack.isEmpty() + " and size = " + stack.size());  
        Output.comment("Create clone stack, and display");
        Stack cloneStack = stack.clone();
        Output.show(cloneStack.toString());        
        Output.comment("Check if the 2 stacks are equal");
        if (stack.equals(cloneStack)) {
            Output.show("stacks are equal");
        }
        else {
            Output.show("stacks are not equal");
        }        
        Output.comment("Pop half the original stack values, and display");
        for (int i = 0; i < SIZE / 2; i++) {
            stack.pop();
        }
        Output.show(stack.toString());                        
        Output.comment("Display clone again");
        Output.show(cloneStack.toString());        
        Output.comment("Check if the 2 stacks are equal again");
        if (stack.equals(cloneStack)) {
            Output.show("stacks are equal");
        }
        else {
            Output.show("stacks are not equal");
        }
        Output.comment("Wipe out (finalize) the clone, and display");
        cloneStack.finalize();
        Output.show(cloneStack.toString());        
        Output.comment("Check the top of both stacks, and display");
        TestClass t1 = (TestClass)stack.top();
        TestClass t2 = (TestClass)cloneStack.top();        
        Output.show(t1);
        Output.show(t2);        
        Output.comment("Create array from stack, and display");
        TestClass[] array = new TestClass[0];
        array = (TestClass[])stack.toArray(array);
        String text = "array = [";
        for (int i = 0; i < array.length-1; i++) {
            text += array[i].toString() + ",";
        }
        text += array[array.length-1].toString() + "]";
        Output.show(text);        
        Output.comment("Create LinkedList from stack, and display");
        LinkedList linkedList = stack.toLinkedList();
        Output.show("LinkedList = " + linkedList.toString());        
        Output.comment("Create new Stack from array, and display");
        Stack stack2 = new Stack(array);
        Output.show(stack2.toString());        
        Output.comment("Create new Stack from LinkedList, and display");
        Stack stack3 = new Stack(linkedList);
        Output.show(stack3.toString());    
        Output.header("Stack Testing",false,false); 
    }

    /**
     * Tests the Queue object and methods
     */
    private void queuesTest() {
        Output.header("Queue Testing",true,false);               
        final int SIZE = 10;        
        Output.comment("Create queue and display");        
        Queue queue = new Queue();
        Output.show(queue.toString());        
        Output.comment("Check if empty, and size");
        Output.show("Empty = " + queue.isEmpty() + " and size = " + queue.size());        
        Output.comment("Enqueue " + SIZE + " items onto the queue, and display");
        for (int i = 0; i < SIZE; i++) {
            queue.enqueue(new TestClass());
        }
        Output.show(queue.toString());        
        Output.comment("Check if empty, and size");
        Output.show("Empty = " + queue.isEmpty() + " and size = " + queue.size());                
        Output.comment("Create clone queue, and display");
        Queue cloneQueue = queue.clone();
        Output.show(cloneQueue.toString());                
        Output.comment("Check if the 2 queue are equal");
        if (queue.equals(cloneQueue)) {
            Output.show("queues are equal");
        }
        else {
            Output.show("queues are not equal");
        }        
        Output.comment("Dequeue half the original queue values, and display");
        for (int i = 0; i < SIZE / 2; i++) {
            queue.dequeue();
        }
        Output.show(queue.toString());                   
        Output.comment("Display clone again");
        Output.show(cloneQueue.toString());        
        Output.comment("Check if the 2 queue are equal again");
        if (queue.equals(cloneQueue)) {
            Output.show("queues are equal");
        }
        else {
            Output.show("queues are not equal");
        }
        Output.comment("Wipe out (finalize) the clone, and display");
        cloneQueue.finalize();
        Output.show(cloneQueue.toString());        
        Output.comment("Check the front and back of both queues, and display");
        TestClass t1 = (TestClass)queue.front();
        TestClass t2 = (TestClass)cloneQueue.front();        
        Output.show(t1);
        Output.show(t2);
        t1 = (TestClass)queue.back();
        t2 = (TestClass)cloneQueue.back();
        Output.show(t1);
        Output.show(t2);        
        Output.comment("Create array from queue, and display");
        TestClass[] array = new TestClass[0];
        array = (TestClass[])queue.toArray(array);
        String text = "array = [";
        for (int i = 0; i < array.length-1; i++) {
            text += array[i].toString() + ",";
        }
        text += array[array.length-1].toString() + "]";
        Output.show(text);        
        Output.comment("Create LinkedList from queue, and display");
        LinkedList linkedList = queue.toLinkedList();
        Output.show("LinkedList = " + linkedList.toString());        
        Output.comment("Create new queue from array, and display");
        Queue queue2 = new Queue(array);
        Output.show(queue2.toString());        
        Output.comment("Create new queue from LinkedList, and display");
        Queue queue3 = new Queue(linkedList);
        Output.show(queue3.toString());                
        Output.header("Queue Testing",false,false);        
    }

}
