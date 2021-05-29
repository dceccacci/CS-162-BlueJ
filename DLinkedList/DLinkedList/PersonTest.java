

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class PersonTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class PersonTest
{
    private Person person1;
    private Person person2;
    private Person person3;
    private Person person4;
    private Person person5;

    /**
     * Default constructor for test class PersonTest
     */
    public PersonTest()
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
        person3 = new Person("Jane" , "Doe", "ABCDEFGHI");
        person4 = new Person("Jack" , "Sparrow", "12345678");
        person5 = new Person("Trevor" , "Belmont", "0123456789");
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
    public void testGetFirstName()
    {
        assertEquals("Devon", person1.getFirstName());
    }
    
    @Test
    public void testGetLastName()
    {
        assertEquals("Ceccacci", person1.getLastName());
    }
    
    @Test
    public void testGetID()
    {
        assertEquals("012345678", person1.getID());
        assertEquals("123456789", person2.getID());
        assertEquals(null, person3.getID());
        assertEquals(null, person4.getID());
        assertEquals(null, person5.getID());
    }
    
}

