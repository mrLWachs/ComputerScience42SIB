
/** required package class namespace */
package testing.testclass;

/** required imports */
import java.io.Serializable;
import tools.Calculator;

/**
 * AssociateTestClass.java - another class associated with the test class
 * class of the test class
 * 
 * @author lawrence.wachs
 * @since Dec 16, 2016
 * @instructor Mr. Wachs
 */
public class AssociateTestClass implements Serializable, Comparable<Object>
{
    
    /** Randomly generated data for this class */
    private String data5;
    
    private String key;
    
    
    /** 
     * Default constructor 
     */
    public AssociateTestClass() {
        data5 = Calculator.random(BaseTestClass.WORD_LENGTH);  
        key   = generateKey();
    }
    
    /** 
     * Constructor sets class properties
     * 
     * @param data5 the String class property
     */
    public AssociateTestClass(String data5) {
        this.data5 = data5;   
        key        = generateKey();
    }
    
    /**
     * String representation of this object
     * 
     * @return the string version of this object
     */
    @Override
    public String toString() {  
        return key;
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
            AssociateTestClass associateTestClass = (AssociateTestClass)object;
            return this.toString().equals(associateTestClass.toString());
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
    public AssociateTestClass clone() {
        return new AssociateTestClass(this.data5);
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
        AssociateTestClass that = (AssociateTestClass)object;
        try {
            return this.toString().compareTo(that.toString()); 
        }
        catch (NullPointerException | ClassCastException e) {
            System.out.println("compareTo() Error: " + e.toString());
            return -1;
        }
    }
    
    /**
     * Generates a key value from all the properties of this class, it's 
     * inherited classes, and associated classes
     * 
     * @return a string value (number)
     */
    private String generateKey() {
        int grandTotal = 0;
        for (int i = 0; i < data5.length(); i++) {
            grandTotal += (int)(data5.charAt(i));
        }
        String text   = Integer.toString(grandTotal);        
        int    spot   = Calculator.random(0, text.length()-1);
        char   value  = text.charAt(spot);
        String thing  = "" + value;
        int    number = Integer.parseInt(thing);
        String answer = "" + number;
        return answer;
    }
    
}