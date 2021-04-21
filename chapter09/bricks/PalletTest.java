

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class PalletTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class PalletTest
{
    private Pallet pallet1By1;
    private Pallet pallet10by10;
    private Pallet pallet1by10;
    private Pallet pallet10by1;

    /**
     * Default constructor for test class PalletTest
     */
    public PalletTest()
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
        pallet1By1 = new Pallet(1, 1);
        pallet10by10 = new Pallet(10, 10);
        pallet1by10 = new Pallet(1, 10);
        pallet10by1 = new Pallet(10, 1);
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
