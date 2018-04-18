
/** required package class namespace */
package testing.testclass;

/** required imports */
import collections.LinkedList;
import java.io.Serializable;
import numbers.Random;

/**
 * ChildTestClass.java - a test class for randomly generated data types
 * 
 * @author Mr. Wachs 
 * @since Dec 16, 2016
 * @instructor Mr. Wachs
 */
public class TestClass extends BaseTestClass implements Serializable, Comparable<BaseTestClass>
{
        
    /** Class associated with this class */
    public AssociateTestClass associateTestClass;
    
    /** Randomly generated data for this class */
    public boolean[] list1;
    /** Randomly generated data for this class */
    public int[] list2;
    /** Randomly generated data for this class */
    public double[] list3;
    /** Randomly generated data for this class */
    public char[] list4;
    /** Randomly generated data for this class */
    public String[] list5;
    
    
    /** 
     * Default constructor 
     */
    public TestClass() {
        super();      
        associateTestClass = new AssociateTestClass();
        list1 = new boolean[WORD_LENGTH];
        list2 = new int[WORD_LENGTH];
        list3 = new double[WORD_LENGTH];
        list4 = new char[WORD_LENGTH];
        list5 = new String[WORD_LENGTH];
        list1 = Random.generate(list1);
        list2 = Random.generate(list2);
        list3 = Random.generate(list3);
        list4 = Random.generate(list4);
        list5 = Random.generate(list5,5,'a','z');
    }
    
    
    /**
     * Constructor sets class properties
     * 
     * @param theBoolean the boolean class property
     * @param theInteger the int class property
     * @param theDouble the double class property
     * @param theCharacter the char class property
     * @param theString the String class property
     */
    public TestClass(boolean theBoolean, 
                     int theInteger, 
                     double theDouble,
                     char theCharacter,
                     String theString) {
        super(theBoolean,theInteger,theDouble,theCharacter);
        associateTestClass = new AssociateTestClass(theString);
        list1 = new boolean[WORD_LENGTH];
        list2 = new int[WORD_LENGTH];
        list3 = new double[WORD_LENGTH];
        list4 = new char[WORD_LENGTH];
        list5 = new String[WORD_LENGTH];
        for (int i = 0; i < list1.length; i++) list1[i] = theBoolean;
        for (int i = 0; i < list2.length; i++) list2[i] = theInteger;
        for (int i = 0; i < list3.length; i++) list3[i] = theDouble;
        for (int i = 0; i < list4.length; i++) list4[i] = theCharacter;
        for (int i = 0; i < list5.length; i++) list5[i] = theString;
    }

    /**
     * String representation of this object
     * 
     * @return the string version of this object
     */
    @Override
    public String toString() {           
        int grandTotal = Integer.parseInt(super.toString());
        grandTotal += Integer.parseInt(associateTestClass.toString());
        int total = 0;
        for (int i = 0; i < list1.length; i++) 
            total += (int)(list1[i] ? 1 : 0);
        grandTotal += total; 
        total = 0;
        for (int i = 0; i < list2.length; i++) 
            total += list2[i];
        grandTotal += total;
        total = 0;
        for (int i = 0; i < list3.length; i++) 
            total += (int)list3[i];
        grandTotal += total;
        total = 0;
        for (int i = 0; i < list4.length; i++) 
            total += (int)list4[i];
        grandTotal += total;        
        total = 0;
        for (int i = 0; i < list5.length; i++) {
            int subTotal = 0;
            for (int j = 0; j < list5[i].length(); j++) {
                subTotal += (int)(list5[i].charAt(j));
            }
            total += subTotal;
        }
        grandTotal += total; 
        return Integer.toString(grandTotal);
    }
    
    /**
     * Returns a duplicate object using new memory
     * 
     * @return a clone of the object with new memory
     */
    public TestClass clone() {
        TestClass testClass = new TestClass();
        testClass.data1 = this.data1;
        testClass.data2 = this.data2;
        testClass.data3 = this.data3;
        testClass.data4 = this.data4;
        testClass.associateTestClass = this.associateTestClass.clone();        
        testClass.list1 = new boolean[this.list1.length];        
        for (int i = 0; i < this.list1.length; i++) {
            testClass.list1[i] = this.list1[i];
        }        
        testClass.list2 = new int[this.list2.length];
        for (int i = 0; i < this.list2.length; i++) {
            testClass.list2[i] = this.list2[i];
        }        
        testClass.list3 = new double[this.list3.length];
        for (int i = 0; i < this.list3.length; i++) {
            testClass.list3[i] = this.list3[i];
        }        
        testClass.list4 = new char[this.list4.length];
        for (int i = 0; i < this.list4.length; i++) {
            testClass.list4[i] = this.list4[i];
        }        
        testClass.list5 = new String[this.list5.length];
        for (int i = 0; i < this.list5.length; i++) {
            testClass.list5[i] = this.list5[i];
        }                
        return testClass;
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
            TestClass testClass = (TestClass)object;
            return this.toString().equals(testClass.toString());
        }
        catch (NullPointerException | ClassCastException e) {
            System.out.println("equals() Error: " + e.toString());
            return false;
        }   
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
    public int compareTo(TestClass that) {
        try {  
            return this.toString().compareTo(that.toString());   
        }
        catch (NullPointerException | ClassCastException e) {
            System.out.println("compareTo() Error: " + e.toString());
            return -1;
        }        
    }
        
    
    public static LinkedList createLinkedListNoDuplicates(int size) {
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < size; i++) {
            TestClass test;
            boolean valid;
            do {      
                valid = true;
                test = new TestClass();
                for (int j = 0; j < i; j++) {
                    if (linkedList.get(j).equals(test)) {
                        valid = false;
                        j = i;
                    }
                }
            } while (!valid);            
            linkedList.add(test);            
        }
        return linkedList;
    }
    
    public static LinkedList createLinkedList(int size) {
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < size; i++) {       
            linkedList.add(new TestClass());            
        }
        return linkedList;
    }

}
