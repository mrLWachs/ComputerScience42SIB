
/** required package class namespace */
package testing.cs40s.advancedclasses;

import io.Output;

/**
 * Pizza.java - description here...
 *
 * @author lawrence.wachs 
 * @since Oct 24, 2017 
 * @instructor Mr. Wachs
 */
public class Pizza extends Food
{

    public Pizza() {
        super("all");
    }

    @Override
    public void eat() {
        Output.show("Pizza cooking is " + 
                oughtCook() + " food group is " +
                super.group + " with the Canoe method");
    }

    @Override
    public boolean oughtCook() {
        return true;
    }

}
