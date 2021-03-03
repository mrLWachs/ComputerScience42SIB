
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
        
        
        
        
        
        Simulator.header("Collections Test completed!");
    }
    
}
