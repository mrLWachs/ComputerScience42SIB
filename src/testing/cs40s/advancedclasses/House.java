
/** required package class namespace */
package testing.cs40s.advancedclasses;

/**
 * House.java - description here...
 *
 * @author lawrence.wachs 
 * @since Oct 27, 2017 
 * @instructor Mr. Wachs
 */
public class House <T extends Person, U>
{

    public T homeOwner;
    public U[] items;
    
    /** 
     * Default constructor for the class 
     */
    public House(T homeOwner, U[] items) {
        this.homeOwner = homeOwner;
        this.items = items;
    }

}
