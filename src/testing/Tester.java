/** required package class namespace */
package testing;

import testing.advancedclasses.AdvancedClassesTest;
import testing.collections.CollectionsTest;
import testing.searchsort.SearchSortTest;


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
        System.out.println("\nTesting begins.....\n");        
//        RecursionTest       unit1 = new RecursionTest();
//        AdvancedClassesTest unit2 = new AdvancedClassesTest();
//        CollectionsTest     unit3 = new CollectionsTest();
        SearchSortTest      unit4 = new SearchSortTest();
        System.out.println("\nTesting complete!\n");
    }
    
}