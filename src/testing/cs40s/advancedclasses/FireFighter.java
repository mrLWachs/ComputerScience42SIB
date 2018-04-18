
/** required package class namespace */
package testing.cs40s.advancedclasses;

import java.io.Serializable;

/**
 * FireFighter.java - represents a fire fighter
 *
 * @author Mr. Wachs 
 * @since Oct 12, 2017 
 * @instructor Mr. Wachs
 */
public class FireFighter extends Person implements Serializable
{

    private int hatSize;
        
    /**
     * String representation of this object
     *
     * @return The object represented as a String
     */
    @Override
    public String toString() {
        return "Fire Fighter: " + super.toString();
    }

    /**
     * Determines if two objects are "equal" in this context
     *
     * @param object the object to compare to
     * @return the objects are "equal" (true) or not (false)
     */
    @Override
    public boolean equals(Object object) {
        return super.equals(object);
    }

    /**
     * Creates a duplicate object using new memory
     *
     * @return a "clone" of the object using new memory
     */
    public FireFighter clone() {
        return this;
    }

    /**
     * Accesses the hat size for this object
     * 
     * @return the hatSize to get
     */
    public int getHatSize() {
        return hatSize;
    }

    /**
     * Mutates the hat size for this object
     * 
     * @param hatSize the hatSize to set
     */
    public void setHatSize(int hatSize) {
        this.hatSize = hatSize;
    }

}
