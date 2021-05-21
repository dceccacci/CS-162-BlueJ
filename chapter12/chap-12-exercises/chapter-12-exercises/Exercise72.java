import java.util.TreeSet;
import java.util.Iterator;

/**
 * Write a description of class Exercise72 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Exercise72
{
    private TreeSet personTree = new TreeSet();
    
    /**
     * Constructor for objects of class Exercise72
     */
    public Exercise72()
    {
        personTree.add(new OtherPerson("a",21));
        personTree.add(new OtherPerson("b",18));
        personTree.add(new OtherPerson("c",26));
        personTree.add(new OtherPerson("d",19));
        personTree.add(new OtherPerson("e",20));
        printTree();
    }
    
    public void printTree(){
        for(Object person : personTree){
            System.out.print(person);
        }
    }
}
