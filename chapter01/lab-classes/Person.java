
/**
 * Write a description of class Person here.
 *
 * @author (Devon Ceccacci)
 * @version (April 2021)
 */
public class Person
{
    private String name;
    
    private String id;

    /**
     * Constructor for objects of class Person
     */
    public Person(String name, String id)
    {
        if(name.length() < 4){
            System.out.println("Not enough letters in name");
        }
        if(id.length() < 3){
            System.out.println("Not enough numbers in ID");
        }
        this.name = name;
        this.id = id;
    }
    
    public String getName()
    {
        return name;
    }
    
    public String getId()
    {
        return id;
    }
    
    public void changeName(String newName)
    {
        name = newName;
    }
    
        /**
     * Return the login name of this student. The login name is a combination
     * of the first four characters of the student's name and the first three
     * characters of the student's ID number.
     */
    public String getLoginName()
    {
        if (name.length() < 4){
            return name + id.substring(0,3);
        }
        if (id.length() < 3){
            return name.substring(0,4) + id;
        }
        if (id.length() < 3 && name.length() <4){
            return name + id;
        }
        else{
            return name.substring(0,4) + id.substring(0,3);
        }
    }
    
    

}
