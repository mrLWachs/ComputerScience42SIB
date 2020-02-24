
/** required package class namespace */
package collections;

import java.io.Serializable;

 
/**
 * Stack.java - description
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
        finalize();
    }
    
    /**
     * Calls for garbage collection, and frees up memory - when the stack is 
     * destroyed
     */
    @Override
    public final void finalize() {
        length = 0;                                     // length set to zero
        top    = null;                                  // reference set to null
        System.gc();                                    // garbage collector called
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
     * String representation of this object
     *
     * @return The object represented as a String
     */
    @Override
    public String toString() {
        
        
        
        
        return "Stack: " + super.toString();
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
