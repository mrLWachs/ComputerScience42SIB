/** required package class namespace */
package testing;

import io.Output;
import testing.advancedclasses.AdvancedClassesTest;
import testing.collections.CollectionsTest;
import testing.permanentstorage.PermanentStorageTest;
import testing.searchsort.SearchSortTest;
import testing.stacksqueues.StacksQueuesTest;


/**
 * Tester.java - the unit testing class that drives the various unit tests
 *
 * @author Mr. Wachs 
 * @since 24-Sep-2018 
 */
public class Tester 
{

    /**
     * Default class constructor, runs on instantiation
     */
    public Tester() {
//        Output.init();
//        Output.header("All unit testing",true,true);  
        
//        RecursionTest       unit1 = new RecursionTest();
//        AdvancedClassesTest unit2 = new AdvancedClassesTest();
//        CollectionsTest     unit3 = new CollectionsTest();
//        SearchSortTest      unit4 = new SearchSortTest();        
//        PermanentStorageTest unit5 = new PermanentStorageTest();
        
        StacksQueuesTest unit6 = new StacksQueuesTest();
        
//        Output.header("All unit testing",false,true);        
//        Output.flush();
    }
    
}