
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
        
        // For the I.B. Exam, you only need to know:
        // Search: linear (sequential) search, and binary search
        // Sort: bubble sort and the selection sort
        
        // Create some constants for the data
        
        final int MIN      = 0;
        final int MAX      = 10;
        final int LARGEST  = MAX;
        final int SMALLEST = MIN;
        
        Numbers numbers = new Numbers();
        
        // Create some random data to search through and sort
        // Including all "edge" cases to test for (using unit testing)
        
        int[] array    = numbers.random(SMALLEST, LARGEST, MAX);
        int randomItem = numbers.random(SMALLEST, LARGEST);
        int itemInList = array[numbers.random(MIN+1, MAX-2)];
        int firstItem  = array[0];
        int lastItem   = array[MAX-1];
        int notInList  = LARGEST + 1;
        
        int[] findItems = {
            randomItem,
            itemInList,
            firstItem,
            lastItem,
            notInList
        };
        
        // Create data to store the results...
        
        boolean found  = false;
        int     index  = -1;
        int[]   sorted = new int[MAX];
        
        
        results(array, randomItem, index);
        results(array, sorted);
        
        
        
        
                
        Simulator.header("Searching and Sorting Test completed!");
    }   
    
    
    /**
     * Displays the results of a search
     * 
     * @param array the array to search through
     * @param item the item to search for
     * @param index which array index it was found at (or -1 if not found)
     */
    private void results(int[] array, int item, int index) {
        Text display = new Text();
        String text = "";
        text += "Array ";
        text += display.toString(array);
        text += "\t searching for " + item;
        text += "\t at index " + index;
        System.out.println(text);
    }

    /**
     * Displays the results of a sort
     * 
     * @param array the original array
     * @param sorted the sorted array
     */
    private void results(int[] array, int[] sorted) {
        Text display = new Text();
        String text = "";
        text += "Original Array \t";
        text += display.toString(array);
        text += "\n";
        text += "Sorted Array \t";
        text += display.toString(sorted);
        System.out.println(text);
    }
    
}
