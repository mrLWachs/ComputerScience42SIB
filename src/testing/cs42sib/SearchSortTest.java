
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
        
        Simulator.comment("Use classes with search/sort generic methods...");
        
        Simulator.comment("Create the objects to use");
        
        Text   text   = new Text();
        Search search = new Search();
        Sort   sort   = new Sort();
        
        Simulator.comment("Create random LinkedList data...");
        Simulator.comment("Including all edge cases to test for");
        
        LinkedList<String> unsortedWords = text.randomList(MAX);
        LinkedList<String> sortedWords   = new LinkedList<>();
        
        String randomWord = text.randomWord();
        String inListWord = unsortedWords.get(numbers.random(MIN+1,MAX-2));
        String firstWord  = unsortedWords.front();
        String lastWord   = unsortedWords.back();
        String notWord    = "Wachs";
        
        LinkedList<String> testCases = new LinkedList<>();
        testCases.add(randomWord);
        testCases.add(inListWord);        
        testCases.add(firstWord);
        testCases.add(lastWord);
        testCases.add(notWord);
        
        Simulator.comment("Execute all the searches on all test data...");
        
        for (int i = 0; i < testCases.size(); i++) {
            String word = testCases.get(i);
            index = search.linear(word, unsortedWords);
            System.out.println("Linear: \t" + unsortedWords.toString() + 
                    " -> \t" + word + " -> \t" + index);
            index = search.binary(word, unsortedWords);
            System.out.println("Binary: \t" + unsortedWords.toString() + 
                    " -> \t" + word + " -> \t" + index);
        }
        
        Simulator.comment("Execute all the sorts on all test data...");
        
        Simulator.comment("Bubble sort LinkedList data...");
        
        sortedWords = unsortedWords.clone();
        sort.bubble(sortedWords);
        System.out.println("Before: \t" + unsortedWords.toString());
        System.out.println("After:  \t" + sortedWords.toString());
        
        Simulator.comment("Selection sort LinkedList data...");
        
        sortedWords = unsortedWords.clone();
        sort.selection(sortedWords);
        System.out.println("Before: \t" + unsortedWords.toString());
        System.out.println("After:  \t" + sortedWords.toString());
        
        Simulator.comment("Shell sort LinkedList data...");
        
        sortedWords = unsortedWords.clone();
        sort.shell(sortedWords);
        System.out.println("Before: \t" + unsortedWords.toString());
        System.out.println("After:  \t" + sortedWords.toString());
        
        Simulator.comment("Insertion sort LinkedList data...");
        
        sortedWords = unsortedWords.clone();
        sort.insertion(sortedWords);
        System.out.println("Before: \t" + unsortedWords.toString());
        System.out.println("After:  \t" + sortedWords.toString());
        
        Simulator.comment("Quick sort LinkedList data...");
        
        sortedWords = unsortedWords.clone();
        sort.quick(sortedWords);
        System.out.println("Before: \t" + unsortedWords.toString());
        System.out.println("After:  \t" + sortedWords.toString());
                
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
        return -1;
    }

    
    /**
     * An implementation of a bubble sort algorithm it will sort the array into  
     * ascending order
     * 
     * @param array the array of items to sort
     */
    private int[] bubbleSort(int[] array) {
        return array;
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
     * @param found whether it was found or not
     * @param index which array index it was found at (or -1 if not found)
     */
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
