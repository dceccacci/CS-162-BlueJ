

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class ContactDetailsTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ContactDetailsTest
{
    private ContactDetails contactD1;

    /**
     * Default constructor for test class ContactDetailsTest
     */
    public ContactDetailsTest()
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
        contactD1 = new ContactDetails("Devon", "5551234", "something@thatplace.com");
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
    public void testGetAddress()
    {
        assertEquals("something@thatplace.com", contactD1.getAddress(0));
    }

    @Test
    public void testMultipleAddresses()
    {
        contactD1.addAddress("number2@place.com");
        contactD1.addAddress("number3@place.com");
        assertEquals("number2@place.com", contactD1.getAddress(1));
        assertEquals("number3@place.com", contactD1.getAddress(2));
    }
    
    @Test
    public void testToString()
    {
        contactD1.addAddress("number2@place.com");
        contactD1.addAddress("number3@place.com");
        assertEquals("Devon\n5551234\nsomething@thatplace.com\nnumber2@place.com\nnumber3@place.com\n",
                        contactD1.toString());
    }
}


