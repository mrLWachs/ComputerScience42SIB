
/** required package class namespace */
package collections;

/** required imports */
import java.io.Serializable;


/**
 * Tree.java - a representation of a binary tree ADT object
 * 
 * @author Mr. Wachs
 * @param <T> the generic object used in this class
 * @since 14-Mar-2019 
 */
public class Tree <T extends Comparable<T>> implements Serializable
{

    /** The number of tree nodes in the tree */
    private int size;
    /** Reference to the root of the tree */
    private TreeNode root;
    /** Stores the node data in a list if needed */
    private LinkedList<T> list;
    /** Used for outputting data in traversals */
    private LinkedList<T> order;
        
    
    /**
     * Default constructor for the class, sets class properties
     */
    public Tree() {
        size  = 0;
        root  = null;
        list  = new LinkedList<>();             // build objects for traversals
        order = new LinkedList<>();
    }

    /**
     * String representation of this object
     *
     * @return The object represented as a String
     */
    @Override
    public String toString() {
        return "Tree " + super.toString();
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
    public Tree clone() {
        return this;
    }

}
