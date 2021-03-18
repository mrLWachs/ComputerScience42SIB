
/** Required package class namespace */
package collections;

/** Required imports */
import java.io.Serializable;
import java.lang.reflect.Array;

 
/**
 * Stack.java - a Stack ADT using generics. The stack class represents a 
 * last-in-first-out (LIFO) stack of generic objects. The usual push and pop
 * methods are provided, as well as a method to peek at the top item on the 
 * stack, a method to test for whether the stack is empty. When a stack is 
 * first created, it contains no items. It can be visualized as:
 * 
 *    top -------> item    items are removed (pop) and added (push) to the top
 *                 item
 *                 item
 *                 item
 *    bottom ----> item    a null at the bottom indicates an empty stack
 *
 * @author Mr. Wachs
 * @param <T> the generic object used in this class
 * @since Mar. 15, 2021, 9:53:12 a.m.
 */
public class Stack <T> implements Serializable
{

    /** Node reference to the top of the stack */
    private Node top;
    
    /** The number of nodes in the stack */
    private int length;
        
    
    /**
     * Default constructor, set class properties
     */
    public Stack() {
        finalize();                                     // wipe any current data
    }
    
    /**
     * Calls for garbage collection, and frees up memory - when the stack is 
     * destroyed
     */
    @Override
    public final void finalize() {
        length = 0;                                 // length set to zero
        top    = null;                              // reference set to null
        System.gc();                                // garbage collector called
    }
    
    /**
     * The number of items in the stack
     * 
     * @return the length of the stack
     */
    public int size() {
        return length;
    }
    
    /**
     * Determines if the stack is empty or not
     * 
     * @return empty stack (true) or not (false)
     */
    public boolean isEmpty() {
        return (length == 0);
    }
    
    /**
     * Adds data to the top of the stack
     * 
     * @param data the generic data to add
     * @return operation was successful (true) or not (false)
     */
    public boolean push(T data) {
        if (data == null) return false;                 // empty stack
        Node node = new Node(data);                     // create node
        if (!isEmpty()) node.next = top;                // add first node
        top = node;                                     // set to top of stack
        length++;                                       // increase length
        return true;                                    // operation successful
    }
    
    /**
     * Removes the data from the top of the stack, it mutates (changes) the 
     * stack
     * 
     * @return the data from the top of the stack
     */
    public T pop() {
        if (isEmpty()) return null;                     // no nodes in stack
        else {                                          // stack has some nodes
            length--;                                   // reduce length
            T data = (T)top.data;                       // store data
            top = top.next;                             // adjust top reference
            System.gc();                                // remove garbage memory
            return data;                                // data returned
        }        
    }
    
    /**
     * String representation of this object
     *
     * @return The object represented as a String
     */
    @Override
    public String toString() {
        if (isEmpty()) return "Empty Stack";
        else {
            String text = "Stack top  -> [";
            Node current = top;
            while (current.next != null) {
                text += current.toString() + ",";
                current = current.next;
            }            
            return text + current.toString() + "] <- bottom";
        }
    }
       
    /**
     * Deep comparison, determines if two objects are "equal" in this context
     *
     * @param object the object to compare to
     * @return the objects are "equal" (true) or not (false)
     */
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Stack)) return false;   // check object type
        try {                                           // error trap
            Stack stack1 = ((Stack)object).clone();     // clone/cast parameter
            Stack stack2 = this.clone();                // clone this stack
            if (stack1.size() != stack2.size()) return false;   // not same size
            while (!stack2.isEmpty()) {                 // traverse stacks
                T data1 = (T)stack1.pop();              // retrieve data
                T data2 = (T)stack2.pop();
                if (!data1.equals(data2)) return false; // compare data
            }
            return true;                                // all tests passed
        }
        catch (ClassCastException | NullPointerException e) {
            return false;                               // cannot cast, or null
        }
    }
       
    /**
     * a Deep clone, creates a duplicate object using new memory
     *
     * @return a "clone" of the object using new memory
     */
    @Override
    public Stack clone() {
        Stack<T> that = new Stack<>();                  // new empty stack
        Node current = top;                             // start at top node
        while (current != null) {                       // traverse stack
            T data = (T)current.data;                   // get data
            that.push(data);                            // push onto new stack
            current = current.next;                     // move to next node
        }                
        Stack<T> copy = new Stack<>();                  // second new stack
        while (!that.isEmpty()) {                       // traverse first stack
            T data = (T)that.pop();                     // get data
            copy.push(data);                            // push onto 2nd stack
        }        
        return copy;                                    // return clone
    }
    
    /**
     * Just "peeks" at the top of the stack without mutating (changing it) 
     * the structure of this stack
     * 
     * @return the data on the top
     */
    public T peek() {
        if (isEmpty()) return null;                     // no nodes in stack
        return (T)top.data;                             // return top data       
    }
    
    /**
     * Just "peeks" at top of stack without mutating the structure
     * 
     * @return the data on the top
     */
    public T top() {
        return peek();
    }

    /**
     * Turns the stack into a ADT LinkedList object
     * 
     * @return the Stack as a ADT LinkedList
     */
    public LinkedList<T> toLinkedList() {
        LinkedList<T> list = new LinkedList<>();        // create new list
        Node current = top;                             // start at top node        
        while (current != null) {                       // traverse stack   
            T data = (T)current.data;                   // retrieve data
            list.add(data);                             // add to list
            current = current.next;                     // move to next node
        }
        return list;                                    // return list
    }
    
    /**
     * Returns an array that contains the same data as the list
     * 
     * @param array the data type array
     * @return an array of generic type T
     */
    public T[] toArray(T[] array) {
        array = (T[])(Array.newInstance(
                array.getClass().getComponentType(), 
                length));                               // create array 
        Node current = top;                             // start at top node 
        for (int i = 0; i < length; i++) {              // traverse array
            array[i] = (T)current.data;                 // retrieve data
            current = current.next;                     // move to next node
        }
        return array;                                   // return array
    }
       
    /**
     * Constructor sets class data to the parameter 
     * 
     * @param queue the queue to set the stack to
     */
    public Stack(Queue queue) {
        this(queue.toLinkedList());
    }
    
    /**
     * Turns the stack into a ADT Queue object
     * 
     * @return the Stack as a ADT Queue
     */
    public Queue toQueue() {
        return new Queue(this);
    }
        
    /**
     * Constructor sets class data to the parameter 
     * 
     * @param list the LinkedList to set the stack to
     */
    public Stack(LinkedList<T> list) {
        finalize();                                     // wipe any current data
        for (int i = list.size()-1; i >= 0; i--) {      // traverse list
            T data = (T)list.get(i);                    // retrieve data
            push(data);                                 // push onto stack
        }
    }
    
    /**
     * Constructor sets class data to the parameter 
     * 
     * @param array the array to set the stack to
     */
    public Stack(T[] array) {
        finalize();                                     // wipe any current data
        for (int i = array.length-1; i >= 0; i--) {     // traverse array
            T data = (T)array[i];                       // retrieve data
            push(data);                                 // push onto stack
        }
    }
    
}
