
/** required package class namespace */
package testing.cs30s;

import testing.Output;

/**
 * Student.java - defines a student (who "is a" person)
 *
 * @author Mr. Wachs 
 * @since Nov 29, 2017 
 * @instructor Mr. Wachs
 */
public class Student extends Person 
{
    
    private int studentNumber;
    private double average;
    
    
    /**
     * Constructor method for the class
     * 
     * @param name the name to assign to this person
     * @param age the age to assign to this person
     * @param isMale the gender to assign to this person
     * @param studentNumber the student number for this student
     */
    public Student(String name, int age, boolean isMale, int studentNumber) {
        super();
        this.studentNumber = studentNumber;
        super.name = name;
        super.birthday(age);
        super.assignGender(isMale);
        average = 1.0;
    }
    
    
    public void study() {
        average = (average + 0.1);
    }
    
    public void cram() {
        for (int i = 0; i < 10; i++) {
            study();
        }
    }
    
    public void slackOff() {
        average = (average - 0.5);
    }

    /**
     * 
     */
    @Override
    public void talk() {        
        super.talk();
        Output.show("... and my average is "
                + average + ", and my student"
                        + " number is " +
                studentNumber);        
    }    
    
}
