
/** required package class namespace */
package testing.cs42sib;

/** required imports */
import collections.LinkedList;
import io.Output;
import numbers.Random;
import searchsort.Searcher;
import searchsort.Sorter;
import testing.testclass.TestClass;

/**
 * SearchingAndSortingTest.java - tests the concepts learned in this unit
 *
 * @author Mr. Wachs 
 * @since Feb 15, 2018 
 * @instructor Mr. Wachs
 */
public class SearchingAndSortingTest 
{

    public SearchingAndSortingTest() {
//        simple();
        
        Output.init();
        visual();
        Output.flush();
        
    }

    private void simple() {
        System.out.println("\nSearch test started...\n");
        
        final int SIZE = 10;
        final int MIN  = 0; 
        final int MAX  = SIZE;
        
        LinkedList<Integer> list    = new LinkedList<>();
        Integer[]           array   = new Integer[SIZE];
        Integer             item    = Random.generate(MIN, MAX);
        Integer             unfound = MIN-1;

        Searcher            search  = new Searcher();
        Sorter              sort    = new Sorter();
        
        // create random array and list
        System.out.println("Creating unsorted array and LinkedList "
                + "of random values");
        array = Random.generateIntegers(SIZE,MIN,MAX);
        list  = Random.generateIntegersList(SIZE,MIN,MAX);
        output(array);
        System.out.println("List \t " + list);
        
        
        System.out.println("\nTest linear search\n");
        
        System.out.println("Testing linear search in array");
        int location = search.linear(item,array);        
        System.out.println("Random Item in array\t" + item + 
                "\t location \t" + location);
                
        item = array[0];
        location = search.linear(item,array);
        System.out.println("Front Item in array\t" + item + 
                "\t location \t" + location);
        
        item = array[array.length-1];
        location = search.linear(item,array);
        System.out.println("Back Item in array\t" + item + 
                "\t location \t" + location);
        
        location = search.linear(unfound,array);
        System.out.println("Unfound Item in array\t" + unfound + 
                "\t location \t" + location);
        
        
        
        System.out.println("Testing linear search in list");
        location = search.linear(item,list);        
        System.out.println("Random Item in list\t" + item + 
                "\t location \t" + location);
                
        item = list.front();
        location = search.linear(item,list);
        System.out.println("Front Item in list\t" + item + 
                "\t location \t" + location);
        
        item = list.back();
        location = search.linear(item,list);
        System.out.println("Back Item in list\t" + item + 
                "\t location \t" + location);
        
        location = search.linear(unfound,list);
        System.out.println("Unfound Item in list\t" + unfound + 
                "\t location \t" + location);
                
        
        System.out.println("\nTest binary search\n");
        array = Random.generateSortedIntegers(SIZE,MIN,MAX);
        list  = Random.generateSortedIntegersList(SIZE,MIN,MAX);
        System.out.println("Creating sorted array and LinkedList "
                + "of random values");
        output(array);
        System.out.println("List \t " + list);
        
        System.out.println("Testing binary search in array");
        location = search.binary(item,array);        
        System.out.println("Random Item in array\t" + item + 
                "\t location \t" + location);
                
        item = array[0];
        location = search.binary(item,array);
        System.out.println("Front Item in array\t" + item + 
                "\t location \t" + location);
        
        item = array[array.length-1];
        location = search.binary(item,array);
        System.out.println("Back Item in array\t" + item + 
                "\t location \t" + location);
        
        location = search.linear(unfound,array);
        System.out.println("Unfound Item in array\t" + unfound + 
                "\t location \t" + location);
        
        
        
        System.out.println("Testing binary search in list");
        location = search.binary(item,list);        
        System.out.println("Random Item in list\t" + item + 
                "\t location \t" + location);
                
        item = list.front();
        location = search.binary(item,list);
        System.out.println("Front Item in list\t" + item + 
                "\t location \t" + location);
        
        item = list.back();
        location = search.binary(item,list);
        System.out.println("Back Item in list\t" + item + 
                "\t location \t" + location);
        
        location = search.binary(unfound,list);
        System.out.println("Unfound Item in list\t" + unfound + 
                "\t location \t" + location);
        
        
        
        System.out.println("\nTest sorts\n");
        
        
        
        
        System.out.println("Test bubble sort");
        System.out.println("unsorted..."); 
        output(array);
        System.out.println("List \t " + list);
        sort.bubble(array);        
        sort.bubble(list);
        System.out.println("sorted...");
        output(array);
        System.out.println("List \t " + list);
                       
        
        // randomize array and list  
        System.out.println("Test Selection sort");
        array = Random.generateIntegers(SIZE,MIN,MAX);
        list  = Random.generateIntegersList(SIZE,MIN,MAX);
        System.out.println("unsorted...");
        output(array);
        System.out.println("List \t " + list);
        
        // selection sort
        System.out.println("sorted...");
        sort.selection(array);
        output(array);
        sort.selection(list);
        System.out.println("List \t " + list);
        
        
        
        // randomize array and list  
        System.out.println("Test insertion sort");
        array = Random.generateIntegers(SIZE,MIN,MAX);
        list  = Random.generateIntegersList(SIZE,MIN,MAX);
        System.out.println("unsorted...");
        output(array);
        System.out.println("List \t " + list);
        
        // insertion sort
        System.out.println("sorted...");
        sort.insertion(array);
        output(array);
        sort.insertion(list);
        System.out.println("List \t " + list);
        
        
        
        // randomize array and list  
        System.out.println("Test shell sort");
        array = Random.generateIntegers(SIZE,MIN,MAX);
        list  = Random.generateIntegersList(SIZE,MIN,MAX);
        System.out.println("unsorted...");
        output(array);
        System.out.println("List \t " + list);
        
        // shell sort
        System.out.println("sorted...");
        sort.shell(array);
        output(array);
        sort.shell(list);
        System.out.println("List \t " + list);
        
        
        // randomize array and list  
        System.out.println("Test quick sort");
        array = Random.generateIntegers(SIZE,MIN,MAX);
        list  = Random.generateIntegersList(SIZE,MIN,MAX);
        System.out.println("unsorted...");
        output(array);
        System.out.println("List \t " + list);
        
        // quick sort
        System.out.println("sorted...");
        sort.quick(array);
        output(array);
        sort.quick(list);
        System.out.println("List \t " + list);
        
        
        
        
        
        System.out.println("\nSearch test complete...\n");
    }
        
    private<T> void output(T[] array) {
        String text = "Array \t [";
        for (int i = 0; i < array.length - 1; i++) {
            text += array[i].toString() + ",";
        }
        System.out.println(text + array[array.length-1] + "]");
    }

    private void visual() {
        Output.header("Search Testing",true,false);
        
        final int SIZE = 10;
        
        LinkedList  list    = new LinkedList<>();
        TestClass[] array   = new TestClass[SIZE];
        TestClass   item    = array[SIZE/2];
        TestClass   unfound = new TestClass(true,0,0d,'a',"");
        
        Searcher search  = new Searcher();
        Sorter   sort    = new Sorter();
        
        // create random array and list
        Output.comment("Creating unsorted array and LinkedList "
                + "of random values");
        array   = TestClass.generateArray(SIZE);
        list    = TestClass.generateList(SIZE);
        item    = array[SIZE/2];
        unfound = new TestClass(true,0,0d,'a',"");
        Output.show("Array \t" + Output.arrayToString(array));
        Output.show("List \t  " + list);
        
        Output.comment("Test linear search");
        
        Output.comment("Testing linear search in array");
        int location = search.linear(item,array);        
        Output.show("Middle Item in array\t" + item + 
                "\t location \t" + location);
                
        item = array[0];
        location = search.linear(item,array);
        Output.show("Front Item in array\t" + item + 
                "\t location \t" + location);
        
        item = array[array.length-1];
        location = search.linear(item,array);
        Output.show("Back Item in array\t" + item + 
                "\t location \t" + location);
        
        location = search.linear(unfound,array);
        Output.show("Unfound Item in array\t" + unfound + 
                "\t location \t" + location);
        
        Output.comment("Testing linear search in list");
        location = search.linear(item,list);        
        Output.show("Middle Item in list\t" + item + 
                "\t location \t" + location);
                
        item = (TestClass)list.front();
        location = search.linear(item,list);
        Output.show("Front Item in list\t" + item + 
                "\t location \t" + location);
        
        item = (TestClass)list.back();
        location = search.linear(item,list);
        Output.show("Back Item in list\t" + item + 
                "\t location \t" + location);
        
        location = search.linear(unfound,list);
        Output.show("Unfound Item in list\t" + unfound + 
                "\t location \t" + location);
              
        Output.comment("Test binary search");
        array   = TestClass.generateArray(SIZE);
        list    = TestClass.generateList(SIZE);
        item    = array[SIZE/2];
        unfound = new TestClass(true,0,0d,'a',"");
        Output.show("Creating sorted array and LinkedList "
                + "of random values");
        Output.show("Array \t" +Output.arrayToString(array));
        Output.show("List \t  " + list);
        
        Output.comment("Testing binary search in array");
        location = search.binary(item,array);        
        Output.show("Middle Item in array\t" + item + 
                "\t location \t" + location);
                
        item = array[0];
        location = search.binary(item,array);
        Output.show("Front Item in array\t" + item + 
                "\t location \t" + location);
        
        item = array[array.length-1];
        location = search.binary(item,array);
        Output.show("Back Item in array\t" + item + 
                "\t location \t" + location);
        
        location = search.linear(unfound,array);
        Output.show("Unfound Item in array\t" + unfound + 
                "\t location \t" + location);
        
        Output.comment("Testing binary search in list");
        location = search.binary(item,list);        
        Output.show("Middle Item in list\t" + item + 
                "\t location \t" + location);
                
        item = (TestClass)list.front();
        location = search.binary(item,list);
        Output.show("Front Item in list\t" + item + 
                "\t location \t" + location);
        
        item = (TestClass)list.back();
        location = search.binary(item,list);
        Output.show("Back Item in list\t" + item + 
                "\t location \t" + location);
        
        location = search.binary(unfound,list);
        Output.show("Unfound Item in list\t" + unfound + 
                "\t location \t" + location);
        
        Output.comment("Test sorts");
        
        Output.comment("Test bubble sort");
        Output.comment("unsorted..."); 
        Output.show("Array \t" +Output.arrayToString(array));
        Output.show("List \t  " + list);
        sort.bubble(array);        
        sort.bubble(list);
        Output.comment("sorted...");
        Output.show("Array \t" +Output.arrayToString(array));
        Output.show("List \t  " + list);
                
        // randomize array and list  
        Output.comment("Test Selection sort");
        array   = TestClass.generateArray(SIZE);
        list    = TestClass.generateList(SIZE);
        Output.comment("unsorted...");
        Output.show("Array \t" + Output.arrayToString(array));
        Output.show("List \t  " + list);
        
        // selection sort
        Output.comment("sorted...");
        sort.selection(array);
        Output.show("Array \t" +Output.arrayToString(array));
        sort.selection(list);
        Output.show("List \t  " + list);
        
        // randomize array and list  
        Output.comment("Test insertion sort");
        array   = TestClass.generateArray(SIZE);
        list    = TestClass.generateList(SIZE);
        Output.comment("unsorted...");
        Output.show("Array \t" +Output.arrayToString(array));
        Output.comment("List \t  " + list);
        
        // insertion sort
        Output.comment("sorted...");
        sort.insertion(array);
        Output.show("Array \t" + Output.arrayToString(array));
        sort.insertion(list);
        Output.show("List \t  " + list);
        
        // randomize array and list  
        Output.comment("Test shell sort");
        array   = TestClass.generateArray(SIZE);
        list    = TestClass.generateList(SIZE);
        Output.comment("unsorted...");
        Output.show("Array \t" +Output.arrayToString(array));
        Output.show("List \t  " + list);
        
        // shell sort
        Output.comment("sorted...");
        sort.shell(array);
        Output.show("Array \t" +Output.arrayToString(array));
        sort.shell(list);
        Output.show("List \t  " + list);
                
        // randomize array and list  
        Output.comment("Test quick sort");
        array = TestClass.generateArray(SIZE);
        list  = TestClass.generateList(SIZE);
        Output.comment("unsorted...");
        Output.show("Array \t" +Output.arrayToString(array));
        Output.show("List \t  " + list);
        
        // quick sort
        Output.comment("sorted...");
        sort.quick(array);
        Output.show("Array \t" +Output.arrayToString(array));
        sort.quick(list);
        Output.show("List \t  " + list);
                
        Output.header("Search Testing",false,false);
    }
    
}
