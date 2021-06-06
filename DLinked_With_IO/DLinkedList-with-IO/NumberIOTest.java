

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.ArrayList;

/**
 * The test class NumberIOTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class NumberIOTest
{
    private NumberIO NIO;
    private static final String FILE_LOCATION = "FINAL_TEST_NUMBERS.txt";
    private static final List<Integer> DEFAULT_LIST = new ArrayList<Integer>(
                            List.of(1, 2, 3, 4, 5, 6, 7, 8, 9));

    /**
     * Default constructor for test class NumberIOTest
     */
    public NumberIOTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
        NIO = new NumberIO("numbers.txt");
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
        
    }
    
    /**
     * Resets .txt file to default nummbers
     */
    public void reset(){
        NIO.writeFile(FILE_LOCATION, DEFAULT_LIST);
    }
    
    @Test
    public void testReadWrite(){
        reset();
        NIO.writeFile(FILE_LOCATION, DEFAULT_LIST);
        List<Integer> numbers = NIO.readFile(FILE_LOCATION);
        assertEquals(numbers, DEFAULT_LIST);
    }
    
    @Test
    public void testAddToDLL(){
        reset();
        DLinkedList<Integer> dlist = new DLinkedList<Integer>();
        NIO.addToDLL(DEFAULT_LIST, dlist);
        assert(dlist.size() == 9);
    }
    
    @Test
    public void testGetFromDLL(){
        reset();
        DLinkedList<Integer> dlist = new DLinkedList<Integer>();
        NIO.addToDLL(DEFAULT_LIST, dlist);
        List<Integer> nums = NIO.getFromDLL(dlist);
        assertEquals(nums, DEFAULT_LIST);
    }
    
    @Test
    public void testChangeNumbers(){
        reset();
        List<Integer> changedList = new ArrayList<Integer>(
                            List.of(2, 3, 4, 5, 6, 7, 8, 9, 10));
        DLinkedList<Integer> dlist = new DLinkedList<Integer>();
        NIO.addToDLL(DEFAULT_LIST, dlist);
        NIO.changeNumbers(dlist);
        List<Integer> nums = NIO.getFromDLL(dlist);
        assertEquals(nums, changedList);
    }
    
    
}
