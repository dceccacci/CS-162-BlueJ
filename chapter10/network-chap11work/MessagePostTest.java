

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class MessagePostTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class MessagePostTest
{
    private NewsFeed newsFeed1;
    private MessagePost messageP1;
    private MessagePost messageP2;

    /**
     * Default constructor for test class MessagePostTest
     */
    public MessagePostTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        messageP1 = new MessagePost("Author Name 1", "Some Text 1");
        messageP2 = new MessagePost("Author Name 2", "Some Text 2");
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
}
