
/** required package class namespace */
package collections;

/** required imports */
import java.io.Serializable;

/**
 * Tree.java - a representation of a binary tree ADT object
 * 
 * @author Mr. Wachs
 * @param <T> the generic object used in this class
 * @since Feb 9, 2017
 * @instructor Mr. Wachs
 */
public class Tree <T extends Comparable<T>> implements Serializable
{
    
    private TreeNode<T> root;
    private LinkedList<T> list;
    private LinkedList<T> order;
    
    
    /** 
     * Default constructor for the class 
     */
    public Tree() {
        root  = null;
        list  = new LinkedList<>();             // build objects for traversals
        order = new LinkedList<>();
    }

    /**
     * Constructor builds from a linked list object
     * 
     * @param linkedList the linked list object to use
     */
    public Tree(LinkedList linkedList) {
        root  = null;
        list  = new LinkedList<>();
        order = new LinkedList<>();
        for (int i = 0; i < linkedList.size(); i++) {
            this.insert((T)linkedList.get(i));
        }
    }
            
    /**
     * Inserts data recursively into the tree in order
     * 
     * @param data the data type to insert
     */
    public boolean insert(T data) {
        if (data == null) return false;
        order.add(data);
        if (root == null) root = new TreeNode<>(data);
        else              root.insert(data);
        return true;
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
        if (current == null) return false;                  // base case
        else if (data.compareTo((T)current.data) < 0)       // recursive case
            return recursiveSearch(data, current.left);     // left sub-tree
        else if (data.compareTo((T)current.data) > 0)       // recursive case
            return recursiveSearch(data, current.right);    // right sub-tree
        else return true;                                   // base case
    }
    
    /**
     * A pre-order traversal of the tree nodes
     * 
     * @return a linked list containing all the data pre-order
     */
    public LinkedList preOrder() {
        list.clear();                       // clear list for new traversal
        list = recursivePreOrder(root);     // build list with traversal
        return list;
    }
    
    /**
     * A post-order traversal of the tree nodes
     * 
     * @return a linked list containing all the data post-order
     */
    public LinkedList postOrder() {
        list.clear();                       // clear list for new traversal
        list = recursivePostOrder(root);    // build list with traversal
        return list;
    }
    
    /**
     * A in-order traversal of the tree nodes
     * 
     * @return a linked list containing all the data in-order
     */
    public LinkedList inOrder() {
        list.clear();                       // clear list for new traversal
        list = recursiveInOrder(root);      // build list with traversal
        return list;
    }
    
    /**
     * String representation of this object
     *
     * @return The object represented as a String
     */
    @Override
    public String toString() {
        if (root == null) return "Empty Tree";
        else {
            String text = "Tree traversals:";
            text += "\n\tPre-Order:  " + preOrder().toString();
            text += "\n\tPost-Order: " + postOrder().toString();
            text += "\n\tIn-Order:   " + inOrder().toString();
            return text;
        }
    }

    /**
     * Determines if two objects are "equal" in this context
     *
     * @param object the object to compare to
     * @return the objects are "equal" (true) or not (false)
     */
    @Override
    public boolean equals(Object object) {
        LinkedList<T> inOrder1 = this.inOrder();
        LinkedList<T> inOrder2 = ((Tree)object).inOrder();
        return inOrder1.equals(inOrder2);
    }

    /**
     * Creates a duplicate object using new memory
     *
     * @return a "clone" of the object using new memory
     */
    public Tree clone() {
        Tree<T> tree = new Tree<>();
        for (int i = 0; i < order.size(); i++) {
            tree.insert((T)order.get(i));
        }
        return tree;
    }

    /**
     * Recursive pre-order traversal starting at the root
     * 
     * @param current the reference to the current tree node
     */
    private LinkedList<T> recursivePreOrder(TreeNode<T> current) {
        if (current != null) {                  // not past leaf node, recurse
            list.add((T)current.data);          // output data
            recursivePreOrder(current.left);    // visit left sub-tree
            recursivePreOrder(current.right);   // visit right sub-tree
        }
        return list;                            // base case, past leaf node
    }

    /**
     * Recursive post-order traversal starting at the root
     * 
     * @param current the reference to the current tree node
     */
    private LinkedList<T> recursivePostOrder(TreeNode<T> current) {
        if (current != null) {                  // not past leaf node, recurse
            recursivePostOrder(current.left);   // visit left sub-tree
            recursivePostOrder(current.right);  // visit right sub-tree
            list.add((T)current.data);          // output data
        }
        return list;                            // base case, past leaf node
    }

    /**
     * Recursive in-order traversal starting at the root
     * 
     * @param current the reference to the current tree node
     */
    private LinkedList<T> recursiveInOrder(TreeNode<T> current) {
        if (current != null) {                  // not past leaf node, recurse
            recursiveInOrder(current.left);     // visit left sub-tree
            list.add((T)current.data);          // output data
            recursiveInOrder(current.right);    // visit right sub-tree       
        }
        return list;                            // base case, past leaf node
    }

}
