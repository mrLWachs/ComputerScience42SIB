
/** required package class namespace */
package searchsort;


/** required imports */
import collections.LinkedList;

/**
 * Sorter.java - useful methods for sorting arrays and 
 * 
 * @author Mr. Wachs
 * @param <T> the generic object used in this class
 * @since Feb 9, 2017
 * @instructor Mr. Wachs
 */
public class Sorter <T extends Comparable<T>> 
{
       
    /**
     * A simple implementation of a bubble sort algorithm
     * it will sort the array into ascending order
     * 
     * @param array the array of generic items to sort
     */
    public void bubble(T[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                T item1 = array[j];
                T item2 = array[j+1];
                if (item1.compareTo(item2) > 0) {
                    array[j]   = item2;
                    array[j+1] = item1;
                }
            }
        }
    }    
    
}
