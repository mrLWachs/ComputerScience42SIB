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
 * @since 22-Feb-2022, 10:40:47 AM
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
        finalize();                                     // Wipe any current data
    }
    
    /**
     * Calls for garbage collection, and frees up memory - when the stack is 
     * destroyed
     */
    @Override
    public final void finalize() {
        length = 0;                                 // The length set to zero
        top    = null;                              // Reference set to null
        System.gc();                                // Garbage collector called
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
     * Adds data to the top of the stack
     * 
     * @param item the generic data to add
     * @return operation was successful (true) or not (false)
     */
    public boolean push(T item) {
        if (item == null) return false;     // Method is over (error check)        
        Node node = new Node(item);         // Create (instantiate) node object
        if (!isEmpty()) node.next = top;    // Adding not the first node
        top = node;                         // Set the top entry point 
        length++;                           // Track an increase in the length
        return true;                        // Operation successfull
    }
    
    /**
     * Removes the data from the top of the stack, it mutates (changes) the 
     * stack
     * 
     * @return the data from the top of the stack
     */
    public T pop() {
        if (isEmpty()) return null;     // Error check, no nodes in stack
        else {
            length--;                   // Reduce the length
            T data = (T) top.data;      // Temporarily store the data
            top = top.next;             // Adjust the top reference
            System.gc();                // Remove garbage memory
            return data;                // Temporary data returned
        }
    }
    
    /**
     * Just "peeks" at the top of the stack without mutating (changing it) 
     * the structure of this stack
     * 
     * @return the data on the top
     */
    public T peek() {
        if (isEmpty()) return null;                     // No nodes in stack
        return (T)top.data;                             // Return top data  
    }
    
    /**
     * Just "peeks" at top of stack without mutating the structure - NOTE: this
     * is a "wrapper" method for the peek method (a wrapper method is an 
     * adapter or a alternative name to call for an existing method to provide 
     * a simpler interface for users)
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
        LinkedList<T> list = new LinkedList<>();    // Create a list
        Node current = top;                         // Start a reference to top
        while (current != null) {                   // Traverse stack
            T data = (T)current.data;               // Retrieve current data
            list.add(data);                         // Add to the list
            current = current.next;                 // Move to the next node
        }        
        return list;                                // Return filled list
    }
    
    /**
     * Returns an array that contains the same data as the list
     * 
     * @return an array of generic type T
     */
    public T[] toArray(T[] array) {
        array = (T[])(Array.newInstance(
                array.getClass().getComponentType(), 
                length));                               // Create generic array 
        Node current = top;                             // Start at top node 
        for (int i = 0; i < length; i++) {              // Traverse array
            array[i] = (T)current.data;                 // Retrieve data
            current = current.next;                     // Move to next node
        }
        return array;                                   // Return filled array
    }
    
    /**
     * Turns the stack into a ADT Queue object
     * 
     * @return the Stack as a ADT Queue
     */
    public Queue<T> toQueue() {
        return new Queue(this);
    }
    
    /**
     * Constructor sets class data to the parameter 
     * 
     * @param linkedList the LinkedList to set the stack to
     */
    public Stack(LinkedList<T> linkedList) {
        finalize();                                         // Wipe any content
        for (int i = linkedList.size()-1; i >= 0; i--) {    // Reverse traverse
            T data = (T)linkedList.get(i);                  // Get data
            push(data);                                     // Add to stack
        }
    }
    
    /**
     * Constructor sets class data to the parameter 
     * 
     * @param array the array to set the stack to
     */
    public Stack(T[] array) {
        finalize();                                         // Wipe any content
        for (int i = array.length-1; i >= 0; i--) {         // Reverse traverse
            T data = (T)array[i];                           // Get data
            push(data);                                     // Add to stack
        }
    }
    
    /**
     * Constructor sets class data to the parameter 
     * 
     * @param queue the queue to set the stack to
     */
    public Stack(Queue<T> queue) {
        this(queue.toLinkedList());
    }
     
    /**
     * String representation of this object
     *
     * @return The object represented as a String
     */
    @Override
    public String toString() {
        if (isEmpty()) return "Empty Stack";            // Empty Stack
        else {                                          // Existing stack
            String text = "Stack top  -> [";            // String variable
            Node current = top;                         // Start at top
            while (current.next != null) {              // Loop through stack
                text += current.toString() + ",";       // Add to string
                current = current.next;                 // Move to next node
            }            
            return text + current.toString() + "] <- bottom";   // Return string
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
        if (!(object instanceof Stack)) return false;   // Check object type
        try {                                           // Error trap
            Stack stack1 = ((Stack)object).clone();     // Clone/cast parameter
            Stack stack2 = this.clone();                // Clone this stack
            if (stack1.size() != stack2.size()) return false;   // Not same size
            while (!stack2.isEmpty()) {                 // Traverse stacks
                T data1 = (T)stack1.pop();              // Retrieve data
                T data2 = (T)stack2.pop();
                if (!data1.equals(data2)) return false; // Compare data
            }
            return true;                                // All tests passed
        }
        catch (ClassCastException | NullPointerException e) {
            return false;                               // Cannot cast, or null
        }
    }
       
    /**
     * a Deep clone, creates a duplicate object using new memory
     *
     * @return a "clone" of the object using new memory
     */
    @Override
    public Stack clone() {
        Stack<T> that = new Stack<>();                  // New empty stack
        Node current = this.top;                        // Start at top node
        while (current != null) {                       // Traverse stack
            T data = (T)current.data;                   // Get data (from this)
            that.push(data);                            // Push onto that stack
            current = current.next;                     // Move to next node
        }                
        Stack<T> copy = new Stack<>();                  // Second new stack
        while (!that.isEmpty()) {                       // Traverse first stack
            T data = (T)that.pop();                     // Get data
            copy.push(data);                            // Push onto 2nd stack
        }        
        return copy;                                    // Return clone
    }
    
}