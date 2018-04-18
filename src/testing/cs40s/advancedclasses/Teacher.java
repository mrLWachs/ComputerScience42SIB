
/** required package class namespace */
package testing.cs40s.advancedclasses;

/**
 * Teacher.java - represents a teacher
 *
 * @author Mr. Wachs 
 * @since Oct 5, 2017 
 * @instructor Mr. Wachs
 */
public class Teacher extends Person
{

    private int count;
    private final int MAX;
    
    /** the students associated with this teacher */
    public Student[] students;
    
    /** 
     * Default constructor for the class 
     */
    public Teacher(String name, boolean isMale, int age) {
        MAX      = 320;
        count    = 0;
        students = new Student[MAX];
        super.setName(name);
        super.age = age;
        super.isMale = isMale;
    }
    
    /**
     * Adds a student to this teacher's collection
     * 
     * @param student the student to add
     */
    public void add(Student student) {
        students[count] = student;
        count++;
        if (count >= MAX) count = 0;
    }
    
    /**
     * Changes the grades of all active students of this teacher
     */
    public void teach() {        
        for (int i = 0; i < count; i++) {
            students[i].learn();
        }        
    }
    
    /**
     * String representation of this object
     * 
     * @return The object represented as a String
     */
    @Override
    public String toString() {
        String text = "Teacher: " + super.toString();
        text += "\n\t - Teaches " + count + " students";
        for (int i = 0; i < count; i++) {
            text += "\n\t" + students[i].toString();
        }
        return text;
    }
    
    /**
     * Determines if two objects are "equal" in this context
     * 
     * @param object the object to compare to
     * @return the objects are "equal" (true) or not (false)
     */
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Teacher)) return false;
        Teacher teacher = (Teacher)object;
        if (this.count != teacher.count) return false;
        if (!super.equals(object)) return false;        
        for (int i = 0; i < count; i++) {
            Student student1 = this.students[i];
            Student student2 = teacher.students[i];
            if (!student1.equals(student2)) return false;            
        }
        return true;
    }
    
    /**
     * Creates a duplicate object using new memory
     *
     * @return a "clone" of the object using new memory
     */
    public Teacher clone() {
        Teacher teacher = new Teacher(this.getName(),this.isMale,this.age);
        for (int i = 0; i < count; i++) {
            teacher.add(this.students[i].clone());
        }
        return teacher;
    }
    
}
