import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class SalesItemTest.
 *
 * @author  mik
 * @version 0.1
 */
public class SalesItemTest
{
    private SalesItem salesIte1;
    private SalesItem salesIte2;

    /**
     * Default constructor for test class SalesItemTest
     */
    public SalesItemTest()
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
        salesIte1 = new SalesItem("item", 300);
        salesIte2 = new SalesItem("stuff", 600);
        salesIte2.addComment("name1", "text", 3);
        salesIte2.addComment("name2", "text", 3);
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

    /**
     * Test that a comment can be added, and that the comment count is correct afterwards.
     */
    @Test
    public void testAddComment()
    {
        SalesItem salesIte1 = new SalesItem("Brain surgery for Dummies", 21998);
        assertEquals(true, salesIte1.addComment("James Duckling", "This book is great. I perform brain surgery every week now.", 4));
        assertEquals(1, salesIte1.getNumberOfComments());
    }

    /**
     * Test that a comment using an illegal rating value is rejected.
     */
    @Test
    public void testIllegalRating()
    {
        SalesItem salesIte1 = new SalesItem("Java For Complete Idiots, Vol 2", 19900);
        assertEquals(false, salesIte1.addComment("Joshua Black", "Not worth the money. The font is too small.", -5));
    }

    /**
     * Test that a sales item is correctly initialised (name and price).
     */
    @Test
    public void testInit()
    {
        SalesItem salesIte1 = new SalesItem("test name", 1000);
        assertEquals("test name", salesIte1.getName());
        assertEquals(1000, salesIte1.getPrice());
    }

    @Test
    public void addComment()
    {
        SalesItem salesIte1 = new SalesItem("Brain Surgery for Dummies.", 9899);
        assertEquals(true, salesIte1.addComment("Fred", "Great - I perform brain surgery every week now!", 4));
    }

    @Test
    public void test()
    {
        SalesItem salesIte1 = new SalesItem("apple", 200);
        assertEquals(true, salesIte1.addComment("human", "I like apples", 5));
        assertEquals(true, salesIte1.addComment("otherHuman", "food is alright", 1));
        assertEquals(2, salesIte1.getNumberOfComments());
    }

    @Test
    public void addCommentSameAuthor()
    {
        SalesItem salesIte1 = new SalesItem("apple", 200);
        assertEquals(true, salesIte1.addComment("human", "food", 3));
        assertEquals(false, salesIte1.addComment("human", "I continue to food", 4));
    }

    @Test
    public void checkRatingsOutsideBoundaries()
    {
        SalesItem salesIte1 = new SalesItem("item", 400);
        assertEquals(false, salesIte1.addComment("human1", "text", 0));
        assertEquals(false, salesIte1.addComment("human2", "some text", 6));
    }

    @Test
    public void testFindMostHelpfulComment()
    {
        SalesItem salesIte1 = new SalesItem("item", 100);
        assertEquals(true, salesIte1.addComment("name", "text", 3));
        salesIte1.upvoteComment(0);
        Comment comment1 = salesIte1.findMostHelpfulComment();
        assertEquals("name", comment1.getAuthor());
        assertEquals(3, comment1.getRating());
        assertEquals(1, comment1.getVoteCount());
    }
}







