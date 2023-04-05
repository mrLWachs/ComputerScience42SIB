/** Required package class namespace */
package collections;

/** Required API imports */
import java.io.Serializable;

 
/**
 * TreeNode.java - representation of a generic node for use with a binary
 * tree object.It could be visualized as:
 
                       TreeNode
                 +-----------------+
                 |      data       |
                 +-----------------+
                 |  left  |  right |
                 +-----------------+
                    /           \
                   /             \
              TreeNode        TreeNode
 *
 * @author Mr. Wachs
 * @param <T> Generic data property
 * @since 5-Apr-2023, 9:56:58 AM
 */
public class TreeNode <T extends Comparable<T> > implements Serializable
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
     * Class constructor, set class properties (data)
     */
    public TreeNode(T data) {
        
    }
     
    /**
     * String representation of this object
     *
     * @return The object represented as a String
     */
    @Override
    public String toString() {
        return "TreeNode: " + super.toString();
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
    public TreeNode clone() {
        return this;
    }
    
}