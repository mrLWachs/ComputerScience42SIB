package testing.cs42sib.collections;

import java.io.Serializable;

/**
 * LinkedList.java - an implementation of a linked list abstract (advanced)
 * data (dynamic) type (ADT) and useful methods, and could be "visualized" as:
 * 
 * <pre>
 *             +------+       +------+       +------+       +------+      
 *  null {---- |      | {---- |      | {---- |      | {---- |      |  
 *             | NODE |       | NODE |       | NODE |       | NODE |       
 *             |      |----}  |      |----}  |      |----}  |      |----} null  
 *             +------+       +------+       +------+       +------+      
 *                 ^                                           ^
 *                 |                                           |
 *                head                                        tail
 *
 * </pre>
 * 
 * @author Mr. Wachs 
 * @param <T> the generic data type used in the class
 * @since March 4, 2021 
 */
public class LinkedList <T> implements Serializable
{
    
    /** Flag to indicate a search was not found */
    public final int NOT_FOUND = -1;
    
    /** Reference (link) to the first (front) node in the list (entry point) */
    private Node head;
    
    /** Reference (link) to the last (back) node in the list (entry point) */
    private Node tail;
    
    /** The number of nodes in the list, immutable property */
    private int length;
    
    /** the longest "word" size of the largest node data */
    public int longestWord;
    
    
    /**
     * Default constructor, set class properties
     */
    public LinkedList() {
        finalize();
    }
    
    /**
     * Frees up all memory used by this object
     */
    @Override
    public void finalize() {
        length = 0;                 // length set to zero
        head = tail = null;         // references set to nulls
        System.gc();                // runs the garbage collector in Java
    }
    
    /**
     * Determines if the list is empty (no content)
     * 
     * @return is empty (true) or not empty (false)
     */
    public boolean isEmpty() {
        return length == 0;
    }
    
    /**
     * Accessor method of the immutable property
     * 
     * @return the number of nodes in the list
     */
    public int size() {
        return length;
    }
        
    /**
     * Inserts data into the front (head) of the list
     * 
     * @param data the data type to add
     * @return the operation was successful (true) or not (false)
     */
    public boolean addFront(T data) {
        if (data == null) return false;     // null data cannot be added        
        Node<T> node = new Node<>(data);    // new node memory created 
        // Scenarios to consider:    
        // 1) empty list
        // 2) list of 1 or more nodes
        if (isEmpty()) {                    // adding first node
            head = tail = node;             // set references
        }
        else {                              // subsequent nodes added
            node.next = head;               // link node to rest of list
            head.previous = node;           // connect rest of list to node
            head = node;                    // reassign head reference
        }
        length++;                           // increase length environmental
        return true;                        // operation successful
    }
    
    /**
     * Inserts data into the back (tail) of the list
     * 
     * @param data the data type to add
     * @return the operation was successful (true) or not (false)
     */
    public boolean addBack(T data) {
        if (data == null) return false;     // null data cannot be added            
        Node<T> node = new Node<>(data);    // new node memory created    
        if (isEmpty()) {                    // adding first node
            head = tail = node;             // set references
        }
        else {                              // subsequent nodes added
            node.previous = tail;           // link node to rest of list
            tail.next = node;               // connect rest of list to node
            tail = node;                    // reassign tail reference
        }
        length++;                           // increase length environmental
        return true;                        // operation successful
    }
    
    /**
     * String representation of this object
     *
     * @return The object represented as a String
     */
    @Override
    public String toString() {
        if (isEmpty()) return "Empty LinkedList";       // no nodes to display
        String text = "Linked List [";                  // starting character
        Node current = head;                            // start at head node
        while (current.next != null) {                  // traverse list
            text += current.toString() + ",";           // append data
            current = current.next;                     // move to next node
        }            
        return text + current.toString() + "]";         // append end character      
    }
    
    /**
     * Accessor for the data at the specified index
     * 
     * @param index the index location to access
     * @return the data (or null) at the index
     */
    public T get(int index) {        
        if (!inRange(index)) return null;   // invalid index, return flag        
        return (T)getNode(index).data;      // get reference and retrieve data  
    }
    
    /**
     * Mutator method sets the index location to the new data
     * 
     * @param index the index location to mutate
     * @param data the new data to mutate into
     * @return the operation was successful (true) or not (false)
     */
    public boolean set(int index, T data) {
        if (!inRange(index)) return false;          // invalid index
        if (data == null)    return false;          // invalid data
        Node current = getNode(index);              // get to node at index
        current.data = data;                        // change node data
        return true;                                // operation successful
    }
    













    
    /**
     * Accessor method to the encapsulated (private) property of the first
     * (head) node of the list
     * 
     * @return reference to the first node
     */
    protected Node getFirstNode() {
        return head;
    }
    
    /**
     * Accessor method to the encapsulated (private) property of the last
     * (tail) node of the list
     * 
     * @return reference to the last node
     */
    protected Node getLastNode() {
        return tail;
    }
    
    /**
     * Accesses the node reference for this index location
     * 
     * @param index the index location
     * @return a reference to the node at this index or null
     */
    protected Node getNode(int index) {
        if (!inRange(index))   return null;             // not valid index
        if (index == 0)        return getFirstNode();   // first node returned
        if (index == length-1) return getLastNode();    // last node returned
        Node current = head;                            // start at first node
        for (int i = 0; i < index; i++) {               // move to index
            current = current.next;                     // advance reference
        }
        return current;                                 // return reference
    }
        
    /**
     * Checks to see if the index is in range of the list
     * 
     * @param index the location to check
     * @return it is in range (true) or not (false)
     */        
    private boolean inRange(int index) {
        if (isEmpty())       return false;  // empty list no valid index
        if (index < 0)       return false;  // index before first valid number
        if (index >= length) return false;  // index after last valid number
        return true;                        // index is valid
    }
    
}
