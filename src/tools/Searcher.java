
/** required package class namespace */
package tools;

import collections.LinkedList;


/**
 * Searcher.java - 
 *
 * @author Mr. Wachs 
 * @since 7-Feb-2019 
 */
public class Searcher <T>
{

    public static int NOT_FOUND = -1;
        
    public int linearSearch(T[] array, T item) {        
        for (int i = 0; i < array.length; i++) {            
            if (item.equals(array[i])) {
                return i;
            }            
        }
        return NOT_FOUND;
    }
    

    public int linearSearch(LinkedList list, T item) {
        // start at the beginning of the list
        // compare the list item with the item searching for
        // if it is, return that location
        // move to the next item in the list
        // if I go through the whole list
        // return flag value
        return linearRecursive(list, item, 0);
    }
    
    /**
     * Wrapper method
     * @return 
     */
    private int linearRecursive(LinkedList list, T item, int index) {
        // base case (stops recusrision)
        if (list.get(index).equals(item)) return index;
        if (index >= list.size()) return NOT_FOUND;
        // recusive case (like a loop)
        return linearRecursive(list, item, index + 1);
    }
    
    
    
    
    
    
    
    
    
    
    public int binarySearch(T[] array, T item) {
        return 0;
    }

    public int binarySearch(LinkedList list, T item) {
        return 0;
    }
    
}
