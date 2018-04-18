
/** required package class namespace */
package searchsort;

/** required imports */
import collections.LinkedList;

/**
 * Searcher.java - useful methods for searching through arrays and lists
 * of generic data for a specific item
 * 
 * @author Mr. Wachs
 * @param <T> the generic object used in this class
 * @since Feb 9, 2017
 * @instructor Mr. Wachs
 */
public class Searcher <T extends Comparable<T>>
{
    
    /** Indicates the item being searched for is not found */
    public final int NOT_FOUND = -1;
    
    /**
     * An implementation of a linear search (sequential search)
     * algorithm. It will find the first occurance of an item
     * in the LinkedList and return the index where it found it, or a 
     * -1 if not found
     * 
     * @param item the generic data type to search for in the list
     * @param list a LinkedList of generic items to search through
     * @return the first index found at, or a -1 if not found
     */
    public int linear(T item, LinkedList<T> list) {
        for (int i = 0; i < list.size(); i++) {
            if (item.equals(list.get(i))) {
                return i;
            }
        }
        return NOT_FOUND;
    }
    
    /**
     * An implementation of a linear search (sequential search)
     * algorithm. It will find the first occurance of an item
     * in the LinkedList and return the index where it found it, or a 
     * -1 if not found
     * 
     * @param item the generic data type to search for in the list
     * @param array an array of generic items to search through
     * @return the first index found at, or a -1 if not found
     */
    public int linear(T item, T[] array) {
        for (int i = 0; i < array.length; i++) {
            if (item.equals(array[i])) {
                return i;
            }
        }
        return NOT_FOUND;
    }
    
    /**
     * An implementation of a binary search (sequential search)
     * algorithm. It will find the first occurance of an item
     * in the LinkedList and return the index where it found it, or a 
     * -1 if not found
     * 
     * @param item the generic data type to search for in the list
     * @param array an array of generic items to search through
     * @return the first index found at, or a -1 if not found 
     */
    public int binary(T item, T[] array) {
        int high = array.length - 1;
        int low = 0;
        while (low <= high) {
            int mid = (high + low) / 2;
            if (array[mid].compareTo(item) == 0) return mid;
            else if (array[mid].compareTo(item) > 0) high = mid - 1;
            else if (array[mid].compareTo(item) < 0) low  = mid + 1;
        }
        return NOT_FOUND;
    }
    
    
    

}
