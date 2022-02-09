
/** Required package class namespace */
package testing.testclass;

/** Required imports */
import collections.LinkedList;
import tools.Text;
import io.Simulator;
import io.System;

 
/**
 * Test.java - a testing class to be used in conjunction with the TexstClass
 * to test code on al different simple and complex data types and collections
 * of those types
 *
 * @author Mr. Wachs
 * @since Feb. 9, 2022, 8:01:03 a.m.
 */
public class Test 
{
    
    /**
     * A testing run of this class and the various methods it employs
     */
    public static void run() {
        Simulator.header("Testing class example started...");
        
        Text text = new Text();
        int length = TestClass.DEFAULT_LENGTH;
        
        Simulator.comment("Single Test Data");
        
        System.out.println(Test.getBoolean());
        System.out.println(Test.getInteger(length));
        System.out.println(Test.getDouble(length));
        System.out.println(Test.getCharacter(length));
        System.out.println(Test.getString(length));
        System.out.println(Test.getWord(length));
        
        Simulator.comment("Arrays Test Data");
        
        Boolean[]   a1 = Test.getBooleanArray(length);
        Integer[]   a2 = Test.getIntegerArray(length);
        Double[]    a3 = Test.getDoubleArray(length);
        Character[] a4 = Test.getCharacterArray(length);
        String[]    a5 = Test.getStringArray(length);
        String[]    a6 = Test.getWordArray(length);
        
        System.out.println(text.toString(a1));
        System.out.println(text.toString(a2));
        System.out.println(text.toString(a3));
        System.out.println(text.toString(a4));
        System.out.println(text.toString(a5));
        System.out.println(text.toString(a6));
        
        Simulator.comment("LinkedLists Test Data");
        
        LinkedList l1 = Test.getBooleanList(length);
        LinkedList l2 = Test.getIntegerList(length);
        LinkedList l3 = Test.getDoubleList(length);
        LinkedList l4 = Test.getCharacterList(length);
        LinkedList l5 = Test.getStringList(length);
        LinkedList l6 = Test.getWordList(length);
        
        System.out.println(l1);
        System.out.println(l2);
        System.out.println(l3);
        System.out.println(l4);
        System.out.println(l5);
        System.out.println(l6);
        
        Simulator.comment("Unique Arrays Test Data");
        
        Boolean[]   ua1 = Test.getUniqueBooleanArray(length);
        Integer[]   ua2 = Test.getUniqueIntegerArray(length);
        Double[]    ua3 = Test.getUniqueDoubleArray(length);
        Character[] ua4 = Test.getUniqueCharacterArray(length);
        String[]    ua5 = Test.getUniqueStringArray(length);
        String[]    ua6 = Test.getUniqueWordArray(length);
        
        System.out.println("unique " + text.toString(ua1));
        System.out.println("unique " + text.toString(ua2));
        System.out.println("unique " + text.toString(ua3));
        System.out.println("unique " + text.toString(ua4));
        System.out.println("unique " + text.toString(ua5));
        System.out.println("unique " + text.toString(ua6));
        
        Simulator.comment("Unique LinkedLists Test Data");
        
        LinkedList u1 = Test.getUniqueBooleanList(length);
        LinkedList u2 = Test.getUniqueIntegerList(length);
        LinkedList u3 = Test.getUniqueDoubleList(length);
        LinkedList u4 = Test.getUniqueCharacterList(length);
        LinkedList u5 = Test.getUniqueStringList(length);
        LinkedList u6 = Test.getUniqueWordList(length);
        
        System.out.println("unique " + u1);
        System.out.println("unique " + u2);
        System.out.println("unique " + u3);
        System.out.println("unique " + u4);
        System.out.println("unique " + u5);
        System.out.println("unique " + u6);
                
        Simulator.header("Testing class example completed!");
    }
    
    /**
     * A randomly generated value from the test class structure
     * 
     * @return a random object
     */
    public static Boolean getBoolean() {
        return (Boolean)new TestClass().theBoolean;
    }

    /**
     * A randomly generated value from the test class structure
     * 
     * @return a random object
     */
    public static Integer getInteger() {
        return (Integer)new TestClass().theInteger;
    }
    
    /**
     * A randomly generated value from the test class structure
     * 
     * @param length the length of the randomly generated value
     * @return a random object
     */
    public static Integer getInteger(int length) {
        return (Integer)new TestClass(length).theInteger;
    }
        
    /**
     * A randomly generated value from the test class structure
     * 
     * @return a random object
     */
    public static Double getDouble() {
        return (Double)new TestClass().theDouble;
    }
    
    /**
     * A randomly generated value from the test class structure
     * 
     * @param length the length of the randomly generated value
     * @return a random object
     */
    public static Double getDouble(int length) {
        return (Double)new TestClass(length).theDouble;
    }
    
    /**
     * A randomly generated value from the test class structure
     * 
     * @return a random object
     */
    public static Character getCharacter() {
        return (Character)new TestClass().theCharacter;
    }
    
    /**
     * A randomly generated value from the test class structure
     * 
     * @param length the length of the randomly generated value
     * @return a random object
     */
    public static Character getCharacter(int length) {
        return (Character)new TestClass(length).theCharacter;
    }
    
    /**
     * A randomly generated value from the test class structure
     * 
     * @return a random object
     */
    public static String getString() {
        return new TestClass().associate.theString;
    }
    
    /**
     * A randomly generated value from the test class structure
     * 
     * @param length the length of the randomly generated value
     * @return a random object
     */
    public static String getString(int length) {
        return new TestClass(length).associate.theString;
    }
    
    /**
     * A randomly generated value from the test class structure
     * 
     * @return a random object
     */
    public static String getWord() {
        return new TestClass().word;
    }
    
    /**
     * A randomly generated value from the test class structure
     * 
     * @param length the length of the randomly generated value
     * @return a random object
     */
    public static String getWord(int length) {
        return new TestClass(length).word;
    }
    
    /**
     * Generates and returns an array of random objects
     * 
     * @return an array of random objects
     */    
    public static Boolean[] getBooleanArray() {
        Boolean[] array = new Boolean[TestClass.DEFAULT_LENGTH];
        for (int i = 0; i < array.length; i++) {
            array[i] = getBoolean();
        }
        return array;
    }
    
    /**
     * Generates and returns an array of random objects
     * 
     * @param length the size of the array to generate
     * @return an array of random objects
     */
    public static Boolean[] getBooleanArray(int length) {
        Boolean[] array = new Boolean[length];
        for (int i = 0; i < array.length; i++) {
            array[i] = getBoolean();
        }
        return array;
    }
    
    /**
     * Generates and returns a array of non duplicate random objects
     * 
     * @param length the size of the array to generate
     * @return a array of unique random objects
     */
    public static Boolean[] getUniqueBooleanArray(int length) {
        if (length > 2) return null;
        return getUniqueBooleanList(length).toArray(new Boolean[0]);
    }
    
    /**
     * Generates and returns a array of non duplicate random objects
     * 
     * @return a array of unique random objects
     */
    public static Boolean[] getUniqueBooleanArray() {
        return getUniqueBooleanArray(TestClass.DEFAULT_LENGTH);
    }    
    
    /**
     * Generates and returns an array of random objects
     * 
     * @return an array of random objects
     */
    public static Integer[] getIntegerArray() {
        Integer[] array = new Integer[TestClass.DEFAULT_LENGTH];
        for (int i = 0; i < array.length; i++) {
            array[i] = getInteger();
        }
        return array;
    }
    
    /**
     * Generates and returns an array of random objects
     * 
     * @param length the size of the array to generate
     * @return an array of random objects
     */
    public static Integer[] getIntegerArray(int length) {
        Integer[] array = new Integer[length];
        for (int i = 0; i < array.length; i++) {
            array[i] = getInteger(length);
        }
        return array;
    }  
    
    /**
     * Generates and returns a array of non duplicate random objects
     * 
     * @param length the size of the array to generate
     * @return a array of unique random objects
     */
    public static Integer[] getUniqueIntegerArray(int length) {
        return getUniqueIntegerList(length).toArray(new Integer[0]);
    }
    
    /**
     * Generates and returns a array of non duplicate random objects
     * 
     * @return a array of unique random objects
     */
    public static Integer[] getUniqueIntegerArray() {
        return getUniqueIntegerArray(TestClass.DEFAULT_LENGTH);
    }
    
    /**
     * Generates and returns an array of random objects
     * 
     * @return an array of random objects
     */
    public static Double[] getDoubleArray() {
        Double[] array = new Double[TestClass.DEFAULT_LENGTH];
        for (int i = 0; i < array.length; i++) {
            array[i] = getDouble();
        }
        return array;
    }
    
    /**
     * Generates and returns an array of random objects
     * 
     * @param length the size of the array to generate
     * @return an array of random objects
     */
    public static Double[] getDoubleArray(int length) {
        Double[] array = new Double[length];
        for (int i = 0; i < array.length; i++) {
            array[i] = getDouble(length);
        }
        return array;
    }
      
    /**
     * Generates and returns a array of non duplicate random objects
     * 
     * @param length the size of the array to generate
     * @return a array of unique random objects
     */
    public static Double[] getUniqueDoubleArray(int length) {
        return getUniqueDoubleList(length).toArray(new Double[0]);
    }
    
    /**
     * Generates and returns a array of non duplicate random objects
     * 
     * @return a array of unique random objects
     */
    public static Double[] getUniqueDoubleArray() {
        return getUniqueDoubleArray(TestClass.DEFAULT_LENGTH);
    }
        
    /**
     * Generates and returns an array of random objects
     * 
     * @return an array of random objects
     */
    public static Character[] getCharacterArray() {
        Character[] array = new Character[TestClass.DEFAULT_LENGTH];
        for (int i = 0; i < array.length; i++) {
            array[i] = getCharacter();
        }
        return array;
    }
    
    /**
     * Generates and returns an array of random objects
     * 
     * @param length the size of the array to generate
     * @return an array of random objects
     */
    public static Character[] getCharacterArray(int length) {
        Character[] array = new Character[length];
        for (int i = 0; i < array.length; i++) {
            array[i] = getCharacter(length);
        }
        return array;
    }
          
    /**
     * Generates and returns a array of non duplicate random objects
     * 
     * @param length the size of the array to generate
     * @return a array of unique random objects
     */
    public static Character[] getUniqueCharacterArray(int length) {
        return getUniqueCharacterList(length).toArray(new Character[0]);
    }
    
    /**
     * Generates and returns a array of non duplicate random objects
     * 
     * @return a array of unique random objects
     */
    public static Character[] getUniqueCharacterArray() {
        return getUniqueCharacterArray(TestClass.DEFAULT_LENGTH);
    }
    
    /**
     * Generates and returns an array of random objects
     * 
     * @return an array of random objects
     */
    public static String[] getStringArray() {
        String[] array = new String[TestClass.DEFAULT_LENGTH];
        for (int i = 0; i < array.length; i++) {
            array[i] = getString();
        }
        return array;
    }
    
    /**
     * Generates and returns an array of random objects
     * 
     * @param length the size of the array to generate
     * @return an array of random objects
     */
    public static String[] getStringArray(int length) {
        String[] array = new String[length];
        for (int i = 0; i < array.length; i++) {
            array[i] = getString(length);
        }
        return array;
    }
    
    /**
     * Generates and returns a array of non duplicate random objects
     * 
     * @param length the size of the array to generate
     * @return a array of unique random objects
     */
    public static String[] getUniqueStringArray(int length) {
        return getUniqueStringList(length).toArray(new String[0]);
    }
    
    /**
     * Generates and returns a array of non duplicate random objects
     * 
     * @return a array of unique random objects
     */
    public static String[] getUniqueStringArray() {
        return getUniqueStringArray(TestClass.DEFAULT_LENGTH);
    }
    
    /**
     * Generates and returns an array of random objects
     * 
     * @return an array of random objects
     */
    public static String[] getWordArray() {
        String[] array = new String[TestClass.DEFAULT_LENGTH];
        for (int i = 0; i < array.length; i++) {
            array[i] = getWord();
        }
        return array;
    }
    
    /**
     * Generates and returns an array of random objects
     * 
     * @param length the size of the array to generate
     * @return an array of random objects
     */
    public static String[] getWordArray(int length) {
        String[] array = new String[length];
        for (int i = 0; i < array.length; i++) {
            array[i] = getWord(length);
        }
        return array;
    }

    /**
     * Generates and returns a array of non duplicate random objects
     * 
     * @param length the size of the array to generate
     * @return a array of unique random objects
     */
    public static String[] getUniqueWordArray(int length) {
        return getUniqueWordList(length).toArray(new String[0]);
    }
    
    /**
     * Generates and returns a array of non duplicate random objects
     * 
     * @return a array of unique random objects
     */
    public static String[] getUniqueWordArray() {
        return getUniqueWordArray(TestClass.DEFAULT_LENGTH);
    }
    
    /**
     * Generates and returns a LinkedList of random objects
     * 
     * @return a LinkedList of random objects
     */    
    public static LinkedList<Boolean> getBooleanList() {
        return new LinkedList<Boolean>(getBooleanArray());
    }
    
    /**
     * Generates and returns a LinkedList of random objects
     * 
     * @param length the size of the list to generate
     * @return a LinkedList of random objects
     */
    public static LinkedList<Boolean> getBooleanList(int length) {
        return new LinkedList<Boolean>(getBooleanArray(length));
    }
    
    /**
     * Generates and returns a LinkedList of non duplicate random objects
     * 
     * @param length the size of the list to generate
     * @return a LinkedList of unique random objects
     */
    public static LinkedList<Boolean> getUniqueBooleanList(int length) {
        if (length > 2) return null;
        LinkedList<Boolean> list = new LinkedList<Boolean>();
        for (int i = 0; i < length; i++) {
            Boolean word;
            boolean valid = true;
            do {
                valid = true;
                word = getBoolean();
                for (int j = 0; j < i; j++) {
                    Boolean wordToCheck = list.get(j);
                    if (wordToCheck.equals(word)) {
                        valid = false;
                        j = i;
                    }
                }
            } while (!valid);
            list.add(word);
        }
        return list;
    }

    /**
     * Generates and returns a LinkedList of non duplicate random objects
     * 
     * @return a LinkedList of unique random objects
     */
    public static LinkedList<Boolean> getUniqueBooleanList() {
        return getUniqueBooleanList(TestClass.DEFAULT_LENGTH);
    }
        
    /**
     * Generates and returns a LinkedList of random objects
     * 
     * @return a LinkedList of random objects
     */
    public static LinkedList<Integer> getIntegerList() {
        return new LinkedList<Integer>(getIntegerArray());
    }
    
    /**
     * Generates and returns a LinkedList of random objects
     * 
     * @param length the size of the list to generate
     * @return a LinkedList of random objects
     */
    public static LinkedList<Integer> getIntegerList(int length) {
        return new LinkedList<Integer>(getIntegerArray(length));
    }
    
    /**
     * Generates and returns a LinkedList of non duplicate random objects
     * 
     * @param length the size of the list to generate
     * @return a LinkedList of unique random objects
     */
    public static LinkedList<Integer> getUniqueIntegerList(int length) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        for (int i = 0; i < length; i++) {
            Integer word;
            boolean valid = true;
            do {
                valid = true;
                word = getInteger(length);
                for (int j = 0; j < i; j++) {
                    Integer wordToCheck = list.get(j);
                    if (wordToCheck.equals(word)) {
                        valid = false;
                        j = i;
                    }
                }
            } while (!valid);
            list.add(word);
        }
        return list;
    }

    /**
     * Generates and returns a LinkedList of non duplicate random objects
     * 
     * @return a LinkedList of unique random objects
     */
    public static LinkedList<Integer> getUniqueIntegerList() {
        return getUniqueIntegerList(TestClass.DEFAULT_LENGTH);
    }
    
    /**
     * Generates and returns a LinkedList of random objects
     * 
     * @return a LinkedList of random objects
     */
    public static LinkedList<Double> getDoubleList() {
        return new LinkedList<Double>(getDoubleArray());
    }
    
    /**
     * Generates and returns a LinkedList of random objects
     * 
     * @param length the size of the list to generate
     * @return a LinkedList of random objects
     */
    public static LinkedList<Double> getDoubleList(int length) {
        return new LinkedList<Double>(getDoubleArray(length));
    }
    
    /**
     * Generates and returns a LinkedList of non duplicate random objects
     * 
     * @param length the size of the list to generate
     * @return a LinkedList of unique random objects
     */
    public static LinkedList<Double> getUniqueDoubleList(int length) {
        LinkedList<Double> list = new LinkedList<Double>();
        for (int i = 0; i < length; i++) {
            Double word;
            boolean valid = true;
            do {
                valid = true;
                word = getDouble(length);
                for (int j = 0; j < i; j++) {
                    Double wordToCheck = list.get(j);
                    if (wordToCheck.equals(word)) {
                        valid = false;
                        j = i;
                    }
                }
            } while (!valid);
            list.add(word);
        }
        return list;
    }

    /**
     * Generates and returns a LinkedList of non duplicate random objects
     * 
     * @return a LinkedList of unique random objects
     */
    public static LinkedList<Double> getUniqueDoubleList() {
        return getUniqueDoubleList(TestClass.DEFAULT_LENGTH);
    }
        
    /**
     * Generates and returns a LinkedList of random objects
     * 
     * @return a LinkedList of random objects
     */
    public static LinkedList<Character> getCharacterList() {
        return new LinkedList<Character>(getCharacterArray());
    }
    
    /**
     * Generates and returns a LinkedList of random objects
     * 
     * @param length the size of the list to generate
     * @return a LinkedList of random objects
     */
    public static LinkedList<Character> getCharacterList(int length) {
        return new LinkedList<Character>(getCharacterArray(length));
    }
        
    /**
     * Generates and returns a LinkedList of non duplicate random objects
     * 
     * @param length the size of the list to generate
     * @return a LinkedList of unique random objects
     */
    public static LinkedList<Character> getUniqueCharacterList(int length) {
        LinkedList<Character> list = new LinkedList<Character>();
        for (int i = 0; i < length; i++) {
            Character word;
            boolean valid = true;
            do {
                valid = true;
                word = getCharacter(length);
                for (int j = 0; j < i; j++) {
                    Character wordToCheck = list.get(j);
                    if (wordToCheck.equals(word)) {
                        valid = false;
                        j = i;
                    }
                }
            } while (!valid);
            list.add(word);
        }
        return list;
    }

    /**
     * Generates and returns a LinkedList of non duplicate random objects
     * 
     * @return a LinkedList of unique random objects
     */
    public static LinkedList<Character> getUniqueCharacterList() {
        return getUniqueCharacterList(TestClass.DEFAULT_LENGTH);
    }
    
    /**
     * Generates and returns a LinkedList of random objects
     * 
     * @return a LinkedList of random objects
     */
    public static LinkedList<String> getStringList() {
        return new LinkedList<String>(getStringArray());
    }
    
    /**
     * Generates and returns a LinkedList of random objects
     * 
     * @param length the size of the list to generate
     * @return a LinkedList of random objects
     */
    public static LinkedList<String> getStringList(int length) {
        return new LinkedList<String>(getStringArray(length));
    }
    
    /**
     * Generates and returns a LinkedList of non duplicate random objects
     * 
     * @param length the size of the list to generate
     * @return a LinkedList of unique random objects
     */
    public static LinkedList<String> getUniqueStringList(int length) {
        LinkedList<String> list = new LinkedList<String>();
        for (int i = 0; i < length; i++) {
            String word = "";
            boolean valid = true;
            do {
                valid = true;
                word = getString(length);
                for (int j = 0; j < i; j++) {
                    String wordToCheck = list.get(j);
                    if (wordToCheck.equals(word)) {
                        valid = false;
                        j = i;
                    }
                }
            } while (!valid);
            list.add(word);
        }
        return list;
    }

    /**
     * Generates and returns a LinkedList of non duplicate random objects
     * 
     * @return a LinkedList of unique random objects
     */
    public static LinkedList<String> getUniqueStringList() {
        return getUniqueStringList(TestClass.DEFAULT_LENGTH);
    }
        
    /**
     * Generates and returns a LinkedList of random objects
     * 
     * @return a LinkedList of random objects
     */
    public static LinkedList<String> getWordList() {
        return new LinkedList<String>(getWordArray());
    }
    
    /**
     * Generates and returns a LinkedList of random objects
     * 
     * @param length the size of the list to generate
     * @return a LinkedList of random objects
     */
    public static LinkedList<String> getWordList(int length) {
        return new LinkedList<String>(getWordArray(length));
    }
        
    /**
     * Generates and returns a LinkedList of non duplicate random objects
     * 
     * @param length the size of the list to generate
     * @return a LinkedList of unique random objects
     */
    public static LinkedList<String> getUniqueWordList(int length) {
        int maxWordSize = Text.longestWord;
        if (length > maxWordSize) return null;
        LinkedList<String> list = new LinkedList<String>();
        for (int i = 0; i < length; i++) {
            String word = "";
            boolean valid = true;
            do {
                valid = true;
                word = getWord(length);
                for (int j = 0; j < i; j++) {
                    String wordToCheck = list.get(j);
                    if (wordToCheck.equals(word)) {
                        valid = false;
                        j = i;
                    }
                }
            } while (!valid);
            list.add(word);
        }
        return list;
    }

    /**
     * Generates and returns a LinkedList of non duplicate random objects
     * 
     * @return a LinkedList of unique random objects
     */
    public static LinkedList<String> getUniqueWordList() {
        return getUniqueWordList(TestClass.DEFAULT_LENGTH);
    }
    
}
