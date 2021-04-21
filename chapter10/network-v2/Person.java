
/**
 * Write a description of class Person here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Person
{
    Person p1 = new Person();
    Person p2 = new Person();
    PhDStudent phd1 = new PhDStudent();
    Teacher t1 = new Teacher();
    Student s1 = new Student();
    

    /**
     * Constructor for objects of class Person
     */
    public Person()
    {
        // FAILED s1 = p1;
        // FAILED s1 = p2;
        p1 = s1;
        // FAILED t1 = s1;
        s1 = phd1;
 
    }

}
