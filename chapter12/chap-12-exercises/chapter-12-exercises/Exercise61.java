
/**
 * Write a description of class Exercise61 here.
 *
 * @author (Devon Ceccacci)
 * @version (a version number or a date)
 */
public class Exercise61
{
    private Person personA = new Person("Bob", 34);
    private Person personB = new Person("Alice", 56);
    
    /**
     * Constructor for objects of class Exercise61
     */
    public Exercise61()
    {
        System.out.println(compareByName(personB));
    }
    
    public int compareByName(Person B){
        return personA.compareTo(personB);
    }
    


}
