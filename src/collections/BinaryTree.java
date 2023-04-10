/** Required package class namespace */
package collections;

import java.io.Serializable;

 
/**
 * BinaryTree.java - a representation of a binary tree ADT object.It uses the 
 * TreeNode class to connect into a traditional binary tree. It could be
 * visualized as:
 *                               +------+
 *                               | root |
 *                               +------+
 *                                /    \
 *        (Left sub-tree)  +------+    +------+  (Right sub-tree)
 *                         | node |    | node |
 *                         +------+    +------+
 *                          /    \           \
 *                   +------+    +------+    +------+
 *                   | node |    | node |    | node |
 *                   +------+    +------+    +------+
 *
 * @author Mr. Wachs
 * @param <T> the generic data type used
 * @since 5-Apr-2023, 9:57:36 AM
 */
public class BinaryTree <T extends Comparable<T> > implements Serializable
{

    private TreeNode<T> root;               // The root of tree
    
    // Add some other object (mostly to show the tree works - they could be 
    // removed from this class)
    
    private LinkedList<T> list;             // For when we "travel" the tree
    private LinkedList<T> order;            // The original order of the data
        
    
    /**
     * Default constructor, set class properties
     */
    public BinaryTree() {
        root  = null;
        list  = new LinkedList<>();         // Instantiate for traversals
        order = new LinkedList<>();
    }
     
    /**
     * Inserts data recursively into the tree in order
     * 
     * @param data the data type to insert
     */
    public boolean insert(T data) {
        if (data == null) return false;                 // Error check
        order.add(data);                                // Add to our list
        if (root == null) root = new TreeNode<>(data);  // Inserting first item
        else root.insert(data);                         // Recursive insert
        return true;                                    // Operation successful
    }
    
    /**
     * Searches the tree to see if the data exists in the tree
     * 
     * @param data the data to search for
     * @return data has been found (true) or not (false)
     */
    public boolean search(T data) {
        if (data == null) return false;             // Invalid search item
        return recursiveSearch(data,root);          // Wrapper method
    }
    
    /**
     * Recursive search starting at the root of the tree
     * 
     * @param data the data to search for
     * @param current the current tree node reference
     * @return found (true) or not (false)
     */
    private boolean recursiveSearch(T data, TreeNode<T> current) {
        // Base case (the tree is empty or we got past a leaf node)
        if (current == null) return false;          // Not found
        else if (data.compareTo(current.data) < 0) {
            // Recursive case (search the left sub-tree)
            return recursiveSearch(data, current.left);
        }
        else if (data.compareTo(current.data) > 0) {
            // Recursive case (search the right sub-tree)
            return recursiveSearch(data, current.right);
        }
        else return true;       // Base case (we found it)
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
    public BinaryTree clone() {
        BinaryTree<T> tree = new BinaryTree<>();    // Create new tree memory
        for (int i = 0; i < order.size(); i++) {    // Traverse this tree list
            tree.insert((T)order.get(i));           // Insert into new tree
        }
        return tree;
    }
    
}