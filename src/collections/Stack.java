
/** required package class namespace */
package collections;

/** required imports */
import java.io.Serializable;

 
/**
 * Stack.java - a Stack ADT using generics. The stack class represents a 
 * last-in-first-out (LIFO) stack of generic objects. The usual push and pop
 * methods are provided, as well as a method to peek at the top item on the 
 * stack, a method to test for whether the stack is empty. When a stack is 
 * first created, it contains no items. It can be visualized as:
 * 
 *       top -------> item    (items are removed and added to the top)
 *                    item
 *                    item
 *                    item
 *       bottom ----> item    (a null at the bottom indicates an empty stack)
 *
 * @author Mr. Wachs
 * @param <T> the generic object used in this class
 * @since Feb. 24, 2020, 10:14:33 a.m.
 */
public class Stack <T extends Comparable<T>> implements Serializable
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
     * Determines if the stack is empty or not
     * 
     * @return empty stack (true) or not (false)
     */
    public boolean isEmpty() {
        return length == 0;
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
     * String representation of this object
     *
     * @return The object represented as a String
     */
    @Override
    public String toString() {
        if (isEmpty()) return "Stack = empty";          // no nodes to display
        else {
            String text = "Stack = [";                  // starting character
            Node current = top;                         // start at top node
            while (current.next != null) {              // traverse stack
                text += current.toString() + ",";       // append data
                current = current.next;                 // move to next node
            }            
            return text + current.toString() + "]";     // append end character
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
        return super.equals(object);
    }
        
    /**
     * a Deep clone, creates a duplicate object using new memory
     *
     * @return a "clone" of the object using new memory
     */
    @Override
    public Stack clone() {
        return this;
    }

}