
/** required package class namespace */
package testing.cs40s.advancedclasses;

 
/**
 * Royalty.java - represents a royalty person
 *
 * @author Mr. Wachs
 * @since Oct. 21, 2019, 10:40:12 a.m.
 */
public class Royalty extends Person
{

    /**
     * Default constructor, set class properties
     */
    public Royalty() {
        
    }

    /**
     * String representation of this object
     *
     * @return The object represented as a String
     */
    @Override
    public String toString() {
        return "Royalty: " + super.toString();
    }
    
    /**
     * Deep comparison, determines if two objects are "equal" in this context
     *
     * @param object the object to compare to
     * @return the objects are "equal" (true) or not (false)
     */
    @Override
    public boolean equals(Object object) {
        return super.equals(object);
    }
        
    /**
     * a Deep clone, creates a duplicate object using new memory
     *
     * @return a "clone" of the object using new memory
     */
    @Override
    public Royalty clone() {
        return this;
    }

}
