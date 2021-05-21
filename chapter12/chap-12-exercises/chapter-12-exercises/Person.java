import java.util.Comparator;

/**
 * Write a description of class Person here.
 *
 * @author (Devon Ceccacci)
 * @version (a version number or a date)
 */
public class Person implements Comparable<Person>
{
    private String name;
    private int age;

    /**
     * Constructor for objects of class Person
     */
    public Person(String name, int age)
    {
        this.name = name;
        this.age = age;
    }
    
    public String getName(){
        return name;
    }
    
    public int getAge(){
        return age;
    }
    
    public int compareTo(Person otherPerson){
        return (this.name).compareTo(otherPerson.name);
    }
    
    


}
