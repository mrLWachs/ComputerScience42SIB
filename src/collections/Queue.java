  /*
 *  Mr. Wachs' classes - Java Computer Science learning file Queue.java
 *  for project ComputerScience42SIB on 1-Mar-2019 at 10:31:45 AM by lawrence.wachs
 */


/** required package class namespace */
package collections;

import java.io.Serializable;



/**
 * Queue.java - 
 *
 * @author Mr. Wachs 
 * @since 1-Mar-2019 
 */
public class Queue <T> implements Serializable, Comparable<Object>
{

    private Node front;
    private Node back;
    private int length;    
    
    /**
     * Default constructor for the class, sets class properties
     */
    public Queue() {
        front = back = null;
        length = 0;
    }

    public Queue(LinkedList list) {
        front = back = null;
        length = 0;
        for (int i = 0; i < list.size(); i++) {
            enqueue((T)list.get(i));
        }
    }

    public Queue(T[] array) {
        front = back = null;
        length = 0;
        for (int i = 0; i < array.length; i++) {
            enqueue(array[i]);
        }
    }

    public Queue(Stack stack) {
        front = back = null;
        length = 0;
        for (int i = 0; i < stack.size(); i++) {
            enqueue((T)stack.pop());
        }
    }
        
    public boolean enqueue(T data) {
        return false;
    }
    
    public T dequeue() {
        return null;
    }
    
    public T peek() {
        return null;
    }
    
    public int size() {
        return length;
    }
    
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
        if (isEmpty()) return "Empty Queue";
        else {
            String text = "Queue ["; 
            Node current = front;
            while (current != null) {
                text += current.toString() + ",";
                current = current.previous;
            }             
            return text + "]";
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
        return super.equals(object);
    }
    
    /**
     * Creates a duplicate object using new memory
     *
     * @return a "clone" of the object using new memory
     */
    @Override
    public Queue clone() {
        return this;
    }

    /**
     *
     * @param object
     * @return
     */
    @Override
    public int compareTo(Object object) {
        return 0;
    }

}
