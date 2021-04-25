

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class NewsFeedTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class NewsFeedTest
{
    private NewsFeed newsFeed1;
    private MessagePost messageDaVinci;
    private MessagePost messageP2;
    private PhotoPost photoPos1;
    private PhotoPost photoPos2;

    /**
     * Default constructor for test class NewsFeedTest
     */
    public NewsFeedTest()
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
        newsFeed1 = new NewsFeed();
        messageDaVinci = new MessagePost("Leonardo da Vinci", "Had a great idea this morning.\n"
                                   +"But now I forgot what it was. Something to do with flying...");
        messageP2 = new MessagePost("Author Name 2", "Some Text 2");
        photoPos1 = new PhotoPost("Author 3", "File name 1", "Caption 1");
        photoPos2 = new PhotoPost("Author 4", "File name 2", "Caption 2");
        messageDaVinci.like();
        messageDaVinci.like();
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
