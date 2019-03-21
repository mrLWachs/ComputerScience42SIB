
/** required package class namespace */
package testing.testclass;

/** required imports */
import java.io.Serializable;
import tools.Calculator;

/**
 * BaseTestClass.java - a base class for the testing class to inherit from
 * primitive data properties
 * 
 * @author Mr. Wachs 
 * @since Dec 1, 2016
 * @instructor Mr. Wachs
 */
public class BaseTestClass implements Serializable, Comparable<Object>
{
    
    /** Randomly generated data for this class */
    protected boolean data1;
    /** Randomly generated data for this class */
    protected int data2;
    /** Randomly generated data for this class */
    protected double data3;
    /** Randomly generated data for this class */
    protected char data4;
    
    /** The length for random string generation */ 
    protected static final int WORD_LENGTH = 5;    
    
    private String key;
    
    /** 
     * Default constructor 
     */
    public BaseTestClass() {    
        data1 = Calculator.random();
        data2 = Calculator.random(1,WORD_LENGTH);
        data3 = Calculator.random(1d,(double)WORD_LENGTH);
        data4 = Calculator.random((char)(1+96),(char)(WORD_LENGTH+96));     
        key   = generateKey();
    }

    /**
     * Constructor sets class properties
     * 
     * @param theBoolean the boolean class property
     * @param theInteger the int class property
     * @param theDouble the double class property
     * @param theCharacter the char class property
     */
    public BaseTestClass(boolean theBoolean, 
                         int theInteger, 
                         double theDouble,
                         char theCharacter) {
        this.data1 = theBoolean;
        this.data2 = theInteger;
        this.data3 = theDouble;
        this.data4 = theCharacter;  
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
            BaseTestClass baseTestClass = (BaseTestClass)object;
            return this.toString().equals(baseTestClass.toString());
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
    public BaseTestClass clone() {
        return new BaseTestClass(this.data1,this.data2,this.data3,this.data4);
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
        BaseTestClass that = (BaseTestClass)object;
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
        grandTotal += (data1 ? 1 : 0);
        grandTotal += data2;
        grandTotal += (int)(data3);
        grandTotal += (int)(data4); 
        String text   = Integer.toString(grandTotal);        
        int    spot   = Calculator.random(0, text.length()-1);
        char   value  = text.charAt(spot);
        String thing  = "" + value;
        int    number = Integer.parseInt(thing);
        String answer = "" + number;
        return answer;
    }
    
}