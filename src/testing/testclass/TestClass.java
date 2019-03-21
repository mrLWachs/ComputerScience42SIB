/** required package class namespace */
package testing.testclass;

/** required imports */
import collections.LinkedList;
import java.io.Serializable;
import tools.Calculator;
import tools.Sorter;

/**
 * ChildTestClass.java - a test class for randomly generated data types
 * 
 * @author Mr. Wachs 
 * @since Dec 16, 2016
 * @instructor Mr. Wachs
 */
public class TestClass extends BaseTestClass implements Serializable, 
        Comparable<Object>
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
    
    private String key;
    
    
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
        list1 = Calculator.random(list1);
        list2 = Calculator.random(list2);
        list3 = Calculator.random(list3);
        list4 = Calculator.random(list4);
        list5 = Calculator.random(list5,5,'a','z');
        key   = generateKey();
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
        key = generateKey();
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
     * @param object the other object to be compared to
     * @return the value 0 if the argument string is equal to
     *          this object; a value less than 0 if this object
     *          is lexicographically less than the argument; and a
     *          value greater than 0 if this object is
     *          lexicographically greater than the argument
     */
    @Override
    public int compareTo(Object object) {
        TestClass that = (TestClass)object;
        try {  
            return this.toString().compareTo(that.toString());   
        }
        catch (NullPointerException | ClassCastException e) {
            System.out.println("compareTo() Error: " + e.toString());
            return -1;
        }        
    }
      
    /**
     * Generates and returns a LinkedList of random objects
     * 
     * @param size the size of the list to generate
     * @return a LinkedList of random objects
     */
    public static LinkedList generateList(int size) {
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < size; i++) {       
            linkedList.add(new TestClass());            
        }
        return linkedList;
    }
    
    /**
     * Generates and returns an array of random objects
     * 
     * @param size the size of the array to generate
     * @return an array of random objects
     */
    public static TestClass[] generateArray(int size) {
        TestClass[] array = new TestClass[size];
        for (int i = 0; i < size; i++) {       
            array[i] = new TestClass();            
        }
        return array;
    }
    
    /**
     * Generates and returns a LinkedList of non duplicate random objects
     * 
     * @param size the size of the list to generate
     * @return a LinkedList of unique random objects
     */
    public static LinkedList generateUniqueList(int size) {
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
    
    /**
     * Generates and returns a array of non duplicate random objects
     * 
     * @param size the size of the array to generate
     * @return a array of unique random objects
     */
    public static TestClass[] generateUniqueArray(int size) {
        TestClass[] array = new TestClass[size];
        for (int i = 0; i < size; i++) {
            TestClass test;
            boolean valid;
            do {      
                valid = true;
                test = new TestClass();
                for (int j = 0; j < i; j++) {
                    if (array[j].equals(test)) {
                        valid = false;
                        j = i;
                    }
                }
            } while (!valid);  
            array[i] = test;          
        }
        return array;
    }
    
    /**
     * Generates and returns a array of sorted random objects
     * 
     * @param size the size of the array to generate
     * @return a array of sorted random objects
     */
    public static TestClass[] generateSortedArray(int size) {
        TestClass[] array = generateArray(size);
        new Sorter().quick(array);
        return array;
    }
    
    /**
     * Generates and returns a LinkedList of sorted random objects
     * 
     * @param size the size of the list to generate
     * @return a LinkedList of sorted random objects
     */
    public static LinkedList generateSortedList(int size) {
        LinkedList linkedList = generateList(size);
        new Sorter().quick(linkedList);
        return linkedList;
    }
    
    /**
     * Generates and returns a array of sorted non duplicate random objects
     * 
     * @param size the size of the array to generate
     * @return a array of sorted unique random objects
     */
    public static TestClass[] generateUniqueSortedArray(int size) {
        TestClass[] array = generateUniqueArray(size);
        new Sorter().quick(array);
        return array;
    }
    
    /**
     * Generates and returns a LinkedList of sorted non duplicate random 
     * objects
     * 
     * @param size the size of the list to generate
     * @return a LinkedList of sorted unique random objects
     */
    public static LinkedList generateUniqueSortedList(int size) {
        LinkedList linkedList = generateUniqueList(size);
        new Sorter().quick(linkedList);
        return linkedList;
    }

    /**
     * Generates a key value from all the properties of this class, it's 
     * inherited classes, and associated classes
     * 
     * @return a string value (number)
     */
    private String generateKey() {
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
        String text   = Integer.toString(grandTotal);        
        int    spot1  = Calculator.random(0, text.length()-1);
        int    spot2  = Calculator.random(0, text.length()-1);
        char   value1 = text.charAt(spot1);
        char   value2 = text.charAt(spot2);
        String value  = "" + value1 + "" + value2;
        int    number = Integer.parseInt(value);
        String answer = "" + number;
        return answer;
    }

}