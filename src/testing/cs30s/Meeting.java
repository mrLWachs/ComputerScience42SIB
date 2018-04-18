
/** required package class namespace */
package testing.cs30s;

/**
 * Meeting.java - description here...
 *
 * @author lawrence.wachs 
 * @since Dec 1, 2017 
 * @instructor Mr. Wachs
 */
public class Meeting 
{
    
    private Person[] members;
    private int index;
    
    public Meeting() {
        members = new Person[1000];
        index = 0;
    }
    
    public void add(Person person) {
        members[index] = person;
        index++;
        if (index >= 1000) {
            index = 0;
        }
    }
    
    public void hold() {
        for (int i = 0; i < index; i++) {
            members[i].talk();
        }
    }
        
}
