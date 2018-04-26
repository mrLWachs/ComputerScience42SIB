
/** required package class namespace */
package testing.cs40s.advancedclasses;

/**
 * SuperHero.java - interface sets the rules for a super hero
 *
 * @author Mr. Wachs 
 * @since Oct 25, 2017 
 * @instructor Mr. Wachs
 */
public interface SuperHero extends Hero
{
    /**
     * Accessor of the power level for this super hero
     * 
     * @return the power level of this super hero
     */
    public int powerLevel();
    
    /**
     * Mutator sets the secret identification name for this super hero
     * 
     * @param name the secret name to set to
     */
    public void setSecretId(String name);
    
    /**
     * Accessor gets the secret identification name for this super hero
     * 
     * @return the secret name for this super hero
     */
    public String getSecretID();
    
}
