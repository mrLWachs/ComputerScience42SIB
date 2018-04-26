
/** required package class namespace */
package testing.cs30s;

import testing.Output;

/**
 * Husky.java - description here...
 *
 * @author lawrence.wachs 
 * @since Nov 30, 2017 
 * @instructor Mr. Wachs
 */
public class Husky extends Student
{
    private double pride;

    public Husky(String name, int age, 
                 boolean isMale, int studentNumber) {
        super(name, age, isMale, studentNumber);
        pride = 0.5;
    }
    
    public void pepRally() {
        pride = pride * 1.1;
    }
    
    public void assembly() {
        pride = pride * 0.9;
    }
    
    @Override
    public void talk() {
        super.talk();
        Output.show("... I am "
                + "a Husky, and my "
                + "pride is " +
                (pride * 100) + "%");
    }

    
}
