
/** Required package class namespace */
package testing.cs40s.advancedclasses;


/**
 * Hockey.java - enforcing "the rules" of hockey (and sports). Interfaces can
 * inherit from other interfaces ("can follow the rules of other rules"). This
 * is like classes inheriting from other classes.
 *
 * @author Mr. Wachs
 * @since 23-Nov-2022, 11:03:07 AM
 */
public interface Hockey extends Sports
{
    
    /**
     * A team scoring a point
     * 
     * @param name the name of the team who scored
     */
    void score(String name);
    
    /**
     * The passed period of hockey is over
	 *
     * @param period the period number
     */
    void endOfPeriod(int period);

}