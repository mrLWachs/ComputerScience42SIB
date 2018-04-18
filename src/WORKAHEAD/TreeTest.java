
/** required package class namespace */
package WORKAHEAD;

import collections.LinkedList;
import io.Output;
import numbers.Random;
//import testing.testclass.SubTestClass;

/**
 * TreeTest.java - description
 * @author lawrence.wachs
 * @since Feb 9, 2017
 * @version 1.0
 * @instructor Mr. Wachs
 */
public class TreeTest 
{
    
    /** default constructor */
    public TreeTest() {
        Output.header("Trees unit test", true, false);
        
        Output.header("Trees unit test", false, false);
    }
    
    

    private void inClass() {
        Tree<Integer> tree = new Tree<>();
        for (int i = 0; i < 7; i++) {
            tree.insert(Random.generate(1, 100));
        }
        System.out.println(tree);
        
        LinkedList<Integer> list = tree.postOrder();
        System.out.println("List: " + list + "\n");
        
        Tree<Integer> tree2 = new Tree<>(list);
        System.out.println(tree2);
        
        LinkedList<Integer> list2 = tree2.preOrder();
        System.out.println("List: " + list2 + "\n");
        
        Tree<Integer> tree3 = tree2.clone();
        System.out.println(tree3);
        
        if (tree3.equals(tree2)) {
            System.out.println("Equal trees");
        }
        else {
            System.out.println("Not equal trees");
        }
    }
    
//
//    private void bigTest() {
//        // size used for testing
//        int size = 10;
//        // create 6 lists (different data types)
//        LinkedList<Boolean>   list1 = new LinkedList<>();
//        LinkedList<Integer>   list2 = new LinkedList<>();
//        LinkedList<Double>    list3 = new LinkedList<>();
//        LinkedList<Character> list4 = new LinkedList<>(); 
//        LinkedList<String>    list5 = new LinkedList<>();
////        LinkedList<SubTestClass> list6 = new LinkedList<>();     
//        // fill the lists with random values
//        for (int i = 0; i < size; i++) {
//            list1.add(Random.generate());
//            list2.add(Random.generate(0,size-1));
//            list3.add(Random.generate(0d,(double)(size-1)));
//            list4.add(Random.generate('a','z'));            
//            list5.add(Random.generate(5));
////            list6.add(new SubTestClass());
//        }
//        // output the lists
//        System.out.println(list1);
//        System.out.println(list2);
//        System.out.println(list3);        
//        System.out.println(list4);
//        System.out.println(list5);
////        System.out.println(list6);
//        // create 6 Trees from the lists (matching data types)
//        Tree<Boolean>      tree1 = new Tree<>(list1);
//        Tree<Integer>      tree2 = new Tree<>(list2);
//        Tree<Double>       tree3 = new Tree<>(list3);
//        Tree<Character>    tree4 = new Tree<>(list4);
//        Tree<String>       tree5 = new Tree<>(list5);
////        Tree<SubTestClass> tree6 = new Tree<>(list6);
//        // output the Trees
//        System.out.println("Tree 1: " + tree1);
//        System.out.println("Tree 2: " + tree2);
//        System.out.println("Tree 3: " + tree3);        
//        System.out.println("Tree 4: " + tree4);
//        System.out.println("Tree 5: " + tree5);
////        System.out.println("Tree 6: " + tree6);
//        // make new Trees from clones of the old Trees          
//        Tree<Boolean>      tree7  = tree1.clone();
//        Tree<Integer>      tree8  = tree2.clone();
//        Tree<Double>       tree9  = tree3.clone();
//        Tree<Character>    tree10 = tree4.clone();
//        Tree<String>       tree11 = tree5.clone();
////        Tree<SubTestClass> tree12 = tree6.clone();
//        // output the new Trees
//        System.out.println("Tree 7: " + tree7);
//        System.out.println("Tree 8: " + tree8);
//        System.out.println("Tree 9: " + tree9);
//        System.out.println("Tree 10: " + tree10);
//        System.out.println("Tree 11: " + tree11);
////        System.out.println("Tree 12: " + tree12);        
//        // compare them to be equal (or not)
//        boolean result = true;  // assume they are all equal
//        if (!tree1.equals(tree7))  result = false;
//        if (!tree2.equals(tree8))  result = false;
//        if (!tree3.equals(tree9))  result = false;
//        if (!tree4.equals(tree10)) result = false;
//        if (!tree5.equals(tree11)) result = false;
////        if (!tree6.equals(tree12)) result = false;
//        if (result) System.out.println("All trees equal");
//        else        System.out.println("All trees not equal");
//        // insert random values into the trees
//        for (int i = 0; i < size; i++) {
//            tree1.insert(Random.generate());
//            tree2.insert(Random.generate(0,size-1));
//            tree3.insert(Random.generate(0d,(double)(size-1)));
//            tree4.insert(Random.generate('a','z'));            
//            tree5.insert(Random.generate(5));
////            tree6.insert(new SubTestClass());
//        }
//        // compare them to be equal (or not)
//        result = true;  // assume they are all equal
//        if (!tree1.equals(tree7))  result = false;
//        if (!tree2.equals(tree8))  result = false;
//        if (!tree3.equals(tree9))  result = false;
//        if (!tree4.equals(tree10)) result = false;
//        if (!tree5.equals(tree11)) result = false;
////        if (!tree6.equals(tree12)) result = false;
//        if (result) System.out.println("All trees equal");
//        else        System.out.println("All trees not equal");
//        // output all trees
//        System.out.println("Tree 1:  " + tree1);
//        System.out.println("Tree 2:  " + tree2);
//        System.out.println("Tree 3:  " + tree3);        
//        System.out.println("Tree 4:  " + tree4);
//        System.out.println("Tree 5:  " + tree5);
////        System.out.println("Tree 6:  " + tree6);
//        System.out.println("Tree 7:  " + tree7);
//        System.out.println("Tree 8:  " + tree8);
//        System.out.println("Tree 9:  " + tree9);
//        System.out.println("Tree 10: " + tree10);
//        System.out.println("Tree 11: " + tree11);
////        System.out.println("Tree 12: " + tree12);
//        // search for items in the tree
//        int location = Random.generate(0,size-1);
//        System.out.println("Search 1:  " + tree1.search(list1.get(location)));
//        System.out.println("Search 2:  " + tree2.search(list2.get(location)));
//        System.out.println("Search 3:  " + tree3.search(list3.get(location)));
//        System.out.println("Search 4:  " + tree4.search(list4.get(location)));
//        System.out.println("Search 5:  " + tree5.search(list5.get(location)));
////        System.out.println("Search 6:  " + tree6.search(list6.get(location)));
//        // search for items possibly in the tree
//        System.out.println("Search 7:  " + 
//                tree7.search(Random.generate()));
//        System.out.println("Search 8:  " + 
//                tree8.search(Random.generate(0,size-1)));
//        System.out.println("Search 9:  " + 
//                tree9.search(Random.generate(0d,(double)(size-1))));
//        System.out.println("Search 10: " + 
//                tree10.search(Random.generate('a','z')));
//        System.out.println("Search 11: " + 
//                tree11.search(Random.generate(5)));
////        System.out.println("Search 12: " + 
////                tree12.search(new SubTestClass()));
//        
//    }
    
}
