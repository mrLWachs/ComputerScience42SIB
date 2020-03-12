/** required package class namespace */
package collections;

/** required imports */
import java.io.Serializable;

 
/**
 * Tree.java - a representation of a binary tree ADT object. It uses the 
 * TreeNode class to connect into a traditional binary tree. It could be
 * visualized as:
 *                                +------+
 *                                | root |
 *                                +------+
 *                                 /    \
 *         (Left sub-tree)  +------+    +------+  (Right sub-tree)
 *                          | node |    | node |
 *                          +------+    +------+
 *                           /    \           \
 *                    +------+    +------+    +------+
 *                    | node |    | node |    | node |
 *                    +------+    +------+    +------+
 *
 * @author Mr. Wachs
 * @since Mar. 11, 2020, 10:37:21 a.m.
 */
public class Tree <T extends Comparable<T>> implements Serializable
{
    
    private TreeNode<T> root;
    
    // objects for traversals...
    private LinkedList<T> list;
    private LinkedList<T> order;
    

    /**
     * Default constructor, set class properties
     */
    public Tree() {
        root  = null;
        list  = new LinkedList<>();             // build objects for traversals
        order = new LinkedList<>();
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
    public Tree clone() {
        return this;
    }
    
    /**
     * Searches the tree to see if the data exists in the tree
     * 
     * @param data the data to search for
     * @return data has been found (true) or not (false)
     */
    public boolean search(T data) {
        if (data == null) return false;         // invalid search item
        return recursiveSearch(data,root);      // wrapper search
    }

    /**
     * Recursive search starting at the root of the tree
     * 
     * @param data the data to search for
     * @param current the current tree node reference
     * @return found (true) or not (false)
     */
    private boolean recursiveSearch(T data, TreeNode<T> current) {        
        // base case (on empty tree or go past a leaf node)
        if (current == null) return false; 
        else if (data.compareTo(current.data) < 0) {
            // recursive case (look in the left sub-tree)
            return recursiveSearch(data, current.left);
        }
        else if (data.compareTo(current.data) > 0) {
            // recursive case (look in the right sub-tree)
            return recursiveSearch(data, current.right);
        }
        else return true;   // base case (find it)
    }
    
    /**
     * Inserts data recursively into the tree in order
     * 
     * @param data the data type to insert
     */
    public boolean insert(T data) {        
        if (data == null) return false;                 // error check        
        if (root == null) root = new TreeNode<>(data);  // inserting first node        
        else root.insert(data);                         // insert other nodes
        return true;                                    // operation successful
    }
    
}
