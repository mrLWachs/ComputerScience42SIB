package testing.cs42sib.collections;

public class CollectionsTest 
{

    public CollectionsTest() {
        
        Node<String> a = new Node<>();
        a.data = "Hello";        
        Node<String> b = new Node<>("Bye");        
        Node<String> c = new Node<>("book",a);
        c.next.data = "Hi";
        Node<String> d = new Node<>("can",b,c);
        d.previous.next.data = "Sup";
        
        System.out.println(a.toString());
        System.out.println(b.toString());
        System.out.println(c.toString());
        System.out.println(d.toString());
        
        
    }
    
}
