import java.util.AbstractList;
import java.util.List;
import java.util.ArrayList;

/**
 * Write a description of class Exercise73 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Exercise73 extends AbstractList
{
    List<Object> list;

    /**
     * Constructor for objects of class Exercise73
     */
    public Exercise73()
    {
        list = new ArrayList<Object>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
    }
    
    @Override
    public Object get(int index){
        return list.get(index);
    }
    
    @Override
    public int size(){
        return list.size();
    }
}
