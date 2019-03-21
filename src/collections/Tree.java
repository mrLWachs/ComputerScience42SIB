
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

    /**
     * Constructor for the class, sets class properties, and builds from a 
     * linked list object
     * 
     * @param linkedList the linked list object to use
     */
    public Tree(LinkedList<T> linkedList) {
        this();                                         // reinstantiate
        for (int i = 0; i < linkedList.size(); i++) {   // traverse list
            insert(linkedList.get(i));                  // insert into tree
        }
    }
    
    /**
     * Constructor for the class, sets class properties, and builds from a 
     * stack object
     * 
     * @param stack the stack object to use
     */
    public Tree(Stack stack) {
        this(stack.toLinkedList());
    }
    
    /**
     * Constructor for the class, sets class properties, and builds from a 
     * queue object
     * 
     * @param queue the queue object to use
     */
    public Tree(Queue queue) {
        this(queue.toLinkedList());
    }
    
    /**
     * Constructor for the class, sets class properties, and builds from a 
     * array object
     * 
     * @param array the array object to use
     */
    public Tree(T[] array) {
        this(new LinkedList<T>(array));
    }
    
    /**
     * Searches the tree to see if the data exists in the tree
     * 
     * @param data the data to search for
     * @return data has been found (true) or not (false)
     */
    public boolean search(T data) {
        if (data == null) return false;         // invalid search item
        return searchRecursive(data,root);      // wrapper search
    }
    
    /**
     * A pre-order traversal of the tree nodes
     * 
     * @return a linked list containing all the data pre-order
     */
    public LinkedList preOrder() {
        list.clear();                       // clear list for new traversal
        preOrderRecursive(root);            // build list with traversal
        return list;
    }
    
    /**
     * A post-order traversal of the tree nodes
     * 
     * @return a linked list containing all the data post-order
     */
    public LinkedList postOrder() {
        list.clear();                       // clear list for new traversal
        postOrderRecursive(root);           // build list with traversal
        return list;
    }
    
    /**
     * A in-order traversal of the tree nodes
     * 
     * @return a linked list containing all the data in-order
     */
    public LinkedList inOrder() {
        list.clear();                       // clear list for new traversal
        inOrderRecursive(root);             // build list with traversal
        return list;
    }
    
    /**
     * Inserts data recursively into the tree in order
     * 
     * @param data the data type to insert
     */
    public boolean insert(T data) {
        if (data == null) return false;                 // null data not allowed
        if (root == null) root = new TreeNode(data);    // first node to add
        else              root.insert(data);            // recursive insert
        order.add(data);                                // add to order list
        size++;                                         // increase size
        return true;                                    // operation successful
    }
    
    /**
     * String representation of this object
     *
     * @return The object represented as a String
     */
    @Override
    public String toString() {
        String text = "";
        text += "Tree Insertion order:      " + order.toString();
        text += "\n(1) Pre-Order traversal:   " + preOrder().toString();
        text += "\n(2) Post-Order traversal:  " + postOrder().toString();
        text += "\n(3) In-Order traversal:    " + inOrder().toString();        
        return text;
    }
        
    /**
     * Determines if two objects are "equal" in this context
     *
     * @param object the object to compare to
     * @return the objects are "equal" (true) or not (false)
     */
    @Override
    public boolean equals(Object object) {
        LinkedList<T> inOrder1 = this.inOrder();            // convert to list
        LinkedList<T> inOrder2 = ((Tree)object).inOrder();  // convert to list
        return inOrder1.equals(inOrder2);                   // compare lists
    }

    /**
     * Creates a duplicate object using new memory
     *
     * @return a "clone" of the object using new memory
     */
    @Override
    public Tree clone() {
        Tree<T> that = new Tree<>();                    // create new tree
        for (int i = 0; i < this.order.size(); i++) {   // traverse current tree
            that.insert(this.order.get(i));             // insert to new tree
        }
        return that;                                    // return new tree
    }

    /**
     * Recursive search starting at the root of the tree
     * 
     * @param data the data to search for
     * @param current the current tree node reference
     * @return found (true) or not (false)
     */
    private boolean searchRecursive(T data, TreeNode current) {
        if (current == null) return false;      // go past a leaf (base case)
        else if (data.compareTo((T)current.data) < 0) {     // recursive case
            // data paramter is less than current's data
            return searchRecursive(data, current.left);     // left sub-tree
        }
        else if (data.compareTo((T)current.data) > 0) {     // resursive case
            // data paramter is greater than current's data
            return searchRecursive(data, current.right);    // right sub-tree
        }
        else {                                              // base case
            // data paramter is equal to current's data
            return true;
        }
    }

    /**
     * Recursive pre-order traversal starting at the root
     * 
     * @param current the reference to the current tree node
     */
    private void preOrderRecursive(TreeNode current) {
        if (current == null) return;        // base case
        list.add((T)current.data);          // visit current (before)
        preOrderRecursive(current.left);    // go left
        preOrderRecursive(current.right);   // go right        
    }

    /**
     * Recursive post-order traversal starting at the root
     * 
     * @param current the reference to the current tree node
     */
    private void postOrderRecursive(TreeNode current) {
        if (current == null) return;        // base case        
        postOrderRecursive(current.left);   // go left
        postOrderRecursive(current.right);  // go right 
        list.add((T)current.data);          // visit current (after)
    }

    /**
     * Recursive in-order traversal starting at the root
     * 
     * @param current the reference to the current tree node
     */
    private void inOrderRecursive(TreeNode current) {
        if (current == null) return;        // base case        
        inOrderRecursive(current.left);     // go left
        list.add((T)current.data);          // visit current (in-betwee)
        inOrderRecursive(current.right);    // go right 
    }

}
