/** Required package class namespace */
package collections;

import java.io.Serializable;

 
/**
 * Tree.java - description
 *
 * @author Mr. Wachs
 * @since 5-Apr-2023, 9:57:36 AM
 */
public class BinaryTree <T extends Comparable<T> > implements Serializable
{

    /**
     * Default constructor, set class properties
     */
    public BinaryTree() {
        
    }
     
    /**
     * String representation of this object
     *
     * @return The object represented as a String
     */
    @Override
    public String toString() {
        return "Tree: " + super.toString();
    }
   
    /**
     * Deep comparison, determines if two objects are "equal" in this context
     *
     * @param object the object to compare to
     * @return the objects are "equal" (true) or not (false)
     */
    @Override
    public boolean equals(Object object) {
        return super.equals(object);
    }
       
    /**
     * a Deep clone, creates a duplicate object using new memory
     *
     * @return a "clone" of the object using new memory
     */
    @Override
    public BinaryTree clone() {
        return this;
    }
    
}