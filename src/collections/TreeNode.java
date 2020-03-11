/** required package class namespace */
package collections;

/** required imports */
import java.io.Serializable;

 
/**
 * TreeNode.java - representation of a generic node for use with a binary
 * tree object
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
    
}
