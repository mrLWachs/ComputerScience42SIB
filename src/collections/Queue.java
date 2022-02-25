
/** Required package class namespace */
package collections;

/** Required imports */
import java.io.Serializable;
import java.lang.reflect.Array;


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
        if (isEmpty()) return null;                     // No nodes in queue
        return (T)tail.data;                            // Return data
    }
    
    /**
     * Just "peeks" at back of the queue without mutating the structure
     * 
     * @return the data at the back
     */
    public T back() {
        if (isEmpty()) return null;                     // No nodes in queue
        return (T)head.data;                            // Return data
    }
        
    /**
     * Turns the queue into a ADT LinkedList object
     * 
     * @return the Stack as a ADT LinkedList
     */
    public LinkedList<T> toLinkedList() {
        LinkedList<T> list = new LinkedList<>();    // Create a list
        Node current = head;                        // Start a reference to head
        while (current != null) {                   // Traverse stack
            T data = (T)current.data;               // Retrieve current data
            list.add(data);                         // Add to the list
            current = current.next;                 // Move to the next node
        }        
        return list;                                // Return filled list
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
                length));                               // Create generic array 
        Node current = head;                            // Start at head node 
        for (int i = 0; i < length; i++) {              // Traverse array
            array[i] = (T)current.data;                 // Retrieve data
            current = current.next;                     // Move to next node
        }
        return array;                                   // Return filled array
    }
    
    /**
     * Turns the queue into a ADT stack object
     * 
     * @return the queue as a ADT stack
     */
    public Stack toStack() {
        return new Stack(this);
    }
        
    /**
     * Constructor sets class data to the parameter 
     * 
     * @param linkedList the LinkedList to set the queue to
     */
    public Queue(LinkedList<T> linkedList) {
        finalize();                                         // Wipe any content
        for (int i = linkedList.size()-1; i >= 0; i--) {    // Reverse traverse
            T data = (T)linkedList.get(i);                  // Get data
            enqueue(data);                                  // Add to queue
        }
    }
    
    /**
     * Constructor sets class data to the parameter 
     * 
     * @param array the array to set the stack to
     */
    public Queue(T[] array) {
        finalize();                                         // Wipe any content
        for (int i = array.length-1; i >= 0; i--) {         // Reverse traverse
            T data = (T)array[i];                           // Get data
            enqueue(data);                                  // Add to queue
        }
    }
    
    /**
     * Constructor sets class data to the parameter 
     * 
     * @param stack the stack to set the queue to
     */
    public Queue(Stack stack) {
        this(stack.toLinkedList());
    }

    /**
     * String representation of this object
     *
     * @return The object represented as a String
     */
    @Override
    public String toString() {
        if (isEmpty()) return "Empty Queue";            // No nodes to display
        else {
            String text = "Queue back -> [";            // Starting character
            Node current = head;                        // Start at top node
            while (current.next != null) {              // Traverse stack
                text += current.toString() + ",";       // Append data
                current = current.next;                 // Move to next node
            }            
            return text + current.toString() + "] <- front"; // Append end 
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
        if (!(object instanceof Queue)) return false;   // Check object type
        try {                                           // Error trap
            Queue<T> q1 = this.clone();                 // Clone this queue
            Queue<T> q2 = ((Queue<T>)object).clone();   // Clone/cast parameter
            if (q1.size() != q2.size()) return false;   // Queues not same size          
            while (!q1.isEmpty()) {                     // Traverse queues
                T data1 = (T)q1.dequeue();              // Retrieve data
                T data2 = (T)q2.dequeue();
                if (!data1.equals(data2)) return false; // Compare data              
            }
            return true;                                // All tests passed
        }
        catch (ClassCastException | NullPointerException e) { 
            return false;                               // Cannot cast, or null
        }
    }
    
    /**
     * a Deep clone, creates a duplicate object using new memory
     *
     * @return a "clone" of the object using new memory
     */
    @Override
    public Queue clone() {   
        Queue<T> that = new Queue<>();                  // New empty queue
        Node current = tail;                            // Start at first node
        while (current != null) {                       // Traverse queue
            T data = (T)current.data;                   // Get data
            that.enqueue(data);                         // Enqueue to new queue
            current = current.previous;                 // Move to next node
        }        
        return that;                                    // Return clone
    }
    
}