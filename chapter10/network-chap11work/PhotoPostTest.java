

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class PhotoPostTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class PhotoPostTest
{
    private PhotoPost photoPos1;
    private PhotoPost photoPos2;

    /**
     * Default constructor for test class PhotoPostTest
     */
    public PhotoPostTest()
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
        photoPos1 = new PhotoPost("Author 3", "File name 1", "Caption 1");
        photoPos2 = new PhotoPost("Author 4", "File name 2", "Caption 2");
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
