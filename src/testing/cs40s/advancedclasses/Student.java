
/** required package class namespace */
package testing.cs40s.advancedclasses;

import testing.Output;
import java.io.Serializable;

/**
 * Student.java - represents a student
 *
 * @author Mr. Wachs 
 * @since Oct 4, 2017 
 * @instructor Mr. Wachs
 */
public class Student extends Person implements Serializable
{
    
    private int studentNumber;    
    private double grade;
    
    /** the student identification number */
    public static int totalStudents;
    
    /** 
     * Default constructor for the class 
     */
    public Student(int studentNumber) {
        super();
        this.studentNumber = studentNumber;     
        super.isMale = true;
        setGrade(50.0);
        totalStudents++;
    }
    
    /**
     * Constructor for the class 
     * 
     * @param name their name
     * @param isMale their gender
     * @param age their age
     * @param studentNumber their student number 
     */
    public Student(String name, boolean isMale, int age, int studentNumber) {
        this(studentNumber);
        this.age = age;
        this.isMale = isMale;
        this.setName(name);
    }
        
    /**
     * Display information on the screen
     */
    @Override
    public void talk() {
        Output.show(toString());
    }

    /**
     * String representation of this object
     * @return The object represented as a String
     */
    @Override
    public String toString() {
        String text = "Student: " + super.toString();
        text += "\n\t# " + studentNumber;
        text += "\n\t# " + grade + "%";        
        return text;
    }
        
    /**
     * Creates a duplicate object using new memory
     *
     * @return a "clone" of the object using new memory
     */
    @Override
    public Student clone() {
        Student student = new Student(this.studentNumber);
        student.setName(super.getName());
        student.age = super.age;
        student.isMale = this.isMale;
        student.grade = this.grade;        
        return student;
    }
    
    /**
     * Modifies the grade of this student up
     */
    public void learn() {
        setGrade(getGrade() + 1.0);
    }

    /**
     * Accessor method for the private property grade
     * 
     * @return the grade
     */
    public double getGrade() {
        return grade;
    }

    /**
     * Mutator method for the private property grade
     * 
     * @param grade the grade to set
     */
    public void setGrade(double grade) {
        this.grade = grade;
    }
    
    /**
     * Determines if two objects are "equal" in this context
     * 
     * @param object the object to compare to
     * @return the objects are "equal" (true) or not (false)
     */
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Student))                return false;
        Student student = (Student)object;
        if (this.studentNumber != student.studentNumber) return false;
        if (this.grade != student.grade)                 return false;
        return super.equals(object);
    }
    
}
