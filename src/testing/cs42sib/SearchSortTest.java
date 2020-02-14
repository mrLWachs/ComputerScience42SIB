
/** required package class namespace */
package testing.cs42sib;

/** required imports */
import collections.LinkedList;
import io.Simulator;
import tools.Numbers;
import tools.Search;
import tools.Sort;
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
        final int LARGEST  = MAX;                   // highest random value
        final int SMALLEST = -LARGEST;              // lowest random value
                        
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
            index = linearSearch(array,item);       // index search
            results(array,item,index);              // show results
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
            results(sorted,item,index);             // show results
        }
        
        Simulator.comment("Finally the simpliest search and sort...");
        Text text = new Text();
        found = search(array,randomItem);           // simple search
        sort(array);                                // simple sort
        System.out.println("Sorted array " + text.toString(array) + 
                           "\t search for " + randomItem +
                           "\t is " + found);
        
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
        for (int i = 0; i < array.length; i++) {
            if (item == array[i]) return true;
        }
        return false;
    }

    /**
     * A simple sort, it will sort the array into ascending order
     * 
     * @param array the array of items to sort 
     */
    public void sort(int[] array) {
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
     * An implementation of a linear search (sequential search) algorithm. It 
     * will find the first occurance of an item in the array and return the
     * index where it found it, or a -1 if not found
     * 
     * @param array an array to search through
     * @param item the item to search for
     * @return the first index found at, or a -1 if not found
     */
    private int linearSearch(int[] array, int item) {
        // catch a potential error before we begin
        if (array == null) return -1;
        // traverse through the array
        for (int i = 0; i < array.length; i++) {
            // if I encounter the item... 
            if (array[i] == item) {
                // return the spot I found it at
                return i;
            }
        }
        // made it through the entire list, never found it,
        // return a "flag" value indicating not found
        return -1;
    }

    
    /**
     * An implementation of a bubble sort algorithm it will sort the array into  
     * ascending order
     * 
     * @param array the array of items to sort
     */
    private int[] bubbleSort(int[] array) {
        // create a new array, same size as the passed array
        int[] sorted = new int[array.length];
        // make it a copy of the original
        System.arraycopy(array, 0, sorted, 0, array.length);        
        // we need to traverse the array as many times as there are items in
        // the array
        for (int times = 0; times < sorted.length; times++) {
            // traverse the entire array to the second last spot
            for (int i = 0; i < sorted.length - 1; i++) {
                // check each item and the item after it
                int item1 = sorted[i];
                int item2 = sorted[i + 1];
                if (item1 > item2) {
                    // swap them
                    sorted[i]     = item2;
                    sorted[i + 1] = item1;
                }
            }
        }
        return sorted;
    }
    
    
    
    
    
    
    
    
    
    
    
    /**
     * An implementation of a selection sort algorithm it will sort the array   
     * into ascending order
     * 
     * @param array the array of items to sort
     */
    private int[] selectionSort(int[] array) {
        return array;
    }

    
    
    
    
    
    /**
     * An implementation of a binary search algorithm. It will find the first 
     * occurance of an item in the array and return the index where it found 
     * it, or a -1 if not found
     * 
     * @param array an array to search through
     * @param item the item to search for
     * @return the first index found at, or a -1 if not found
     */
    private int binarySearch(int[] sorted, int item) {
        return -1;
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
        text += "\t search for " + item;
        text += "\t at index "   + index;
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
        if (sorted == null) sorted = array;
        String text = "";
        text += "Original Array \t" + display.toString(array); 
        text += "\n";
        text += "Sorted Array   \t" + display.toString(sorted);
        System.out.println(text);
    }

}
