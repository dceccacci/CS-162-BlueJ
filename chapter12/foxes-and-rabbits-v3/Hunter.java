import java.util.List;
import java.util.Iterator;
import java.util.Random;

/**
 * Write a description of class Hunter here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Hunter implements Actor
{
    private static final Random rand = Randomizer.getRandom();
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
            hunt();
            List<Location> allFreeLocations = field.getAllFreeLocation();
            Location newLocation = allFreeLocations.get(rand.nextInt(allFreeLocations.size()));
            setLocation(newLocation);
        }
    }
    
    private void hunt(){
        Field field = getField();
        List<Location> adjacent = field.shuffleAdjacentFiveByFive(getLocation());
        Iterator<Location> it = adjacent.iterator();
        int ammo = rand.nextInt(4)+1;
        while(it.hasNext() && ammo > 0){
            Location where = it.next();
            Object animal = field.getObjectAt(where);
            if(animal instanceof Rabbit || animal instanceof Fox || 
                animal instanceof Lion){
                Animal hunted = (Animal) animal;
                if(hunted.isActive()){
                    hunted.setDead();
                    ammo--;
                }
            }
        }
    }

}
