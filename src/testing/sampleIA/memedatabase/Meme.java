

/** required package class namespace */
package testing.sampleIA.memedatabase;

import collections.LinkedList;
import java.io.File;
import java.io.Serializable;

 
/**
 * Meme.java - description
 *
 * @author Mr. Wachs
 * @since Mar. 2, 2020, 10:45:33 a.m.
 */
public class Meme implements Comparable, Serializable
{

    private File pictureFile;
    private String author;
    private String dateCreated;
    private LinkedList<String> keywords;

    public Meme(File pictureFile,
            String author,
            String dateCreated,
            LinkedList<String> keywords) {
        this.pictureFile = pictureFile;
        this.author      = author;
        this.dateCreated = dateCreated;
        this.keywords    = keywords;
    }
    
    
    @Override
    public int compareTo(Object o) {
        return 0;
    }
    
}
