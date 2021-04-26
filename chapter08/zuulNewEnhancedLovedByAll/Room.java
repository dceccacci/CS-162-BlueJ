import java.util.HashMap;
import java.util.Set;
import java.util.ArrayList;
import java.util.Collection;
/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  The exits are labelled north, 
 * east, south, west.  For each direction, the room stores a reference
 * to the neighboring room, or null if there is no exit in that direction.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */
public class Room 
{
    private String description;
    private String shortName;
    private HashMap<String, Room> exits;    // stores exits of this room
    private ArrayList<Item> items;      // stores items in the room
    private boolean lockedDoor;
    private ArrayList<Character> characters = new ArrayList<Character>();

    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */
    public Room(String description, String shortName) 
    {
        this.description = description;
        exits = new HashMap<>();
        items = new ArrayList<>();
        lockedDoor = false;
        this.shortName = shortName;
    }
    
    /**
     * returns the ArrayList of exits
     */
    public ArrayList getAllExits()
    {
        ArrayList<Room> roomList = new ArrayList<Room>();
        exits.values().stream()
                      .forEach(room -> roomList.add(room));
        return roomList;
    }
    
    public String getShortName()
    {
        return shortName;
    }
    
    /**
     * Define an exit from this room.
     * @param direction The direction of the exit.
     * @param neighbor The room in the given direction.
     */
    public void setExits(String direction, Room neighbor) 
    {
        exits.put(direction, neighbor);
    }
    
    /**
     * Set items to the this room.
     */
    public void setItems(Item item)
    {
        items.add(item);
    }

    /**
     * @return The description of the room.
     */
    public String getDescription()
    {
        return description;
    }
    
    public Room getExit(String direction)
    {
        if(exits.containsKey(direction)){
            return exits.get(direction);
        }
        else{
            return null;
        }
    }
    
    /**
     * Return a description of the room's exits,
     * for example, "Exits: north west".
     * @return A description of the available exits.
     */
    public String getExitString()
    {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for(String exit : keys){
            returnString += " " + exit;
        }
        return returnString;
    }
    
    /**
     * Return the name of the items in the room as an Arraylist.
     * @return Items in room.
     */
    public ArrayList getItemArray()
    {
        if(items.isEmpty())
        {
            return null;
        }
        else{
            return items;
        }
    }
    
    /**
     * Return a long description of this room, of the form:
     *          You are in the kitchen.
     *          Exits: north west
     * @return A description of the room, including exits.
     */
    public String getLongDescription()
    {
        return "You are " + description + ".\n" + getExitString();
    }
    
    public Item takeItem(String item)
    {
        for(int i = 0; i < items.size(); i++)
        {
            if(items.get(i).getName().equals(item))
            {
                return items.get(i);
            }
        }
        return null;
    }
    
    public void removeItem(Item item)
    {
        items.remove(item);
    }
    
    public boolean getLockedDoor()
    {
        return lockedDoor;
    }
    
    public void toggleLockDoor()
    {
        if(lockedDoor)
        {
            lockedDoor = false;
        }
        else{
            lockedDoor = true;
        }
    }
    
    public void addCharacter(Character character)
    {
        characters.add(character);
    }
    
    public Character getCharacter(String character)
    {
        for(int i = 0; i < characters.size(); i++)
        {
            if(characters.get(i).getName().equals(character))
            { 
                return characters.get(i);
            }
        }
        return null;
    }
    
    public ArrayList getCharacterList()
    {
        return characters;
    }
    
    public void removeCharacter(Character character)
    {
        characters.remove(character);
    }
}
