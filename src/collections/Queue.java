/** Required package class namespace */
package collections;

/** Required API imports */
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
 * @since 13-Mar-2023, 10:41:09 AM
 */
public class Queue <T> implements Serializable
{

    /** Node reference to the first node of the queue */
    private Node head;
    
    /** Node reference to the last node of the queue */
    private Node tail;
        
    /** The number of nodes in the stack */
    private int length;
        
    
    /**
     * Default constructor, set class properties
     */
    public Queue() {
        finalize();
    }
     
    /**
     * Calls for garbage collection, and frees up memory - when the stack is 
     * destroyed
     */
    @Override
    public final void finalize() {
        length = 0;                                 // Length set to zero
        head = tail = null;                         // Reference set to null
        System.gc();                                // Garbage collector called
    }
    
    
    /**
     * Adds data to the back (tail) of the queue (mutator method)
     * 
     * @param data the generic data to add
     * @return the operation was successful (true) or not (false)
     */
    public boolean enqueue(T data) {
        return true;
    }

    /**
     * Removes an item from the front (head) of the queue (mutator method)
     * 
     * @return the generic data in the queue
     */
    public T dequeue() {
        return null;
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
        if (isEmpty()) return "Empty Queue";            // Nothing in the queue
        else {                                          // Queue has content
            String text = "Queue back -> [";             // Start a string
            Node current = head;                        // Reference to head
            while (current.next != null) {              // Traverse queue
                text += current.toString() + ",";       // Add to string
                current = current.next;                 // Move to next node
            }            
            return text + current.toString() + "] <- front"; 
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
    public Queue clone() {
        return this;
    }
    
}