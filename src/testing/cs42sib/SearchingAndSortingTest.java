
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
        simple();
//        visual();
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
        
        Searcher search = new Searcher();
        
        TestClass notFindableItem = new TestClass(true,0,0,' ',"");
        
        TestClass item = null;
        int location = 0;       
                    
        Output.comment("Testing LinkedList with random non-duplicates, and display:");
        LinkedList list = TestClass.generateUniqueList(SIZE);
        Output.show(list.toString());
             
        Output.comment("Linear search with LinkedList, testing edges"); 
        
        item = (TestClass)list.front();
        location = search.linear(item, list);        
        Output.show("Linear Search for item " + item.toString() + 
                " IN LinkedList (first item) at location " + location);
                
        item = (TestClass)list.back();
        location = search.linear(item, list);
        Output.show("Linear Search for item " + item.toString() + 
                " IN LinkedList (last item) at location " + location);
        
        location = Random.generate(0, SIZE-1);
        item = (TestClass)list.get(location);
        location = search.linear(item, list);
        Output.show("Linear Search for item " + item.toString() + 
                " IN LinkedList (randomly) at location " + location);
        
        item = notFindableItem.clone();
        location = search.linear(item, list);
        Output.show("Linear Search for item " + item.toString() + 
                " NOT IN LinkedList at location " + location);
        

        Output.comment("Testing array with random non-duplicates, and display:");
        TestClass[] array = new TestClass[SIZE];
        array = (TestClass[])TestClass.generateList(SIZE).toArray(array);
        Output.show(Output.arrayToString(array));
        
        Output.comment("Linear search with array, testing edges"); 
        
        item = array[0];
        location = search.linear(item, array);        
        Output.show("Linear Search for item " + item.toString() + 
                " IN array (first item) at location " + location);
                
        item = array[array.length-1];
        location = search.linear(item, array);
        Output.show("Linear Search for item " + item.toString() + 
                " IN array (last item) at location " + location);
        
        location = Random.generate(0, SIZE-1);
        item = array[location];
        location = search.linear(item, array);
        Output.show("Linear Search for item " + item.toString() + 
                " IN array (randomly) at location " + location);
        
        item = notFindableItem.clone();
        location = search.linear(item, array);
        Output.show("Linear Search for item " + item.toString() + 
                " NOT IN array at location " + location);
        
        
        
        
        Output.header("Search Testing",false,false);
    }
    
}
