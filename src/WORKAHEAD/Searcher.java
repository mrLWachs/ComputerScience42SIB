
/** required package class namespace */
package WORKAHEAD;

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
     * @param array an array of generic items to search through
     * @return the first index found at, or a -1 if not found
     */
    public int linearSearch(T item, T[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].compareTo(item) == 0) {
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
     * @param list the LinkedList to search through
     * @return the first index found at, or a -1 if not found
     */
    public int linearSearch(T item, LinkedList list) {
        return recursiveLinearSearch(item, list, 0);
    }
    
    /**
     * Recursive method to find the first occurance of an item
     * in the LinkedList and return the index where it found it, or a 
     * -1 if not found
     * 
     * @param item the generic data type to search for in the list
     * @param list the LinkedList to search through
     * @param i the current index location
     * @return the first index found at, or a -1 if not found
     */
    private int recursiveLinearSearch(T item, 
            LinkedList<T> list, int i) {
        if      (i == list.size())                 return NOT_FOUND;
        else if (item.compareTo(list.get(i)) == 0) return i;
        else return recursiveLinearSearch(item,list,i+1);
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
    public int binarySearch(T item, T[] array) {
        int high = array.length - 1;
        int low  = 0;
        while (low <= high) {
            int mid = (high + low) / 2;
            if      (array[mid].compareTo(item) == 0) return mid;
            else if (array[mid].compareTo(item) >  0) high = mid - 1;
            else if (array[mid].compareTo(item) <  0) low  = mid + 1;
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
     * @param list the LinkedList to search through
     * @return the first index found at, or a -1 if not found 
     */
    public int binarySearch(T item, LinkedList<T> list) {
        return recursiveBinarySearch(item,list,0,list.size());
    }
    
    /**
     * Recursive method used to find the item in the list and 
     * return the index of it's location or a -1 if not found
     * 
     * @param item the generic data type to search for in the list
     * @param list the LinkedList to search through
     * @param low the lowest index to start from
     * @param high the highest index to go to
     * @return the first index found at, or a -1 if not found 
     */
    private int recursiveBinarySearch(T item, LinkedList<T> list, 
            int low, int high) {
        if (low <= high) {
            int mid = low + (high - low) / 2;
            if (list.get(mid) == null) return NOT_FOUND;
            if (list.get(mid).compareTo(item) >  0)
                return recursiveBinarySearch(item,list,low,mid-1);
            else if (list.get(mid).compareTo(item) <  0)
                return recursiveBinarySearch(item,list,mid+1,high);
            else 
                return mid;
        }
        return NOT_FOUND;
    }
    
}
