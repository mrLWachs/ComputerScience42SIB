/** required package class namespace */
package collections;

/** required imports */
import java.io.Serializable;

 
/**
 * Tree.java - a representation of a binary tree ADT object
 *
 * @author Mr. Wachs
 * @since Mar. 11, 2020, 10:37:21 a.m.
 */
public class Tree <T extends Comparable<T>> implements Serializable
{
    
    private TreeNode<T> root;
    
    // objects for traversals...
    private LinkedList<T> list;
    private LinkedList<T> order;
    

    /**
     * Default constructor, set class properties
     */
    public Tree() {
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
        return "Tree: " + super.toString();
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
    public Tree clone() {
        return this;
    }
    
}
