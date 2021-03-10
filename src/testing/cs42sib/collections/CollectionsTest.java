
/** Required package class namespace */
package testing.cs42sib.collections;

/** Required imports */
import io.Simulator;

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
        d.previous.next.data = "Sup";
        
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
        
        System.out.println(a.equals(h));
        System.out.println(b.equals(g));
        System.out.println(c.equals(f));
        System.out.println(d.equals(e));
        
        System.out.println(a.equals(b));
        System.out.println(b.equals(c));
        System.out.println(c.equals(d));
        System.out.println(d.equals(h));
        
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
        
        LinkedList<String> list1 = new LinkedList<>();
        
        // Test is the size and isEmpty methods................................
        Simulator.comment("");
        Simulator.comment("Test is the size and isEmpty methods...");
        
        System.out.println("Size     = " + list1.size());
        System.out.println("Is empty = " + list1.isEmpty());
        System.out.println(list1.toString());
        
        // Add content to the front............................................
        Simulator.comment("Add content to the front...");
        
        System.out.println(list1.addFront("Tiger"));
        System.out.println(list1.toString());
        System.out.println(list1.addFront("Quail"));
        System.out.println(list1.toString());
        System.out.println(list1.addFront("Cockatoo"));
        System.out.println(list1.toString());
        System.out.println(list1.addFront(null));
        System.out.println(list1.toString());
        
        // Add content to the back.............................................
        Simulator.comment("Add content to the back...");
        
        System.out.println(list1.addBack("Whale"));
        System.out.println(list1.toString());
        System.out.println(list1.addBack("Monkey"));
        System.out.println(list1.toString());
        System.out.println(list1.addBack("Dog"));
        System.out.println(list1.toString());
        System.out.println(list1.addBack(null));
        System.out.println(list1.toString());
        
        // Test our get ("accessor") method....................................     
        Simulator.comment("Test our get (accessor) method...");
        
        for (int i = -1; i <= list1.size(); i++) {
            System.out.println("index " + i + " = " + list1.get(i));
        }
        System.out.println(list1.toString());
                
        // Test our clone method.....................................
        Simulator.comment("Test our clone method...");
        
        LinkedList<String> copy = list1.clone();
        System.out.println(copy.toString());    
        
        // Test our set ("mutator") method.....................................
        Simulator.comment("Test our set (mutator) method...");
        
        for (int i = -1; i <= copy.size(); i++) {
            System.out.println(copy.set(i, "geese"));
        }
        System.out.println(copy.set(1, null));        
        System.out.println(copy.toString());
        
        // Test our remove front method........................................
        Simulator.comment("Test our remove front method...");
        
        for (int i = 0; i < 10; i++) {
            System.out.println(copy.removeFront());
            System.out.println(copy.toString());
        }
                
        // Test our remove back method.........................................
        Simulator.comment("Test our remove back method...");
        
        copy = list1.clone();
        System.out.println(copy.toString());
        for (int i = 0; i < 10; i++) {
            System.out.println(copy.removeBack());
            System.out.println(copy.toString());
        }
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        Simulator.header("Collections Test completed!");
    }
    
}
