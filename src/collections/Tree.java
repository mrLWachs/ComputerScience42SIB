/** required package class namespace */
package collections;

/** required imports */
import java.io.Serializable;

 
/**
 * Tree.java - a representation of a binary tree ADT object.It uses the 
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
 * @since Mar. 11, 2020, 10:37:21 a.m.
 */
public class Tree <T extends Comparable<T>> implements Serializable
{
    
    private TreeNode<T> root;                       // root of the tree
    private LinkedList<T> list;                     // objects for traversals...
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
     * Constructor for the class, sets class properties
     * 
     * @param linkedList the LinkedList to create the tree from
     */
    public Tree(LinkedList<T> linkedList) {
        root  = null;
        list  = new LinkedList<>();             // build objects for traversals
        order = new LinkedList<>();
        for (int i = 0; i < linkedList.size(); i++) {
            insert((T)linkedList.get(i));
        }
    }
    
    /**
     * Constructor for the class, sets class properties
     * 
     * @param array the array to create the tree from
     */
    public Tree(T[] array) {
        this(new LinkedList<>(array));
    }
    
    /**
     * Constructor for the class, sets class properties
     * 
     * @param stack the Stack to create the tree from
     */
    public Tree(Stack stack) {
        this(stack.toLinkedList());
    }
    
    /**
     * Constructor for the class, sets class properties
     * 
     * @param queue the Queue to create the tree from
     */
    public Tree(Queue queue) {
        this(queue.toLinkedList());
    }
        
    /**
     * String representation of this object
     *
     * @return The object represented as a String
     */
    @Override
    public String toString() {
        if (root == null) return "Tree Empty";          // for empty trees
        else {                                          // for filled trees
            String text = "Binary Tree:\n";             // text for output
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
        if (object == null) return false;           // error check parameter
        try {
            Tree that = (Tree)object;               // cast to tree object
            LinkedList inOder1 = this.inOrder();    // use in order lists
            LinkedList inOder2 = that.inOrder();
            return inOder1.equals(inOder2);         // check if same lists
        }
        catch (ClassCastException error) {          // cannot cast object
            return false;
        }
    }
       
    /**
     * a Deep clone, creates a duplicate object using new memory
     *
     * @return a "clone" of the object using new memory
     */
    @Override
    public Tree clone() {
        Tree<T> tree = new Tree<>();                // create new tree memory
        for (int i = 0; i < order.size(); i++) {    // traverse this tree list
            tree.insert((T)order.get(i));           // insert into new tree
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
        order.add(data);
        if (root == null) root = new TreeNode<>(data);  // inserting first node        
        else root.insert(data);                         // insert other nodes
        return true;                                    // operation successful
    }
    
    /**
     * A pre-order traversal of the tree nodes
     * 
     * @return a linked list containing all the data pre-order
     */
    public LinkedList preOrder() {
        list.clear();                                   // clear out the list
        list = recursivePreOrder(root);     // fill with pre order traversal
        return list;
    }
    
    /**
     * A post-order traversal of the tree nodes
     * 
     * @return a linked list containing all the data post-order
     */
    public LinkedList postOrder() {
        list.clear();                                   // clear out the list
        list = recursivePostOrder(root);    // fill with post order traversal
        return list;
    }
    
    /**
     * A in-order traversal of the tree nodes
     * 
     * @return a linked list containing all the data in-order
     */
    public LinkedList inOrder() {
        list.clear();                                   // clear out the list
        list = recursiveInOrder(root); // fill with recursive in order traversal
        return list;
    }

    /**
     * Recursive pre-order traversal starting at the root
     * 
     * @param current the reference to the current tree node
     */
    private LinkedList<T> recursivePreOrder(TreeNode<T> current) {
        // "pre" means "before" or "first", so: visit,left,right
        if (current != null) {      // not past leaf node, recuse (keep going)
            list.add(current.data);             // "visit" node
            recursivePreOrder(current.left);    // travel left sub-tree
            recursivePreOrder(current.right);   // travel right sub-tree
        }
        return list;                            // base case, past leaf node
    }

    /**
     * Recursive post-order traversal starting at the root
     * 
     * @param current the reference to the current tree node
     */
    private LinkedList<T> recursivePostOrder(TreeNode<T> current) {
        // "post" means "after" or "last", so: left,right,visit
        if (current != null) {      // not past leaf node, recuse (keep going)
            recursivePostOrder(current.left);   // travel left sub-tree
            recursivePostOrder(current.right);  // travel right sub-tree
            list.add(current.data);             // "visit" node
        }
        return list;                            // base case, past leaf node
    }

    /**
     * Recursive in-order traversal starting at the root
     * 
     * @param current the reference to the current tree node
     */
    private LinkedList<T> recursiveInOrder(TreeNode<T> current) {
        // "in" means "in-between", so: left,visit,right
        if (current != null) {      // not past leaf node, recuse (keep going)
            recursiveInOrder(current.left);     // travel left sub-tree
            list.add(current.data);             // "visit" node
            recursiveInOrder(current.right);    // travel right sub-tree            
        }
        return list;                            // base case, past leaf node
    }
        
}
