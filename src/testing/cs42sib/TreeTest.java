
/** required package class namespace */
package testing.cs42sib;

import collections.Tree;
import collections.TreeNode;

/**
 * TreeTest.java - tests the concepts learned in this unit
 *
 * @author Mr. Wachs 
 * @since Apr 26, 2018 
 * @instructor Mr. Wachs
 */
public class TreeTest 
{

    /** 
     * Default constructor for the class 
     */
    public TreeTest() {
        System.out.println("Tree unit test started...");
        TreeNode<Integer> node1 = new TreeNode<>(50);
        TreeNode<Integer> node2 = new TreeNode<>(20);
        TreeNode<Integer> node3 = new TreeNode<>(70);
        node1.left = node2;
        node1.right = node3;
        System.out.println(node1);
        
        Tree<Integer> tree = new Tree<>();
        
        tree.search(50);
        
        System.out.println("Tree unit test complete!");
    }

}
