import java.util.*;
/**
 * Write a description of class Test here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Test
{
    private ArrayList<Integer> bunchOfNumbers;
    
    public Test()
    {
        bunchOfNumbers = new ArrayList<>();
        for(int i=1; i <= 100; i++)
        {
            bunchOfNumbers.add(i);
        }
    }
    
    public void limitExample()
    {
        bunchOfNumbers.stream()
                      .filter(n -> n % 2 == 0)
                      .limit(5)
                      .forEach(n -> System.out.println(n));
        
    }
    
    public void skipExample()
    {
        bunchOfNumbers.stream()
                      .skip(90)
                      .forEach(n -> System.out.println(n));
    }
    
}
