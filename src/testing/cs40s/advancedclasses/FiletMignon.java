
/** required package class namespace */
package testing.cs40s.advancedclasses;

import testing.Output;

/**
 * FiletMignon.java - description here...
 *
 * @author lawrence.wachs 
 * @since Oct 24, 2017 
 * @instructor Mr. Wachs
 */
public class FiletMignon extends Food
{

    public FiletMignon() {
        super("meat and alternatives");
    }

    @Override
    public void eat() {
        Output.show("Filet Mignon cooking is " + 
                oughtCook() + " food group is " +
                super.group + " with a knife and fork");
    }

    @Override
    public boolean oughtCook() {
        return true;
    }

}
