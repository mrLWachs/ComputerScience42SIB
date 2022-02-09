
/** Required package class namespace */
package testing.testclass;

/** Required imports */
import java.io.Serializable;
import tools.Numbers;
import tools.Text;


/**
 * TestClass.java - a test class for randomly generated data types
 * 
 * @author Mr. Wachs 
 * @since Feb. 9, 2022, 8:01:03 a.m.
 */
public class TestClass extends BaseClass implements Serializable, 
        Comparable<Object>
{
    
    /** Class associated with this class, randomly generated data */
    public AssociateClass associate; 
    /** Randomly generated data for this class */
    public int theInteger;
    /** Randomly generated data for this class */
    public double theDouble;
    /** Randomly generated data for this class */
    public char theCharacter;
    /** Randomly generated data for this class */
    public String word;
    
    /** The length for size generations */ 
    protected int length;  
    
    /** Text class for generating text, shared */
    private static Text text = new Text();
    /** Numbers class for generating numbers, shared */
    private static Numbers numbers = new Numbers();
    /** constant for characters */
    private static final char ALPHA_LOW = 'a';
    /** constant for characters */
    private static final char ALPHA_HIGH = 'z';
    
    /** constant for default size generations */
    public static final int DEFAULT_LENGTH = 5;
            
    
    /**
     * Default Constructor sets class properties
     */
    public TestClass() {
        this(DEFAULT_LENGTH);
    }
    
    /**
     * Constructor sets class properties
     * 
     * @param length for size generations
     */
    public TestClass(int length) {
        this(length,
             numbers.random(),
             numbers.random(0, length),
             numbers.round(numbers.random(0d, (double)length),length),
             text.random(ALPHA_LOW, ALPHA_HIGH),
             text.random(length),
             text.randomWord(length));
    }
    
    /**
     * Constructor sets class properties
     * 
     * @param length for size generations
     * @param theBoolean the Boolean value
     * @param theInteger the integer value
     * @param theDouble the double value
     * @param theCharacter the character value
     * @param theString the string value
     * @param word the word
     */
    public TestClass(int length,
                     boolean theBoolean,
                     int theInteger,
                     double theDouble,
                     char theCharacter,
                     String theString,
                     String word) {
        super(theBoolean);
        this.length       = length;
        this.associate    = new AssociateClass(theString);
        this.theInteger   = theInteger;
        this.theDouble    = theDouble;
        this.theCharacter = theCharacter;
        this.word         = word;
    }

    /**
     * String representation of this object
     * 
     * @return the string version of this object
     */
    @Override
    public String toString() {    
        final char DELIMIT = '|';
        return super.toString()                 + DELIMIT + 
               Integer.toString(theInteger)     + DELIMIT +
               Double.toString(theDouble)       + DELIMIT +
               Character.toString(theCharacter) + DELIMIT +
               associate.toString()             + DELIMIT +
               word;
    }
    
    /**
     * Returns a duplicate object using new memory
     * 
     * @return a clone of the object with new memory
     */
    public TestClass clone() {
        return new TestClass(this.length,
                             this.theBoolean,
                             this.theInteger,
                             this.theDouble,
                             this.theCharacter,
                             this.associate.theString,
                             this.word);
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
            TestClass that = (TestClass)object;
            return this.toString().equals(that.toString());
        }
        catch (NullPointerException | ClassCastException e) {
            System.out.println("equals() Error: " + e.toString());
            return false;
        }   
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
            TestClass that = (TestClass)object;
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

    /**
     * Generates a one or two digit number (between 0 - 99) based on a hash
     * algorithm with the passed text
     * 
     * @param text the text to generate a number from
     * @return the one or two digit integer (between 0-99)
     */
    public static int generate(String text) {
        final char DELIMIT = '|';
        int total = 0;
        for (int i = 0; i < text.length(); i++) {
            char character = text.charAt(i);
            if (character != DELIMIT) {
                int ascii = (int)character;
                total += ascii;
            }
        }
        String number = "0" + total;
        int oneDigit = numbers.random(0,100);
        if (oneDigit >= 0 && oneDigit <= 9) {
            int  mid       = (number.length()-1) / 2;
            char character = number.charAt(mid);
            number         = character + "";
        }
        else {
            int  mid1       = (number.length()-1) / 2;
            int  mid2       = mid1 / 2;
            char character1 = number.charAt(mid1);
            char character2 = number.charAt(mid2);
            number          = character1 + "" + character2;
            
        }
        return Integer.parseInt(number);
    }
    
}