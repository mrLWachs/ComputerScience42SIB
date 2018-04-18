
/** required package class namespace */
package WORKAHEAD;

/** required imports */
import collections.LinkedList;
import io.Output;
import numbers.Random;
import testing.testclass.TestClass;
//import searchsort.Sorter;

/**
 * SearchingAndSortingTest.java - the testing done on both searching and sorting, and
 the support methods to do this
 * @author Mr. Wachs
 * @param <T> the generic object used in this class
 * @since Mar 1, 2017
 * @instructor Mr. Wachs
 */
public class SearchingAndSortingTest <T> 
{
    
    /** default constructor for the class */
    public SearchingAndSortingTest() {
        Output.header("Searching and Sorting unit test", true, false);
        searchTest();
        sortTest();
        Output.header("Searching and Sorting unit test", false, false);
    }
    
    private void searchTest() {
        Output.header("Search Testing",true,false);
        
//        final int SIZE = 20;
//        
//        Searcher search = new Searcher();
//        
//        TestClass notFindableItem = new TestClass(true,0,0,' ',"");
//        
//        TestClass item = null;
//        int location = 0;       
//                    
//        Output.comment("Testing Linear search with LinkedLists, first "
//                + "create random object LinkedLists, and display:");
//        LinkedList<TestClass> list = TestClass.createLinkedListNoDuplicates(SIZE);
//        Output.show(list.toString());
//                
//        item = list.front();
//        location = search.linearSearch(item, list);        
//        Output.show("Linear Search for item " + item.toString() + 
//                " IN LinkedList (first item) at location " + location);
//                
//        item = list.back();
//        location = search.linearSearch(item, list);
//        Output.show("Linear Search for item " + item.toString() + 
//                " IN LinkedList (last item) at location " + location);
//        
//        location = Random.generate(0, SIZE-1);
//        item = list.get(location);
//        location = search.linearSearch(item, list);
//        Output.show("Linear Search for item " + item.toString() + 
//                " IN LinkedList (randomly) at location " + location);
//        
//        item = notFindableItem.clone();
//        location = search.linearSearch(item, list);
//        Output.show("Linear Search for item " + item.toString() + 
//                " NOT IN LinkedList at location " + location);
//        
//        
        
        
        
        Output.header("Search Testing",false,false);
    }

    private void sortTest() {
        Output.header("Sort Testing",true,false);
        
        
        Output.header("Sort Testing",false,false);
    }
    
    
//    
//    /** class constant property */
//    public static final int SIZE          = 500;
//    public static final int DISPLAY_LIMIT = 5;
//    
//    /** class data properties */
//    public static LinkedList<Boolean>      list1;
//    public static LinkedList<Integer>      list2;
//    public static LinkedList<Double>       list3;
//    public static LinkedList<Character>    list4;
//    public static LinkedList<String>       list5;  
//    public static Boolean[]                array1;
//    public static Integer[]                array2;
//    public static Double[]                 array3;
//    public static Character[]              array4;
//    public static String[]                 array5;
//    public static Boolean                  item1;
//    public static Integer                  item2;
//    public static Double                   item3;
//    public static Character                item4;
//    public static String                   item5;
//    public static Boolean                  item6;
//    public static Integer                  item7;
//    public static Double                   item8;
//    public static Character                item9;
//    public static String                   item10;
//    public static Boolean                  item11;
//    public static Integer                  item12;
//    public static Double                   item13;
//    public static Character                item14;
//    public static String                   item15;
//    public static Boolean                  item16;
//    public static Integer                  item17;
//    public static Double                   item18;
//    public static Character                item19;
//    public static String                   item20;
//    
//   
//    /** default constructor for the class */
//    public SearchingAndSortingTest() {
////        Tester.start("Searching and Sorting");
////        testing.searchsort.SearchTest searchTest = new testing.searchsort.SearchTest();
////        testing.searchsort.SortTest   sortTest   = new testing.searchsort.SortTest();        
////        Tester.end("Searching and Sorting");
//    }
//
//    /** resets all lists and arrays to random data */
//    public static void resetListAndArrayData() {
//        list1  = new LinkedList<>();
//        list2  = new LinkedList<>();
//        list3  = new LinkedList<>();
//        list4  = new LinkedList<>();
//        list5  = new LinkedList<>();  
//        array1 = new Boolean[SIZE];
//        array2 = new Integer[SIZE];
//        array3 = new Double[SIZE];
//        array4 = new Character[SIZE];
//        array5 = new String[SIZE];
//        for (int i = 0; i < SIZE; i++) {
//            item1 = Random.generate();
//            item2 = Random.generate(0,SIZE-1);
//            item3 = Random.generate(0d,(double)(SIZE-1));
//            item4 = Random.generate('a','z');
//            item5 = Random.generate(SIZE);
//            list1.add(item1);
//            list2.add(item2);
//            list3.add(item3);
//            list4.add(item4);
//            list5.add(item5);
//            array1[i] = item1;
//            array2[i] = item2;
//            array3[i] = item3;
//            array4[i] = item4;
//            array5[i] = item5;
//        }
//    }
//    
//    /** outputs all lists and arrays to the screen */
//    public static void outputListAndArrayData() {
//        System.out.println("List 1:  " + output(list1));
//        System.out.println("List 2:  " + output(list2));
//        System.out.println("List 3:  " + output(list3));
//        System.out.println("List 4:  " + output(list4));
//        System.out.println("List 5:  " + output(list5));
//        System.out.println("Array 1: " + output(array1));
//        System.out.println("Array 2: " + output(array2));
//        System.out.println("Array 3: " + output(array3));
//        System.out.println("Array 4: " + output(array4));
//        System.out.println("Array 5: " + output(array5));
//    }
//    
//    /** generates random data to search for in the lists and arrays */
//    public static void randomSearchItems() {
//        item1  = Random.generate();
//        item2  = Random.generate(0,SIZE-1);
//        item3  = Random.generate(0d,(double)(SIZE-1));
//        item4  = Random.generate('a','z');
//        item5  = Random.generate(SIZE);
//        item6  = Random.generate();
//        item7  = Random.generate(0,SIZE-1);
//        item8  = Random.generate(0d,(double)(SIZE-1));
//        item9  = Random.generate('a','z');
//        item10  = Random.generate(SIZE);        
//    }
//    
//    /** generates search data that is already in the lists and arrays */
//    public static void locationSearchItems() {
//        item11 = SearchingAndSortingTest.list1.get(Random.generate(0, SIZE-1));
//        item12 = SearchingAndSortingTest.list2.get(Random.generate(0, SIZE-1));
//        item13 = SearchingAndSortingTest.list3.get(Random.generate(0, SIZE-1));
//        item14 = SearchingAndSortingTest.list4.get(Random.generate(0, SIZE-1));
//        item15 = SearchingAndSortingTest.list5.get(Random.generate(0, SIZE-1));            
//        item16 = SearchingAndSortingTest.array1[Random.generate(0, SIZE-1)];
//        item17 = SearchingAndSortingTest.array2[Random.generate(0, SIZE-1)];
//        item18 = SearchingAndSortingTest.array3[Random.generate(0, SIZE-1)];
//        item19 = SearchingAndSortingTest.array4[Random.generate(0, SIZE-1)];
//        item20 = SearchingAndSortingTest.array5[Random.generate(0, SIZE-1)];
//    }
//            
//    /**
//     * outputs the search results
//     * @param <T> the generic object used in this class
//     * @param text which search results this is
//     * @param item the item being searched for
//     * @param location the result of the search
//     */
//    public static <T> void results(String text, T item, int location) {
//        System.out.println(text + "\t result = " + location + 
//                "\t for item " + item.toString());
//    }
//        
//    /** sorts all lists and arrays for the binary search */
//    public  static void sortAllListsAndArrays() {
//        Sorter sorter = new Sorter();                
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
//    }
//    
//    /**
//     * outputs the contents of an array on the screen
//     * @param <T> the generic object used in this class
//     * @param array the array to output
//     * @return the nicely formatted output of the array
//     */
//    private static <T> String output(T[] array) {
//        String text = "[";
//        for (int i = 0; i < DISPLAY_LIMIT; i++) {
//            text += array[i].toString() + ",";
//        }
//        return text + " ... " + array[array.length-1].toString() + "]";
//    }
//    
//    /**
//     * outputs the contents of a LinkedList on the screen
//     * @param <T> the generic object used in this class
//     * @param list the LinkedList to output
//     * @return the nicely formatted output of the array
//     */
//    private static <T> String output(LinkedList list) {
//        String text = "[";
//        for (int i = 0; i < DISPLAY_LIMIT; i++) {
//            text += list.get(i).toString() + ",";
//        }
//        return text + " ... " + list.get(list.size()-1).toString() + "]";
//    }
//    

    
}
