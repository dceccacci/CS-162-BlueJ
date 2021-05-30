
/**
 * Write a description of class DuplicateKeyException here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class DuplicateKeyException extends Exception
{
    private String key;


    /**
     * Constructor for objects of class DuplicateKeyException
     */
    public DuplicateKeyException(String key)
    {
        this.key = key;
    }
    
    public String getKey(){
        return key;
    }
    
    @Override
    public String toString(){
        return "Duplicate key: " + key + " was found.";
    }

}
