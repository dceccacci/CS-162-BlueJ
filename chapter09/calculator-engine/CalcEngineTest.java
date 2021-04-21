

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CalcEngineTest.
 *
 * @author  (Devon Ceccacci)
 * @version (version 1.2)
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
    public void testPlus()
    {
        calcEngi1.clear();
        calcEngi1.numberPressed(3);
        calcEngi1.plus();
        calcEngi1.numberPressed(4);
        calcEngi1.equals();
        assertEquals(7, calcEngi1.getDisplayValue());
    }

    @Test
    public void testPlusBack2Back()
    {
        calcEngi1.clear();
        calcEngi1.numberPressed(3);
        calcEngi1.plus();
        calcEngi1.numberPressed(4);
        calcEngi1.equals();
        assertEquals(7, calcEngi1.getDisplayValue());
        calcEngi1.clear();
        calcEngi1.numberPressed(3);
        calcEngi1.plus();
        calcEngi1.numberPressed(4);
        calcEngi1.equals();
        assertEquals(7, calcEngi1.getDisplayValue());
    }

    @Test
    public void testMinus()
    {
        calcEngi1.clear();
        calcEngi1.numberPressed(9);
        calcEngi1.minus();
        calcEngi1.numberPressed(4);
        calcEngi1.equals();
        assertEquals(5, calcEngi1.getDisplayValue());
    }
    
    @Test
    public void testMinusBack2Back()
    {
        calcEngi1.clear();
        calcEngi1.numberPressed(9);
        calcEngi1.minus();
        calcEngi1.numberPressed(4);
        calcEngi1.equals();
        assertEquals(5, calcEngi1.getDisplayValue());
        calcEngi1.clear();
        calcEngi1.numberPressed(9);
        calcEngi1.minus();
        calcEngi1.numberPressed(4);
        calcEngi1.equals();
        assertEquals(5, calcEngi1.getDisplayValue());
    }
    
    @Test
    public void testPlusThenMinus()
    {
        calcEngi1.clear();
        calcEngi1.numberPressed(3);
        calcEngi1.plus();
        calcEngi1.numberPressed(4);
        calcEngi1.equals();
        assertEquals(7, calcEngi1.getDisplayValue());
        calcEngi1.clear();
        calcEngi1.numberPressed(9);
        calcEngi1.minus();
        calcEngi1.numberPressed(4);
        calcEngi1.equals();
        assertEquals(5, calcEngi1.getDisplayValue());
    }
    
    @Test
    public void testMinusThenPlus()
    {
        calcEngi1.clear();
        calcEngi1.numberPressed(9);
        calcEngi1.minus();
        calcEngi1.numberPressed(4);
        calcEngi1.equals();
        assertEquals(5, calcEngi1.getDisplayValue());
        calcEngi1.clear();
        calcEngi1.numberPressed(3);
        calcEngi1.plus();
        calcEngi1.numberPressed(4);
        calcEngi1.equals();
        assertEquals(7, calcEngi1.getDisplayValue());
    }
    
}



