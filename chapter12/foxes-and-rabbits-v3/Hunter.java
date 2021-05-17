import java.util.List;
import java.util.Iterator;

/**
 * Write a description of class Hunter here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Hunter implements Actor
{
    private static final int MAX_KILL = 20;
    
    private int killQuota;
    private boolean active;
    private Field field;
    private Location location;
    

    /**
     * Constructor for objects of class Hunter
     */
    public Hunter(Field field, Location location)
    {
        killQuota = 0;
        active = true;
        this.field = field;
        setLocation(location);
    }
    
    /**
     * Place the animal at the new location in the given field.
     * @param newLocation The animal's new location.
     */
    protected void setLocation(Location newLocation)
    {
        if(location != null) {
            field.clear(location);
        }
        location = newLocation;
        field.place(this, newLocation);
    }
    
    public boolean isActive(){
        return active;
    }
    
    private Field getField(){
        return field;
    }
    
    private Location getLocation(){
        return location;
    }
    
    public void act(List<Actor> newHunter){          
        if(isActive()) {           
            // Move towards an animal to kill if found.
            Location newLocation = hunt();
            if(newLocation == null) { 
                // Nothing to hunt - try to move to a free location.
                newLocation = getField().freeAdjacentLocation(getLocation());
            }
            // See if it was possible to move.
            if(newLocation != null) {
                setLocation(newLocation);
            }
        }
    }
    
        private Location hunt(){
        Field field = getField();
        List<Location> adjacent = field.adjacentLocations(getLocation());
        Iterator<Location> it = adjacent.iterator();
        while(it.hasNext()){
            Location where = it.next();
            Object animal = field.getObjectAt(where);
            if(animal instanceof Rabbit || animal instanceof Fox || 
                animal instanceof Lion){
                Animal hunted = (Animal) animal;
                if(hunted.isActive()){
                    hunted.setDead();
                    return where;
                }
            }
        }
        return null;
    }
    

}
