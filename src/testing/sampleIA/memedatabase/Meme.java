
/** required package class namespace */
package testing.sampleIA.memedatabase;

/** required imports */
import java.io.File;
import java.io.Serializable;
import collections.LinkedList;
//import testing.sampleIA.collections.LinkedList;

 
/**
 * Meme.java - represents an internet "meme" which is an image (usually funny) 
 * and also the author of that meme, the date created, and any keywords that 
 * describe the meme
 *
 * @author Mr. Wachs
 * @since Mar. 2, 2020, 10:45:33 a.m.
 */
public class Meme implements Comparable, Serializable
{

    public File pictureFile;                // the file for the image itself
    public String author;                   // the author of this meme
    public String dateCreated;              // the date the meme was created
    public LinkedList<String> keywords;     // dynamic list of keywords

    
    /**
     * Class constructor, set class properties
     * 
     * @param pictureFile the file for the image itself
     * @param author the author of this meme
     * @param dateCreated the date the meme was created
     * @param keywords dynamic list of keywords
     */
    public Meme(File pictureFile, String author, String dateCreated,
                LinkedList<String> keywords) {
        this.pictureFile = pictureFile;         // assign parameter to property
        this.author      = author;
        this.dateCreated = dateCreated;
        if (keywords != null) {                 // valid list of keywords
            this.keywords = new LinkedList<>();         // instantiate list
            for (int i = 0; i < keywords.size(); i++) { // traverse list
                this.keywords.add(keywords.get(i));     // assign to property
            }
        }        
    }
    
    /**
     * String representation of this object
     *
     * @return The object represented as a String
     */
    @Override
    public String toString() {
        String text = author + " (" + dateCreated + "): ";      // create text
        if (keywords == null || keywords.isEmpty()) text += "no keywords";
        else {                                  // continue filling from list
            text += "keywords = ";
            for (int i = 0; i < keywords.size()-1; i++) {
                text += keywords.get(i) + ",";
            }
            text += keywords.get(keywords.size()-1);
        }
        return text;                                    // return filled text
    }
    
    /**
     * Compares two objects, based on the specifics definitions within the 
     * class
     * 
     * @param object the object to be compared to
     * @return A 0 if the argument is equal to this, a value less than 0 if  
     * this is less than the argument, and a value greater than 0 if this is       
     * greater than the argument  
     */
    @Override
    public int compareTo(Object object) {
        Meme that = (Meme)object;                   // cast object into meme
        String value1 = this.toString();            // get string values from
        String value2 = that.toString();            // both objects
        return value1.compareToIgnoreCase(value2);  // use string compare
    }

}
