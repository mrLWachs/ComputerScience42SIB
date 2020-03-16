
/** required package class namespace */
package testing.cs42sib;

/** required imports */
import collections.Tree;
import collections.TreeNode;
import io.Simulator;
import io.System;
import tools.Numbers;


/**
 * TreesTest.java - tests the concepts learned in this unit
 *
 * @author Mr. Wachs
 * @since Jan. 14, 2020, 8:01:03 a.m.
 */
public class TreesTest 
{

    /**
     * Default constructor, set class properties
     */
    public TreesTest() {
        Simulator.header("Binary Trees Test started...");
        
        Simulator.header("Constants/variables for creating random values...");        
        final int MIN   = 10;
        final int MAX   = 99;
        final int SIZE  = 10;        
        Numbers numbers = new Numbers();
        
        Simulator.comment("Creating some TreeNode objects...");        
        TreeNode<Integer> node1 = new TreeNode<>(numbers.random(MIN, MAX));
        TreeNode<Integer> node2 = new TreeNode<>(numbers.random(MIN, MAX));
        TreeNode<Integer> node3 = new TreeNode<>(numbers.random(MIN, MAX),
                                                 node1,node2);
        
        Simulator.comment("Linking the TreeNodes...");        
        node1.left  = node2;
        node1.right = node3;
        
        Simulator.comment("Testing TreeNode equals...");        
        if (node1.equals(node2)) System.out.println("TreeNode1=TreeNode2");
        if (node1.equals(node3)) System.out.println("TreeNode1=TreeNode3");
        
        Simulator.comment("Testing TreeNode toString...");
        System.out.println(node1.toString());
        System.out.println(node2.toString());
        System.out.println(node3.toString());
        
        Simulator.comment("Creating a Tree object...");        
        Tree<Integer> tree = new Tree<>();
        
        Simulator.comment("Testing Tree toString...");        
        System.out.println(tree.toString());
        
        Simulator.comment("Testing Tree insert...");        
        for (int i = 0; i < SIZE; i++) {
            tree.insert(numbers.random(MIN, MAX));
        }
        int value = numbers.random(MIN, MAX);
        tree.insert(value);
                      
        Simulator.comment("Testing Tree search...");        
        System.out.println("Should be found     = " + tree.search(value));      
        System.out.println("Should be NOT found = " + tree.search(0));        
            
        Simulator.comment("Re-testing Tree toString...");        
        System.out.println(tree.toString());
        
        Simulator.comment("Building second tree and testing equals...");        
        Tree<Integer> another = new Tree<>();
        for (int i = 0; i < SIZE+1; i++) {
            another.insert(numbers.random(MIN, MAX));
        }
        System.out.println("tree    -> " + tree.inOrder().toString());
        System.out.println("another -> " + another.inOrder().toString());
        if (tree.equals(another)) System.out.println("tree==another");
        else                      System.out.println("tree!=another");
        
        Simulator.comment("Building clone tree and testing equals...");        
        Tree<Integer> clone = tree.clone();
        System.out.println("tree  -> " + tree.inOrder().toString());
        System.out.println("clone -> " + clone.inOrder().toString());
        if (tree.equals(clone)) System.out.println("tree==clone");
        else                    System.out.println("tree!=clone");
        
        Simulator.header("Binary Trees Test completed!");
    }   

}
