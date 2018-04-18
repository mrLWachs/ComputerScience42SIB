
/** required package class namespace */
package testing.cs40s;

import numbers.Random;
import collections.LinkedList;
import collections.Node;
import io.Output;

/**
 * CollectionsTest.java - description here...
 *
 * @author lawrence.wachs 
 * @since Nov 7, 2017 
 * @instructor Mr. Wachs
 */
class CollectionsTest 
{

    /** 
     * Default constructor for the class 
     */
    public CollectionsTest() {
        Output.header("Collections unit test",true,false);        
        Output.comment("create sample nodes");
        Node<Integer> a = new Node<>();
        Node<Integer> b = new Node<>();
        Node<Integer> c = new Node<>();
        Output.comment("assign nodes data and 'link' them");
        a.data = new Integer("10");
        b.data = new Integer(20);
        c.data = 30;        
        a.next = b;
        b.previous = a;
        Output.comment("create a node with premade data and links");
        Node<Integer> d = new Node<>(40,a,c);
        Output.comment("create a linked list");
        LinkedList<String> list = new LinkedList<>();
        Output.comment("display it (empty)");
        Output.show(list);
        Output.comment("add data to front and back");
        list.addFront("dog");   // list = dog
        list.addFront("snake"); // list = snake -> dog
        list.addBack("bear");   // list = snake -> dog -> bear        
        list.addFront(null);    // should not add
        Output.comment("display current list");
        Output.show(list);
        Output.comment("create a second clone list");
        LinkedList<String> list2 = list.clone();
        Output.comment("display it (should be copy)");
        Output.show(list2);
        Output.comment("check if the lists are equal (they should be)");
        if (list.equals(list2)) {
            Output.show("equal");
        }
        else {
            Output.show("not equal");
        }        
        Output.comment("now mutate the clone list");
        list2.addBack("frog");
        Output.comment("and display both (clone should now be different)");
        Output.show(list);
        Output.show(list2);
        Output.comment("check if the lists are equal (they should not be)");
        if (list.equals(list2)) {
            Output.show("equal");
        }
        else {
            Output.show("not equal");
        }
        Output.comment("mutate a location in the list");
        list.set(1, "alligator");   
        Output.comment("access a location in the list");
        String item = list.get(2);
        Output.comment("display access/mutator results");
        Output.show(list);       
        Output.show(item);
        Output.comment("add items to both lists");
        list.addBack("chipmunk");
        list.addFront("potato");
        list.addBack("alligator");
        list2.addBack("chipmunk");
        list2.addFront("potato");
        list2.addBack("alligator");
        Output.comment("display both list");
        Output.show(list);
        Output.show(list2);
        Output.comment("now remove items from clone list");
        for (int i = 0; i < 10; i++) {
            list2.removeBack();
            Output.show(list2);
        }
        Output.comment("add item into the list (middle)");
        list.addBefore("Chicken", 3);
        Output.comment("display results");
        Output.show(list);        
        Output.comment("remove index 2 and see it's contents");
        String value = list.remove(2);
        Output.show(value);
        String itemTofind = "Chicken";
        Output.comment("adding '" + itemTofind + "' to the front");
        list.addFront(itemTofind);
        Output.comment("Showing modified list");
        Output.show(list);        
        Output.comment("Searching for last spot of '" + itemTofind + 
                "' in the list");                
        int result = list.lastIndexOf(itemTofind);        
        if (result != LinkedList.NOT_FOUND) {
            Output.show(itemTofind + " Found at " + result);
        }
        else {
            Output.show(itemTofind + " Not found!");
        }        
        Output.comment("Add " + itemTofind + " a few more times");
        list.addBack(itemTofind);
        list.addBefore(itemTofind, 2);
        Output.show(list);
        Output.comment("Remove first occurance of " + itemTofind);
        list.remove(itemTofind);        
        Output.show(list);
        Output.comment("Remove last occurance of " + itemTofind);
        list.removeLast(itemTofind);        
        Output.show(list);
        Output.comment("Remove all occurances of " + itemTofind);
        list.removeAll(itemTofind);        
        Output.show(list);        
        Output.comment("Add a few more items to the list, and show");
        list.addAfter("chicken", 2);
        list.addBefore("cat", 2);
        list.add("dog");
        list.add("rat", 2);
        list.addBack("bear");
        list.addFront("alligator");
        Output.show(list);
        Output.comment("Create an array of items");
        String[] items = {"chicken","bear","alligator"};
        Output.comment("now see if the list contains all the items");
        if (!list.containsAll(items)) {
            Output.show("All items are not in the list");
        }
        else {
            Output.show("All items ARE in the list");
        }        
        Output.comment("Clear the list and show");
        list.clear();
        Output.show(list);        
        Output.comment("Rebuild the list, and show");
        list.add("Joe");        
        list.add("Magneto");
        list.add("DrDoom");
        list.add("Voldemort");
        list.add("Mandarin");
        list.add("Ultron");
        list.add("Thanos");
        Output.show(list);
        Output.comment("Create a different list, and show");
        LinkedList<String> heroes = new LinkedList<>();
        heroes.add("Batman");
        heroes.add("Spiderman");
        heroes.add("Thing");
        heroes.add("Vibe");
        heroes.add("Flash");
        Output.show(heroes);
        Output.comment("Now append new list to first list, and show");
        list.addAll(heroes,3);
        Output.show(list);        
        Output.comment("Pull a sub-list from the main list, and show");
        LinkedList<String> sub = list.subList(2,6);
        Output.show(sub);        
        Output.comment("Create a new array and turn the list into that");
        String[] cats = {"fluffy","spot","whiskers","garfield"};
        list.fromArray(cats);
        Output.show(list);        
        Output.comment("Turn the list from another list");
        list.fromLinkedList(heroes);
        Output.show(list);        
        Output.comment("Test constructors that do those same two things");
        LinkedList<String> newList1 = new LinkedList<>(cats);
        LinkedList<String> newList2 = new LinkedList<>(heroes);
        Output.show(newList1);
        Output.show(newList2);        
        Output.comment("Turn the list into an array, and show array");
        String[] array = new String[0];
        array = list.toArray(array);
        Output.show(showArray(array));                 
        final int MAX = 50;
        Output.comment("Now build a new character list with " + 
                MAX + " random chars in it, and show");
        LinkedList<Character> letters = new LinkedList<>();
        for (int i = 0; i < MAX; i++) {
            char character = Random.generate('A','Z');
            letters.add(character);            
        }
        Output.show(letters);        
        Character letter = Random.generate('A','Z');
        Output.comment("Now find all the indices of " + letter);
        int locations[] = letters.allIndices(letter);
        Integer[] indices = new Integer[locations.length];
        for (int i = 0; i < indices.length; i++) {
            indices[i] = locations[i];
        }
        Output.show(showArray(indices)); 
        Output.header("Collections unit test",false,false);
    }

    private<T> String showArray(T[] array) {
        String output = "Array = {";
        for (int i = 0; i < array.length - 1; i++) {
            output += array[i] + ",";
        }
        output += array[array.length - 1] + "}";
        return output;
    }
    
    
}
