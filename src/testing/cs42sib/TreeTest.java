
/** required package class namespace */
package testing.cs42sib;

import collections.LinkedList;
import collections.Tree;
import collections.TreeNode;
import numbers.Random;
import testing.Output;
import testing.testclass.TestClass;

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
        Output.header("Tree unit testing",true,false);
        Output.comment("Create 3 TreeNode objects, connect, and output");
        TreeNode node1 = new TreeNode(new TestClass());
        TreeNode node2 = new TreeNode(new TestClass());
        TreeNode node3 = new TreeNode(new TestClass());
        node1.left  = node2;
        node1.right = node3;
        Output.show("Root  node:  " + node1);
        Output.show("Left  node:  " + node2);
        Output.show("Right node:  " + node3);                
        Output.comment("Create Tree empty");
        final int SIZE = 10; 
        LinkedList list = new LinkedList();
        Tree tree = new Tree();
        Output.comment("Insert " + SIZE + " random objects into tree");
        for (int i = 0; i < SIZE; i++) {
            TestClass testClass = new TestClass();
            list.add(testClass);
            tree.insert(testClass);
        }
        Output.comment("Ouptut tree");
        Output.show(tree);
        Output.comment("Cloning tree and ouptut");
        Tree clone = tree.clone();
        Output.show(clone);
        Output.comment("Testing equals");
        if (tree.equals(clone)) Output.show("Equal Trees");
        else                    Output.show("Not equal Trees");
        Output.comment("Changing clone tree and checking equals again");
        clone.insert(new TestClass());
        if (tree.equals(clone)) Output.show("Equal Trees");
        else                    Output.show("Not equal Trees");                
        Output.comment("Testing search (item not in tree)");
        TestClass unfound = new TestClass(true,0,0d,'a',"");
        boolean result = tree.search(unfound);
        Output.show("Item: " +  unfound + " in Tree is " + result);        
        Output.comment("Testing search (item in tree)");
        TestClass item = (TestClass)list.get(Random.generate(0, SIZE-1));
        result = tree.search(item);
        Output.show("Item: " +  item + " in Tree is " + result);        
        Output.comment("Creating tree from LinkedList and output");
        list.clear();
        for (int i = 0; i < SIZE; i++) {
            list.add(new TestClass());
        }
        Tree treeFromList = new Tree(list);
        Output.show(treeFromList);
        Output.header("Tree unit testing",false,false);
    }

}
