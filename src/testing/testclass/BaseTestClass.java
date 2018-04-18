
/** required package class namespace */
package testing.testclass;

/** required imports */
import java.io.Serializable;
import numbers.Random;

/**
 * BaseTestClass.java - a base class for the testing class to inherit from
 * primitive data properties
 * 
 * @author Mr. Wachs 
 * @since Dec 1, 2016
 * @instructor Mr. Wachs
 */
public class BaseTestClass implements Serializable, 
        Comparable<BaseTestClass>
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
    
    
    /** 
     * Default constructor 
     */
    public BaseTestClass() {    
        data1 = Random.generate();
        data2 = Random.generate(1,WORD_LENGTH);
        data3 = Random.generate(1d,(double)WORD_LENGTH);
        data4 = Random.generate((char)(1+96),(char)(WORD_LENGTH+96));        
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
    }
    
    /**
     * String representation of this object
     * 
     * @return the string version of this object
     */
    @Override
    public String toString() {   
        int grandTotal = 0;
        grandTotal += (data1 ? 1 : 0);
        grandTotal += data2;
        grandTotal += (int)(data3);
        grandTotal += (int)(data4);  
        return Integer.toString(grandTotal);
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
     * @param that the other object to be compared to
     * @return the value 0 if the argument string is equal to
     *          this object; a value less than 0 if this object
     *          is lexicographically less than the argument; and a
     *          value greater than 0 if this object is
     *          lexicographically greater than the argument
     */
    @Override
    public int compareTo(BaseTestClass that) {
        try {
            return this.toString().compareTo(that.toString()); 
        }
        catch (NullPointerException | ClassCastException e) {
            System.out.println("compareTo() Error: " + e.toString());
            return -1;
        }
    }
    
}
