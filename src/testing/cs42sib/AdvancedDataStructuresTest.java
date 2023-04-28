/** Required package class namespace */
package testing.cs42sib;

import collections.BinaryTree;
import collections.LinkedList;
import collections.Queue;
import collections.Stack;
import io.Simulator;
import testing.testclass.TestClass;
import tools.Text;

 
/**
 * AdvancedDataStructuresTest.java - description
 *
 * @author Mr. Wachs
 * @since 10-Apr-2023, 1:05:46 PM
 */
public class AdvancedDataStructuresTest 
{

    /**
     * Default constructor, set class properties
     */
    public AdvancedDataStructuresTest() {
        Simulator.header("Advanced Data Structures Test started...");
        
        final int TEST_LENGTH = 50;   
        final int DATA_LENGTH = 5;
        
        TestClass[] array = new TestClass[TEST_LENGTH];
        
        for (int i = 0; i < TEST_LENGTH; i++) {
            TestClass variable = new TestClass(DATA_LENGTH);
            //System.out.println("variable = " + variable.toString());
            array[i] = variable;
        }
        
        System.out.println("array = " + new Text().toString(array));
        
        LinkedList<TestClass> list = new LinkedList<>(array);
        System.out.println("list = " + list.toString());
        
        Stack<TestClass> stack = new Stack<>(list);
        System.out.println("stack = " + stack.toString());
        
        Queue<TestClass> queue = new Queue<>(stack);
        System.out.println("queue = " + queue.toString());
        
//        BinaryTree<TestClass> tree = new BinaryTree<>(queue);
//        System.out.println("tree = " + tree.toString());
                
    }
     
}