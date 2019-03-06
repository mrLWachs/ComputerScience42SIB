/*
 *  Mr. Wachs' classes - Java Computer Science learning file Stack.java
 *  for project ComputerScience42SIB on 1-Mar-2019 at 10:31:38 AM by lawrence.wachs
 */


/** required package class namespace */
package collections;

import java.io.Serializable;



/**
 * Stack.java - 
 *
 * @author Mr. Wachs 
 * @since 1-Mar-2019 
 */
public class Stack <T> implements Serializable, Comparable<Stack>
{

    private Node top;
    private int length;
    
    /**
     * Default constructor for the class, sets class properties
     */
    public Stack() {
        top = null;
        length = 0;
    }

    public Stack(LinkedList list) {
        top = null;
        length = 0;
        for (int i = 0; i < list.size(); i++) {
            push((T)list.get(i));
        }
    }
    
    public Stack(T[] array) {
        top = null;
        length = 0;
        for (int i = 0; i < array.length; i++) {
            push(array[i]);
        }
    }
    
    public Stack(Queue queue) {
        top = null;
        length = 0;
        for (int i = 0; i < queue.size(); i++) {
            push((T)queue.dequeue());
        }
    }
    
    public boolean push(T data) {
        return false;
    }
    
    public T pop() {
        return null;
    }
    
    public T peek() {
        return null;
    }
    
    public int size() {
        return length;
    }
    
    public boolean isEmpty() {
        return length == 0;
    }
    
    /**
     * String representation of this object
     *
     * @return The object represented as a String
     */
    @Override
    public String toString() {
        if (isEmpty()) return "Empty Stack";
        else {
            String text = "Stack ["; 
            Node current = top;
            while (current != null) {
                text += current.toString() + ",";
                current = current.next;
            }            
            return text + "]";
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
        return super.equals(object);
    }
    
    /**
     * Creates a duplicate object using new memory
     *
     * @return a "clone" of the object using new memory
     */
    @Override
    public Stack clone() {
        return this;
    }

    @Override
    public int compareTo(Stack o) {
        return 0;
    }

}
