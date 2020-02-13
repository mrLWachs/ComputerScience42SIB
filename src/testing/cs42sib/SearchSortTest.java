
/** required package class namespace */
package testing.cs42sib;

/** required imports */
import io.Simulator;
import tools.Numbers;
import tools.Text;


/**
 * SearchSortTest.java - tests the concepts learned in this unit
 *
 * @author Mr. Wachs
 * @since Jan. 14, 2020, 8:01:03 a.m.
 */
public class SearchSortTest 
{

    /**
     * Default constructor, set class properties
     */
    public SearchSortTest() {
        Simulator.header("Searching and Sorting Test started...");
        
        Simulator.comment("For the I.B. exam, only need to know...");
        Simulator.comment("Linear search and binary search");
        Simulator.comment("Bubble sort and Selection sort");
                
        Simulator.comment("Create constants for the data...");
        
        Numbers   numbers  = new Numbers();         // for random values
        final int MIN      = 0;                     // low array bound
        final int MAX      = 10;                    // high array bound
        final int SMALLEST = -10;                   // lowest random value
        final int LARGEST  = 10;                    // highest random value
                
        Simulator.comment("Create random data to search and sort for...");
        Simulator.comment("Including all edge cases to test for");
        
        int[] array      = numbers.random(SMALLEST, LARGEST, MAX);
        int   randomItem = numbers.random(SMALLEST, LARGEST);
        int   itemInList = array[numbers.random(MIN+1,MAX-2)];
        int   firstItem  = array[0];
        int   lastItem   = array[MAX-1];
        int   notInList  = LARGEST + 1;
        
        int[] findItems = {
            randomItem,
            itemInList,
            firstItem,
            lastItem,
            notInList
        };                                          // all edge test cases
        
        Simulator.comment("Create data to store the results...");
        
        boolean found  = false;                     // simple search result
        int     index  = -1;                        // index search result
        int[]   sorted = new int[MAX];              // store sorted array
        
        Simulator.comment("Now execute the linear search on all test data...");
        
        for (int i = 0; i < findItems.length; i++) {    // traverse test cases
            int item = findItems[i];                // test case to search for
            found = search(array,item);             // simple search
            index = linearSearch(array,item);       // index search
            results(array,item,found,index);        // show results
        }
        
        Simulator.comment("Now execute the bubble sort...");
        
        sorted = bubbleSort(array);                 // bubble sort
        results(array,sorted);                      // show results
        
        Simulator.comment("Now execute the selection sort...");
        
        sorted = selectionSort(array);              // selection sort
        results(array,sorted);                      // show results
        
        Simulator.comment("Now execute the binary search on all test data...");
        
        for (int i = 0; i < findItems.length; i++) {    // traverse test cases
            int item = findItems[i];                // test case to search for
            index = binarySearch(sorted,item);      // index search
            results(sorted,item,found,index);       // show results
        }
        
        Simulator.header("Searching and Sorting Test completed!");
    }   

    private boolean search(int[] array, int item) {
        return false;
    }

    private int linearSearch(int[] array, int item) {
        return -1;
    }

    private int[] bubbleSort(int[] array) {
        return array;
    }
    
    private int[] selectionSort(int[] array) {
        return array;
    }

    private int binarySearch(int[] sorted, int item) {
        return -1;
    }
    
    
    
    private void results(int[] array, int item, 
                         boolean found, int index) {
        Text display = new Text();
        String text = "";
        text += "Array " + display.toString(array); 
        text += "\t search for " + item;
        text += "\t was "        + found;
        text += "\t at index "   + index;
        System.out.println(text);
    }

    private void results(int[] array, int[] sorted) {
        Text display = new Text();
        if (sorted == null) sorted = array;
        String text = "";
        text += "Original Array \t" + display.toString(array); 
        text += "\n";
        text += "Sorted Array   \t" + display.toString(sorted);
        System.out.println(text);
    }

}
