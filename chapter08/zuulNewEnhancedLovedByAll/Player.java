import java.util.ArrayList;
/**
 * This is the Player class, which will hold information
 * and values related to the Player.
 *
 * @author (Devon Ceccacci)
 * @version (1.0 , 4/8/2021)
 */
public class Player
{
    private Room currentRoom;
    private String name;
    private ArrayList<Item> backpack;
    private int maxWeight;
    private int currentWeight;
    private int currentFatigue;
    private int maxFatigue;
    private boolean chargingBeamer;
    private Room beamerRoom;

    /**
     * Constructor for objects of class Player
     */
    public Player(String name, int maxWeight, int maxFatigue)
    {
        this.name = name;
        this.maxWeight = maxWeight;
        currentWeight = 0;
        this.maxFatigue = maxFatigue;
        currentFatigue = 0;
        backpack = new ArrayList<>();
        chargingBeamer = false;
    }
    
    
    /**
     * Commands that deal with fatigue
     */
    public int getMaxFatigue()
    {
        return maxFatigue;
    }
    public int getCurrentFatigue()
    {
        return currentFatigue;
    }
    public void increaseFatigue()
    {
        currentFatigue++;
    }
    public void resetFatigue()
    {
        currentFatigue = 0;
    }
    
    
    public int getMaxWeight()
    {
        return maxWeight;
    }
    public int getCurrentWeight()
    {
        return currentWeight;
    }
    
    public void setCurrentRoom(Room currentRoom)
    {
        this.currentRoom = currentRoom;
    }
    public Room getCurrentRoom()
    {
        return currentRoom;
    }
    
    public void addItem(Item item)
    {
        if(canItemBePickedUp(item))
        {
            backpack.add(item);
            currentWeight = currentWeight + item.getWeight();
        }
        else{
            System.out.println("item is to heavy to put into backpack");
        }
    }
    
    public void removeItem(Item item)
    {
        backpack.remove(item);
    }
    
    public boolean canItemBePickedUp(Item item)
    {
        if(maxWeight >= currentWeight + item.getWeight())
        {
            return true;
        }
        else{
            return false;
        }
    }
    
    public ArrayList getBackpack()
    {
        return backpack;
    }
    
    public Item dropItem(String item)
    {
        for(int i = 0; i < backpack.size(); i++)
        {
            if(backpack.get(i).getName().equals(item))
            { 
                currentWeight = currentWeight - backpack.get(i).getWeight();
                return backpack.get(i);
            }
        }
        return null;
    }
    
    public boolean magicCookie()
    {
        for(int i = 0; i < backpack.size(); i++)
        {
            if(backpack.get(i).getName() == "cookie")
            {
                maxWeight = maxWeight + 20;
                backpack.remove(i);
                return true;
            }
        }
        return false;
    }
    
    public boolean useBeamer()
    {
        if(chargingBeamer)
        {
            chargingBeamer = false;
            setCurrentRoom(currentBeamerRoom());
            return true;
        }
        else{
            chargingBeamer = true;
            beamerRoom = getCurrentRoom();
            return false;
        }
    }
    public Room currentBeamerRoom()
    {
        return beamerRoom;
    }
    
    public boolean hasItem(String item)
    {
        for(int i = 0; i < backpack.size(); i++)
        {
            if(backpack.get(i).getName().equals(item))
            { 
                return true;
            }
        }
        return false;
    }
}
