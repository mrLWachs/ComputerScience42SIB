
/** Required package class namespace */
package testing.cs42sib;

/** Required imports */
import collections.BinaryTree;
import collections.LinkedList;
import collections.Queue;
import collections.Stack;
import collections.TreeNode;
import io.Simulator;
import tools.Numbers;
import tools.Text;


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
                
        Numbers n = new Numbers();                  // Object for random numbers
        Text    t = new Text();                     // Object for random text        
        
        final double LOW       = 0.000000001;       // Constants for randoms
        final double HIGH      = 9.999999999;
        final int    SIZE      = 10;                // Constants for sizes 
        final int    WORD_SIZE = 5;                
        final double PI   = n.round(Math.PI, 2);    // Specific number
                
        System.out.println("Create some TreeNode objects.....................");
        TreeNode<Double> n1 = new TreeNode<>(n.random(LOW, HIGH));
        TreeNode<Double> n2 = new TreeNode<>(n.random(LOW, HIGH));
        TreeNode<Double> n3 = new TreeNode<>(n.random(LOW, HIGH), n1, n2);
        
        System.out.println("Link to some other nodes.........................");        
        n1.left  = n2;
        n1.right = n3;
        
        System.out.println("Test equals......................................");        
        if (n1.equals(n2)) System.out.println("n1==n2");
        if (n1.equals(n3)) System.out.println("n1==n3");
        if (n2.equals(n3)) System.out.println("n2==N3");
        
        System.out.println("Test toString....................................");        
        System.out.println("n1 is " + n1.toString());
        System.out.println("n2 is " + n2.toString());
        System.out.println("n3 is " + n3.toString());
        
        System.out.println("Create a Binary Tree object......................");
        BinaryTree<Double> tree = new BinaryTree<>();
        
        System.out.println("Test toString....................................");
        System.out.println(tree.toString());
        
        System.out.println("Test insert......................................");
        for (int i = 0; i < SIZE; i++) {
            double number = n.random(LOW, HIGH);        // Create random number
            number = n.round(number, 2);                // Round it off
            boolean result = tree.insert(number);       // Insert into tree
            System.out.println("Result was " + result); // Display results
        }
        
        System.out.println("Re-test toString.................................");
        System.out.println(tree.toString());
        
        System.out.println("Test insert again (with specific number).........");
        tree.insert(PI);                                // Insert into tree
        
        System.out.println("Test search (for that specific number)...........");
        boolean result = tree.search(PI);
        System.out.println("Search for " + PI + " was " + result + 
                           " in the Binary Tree " + tree.toString()); 
        
        System.out.println("Test search (for random number)..................");
        double number = n.random(LOW, HIGH);        // Create random number
        number = n.round(number, 2);                // Round it off
        result = tree.search(number);
        System.out.println("Search for " + number + " was " + result + 
                           " in the Binary Tree " + tree.toString());
        
        System.out.println("Build second tree (test clone)...................");
        BinaryTree<Double> clone = tree.clone();
        
        System.out.println("Output both trees................................");
        System.out.println(tree.toString());
        System.out.println(clone.toString());
        
        System.out.println("Test equals......................................");
        result = tree.equals(clone);
        System.out.println("Tree equals clone is " + result);
        
        System.out.println("Change the clone by adding another value........");
        number = n.random(LOW, HIGH);        // Create random number
        clone.insert(number);
        
        System.out.println("Re-test equals...................................");
        result = tree.equals(clone);
        System.out.println("Tree equals clone is " + result);
        
        System.out.println("Build Random String Array........................");
        String[] array = t.randomWordSize(SIZE, WORD_SIZE);
        System.out.println(t.toString(array));
        
        System.out.println("Build Random String LinkedList...................");
        LinkedList<String> linkedList = new LinkedList<>(array);
        System.out.println(linkedList.toString());
        
        System.out.println("Build Random String Stack........................");
        Stack<String> stack = new Stack<>(linkedList);
        System.out.println(stack.toString());
        
        System.out.println("Build Random String Queue........................");
        Queue<String> queue = new Queue<>(stack);
        System.out.println(queue.toString());
        
        System.out.println("Build Trees from those other ADT objects.........");
        BinaryTree<String> tree1 = new BinaryTree<>(array);
        BinaryTree<String> tree2 = new BinaryTree<>(linkedList);
        BinaryTree<String> tree3 = new BinaryTree<>(stack);
        BinaryTree<String> tree4 = new BinaryTree<>(queue);
        
        System.out.println("Output all the new Trees.........................");
        System.out.println("Tree from Array is:      " + tree1.toString());
        System.out.println("Tree from LinkedList is: " + tree1.toString());
        System.out.println("Tree from Stack is:      " + tree1.toString());
        System.out.println("Tree from Queue is:      " + tree1.toString());
        
        Simulator.header("Binary Trees Test completed!");
    }   

}