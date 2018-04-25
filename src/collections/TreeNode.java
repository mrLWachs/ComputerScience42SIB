
/** required package class namespace */
package collections;

/** required imports */
import java.io.Serializable;


/**
 * TreeNode.java - representation of a generic node for use with a binary
 * tree object
 * 
 * @author Mr. Wachs
 * @param <T> the generic object used in this class
 * @since Feb 9, 2017
 * @instructor Mr. Wachs
 */
public class TreeNode <T extends Comparable<T>> implements Serializable
{

    /** 
     * The class data property (a generic object)
     */
    public T data;    
    /** 
     * Self reference to the left node object (sub-tree)
     */
    public TreeNode left;
    /** 
     * Self reference to the right node object (sub-tree)
     */
    public TreeNode right;
    
    
    /** 
     * Default constructor for the class 
     */
    public TreeNode() {

    }

    /**
     * String representation of this object
     *
     * @return The object represented as a String
     */
    @Override
    public String toString() {
        return super.toString();
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
    public TreeNode clone() {
        return this;
    }

}
