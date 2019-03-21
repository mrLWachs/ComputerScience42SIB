
/** required package class namespace */
package testing.cs40s.advancedclasses;

/** required imports */
import io.System;

/**
 * CheeseCake.java - represents cheese cake food
 *
 * @author Mr. Wachs 
 * @since 1-Nov-2018 
 */
public class CheeseCake extends Food
{

    /**
     * Constructor for the class, sets class properties 
     */
    public CheeseCake() {
        super("Dairy");
    }

    /**
     * How to eat cheese cake
     */
    @Override
    public void eat() {
        System.out.println("use a fork");
    }

    /**
     * We should always cook cheese cake
     * 
     * @return it should be cooked
     */
    @Override
    public boolean shouldCook() {
        return true;
    }
    
}
