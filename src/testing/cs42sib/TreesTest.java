
/** required package class namespace */
package testing.cs42sib;

/** required imports */
import collections.LinkedList;
import collections.Queue;
import collections.Stack;
import collections.Tree;
import collections.TreeNode;
import io.Simulator;
import io.System;
import tools.Numbers;
import tools.Text;


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
        
        Simulator.comment("Building data structures from each other...");   
        
        final int WORD_LENGTH = 5;
        Text text = new Text();
        
        Simulator.comment("Create variable objects...");
        
        String variable1 = text.randomWord(WORD_LENGTH).toLowerCase();
        String variable2 = text.randomWord(WORD_LENGTH).toLowerCase();
        String variable3 = text.randomWord(WORD_LENGTH).toLowerCase();
        String variable4 = text.randomWord(WORD_LENGTH).toLowerCase();
        String variable5 = text.randomWord(WORD_LENGTH).toLowerCase();
        
        Simulator.comment("Create array from variables...");
        
        String[] array = {variable1,variable2,variable3,variable4,variable5};
        
        Simulator.comment("Create LinkedList from array...");
        
        LinkedList<String> list = new LinkedList<>(array);
        
        Simulator.comment("Create Stack from LinkedList...");
        
        Stack<String> stack = new Stack<>(list);
        
        Simulator.comment("Create Queue from Stack...");
        
        Queue<String> queue = new Queue<>(stack);
        
        Simulator.comment("Create Tree from Queue...");
        
        Tree<String> binaryTree = new Tree<>(queue);
        
        Simulator.comment("Output variables,array,list,stack,queue,tree...");
        
        System.out.println(variable1);
        System.out.println(variable2);
        System.out.println(variable3);
        System.out.println(variable4);
        System.out.println(variable5);
        System.out.println(text.toString(array));
        System.out.println(list);
        System.out.println(stack);
        System.out.println(queue);
        System.out.println(binaryTree);
        
        Simulator.comment("Now re-building queue from tree...");
        
        queue = new Queue<>(binaryTree);
        
        Simulator.comment("Now re-building stack from queue...");
        
        stack = new Stack<>(queue);
        
        Simulator.comment("Now re-building LinkedList from stack...");
        
        list = new LinkedList<>(stack);
        
        Simulator.comment("Now re-building array from LinkedList...");
        
        array = list.toArray(array);
        
        Simulator.comment("Output array,list,stack,queue,tree again...");
        
        System.out.println(text.toString(array));
        System.out.println(list);
        System.out.println(stack);
        System.out.println(queue);
        System.out.println(binaryTree);
        
        Simulator.header("Binary Trees Test completed!");
    }   

}
