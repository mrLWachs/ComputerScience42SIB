
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
    
    /** Node reference to the first node in the queue */
    private Node head;
    
    /** Node reference to the last node in the queue */
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
     * Frees up all memory used by this object
     */
    @Override
    public final void finalize() {
        length = 0;                                 // The length set to zero
        head = tail = null;                         // References set to null
        System.gc();                                // Garbage collector called
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
     * Adds data to the back (tail) of the queue
     * 
     * @param data the generic data to add
     * @return the operation was successful (true) or not (false)
     */
    public boolean enqueue(T data) {
        if (data == null) return false;                 // Empty queue
        Node node = new Node<T>(data);                  // Create node
        if (isEmpty()) head = tail = node;              // Add first node
        else {                                          // Add subsequent nodes
            node.next = head;                           // Adjust references
            head.previous = node;
            head = node;
        }
        length++;                                       // Increase length
        return true;                                    // Operation successful
    }
    
    /**
     * Removes an item from the tail of the queue
     * 
     * @return the generic data in the queue
     */
    public T dequeue() {
        if (isEmpty()) return null;                     // No nodes in queue
        else {                                          // Queue has some nodes
            length--;                                   // Reduce length
            T data = (T)tail.data;                      // Store data
            if (head == tail) finalize();               // Single node, wipe all
            else {                                      // Multi node queue
                tail = tail.previous;                   // Adjust references
                tail.next.previous = null;
                tail.next = null;
                System.gc();                            // Clean up memory
            }
            return data;                                // Data returned
        }
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