
/**
 * This class holds decription and weight of different items.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Item
{
    private String itemDescription;
    private String itemName;
    private int itemWeight;

    /**
     * Creates an item. Sets the name and weight of item by passed paramaters.
     * @param name   The String name of the item.
     * @param weight    The int weight of the item. (measured in pounds)
     */
    public Item(String name, int weight, String description)
    {
        this.itemName = name;
        this.itemWeight = weight;
        this.itemDescription = description;
    }
    
    /**
     * Return String name of item.
     */
    public String getName()
    {
        return itemName;
    }
    
    /**
     * Return int weight of item.
     */
    public int getWeight()
    {
        return itemWeight;
    }
    
    public String getDescription()
    {
        return itemDescription;
    } 
    
}
