
/** required package class namespace */
package testing.cs42sib;

import collections.Tree;
import collections.TreeNode;
import testing.Output;

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
    
    public void visual() {
        //////////////////////////////////////////////////////////////////
        Output.init();
        //////////////////////////////////////////////////////////////////
        
        Output.header("Trees unit testing",true,false);
        
        Output.comment("Create TreeNode objects to test, and output");        
        TreeNode<Integer> node1 = new TreeNode<>(50);
        TreeNode<Integer> node2 = new TreeNode<>(20);
        TreeNode<Integer> node3 = new TreeNode<>(70);
        node1.left  = node2;
        node1.right = node3;
        Output.show("Root node:  " + node1);
        Output.show("Left node:  " + node1.left);
        Output.show("Right node: " + node1.right);
                
        Output.comment("Create Tree object");
        Tree<Integer> tree = new Tree<>();
        
        Output.comment("Search for object in tree");
        tree.search(50);
        
        Output.header("Trees unit testing",false,false);
        
        //////////////////////////////////////////////////////////////////
        Output.flush();
        //////////////////////////////////////////////////////////////////
    }

}
