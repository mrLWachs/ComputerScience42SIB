
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
        
        // Now the linear (sequential) search on all test data..................
        Simulator.comment("Now the linear search on all test data");
        
        for (int i = 0; i < findItems.length; i++) {
            index = linearSearch(array, findItems[i]);
            Results.show(array, findItems[i], index);
        }
        
        // Simple sort.........................................................
        Simulator.comment("Simple sort...");
        
        sort(array);
        Results.show(array);
        
        // We need to "re-scramble" the array for further testing..............
        Simulator.comment("We will re-scramble array for further testing");
        
        array = numbers.random(SMALLEST, LARGEST, MAX);
        Results.show(array);
        
        // Now execute the bubble sort (named after bubbles rising from water)..
        Simulator.comment("Now bubble sort (from bubbles rising from water)");
        
        sorted = bubbleSort(array);
        Results.show(array, sorted);
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
                   
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
            // If I encounter the item
            if (array[i] == item) {
                // Return the spot I found it at (and stop)
                return i;
            }
        }
        // Make it through the entire list, never find it, return
        // a "flag" value indicating not found
        return -1;
    }

    /**
     * A simple sort, it will sort the array into ascending order
     * 
     * @param array the array of items to sort 
     */
    private void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {         // Traversing the array
            for (int j = 0; j < array.length - 1; j++) { // Traverse 1 less 
                if (array[j] > array[j+1]) {             // Checking items
                    int temp   = array[j];               // Temporary variable
                    array[j]   = array[j+1];             // Swapping items
                    array[j+1] = temp;
                }
            }
        }
    }
    
    /**
     * An implementation of a bubble sort algorithm it will sort the array into  
     * ascending order
     * 
     * @param array the array of items to sort
     */
    private int[] bubbleSort(int[] array) {
        // Create a new array, same size as the passed array
        int[] sorted = new int[array.length];
        // Make it a copy of that original
        System.arraycopy(array, 0, sorted, 0, array.length);        
        // Sort the copy, using the bubblesort algorithm...        
        // We need to traverse the array aas many times as there are items in
        // that array (n items, for example array size 10, n =10)        
        for (int times = 0; times < sorted.length; times++) {
            // Nested for loop, to traverse the entire array up to the
            // second last spot
            for (int i = 0; i < sorted.length - 1; i++) {
                // Check  each item and the item after it
                int item1 = sorted[i];
                int item2 = sorted[i+1];
                // Now check
                if (item1 > item2) {
                    // Swap them
                    sorted[i]   = item2;
                    sorted[i+1] = item1;
                }                                
            }
        }
        return sorted;
    }
    
    
}