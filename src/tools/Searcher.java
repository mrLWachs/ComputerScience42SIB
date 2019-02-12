
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
        for (int i = 0; i < list.size(); i++) {            
            if (item.equals(list.get(i))) {
                return i;
            }            
        }
        return NOT_FOUND;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    public int binarySearch(T[] array, T item) {
        return 0;
    }

    public int binarySearch(LinkedList list, T item) {
        return 0;
    }
    
}
