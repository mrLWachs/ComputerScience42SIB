
/** required package class namespace */
package searchsort;


/** required imports */
import collections.LinkedList;

/**
 * Sorter.java - useful methods for sorting arrays and LinkedLists
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
        for (int i = 0; i < array.length; i++) {            // traverse array
            for (int j = 0; j < array.length - 1; j++) {    // traverse again
                T item1 = array[j];
                T item2 = array[j+1];
                if (item1.compareTo(item2) > 0) {           // out of order
                    array[j]   = item2;                     // swap positions
                    array[j+1] = item1;
                }
            }
        }
    }    
    
    /**
     * An efficient implementation of a bubble sort algorithm
     * it will sort the list into ascending order
     * 
     * @param list the LinkedList to sort
     */
    public void bubble(LinkedList<T> list) {
        boolean sorted = true;                      // flag to stop or not
        for (int i = list.size()-1; i >= 0; i--) {  // traverse list
            sorted = true;                          // assume sorted
            for (int j = 0; j < i; j++) {           // traverse again
                T item1 = list.get(j);  
                T item2 = list.get(j+1);
                if (item1.compareTo(item2) > 0) {   // out of order
                    sorted = false;                 // flag no sorted
                    list.set(j, item2);             // swap positions
                    list.set(j+1, item1);
                } 
            }
            if (sorted) return;                     // return early
        }
    }
    
    /**
     * An implementation of a selection sort algorithm
     * it will sort the array into ascending order
     * 
     * @param array the array of generic items to sort
     */
    public void selection(T[] array) {
        for (int i = 0; i < array.length-1; i++) {          // traverse array
            int lowest = i;                                 // take low index
            for (int j = i+1; j < array.length; j++) {      // traverse again
                if (array[j].compareTo(array[lowest]) < 0) { // swap with low
                    lowest = j;
                }
            }
            if (lowest != i) {                              // perform swap
                T temp        = array[i];
                array[i]      = array[lowest];
                array[lowest] = temp;
            }
        }
    }
    
    /**
     * An implementation of a selection sort algorithm
     * it will sort the list into ascending order
     * 
     * @param list the LinkedList to sort
     */
    public void selection(LinkedList<T> list) {
        for (int i = 0; i < list.size()-1; i++) {       // traverse array
            int lowest = i;                             // take low index
            for (int j = i+1; j < list.size(); j++) {   // traverse again
                T item1 = list.get(j);
                T item2 = list.get(lowest);
                if (item1.compareTo(item2) < 0) {       // swap with low
                    lowest = j;
                }
            }
            if (lowest != i) {                          // perform swap
                T temp1 = list.get(i);
                T temp2 = list.get(lowest);
                list.set(i, temp2);
                list.set(lowest, temp1);
            }
        }
    }
    
}
