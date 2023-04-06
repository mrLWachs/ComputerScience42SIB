
/** Required package class namespace */
package testing.cs42sib;

/** Required API imports */
import collections.BinaryTree;
import collections.TreeNode;
import io.Simulator;
import tools.Numbers;


/**
 * TreesTest.java - tests the concepts learned in this unit
 *
 * @author Mr. Wachs
 * @since Feb. 9, 2022, 8:01:03 a.m.
 */
public class TreesTest 
{

    /**
     * Default constructor, set class properties
     */
    public TreesTest() {
        Simulator.header("Binary Trees Test started...");
                
        // Constants/variables for creating random values......................
        Simulator.comment("Constants/variables for creating random values..."); 
        
        final int MIN   = 10;
        final int MAX   = 99;
        final int SIZE  = 10;        
        Numbers numbers = new Numbers();
        
        // Creating some TreeNode objects......................................
        Simulator.comment("Creating some TreeNode objects...");      
        
        TreeNode<Integer> node1 = new TreeNode<>(numbers.random(MIN, MAX));
        TreeNode<Integer> node2 = new TreeNode<>(numbers.random(MIN, MAX));
        TreeNode<Integer> node3 = new TreeNode<>(numbers.random(MIN, MAX),
                                                 node1,node2);
        // Linking the TreeNodes...............................................
        Simulator.comment("Linking the TreeNodes...");     
        
        node1.left  = node2;
        node1.right = node3;
        
        // Testing TreeNode equals..............................................
        Simulator.comment("Testing TreeNode equals...");    
        
        if (node1.equals(node2)) System.out.println("TreeNode1=TreeNode2");
        if (node1.equals(node3)) System.out.println("TreeNode1=TreeNode3");
        if (node2.equals(node3)) System.out.println("TreeNode2=TreeNode3");        
        
        // Testing TreeNode toString...........................................
        Simulator.comment("Testing TreeNode toString...");
        
        System.out.println(node1.toString());
        System.out.println(node2.toString());
        System.out.println(node3.toString());
        
        // Creating a Tree object..............................................
        Simulator.comment("Creating a Tree object...");  
        
        BinaryTree<Integer> tree = new BinaryTree<>();
        
        // Test the insert method..............................................
        for (int i = 0; i < SIZE; i++) {
            tree.insert(numbers.random(MIN, MAX));
        }
        
        
        
        
        
        
        Simulator.header("Binary Trees Test completed!");
    }   

}