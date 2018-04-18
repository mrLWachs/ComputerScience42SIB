
/** required package class namespace */
package testing.cs40s.advancedclasses;

/**
 * ComputerScienceStudent.java - description here...
 *
 * @author lawrence.wachs 
 * @since Oct 23, 2017 
 * @instructor Mr. Wachs
 */
public class ComputerScienceStudent extends Husky
{

    public ComputerScienceStudent(String name, boolean isMale, 
                                  int age, int studentNumber) {
        super(name, isMale, age, studentNumber);
    }

    /**
     * String representation of this object
     *
     * @return The object represented as a String
     */
    @Override
    public String toString() {
        return "Computer Science: " + super.toString();
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
    public ComputerScienceStudent clone() {
        return this;
    }

}
