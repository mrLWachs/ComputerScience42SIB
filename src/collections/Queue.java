
/** required package class namespace */
package collections;

/** required imports */
import java.io.Serializable;
import java.lang.reflect.Array;


/**
 * Queue.java - a Queue ADT using generics
 *
 * @author Mr. Wachs
 * @param <T> the generic object used in this class
 * @since 1-Mar-2019  
 * @instructor Mr. Wachs
 */
public class Queue <T> implements Serializable, Comparable<Object>
{

    /** Node reference to the first (front, head) node in the queue */
    private Node front;
    /** Node reference to the last (back, tail) node in the queue */
    private Node back;
    /** The number of nodes in the queue */
    private int length;    
    
    /**
     * Default constructor for the class, sets class properties
     */
    public Queue() {
        front = back = null;                            // references to null
        length = 0;                                     // set to 0
    }

    /**
     * Constructor for the class, sets class properties
     * 
     * @param list the LinkedList to set the queue to
     */
    public Queue(LinkedList list) {
        front = back = null;                            // references to null
        length = 0;                                     // set to 0
        for (int i = 0; i < list.size(); i++) {         // traverse list
            T data = (T)list.get(i);                    // retrieve data
            enqueue(data);                              // enqueue into queue
        }
    }

    /**
     * Constructor for the class, sets class properties
     * 
     * @param array the array to set the queue to 
     */
    public Queue(T[] array) {
        front = back = null;                            // references to null
        length = 0;                                     // set to 0;
        for (int i = 0; i < array.length; i++) {        // traverse array
            T data = (T)array[i];                       // retrieve data
            enqueue(data);                              // enqueue into queue
        }
    }

    /**
     * Constructor for the class, sets class properties
     * 
     * @param stack the stack to set the queue to 
     */
    public Queue(Stack stack) {
        front = back = null;                            // references to null
        length = 0;                                     // set to 0
        for (int i = 0; i < stack.size(); i++) {        // traverse stack
            T data = (T)stack.pop();                    // retrieve data
            enqueue(data);                              // enqueue into queue
        }
    }
        
    /**
     * Adds data to the back of the queue
     * 
     * @param data the generic data to add
     * @return the operation was successful (true) or not (false)
     */
    public boolean enqueue(T data) {
        if (data == null) return false;                 // empty queue
        try {
            Node<T> node = new Node<>(data);            // create node
            if (isEmpty()) {
                front = back = node;                    // add first node
            }
            else {                                      // add subsequent nodes
                node.next = back;                       // adjust references
                back.previous = node;
                back = node;
            }
            length++;                                   // increase length 
        } catch (OutOfMemoryError error) {
            System.out.println("Queue overflow");       // output error
            return false;                               // unsuccessful
        }        
        return true;                                    // operation successful
    }
        
    /**
     * Removes the first item at the front of the queue
     * 
     * @return the generic data at the front of the queue
     */
    public T dequeue() {
        if (isEmpty()) return null;                 // no nodes in queue
        else {                                      // queue has some nodes
            length--;                               // reduce length
            T data = peek();                        // get top data
            if (front == back) {                    // single node queue
                front = back = null;                // wipe all data
            }
            else {                                  // multi node queue
                Node temp = front.previous;         // adjust references
                front.previous = null;
                temp.next = null;                        
                front = temp;
            }            
            System.gc();                            // call garbage collection
            return data;                            // data returned
        }
    }
    
    /**
     * Just "peeks" at front of the queue without mutating the structure
     * 
     * @return the data at the front
     */
    public T peek() {
        return front();
    }
    
    /**
     * Just "peeks" at front of the queue without mutating the structure
     * 
     * @return the data at the front
     */
    public T front() {
        if (isEmpty()) return null;                     // no nodes in stack
        return (T)front.data;                            // return head data
    }
    
    /**
     * Just "peeks" at back of the queue without mutating the structure
     * 
     * @return the data at the back
     */
    public T back() {
        if (isEmpty()) return null;                     // no nodes in stack
        return (T)back.data;                            // return tail data
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
     * String representation of this object
     *
     * @return The object represented as a String
     */
    @Override
    public String toString() {
        if (isEmpty()) return "Empty Queue";            // no nodes to display
        else {
            String text = "Queue = [";                  // starting character
            Node current = front;                       // start at front node
            while (current.previous != null) {          // traverse queue
                text += current.toString() + ",";       // append data
                current = current.previous;             // move to next node
            }            
            return text + current.toString() + "]";     // append end character
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
        if (!(object instanceof Queue)) return false;           // check type
        try {                                                   // error trap
            Queue<T> queue1 = this.clone();                     // clone queue
            Queue<T> queue2 = ((Queue<T>)object).clone();       // clone/cast 
            if (queue1.size() != queue2.size()) return false;   // not same size          
            while (!queue1.isEmpty()) {                         // traverse
                T data1 = (T)queue1.dequeue();                  // retrieve data
                T data2 = (T)queue2.dequeue();
                if (!data1.equals(data2)) return false;         // compare data              
            }
            return true;                                        // all passed
        }
        catch (ClassCastException | NullPointerException e) { 
            return false;                               // cannot cast, or null
        }
    }
    
    /**
     * Creates a duplicate object using new memory
     *
     * @return a "clone" of the object using new memory
     */
    @Override
    public Queue clone() {
        Queue<T> queue = new Queue<>();                 // new empty queue
        Node current = front;                           // start at first node
        while (current != null) {                       // traverse queue
            T data = (T)current.data;                   // get data
            queue.enqueue(data);                        // enqueue to new queue
            current = current.previous;                 // move to next node
        }        
        return queue;                                   // return clone
    }

    /**
     * Compares two objects and the result is a positive integer if this 
     * object is greater than the argument, a zero if the objects are equal,
     * and a negative integer if this object is less than the argument
     *
     * @param object the object to compare to
     * @return 0 if the objects are equal, a negative if this object is less 
     * than the argument (or any errors), and a positive if this object is 
     * greater than the argument
     */
    @Override
    public int compareTo(Object object) {
        if (!(object instanceof Queue)) return -1;      // check object type
        try {                                           // error trap
            Queue queue1 = this.clone();                // clone/cast parameter
            Queue queue2 = ((Queue)object).clone();     // clone this queue
            if (queue1.size() < queue2.size())         
                return -1;                              // queues not same size
            else if (queue1.size() > queue2.size())         
                return 1;                               // queues not same size
            else if (queue1.equals(queue2))             // queues same size
                return 0;
            else {                
                return 0;                               // potential to expand
            }         
        }
        catch (ClassCastException | NullPointerException e) {
            return -1;                                  // cannot cast, or null
        }
    }
    
    /**
     * Frees up all memory used by this object
     */
    @Override
    public final void finalize() {
        front = back = null;                            // references set to nulls
        length = 0;                                     // length set to zero
        System.gc();                                    // garbage collector called
    }
    
    /**
     * Turns the stack into a ADT LinkedList object
     * 
     * @return the Stack as a ADT LinkedList
     */
    public LinkedList<T> toLinkedList() {
        LinkedList<T> list = new LinkedList<>();        // create new list
        Node current = front;                            // start at first node        
        while (current != null) {                       // traverse queue   
            T data = (T)current.data;                   // retrieve data
            list.add(data);                             // add to list
            current = current.previous;                 // move to next node
        }
        return list;                                    // return list
    }
    
    /**
     * Returns an array that contains the same data as the list
     * 
     * @param array the data type array
     * @return an array of generic type T
     */
    public T[] toArray(T[] array) {
        array = (T[])(Array.newInstance(
                array.getClass().getComponentType(), 
                length));                               // create array 
        Node current = front;                            // start at top node 
        for (int i = 0; i < length; i++) {              // traverse array
            array[i] = (T)current.data;                 // retrieve data
            current = current.previous;                 // move to next node
        }
        return array;                                   // return array
    }

}
