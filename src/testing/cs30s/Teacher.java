
/** required package class namespace */
package testing.cs30s;

import testing.Output;

/**
 * Teacher.java - description here...
 *
 * @author lawrence.wachs 
 * @since Nov 30, 2017 
 * @instructor Mr. Wachs
 */
public class Teacher extends Person
{

    public Student[] students;
    
    public Teacher(String name, 
                   int age, 
                   boolean isMale) {
        super(name,age,isMale,true);
        students = new Student[100];
    }
    
    public void teach() {
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null) {
                students[i].study();
            }
        }
    }
    
    public void talk() {
        super.talk();
        Output.show("... As a "
                + "teacher, I teach "
                + students.length +
                " students!");
    }
    
}
