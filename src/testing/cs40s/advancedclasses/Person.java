
/** required package class namespace */
package testing.cs40s.advancedclasses;

import io.Output;
import java.io.Serializable;

/**
 * Person.java - represents a person
 *
 * @author Mr. Wachs  
 * @since Oct 4, 2017 
 * @instructor Mr. Wachs
 */
public class Person implements Serializable
{
    
    private String name;
    
    /** the age of the person */
    public int age;
    
    /** the gender of the person */
    protected boolean isMale;
       
    /** 
     * Default constructor for the class 
     */
    public Person() {
        name   = "John Smith";
        age    = 0;
        isMale = false;
    }

    /**
     * Display information on the screen
     */
    public void talk() {
        Output.show(toString());
    }
    
    /**
     * Determines if two objects are "equal" in this context
     * 
     * @param object the object to compare to
     * @return the objects are "equal" (true) or not (false)
     */
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Person))              return false;
        Person person = (Person)object;
        if (this.age    != person.age)                return false;
        if (this.isMale != person.isMale)             return false;
        if (!this.getName().equals(person.getName())) return false;
        return true;
    }
    
    /**
     * String representation of this object
     * 
     * @return The object represented as a String
     */
    @Override
    public String toString() {
        return "Person: " + name + " is " + age + " and gender is " + isMale;
    }
    
    /**
     * Ends the world
     */
    public static void endOfTheWorld() {
        Output.show("Boom!!!!!");
    }
    
    /**
     * Creates a duplicate object using new memory
     *
     * @return a "clone" of the object using new memory
     */
    public Person clone() {
        //return this; // shallow clone        
        Person person = new Person();
        person.age    = this.age;
        person.isMale = this.isMale;
        person.setName(this.getName());
        return person;
    }
    
    /**
     * Mutator method for the private property name
     * 
     * @param name the name of this person
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Accessor method for the private property name
     * 
     * @return the name of this person
     */
    public String getName() {
        return name;
    }
    
    public void eat(Food food) {
        if (food.oughtCook()) {
            food.eat();
        }
        else {
            Output.show("Yuck");
        }
    }
    
}
