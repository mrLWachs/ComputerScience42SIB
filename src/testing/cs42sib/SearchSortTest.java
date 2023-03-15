
/** Required package class namespace */
package testing.cs42sib;

/** Required imports */
import io.Simulator;
import tools.Numbers;
import tools.Results;


/**
 * SearchSortTest.java - tests the concepts learned in this unit
 *
 * @author Mr. Wachs
 * @since Feb. 9, 2022, 8:01:03 a.m.
 */
public class SearchSortTest 
{

    /**
     * Default constructor, set class properties
     */
    public SearchSortTest() {
        Simulator.header("Searching and Sorting Test started...");
                
        // For the I.B. Exam, you only need to know.............................
        Simulator.comment("For the I.B. Exam, you only need to know:");
        // Search: linear (sequential) search and binary search.................
        Simulator.comment("Search: linear search and binary search");
        // Sort: bubble sort and the selection sort.............................
        Simulator.comment("Sort: bubble sort and the selection sort");
        
        // Create some constants (edges) for the data...........................
        Simulator.comment("Create some constants (edges) for the data");
        
        final int MIN      = 0;
        final int MAX      = 10;
        final int LARGEST  = MAX;
        final int SMALLEST = MIN;
        
        Numbers numbers = new Numbers();
        
        // Create some random data to search through and sort...................
        Simulator.comment("Create some random data to search through and sort");
        // Including all "edge" cases to test for (using unit testing)..........
        Simulator.comment("Including edge cases to test");
        
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
                
        // Create data to store the results.....................................
        Simulator.comment("Create data to store the results...");
        
        boolean found  = false;
        int     index  = -1;
        int[]   sorted = new int[MAX];
        
        // The simpliest of searches............................................
        Simulator.comment("The simpliest of searches");
        
        found = search(array, randomItem);
        
        Results.show(array, randomItem, found);
        
        
        
        
        
        
                   
        Simulator.header("Searching and Sorting Test completed!");
    }   

    /**
     * A simple search, determines if the item is in the array or not
     * 
     * @param array an array to search through
     * @param item the item to search for
     * @return found (true) or not (false)
     */
    private boolean search(int[] array, int item) {
        for (int i = 0; i < array.length; i++) {    // Traverse array
            if (array[i] == item) {                 // Check for item
                return true;                        // Item found (leave method)
            }
        }
        return false;                               // Not found
    }
    
    
}