/*
 *  Mr. Wachs' classes - Java Computer Science learning file CS40STest.java
 *  for project ComputerScience42SIB on 5-Mar-2019 at 2:07:21 PM by lawrence.wachs
 */


/** required package class namespace */
package testing.cs40s;

import testing.cs40s.collections.CollectionsTest;
import testing.cs40s.advancedclasses.AdvancedClassesTest;
import testing.cs40s.permanentstorage.PermanentStorageTest;
import testing.cs40s.searchsort.SearchSortTest;



/**
 * CS40STest.java - 
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
        RecursionTest        unit1 = new RecursionTest();
        AdvancedClassesTest  unit2 = new AdvancedClassesTest();
        CollectionsTest      unit3 = new CollectionsTest();
        SearchSortTest       unit4 = new SearchSortTest();        
        PermanentStorageTest unit5 = new PermanentStorageTest();
    }
    
}
