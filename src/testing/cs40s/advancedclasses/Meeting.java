
/** required package class namespace */
package testing.cs40s.advancedclasses;

import testing.Output;

/**
 * Meeting.java - description here...
 *
 * @author lawrence.wachs 
 * @since Oct 23, 2017 
 * @instructor Mr. Wachs
 */
public class Meeting 
{
    
    private Person[] members;
    private final int MAX;
    private int count;    

    /** 
     * Default constructor for the class 
     */
    public Meeting() {
        MAX = 1000;
        count = 0;
        members = new Person[MAX];
    }

    public void hold() {
        Output.show("Caution!"
                + " watch your language,"
                + " there are " + 
                Student.totalStudents 
                + " students in the"
                        + "room!");
        for (Person member : members) {
           if (member != null) { 
               if (member instanceof MrWachs) {
                   Output.show("Shhh, Wachs "
                           + "is talking");
               }
               Output.show(member);
           }
        }
    }
    
    public void attend(Person person) {
        members[count] = person;
        count++;
        if (count >= MAX) count = 0;
    }

}
