
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
 * @since 13-Mar-2019 
 */
public class TreeNode <T extends Comparable<T>> implements Serializable
{
    
    /** The class data property (a generic object) */
    public T data;
    /** Self reference to the left node object (sub-tree) */
    public TreeNode left;
    /** Self reference to the right node object (sub-tree) */
    public TreeNode right;
    

    /**
     * Default constructor for the class, sets class properties
     */
    public TreeNode() {
        this(null,null,null);
    }
    
    /**
     * Class constructor sets class property data
     * 
     * @param data the generic data for the class
     */
    public TreeNode(T data) {
        this(data,null,null);
    }    
    
    /**
     * Class constructor sets class property data
     * 
     * @param data the generic data for the class
     * @param left reference to the left sub-tree
     * @param right reference to the right sub-tree 
     */
    public TreeNode(T data, TreeNode left, TreeNode right) {
        this.data  = data;
        this.left  = left;
        this.right = right;
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
        try {        
            TreeNode treeNode = (TreeNode)object;
            return this.data.equals(treeNode.data);
        }
        catch (ClassCastException error) {
            System.out.println("TreeNode Casting error: " + error.toString());
            return false;
        }
    }
    
    /**
     * Creates a duplicate object using new memory
     *
     * @return a "clone" of the object using new memory
     */
    @Override
    public TreeNode clone() {
        return new TreeNode<>(this.data);
    }

}
