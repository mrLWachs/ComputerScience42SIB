
/** required package class namespace */
package testing.cs40s.advancedclasses;

import io.Output;

/**
 * Donut.java - description here...
 *
 * @author lawrence.wachs 
 * @since Oct 24, 2017 
 * @instructor Mr. Wachs
 */
public class Donut extends Food
{

    public Donut() {
        super("none");
    }

    @Override
    public void eat() {
        Output.show("Donut cooking is " + 
                oughtCook() + " food group is " +
                super.group + " with one bite!");
    }

    @Override
    public boolean oughtCook() {
        return false;
    }

}
