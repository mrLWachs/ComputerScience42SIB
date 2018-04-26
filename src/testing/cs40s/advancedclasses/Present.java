
/** required package class namespace */
package testing.cs40s.advancedclasses;

import testing.Output;

/**
 * Present.java - description here...
 *
 * @author lawrence.wachs 
 * @since Oct 27, 2017 
 * @instructor Mr. Wachs
 */
public class Present <T>
{

    private T item;
    
    /** 
     * Default constructor for the class 
     */
    public Present(T item) {
        this.item = item;
    }
    
    public T open() {
        return item;
    }
    
    public void peek() {
        Output.show(item.toString());
    }

}
