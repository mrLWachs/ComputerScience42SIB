
/** required package class namespace */
package tools;

import collections.LinkedList;


/**
 * Sorter.java - 
 *
 * @author Mr. Wachs 
 * @since 7-Feb-2019 
 */
public class Sorter <T>
{

    
    public T[] bubbleSort(T[] array) {
        
        //    0     1     2     3     4     5     6
        // +-----+-----+-----+-----+-----+-----+-----+
        // |     |     |     |     |     |     |     |
        // +-----+-----+-----+-----+-----+-----+-----+
        //    P1    P2
        
        // position 1 starts at the begining of list
        // position 2 is the spot beside it
        
        // if position 1 is greater than position 2
            // swap two items (swap positions)
        
        // p1 and p2 advance...
        
        // p1 goes to the 2nd last spot in the list
        
        // we do this whole operation as many times as 
        // the list size (worst case scenario)
        
        return array;
    }   

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public LinkedList bubbleSort(LinkedList list) {
        return list;
    }   

    public Object[] selectionSort(Object[] array) {
        return array;
    }
    
    public LinkedList selectionSort(LinkedList list) {
        return list;
    }
    
}
