
/** required package class namespace */
package testing.cs40s.advancedclasses;

import testing.Output;

/**
 * Food.java - description here...
 *
 * @author lawrence.wachs 
 * @since Oct 24, 2017 
 * @instructor Mr. Wachs
 */
public abstract class Food 
{
    
    protected boolean isEdible;
    protected String group;

    public Food(String group) {
        this.group = group;
        isEdible = true;
    }

    public void spoil() {
        isEdible = false;
        Output.show("Becomes compost");
    }

    public abstract void eat();
    
    public abstract boolean oughtCook();
    
}
