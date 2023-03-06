
/** Required package class namespace */
package collections;

/** Required API imports */
import java.io.Serializable;


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
 * @since March 3, 2023
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
        length = 0;                                 // Length set to zero
        top    = null;                              // Reference set to null
        System.gc();                                // Garbage collector called
    }
    
    /**
     * Accessor method for the number of items in the stack
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
     * String representation of this object
     *
     * @return The object represented as a String
     */
    @Override
    public String toString() {
        if (isEmpty()) return "Empty Stack";            // Nothing in the stack
        else {                                          // Stack has content
            String text = "Stack top -> [";             // Start a string
            Node current = top;                         // Reference to top
            while (current.next != null) {              // Traverse stack
                text += current.toString() + ",";       // Add to string
                current = current.next;                 // Mode to next node
            }            
            return text + current.toString() + "] <- bottom"; 
        }
    }
    
    /**
     * Adds (inserting) to the top of the stack. Note: the data must be valid
     * (not null) for it to be added
     * 
     * @param data the generic data to be added (pushed)
     * @return operation was successful (true) or not (false)
     */
    public boolean push(T data) {
        if (data == null) return false;     // Will not proceed
        Node node = new Node(data);         // Creating (instantiating) object
        if (!isEmpty()) node.next = top;    // Check if is the first node
        top = node;                         // Adjusting top reference (link)
        length++;                           // Increasing private property
        return true;                        // Operation was successful
    }
    
    
    
    
}