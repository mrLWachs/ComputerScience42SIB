
/** required package class namespace */
package collections;

/** required imports */
import java.io.Serializable;
import java.lang.reflect.Array;

/**
 * LinkedList.java - an implementation of a linked list abstract (advanced)
 * data (dynamic) type (ADT) and its useful methods
 *
 * @author Mr. Wachs 
 * @param <T> The generic type used 
 * @since Nov 8, 2017 
 * @instructor Mr. Wachs
 */
public class LinkedList <T extends Comparable<T>> implements Serializable
{

    /** The number of nodes in the list */
    private int length;    
    /** Node reference to the first node in the list */
    private Node head;
    /** Node reference to the last node in the list */
    private Node tail;
    
    /** Flag to indicate a search operation was not found */
    public static final int NOT_FOUND = -1;
    
           
    /** 
     * Default constructor for the class 
     */
    public LinkedList() {
        finalize();
    }

    /**
     * String representation of this object
     *
     * @return The object represented as a String
     */
    @Override
    public String toString() {        
        if (isEmpty()) return "Empty list";             // no nodes to display
        else {
            String text = "[";                          // starting character
            Node current = head;                        // start at head node
            while (current.next != null) {              // traverse list
                text += current.toString() + ",";       // append data
                current = current.next;                 // move to next node
            }            
            return text + current.toString() + "]";     // append end character
        }        
    }

    /**
     * Determines if two objects are "equal" in this context
     *
     * @param object the object to compare to
     * @return the objects are "equal" (true) or not (false)
     */
    @Override
    public boolean equals(Object object) {
        LinkedList<T> list = (LinkedList<T>)object;     // cast object to list
        if (this.size() != list.size()) return false;   // not same sizes
        else {            
            Node current1 = this.getFirstNode();        // get reference to
            Node current2 = list.getFirstNode();        // nodes in each list    
            while (current1 != null) {                  // traverse lists
                if (!current1.equals(current2)) {       // not equal data 
                    return false;                       // not equal lists
                }                
                current1 = current1.next;               // move each reference
                current2 = current2.next;               // to next node
            }
            return true;                                // lists are equal
        }        
    }
    
    /**
     * Creates a duplicate object using new memory
     *
     * @return a "clone" of the object using new memory
     */
    public LinkedList clone() {
        LinkedList<T> list = new LinkedList<>();    // create new list memory
        for (int i = 0; i < length; i++) {          // traverse list
            list.addBack((T)this.getNode(i).data);  // get and add node data          
        }        
        return list;                                // new list returned
    }
        
    /**
     * Frees up all memory used by this object
     */
    @Override
    public final void finalize() {
        length = 0;                                 // length set to zero
        head = tail = null;                         // references set to nulls
        System.gc();                                // garbage collector called
    }
    
    /**
     * Determines if the list is empty (no content)
     * 
     * @return is empty (true) or not empty (false)
     */
    public boolean isEmpty() {
        return length == 0;                         // compares length to zero
    }
       
    /**
     * The number of nodes (the length) of the list
     * 
     * @return the number of nodes in the list
     */
    public int size() {
        return length;
    }        
            
    /**
     * Inserts data into the front (head) of the list
     * 
     * @param data the data type to add
     * @return the operation was successful (true) or not (false)
     */
    public boolean addFront(T data) {
        if (data == null) return false;     // null data cannot be added        
        Node<T> node = new Node<>(data);    // new node memory created    
        if (isEmpty()) {                    // adding first node
            head = tail = node;             // set references
        }
        else {                              // subsequent nodes added
            node.next = head;               // link node to rest of list
            head.previous = node;           // connect rest of list to node
            head = node;                    // reassign head reference
        }
        length++;                           // increase length environmental
        return true;                        // operation successful
    }
    
    /**
     * Inserts data into the back (tail) of the list
     * 
     * @param data the data type to add
     * @return the operation was successful (true) or not (false)
     */
    public boolean addBack(T data) {
        if (data == null) return false;     // null data cannot be added            
        Node<T> node = new Node<>(data);    // new node memory created    
        if (isEmpty()) {                    // adding first node
            head = tail = node;             // set references
        }
        else {                              // subsequent nodes added
            node.previous = tail;           // link node to rest of list
            tail.next = node;               // connect rest of list to node
            tail = node;                    // reassign tail reference
        }
        length++;                           // increase length environmental
        return true;                        // operation successful
    }        
            
    /**
     * Checks to see if the index is in range of the list
     * 
     * @param index the location to check
     * @return it is in range (true) or not (false)
     */        
    private boolean inRange(int index) {
        if (isEmpty())       return false;  // empty list no valid index
        if (index < 0)       return false;  // index before first valid number
        if (index >= length) return false;  // index after last valid number
        return true;                        // index is valid
    }
    
    /**
     * Reference to the first (head) node in the list
     * 
     * @return reference to the head (first) node
     */
    protected Node getFirstNode() {
        return head;
    }

    /**
     * Reference to the last (tail) node in the list
     * 
     * @return reference to the tail (last) node
     */
    protected Node getLastNode() {
        return tail;
    }
    
    /**
     * Accesses the node reference for this index location
     * 
     * @param index the index location
     * @return a reference to the node at this index or null
     */
    protected Node getNode(int index) {
        if (!inRange(index))   return null;             // not valid index
        if (index == 0)        return getFirstNode();   // first node returned
        if (index == length-1) return getLastNode();    // last node returned
        else {                                          // internal node
            Node current = head;                        // start at first node
            for (int i = 0; i < index; i++) {           // move to index
                current = current.next;                 // advance reference
            }
            return current;                             // return reference
        }
    }
        
    /**
     * Accessor for the data at the specified index
     * 
     * @param index the index location to access
     * @return the data (or null) at the index
     */
    public T get(int index) {        
        if (!inRange(index)) return null;   // invalid index, return flag        
        return (T)getNode(index).data;      // get reference and retrieve data  
    }
    
    /**
     * Mutator method sets the index location to the new data
     * 
     * @param index the index location to mutate
     * @param data the new data to mutate into
     * @return the operation was successful (true) or not (false)
     */
    public boolean set(int index, T data) {
        Node current = getNode(index);
        if (current == null) return false;          // invalid index
        if (data == null)    return false;        
        current.data = data;
        return true;
    }
    
    /**
     * Accesses the first, head, front data in the list
     * 
     * @return the head data
     */
    public T front() {
        return get(0);        
    }
    
    /**
     * Accesses the last, tail, back data in the list
     * 
     * @return the tail data
     */
    public T back() {
        return get(length-1);
    }
    
    /**
     * Removes (deletes) the first (head) node of the list
     * 
     * @return the data in the first node (or null)
     */
    public T removeFront() {
        if (isEmpty()) return null;
        else {
            T data = (T)head.data;            
            if (length == 1) finalize();
            else {                
                head = head.next;                
                head.previous.next = null;
                head.previous = null;
                length--;
                System.gc();
            }
            return data;
        }
    }
    
    /**
     * Removes (deletes) the last (tail) node of the list
     * 
     * @return the data in the last node (or null)
     */
    public T removeBack() {
        if (isEmpty()) return null;
        else {
            T data = (T)tail.data;            
            if (length == 1) finalize();
            else {                
                tail = tail.previous;                
                tail.next.previous = null;
                tail.next = null;
                length--;
                System.gc();
            }
            return data;
        }
    }
    
    /**
     * Checks if the specified data is inside the list
     * 
     * @param data the data to check for
     * @return data is in the list (true) or not (false)
     */
    public boolean contains(T data) {
        Node current = head;
        while (current != null) {
            if (current.data.equals(data)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
    
    /**
     * Inserts data as a new node after the passed index
     * 
     * @param data the data type to insert
     * @param index the index location to insert after
     * @return the operation was successful (true) or not (false)
     */
    public boolean addAfter(T data, int index) {
        if (data == null)    return false;
        if (!inRange(index)) return false;        
        if (index == length-1) return addBack(data);
        else {            
            Node<T> node = new Node(data);
            Node current = getNode(index);            
            node.next = current.next;
            current.next.previous = node;
            current.next = node;
            node.previous = current;
            length++;
        }
        return true;
    }
    
    /**
     * Inserts data as a new node before the passed index
     * 
     * @param data the data type to insert
     * @param index the index location to insert before
     * @return the operation was successful (true) or not (false)
     */
    public boolean addBefore(T data, int index) {
        if (data == null)    return false;
        if (!inRange(index)) return false;        
        if (index == 0)      return addFront(data);
        else {            
            Node<T> node = new Node(data);
            Node current = getNode(index);            
            node.previous = current.previous;
            current.previous.next = node;
            current.previous  = node;
            node.next = current;
            length++;
        }
        return true;
    }
    
    /**
     * Adds the data to the back of the list
     * 
     * @param data the data to add
     * @return the operation was successful (true) or not (false)
     */
    public boolean add(T data) {
        return addBack(data);
    }
    
    /**
     * Adds the data before the passed index
     * 
     * @param data the data to add
     * @param index the index location to add before
     * @return the operation was successful (true) or not (false)
     */
    public boolean add(T data, int index) {
        return addBefore(data, index);
    }
    
    /**
     * Deletes the node at the specified index and mutates the list
     * 
     * @param index the index location to remove
     * @return the data at the specified index (or null)
     */
    public T remove(int index) {
        if (!inRange(index))   return null;
        if (index == 0)        return removeFront();
        if (index == length-1) return removeBack();        
        Node current = getNode(index);        
        current.previous.next = current.next;
        current.next.previous = current.previous;        
        current.next = current.previous = null;
        length--;
        return (T)current.data;
    }
    
    /**
     * Finds the node matching the data at the first occurance in the list
     * and returns it's index or -1 (NOT_FOUND) if not in the list
     * 
     * @param data the node data to search for
     * @return index of first occurance or -1 (NOT_FOUND)
     */
    public int firstIndexOf(T data) {
        Node current = head;
        int index = 0;
        while (current != null) {
            if (current.data.equals(data)) {
                return index;
            }
            index++;
            current = current.next;
        }
        return NOT_FOUND;        
    }
    
    /**
     * Finds the node matching the data at the last occurance in the list
     * and returns it's index or -1 (NOT_FOUND) if not in the list
     * 
     * @param data the node data to search for
     * @return index of last occurance or -1 (NOT_FOUND) 
     */
    public int lastIndexOf(T data) {
        Node current = tail;
        int index = length - 1;
        while (current != null) {
            if (current.data.equals(data)) {
                return index;
            }
            index--;
            current = current.previous;
        }
        return NOT_FOUND;        
    }
    
    /**
     * Deletes the first occurance of the data in the list
     * 
     * @param data the node data to remove
     * @return the operation was successful (true) or not (false) 
     */
    public boolean remove(T data) {
        if (data == null) return false;
        int index = firstIndexOf(data);
        if (index == NOT_FOUND) return false;
        remove(index);
        return true;
    }
    
    /**
     * Deletes the last occurance of the data in the list
     * 
     * @param data the node data to remove
     * @return the operation was successful (true) or not (false) 
     */
    public boolean removeLast(T data) {
        if (data == null) return false;
        int index = lastIndexOf(data);
        if (index == NOT_FOUND) return false;
        remove(index);
        return true;
    }
    
    /**
     * Deletes all occurances of the data in the list
     * 
     * @param data the node data to remove
     * @return the operation was successful (true) or not (false)
     */
    public boolean removeAll(T data) {
        if (data == null) return false;
        if (!contains(data)) return false;
        while(contains(data)) {
            remove(data);
        }
        return true;
   }
    
    /**
     * Deletes all occurances of the different data items in the array 
     * from the list
     * 
     * @param items the node data array items to remove
     * @return the operation was successful (true) or not (false)
     */
    public boolean removeAll(T[] items) {
         if (items == null)     return false;
         if (items.length == 0) return false;
         for (T item : items) {
             removeAll(item);
         }
         return true;
    } 
   
    /**
     * Deletes all occurances of the different data items in the passed
     * list from the current list
     * 
     * @param list the LinkedList of items to remove
     * @return the operation was successful (true) or not (false)
     */
    public boolean removeAll(LinkedList<T> list) {
        if (list == null)   return false;
        if (list.isEmpty()) return false;
        for (int i = 0; i < list.size(); i++) {
            removeAll(list.get(i));
        }
        return true;
    }
   
    /**
     * Wipes out all memory of all contents of the list
     */
    public void clear() {
        Node current = head;
        while (current != null) {
            Node next = current.next;
            current.finalize();
            current = next;
        }
        finalize();
    }
   
    /**
     * Checks the list to see if it contains all the items in the array
     * 
     * @param items the node data array items to check
     * @return all items are in the list (true) or not (false)
     */
    public boolean containsAll(T[] items) {
        if (items == null)     return false;
        if (items.length == 0) return false;
        for (T item : items) {
            if (!contains(item)) return false;
        }
        return true;
    }
    
    /**
     * The number of instances this data occurs in the list
     * 
     * @param data the data to search for
     * @return the number of instances of the data
     */
    public int numberOf(T data) {
        int counter = 0;
        Node current = head;
        while (current != null) {
            if (current.data.equals(data)) {
                counter++;
            }
            current = current.next;
        }
        return counter;
    }
   
    /**
     * Appends all the items from the passed list to the end of the 
     * current list
     * 
     * @param list the Linked list to append on
     */
    public void addAll(LinkedList<T> list) {
        for (int i = 0; i < list.size(); i++) {
            this.add(list.get(i));
        }
    }
   
    /**
     * Appends all the items from the passed list into the current list 
     * after the passed index in the list
     * 
     * @param list the Linked list to append on
     * @param index the index location to append from
     */
    public void addAll(LinkedList<T> list, int index) {
        for (int i = 0; i < list.size(); i++) {
            this.addAfter(list.get(i), index);
            index++;
        }
    }
   
    /**
    * Accesses a sub list from the main list based on the passed parameters
    * 
    * @param from the index to start the sublist from
    * @param to the index to end the sub list at
    * @return a sub list from the main list
    */
    public LinkedList<T> subList(int from, int to) {
        if (!inRange(from)) return null;
        if (!inRange(to))   return null;
        if (from > to)      return null;
        LinkedList<T> list = new LinkedList<>();
        for (int i = from; i <= to; i++) {
            list.add(this.get(i));
        }
        return list;
    }
   
    /**
     * Mutates the list into a list only matching the contents of the array
     * 
     * @param array the data objects to form the list from
     */
    public final void fromArray(T[] array) {
        finalize();
        for (T t : array) {
            add(t);
        }
    }
    
    /**
     * Constructor instantiates list from the passed data
     * 
     * @param array the data objects to create the list from
     */
    public LinkedList(T[] array) {
        fromArray(array);
    }
    
    /**
     * Mutates list into a list only matching the contents of the other list
     * 
     * @param list the data objects to form the list from
     */
    public final void fromLinkedList(LinkedList<T> list) {
        finalize();
        for (int i = 0; i < list.size(); i++) {
            add(list.get(i));
        }
    }
    
    /**
     * Constructor instantiates list from the passed data
     * 
     * @param list the data objects to create the list from
     */
    public LinkedList(LinkedList<T> list) {
        fromLinkedList(list);
    }
   
    /**
     * Returns an array that contains the same data as the list
     * 
     * @param array the data type array
     * @return an array of generic type T
     */
    public T[] toArray(T[] array) {
        array = (T[])(
                Array.newInstance(
                        array.getClass().getComponentType(), 
                        length)
                );
        for (int i = 0; i < length; i++) {
            array[i] = get(i);
        }
        return array;
    }
   
    /**
     * Accesses all occurances of the passed data in the list and returns an
     * integer array containing all index values the data occurred at
     * 
     * @param data the data to search for
     * @return all indices location in an array or null if no indices
     */
    public int[] allIndices(T data) {
        if (!contains(data)) return null;        
        int size = numberOf(data);
        int[] array = new int[size];
        Node current = head;
        int counter = 0;
        for (int i = 0; i < length; i++) {
            if (current.data.equals(data)) {
                array[counter] = i;
                counter++;
                if (counter >= size) return array;
            }
            current = current.next;
        }
        return array;
    }
    
}
