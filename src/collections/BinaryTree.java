
/** Required package class namespace */
package collections;

/** Required API imports */
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
 *                   +------+    +------+    +------+ (leaf nodes)
 *
 *
 * @author Mr. Wachs
 * @param <T> the generic data type used
 * @since 28-Feb-2022, 10:16:08 AM
 */
public class BinaryTree <T extends Comparable<T>> implements Serializable
{
    
    private TreeNode<T> root;                       // The root of the tree
    private LinkedList<T> list;                     // Objects for traversals...
    private LinkedList<T> order;
    
    /**
     * Default constructor, set class properties
     */
    public BinaryTree() {
        root  = null;
        list  = new LinkedList<>();             // Build objects for traversals
        order = new LinkedList<>();
    }
    
    /**
     * Constructor for the class, sets class properties
     * 
     * @param linkedList the LinkedList to create the tree from
     */
    public BinaryTree(LinkedList<T> linkedList) {
        root  = null;
        list  = new LinkedList<>();             // Build objects for traversals
        order = new LinkedList<>();
        for (int i = 0; i < linkedList.size(); i++) {   // Traverse list
            insert((T)linkedList.get(i));               // Insert into tree
        }
    }
    
    /**
     * Constructor for the class, sets class properties
     * 
     * @param stack the Stack to create the tree from
     */
    public BinaryTree(Stack<T> stack) {
        this(stack.toLinkedList());
    }
    
    /**
     * Constructor for the class, sets class properties
     * 
     * @param queue the Queue to create the tree from
     */
    public BinaryTree(Queue<T> queue) {
        this(queue.toLinkedList());
    }
    
    /**
     * Constructor for the class, sets class properties
     * 
     * @param array the array to create the tree from
     */
    public BinaryTree(T[] array) {
        this(new LinkedList<>(array));
    }
    
    /**
     * String representation of this object
     *
     * @return The object represented as a String
     */
    @Override
    public String toString() {
        if (root == null) return "Tree Empty";          // For empty trees
        else {                                          // For filled trees
            String text = "Binary Tree:\n";             // The text for output
            text += "Order: " + order.toString()       + "\n";
            text += "Pre:   " + preOrder().toString()  + "\n";
            text += "In:    " + inOrder().toString()   + "\n";
            text += "Post:  " + postOrder().toString();
            return text;
        }
    }
    
    /**
     * Deep comparison, determines if two objects are "equal" in this context
     *
     * @param object the object to compare to
     * @return the objects are "equal" (true) or not (false)
     */
    @Override
    public boolean equals(Object object) {
        if (object == null) return false;           // Error check parameter
        try {
            BinaryTree that = (BinaryTree)object;   // Cast to tree object
            LinkedList inOder1 = this.inOrder();    // Use in order lists
            LinkedList inOder2 = that.inOrder();
            return inOder1.equals(inOder2);         // Check if same lists
        }
        catch (ClassCastException error) {          // Cannot cast object
            return false;
        }
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
    
    /**
     * Searches the tree to see if the data exists in the tree
     * 
     * @param data the data to search for
     * @return data has been found (true) or not (false)
     */
    public boolean search(T data) {
        if (data == null) return false;         // Invalid search item
        return recursiveSearch(data,root);      // Wrapper search
    }
    
    /**
     * Inserts data recursively into the tree in order
     * 
     * @param data the data type to insert
     */
    public boolean insert(T data) {
        if (data == null) return false;                 // Error check        
        order.add(data);
        if (root == null) root = new TreeNode<>(data);  // Inserting first node        
        else root.insert(data);                         // Insert other nodes
        return true;                                    // Operation successful
    }
    
    /**
     * A pre-order traversal of the tree nodes
     * 
     * @return a linked list containing all the data pre-order
     */
    public LinkedList preOrder() {
        list.clear();                                   // Clear out the list
        list = recursivePreOrder(root);     // Fill with pre order traversal
        return list;
    }
    
    /**
     * A post-order traversal of the tree nodes
     * 
     * @return a linked list containing all the data post-order
     */
    public LinkedList postOrder() {
        list.clear();                                   // Clear out the list
        list = recursivePostOrder(root);    // Fill with post order traversal
        return list;
    }
    
    /**
     * A in-order traversal of the tree nodes
     * 
     * @return a linked list containing all the data in-order
     */
    public LinkedList inOrder() {
        list.clear();                                   // Clear out the list
        list = recursiveInOrder(root); // Fill with recursive in order traversal
        return list;
    }
        
    /**
     * Recursive search starting at the root of the tree
     * 
     * @param data the data to search for
     * @param current the current tree node reference
     * @return found (true) or not (false)
     */
    private boolean recursiveSearch(T data, TreeNode<T> current) {        
        // Base case (on empty tree or go past a leaf node)
        if (current == null) return false; 
        else if (data.compareTo(current.data) < 0) {
            // Recursive case (look in the left sub-tree)
            return recursiveSearch(data, current.left);
        }
        else if (data.compareTo(current.data) > 0) {
            // Recursive case (look in the right sub-tree)
            return recursiveSearch(data, current.right);
        }
        else return true;   // Base case (find it)
    }
    
    /**
     * Recursive pre-order traversal starting at the root
     * 
     * @param current the reference to the current tree node
     */
    private LinkedList<T> recursivePreOrder(TreeNode<T> current) {
        // "pre" means "before" or "first", so: visit,left,right
        if (current != null) {      // Not past leaf node, recuse (keep going)
            list.add(current.data);             // We "visit" node
            recursivePreOrder(current.left);    // Travel left sub-tree
            recursivePreOrder(current.right);   // Travel right sub-tree
        }
        return list;                            // Base case, past leaf node
    }

    /**
     * Recursive post-order traversal starting at the root
     * 
     * @param current the reference to the current tree node
     */
    private LinkedList<T> recursivePostOrder(TreeNode<T> current) {
        // "post" means "after" or "last", so: left,right,visit
        if (current != null) {      // Not past leaf node, recuse (keep going)
            recursivePostOrder(current.left);   // Travel left sub-tree
            recursivePostOrder(current.right);  // Travel right sub-tree
            list.add(current.data);             // We "visit" node
        }
        return list;                            // Base case, past leaf node
    }

    /**
     * Recursive in-order traversal starting at the root
     * 
     * @param current the reference to the current tree node
     */
    private LinkedList<T> recursiveInOrder(TreeNode<T> current) {
        // "in" means "in-between", so: left,visit,right
        if (current != null) {      // Not past leaf node, recuse (keep going)
            recursiveInOrder(current.left);     // Travel left sub-tree
            list.add(current.data);             // We "visit" node
            recursiveInOrder(current.right);    // Travel right sub-tree            
        }
        return list;                            // Base case, past leaf node
    }
    
}