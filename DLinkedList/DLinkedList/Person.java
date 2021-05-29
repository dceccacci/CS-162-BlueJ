import java.util.HashSet;
import java.util.Set;

/**
 * Write a description of class Person here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Person implements IPerson
{
    // Individual Person fields
    private final String FIRSTNAME;
    private final String LASTNAME;
    private final String ID;


    /**
     * Constructor for objects of class Person
     */
    public Person(String firstName, String lastName, String iD){
        this.FIRSTNAME = firstName;
        this.LASTNAME = lastName;
        if(validateID(iD)){
            this.ID = iD;
        }
        else{
            this.ID = null;
            //System.out.println("Invalid ID for: " + toString());
        }
    }
        
    public boolean validateID(String iD){
        if(iD == null || iD.length() != 9){
            return false;
        }
        
        try{
            int num = Integer.parseInt(iD);
        } catch (NumberFormatException nfe) {
            return false;
        }
        
        return true;
    }
    
    public String getID(){
        return ID;
    }
    
    public String getFirstName(){
        return FIRSTNAME;
    }
    
    public String getLastName(){
        return LASTNAME;
    }
    
    @Override
    public String toString(){
        return getLastName() + ", " + getFirstName() + " ID: " + getID();
    }
}

