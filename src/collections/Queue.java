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
     * String representation of this object
     *
     * @return The object represented as a String
     */
    @Override
    public String toString() {
        return "Queue: " + super.toString();
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