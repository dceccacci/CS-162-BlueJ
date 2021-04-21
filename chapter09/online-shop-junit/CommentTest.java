

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CommentTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class CommentTest
{
    private Comment comment1;

    /**
     * Default constructor for test class CommentTest
     */
    public CommentTest()
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
        comment1 = new Comment("name", "text", 3);
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
    public void testCommentAuthorRatingStores()
    {
        Comment comment1 = new Comment("name", "some text", 3);
        assertEquals("name", comment1.getAuthor());
        assertEquals(3, comment1.getRating());
    }

    @Test
    public void testUpvote()
    {
        Comment comment1 = new Comment("name", "some text", 3);
        comment1.upvote();
        assertEquals(1, comment1.getVoteCount());
    }

    @Test
    public void testDownvote()
    {
        Comment comment1 = new Comment("name", "some text", 3);
        comment1.upvote();
        comment1.upvote();
        comment1.upvote();
        comment1.downvote();
        assertEquals(2, comment1.getVoteCount());
    }

    @Test
    public void testNegVote()
    {
        comment1.downvote();
        assertEquals(0, comment1.getVoteCount());
    }
}





