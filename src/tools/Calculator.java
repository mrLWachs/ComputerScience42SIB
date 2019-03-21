
/** required package class namespace */
package tools;

import collections.LinkedList;
import testing.cs40s.advancedclasses.Athlete;


/**
 * Calculator.java - useful collection of methods for doing calculations.
 *
 * @author Mr. Wachs 
 * @since 24-Sep-2018 
 */
public class Calculator 
{

    /**
     * Calculates the factorial of a number
     * 
     * @param number the value to calculate
     * @return the factorial of that number
     */
    public static long factorial(int number) {
        if      (number == 0) return 1;                            // base case
        else if (number < 0)  return Integer.MIN_VALUE;            // base case
        else                  return number * factorial(number-1);  
        // recursive case
    }

    /**
     * Calculates the power of a base to it's exponent 
     * 
     * @param base the power's base
     * @param exponent the power's exponent
     * @return the base ^ exponent
     */
    public static double power(int base, int exponent) {
        if      (exponent <  0)                         // recursive case
            return 1 / power(base,Math.abs(exponent));
        else if (exponent == 0) return 1;               // base case
        else if (exponent == 1) return base;            // base case
        else                                            // recursive case
            return base * power(base, exponent-1);  
    }
    
    /**
     * Generates a random number inside a range
     * 
     * @param low the lowest possible random number
     * @param high the highest possible random number
     * @return random number in the range
     */
    public static double random(double low, double high) {
        double seed   = Math.random();
        double random = (high - low + 1) * seed + low;
        return random;
    }
    
    /**
     * Generates a random boolean
     * 
     * @return true or false
     */
    public static boolean random() {
        return Calculator.random(0,1) == 0;
    }
    
    /**
     * Generates a random number inside a range
     * 
     * @param low the lowest possible random number
     * @param high the highest possible random number
     * @return random number in the range
     */
    public static int random(int low, int high) {
        return (int)Calculator.random((double)low, (double)high);
    }

    /**
     * Generates a random character inside a range
     * 
     * @param low the lowest possible random character
     * @param high the highest possible random character
     * @return random character in the range
     */
    public static char random(char low, char high) {
        return (char)Calculator.random((int)low, (int)high);
    }
    
    /**
     * Generates a random String inside a range
     * 
     * @param length the length of the string to generate
     * @param low the lowest possible random character
     * @param high the highest possible random character
     * @return random String in the range
     */
    public static String random(int length, char low, char high) {
        String word = "";
        for (int i = 0; i < length; i++) {
            word += Calculator.random(low,high);
        }
        return word;
    }
    
    /**
     * Generates a random String of a set length
     * 
     * @param length the length of the string to generate
     * @return a random string of set length
     */
    public static String random(int length) {
        return Calculator.random(length,'a','z');
    }
    
    /**
     * Generates a random array of booleans
     * 
     * @param array the initial sized array
     * @return a random array of booleans
     */
    public static boolean[] random(boolean array[]) {
        for (int i = 0; i < array.length; i++) {
            array[i] = Calculator.random();
        }
        return array;
    }
    
    /**
     * Generates a random array of integers inside a range
     * 
     * @param array the initial sized array
     * @param low the lowest possible random number
     * @param high the highest possible random number
     * @return a random array of integers inside a range
     */
    public static int[] random(int array[], int low, int high) {
        for (int i = 0; i < array.length; i++) {
            array[i] = Calculator.random(low, high);
        }
        return array;
    }
    
    /**
     * Generates a random array of integers between 0 and the array length
     * 
     * @param array the initial sized array
     * @return a random array of integers 
     */
    public static int[] random(int array[]) {
        for (int i = 0; i < array.length; i++) {
            array[i] = Calculator.random(0, array.length-1);
        }
        return array;
    }
    
    /**
     * Generates a random array of doubles inside a range
     * 
     * @param array the initial sized array
     * @param low the lowest possible random number
     * @param high the highest possible random number
     * @return a random array of doubles inside a range
     */
    public static double[] random(double array[], double low, double high) {
        for (int i = 0; i < array.length; i++) {
            array[i] = Calculator.random(low, high);
        }
        return array;
    }
    
    /**
     * Generates a random array of doubles between 0 and the array length
     * 
     * @param array the initial sized array
     * @return a random array of doubles 
     */
    public static double[] random(double array[]) {
        for (int i = 0; i < array.length; i++) {
            array[i] = Calculator.random(0d,(double)(array.length-1));
        }
        return array;
    }
    
    /**
     * Generates a random array of characters inside a range
     * 
     * @param array the initial sized array
     * @param low the lowest possible random character
     * @param high the highest possible random character
     * @return a random array of characters inside a range
     */
    public static char[] random(char array[], char low, char high) {
        for (int i = 0; i < array.length; i++) {
            array[i] = Calculator.random(low, high);
        }
        return array;
    }
    
    /**
     * Generates a random array of characters between 'a' and 'z'
     * 
     * @param array the initial sized array
     * @return a random array of characters 
     */
    public static char[] random(char array[]) {
        for (int i = 0; i < array.length; i++) {
            array[i] = Calculator.random('a','z');
        }
        return array;
    }
    
    /**
     * Generates a random array of strings inside a range
     * 
     * @param array the initial sized array
     * @param length the length of each string to generate
     * @param low the lowest possible random character
     * @param high the highest possible random character
     * @return a random array of strings inside a range
     */
    public static String[] random(String array[], int length, 
                                    char low, char high) {
        for (int i = 0; i < array.length; i++) {
            array[i] = Calculator.random(length, low, high);
        }
        return array;
    }
    
    /**
     * Generates a random array of Booleans
     * 
     * @param length the length of the array to generate
     * @return a random array of Booleans 
     */
    public static Boolean[] randomBooleans(int length) {
        Boolean[]  a = new Boolean[length];
        for (int i = 0; i < length; i++) {
            a[i] = Calculator.random();
        }
        return a;
    }
    
    /**
     * Generates a random array of integers between 0 and the array length
     * 
     * @param length the length of the array to generate
     * @return a random array of integers 
     */
    public static Integer[] randomIntegers(int length) {
        Integer[]  a = new Integer[length];
        for (int i = 0; i < length; i++) {
            a[i] = Calculator.random(0, length);
        }
        return a;
    }
        
    /**
     * Generates a random array of doubles between 0 and the array length
     * 
     * @param length the length of the array to generate
     * @return a random array of doubles 
     */
    public static Double[] randomDoubles(int length) {
        Double[]  a = new Double[length];
        for (int i = 0; i < length; i++) {
            a[i] = Calculator.random(0d, (double)length);
        }
        return a;
    }
    
    /**
     * Generates a random array of Characters between 'a' and 'z'
     * 
     * @param length the length of the array to generate
     * @return a random array of Characters 
     */
    public static Character[] randomCharacters(int length) {
        Character[]  a = new Character[length];
        for (int i = 0; i < length; i++) {
            a[i] = Calculator.random('a','z');
        }
        return a;
    }
    
    /**
     * Generates a random array of strings with words randomly generated 
     * between 'a' and 'z'
     * 
     * @param arrayLength the length of the array to generate
     * @param wordLength the length of each string to generate
     * @return a random array of strings 
     */
    public static String[] randomStrings(int arrayLength, int wordLength) {
        String[]  a = new String[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            a[i] = Calculator.random(wordLength,'a','z');
        }
        return a;
    }  

    /**
     * Generates a random array of integers inside a range
     * 
     * @param size the size of the array to generate
     * @param low the lowest possible random number
     * @param high the highest possible random number
     * @return a random array of integers inside a range
     */
    public static Integer[] randomIntegers(int size, int low, int high) {
        Integer[] array = new Integer[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = Calculator.random(low, high);
        }
        return array;
    }
    
    /**
     * Generates a random array of Doubles inside a range
     * 
     * @param size the size of the array to generate
     * @param low the lowest possible random number
     * @param high the highest possible random number
     * @return a random array of Doubles inside a range
     */
    public static Double[] randomDoubles(int size, double low, double high) {
        Double[] array = new Double[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = Calculator.random(low, high);
        }
        return array;
    }

    /**
     * Generates a random array of Characters inside a range
     * 
     * @param size the size of the array to generate
     * @param low the lowest possible random character
     * @param high the highest possible random character
     * @return a random array of Characters inside a range
     */
    public static Character[] randomCharacters(int size, char low, char high) {
        Character[] array = new Character[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = Calculator.random(low, high);
        }
        return array;
    }

    /**
     * Generates a random array of Strings inside a range
     * 
     * @param arrayLength the size of the array to generate
     * @param wordLength the length of each string to generate    * 
     * @param low the lowest possible random character
     * @param high the highest possible random character
     * @return a random array of Strings inside a range
     */
    public static String[] randomStrings(int arrayLength, 
                                           int wordLength, 
                                           char low, 
                                           char high) {
        String[] array = new String[arrayLength];
        for (int i = 0; i < array.length; i++) {
            array[i] = Calculator.random(wordLength, low, high);
        }
        return array;
    }
    
    /**
     * Generates a random array of Strings (size 5)
     * 
     * @param arrayLength the size of the array to generate
     */
    public static String[] randomStrings(int arrayLength) {
        String[] array = new String[arrayLength];
        for (int i = 0; i < array.length; i++) {
            array[i] = Calculator.random(5);
        }
        return array;
    }
        
    /**
     * Generates a random LinkedList of Booleans
     * 
     * @param size the size of the list to generate
     * @return a random LinkedList of Booleans
     */
    public static LinkedList<Boolean> randomBooleansList(int size) {
        LinkedList<Boolean> list = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            list.add(Calculator.random());
        }
        return list;
    }
        
    /**
     * Generates a random LinkedList of integers inside a range
     * 
     * @param size the size of the list to generate
     * @param low the lowest possible random number
     * @param high the highest possible random number
     * @return a random LinkedList of integers inside a range
     */
    public static LinkedList<Integer> randomIntegersList(int size, 
                                                           int low, 
                                                           int high) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            list.add(Calculator.random(low, high));
        }
        return list;
    }
        
    /**
     * Generates a random LinkedList of Doubles inside a range
     * 
     * @param size the size of the list to generate
     * @param low the lowest possible random number
     * @param high the highest possible random number
     * @return a random LinkedList of Doubles inside a range
     */
    public static LinkedList<Double> randomDoublesList(int size, 
                                                           double low, 
                                                           double high) {
        LinkedList<Double> list = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            list.add(Calculator.random(low, high));
        }
        return list;
    }
    
    /**
     * Generates a random LinkedList of Characters inside a range
     * 
     * @param size the size of the list to generate
     * @param low the lowest possible random character
     * @param high the highest possible random character
     * @return a random LinkedList of Characters inside a range
     */
    public static LinkedList<Character> randomCharactersList(int size, 
                                                           char low, 
                                                           char high) {
        LinkedList<Character> list = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            list.add(Calculator.random(low, high));
        }
        return list;
    }
        
    /**
     * Generates a random LinkedList of Strings inside a range
     * 
     * @param listLength the size of the array to generate
     * @param wordLength the length of each string to generate    * 
     * @param low the lowest possible random character
     * @param high the highest possible random character
     * @return a random LinkedList of Strings inside a range
     */
    public static LinkedList<String> randomStringsList(int listLength, 
                                           int wordLength, 
                                           char low, 
                                           char high) {
        LinkedList<String> list = new LinkedList<>();
        for (int i = 0; i < listLength; i++) {
            list.add(Calculator.random(wordLength, low, high));
        }
        return list;
    }
       
    
    /**
     * Generates a random LinkedList of integers 
     * 
     * @param size the size of the list to generate
     */
    public static LinkedList<Integer> randomIntegersList(int size) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            list.add(Calculator.random(-size, size));
        }
        return list;
    }
        
    /**
     * Generates a random LinkedList of Doubles 
     * 
     * @param size the size of the list to generate
     */
    public static LinkedList<Double> randomDoublesList(int size) {
        LinkedList<Double> list = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            list.add(Calculator.random((double)-size, (double)size));
        }
        return list;
    }
    
    /**
     * Generates a random LinkedList of Characters
     * 
     * @param size the size of the list to generate
     */
    public static LinkedList<Character> randomCharactersList(int size) {
        LinkedList<Character> list = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            list.add(Calculator.random('a','z'));
        }
        return list;
    }
        
    /**
     * Generates a random LinkedList of Strings inside a range
     * 
     * @param size the size of the array to generate
     */
    public static LinkedList<String> randomStringsList(int size) {
        LinkedList<String> list = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            list.add(Calculator.random(size));
        }
        return list;
    }
     
    /**
     * Generates a random Athlete object
     * 
     * @return a random Athlete object
     */
    public static Athlete randomAthlete() {
        String  name    = Calculator.random(5);
        int     age     = Calculator.random(15, 19);
        boolean isMale  = Calculator.random();
        int     number  = Calculator.random(100, 999);
        Athlete athlete = new Athlete(name, age, isMale, number);
        return athlete;
    }
        
    /**
     * Generates a random array of Athletes 
     * 
     * @param size the size of the list to generate
     */
    public static Athlete[] randomAthletes(int size) {
        Athlete[] array = new Athlete[size];
        for (int i = 0; i < array.length; i++) {
            String  name    = Calculator.random(5);
            int     age     = Calculator.random(15, 19);
            boolean isMale  = Calculator.random();
            int     number  = Calculator.random(100, 999);
            Athlete athlete = new Athlete(name, age, isMale, number);
            array[i] = athlete;            
        }        
        return array;
    }

    /**
     * Generates a random LinkedList of Athletes 
     * 
     * @param size the size of the array to generate
     */
    public static LinkedList<Athlete> randomAthleteList(int size) {
        LinkedList<Athlete> list = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            String  name    = Calculator.random(5);
            int     age     = Calculator.random(15, 19);
            boolean isMale  = Calculator.random();
            int     number  = Calculator.random(100, 999);
            Athlete athlete = new Athlete(name, age, isMale, number);
            list.add(athlete);           
        }        
        return list;
    }
    
}