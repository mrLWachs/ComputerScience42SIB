
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
        int[]   array   = numbers.random(-100, 100, 30);
        
        
        System.out.println(text.toString(array));
        
        
        Simulator.header("Searching and Sorting Test completed!");
    }   

}
