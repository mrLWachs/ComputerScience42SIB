
/** required package class namespace */
package testing.cs40s;

import testing.Output;
import testing.cs40s.advancedclasses.AdvancedClassesTest;

/**
 * ComputerScience40STest.java - description here...
 *
 * @author Mr. Wachs (login: lawrence.wachs)
 * @since Mar 2, 2018 
 * @instructor Mr. Wachs
 */
public class ComputerScience40STest 
{

    /** 
     * Default constructor for the class 
     */
    public ComputerScience40STest() {
        Output.header("Computer Science 40S course test",true,false);
        RecursionTest        unit01 = new RecursionTest();
        AdvancedClassesTest  unit02 = new AdvancedClassesTest();
        CollectionsTest      unit03 = new CollectionsTest();
        PermanentStorageTest unit04 = new PermanentStorageTest();
        Output.header("Computer Science 40S course test",false,false);
    }

}
