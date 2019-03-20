
/** required package class namespace */
package collections;

/** required imports */
import java.io.Serializable;


/**
 * Tree.java - a representation of a binary tree ADT object
 * 
 * @author Mr. Wachs
 * @param <T> the generic object used in this class
 * @since 14-Mar-2019 
 */
public class Tree <T extends Comparable<T>> implements Serializable
{

    /** The number of tree nodes in the tree */
    private int size;
    /** Reference to the root of the tree */
    private TreeNode root;
    /** Stores the node data in a list if needed */
    private LinkedList<T> list;
    /** Used for outputting data in traversals */
    private LinkedList<T> order;
        
    
    /**
     * Default constructor for the class, sets class properties
     */
    public Tree() {
        size  = 0;
        root  = null;
        list  = new LinkedList<>();             // build objects for traversals
        order = new LinkedList<>();
    }

    
    public boolean search(T data) {
        return recursiveSearch(data,root);
    }
    
    
    public LinkedList preOrder() {
        list = new LinkedList<>();
        preOrderRecursive(root);
        return list;
    }
    
    public LinkedList postOrder() {
        list = new LinkedList<>();
        postOrderRecursive(root);
        return list;
    }
    
    public LinkedList inOrder() {
        list = new LinkedList<>();
        inOrderRecursive(root);
        return list;
    }
    
    public boolean insert(T data) {
        if (data == null) return false;
        if (root == null) root = new TreeNode(data);
        else              root.insert(data);
        order.add(data);
        size++;
        return true;
    }
    
    
    
    
    
    
    
    /**
     * String representation of this object
     *
     * @return The object represented as a String
     */
    @Override
    public String toString() {
        return "Tree " + super.toString();
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
    @Override
    public Tree clone() {
        return this;
    }

    private boolean recursiveSearch(T data, TreeNode current) {
        if (current == null) return false; // go past a leaf (base case)
        else if (data.compareTo((T)current.data) < 0) {
            // data paramter is less than current's data
            return recursiveSearch(data, current.left);
        }
        else if (data.compareTo((T)current.data) > 0) {
            return recursiveSearch(data, current.right);
        }
        else {             // base case
            return true;
        }
    }

    private void preOrderRecursive(TreeNode current) {
        if (current == null) return;        // base case
        list.add((T)current.data);          // visit current (before)
        preOrderRecursive(current.left);    // go left
        preOrderRecursive(current.right);   // go right        
    }

    private void postOrderRecursive(TreeNode current) {
        if (current == null) return;        // base case        
        preOrderRecursive(current.left);    // go left
        preOrderRecursive(current.right);   // go right 
        list.add((T)current.data);          // visit current (after)
    }

    private void inOrderRecursive(TreeNode current) {
        if (current == null) return;        // base case        
        preOrderRecursive(current.left);    // go left
        list.add((T)current.data);          // visit current (in-betwee)
        preOrderRecursive(current.right);   // go right 
    }

}
