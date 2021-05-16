
/**
 * Write a description of class Animal here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Animal
{
    // Whether the animal is alive or not.
    private boolean alive;
    // The animal's position.
    private Location location;
    // The field occupied.
    private Field field;


    /**
     * Constructor for objects of class Animal
     */
    public Animal(Field field, Location location)
    {
        alive = true;
        this.field = field;
        setLocation(location);
    }
    
    /**
     * Returns a boolean, true if alive, false if dead.
     */
    public boolean isAlive(){
        return alive;
    }
    
    /**
     * Returns the animals field
     */
    public Field getField(){
        return field;
    }
    
    /**
     * Return the rabbit's location.
     * @return The rabbit's location.
     */
    protected Location getLocation()
    {
        return location;
    }
    
    /**
     * Indicate that the rabbit is no longer alive.
     * It is removed from the field.
     */
    protected void setDead()
    {
        alive = false;
        if(location != null) {
            field.clear(location);
            location = null;
            field = null;
        }
    }
    
    /**
     * Place the rabbit at the new location in the given field.
     * @param newLocation The rabbit's new location.
     */
    public void setLocation(Location newLocation)
    {
        if(location != null) {
            field.clear(location);
        }
        location = newLocation;
        field.place(this, newLocation);
    }

}
