
/** Required package class namespace */
package testing.cs42sib;

/** Required imports */
import io.Simulator;
import tools.Numbers;

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
                
        // For the I.B. exam, we do NOT need to know the code, but we need to
        // know how the search and sort algorithms work (in theory) and we 
        // only need to know two sort and two search algorithms:
            // SEARCH: linear search, binary search
            // SORT:   bubble sort, selection sort
            
        // Setup some data to use in all the search/sort code..................
        
        // For creating random numbers, arrays and LinkedLists.................
        Numbers numbers = new Numbers();
        
        // Some constants for defining the "edges".............................
        final int MIN      = 0;
        final int MAX      = 10;
        final int LARGEST  = MAX;
        final int SMALLEST = MIN;
        
        // Create some random data to search for and sort (including all "edge"
        // cases to test for (using unit testing)..............................
        
        int[] array      = numbers.random(SMALLEST, LARGEST, MAX);
        int   randomItem = numbers.random(SMALLEST, LARGEST);
        int   itemInList = array[numbers.random(MIN+1, MAX-2)];
        int   firstItem  = array[0];
        int   lastItem   = array[MAX-1];
        int   notInList  = LARGEST + 1;
        
        // Place all of this test data into an array...........................
        int[] findItems = {
            randomItem,
            itemInList,
            firstItem,
            lastItem,
            notInList
        };
        
        // Create some data to store the results...............................
        boolean found  = false;
        int     index  = -1;
        int[]   sorted = new int[MAX];
        
        // SEARCH 1 - The "linear" search: 
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
            
                        
        Simulator.header("Searching and Sorting Test completed!");
    }   
    
}
