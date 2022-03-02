
/** Required package class namespace */
package testing.cs42sib;

/** Required imports */
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
        
        
        System.out.println("Create some TreeNode objects....");
        
        final double LOW  = 3.141;
        final double HIGH = 99.99;
                
        Numbers numbers = new Numbers();
        
        TreeNode<Double> node1 = new TreeNode<>(numbers.random(LOW, HIGH));
        TreeNode<Double> node2 = new TreeNode<>(numbers.random(LOW, HIGH));
        TreeNode<Double> node3 = new TreeNode<>(numbers.random(LOW, HIGH),
                                                node1, node2);
        
        System.out.println("Link some other nodes");
        
        node1.left = node2;
        node1.right = node3;
        
        System.out.println("Test the equals...");
        
        if (node1.equals(node2)) System.out.println("N1==N2");
        if (node1.equals(node3)) System.out.println("N1==N2");
        if (node2.equals(node3)) System.out.println("N1==N2");
        
        System.out.println("Test toString()....");
        
        System.out.println("N1 is " + node1.toString());
        System.out.println("N2 is " + node2.toString());
        System.out.println("N3 is " + node3.toString());
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        Simulator.header("Binary Trees Test completed!");
    }   

}