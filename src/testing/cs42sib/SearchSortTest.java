
/** Required package class namespace */
package testing.cs42sib;

/** Required imports */
import io.Simulator;
import tools.Numbers;
import tools.Text;

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
        // For displaying arrays as text
        Text text = new Text();
        
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
        
        System.out.println("array = " + text.toString(array));
        
        // Loop through our test data
        for (int item : findItems) {
            System.out.print("Searching for item: " + item);
            found = search(array,item);
            System.out.println(" result was " + found);
            
        }
        
        
        
        
        
        
        
        
        
        
        
        
        
        
            
                        
        Simulator.header("Searching and Sorting Test completed!");
    }   

    /**
     * A simple search, determines if the the item is in the array or not
     * 
     * @param array the array to search through
     * @param item the item to search for
     * @return found (true) or not (false)
     */
    private boolean search(int[] array, int item) {
        // Travese (travel through) every index inthe array
        for (int i = 0; i < array.length; i++) {
            // Check if this index value matches the item
            if (array[i] == item) {
                // End the method here
                return true;
            }
        }
        // Traversed the entire array without finding it
        return false;
    }
    
    /**
     * An implementation of a linear search (sequential search) algorithm. It 
     * will find the first occurance of an item in the array and return the
     * index where it found it, or a -1 if not found
     * 
     * @param array an array to search through
     * @param item the item to search for
     * @return the first index found at, or a -1 if not found
     */
    private int linearSearch(int[] array, int item) {
        // Catch a potential error before we begin
        if (array == null) return -1;
        // Traverse the array
        for (int i = 0; i < array.length; i++) {
            // Check if this index value matches the item
            if (array[i] == item) {
                // Return the spot I found it at (and stop loop and method)
                return i;
            }
        }
        // Make it through the entire list, never find it, return
        // a "flag" value indicating not found
        return -1;
    }
    
}
