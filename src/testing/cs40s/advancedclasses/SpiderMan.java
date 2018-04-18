
/** required package class namespace */
package testing.cs40s.advancedclasses;

import io.Output;
import java.io.Serializable;

/**
 * SpiderMan.java - description here...
 *
 * @author lawrence.wachs 
 * @since Oct 25, 2017 
 * @instructor Mr. Wachs
 */
public class SpiderMan extends HighSchoolStudent 
        implements SuperHero, Morals, Serializable, Comparable<SpiderMan>
{

    private String secretID;
    private String costume;
    
    
    public SpiderMan(int age) {
        super("Peter Parker", true, age, 88888888);
    }

    @Override
    public int powerLevel() {
        return 8;
    }

    @Override
    public void setSecretId(String name) {
        secretID = name;
    }

    @Override
    public String getSecretID() {
        return secretID;
    }

    @Override
    public void beHeroic() {
        Output.show(super.getName() + 
                "\n - has a secret identity of a " + getSecretID() + 
                "\n - is " + super.age + 
                "\n - and wears " + costume +
                "\n - and he swings, spider sense, "
                + "crawls walls, spins webs, strong");
    }

    @Override
    public void set(String uniform) {
        costume = uniform;
    }

    @Override
    public String get() {
        return costume;
    }

    @Override
    public boolean isMoral() {
        return Morals.RIGHT;
    }

    public String toString() {
        return super.getName() + 
                "\n - has a secret identity of a " + getSecretID() + 
                "\n - is " + super.age + 
                "\n - and wears " + costume +
                "\n - and he swings, spider sense, "
                + "crawls walls, spins webs, strong";
    }
    
    public int compareTo(SpiderMan man) {
        return 0;
    }
    
    
}
