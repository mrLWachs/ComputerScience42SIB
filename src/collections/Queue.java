
/** Required package class namespace */
package collections;

/** Required imports */
import java.io.Serializable;


/**
 * Queue.java - a Queue ADT using generics. It is a collection of entities that 
 * are maintained in a sequence and can be modified by the addition of entities 
 * at one end of the sequence and removal from the other end of the sequence. 
 * By convention, the end of the sequence at which elements are added is called 
 * the back, tail, or rear of the queue and the end at which elements are 
 * removed is called the head or front of the queue, analogously to the words 
 * used when people line up to wait for goods or services. It can be 
 * visualized as:
 * 
 *   Add items (enqueue)                      Remove items (dequeue)
 *   back (or tail, rear)                     front (or head)
 *    |                                         |
 *    V                                         V
 *   item  item  item  item  item  item  item  item  
 *                                             (null indicates empty queue)
 *
 * @author Mr. Wachs
 * @param <T> the generic object used in this class
 * @since 22-Feb-2022, 10:40:54 AM
 */
public class Queue <T> implements Serializable
{

    /**
     * Default constructor, set class properties
     */
    public Queue() {
        
    }     
    
    /**
     * Frees up all memory used by this object
     */
    @Override
    public final void finalize() {
        
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
     * The number of items in the stack
     * 
     * @return the length of the stack
     */
    public int size() {
        return 0;
    }
        
    /**
     * Adds data to the back (tail) of the queue
     * 
     * @param data the generic data to add
     * @return the operation was successful (true) or not (false)
     */
    public boolean enqueue(T data) {
        return false;
    }
    
    /**
     * Removes an item from the tail of the queue
     * 
     * @return the generic data in the queue
     */
    public T dequeue() {
        return null;
    }
    
    /**
     * Just "peeks" at front of the queue without mutating the structure
     * 
     * @return the data at the front
     */
    public T front() {
        return null;
    }
    
    /**
     * Just "peeks" at back of the queue without mutating the structure
     * 
     * @return the data at the back
     */
    public T back() {
        return null;
    }
        
    /**
     * Turns the queue into a ADT LinkedList object
     * 
     * @return the Stack as a ADT LinkedList
     */
    public LinkedList<T> toLinkedList() {
        return null;
    }
    
    /**
     * Returns an array that contains the same data as the list
     * 
     * @param array the data type array
     * @return an array of generic type T
     */
    public T[] toArray(T[] array) {
        return null;
    }
    
    /**
     * Turns the queue into a ADT stack object
     * 
     * @return the queue as a ADT stack
     */
    public Stack toStack() {
        return null;
    }
        
    /**
     * Constructor sets class data to the parameter 
     * 
     * @param list the LinkedList to set the queue to
     */
    public Queue(LinkedList<T> list) {
        
    }
    
    /**
     * Constructor sets class data to the parameter 
     * 
     * @param array the array to set the stack to
     */
    public Queue(T[] array) {
        
    }
    
    /**
     * Constructor sets class data to the parameter 
     * 
     * @param stack the stack to set the queue to
     */
    public Queue(Stack stack) {
        
    }

    /**
     * String representation of this object
     *
     * @return The object represented as a String
     */
    @Override
    public String toString() {
        return null;
    }
    
    /**
     * Deep comparison, determines if two objects are "equal" in this context
     *
     * @param object the object to compare to
     * @return the objects are "equal" (true) or not (false)
     */
    @Override
    public boolean equals(Object object) {
        return false;
    }
    
    /**
     * a Deep clone, creates a duplicate object using new memory
     *
     * @return a "clone" of the object using new memory
     */
    @Override
    public Queue clone() {   
        return null;                                       // return clone
    }
    
}