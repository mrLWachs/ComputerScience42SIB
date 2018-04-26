
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
        TreeNode treeNode = (TreeNode)object;
        return data.equals(treeNode.data);
    }

    /**
     * Determines if two TreeNodes are equal (by data)
     *
     * @param treeNode the TreeNode to compare to
     * @return the TreeNodes have equal data (true) or not (false)
     */
    public boolean equals(TreeNode treeNode) {
        return data.equals(treeNode.data);
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
        TreeNode treeNode = new TreeNode(this.data);
        return treeNode;
    }

}
