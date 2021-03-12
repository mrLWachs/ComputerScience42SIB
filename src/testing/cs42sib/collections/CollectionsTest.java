
/** Required package class namespace */
package testing.cs42sib.collections;

/** Required imports */
import io.Simulator;
import tools.Text;

/**
 * CollectionsTest.java - tests the concepts learned in this unit
 *
 * @author Mr. Wachs
 * @since March 2, 2021
 */
public class CollectionsTest 
{

    /**
     * Default constructor, set class properties
     */
    public CollectionsTest() {
        Simulator.header("Collections Test started...");
        
        // Create a node and change (mutate) its data..........................
        Simulator.comment("Create a node and change (mutate) its data");
        
        Node<String> a = new Node<>();
        a.data = "Hello";        
        
        // Create more nodes and the "links" between them......................
        Simulator.comment("Create more nodes and the 'links' between them");
        
        Node<String> b = new Node<>("Good-bye");        
        Node<String> c = new Node<>("Exist",a);
        
        // Use a 'double reference' to mutate data.............................
        Simulator.comment("Use a 'double reference' to mutate data ");
        
        c.next.data = "Hi";
        
        // Create a node connected to the other nodes..........................
        Simulator.comment("Create a node connected to the other nodes");
        
        Node<String> d = new Node<>("Die",b,c);
        d.previous.next.data = "WhatSup";
        
        // Output all nodes using overloaded toString method...................
        Simulator.comment("Output all nodes using overloaded toString method");
        
        System.out.println("Node a = " + a.toString());
        System.out.println("Node b = " + b.toString());
        System.out.println("Node c = " + c.toString());
        System.out.println("Node d = " + d.toString());
        
        // Test the clone method on various nodes..............................
        Simulator.comment("Test the clone method on various nodes...");
        
        Node e = d.clone();
        Node f = c.clone();
        Node g = b.clone();
        Node h = a.clone();
        
        System.out.println("Node e = " + e.toString());
        System.out.println("Node f = " + f.toString());
        System.out.println("Node g = " + g.toString());
        System.out.println("Node h = " + h.toString());
        
        // Test equals method on various nodes.................................
        Simulator.comment("Test equals method on various nodes....");
        
        System.out.println("a==h -> " + a.equals(h));
        System.out.println("b==g -> " + b.equals(g));
        System.out.println("c==f -> " + c.equals(f));
        System.out.println("d==e -> " + d.equals(e));
        
        System.out.println("a==b -> " + a.equals(b));
        System.out.println("b==c -> " + b.equals(c));
        System.out.println("c==d -> " + c.equals(d));
        System.out.println("d==h -> " + d.equals(h));
        
        // Test finalize method on various nodes...............................
        Simulator.comment("Test finalize method on various nodes....");
        
        a.finalize();        
        b.finalize();        
        c.finalize();        
        d.finalize();        
        e.finalize();        
        f.finalize();        
        g.finalize();        
        h.finalize();        
        
        System.out.println("Node a = " + a.toString());
        System.out.println("Node b = " + b.toString());
        System.out.println("Node c = " + c.toString());
        System.out.println("Node d = " + d.toString());
        System.out.println("Node e = " + e.toString());
        System.out.println("Node f = " + f.toString());
        System.out.println("Node g = " + g.toString());
        System.out.println("Node h = " + h.toString());
        
        // Create (instatitate) a LinkedList object............................
        Simulator.comment("Create (instatitate) a LinkedList object...");
        
        LinkedList<String> list = new LinkedList<>();
        
        // Test is the size, isEmpty, and toString methods.....................
        Simulator.comment("Test is the size, isEmpty, and toString methods...");
        
        System.out.println("Size     = " + list.size());
        System.out.println("Is empty = " + list.isEmpty());
        System.out.println(list.toString());
        
        // Add content to the front............................................
        Simulator.comment("Add content to the front...");
        
        System.out.println(list.addBack("Hulk"));
        System.out.println(list.toString());
        System.out.println(list.addFront("Thor"));
        System.out.println(list.toString());
        System.out.println(list.addFront("CaptainAmerica"));
        System.out.println(list.toString());
        System.out.println(list.addFront("IronMan"));
        System.out.println(list.toString());
        System.out.println(list.addFront(null));
        System.out.println(list.toString());
        
        // Add content to the back.............................................
        Simulator.comment("Add content to the back...");
        
        System.out.println(list.addBack("Hulk"));
        System.out.println(list.toString());
        System.out.println(list.addBack("Hawkeye"));
        System.out.println(list.toString());
        System.out.println(list.addBack("BlackWidow"));
        System.out.println(list.toString());
        System.out.println(list.addBack("Hulk"));
        System.out.println(list.toString());
        System.out.println(list.addBack("SpiderMan"));
        System.out.println(list.toString());        
        System.out.println(list.addBack(null));
        System.out.println(list.toString());
        
        // Re-test is the size and isEmpty methods................................
        Simulator.comment("Re-test is the size and isEmpty methods...");
        
        System.out.println("Size     = " + list.size());
        System.out.println("Is empty = " + list.isEmpty());
        
        // Variables to track the front (start) and back (end) edges...........
        Simulator.comment("Variables to track the edges...");
        
        int start  = 0;
        int end    = list.size() - 1;        
        int before = start - 1;
        int after  = end   + 1;
        
        // Test our get ("accessor") method....................................     
        Simulator.comment("Test our get (accessor) method...");
        
        for (int i = before; i <= after; i++) {
            System.out.println("index " + i + " = " + list.get(i));
        }
        System.out.println(list.toString());
                
        // Test our clone method.....................................
        Simulator.comment("Test our clone method...");
        
        LinkedList<String> clone = list.clone();
        System.out.println(clone.toString());    
        
        // Test our set ("mutator") method.....................................
        Simulator.comment("Test our set (mutator) method...");
        
        for (int i = before; i <= after; i++) {
            System.out.println(clone.set(i, "Vision"));
        }
        System.out.println(clone.set(1, null));        
        System.out.println(clone.toString());
        
        // Test our remove front method........................................
        Simulator.comment("Re-clone list, then...");
        clone = list.clone();
        System.out.println(clone.toString());
        Simulator.comment("Test our remove front method...");
        
        for (int i = before; i <= after; i++) {
            System.out.println(clone.toString() + "\t" + clone.removeFront());
        }
                
        // Test our remove back method.........................................
        Simulator.comment("Re-clone list, then...");
        clone = list.clone();
        System.out.println(clone.toString());
        Simulator.comment("Test our remove back method...");
        
        for (int i = before; i <= after; i++) {
            System.out.println(clone.toString() + "\t" + clone.removeBack());
        }
        
        // Test our contains method............................................
        Simulator.comment("Test our contains method...");
        
        // First index (Captain America)...
        Simulator.comment("First index (CaptainAmerica)...");
        System.out.println(list + "\t" + list.contains("CaptainAmerica"));        
        // Last index (Spider-man)...
        Simulator.comment("Last index (SpiderMan)...");
        System.out.println(list + "\t" + list.contains("SpiderMan"));        
        // Not in list (Batman)...
        Simulator.comment("Not in list (Batman)...");
        System.out.println(list + "\t" + list.contains("Batman"));        
        // Multiple times in list (Hulk)...
        Simulator.comment("Multiple times in list (Hulk)...");
        System.out.println(list + "\t" + list.contains("Hulk"));        
        // null in list...
        Simulator.comment("null in list...");
        System.out.println(list + "\t" + list.contains(null));
                     
        
        // Test our add after method...........................................
        Simulator.comment("Re-clone list, then...");
        clone = list.clone();
        System.out.println(clone.toString());
        Simulator.comment("Test our add after method...");
        
        // Add after Last index: (Thanos)
        Simulator.comment("Last index: " + end + " (Thanos)");
        System.out.println(clone + "\t" + clone.addAfter("Thanos", end));
        // Add after First index: (Thanos)
        Simulator.comment("Start: " + start + " (Thanos)");
        System.out.println(clone + "\t" + clone.addAfter("Thanos", start));
        // Add after Invalid index: (Thanos)
        Simulator.comment("Invalid index: " + after + " (Thanos)");
        System.out.println(clone + "\t" + clone.addAfter("Thanos", after));        
        // Add after Index: 5 (Thanos)
        Simulator.comment("Index: 5 (Thanos)");
        System.out.println(clone + "\t" + clone.addAfter("Thanos", 5));        
        // Add after null
        Simulator.comment("null");
        System.out.println(clone + "\t" + clone.addAfter(null, 5));
        
        // Test our add before method..........................................
        Simulator.comment("Re-clone list, then...");
        clone = list.clone();
        System.out.println(clone.toString());
        Simulator.comment("Test our add before method...");
        
        // Add before Last index: 0 (Thanos)
        Simulator.comment("Last index: " + end + " (Thanos)");
        System.out.println(clone + "\t" + clone.addBefore("Thanos", end));
        // Add before First index: 0 (Thanos)
        Simulator.comment("Start: " + start + " (Thanos)");
        System.out.println(clone + "\t" + clone.addBefore("Thanos", start)); 
        // Add before Invalid index: (Thanos)
        Simulator.comment("Invalid index: " + after + " (Thanos)");
        System.out.println(clone + "\t" + clone.addBefore("Thanos", after));        
        // Add before Index: 5 (Thanos)
        Simulator.comment("Index: 5 (Thanos)");
        System.out.println(clone + "\t" + clone.addBefore("Thanos", 5));        
        // Add before null
        Simulator.comment("null");
        System.out.println(clone + "\t" + clone.addBefore(null, 5));
                                
        // Test our add method (wrapper method needs no test)..................
        Simulator.comment("Add method (wrapper method needs no testing)...");
                
        // Test Add overload (wrapper method needs no testing).................
        Simulator.comment("Add overload (wrapper method needs no testing)...");
                
        // Test our remove method..............................................
        Simulator.comment("Re-clone list, then...");
        clone = list.clone();
        System.out.println(clone.toString());
        Simulator.comment("Test our remove method...");
        
        // Removing Last
        Simulator.comment("Removing end");
        System.out.println(clone + "\t" + clone.remove(end));
        // Removing First
        Simulator.comment("Removing start");
        System.out.println(clone + "\t" + clone.remove(start));        
        // Removing index 4
        Simulator.comment("Removing index 4");
        System.out.println(clone + "\t" + clone.remove(4));
        // Removing Before First
        Simulator.comment("Removing before");
        System.out.println(clone + "\t" + clone.remove(before));
        // Removing After Last
        Simulator.comment("Removing after");
        System.out.println(clone + "\t" + clone.remove(after));
        
        // Create an empty list................................................
        Simulator.comment("Create an empty list...");
        
        LinkedList<String> empty = new LinkedList<>();
        System.out.println(empty);
        System.out.println(list);
        
        // Test our first index of method......................................
        Simulator.comment("Test our first index of method...");
        
        // Of an empty list (Hulk)
        Simulator.comment("Of an empty list (Hulk)");
        System.out.println(empty.firstIndexOf("Hulk"));        
        // Of existing list (Hulk)
        Simulator.comment("Of existing list (Hulk)");
        System.out.println(list.firstIndexOf("Hulk"));
                
        // Test our last index of method.......................................
        Simulator.comment("Test our last index of method...");
        
        System.out.println(empty);
        System.out.println(list);
        // Of an empty list (Hulk)
        Simulator.comment("Of an empty list (Hulk)");
        System.out.println(empty.lastIndexOf("Hulk"));        
        // Of existing list (Hulk)
        Simulator.comment("Of existing list (Hulk)");
        System.out.println(list.lastIndexOf("Hulk"));
        
        // Test our all indices method.........................................
        Simulator.comment("Test our all indices method...");
        
        // Create array for results and text object for outputs
        Simulator.comment("Create results array and text object for outputs");
        int[] results = new int[1];
        Text text = new Text();
        String value = "";
        
        // On empty list    
        Simulator.comment("On empty list");
        results = empty.allIndices("Hulk");
        value = text.toString(results);        
        System.out.println(empty + "\t" + "Hulk \t" + value);        
        // On existing list with many occurences
        Simulator.comment("On existing list with many occurences");
        results = list.allIndices("Hulk");
        value = text.toString(results);
        System.out.println(list + "\t" + "Hulk \t" + value);        
        // On existing list with one occurences
        Simulator.comment("On existing list with one occurences");
        results = list.allIndices("Hawkeye");
        value = text.toString(results);
        System.out.println(list + "\t" + "Hawkeye \t" + value);
        // On existing list with no occurences
        Simulator.comment("On existing list with one occurences");
        results = list.allIndices("Batman");
        value = text.toString(results);
        System.out.println(list + "\t" + "Batman \t" + value);
                
        // Test our remove method..............................................
        Simulator.comment("Re-clone list, then...");
        clone = list.clone();
        System.out.println(clone.toString());
        Simulator.comment("Test our remove method...");
        
        // Remove one occurance (Hawkeye)
        Simulator.comment("Remove one occurance (Hawkeye)");
        System.out.println(clone + "\t" + clone.remove("Hawkeye"));
        // Remove multiple occurances (Hulk)
        Simulator.comment("Remove multiple occurances (Hulk)");
        System.out.println(clone + "\t" + clone.remove("Hulk"));
        // Remove multiple occurances (Hulk)
        Simulator.comment("Remove no occurances (Batman)");
        System.out.println(clone + "\t" + clone.remove("Batman"));
                
        // Test our remove last method.........................................
        Simulator.comment("Re-clone list, then...");
        clone = list.clone();
        System.out.println(clone.toString());
        Simulator.comment("Test our remove last method...");
        
        // Remove one occurance (Hawkeye)
        Simulator.comment("Remove one occurance (Hawkeye)");
        System.out.println(clone + "\t" + clone.removeLast("Hawkeye"));
        // Remove multiple occurances (Hulk)
        Simulator.comment("Remove multiple occurances (Hulk)");
        System.out.println(clone + "\t" + clone.removeLast("Hulk"));
        // Remove multiple occurances (Hulk)
        Simulator.comment("Remove no occurances (Batman)");
        System.out.println(clone + "\t" + clone.removeLast("Batman"));
        
        // Test our remove all method..........................................
        Simulator.comment("Re-clone list, then...");
        clone = list.clone();
        System.out.println(clone.toString());
        Simulator.comment("Test our remove all method...");
        
        // Remove one occurance (Hawkeye)
        Simulator.comment("Remove one occurance (Hawkeye)");
        System.out.println(clone + "\t" + clone.removeAll("Hawkeye"));
        // Remove multiple occurances (Hulk)
        Simulator.comment("Remove multiple occurances (Hulk)");
        System.out.println(clone + "\t" + clone.removeAll("Hulk"));
        // Remove multiple occurances (Hulk)
        Simulator.comment("Remove no occurances (Batman)");
        System.out.println(clone + "\t" + clone.removeAll("Batman"));
             
        // Test our remove all (array) method..................................
        Simulator.comment("Re-clone list, then...");
        clone = list.clone();
        System.out.println(clone.toString());
        Simulator.comment("Test our remove all (array) method...");
          
        // Create an array to remove from the list.............................
        Simulator.comment("Create an array to remove from the list...");
        String[] removeItems = {
            "Hawkeye",
            "Hulk",
            "Batman"
        };
        value = text.toString(removeItems);
        System.out.println(value);
        
        // Create null and empty arrays to use.................................
        Simulator.comment("Create null and empty arrays to use");
        String[] nullArray = null;
        String[] emptyArray = new String[0];
        
        Simulator.comment("Remove null array");
        System.out.println(clone.removeAll(nullArray) + "\t" + clone);        
        Simulator.comment("Remove empty array");
        System.out.println(clone.removeAll(emptyArray) + "\t" + clone);        
        Simulator.comment("Remove array");
        System.out.println(clone.removeAll(removeItems) + "\t" + clone);
        
        // Test our remove all (list) method...................................
        Simulator.comment("Re-clone list, then...");
        clone = list.clone();
        System.out.println(clone.toString());
        Simulator.comment("Test our remove all (list) method...");
        
        // Create a list to remove from the list.............................
        Simulator.comment("Create a list to remove from the list...");
        LinkedList<String> removeItemsList = new LinkedList<>();
        removeItemsList.add("Hawkeye");
        removeItemsList.add("Hulk");
        removeItemsList.add("Batman");
        
        // Create null and empty lists to use.................................
        Simulator.comment("Create null and empty arrays to use");
        LinkedList<String> nullList = null;
        LinkedList<String> emptyList = new LinkedList<>();
        
        Simulator.comment("Remove null list");
        System.out.println(clone.removeAll(nullList) + "\t" + clone);        
        Simulator.comment("Remove empty list");
        System.out.println(clone.removeAll(emptyList) + "\t" + clone);        
        Simulator.comment("Remove list");
        System.out.println(clone.removeAll(removeItemsList) + "\t" + clone);
        
        // Test our clear method...............................................
        Simulator.comment("Re-clone list, then...");
        clone = list.clone();
        System.out.println(clone.toString());
        Simulator.comment("Test our clear method...");        
        
        Simulator.comment("Clear a empty list");
        emptyList.clear();
        System.out.println(emptyList);
        Simulator.comment("Clear list");
        clone.clear();
        System.out.println(clone);

        // Build array where all items are in list.............................
        Simulator.comment("Build array where all items are in list...");
        String[] allArrayItems = {
            "Hawkeye",
            "IronMan",
            "SpiderMan"
        };
        value = text.toString(allArrayItems);
        System.out.println(value);

        // Test our contains all (array) method.................................
        Simulator.comment("Re-clone list, then...");
        clone = list.clone();
        System.out.println(clone.toString());
        Simulator.comment("Test our contains all (array) method...");
        
        Simulator.comment("Check for contains with null array");
        System.out.println(clone.containsAll(nullArray) + "\t" + clone);        
        Simulator.comment("Check for contains with empty array");
        System.out.println(clone.containsAll(emptyArray) + "\t" + clone);                 
        Simulator.comment("Check for contains with array with items not in");
        System.out.println(clone.containsAll(removeItems) + "\t" + clone);        
        Simulator.comment("Check for contains with array with all items in");
        System.out.println(clone.containsAll(allArrayItems) + "\t" + clone);

        // Build array where all items are in list.............................
        Simulator.comment("Build list where all items are in list...");
        LinkedList<String> allListItems = new LinkedList<>();
        allListItems.add("Hawkeye");
        allListItems.add("IronMan");
        allListItems.add("SpiderMan");
        System.out.println(allListItems);

        // Test our contains all (list) method..................................
        Simulator.comment("Re-clone list, then...");
        clone = list.clone();
        System.out.println(clone.toString());
        Simulator.comment("Test our contains all (list) method...");
        
        Simulator.comment("Check for contains with null list");
        System.out.println(clone.containsAll(nullList) + "\t" + clone);        
        Simulator.comment("Check for contains with empty list");
        System.out.println(clone.containsAll(emptyList) + "\t" + clone);                 
        Simulator.comment("Check for contains with list with items not in");
        System.out.println(clone.containsAll(removeItemsList) + "\t" + clone);        
        Simulator.comment("Check for contains with list with all items in");
        System.out.println(clone.containsAll(allListItems) + "\t" + clone);
        
        // Test our add all (list) method......................................
        Simulator.comment("Re-clone list, then...");
        clone = list.clone();
        System.out.println(clone.toString());
        Simulator.comment("Test our add all (list) method...");
        
        System.out.println("Before: " + clone);
        Simulator.comment("Add all with null list");
        clone.addAll(nullList);
        System.out.println(clone);        
        Simulator.comment("Add all with empty list");
        clone.addAll(emptyList);
        System.out.println(clone);         
        Simulator.comment("Add all with list");
        clone.addAll(allListItems);
        System.out.println(clone); 

        // Test our add all (list, index) method...............................
        Simulator.comment("Re-clone list, then...");
        clone = list.clone();
        System.out.println(clone.toString());
        Simulator.comment("Test our add all (list,index) method...");
        
        System.out.println("Before: " + clone);
        Simulator.comment("Add all (3) with null list");
        clone.addAll(nullList);
        System.out.println(clone);        
        Simulator.comment("Add all (3) with empty list");
        clone.addAll(emptyList);
        System.out.println(clone);         
        Simulator.comment("Add all (3) with list");
        clone.addAll(allListItems,3);
        System.out.println(clone);         
        Simulator.comment("Add all (before) with list");
        clone.addAll(allListItems,before);
        System.out.println(clone);    
        Simulator.comment("Add all (after) with list");
        clone.addAll(allListItems,after);
        System.out.println(clone);         
        Simulator.comment("Add all (start) with list");
        clone.addAll(allListItems,start);
        System.out.println(clone);         
        Simulator.comment("Add all (end) with list");
        clone.addAll(allListItems,end);
        System.out.println(clone); 
        
        // Test our add all (array) method......................................
        Simulator.comment("Re-clone array, then...");
        clone = list.clone();
        System.out.println(clone.toString());
        Simulator.comment("Test our add all (array) method...");
        
        System.out.println("Before: " + clone);
        Simulator.comment("Add all with null array");
        clone.addAll(nullArray);
        System.out.println(clone);        
        Simulator.comment("Add all with empty array");
        clone.addAll(emptyArray);
        System.out.println(clone);         
        Simulator.comment("Add all with array");
        clone.addAll(allArrayItems);
        System.out.println(clone); 
        
        // Test our add all (array, index) method...............................
        Simulator.comment("Re-clone list, then...");
        clone = list.clone();
        System.out.println(clone.toString());
        Simulator.comment("Test our add all (array,index) method...");
        
        System.out.println("Before: " + clone);
        Simulator.comment("Add all (3) with null array");
        clone.addAll(nullArray);
        System.out.println(clone);        
        Simulator.comment("Add all (3) with empty array");
        clone.addAll(emptyArray);
        System.out.println(clone);         
        Simulator.comment("Add all (3) with array");
        clone.addAll(allArrayItems,3);
        System.out.println(clone);         
        Simulator.comment("Add all (before) with array");
        clone.addAll(allArrayItems,before);
        System.out.println(clone);    
        Simulator.comment("Add all (after) with array");
        clone.addAll(allArrayItems,after);
        System.out.println(clone);         
        Simulator.comment("Add all (start) with array");
        clone.addAll(allArrayItems,start);
        System.out.println(clone);         
        Simulator.comment("Add all (end) with array");
        clone.addAll(allArrayItems,end);
        System.out.println(clone); 
        
        // Test our sublist method.............................................
        Simulator.comment("Re-clone list, then...");
        clone = list.clone();
        System.out.println(clone.toString());
        Simulator.comment("Test our sublist method...");
        
        LinkedList<String> subList = new LinkedList<>();        
        Simulator.comment("Getting sublist from start to end of list");
        subList = clone.subList(start, end);
        System.out.println(list + "\t" + subList);        
        Simulator.comment("Getting sublist from before to after of list");
        subList = clone.subList(before, after);
        System.out.println(list + "\t" + subList);        
        Simulator.comment("Getting sublist from start to 0 of list");
        subList = clone.subList(start, 0);
        System.out.println(list + "\t" + subList);        
        Simulator.comment("Getting sublist from start to 1 of list");
        subList = clone.subList(start, 1);
        System.out.println(list + "\t" + subList);        
        Simulator.comment("Getting sublist from end-1 to end of list");
        subList = clone.subList(end-1, end);
        System.out.println(list + "\t" + subList);        
        Simulator.comment("Getting sublist from end to end of list");
        subList = clone.subList(end, end);
        System.out.println(list + "\t" + subList);        
        Simulator.comment("Getting sublist from start+1 to end-1 of list");
        subList = clone.subList(start+1, end-1);
        System.out.println(list + "\t" + subList);        
        Simulator.comment("Getting sublist from 2 to 5 of list");
        subList = clone.subList(2, 5);
        System.out.println(list + "\t" + subList);        
        Simulator.comment("Getting sublist from 5 to 2 of list");
        subList = clone.subList(5, 2);
        System.out.println(list + "\t" + subList);        
        Simulator.comment("Getting sublist from 2 to 5 of empty list");
        subList = emptyList.subList(2, 5);
        System.out.println(emptyList + "\t" + subList);
        
        // Test our from array method..........................................
        Simulator.comment("Re-clone list, then...");
        clone = list.clone();
        System.out.println(clone.toString());
        Simulator.comment("Test our from array method...");
        
        Simulator.comment("Rebuild list from null array");
        clone.fromArray(nullArray);
        System.out.println(clone);
        Simulator.comment("Rebuild list from array");
        clone.fromArray(allArrayItems);
        System.out.println(clone);
        
        // Test our from linked list method....................................
        Simulator.comment("Re-clone list, then...");
        clone = list.clone();
        System.out.println(clone.toString());
        Simulator.comment("Test our linked list method...");
        
        Simulator.comment("Rebuild list from null list");
        clone.fromLinkedList(nullList);
        System.out.println(clone);
        Simulator.comment("Rebuild list from list");
        clone.fromLinkedList(list);
        System.out.println(clone);

        // Test our to array method............................................
        Simulator.comment("Re-clone list, then...");
        clone = list.clone();
        System.out.println(clone.toString());
        Simulator.comment("Test our to array method...");
        
        Simulator.comment("Create array from list");
        allArrayItems = clone.toArray(emptyArray);
        value = text.toString(allArrayItems);
        System.out.println(clone + "\tArray: " + value);
        
        Simulator.comment("Create array from empty list");
        allArrayItems = emptyList.toArray(emptyArray);
        value = text.toString(allArrayItems);
        System.out.println(emptyList + "\tArray: " + value);
        
        // Test our array constructor..........................................
        Simulator.comment("Re-clone list, then...");
        clone = list.clone();
        System.out.println(clone.toString());
        Simulator.comment("Test our array constructor...");
        
        Simulator.comment("Constructor (wrapper method needs no testing)...");
        
        // Test our list constructor...........................................
        Simulator.comment("Re-clone list, then...");
        clone = list.clone();
        System.out.println(clone.toString());
        Simulator.comment("Test our list constructor...");
        
        Simulator.comment("Constructor (wrapper method needs no testing)...");
        
        Simulator.header("Collections Test completed!");
    }
    
}
