import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Collections;
import java.util.ArrayList;

/**
 * Opens a .txt file, reads the String of numbers, 
 * Convert String into Integers,
 * Place numbers into a DLinkedList,
 * Changes the Integer numbers in the DLinkedList,
 * Retrieve changed numbers from the DLinkedList, 
 * Saves changed numbers over orginal .txt file.
 *
 * @author (Devon Ceccacci)
 * @version (beta)
 */
public class NumberIO
{
    private static final String FILE_LOCATION = "numbers.txt";
    private DLinkedList<Integer> dlnked = new DLinkedList<Integer>();
    private List<Integer> numbers = new ArrayList<Integer>();
    
    public static void main(String[] args){
        NumberIO numIO = new NumberIO(FILE_LOCATION);
    }
    
    /**
     * Constructor
     */
    public NumberIO(String fileName) {
        numbers = readFile(fileName);
        addToDLL(numbers, dlnked);
        changeNumbers(dlnked);
        numbers = getFromDLL(dlnked);
        writeFile(fileName, numbers);
    }
    
    /**
     * return double linked list
     */
    public DLinkedList<Integer> getDLinkedList(){
        return dlnked;
    }
    
    /**
     * return number list
     */
    public List<Integer> getNumbers(){
        return numbers;
    }
    
    /**
     * Increases each number in the DLinkedList by 1.
     */
    public void changeNumbers(DLinkedList<Integer> dlist){
        Integer num = null;
        for(int i = 0; i < dlnked.size(); i++){
            num = dlist.get(i).getData();
            num ++;
            dlist.set(i, num);
        }
    }
    
    /**
     * Adds each number to the DLinkedList
     */
    public void addToDLL(List<Integer> nums,DLinkedList<Integer> dlist) {
        for (int i = 0; i < nums.size(); i++){
            dlist.add(nums.get(i));
        }
    }
    
    public List<Integer> getFromDLL(DLinkedList<Integer> dlist){
        List<Integer> tmpList = new ArrayList<Integer>();
        for(int i = 0; i < dlist.size(); i++){
            Node<Integer> node = dlist.get(i);
            Integer tmpNum = node.getData();
            tmpList.add(tmpNum);
        }
        return tmpList;
    }
    
    /**
     * Reads the .txt file,
     * Converts and returns the numbers into a List<Integer>.
     */
    public static List<Integer> readFile(String name) {
        List<Integer> numbers = null;
        
        try
        {
            numbers = Files.lines(new File(name).toPath())
                                .map(s -> s.trim())
                                .filter(s -> !s.isEmpty())
                                .map(s -> Integer.parseInt(s))
                                .collect(Collectors.toList());
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        
        return numbers;
    }
    
    public static void writeFile(String fileName, List<Integer> numList) {
        try{
            PrintWriter fileout = new PrintWriter(new FileWriter(fileName));
            
            for (int i = 0; i < numList.size(); i++) {
                fileout.println(numList.get(i));
            }
            fileout.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
