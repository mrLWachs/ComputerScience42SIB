/**
 * Required package
 */
package testing.cs30s;

import io.Output;

/**
 * Person.java - defines a person
 *
 * @author Mr. Wachs
 * @since November 22, 2017
 * @instructor Mr. Wachs
 */
public class Person {

    // Properties (things about it, descriptors)...............................
    
    /**
     * The person's full name
     */
    public String  name;
    
    private int     age;
    private boolean isMale;
    private boolean isAlive;
        
    // Methods (things it can do, actions).....................................
    
    /**
     * Constructor method for this class
     */
    public Person() {        
        name    = "Sam Doe";
        age     = 0;
        isMale  = false;
        isAlive = true;        
    }
    
    /**
     * Constructor method for this class
     * 
     * @param name the name to assign to this person
     */
    public Person(String name) {
        this.name = name;
        age       = 0; 
        isMale    = false;
        isAlive   = true; 
    }
        
    /**
     * Constructor method for this class
     * 
     * @param name the name to assign to this person
     * @param age the age to assign to this person
     * @param isMale the gender to assign to this person
     * @param isAlive the living status to assign to this person
     */
    public Person (String name, 
            int age, 
            boolean isMale,
            boolean isAlive) {
        this.name    = name;
        this.age     = age;
        this.isMale  = isMale;
        this.isAlive = isAlive;        
    }
           
    /**
     * What this person has to say
     */
    public void talk() {        
        if (isAlive) {        
            Output.show("My name is " +
                    name + " and my age is " +
                    age + " and if you are "
                    + "wondering if I am a male"
                    + " the answer is " + isMale);
        }
        else {
            Output.show("Boo!");
        }
    }
    
    /**
     * Kills the person
     */
    public void die() {
        isAlive = false;
    }
    
    /**
     * Advances the person's age by 1
     */
    public void birthday() {
        age++;
    }
    
    /**
     * Advances the person's age by passed amount
     * 
     * @param times the number of birthdays to have
     */
    public void birthday(int times) {
        for (int i = 0; i < times; i++) {
            birthday();
        }
    }
    
    /**
     * Transitions this person to the opposite gender
     */
    public void genderTransition() {
        if (isMale) {
            isMale = false;
        }
        else {
            isMale = true;
        }
    }

    /**
     * Assigns a gender to this person
     * 
     * @param isMale the gender to assign
     */
    public void assignGender(boolean isMale) {
        this.isMale = isMale;
    }
    
}
