
/** required package class namespace */
package testing.exampleinternalassessment;

/** required imports */
import java.io.Serializable;

/**
 * Entry.java - stores an entry for the application database
 * 
 * @author Mr. Wachs
 * @since Mar 13, 2017
 * @instructor Mr. Wachs
 */
public class Entry implements Serializable, Comparable<Entry>
{
    
    private String  name;
    private boolean isMale;
    private int     age;
    private String  information;

    
    /**
     * class constructor sets class properties
     * 
     * @param name the entries name
     * @param isMale the entries gender
     * @param age the entries age
     * @param information the entries information
     */
    public Entry(
            String name,
            boolean isMale,
            int age,
            String information) {
        this.name        = name;
        this.isMale      = isMale;
        this.age         = age;
        this.information = information;        
    }
    
    /**
     * string representation of this object
     * 
     * @return the string version of this object 
     */
    public String toString() {
        return  getName()   + ", age: " + 
                getAge()    + ", gender: " + 
                getGender() + ", information: " + 
                getInformation();
    }

    /**
     * gets the gender of this entry
     * 
     * @return the word "male" or "female"
     */
    private String getGender() {
        if (isMale) return "male";
        else        return "female"; 
    }
    
    /**
     * compares the entry parameter to the current entry in terms of
     * less than, greater than, or equal to
     * 
     * @param entry the entry to compare to 
     * @return less than ( < 0 ), greater than ( > 0 ), or equal ( 0 )
     */
    @Override
    public int compareTo(Entry entry) {
        return this.name.compareTo(entry.getName());
    }

    /**
     * gets the name property of this entry 
     * 
     * @return the name property
     */
    public String getName() {
        return name;
    }

    /**
     * gets the gender property of this entry 
     * 
     * @return the gender property
     */
    public boolean getIsMale() {
        return isMale;
    }

    /**
     * gets the age property of this entry 
     * 
     * @return the age property
     */
    public int getAge() {
        return age;
    }

    /**
     * gets the information property of this entry 
     * 
     * @return the information property
     */
    public String getInformation() {
        return information;
    }
    
}
