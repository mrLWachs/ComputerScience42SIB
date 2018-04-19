
/** required package class namespace */
package searchsort;

/**
 * Sorter.java - description here...
 *
 * @author Mr. Wachs (login: lawrence.wachs)
 * @since Apr 19, 2018 
 * @instructor Mr. Wachs
 */
public class Sorter <T extends Comparable<T>>
{
    
    public void bubble(T[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length-1; j++) {
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
