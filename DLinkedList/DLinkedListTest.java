

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class DLinkedListTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class DLinkedListTest<E>
{
    private Person person1;
    private Person person2;
    private Person person3;
    private Person person4;
    private Person person5;
    private DLinkedList<Person> dLinkedL1;

    /**
     * Default constructor for test class DLinkedListTest
     */
    public DLinkedListTest()
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
        person1 = new Person("Devon", "Ceccacci", "012345678");
        person2 = new Person("John" , "Doe", "123456789");
        person3 = new Person("Jane" , "Doe", "223456789");
        person4 = new Person("Jack" , "Sparrow", "112345678");
        person5 = new Person("Trevor" , "Belmont", "323456789");
        dLinkedL1 = new DLinkedList<Person>();
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
    
    @Test
    public void testAdd(){
       dLinkedL1.add(person1);
       Node<Person> x = dLinkedL1.getFirst();
       Person y = x.getData();
       assertEquals("Devon", y.getFirstName());
       dLinkedL1.add(person2);
       assertEquals(dLinkedL1.get(1).getData(), person2);
    }
    
    @Test
    public void testGet(){
        dLinkedL1.add(person1);
        dLinkedL1.add(person2);
        dLinkedL1.add(person3);
        dLinkedL1.add(person4);
        dLinkedL1.addFirst(person5);
        Node<Person> x = dLinkedL1.get(2);
        Person y = x.getData();
        assertEquals("Doe, Jane ID: 223456789", y.toString());
        assertEquals(null, dLinkedL1.get(5));
    }
    
    @Test
    public void testDelete(){
        dLinkedL1.add(person1);
        dLinkedL1.add(person2);
        dLinkedL1.add(person3);
        dLinkedL1.add(person4);
        Node<Person> x = dLinkedL1.delete(2);
        assertEquals(x.getData(), person3);
        assertEquals(dLinkedL1.get(0).getData(), person1);
        assertEquals(dLinkedL1.get(1).getData(), person2);
        assertEquals(dLinkedL1.get(2).getData(), person4);
        assertEquals(null, dLinkedL1.get(3));
        assertEquals(3, dLinkedL1.size());
    }
    
    @Test
    public void testDeleteFirst(){
        dLinkedL1.add(person1);
        dLinkedL1.add(person2);
        dLinkedL1.deleteFirst();
        assertEquals(dLinkedL1.get(0).getData(), person2);
        assertEquals(1, dLinkedL1.size());
    }
    
    @Test
    public void testDeleteLast(){
        dLinkedL1.add(person1);
        dLinkedL1.add(person2);
        dLinkedL1.add(person3);
        dLinkedL1.deleteLast();
        assertEquals(dLinkedL1.get(0).getData(), person1);
        assertEquals(dLinkedL1.get(1).getData(), person2);
        assertEquals(null, dLinkedL1.get(2));
        assertEquals(2, dLinkedL1.size());
    }
    
    @Test
    public void testSize(){
        dLinkedL1.add(person1);
        dLinkedL1.add(person2);
        dLinkedL1.add(person3);
        assertEquals(3, dLinkedL1.size());
    }
    
    @Test
    public void clear(){
        dLinkedL1.add(person1);
        dLinkedL1.add(person2);
        dLinkedL1.add(person3);
        dLinkedL1.clear();
        assertEquals(0, dLinkedL1.size());
        assertEquals(null, dLinkedL1.get(0));
    }
    
    @Test
    public void contains(){
        dLinkedL1.add(person1);
        dLinkedL1.add(person2);
        dLinkedL1.add(person3);
        assertEquals(false, dLinkedL1.contains(person4));
        assertEquals(true, dLinkedL1.contains(person2));
    }
    
    @Test
    public void getFirst(){
        dLinkedL1.add(person1);
        dLinkedL1.add(person2);
        dLinkedL1.add(person3);
        assertEquals(dLinkedL1.getFirst().getData(), person1);
    }
    
    @Test
    public void getLast(){
        dLinkedL1.add(person1);
        dLinkedL1.add(person2);
        dLinkedL1.add(person3);
        assertEquals(dLinkedL1.getLast().getData(), person3);
    }
    
    @Test
    public void set(){
        dLinkedL1.add(person1);
        dLinkedL1.add(person2);
        dLinkedL1.add(person3);
        dLinkedL1.set(1, person4);
        assertEquals(dLinkedL1.get(1).getData(), person4);
    }
    
    
}
