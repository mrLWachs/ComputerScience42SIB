/** required package class namespace */
package collections;

/** required imports */
import java.io.Serializable;

 
/**
 * TreeNode.java - representation of a generic node for use with a binary
 * tree object. It could be visualized as:
 * 
 *                       TreeNode
 *                 +-----------------+
 *                 |      data       |
 *                 +-----------------+
 *                 |  left  |  right |
 *                 +-----------------+
 *                    /           \
 *                   /             \
 *              TreeNode        TreeNode
 *
 * @author Mr. Wachs
 * @since Mar. 11, 2020, 10:18:06 a.m.
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
        TreeNode that = (TreeNode)object;
        try {
            return this.data.equals(that.data);
        }
        catch (NullPointerException error) {
            System.out.println("null error");
            return false;
        } 
        catch(ClassCastException error) {
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
     * Insets data (recursively) into the binary tree at its correct position
     * 
     * @param data the generic data to insert into the tree
     * @return the operation was successful (true) or not (false)
     */
    public boolean insert(T data) {
        if (data == null) return false;          // error check      
        // decide which sub-tree the data goes to
        if (data.compareTo(this.data) < 0) {    // means we insert into the left
            if (this.left == null) {                // empty spot, can use this                
                this.left = new TreeNode<>(data);
            }
            else {                                  // insert recursively                
                this.left.insert(data);
            }
        }
        else if (data.compareTo(this.data) >= 0) {  // means we insert right
            if (this.right == null) {
                this.right = new TreeNode<>(data);
            }
            else {
                this.right.insert(data);
            }
        }        
        return true;                        // if it completes the above tasks
    }
    
}
