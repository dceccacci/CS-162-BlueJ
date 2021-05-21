import java.util.Comparator;

/**
 * Write a description of class OtherPerson here.
 *
 * @author (Devon Ceccacci)
 * @version (a version number or a date)
 */
public class OtherPerson implements Comparable<OtherPerson>
{
    private String name;
    private int age;

    /**
     * Constructor for objects of class OtherPerson
     */
    public OtherPerson(String name, int age)
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
    
    @Override
    public int compareTo(OtherPerson b){
        if(this.getAge() > b.getAge()){
            return 1;
        }
        else if(this.getAge() == b.getAge()){
            return 0;
        }
        else{
            return -1;
        }
    }
    
    @Override
    public String toString(){
        return "Name: " + name + " Age: " + age;
    }


}
