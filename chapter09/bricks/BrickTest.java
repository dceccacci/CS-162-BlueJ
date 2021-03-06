

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class BrickTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class BrickTest
{
    private Brick brick1;

    /**
     * Default constructor for test class BrickTest
     */
    public BrickTest()
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
        brick1 = new Brick(8, 20, 12);
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

    @Test
    public void testSurfaceArea()
    {
        assertEquals(992, brick1.getSurfaceArea(), 0.1);
    }

    @Test
    public void testGetHeight()
    {
        assertEquals(8, brick1.getHeight(), 0.1);
    }

    @Test
    public void testGetVolume()
    {
        assertEquals(1920, brick1.getVolume());
    }

    @Test
    public void testGetWeight()
    {
        assertEquals(3.84, brick1.getWeight(), 0.1);
    }
}




