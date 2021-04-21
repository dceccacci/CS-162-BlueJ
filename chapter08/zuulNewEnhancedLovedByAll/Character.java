
/**
 * Write a description of class NPC here.
 *
 * @author (Devon Ceccacci)
 * @version (Apr-09-2021)
 */
public class Character
{
    private String name;
    private String greeting;
    private String triggerItem;
    private String triggerResponse;
    private Room currentRoom;
    
    /**
     * Constructor for objects of class NPC
     */
    public Character(String name)
    {
        this.name = name;
    }
    
    public void setCurrentRoom(Room room)
    {
        this.currentRoom = room;
    }
    
    public Room getCurrentRoom()
    {
        return currentRoom;
    }
    
    public void setTrigger(String item)
    {
        triggerItem = item;
    }
    public String getTriggerItem()
    {
        return triggerItem;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setGreeting(String greeting)
    {
        this.greeting = greeting;
    }
    
    public String getGreeting()
    {
        return greeting;
    }
    
    public void setTriggerResponse(String trigger)
    {
        triggerResponse = trigger;
    }
    
    public String getTriggerResponse()
    {
        return triggerResponse;
    }

}
