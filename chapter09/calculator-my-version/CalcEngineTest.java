

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CalcEngineTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class CalcEngineTest
{
    private CalcEngine calcEngi1;

    /**
     * Default constructor for test class CalcEngineTest
     */
    public CalcEngineTest()
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
        calcEngi1 = new CalcEngine();
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
    public void testOneNumToChain()
    {
        calcEngi1.numberPressed(5);
        assertEquals("5", calcEngi1.toString());
    }


    @Test
    public void testMultiNumToChain()
    {
        calcEngi1.numberPressed(5);
        calcEngi1.numberPressed(9);
        assertEquals("5 9", calcEngi1.toString());
    }

    @Test
    public void testArithmeticToChain()
    {
        calcEngi1.arithmeticPressed("+");
        assertEquals("", calcEngi1.toString());
        calcEngi1.numberPressed(5);
        calcEngi1.arithmeticPressed("+");
        calcEngi1.numberPressed(5);
        assertEquals(10, calcEngi1.calculate());
        calcEngi1.arithmeticPressed("+");
        calcEngi1.numberPressed(5);
        assertEquals(15, calcEngi1.calculate());
        calcEngi1.reset();
        calcEngi1.arithmeticPressed("+");
        assertEquals("", calcEngi1.toString());
    }

    @Test
    public void testNumAndArthToChain()
    {
        calcEngi1.numberPressed(5);
        calcEngi1.arithmeticPressed("+");
        calcEngi1.numberPressed(6);
        calcEngi1.arithmeticPressed("-");
        calcEngi1.numberPressed(7);
        assertEquals("5 + 6 - 7", calcEngi1.toString());
    }

    @Test
    public void testDisplayValue()
    {
        calcEngi1.numberPressed(5);
        assertEquals(5, calcEngi1.getDisplayValue());
        calcEngi1.arithmeticPressed("+");
        assertEquals(5, calcEngi1.getDisplayValue());
        calcEngi1.numberPressed(8);
        assertEquals(8, calcEngi1.getDisplayValue());
    }

    @Test
    public void testBasicAdd()
    {
        calcEngi1.numberPressed(2);
        calcEngi1.arithmeticPressed("+");
        calcEngi1.numberPressed(3);
        assertEquals(5, calcEngi1.calculate());
    }

    @Test
    public void testAddTwiceInARow()
    {
        calcEngi1.numberPressed(1);
        calcEngi1.arithmeticPressed("+");
        calcEngi1.numberPressed(2);
        calcEngi1.arithmeticPressed("+");
        calcEngi1.numberPressed(3);
        assertEquals(6, calcEngi1.calculate());
        calcEngi1.arithmeticPressed("+");
        calcEngi1.numberPressed(4);
        assertEquals(10, calcEngi1.calculate());
        calcEngi1.reset();
        assertEquals(0, calcEngi1.calculate());
    }

    @Test
    public void testSubtraction()
    {
        calcEngi1.numberPressed(5);
        calcEngi1.arithmeticPressed("-");
        calcEngi1.numberPressed(2);
        assertEquals(3, calcEngi1.calculate());
        calcEngi1.arithmeticPressed("-");
        calcEngi1.numberPressed(1);
        assertEquals(2, calcEngi1.calculate());
    }

    @Test
    public void testMultiArith()
    {
        calcEngi1.numberPressed(5);
        calcEngi1.arithmeticPressed("+");
        calcEngi1.numberPressed(5);
        calcEngi1.arithmeticPressed("-");
        calcEngi1.numberPressed(3);
        assertEquals(7, calcEngi1.calculate());
    }
}









