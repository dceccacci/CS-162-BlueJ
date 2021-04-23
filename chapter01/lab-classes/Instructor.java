
/**
 * Write a description of class Instructor here.
 *
 * @author (Devon Ceccacci)
 * @version (April 2021)
 */
public class Instructor extends Person
{
    private String department;
    private String contactInfo;


    /**
     * Constructor for objects of class Instructor
     */
    public Instructor(String fullName, String id)
    {
        super(fullName, id);
        
    }
    
    public void setDepartment(String department)
    {
        this.department = department;
    }
    
    public void setContactInfo(String info)
    {
        this.contactInfo = info;
    }


}
