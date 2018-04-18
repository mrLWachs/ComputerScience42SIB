
/** required package class namespace */
package WORKAHEAD;

import WORKAHEAD.Sorter;
//import testing.TestController;
import testing.Tester;
import testing.testclass.TestClass;
//import testing.advancedclasses.Student;

/**
 * SortTest.java - the testing done on the Sorter class
 * @author Mr. Wachs
 * @since Mar 1, 2017
 * @instructor Mr. Wachs
 */
public class SortTest 
{
//    
//    /** default constructor for the class */
//    public SortTest() {
//        sort();
////        Tester.start("Sorting");
//////        classTest();
////        bigTest();        
////        Tester.end("Sorting");
//    }
//
//    private static void sort() {
//        
//        final int LENGTH = 10;        
//        TestClass[] tests = new TestClass[LENGTH];
//        for (int i = 0; i < tests.length; i++) {
//            tests[i] = new TestClass();
//        }
//                
//        System.out.print("Unsorted:\t");
//        for (int i = 0; i < tests.length-1; i++) {
//            System.out.print(tests[i].toString() + ",");
//        }
//        System.out.println(tests[tests.length-1].toString());
//        
//        for (int i = 0; i < tests.length; i++) {
//            for (int j = 0; j < tests.length - 1; j++) {
//                if (tests[j].compareTo(tests[j+1]) > 0) {
//                    TestClass temp = tests[j].clone();
//                    tests[j]   = tests[j+1].clone();
//                    tests[j+1] = temp.clone();
//                }
//            }
//        } 
//        
//        System.out.print("Sorted:\t\t");
//        for (int i = 0; i < tests.length-1; i++) {
//            System.out.print(tests[i].toString() + ",");
//        }
//        System.out.println(tests[tests.length-1].toString());
//        
//        boolean b1 = true;
//        boolean b2 = true;
//        
//        int i1 = 1000000000;
//        int i2 = 1000000000;
//        
//        double d1 = 1234567890.0987654321;
//        double d2 = 1234567890.0987654321;
//        
//        char c1 = 'a';
//        char c2 = 'a';
//        
//        String s1 = "abcdefghijklmnopqrstuvwxyz"
//                + "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
//                + "1234567890~!@#$%^&*()-=";
//          
//        String s2 = "abcdefghijklmnopqrstuvwxyz"
//                + "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
//                + "1234567890~!@#$%^&*()-=";
//        
//        TestClass x = new TestClass(b1, i1, d1, c1, s1);
//        TestClass y = new TestClass(b2, i2, d2, c2, s2);
//        
//        System.out.println("x = " + x.toString());
//        System.out.println("y = " + y.toString());
//        
//        if      (x.compareTo(y) >  0) System.out.println("x > y");
//        else if (x.compareTo(y) <  0) System.out.println("x < y");
//        else if (x.compareTo(y) == 0) System.out.println("x == y");
//        
//        TestClass a = new TestClass();
//        TestClass b = new TestClass();
//        
//        System.out.println("a = " + a.toString());
//        System.out.println("b = " + b.toString());
//        
//        if      (a.compareTo(b) >  0) System.out.println("a > b");
//        else if (a.compareTo(b) <  0) System.out.println("a < b");
//        else if (a.compareTo(b) == 0) System.out.println("a == b");
//        
//    }
//    
//    private void classTest() {
////        Integer[] a1 = {
////            72,1,12,-4,0,99,63,150,4            
////        };          
////
////        new Tester().output(a1);
////        Sorter<Integer> sorter1 = new Sorter<>();        
////        sorter1.bubbleSort(a1); 
////        new Tester().output(a1);
////        
////        Student[] a2 = {
////            new Student("C",3,true,3),
////            new Student("A",1,true,1),
////            new Student("D",4,false,4),
////            new Student("E",5,true,5),
////            new Student("B",2,false,2)
////        };
////        
////        new Tester().output(a2);
////        Sorter<Student> sorter2 = new Sorter<>();        
////        sorter2.bubbleSort(a2); 
////        new Tester().output(a2);       
////        
////                
////        Double[] a3 = {
////            199.9, 3.14, 72.3, 242.1, 87.8, 55.9
////        };
////        
////        new Tester().output(a3);        
////        Sorter<Double> sorter3 = new Sorter<>();
////        sorter3.selectionSort(a3);        
////        new Tester().output(a3);
//        
//        
//        
//        
//    }
//    
//    /** the large test on a variety of data types */
//    private void bigTest() {
//        Sorter sorter = new Sorter();        
//        
//        System.out.println("\nReseting Bubble Sorting Data...");
//        SearchingAndSortingTest.resetListAndArrayData();
//        SearchingAndSortingTest.outputListAndArrayData();
//        System.out.println("\nBubble Sorting Data...");
//        sorter.bubbleSort(SearchingAndSortingTest.array1);
//        sorter.bubbleSort(SearchingAndSortingTest.array2);
//        sorter.bubbleSort(SearchingAndSortingTest.array3);
//        sorter.bubbleSort(SearchingAndSortingTest.array4);
//        sorter.bubbleSort(SearchingAndSortingTest.array5);
//        sorter.bubbleSort(SearchingAndSortingTest.list1);
//        sorter.bubbleSort(SearchingAndSortingTest.list2);
//        sorter.bubbleSort(SearchingAndSortingTest.list3);
//        sorter.bubbleSort(SearchingAndSortingTest.list4);
//        sorter.bubbleSort(SearchingAndSortingTest.list5);
//        SearchingAndSortingTest.outputListAndArrayData();   
//        
//        System.out.println("\nReseting Selection Sorting Data...");
//        SearchingAndSortingTest.resetListAndArrayData();
//        SearchingAndSortingTest.outputListAndArrayData();        
//        System.out.println("\nSelection Sorting Data...");  
//        sorter.selectionSort(SearchingAndSortingTest.array1);
//        sorter.selectionSort(SearchingAndSortingTest.array2);
//        sorter.selectionSort(SearchingAndSortingTest.array3);
//        sorter.selectionSort(SearchingAndSortingTest.array4);
//        sorter.selectionSort(SearchingAndSortingTest.array5);        
//        sorter.selectionSort(SearchingAndSortingTest.list1);
//        sorter.selectionSort(SearchingAndSortingTest.list2);
//        sorter.selectionSort(SearchingAndSortingTest.list3);
//        sorter.selectionSort(SearchingAndSortingTest.list4);
//        sorter.selectionSort(SearchingAndSortingTest.list5);
//        
//        System.out.println("\nReseting Insertion Sorting Data...");
//        SearchingAndSortingTest.resetListAndArrayData();
//        SearchingAndSortingTest.outputListAndArrayData();        
//        System.out.println("\nInsertion Sorting Data...");  
//        sorter.insertionSort(SearchingAndSortingTest.array1);
//        sorter.insertionSort(SearchingAndSortingTest.array2);
//        sorter.insertionSort(SearchingAndSortingTest.array3);
//        sorter.insertionSort(SearchingAndSortingTest.array4);
//        sorter.insertionSort(SearchingAndSortingTest.array5);        
//        sorter.selectionSort(SearchingAndSortingTest.list1);
//        sorter.selectionSort(SearchingAndSortingTest.list2);
//        sorter.selectionSort(SearchingAndSortingTest.list3);
//        sorter.selectionSort(SearchingAndSortingTest.list4);
//        sorter.selectionSort(SearchingAndSortingTest.list5);
//        
//        System.out.println("\nReseting Shell Sorting Data...");
//        SearchingAndSortingTest.resetListAndArrayData();
//        SearchingAndSortingTest.outputListAndArrayData();        
//        System.out.println("\nShell Sorting Data...");  
//        sorter.shellSort(SearchingAndSortingTest.array1);
//        sorter.shellSort(SearchingAndSortingTest.array2);
//        sorter.shellSort(SearchingAndSortingTest.array3);
//        sorter.shellSort(SearchingAndSortingTest.array4);
//        sorter.shellSort(SearchingAndSortingTest.array5);        
//        sorter.shellSort(SearchingAndSortingTest.list1);
//        sorter.shellSort(SearchingAndSortingTest.list2);
//        sorter.shellSort(SearchingAndSortingTest.list3);
//        sorter.shellSort(SearchingAndSortingTest.list4);
//        sorter.shellSort(SearchingAndSortingTest.list5);
//        
//        System.out.println("\nReseting Quick Sorting Data...");
//        SearchingAndSortingTest.resetListAndArrayData();
//        SearchingAndSortingTest.outputListAndArrayData();        
//        System.out.println("\nQuick Sorting Data...");  
//        sorter.quickSort(SearchingAndSortingTest.array1);
//        sorter.quickSort(SearchingAndSortingTest.array2);
//        sorter.quickSort(SearchingAndSortingTest.array3);
//        sorter.quickSort(SearchingAndSortingTest.array4);
//        sorter.quickSort(SearchingAndSortingTest.array5);        
//        sorter.quickSort(SearchingAndSortingTest.list1);
//        sorter.quickSort(SearchingAndSortingTest.list2);
//        sorter.quickSort(SearchingAndSortingTest.list3);
//        sorter.quickSort(SearchingAndSortingTest.list4);
//        sorter.quickSort(SearchingAndSortingTest.list5);
//
//        SearchingAndSortingTest.outputListAndArrayData();
//    }
//    
}
