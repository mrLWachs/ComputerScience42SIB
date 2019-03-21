
/** required package class namespace */
package testing.cs42sib.trees;

/** required imports */
import collections.LinkedList;
import collections.Queue;
import collections.Stack;
import collections.Tree;
import io.FileHandler;
import java.util.Arrays;
import testing.testclass.TestClass;
import tools.Sorter;
import io.System;

/**
 * StacksQueuesTest.java - the unit test to test the concept of binary trees
 *
 * @author Mr. Wachs 
 * @since 1-Mar-2019 
 */
public class TreeTest 
{

    /**
     * Default constructor for the class, sets class properties
     */
    public TreeTest() {
        System.out.header("Testing Trees started...");   
        
        System.out.println("\nCreating primative data types...\n");        
        int z = 50;
        int y = 21;
        int x = 96;
        int w = 12;
        int v = 38;
        int u = 42;
        int t = 7; 
        System.out.println("int = " + z);
        System.out.println("int = " + y);
        System.out.println("int = " + x);
        System.out.println("int = " + w);
        System.out.println("int = " + v);
        System.out.println("int = " + y);
        System.out.println("int = " + t);
        
        System.out.println("\nCreating class objects from primatives...\n");        
        Integer a = z, b = y, c = x, d = w, e = v, f = u, g = t;    
        System.out.println("Integer = " + a.toString());
        System.out.println("Integer = " + b.toString());
        System.out.println("Integer = " + c.toString());
        System.out.println("Integer = " + d.toString());
        System.out.println("Integer = " + e.toString());
        System.out.println("Integer = " + f.toString());
        System.out.println("Integer = " + g.toString());
        
        System.out.println("\nCreating from class objects: an array, "
                + "then linked list (from array), then stack (from list), "
                + "then queue (from stack), then tree (from queue)...\n");        
        Integer[]           array = { a,b,c,d,e,f,g };  
        LinkedList<Integer> list  = new LinkedList<>(array);  
        Stack<Integer>      stack = new Stack<>(list);   
        Queue<Integer>      queue = new Queue<>(stack);
        Tree<Integer>       tree  = new Tree<>(queue);
        
        System.out.println("Array = " + Arrays.toString(array));        
        System.out.println(list.toString());    
        System.out.println(stack.toString());    
        System.out.println(queue.toString()); 
        System.out.println("");
        System.out.println(tree.toString());         
        
        System.out.println("\nTesting Tree Clone, equals and search...\n");
        
        Tree treeClone = tree.clone();
        System.out.println("Original...");
        System.out.println(tree.toString()); 
        System.out.println("Clone...");
        System.out.println(treeClone.toString());    
        
        Integer item   = new Integer(99);
        Integer noItem = new Integer(-1);        
        if (tree.equals(treeClone)) System.out.println("Original == Clone");
        else                        System.out.println("Original != Clone"); 
        System.out.println("Changing clone...");
        treeClone.insert(item);
        if (tree.equals(treeClone)) System.out.println("Original == Clone");
        else                        System.out.println("Original != Clone");
        
        System.out.println("item    = " + treeClone.search(item));
        System.out.println("no item = " + treeClone.search(noItem));
        
        System.out.println("\nSorting original array and rebuilding tree...\n");
        
        Sorter sorter = new Sorter();
        sorter.bubble(array);
        tree = new Tree(array);
        System.out.println("Tree from sorted list...");
        System.out.println(tree.toString());
        
        System.out.println("\nSaving/opening tree to/from file...\n");
        
        System.out.println("Before save and open...");
        System.out.println(tree.toString());
        FileHandler file = new FileHandler();
        file.saveObject(tree, "testing.txt");
        tree = (Tree)file.openObject("testing.txt");
        System.out.println("After save and open...");
        System.out.println(tree.toString());       
                
        complicatedTest();
        
        System.out.header("Testing Trees complete!");
    }

    /**
     * Testing trees with more complicated class data
     */
    private void complicatedTest() {
        System.out.println("\nMore complicated tree test...\n");
        
        final int SIZE = 100;        
        TestClass array[] = TestClass.generateArray(SIZE);
        LinkedList<TestClass> list  = new LinkedList<>(array);
        Stack<Integer>        stack = new Stack<>(list);   
        Queue<Integer>        queue = new Queue<>(stack);
        Tree                  tree  = new Tree(stack);
        
        System.out.println("Array = " + Arrays.toString(array));
        System.out.println(list.toString());
        System.out.println(stack.toString());
        System.out.println(queue.toString());    
        System.out.println(tree.toString());
        
        System.out.println("\nTesting Clone, equals and search...\n");
        
        Tree treeClone = tree.clone();
        System.out.println("Original...");
        System.out.println(tree.toString()); 
        System.out.println("Clone...");
        System.out.println(treeClone.toString());    
        
        TestClass item   = new TestClass();
        TestClass noItem = new TestClass(false,0,0,'@',"");        
        if (tree.equals(treeClone)) System.out.println("Original == Clone");
        else                        System.out.println("Original != Clone"); 
        System.out.println("Changing clone...");
        treeClone.insert(item);
        if (tree.equals(treeClone)) System.out.println("Original == Clone");
        else                        System.out.println("Original != Clone");
        
        System.out.println("item    = " + treeClone.search(item));
        System.out.println("no item = " + treeClone.search(noItem));
        
        System.out.println("\nSorting original array and rebuilding tree...\n");
        
        Sorter sorter = new Sorter();
        sorter.bubble(array);
        tree = new Tree(array);
        System.out.println("Tree from sorted list...");
        System.out.println(tree.toString());
        
        System.out.println("\nSaving/opening tree to/from file...\n");
        
        System.out.println("Before save and open...");
        System.out.println(tree.toString());
        FileHandler file = new FileHandler();
        file.saveObject(tree, "testing.txt");
        tree = (Tree)file.openObject("testing.txt");
        System.out.println("After save and open...");
        System.out.println(tree.toString());  
        
    }
    
}
