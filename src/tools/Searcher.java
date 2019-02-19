
/** required package class namespace */
package tools;

/** required imports */
import collections.LinkedList;

/**
 * Searcher.java - useful methods for searching through arrays and lists
 * of generic data for a specific item
 * 
 * @author Mr. Wachs 
 * @since 7-Feb-2019 
 */
public class Searcher <T extends Comparable <T>>
{

    /** Indicates the item being searched for is not found */
    public static int NOT_FOUND = -1;
        
    /**
     * An implementation of a linear search (sequential search)
     * algorithm. It will find the first occurance of an item
     * in the LinkedList and return the index where it found it, or a 
     * -1 if not found
     * 
     * Start at the beginning of the list, compare the list item with the 
     * item searching for, if it is, return that location, then move to the 
     * next item in the list, and if I go through the whole list, then 
     * return flag value (-1)
     * 
     * @param array an array of generic items to search through
     * @param item the generic data type to search for in the list
     * @return the first index found at, or a -1 if not found
     */
    public int linear(T[] array, T item) {        
        if (item == null || array == null) return NOT_FOUND;
        for (int i = 0; i < array.length; i++) {    // traverse entire list
            if (item.equals(array[i])) {            // found first occurance
                return i;                           // stop loop and return
            }
        }
        return NOT_FOUND;                           // not found
    }
    
    /**
     * An implementation of a linear search (sequential search)
     * algorithm. It will find the first occurance of an item
     * in the LinkedList and return the index where it found it, or a 
     * -1 if not found
     * 
     * @param item the generic data type to search for in the list
     * @param list the LinkedList to search through
     * @return the first index found at, or a -1 if not found
     */
    public int linear(LinkedList<T> list, T item) {
        if (item == null || list == null) return NOT_FOUND; // invalids
        return linearRecursive(list, item, 0);              // recursive call
    }
    
    /**
     * Recursive method to find the first occurance of an item
     * in the LinkedList and return the index where it found it, or a 
     * -1 if not found
     * 
     * @param list the LinkedList to search through
     * @param item the generic data type to search for in the list 
     * @param i the current index location
     * @return the first index found at, or a -1 if not found
     */
    private int linearRecursive(LinkedList list, T item, int index) {
        // base cases (stops recursion)
        if (index > list.size()-1)        return NOT_FOUND;
        if (list.get(index).equals(item)) return index;        
        // recusive case (like a loop), method calls itself
        return linearRecursive(list, item, index + 1);
    }
    
    /**
     * An implementation of a binary search algorithm. It will find the 
     * first occurance of an item in the LinkedList and return the index 
     * where it found it, or a -1 if not found
     * 
     * @param array an array of generic items to search through
     * @param item the generic data type to search for in the list
     * @return the first index found at, or a -1 if not found 
     */    
    public int binary(T[] array, T item) {
        if (item == null || array == null) return NOT_FOUND;        
        int high = array.length - 1;    // a "marker" for the high end        
        int low  = 0;                   // a marker for the low end        
        while (low <= high) {           // continue til markers collapse             
            int mid = (high + low) / 2; // calculate middle based on markers
            if      (array[mid].compareTo(item) == 0) return mid;
            else if (array[mid].compareTo(item) >  0) high = mid - 1;
            else if (array[mid].compareTo(item) <  0) low  = mid + 1;
        }        
        return NOT_FOUND;               // number wasn't found
    }

    /**
     * An implementation of a binary search algorithm. It will find the 
     * first occurance of an item in the LinkedList and return the index 
     * where it found it, or a -1 if not found
     * 
     * @param list the LinkedList to search through
     * @param item the generic data type to search for in the list
     * @return the first index found at, or a -1 if not found 
     */
    public int binary(LinkedList<T> list, T item) {
        if (item == null || list == null) return NOT_FOUND;   
        return recursiveBinary(list,item,0,list.size());
    }

    /**
     * Recursive binary search algorithm used to find the item in the list and 
     * return the index of it's location or a -1 if not found
     * 
     * @param list the LinkedList to search through
     * @param item the generic data type to search for in the list
     * @param low the lowest index to start from
     * @param high the highest index to go to
     * @return the first index found at, or a -1 if not found 
     */
    private int recursiveBinary(LinkedList<T> list, T item, int low, int high) { 
        if (low <= high) {                      // while markers not collapsed
            int mid = low + (high - low) / 2;   // calculate middle point 
            if (list.get(mid) == null) return NOT_FOUND;
            if (list.get(mid).compareTo(item) >  0)
                return recursiveBinary(list,item,low,mid-1);
            else if (list.get(mid).compareTo(item) <  0)
                return recursiveBinary(list,item,mid+1,high);
            else 
                return mid;
        }
        return NOT_FOUND;                       // not found
    }
    
}
