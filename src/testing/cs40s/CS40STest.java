
/** required package class namespace */
package testing.cs40s;

/** required imports */
import testing.cs40s.collections.CollectionsTest;
import testing.cs40s.advancedclasses.AdvancedClassesTest;
import testing.cs40s.permanentstorage.PermanentStorageTest;
import testing.cs40s.searchsort.SearchSortTest;
import io.System;

/**
 * CS40STest.java - the large in class example we continue to work 
 * on in each unit adding example code on the new concepts of each unit 
 * along with any in class requests for code examples that might come up 
 * over the course
 *
 * @author Mr. Wachs 
 * @since 5-Mar-2019 
 */
public class CS40STest 
{

    /**
     * Default constructor for the class, sets class properties
     */
    public CS40STest() {
        System.out.header("Computer Science 40S course started...");
        RecursionTest        learnRecursion        = new RecursionTest();
        AdvancedClassesTest  learnAdvancedClasses  = new AdvancedClassesTest();
        CollectionsTest      learnCollections      = new CollectionsTest();
        SearchSortTest       learnSearchingSorting = new SearchSortTest();        
        PermanentStorageTest learnPermanentstorage = new PermanentStorageTest();
        System.out.header("Computer Science 40S course completed!");
    }
    
}
