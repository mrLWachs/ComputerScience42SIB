
/** required package class namespace */
package testing.cs42sib;

/** required imports */
import collections.LinkedList;
import io.Output;
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

    private final int SIZE;
        
    private Searcher    search;
    private Sorter      sort;        
    private LinkedList  list;
    private TestClass[] array;
    private TestClass   arrayItem;
    private TestClass   listItem;    
    private TestClass   unfound;
    
    /** 
     * Default constructor for the class 
     */
    public SearchingAndSortingTest() {
        Output.header("Searching and Sorting unit testing",true,false);
        SIZE      = 10;                           
        search    = new Searcher();
        sort      = new Sorter();        
        list      = new LinkedList<>();
        array     = new TestClass[SIZE];
        arrayItem = new TestClass();
        listItem  = new TestClass();
        unfound   = new TestClass(true,0,0d,'a',"");
        Output.comment("Creating random unsorted array and LinkedList");          
        scramble();
        output();
        Output.comment("Testing linear search in array");
        int location = search.linear(arrayItem,array);     
        results("Middle", location,arrayItem);
        arrayItem = array[0];
        location = search.linear(arrayItem,array);
        results("Front", location,arrayItem);
        arrayItem = array[array.length-1];
        location = search.linear(arrayItem,array);
        results("Back", location,arrayItem);
        location = search.linear(unfound,array);
        results("Unfound", location,arrayItem);
        Output.comment("Testing linear search in list");
        location = search.linear(listItem,list);        
        results("Middle", location,listItem);
        listItem = (TestClass)list.front();
        location = search.linear(listItem,list);
        results("Front", location,listItem);
        listItem = (TestClass)list.back();
        location = search.linear(listItem,list);
        results("Back", location,listItem);
        location = search.linear(unfound,list);
        results("Unfound", location,listItem);
        presorted();
        Output.show("Creating random sorted array and LinkedList");
        output();        
        Output.comment("Testing binary search in array");
        location = search.binary(arrayItem,array);        
        results("Middle", location,arrayItem);                
        arrayItem = array[0];
        location = search.binary(arrayItem,array);
        results("Front", location,arrayItem);        
        arrayItem = array[array.length-1];
        location = search.binary(arrayItem,array);
        results("Back", location,arrayItem);        
        location = search.linear(unfound,array);
        results("Unfound", location,arrayItem);
        Output.comment("Testing binary search in list");
        location = search.binary(listItem,list);        
        results("Middle", location,listItem);                 
        listItem = (TestClass)list.front();
        location = search.binary(listItem,list);
        results("Front", location,listItem); 
        listItem = (TestClass)list.back();
        location = search.binary(listItem,list);
        results("Back", location,listItem); 
        location = search.binary(unfound,list);
        results("Unfound", location,listItem);
        Output.comment("Testing bubble sort");
        scramble();
        Output.comment("unsorted..."); 
        output();   
        sort.bubble(array);        
        sort.bubble(list);
        Output.comment("sorted...");
        output();   
        Output.comment("Testing selection sort");
        scramble();
        Output.comment("unsorted..."); 
        output();   
        sort.selection(array);        
        sort.selection(list);
        Output.comment("sorted...");
        output();
        Output.comment("Testing insertion sort");
        scramble();
        Output.comment("unsorted..."); 
        output();   
        sort.insertion(array);        
        sort.insertion(list);
        Output.comment("sorted...");
        output();
        Output.comment("Testing shell sort");
        scramble();
        Output.comment("unsorted..."); 
        output();   
        sort.shell(array);        
        sort.shell(list);
        Output.comment("sorted...");
        output();
        Output.comment("Testing quick sort");
        scramble();
        Output.comment("unsorted..."); 
        output();   
        sort.quick(array);        
        sort.quick(list);
        Output.comment("sorted...");
        output();  
        Output.header("Searching and Sorting unit testing",false,false);
    }

    /** 
     * Outputs the location results of the specific search for the item
     * 
     * @param find the text of the specific search
     * @param location the location of the search result
     * @param item the item searched for
     */
    private void results(String search, int location, TestClass item) {
        Output.show(search + " Item: " +  item + 
                " in array at location: " + location);
    }

    /**
     * Outputs the array and LinkedList 
     */
    private void output() {
        Output.show("Array: " + Output.arrayToString(array));
        Output.show("List:  " + list);
    }

    /**
     * Generates random array and LinkedList along with the search items
     */
    private void scramble() {
        array     = TestClass.generateArray(SIZE);
        list      = TestClass.generateList(SIZE);
        arrayItem = array[SIZE/2];
        listItem  = (TestClass)list.get(SIZE/2);
    }
    
    /**
     * Generates sorted random array and LinkedList along with the search items
     */
    private void presorted() {
        array     = TestClass.generateSortedArray(SIZE);
        list      = TestClass.generateSortedList(SIZE);
        arrayItem = array[SIZE/2];
        listItem  = (TestClass)list.get(SIZE/2);
    }

}
