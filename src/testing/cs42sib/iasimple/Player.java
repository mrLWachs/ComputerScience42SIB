
/** required package class namespace */
package testing.cs42sib.iasimple;

/** required imports */
import java.io.Serializable;


/**
 * Player.java - represents a player in the roster
 *
 * @author Mr. Wachs 
 * @since 21-Mar-2019 
 */
public class Player implements Serializable, Comparable<Object>
{
    
    private String name;
    private String number;
    private String phoneNumber;
   
    
    /**
     * Constructor for the class, sets class properties
     * 
     * @param name the player's name
     * @param number the player's jersey number
     * @param phoneNumber the player's phone number
     */
    public Player(String name, String number, String phoneNumber) {
        this.name        = name;
        this.number      = number;
        this.phoneNumber = phoneNumber;        
    }

    /**
     * String representation of this object
     *
     * @return The object represented as a String
     */
    @Override
    public String toString() {
        return "Player: " + name + " # " + number + " Phone: " + phoneNumber;
    }
        
    /**
     * Determines if two objects are "equal" in this context
     *
     * @param object the object to compare to
     * @return the objects are "equal" (true) or not (false)
     */
    @Override
    public boolean equals(Object object) {
        Player that = (Player)object;
        return this.getName().equals(that.getName());
    }

    /**
     * Creates a duplicate object using new memory
     *
     * @return a "clone" of the object using new memory
     */
    @Override
    public Player clone() {
        return new Player(this.getName(), this.getNumber(), 
                this.getPhoneNumber());
    }

    /**
     * Compares two objects lexicographically
     *
     * @param object the other object to be compared to
     * @return the value 0 if the argument string is equal to
     *          this object; a value less than 0 if this object
     *          is lexicographically less than the argument; and a
     *          value greater than 0 if this object is
     *          lexicographically greater than the argument
     */
    @Override
    public int compareTo(Object object) {
        Player that = (Player)object;
        return this.name.compareTo(that.getName());
    }

    /**
     * Accessor method to get the name property
     * 
     * @return the player's name
     */
    public String getName() {
        return name;
    }

    /**
     * Accessor method to get the number property
     * 
     * @return the player's number
     */
    public String getNumber() {
        return number;
    }

    /**
     * Accessor method to get the phone number property
     * 
     * @return the player's phone number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

}
