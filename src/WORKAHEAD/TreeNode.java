
/** required package class namespace */
package WORKAHEAD;

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
    
    /** the class data property */
    public T data;    
    /** self reference to the left leaf node object */
    public TreeNode left;
    /** self reference to the right leaf node object */
    public TreeNode right;
    
    /** Default constructor sets class data */
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
     * Insets data (recursively) into the binary tree at its correct position
     * 
     * @param data the generic data to insert into the tree
     * @return the operation was successful (true) or not (false)
     */
    public boolean insert(T data) {        
        if (data == null) return false;
        if (data.compareTo(this.data) < 0) {
            if (this.left == null) this.left = new TreeNode<T>(data);
            else                   this.left.insert(data);
        }
        else if (data.compareTo(this.data) >= 0) {
            if (this.right == null) this.right = new TreeNode<T>(data);
            else                    this.right.insert(data);
        }
        return true;
    }
        
    /**
     * Returns a string representation of the object. In general, this
     * method returns a string that "textually represents" this object. 
     * The result should be a concise but informative representation 
     * that is easy for a person to read.
     * 
     * @return a string representation of the object
     */
    @Override
    public String toString() {
        return data.toString();
    }

    /**
     * Creates and returns a copy of this object, with the precise meaning
     * of "copy" depends on the class of the object
     * 
     * @return a deep clone of this instance
     */
    @Override
    public boolean equals(Object object) {
        return this.data.equals(((TreeNode)object).data);
    }
    
    /**
     * Creates and returns a copy of this object, with the precise meaning
     * of "copy" depends on the class of the object
     * 
     * @return a deep clone of this instance
     */
    @Override
    public TreeNode clone() {
        return new TreeNode<>(this.data);
    }

}
