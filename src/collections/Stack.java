
/** required package class namespace */
package collections;

/** required imports */
import java.io.Serializable;
import java.lang.reflect.Array;

/**
 * Stack.java - a Stack ADT using generics
 *
 * @author Mr. Wachs
 * @param <T> the generic object used in this class
 * @since 1-Mar-2019 
 * @instructor Mr. Wachs
 */
public class Stack <T> implements Serializable, Comparable<Object>
{

    /** Node reference to the top node in the stack */
    private Node top;
    /** The number of nodes in the stack */
    private int length;
    
    /**
     * Default constructor for the class, sets class properties
     */
    public Stack() {
        top    = null;                                  // reference null
        length = 0;                                     // set to 0
    }

    /**
     * Constructor for the class, sets class properties
     * 
     * @param list the LinkedList to set the stack to
     */
    public Stack(LinkedList list) {
        top    = null;                                  // reference null
        length = 0;                                     // set to 0
        for (int i = 0; i < list.size(); i++) {         // traverse list
            T data = (T)list.get(i);                    // retrieve data
            push(data);                                 // push onto stack
        }
    }
    
    /**
     * Constructor for the class, sets class properties
     * 
     * @param array the array to set the stack to 
     */
    public Stack(T[] array) {
        top    = null;                                  // reference null
        length = 0;                                     // set to 0
        for (int i = 0; i < array.length; i++) {        // traverse array
            T data = (T)array[i];                       // retrieve data
            push(data);                                 // push onto stack
        }
    }
    
    /**
     * Constructor for the class, sets class properties
     * 
     * @param queue the queue to set the stack to 
     */
    public Stack(Queue queue) {
        top    = null;                                  // reference null
        length = 0;                                     // set to 0
        for (int i = 0; i < queue.size(); i++) {        // traverse queue
            T data = (T)queue.dequeue();                // retrieve data
            push(data);                                 // push onto stack
        }
    }
    
    /**
     * Adds data to the top of the stack
     * 
     * @param data the generic data to add
     * @return operation was successful (true) or not (false)
     */
    public boolean push(T data) {
        if (data == null) return false;                 // empty stack        
        try {
            Node<T> node = new Node<>(data);            // create node
            if (!isEmpty()) node.next = top;            // add first node
            top = node;                                 // set to top of stack
            length++;                                   // increase length
        } catch (OutOfMemoryError error) {              // error trap
            System.out.println("Stack overflow");       // output error
            return false;                               // unsuccessful
        }        
        return true;                                    // operation successful
    }
    
    /**
     * Removes the data from the top of the stack
     * 
     * @return the data from the top of the stack
     */
    public T pop() {
        if (isEmpty()) return null;             // no nodes in stack
        else {                                  // stack has some nodes            
            T    data = peek();                 // get top data
            Node temp = top;                    // reference to current top
            top       = top.next;               // adjust to new top
            temp.next = null;                   // sever old top's connection
            length--;                           // reduce length
            System.gc();                        // call garbage collection
            return data;                        // data returned
        }
    }
    
    /**
     * Just "peeks" at top of stack without mutating the structure
     * 
     * @return the data on the top
     */
    public T peek() {
        if (isEmpty()) return null;                 // no nodes in stack
        return         (T)top.data;                 // return top data
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
        return length == 0;
    }
    
    /**
     * String representation of this object
     *
     * @return The object represented as a String
     */
    @Override
    public String toString() {
        if (isEmpty()) return "Empty stack";            // no nodes to display
        else {
            String text = "Stack = [";                  // starting character
            Node current = top;                         // start at top node
            while (current.next != null) {              // traverse stack
                text += current.toString() + ", ";       // append data
                current = current.next;                 // move to next node
            }            
            return text + current.toString() + "]";     // append end character
        }
    }
        
    /**
     * Determines if two objects are "equal" in this context
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
            if (stack1.size() != stack2.size())         
                return false;                           // stacks not same size
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
     * Creates a duplicate object using new memory
     *
     * @return a "clone" of the object using new memory
     */
    @Override
    public Stack clone() {
        Stack<T> stack1 = new Stack<>();                // new empty stack
        Node current = top;                             // start at top node
        while (current != null) {                       // traverse stack
            T data = (T)current.data;                   // get data
            stack1.push(data);                          // push onto new stack
            current = current.next;                     // move to next node
        }                
        Stack<T> stack2 = new Stack<>();                // second new stack
        while (!stack1.isEmpty()) {                     // traverse first stack
            T data = (T)stack1.pop();                   // get data
            stack2.push(data);                          // push onto 2nd stack
        }        
        return stack2;                                  // return clone
    }

    
    /**
     * Compares two objects and the result is a positive integer if this 
     * object is greater than the argument, a zero if the objects are equal,
     * and a negative integer if this object is less than the argument
     *
     * @param object the object to compare to
     * @return 0 if the objects are equal, a negative if this object is less 
     * than the argument (or any errors), and a positive if this object is 
     * greater than the argument
     */
    @Override
    public int compareTo(Object object) {
        if (!(object instanceof Stack)) return -1;      // check object type
        try {                                           // error trap
            Stack stack1 = this.clone();                // clone/cast parameter
            Stack stack2 = ((Stack)object).clone();     // clone this stack
            if (stack1.size() < stack2.size())         
                return -1;                              // stacks not same size
            else if (stack1.size() > stack2.size())         
                return 1;                               // stacks not same size
            else if (stack1.equals(stack2))             // stacks same size
                return 0;
            else {                
                return 0;                               // potential to expand
            }         
        }
        catch (ClassCastException | NullPointerException e) {
            return -1;                                  // cannot cast, or null
        }
    }

    /**
     * Frees up all memory used by this object
     */
    @Override
    public final void finalize() {
        length = 0;                                     // length set to zero
        top    = null;                                  // reference set to null
        System.gc();                                    // garbage collector called
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
    
}
