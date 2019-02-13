
/** required package class namespace */
package tools;

/** required imports */
import collections.LinkedList;


/**
 * Sorter.java - useful methods for sorting arrays and LinkedLists
 * of generic data into ascending order
 *
 * @author Mr. Wachs 
 * @since 7-Feb-2019 
 */
public class Sorter <T extends Comparable <T>>
{
    
    /**
     * A simple implementation of a bubble sort algorithm it will sort the 
     * array into ascending order:
     *    0     1     2     3     4     5     6
     * +-----+-----+-----+-----+-----+-----+-----+ 
     * |     |     |     |     |     |     |     |
     * +-----+-----+-----+-----+-----+-----+-----+
     *    P1    P2
     * position 1 starts at the beginning of list
     * position 2 is the spot beside it
     * if position 1 is greater than position 2
     *    swap two items (swap positions)
     * p1 and p2 advance...
     * p1 goes to the 2nd last spot in the list, and we do this whole 
     * operation as many times as the list size (worst case scenario)
     * 
     * @param array the array of generic items to sort
     */
    public void bubbleSort(T[] array) {
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
    public void bubbleSort(LinkedList<T> list) {
        // TO DO !!!!
    }  
    

    public void selectionSort(T[] array) {
        // TO DO !!!!
    }
    
    public void selectionSort(LinkedList<T> list) {
        // TO DO !!!!
    }        

}
