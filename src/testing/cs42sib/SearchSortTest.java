
/** required package class namespace */
package testing.cs42sib;

/** required imports */
import io.Simulator;
import tools.Numbers;
import tools.Text;


/**
 * SearchSortTest.java - tests the concepts learned in this unit
 *
 * @author Mr. Wachs
 * @since Jan. 14, 2020, 8:01:03 a.m.
 */
public class SearchSortTest 
{

    /**
     * Default constructor, set class properties
     */
    public SearchSortTest() {
        Simulator.header("Searching and Sorting Test started...");
        
        Simulator.comment("For the I.B. exam, only need to know...");
        Simulator.comment("Linear search and binary search");
        Simulator.comment("Bubble sort and Selection sort");
                
        Simulator.comment("Create random data to search and sort");
        
        Numbers numbers = new Numbers();
        Text    text    = new Text();
        
        final int MIN  = 0;
        final int MAX  = 30;
        int[]   array  = numbers.random(-100, 100, MAX);
        
        int randomItem = numbers.random(-100, 100);
        int itemInList = array[numbers.random(MIN+1,MAX-2)];
        int firstItem  = array[0];
        int lastItem   = array[MAX-1];
        int notInList  = Integer.MAX_VALUE;
        
        int[] findItems = {
            randomItem,
            itemInList,
            firstItem,
            lastItem,
            notInList
        };
        
        boolean found  = false;
        int     index  = -1;
        int[]   sorted = new int[MAX];
        
        for (int i = 0; i < findItems.length; i++) {
            int item = findItems[i];
            found = search(array,item);
            index = linearSearch(array,item);
            results(array,item,found,index);
        }
        
        sorted = bubbleSort(array);
        results(array,sorted);
        
        
        Simulator.header("Searching and Sorting Test completed!");
    }   

}
