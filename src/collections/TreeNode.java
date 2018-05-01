
/** required package class namespace */
package collections;

/** required imports */
import java.io.Serializable;
import testing.Output;


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
            return equals((TreeNode)object);
        }
        catch (ClassCastException error) {
            Output.error("TreeNode Casting error: " + error.toString());
            return false;
        }
    }

    /**
     * Determines if two TreeNodes are equal (by data)
     *
     * @param treeNode the TreeNode to compare to
     * @return the TreeNodes have equal data (true) or not (false)
     */
    public boolean equals(TreeNode treeNode) {
        try {        
            return equals(treeNode.data);
        }
        catch (NullPointerException error) {
            Output.error("TreeNode Null error: " + error.toString());
            return false;
        }
    }

    /**
     * Determines if two generic data objects are equal 
     *
     * @param data the generic data to compare to
     * @return if we have equal generic data (true) or not (false)
     */
    public boolean equals(T data) {
        return this.data.equals(data);
    }

    /**
     * Creates a duplicate object using new memory
     *
     * @return a "clone" of the object using new memory
     */
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
        if (data == null) return false;
        if (data.compareTo(this.data) < 0) {
            if (this.left == null) this.left = new TreeNode<>(data);
            else                   this.left.insert(data);
        }
        else if (data.compareTo(this.data) >= 0) {
            if (this.right == null) this.right = new TreeNode<>(data);
            else                    this.right.insert(data);
        }
        return true;
    }
    
}
