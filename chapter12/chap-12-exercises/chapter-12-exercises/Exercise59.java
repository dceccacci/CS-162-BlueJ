import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Write a description of class Main here.
 *
 * @author (Devon Ceccacci)
 * @version (a version number or a date)
 */
public class Exercise59
{
    private List<Integer> aLinkedList = new LinkedList<>();
    private List<Integer> anArrayList = new ArrayList<>();
    
    int listSize = 100000;


    /**
     * Constructor for objects of class Main
     */
    public Exercise59()
    {
        addToLists();
        getFromLists();
        removeFromLists();
    }
    
    public void addToLists(){
        
        long linkedStart = System.currentTimeMillis();
        for(int i = 0; i<listSize; i++){
            aLinkedList.add(i);
        }
        long linkedEnd = System.currentTimeMillis();
        
        long arrayStart = System.currentTimeMillis();
        for(int i = 0; i<listSize; i++){
            anArrayList.add(i);
        }
        long arrayEnd = System.currentTimeMillis();
        
        long linkedTime = linkedEnd - linkedStart;
        long arrayTime = arrayEnd - arrayStart;
        System.out.println("+++ Adding to lists +++");
        System.out.println("Linked: " + linkedTime);
        System.out.println("Array: " + arrayTime);
        System.out.println("");
    }
    
    public void getFromLists(){
        int x, y;
        
        long linkedStart = System.currentTimeMillis();
        for(int i = 0; i<listSize; i++){
            x = aLinkedList.get(i);
        }
        long linkedEnd = System.currentTimeMillis();
        
        long arrayStart = System.currentTimeMillis();
        for(int i = 0; i<listSize; i++){
            y = anArrayList.get(i);
        }
        long arrayEnd = System.currentTimeMillis();
        
        long linkedTime = linkedEnd - linkedStart;
        long arrayTime = arrayEnd - arrayStart;
        
        System.out.println("=== Getting from lists ===");
        System.out.println("Linked: " + linkedTime);
        System.out.println("Array: " + arrayTime);
    }
    
    public void removeFromLists(){
        
        long linkedStart = System.currentTimeMillis();
        for(int i = 0; i<(listSize/2); i++){
            aLinkedList.remove(i);
        }
        long linkedEnd = System.currentTimeMillis();
        
        long arrayStart = System.currentTimeMillis();
        for(int i = 0; i<(listSize/2); i++){
            anArrayList.remove(i);
        }
        long arrayEnd = System.currentTimeMillis();
        
        long linkedTime = linkedEnd - linkedStart;
        long arrayTime = arrayEnd - arrayStart;
        
        System.out.println("--- Removing from lists ---");
        System.out.println("Linked: " + linkedTime);
        System.out.println("Array: " + arrayTime);
        
    }
    
    /**
     * A test to see why i was getting an out of bounds error on removing.
     * I believe it has to do with not being able to remove an object correctly without
     * an Iterator.
     */
    public void errorTest(){
        List<String> testLinkedList = new LinkedList<>();
        List<String> testArrayList = new ArrayList<>();
        
        for(int i = 0; i<5; i++){
            testLinkedList.add(Integer.toString(i));
            System.out.println("Linked Adding: " + testLinkedList);
        }

        for(int i = 0; i<5; i++){
            testArrayList.add(Integer.toString(i));
            System.out.println("Array Adding: " + testArrayList);
        }
        
        for(int i = 0; i<3; i++){
            testArrayList.remove(i);
            System.out.println("Array Removing: " + testArrayList);
        }
        
        for(int i = 0; i<5; i++){
            testLinkedList.remove(i);
            System.out.println("Linked Removing: " + testLinkedList);
        }

        
    }

}
