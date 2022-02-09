
/** Required package class namespace */
package testing.testclass;

/** Required imports */
import java.io.Serializable;


/**
 * AssociateClass.java - another class associated with the test class
 * 
 * @author Mr. Wachs
 * @since Feb. 9, 2022, 8:01:03 a.m.
 */
public class AssociateClass implements Serializable, Comparable<Object>
{
    
    /** Randomly generated data for this class */
    public String theString;

    
    /**
     * Constructor sets class properties 
     * 
     * @param theString string value
     */
    public AssociateClass(String theString) {
        this.theString = theString;
    }
    
    /**
     * String representation of this object
     * 
     * @return the string version of this object
     */
    @Override
    public String toString() {  
        return theString;
    }
        
    /**
     * Determines if 2 objects are "equal" in this context
     * 
     * @param object the object to compare to
     * @return equal (true) or not (false)
     */
    @Override
    public boolean equals(Object object) {
        try {  
            AssociateClass that = (AssociateClass)object;
            return this.toString().equals(that.toString());
        }
        catch (NullPointerException | ClassCastException e) {
            System.out.println("equals() Error: " + e.toString());
            return false;
        } 
    }
    
    /**
     * Returns a duplicate object using new memory
     * 
     * @return a clone of the object with new memory
     */
    @Override
    public AssociateClass clone() {
        return new AssociateClass(this.theString);
    }
    
    /**
     * Compares two objects lexicographically
     *
     * @param object the other object to be compared to
     * @return the value 0 if the argument string is equal to
     *          this object; a value less than 0 if this object
     *          is lexicographically less than the argument; and a
     *          value greater than 0 if this object is
     *          lexicographically greater than the argument
     */
    @Override
    public int compareTo(Object object) {        
        try {
            AssociateClass that = (AssociateClass)object;
            return this.toString().compareTo(that.toString()); 
        }
        catch (NullPointerException | ClassCastException e) {
            System.out.println("compareTo() Error: " + e.toString());
            return -1;
        }
    }

    /**
     * Returns a hash code value for the object from all the properties of 
     * this class, its inherited classes, and associated classes. It returns 
     * a consistent code each time which is a 1 or 2 digit number between 0-99
     * 
     * @return a hash code value for this object 
     */
    @Override
    public int hashCode() {
        return TestClass.generate(this.toString());
    }
        
}