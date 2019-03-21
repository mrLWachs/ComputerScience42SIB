
/** required package class namespace */
package testing.cs40s.searchsort;

/** required imports */
import collections.LinkedList;
import testing.cs40s.advancedclasses.Athlete;
import tools.Searcher;
import tools.Sorter;
import io.System;
import tools.Calculator;

/**
 * SearchSortTest.java - tests the concepts learned in this unit
 *
 * @author Mr. Wachs 
 * @since 6-Feb-2019 
 */
public class SearchSortTest <T extends Comparable <T>>
{

    /**
     * Default constructor for the class, sets class properties
     */
    public SearchSortTest() {
        
        System.out.header("Searching and Sorting unit testing starting...");
        
        // create searching and sorting class objects
        Searcher searcher = new Searcher();
        Sorter   sorter   = new Sorter();
        
        // create list/array size
        final int SIZE = 10;
        
        // store searching locations
        int location = -1;
        
        // create all arrays
        Boolean[]             array1 = new Boolean[SIZE];
        Integer[]             array2 = new Integer[SIZE];
        Double[]              array3 = new Double[SIZE];
        Character[]           array4 = new Character[SIZE];
        String[]              array5 = new String[SIZE];
        Athlete[]             array6 = new Athlete[SIZE];
        
        /// create all lists
        LinkedList<Boolean>   list1  = new LinkedList<>();
        LinkedList<Integer>   list2  = new LinkedList<>();
        LinkedList<Double>    list3  = new LinkedList<>();
        LinkedList<Character> list4  = new LinkedList<>();
        LinkedList<String>    list5  = new LinkedList<>();
        LinkedList<Athlete>   list6  = new LinkedList<>();
        
        // create all items to search for
        Boolean               item1  = null;
        Integer               item2  = null;
        Double                item3  = null;
        Character             item4  = null;
        String                item5  = null;
        Athlete               item6  = null;
        
        // create array for all search items
        Object[] allItems  = {item1,item2,item3,item4,item5,item6};
        
        // create list for all arrays, and add all arrays
        LinkedList<Object[]> allArrays = new LinkedList<>();
        allArrays.add(array1);
        allArrays.add(array2);
        allArrays.add(array3);
        allArrays.add(array4);
        allArrays.add(array5);
        allArrays.add(array6);
                
        /// create list for all lists, and add all lists
        LinkedList<LinkedList> allLists = new LinkedList<>();
        allLists.add(list1);
        allLists.add(list2);
        allLists.add(list3);
        allLists.add(list4);
        allLists.add(list5);
        allLists.add(list6);
        
        // scramble arrays, lists, and search items
        scramble(allArrays, allLists, allItems, SIZE);
        
        // linear search arrays/lists
        for (int i = 0; i < allArrays.size(); i++) {
            T[] array = (T[]) allArrays.get(i);
            T   item  = (T) allItems[i];
            location  = searcher.linear(array, item); 
            results("Linear Search",array,item,location);
        }
        for (int i = 0; i < allLists.size(); i++) {
            LinkedList<T> list = allLists.get(i);
            T             item = (T) allItems[i];
            location        = searcher.linear(list,item);
            results("Linear Search",list,item,location);            
        }
        
        // bubble sort arrays/lists
        for (int i = 0; i < allArrays.size(); i++) {
            T[] array  = (T[]) allArrays.get(i);
            sorter.bubble((Comparable[]) array);
            results("Bubble Sort",array);
        }        
        for (int i = 0; i < allLists.size(); i++) {
            LinkedList list   = allLists.get(i);
            sorter.bubble((LinkedList<Comparable>) list);
            results("Bubble Sort",list);          
        } 
        
        // binary search arrays/lists
        for (int i = 0; i < allArrays.size(); i++) {
            T[] array = (T[]) allArrays.get(i);
            T   item  = (T) allItems[i];
            location       = searcher.binary(array,item);
            results("Binary Search",array,item,location);
        }        
        for (int i = 0; i < allLists.size(); i++) {
            LinkedList<T> list = allLists.get(i);
            T             item = (T) allItems[i];;
            location        = searcher.binary(list,item);
            results("Binary Search",list,item,location);          
        }
        
        // scramble arrays, lists, and search items
        scramble(allArrays, allLists, allItems, SIZE);
                
        // Selection sort arrays/lists
        for (int i = 0; i < allArrays.size(); i++) {
            T[] array  = (T[]) allArrays.get(i);
            sorter.selection((Comparable[]) array);
            results("Selection Sort",array);
        }        
        for (int i = 0; i < allLists.size(); i++) {
            LinkedList list   = allLists.get(i);
            sorter.selection((LinkedList<Comparable>) list);
            results("Selection Sort",list);          
        } 
         
        // scramble arrays, lists, and search items
        scramble(allArrays, allLists, allItems, SIZE);
                
        // Selection sort arrays/lists
        for (int i = 0; i < allArrays.size(); i++) {
            T[] array  = (T[]) allArrays.get(i);
            sorter.insertion((Comparable[]) array);
            results("Insertion Sort",array);
        }        
        for (int i = 0; i < allLists.size(); i++) {
            LinkedList list   = allLists.get(i);
            sorter.insertion((LinkedList<Comparable>) list);
            results("Insertion Sort",list);          
        } 
         
        // scramble arrays, lists, and search items
        scramble(allArrays, allLists, allItems, SIZE);
                
        // Selection sort arrays/lists
        for (int i = 0; i < allArrays.size(); i++) {
            T[] array  = (T[]) allArrays.get(i);
            sorter.shell((Comparable[]) array);
            results("Shell Sort",array);
        }        
        for (int i = 0; i < allLists.size(); i++) {
            LinkedList list   = allLists.get(i);
            sorter.shell((LinkedList<Comparable>) list);
            results("Shell Sort",list);          
        } 
         
        // scramble arrays, lists, and search items
        scramble(allArrays, allLists, allItems, SIZE);
                
        // Selection sort arrays/lists
        for (int i = 0; i < allArrays.size(); i++) {
            T[] array  = (T[]) allArrays.get(i);
            sorter.quick((Comparable[]) array);
            results("Quick Sort",array);
        }        
        for (int i = 0; i < allLists.size(); i++) {
            LinkedList list   = allLists.get(i);
            sorter.quick((LinkedList<Comparable>) list);
            results("Quick Sort",list);          
        } 
        
        System.out.header("Searching and Sorting unit testing complete!");
    }
    
    /**
     * Scrambles all lists/arrays and search items to random values
     * 
     * @param allArrays the array of all other arrays
     * @param allLists the list of all other lists
     * @param allItems the array of all search items
     * @param SIZE the size to make all the arrays/lists
     */
    private void scramble(
            LinkedList<Object[]> allArrays, 
            LinkedList<LinkedList> allLists, 
            Object[] allItems, 
            final int SIZE) {
        // randomize the arrays
        allArrays.set(0, Calculator.randomBooleans(SIZE));
        allArrays.set(1, Calculator.randomIntegers(SIZE));
        allArrays.set(2, Calculator.randomDoubles(SIZE));
        allArrays.set(3, Calculator.randomCharacters(SIZE));
        allArrays.set(4, Calculator.randomStrings(SIZE));
        allArrays.set(5, Calculator.randomAthletes(SIZE)); 
        // randomize the lists
        allLists.set(0, Calculator.randomBooleansList(SIZE));
        allLists.set(1, Calculator.randomIntegersList(SIZE));
        allLists.set(2, Calculator.randomDoublesList(SIZE));
        allLists.set(3, Calculator.randomCharactersList(SIZE));
        allLists.set(4, Calculator.randomStringsList(SIZE));
        allLists.set(5, Calculator.randomAthleteList(SIZE));        
        allItems[0] = Calculator.random();
        allItems[1] = Calculator.random(-SIZE, SIZE);
        allItems[2] = Calculator.random((double)-SIZE, (double)SIZE);
        allItems[3] = Calculator.random('a','z');
        allItems[4] = Calculator.random(5);
        allItems[5] = Calculator.randomAthlete();   
        // display the arrays and lists
        for (int i = 0; i < allArrays.size(); i++) {
            results("Created\t",allArrays.get(i));          
        }
        for (int i = 0; i < allLists.size(); i++) {
            results("Created\t",allLists.get(i));          
        }        
    }

    /**
     * Display the results of a search on an array for a item and its location
     * 
     * @param <T> the generic array type
     * @param type the search performed
     * @param array the generic array of items
     * @param item the item being searched for
     * @param location the location found (or not found)
     */
    private<T> void results(String type, T[] array, T item, int location) {   
        String text = start(type, "Array", array[0]);
        text += "Item: " + item + " location = " + location + " -> ";        
        text += contents(array);
        System.out.println(text);
    }

    /**
     * Display the results of a search on a list for a item and its location
     * 
     * @param <T> the generic list type
     * @param type the search performed
     * @param list the generic list of items
     * @param item the item being searched for
     * @param location the location found (or not found)
     */
    private void results(String type, LinkedList list, Object item, 
                         int location) {
        String text = start(type, "List", list.get(0));        
        text += "Item: " + item + " location = " + location + " -> ";          
        text += contents(list);
        System.out.println(text);
    }
    
    /**
     * Display the results of a sort on an array
     * 
     * @param <T> the generic array type
     * @param type the sort performed
     * @param array the generic array of items 
     */
    private<T> void results(String type, T[] array) {
        String text = start(type, "Array", array[0]);
        text += contents(array);
        System.out.println(text);
    }
    
    /**
     * Display the results of a sort on an list
     * 
     * @param <T> the generic list type
     * @param type the sort performed
     * @param list the generic list of items 
     */
    private void results(String type, LinkedList list) {
        String text = start(type, "List", list.get(0));
        text += contents(list);
        System.out.println(text);
    }

    /**
     * The formatted start of an output line for results
     * 
     * @param type1 the action type
     * @param type2 the list/array type
     * @param object the generic data type used 
     * @return the formatted text
     */
    private String start(String type1, String type2, Object object) {
        String classType = object.getClass().getSimpleName(); 
        String delimit   = "\t";
        if (classType.length() < 8) delimit += "\t";
        String text = type1 + "\t" + type2 + "\t" + classType + delimit;
        return text;
    }
    
    /**
     * Creates a formatted line for the array
     * 
     * @param <T> the generic data type
     * @param array the array of items
     * @return the formatted line
     */
    private<T> String contents(T[] array) {
        String text = "[";
        for (int i = 0; i < array.length-1; i++) {
            text += array[i] + ",";
        }
        text += array[array.length-1] + "]";
        return text;
    }
    
    /**
     * Creates a formatted line for the list
     * 
     * @param <T> the generic data type
     * @param list the list of items
     * @return the formatted line
     */
    private<T> String contents(LinkedList list) {
        String text = "[";
        for (int i = 0; i < list.size()-1; i++) {
            text += list.get(i) + ",";
        }
        text += list.get(list.size()-1) + "]";
        return text;
    }
    
}
