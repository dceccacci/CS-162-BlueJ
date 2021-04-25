
/**
 * Write a description of class EventPost here.
 *
 * @author (Devon Ceccacci)
 * @version (Apr-20-2021)
 */
public class EventPost extends Post
{
    private String eventType;

    /**
     * Constructor for objects of class EventPost
     */
    public EventPost(String author, String eventType)
    {
        super(author);
        this.eventType = eventType;
    }
    
    /**
     * returns eventType
     */
    public String getEventType()
    {
        return eventType;
    }

}
