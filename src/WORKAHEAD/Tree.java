
/** required package class namespace */
package WORKAHEAD;

/** required imports */
import collections.LinkedList;
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
    
    private TreeNode<T>   root;
    private LinkedList<T> list;
    private LinkedList<T> order;
    
    
    /** Default constructor sets class data */
    public Tree() {
        root  = null;
        list  = new LinkedList<>();
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
     * Searches the tree to see if the data exists in the tree
     * 
     * @param data the data to search for
     * @return data has been found (true) or not (false)
     */
    public boolean search(T data) {
        return recursiveSearch(data,root);
    }
        
    /**
     * Recursive search starting at the root of the tree
     * 
     * @param data the data to search for
     * @param current the current tree node reference
     * @return found (true) or not (false)
     */
    private boolean recursiveSearch(T data, TreeNode current) {
        if (current == null) return false;
        else if (data.compareTo((T)current.data) < 0) 
            return recursiveSearch(data,current.left);
        else if (data.compareTo((T)current.data) > 0) 
            return recursiveSearch(data,current.right);
        else return true;
    }
        
    /**
     * A pre-order traversal of the tree nodes
     * 
     * @return a linked list containing all the data pre-order
     */
    public LinkedList preOrder() {
        list = new LinkedList<T>();
        preOrderRecursive(root);
        return list;
    }
    
    /**
     * A post-order traversal of the tree nodes
     * 
     * @return a linked list containing all the data post-order
     */
    public LinkedList postOrder() {
        list = new LinkedList<T>();
        postOrderRecursive(root);
        return list;
    }
    
    /**
     * A in-order traversal of the tree nodes
     * 
     * @return a linked list containing all the data in-order
     */
    public LinkedList inOrder() {
        list = new LinkedList<T>();
        inOrderRecursive(root);
        return list;
    }
    
    /**
     * Recursive pre-order traversal starting at the root
     * 
     * @param current the reference to the current tree node
     */
    private void preOrderRecursive(TreeNode current) {
        if (current == null) return; // base
        list.add((T)current.data);
        preOrderRecursive(current.left);
        preOrderRecursive(current.right);
    }
    
    /**
     * Recursive post-order traversal starting at the root
     * 
     * @param current the reference to the current tree node
     */
    private void postOrderRecursive(TreeNode current) {
        if (current == null) return;         
        postOrderRecursive(current.left);
        postOrderRecursive(current.right);
        list.add((T)current.data);
    }
    
    /**
     * Recursive in-order traversal starting at the root
     * 
     * @param current the reference to the current tree node
     */
    private void inOrderRecursive(TreeNode current) {
        if (current == null) return;         
        inOrderRecursive(current.left);
        list.add((T)current.data);
        inOrderRecursive(current.right);        
    }
        
    /**
     * Inserts data recursively into the tree in order
     * 
     * @param data the data type to insert
     */
    public boolean insert(T data) {
        if (data == null) return false;
        order.add(data);
        if (root == null) root = new TreeNode<T>(data);
        else              root.insert(data);
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
        String text = "";        
        try {
            text = (T)(root.data).getClass().
                            getComponentType().
                            getSimpleName()
                    + " Tree Traversals:\n";
        }
        catch(NullPointerException error) {
            text = "Tree Traversals:\n";
        }        
        text += "Insert order:  " + order.toString() + "\n";
        text += "Pre-order is:  " + preOrder().toString() + "\n";
        text += "Post-order is: " + postOrder().toString() + "\n";
        text += "In-order is:   " + inOrder().toString() + "\n";
        return text;
    }    
    
    /**
     * Creates and returns a copy of this object, with the precise meaning
     * of "copy" depends on the class of the object
     * 
     * @return a deep clone of this instance
     */
    @Override
    public boolean equals(Object object) {
        LinkedList<T> inOrder1 = this.inOrder();
        LinkedList<T> inOrder2 = ((Tree)object).inOrder();
        return inOrder1.equals(inOrder2);
    }
    
    /**
     * Creates and returns a copy of this object, with the precise meaning
     * of "copy" depends on the class of the object
     * 
     * @return a deep clone of this instance
     */
    @Override
    public Tree clone() {
        Tree<T> tree = new Tree<>();
        for (int i = 0; i < order.size(); i++) {
            tree.insert((T)order.get(i));
        }
        return tree;
    }

}
