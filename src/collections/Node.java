
/** required package class namespace */
package collections;

/** required imports */
import java.io.Serializable;

/**
 * Node.java - a representation of a generic node for use with
 * a LinkedList object
 *
 * @author Mr. Wachs 
 * @param <T> the generic data type used in the class
 * @since Nov 8, 2017 
 * @instructor Mr. Wachs
 */
public class Node <T extends Comparable<T>> implements Serializable
{

    /** The data property */
    public T data;    
    /** Self reference to the next Node object */
    public Node next;
    /** Self reference to the next Node object */
    public Node previous;
        
    /** 
     * Default constructor for the class 
     */
    public Node() {
        this(null);
    }

    /**
     * Class constructor sets class properties 
     * 
     * @param data the Node data
     */
    public Node(T data) {
        this(data,null,null);
    }
    
    /**
     * Class constructor sets class properties 
     * 
     * @param data the node data
     * @param next reference to the next Node object
     * @param previous reference to the previous Node object
     */
    public Node(T data, Node next, Node previous) {
        this.data     = data;
        this.next     = next;
        this.previous = previous;
    }
    
    /**
     * String representation of this object
     *
     * @return The object represented as a String
     */
    @Override
    public String toString() {
        return data.toString();
    }

    /**
     * Determines if two objects are "equal" in this context
     *
     * @param object the object to compare to
     * @return the objects are "equal" (true) or not (false)
     */
    @Override
    public boolean equals(Object object) {
        Node node = (Node)object;       // cast object into node
        T    data = (T) node.data;      // retrieve the data from the node
        return this.data.equals(data);  // check equal status of datas
    }

    /**
     * Creates a duplicate object using new memory
     *
     * @return a "clone" of the object using new memory
     */
    public Node clone() {
        return new Node(this.data, 
                        this.next,
                        this.previous);
    }
    
    /**
     * Frees up all memory used by this object
     */
    @Override
    public void finalize() {
        data = null;
        next = previous = null;
    }
    
}
