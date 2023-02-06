
/** Required package class namespace */
package testing.cs42sib;

/** Required imports */
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
        // For displaying arrays as text.......................................
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
        
        // SEARCH 1 - The "linear" search......................................      
        System.out.println("Array = " + text.toString(array));
        
        // Loop through our test data..........................................
        for (int item : findItems) {
            System.out.print("Linear Search for item: \t" + item);
            found = search(array,item);
            System.out.print("\t result was " + found);
            index = linearSearch(array, item);
            System.out.println("\t at " + index);
        }
        
        // SORT 1 - The "Bubble" sort..........................................
        System.out.println("Before sort = \t" + text.toString(array));        
        sorted = sort(array);
        System.out.println("After sort = \t" + text.toString(sorted));
        
        array = numbers.random(SMALLEST, LARGEST, MAX);
        System.out.println("Before Bubble sort = \t" + text.toString(array));        
        sorted = bubbleSort(array);
        System.out.println("After Bubble sort = \t" + text.toString(sorted));
        
        // SORT 2 - The "Selection" sort.......................................
        array = numbers.random(SMALLEST, LARGEST, MAX);
        System.out.println("Before Selection sort = \t" + text.toString(array));        
        sorted = selectionSort(array);
        System.out.println("After Selection sort = \t" + text.toString(sorted));
        
        // SORT 2 - The "Selection" sort.......................................
        array = numbers.random(SMALLEST, LARGEST, MAX);
        System.out.println("Before Selection sort = \t" + text.toString(array));        
        sorted = selectionSort(array);
        System.out.println("After Selection sort = \t" + text.toString(sorted));
        
        // SEARCH 2 - The "Binary" search......................................      
        System.out.println("Array = " + text.toString(sorted));
        
        // Redo some of the test data..........................................        
        findItems[1] = sorted[numbers.random(MIN+1, MAX-2)];
        findItems[2] = sorted[0];
        findItems[3] = sorted[MAX-1];
        
        // Loop through our test data..........................................
        for (int item : findItems) {
            index = binarySearch(sorted, item);
            System.out.println("Binary search result for item " + item +
                    "\t result was at index \t" + index);
        }
        
        // Now using the "Search" and "Sort" classes which are in the "tools"
        // package. They have methods that can work on "anything" as they
        // use the generic data type. They also work on Linked List objects
        // as well as arrays. The Search class also includes some other search
        // algorithms not needed (but might come up in your futures)
        
        Search search = new Search();
        Sort   sort   = new Sort();
        
        // Create random linked list data (include all edge cases to test).....        
        LinkedList<String> unsortedWords = text.randomList(MAX, 5);
        LinkedList<String> sortedWords   = new LinkedList<>();
        
        // Place all test cases into another linked list.......................
        LinkedList<String> testCases = new LinkedList<>();
        
        // Generate testing data for the list..................................
        String randomWord = text.randomWord();
        String inListWord = unsortedWords.get(numbers.random(MIN+1, MAX-2));
        String firstWord  = unsortedWords.front();
        String lastWord   = unsortedWords.back();
        String notWord    = "Wachs";
                
        // Add the test data to the test data list.............................
        testCases.add(randomWord);
        testCases.add(inListWord);
        testCases.add(firstWord);
        testCases.add(lastWord);
        testCases.add(notWord);
        
        // Execute the linear search on all test data..........................        
        for (int i = 0; i < testCases.size(); i++) {
            String word = testCases.get(i);
            index = search.linear(word, unsortedWords);
            System.out.println("Linear search: \t" + unsortedWords.toString() +
                               "\t for word: "     + word + " at index: " + 
                               index);
        }
        
        // Execute all the sorts on all test data..............................
        
        // Bubble sort LinkedList data.........................................
        sortedWords = unsortedWords.clone();
        sort.bubble(sortedWords);
        System.out.println("Bubble sort Before: \t" + unsortedWords.toString());
        System.out.println("Bubble sort After:  \t" + sortedWords.toString());
                                
        // Selection sort LinkedList data......................................    
        sortedWords = unsortedWords.clone();
        sort.selection(sortedWords);
        System.out.println("Selection sort Before: \t" + unsortedWords.toString());
        System.out.println("Selection sort After:  \t" + sortedWords.toString());
        
        // Even more sorts (beyond I.B. curriculum)............................
        Simulator.header("Even more sorts (beyond I.B. curriculum)...");
        
        // Shell sort array data...............................................        
        Integer[] unsortedArray = numbers.randomClass(SMALLEST, LARGEST, MAX);
        Integer[] sortedArray   = numbers.arrayClone(unsortedArray);
        System.out.println("Shell sort before: \t" + text.toString(unsortedArray));        
        sort.shell(sortedArray);
        System.out.println("Shell sort after: \t" + text.toString(sortedArray));
        
        // Insertion sort array data...........................................
        sortedArray = numbers.arrayClone(unsortedArray);
        System.out.println("Insertion sort before: \t" + text.toString(unsortedArray));        
        sort.insertion(sortedArray);
        System.out.println("Insertion sort after: \t" + text.toString(sortedArray));
        
        // Quick sort array data...............................................
        sortedArray = numbers.arrayClone(unsortedArray);
        System.out.println("Quick sort before: \t" + text.toString(unsortedArray));        
        sort.quick(sortedArray);
        System.out.println("Quick sort after: \t" + text.toString(sortedArray));
        
        // Merge sort array data...............................................
        sortedArray = numbers.arrayClone(unsortedArray);
        System.out.println("Merge sort before: \t" + text.toString(unsortedArray));        
        sortedArray = (Integer[]) sort.merge(sortedArray);
        System.out.println("Merge sort after: \t" + text.toString(sortedArray));
        
        // Heap sort array data...............................................
        sortedArray = numbers.arrayClone(unsortedArray);
        System.out.println("Heap sort before: \t" + text.toString(unsortedArray));        
        sortedArray = (Integer[]) sort.heap(sortedArray);
        System.out.println("Heap sort after: \t" + text.toString(sortedArray));
        
        
        // Shell sort LinkedList data..........................................     
        sortedWords = unsortedWords.clone();
        sort.shell(sortedWords);
        System.out.println("Shell sort Before: \t" + unsortedWords.toString());
        System.out.println("Shell sort After:  \t" + sortedWords.toString());
        
        // Insertion sort LinkedList data......................................       
        sortedWords = unsortedWords.clone();
        sort.insertion(sortedWords);
        System.out.println("Insertion sort Before: \t" + unsortedWords.toString());
        System.out.println("Insertion sort After:  \t" + sortedWords.toString());
        
        // Quick sort LinkedList data..........................................       
        sortedWords = unsortedWords.clone();
        sort.quick(sortedWords);
        System.out.println("Quick sort Before: \t" + unsortedWords.toString());
        System.out.println("Quick sort After:  \t" + sortedWords.toString());
                
        // Merge sort LinkedList data..........................................        
        sortedWords = unsortedWords.clone();
        sort.merge(sortedWords);
        System.out.println("Merge sort Before: \t" + unsortedWords.toString());
        System.out.println("Merge sort After:  \t" + sortedWords.toString());
        
        // Heap sort LinkedList data...........................................        
        sortedWords = unsortedWords.clone();
        sort.heap(sortedWords);
        System.out.println("Heap sort Before: \t" + unsortedWords.toString());
        System.out.println("**** Heap sort After:  \t" + sortedWords.toString());
                
        // Even more searches (beyond I.B. curriculum).........................
        Simulator.header("Even more searches (beyond I.B. curriculum)...");
        
        // Execute the binary search on all test data..........................        
        for (int i = 0; i < testCases.size(); i++) {
            String word = testCases.get(i);
            index = search.binary(word, sortedWords);
            System.out.println("Binary search: \t" + sortedWords.toString() + 
                               "\t for word: "     + word + " at index: " + 
                               index);
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

    /**
     * A simple sort (actually the "bubble sort") will sort the array into
     * ascending order
     * 
     * @param array the array of items to sort
     * @return another array of sorted items
     */
    private int[] sort(int[] array) {
        // Copying the original into a duplicate, then sort and return
        // the duplicate (that way the original stays intact)
        int[] a = array.clone();
        // Traverse the array for the worse case scenario
        for (int i = 0; i < a.length; i++) {
            // Traverse the array (to the second last index) and make swaps 
            // as needed
            for (int j = 0; j < a.length - 1; j++) {
               // Check if we need need to swap (is the item at this spot, 
               // greater than the item at the next spot)
               if (a[j] > a[j+1]) {
                    // Swap them (by making a temporary variable)
                    int swap = a[j];
                    a[j]     = a[j+1];
                    a[j+1]   = swap;
               }               
            }
        }
        // Send back duplicate (which is now a sorted version of the original)
        return a;
    }
    
    
    /**
     * An implementation of a bubble sort algorithm it will sort the array into  
     * ascending order
     * 
     * @param array the array of items to sort
     */
    private int[] bubbleSort(int[] array) {
        // Create a new array, same size as the passed array, a copy
        int[] sorted = array.clone();   
        // Create a "flag" to indicate if no swaps occured therefore I can stop
        boolean done = false;
        // Sort the copy, using the bubblesort algorithm...        
        // We need to traverse the array aas many times as there are items in
        // that array (n items, for example array size 10, n =10)   
        // in reverse order (travel backwards)
        for (int times = sorted.length -1; times >= 0; times--) {
            // Set the flag to sorted (assume the array is sorted)
            done = true;
            // Nested for loop, to traverse the entire array up to the current 
            // spot I am travelling to in the outer loop
            for (int i = 0; i < times; i++) {
                // Check  each item and the item after it
                int item1 = sorted[i];
                int item2 = sorted[i+1];
                // Now check
                if (item1 > item2) {
                    // Swap them
                    sorted[i]   = item2;
                    sorted[i+1] = item1;
                    // Set my flag (it was not sorted)
                    done = false;
                }                                
            }
            // Now check if no swaps occured
            if (done) return sorted;
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
        // Create a new array, same size as the passed array, a copy
        int[] sorted = array.clone();        
        // Sort that array using the selection sort algorithm...
        // Traverse the entire array
        for (int i = 0; i < sorted.length; i++) {
            // Track the lowest index, assume it's the first spot
            int lowest = i;
            // Nested inner for loop, starts at one over from current position
            // of the outer for loop used to find the lowest spot
            for (int j = i+1; j < sorted.length; j++) {
                int item1 = sorted[j];
                int item2 = sorted[lowest];
                // check the spots
                if (item1 < item2) {
                    // found a new low
                    lowest = j;
                }
            }
            // Outside the inner loop, now that we have the lowest spot, swap
            // the content of the lowest spot with the current spot i
            if (lowest != i) {
                int temp       = sorted[i];
                sorted[i]      = sorted[lowest];
                sorted[lowest] = temp;
            }
        }
        return sorted;
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
    private int binarySearch(int[] array, int item) {
        // Track the low and high indices of the array with "markers"
        int high = array.length - 1;
        int low  = 0;        
        // Loop while the markers are not collapsed on themselves
        while (low <= high) {         
            // find (calculate) the middle between low and high
            int mid = (high + low) / 2;            
            // check if found
            if (array[mid] == item) return mid;            
            // check if the spot I'm at is bigger than item
            else if (array[mid] > item) high = mid - 1;            
            // check if the spot I'm at is smaller than item
            else if (array[mid] < item) low = mid + 1;            
        }        
        return -1;  // not found!        
    } 
    
}
