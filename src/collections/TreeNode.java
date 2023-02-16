
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
 *
 * @author Mr. Wachs
 * @param <T> the generic data to use in the node
 * @since 28-Feb-2022, 10:14:50 AM
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
     * Deep comparison, determines if two objects are "equal" in this context
     *
     * @param object the object to compare to
     * @return the objects are "equal" (true) or not (false)
     */
    @Override
    public boolean equals(Object object) {
        try {
            TreeNode that = (TreeNode)object;       // Cast object to node
            return this.data.equals(that.data);     // Use internal data equals
        }
        catch (NullPointerException error) {        // Null parameter
            System.out.println("null error");
            return false;
        } 
        catch(ClassCastException error) {           // Casting error
            System.out.println("Casting error");
            return false;
        }        
    }
    
    /**
     * a Deep clone, creates a duplicate object using new memory
     *
     * @return a "clone" of the object using new memory
     */
    @Override
    public TreeNode clone() {
        return new TreeNode<>(this.data);
    }
    
    /**
     * Inserts data (recursively) into the binary tree at its correct position
     * 
     * @param data the generic data to insert into the tree
     * @return the operation was successful (true) or not (false)
     */
    public boolean insert(T data) {
        if (data == null) return false;     // Error check
        // Decide which sub-tree (left or right) the data goes to?        
        if (data.compareTo(this.data) < 0) {
            // Means the data in the tree node comapred to the data paramater,
            // shows that the parameter data is "less than" the existing tree
            // node data - means we insert to the left
            if (this.left == null) {
                // Means that the current node's left sub-tree doesn't yet 
                // exist - so we can put a new node here
                this.left = new TreeNode(data); // Add a node to this spot
            }
            else {
                // Means the left sub-tree exists, recursively repeat the insert
                this.left.insert(data);
            }            
        }
        else if (data.compareTo(this.data) >= 0) {  // Same operation but right
            if (this.right == null) {
                this.right = new TreeNode(data);
            }
            else {
                this.right.insert(data);
            }            
        }
        return true;
    }
    
}