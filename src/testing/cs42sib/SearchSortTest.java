
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
        Simulator.comment("For the I.B. Exam, you only need to know:");
        // Search: linear (sequential) search and binary search
        Simulator.comment("Search: linear search and binary search");
        // Sort: bubble sort and the selection sort
        Simulator.comment("Sort: bubble sort and the selection sort");
        
        // Create some constants for the data
        Simulator.comment("Create some constants for the data");
        
        final int MIN      = 0;
        final int MAX      = 10;
        final int LARGEST  = MAX;
        final int SMALLEST = MIN;
        
        Numbers numbers = new Numbers();
        
        // Create some random data to search through and sort
        Simulator.comment("Create some random data to search through and sort");
        // Including all "edge" cases to test for (using unit testing)
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
        
        // Create data to store the results...
        Simulator.comment("Create data to store the results...");
        
        boolean found  = false;
        int     index  = -1;
        int[]   sorted = new int[MAX];
        
        // The simpliest of searches
        Simulator.comment("The simpliest of searches");
        
        found = search(array,randomItem);
                
        // Now the linear (sequential) search on all test data
        Simulator.comment("Now the linear search on all test data");
        
        for (int i = 0; i < findItems.length; i++) {
            index = linearSearch(array,findItems[i]);        
            results(array, findItems[i], index);
        }
        
        // Simple sort...  
        Simulator.comment("Simple sort...");
        //sort(array);
        
        // Now execute the bubble sort (named after bubbles rising from water)
        Simulator.comment("Now bubble sort (from bubbles rising from water)");
        
        sorted = bubbleSort(array);
        
                        
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
        text += "Array " + display.toString(array);
        text += "\n\tSearching for:\t " + item;
        text += "\n\tLocation index:\t " + index;
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
        text += "Original Array \t" + display.toString(array);
        text += "\nSorted Array \t"   + display.toString(sorted);
        System.out.println(text);
    }

    /**
     * A simple search, determines if the item is in the array or not
     * 
     * @param array an array to search through
     * @param item the item to search for
     * @return found (true) or not (false)
     */
    private boolean search(int[] array, int item) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == item) {
                return true;
            }
        }
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
        for (int i = 0; i < array.length; i++) {            
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j+1]) {
                    int temp   = array[j];
                    array[j]   = array[j+1];
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
        return null;
    }
    
}
