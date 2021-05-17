import java.util.List;

/**
 * Abstract class Actor - write a description of the class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public interface Actor
{
    /**
     * Perform the actor's regular behavior.
     * @param newActors A list for receiving newly created actors.
     */
    void act(List<Actor> newActors);
    
    /**
     * Is the actor still alive?
     * @return true if still active, false if not.
     */
    boolean isActive();
}
