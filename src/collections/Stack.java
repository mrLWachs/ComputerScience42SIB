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
        return 0;
    }
    
    /**
     * Determines if the stack is empty or not
     * 
     * @return empty stack (true) or not (false)
     */
    public boolean isEmpty() {
        return false;
    }
    
    /**
     * Adds data to the top of the stack
     * 
     * @param item the generic data to add
     * @return operation was successful (true) or not (false)
     */
    public boolean push(T item) {
        return false;
    }
    
    /**
     * Removes the data from the top of the stack, it mutates (changes) the 
     * stack
     * 
     * @return the data from the top of the stack
     */
    public T pop() {
        return null;
    }
    
    /**
     * Just "peeks" at the top of the stack without mutating (changing it) 
     * the structure of this stack
     * 
     * @return the data on the top
     */
    public T peek() {
        return null;
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
        return null;
    }
    
    /**
     * Returns an array that contains the same data as the list
     * 
     * @return an array of generic type T
     */
    public T[] toArray() {
        return null;
    }
    
    /**
     * Turns the stack into a ADT Queue object
     * 
     * @return the Stack as a ADT Queue
     */
    public Queue<T> toQueue() {
        return null;
    }
    
    /**
     * Constructor sets class data to the parameter 
     * 
     * @param linkedList the LinkedList to set the stack to
     */
    public Stack(LinkedList<T> linkedList) {
        
    }
    
    /**
     * Constructor sets class data to the parameter 
     * 
     * @param array the array to set the stack to
     */
    public Stack(T[] array) {
        
    }
    
    /**
     * Constructor sets class data to the parameter 
     * 
     * @param queue the queue to set the stack to
     */
    public Stack(Queue<T> queue) {
        
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