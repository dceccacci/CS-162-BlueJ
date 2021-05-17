import java.util.List;
import java.util.Iterator;

/**
 * This is the Animal "lion". The most deadliest animal of all.
 * Lion ages, moves, and kills.
 *
 * @author (Devon Ceccacci)
 * @version (May-16-2021)
 */
public class Lion extends Animal
{
    // The age at which a lion can start to breed.
    private static final int BREEDING_AGE = 100;
    // The age to which a lion can live.
    private static final int MAX_AGE = 400;
    // The likelihood of a lion breeding.
    private static final double BREEDING_PROBABILITY = 0.0045;
    // The maximum number of births.
    private static final int MAX_LITTER_SIZE = 1;
    
    // The food value
    private static final int FOOD_VALUE = 25;
    

    
    // Individual characteristics (instance fields).
    // The lion's food level, which is increased by eating rabbits, foxs.
    private int foodLevel;
    /**
     * Constructor for objects of class Lion
     */
    public Lion(boolean randomAge, Field field, Location location)
    {
        super(randomAge, field, location);
        if(randomAge) {
            foodLevel = getRand().nextInt(getFoodValue());
        }
        else {
            foodLevel = getFoodValue();
        }
    }
    
    /**
     * @returns food value
     */
    public int getFoodValue(){
        return FOOD_VALUE;
    }
    
    /**
     * @return the max litter size of the lion.
     */
    public int getMaxLitter(){
        return MAX_LITTER_SIZE;
    }
    
    /**
     * @return the breeding probability of the lion.
     */
    public double getBreedingProbability(){
        return BREEDING_PROBABILITY;
    }
    
    /**
     * @return The age at which a lion starts to breed.
     */
    public int getBreedingAge(){
        return BREEDING_AGE;
    }
    
    /**
     * @return The maximum age of the lion.
     */
    public int getMaxAge(){
        return MAX_AGE;
    }
    
    /**
     * Causes the lion to act.
     */
    public void act(List<Actor> newLion){
        incrementAge();
        incrementHunger();
        if(isActive()) {
            giveBirth(newLion);            
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
            else {
                // Overcrowding.
                setDead();
            }
        }
    }
    
    /**
     * Make this fox more hungry. This could result in the fox's death.
     */
    private void incrementHunger()
    {
        foodLevel--;
        if(foodLevel <= 0) {
            setDead();
        }
    }
    
    /**
     * Lion hunts for sport.
     */
    private Location hunt(){
        Field field = getField();
        List<Location> adjacent = field.adjacentLocations(getLocation());
        Iterator<Location> it = adjacent.iterator();
        while(it.hasNext()){
            Location where = it.next();
            Object actor = field.getObjectAt(where);
            if(actor instanceof Rabbit || actor instanceof Fox){
                Animal hunted = (Animal) actor;
                if(hunted.isActive()){
                    hunted.setDead();
                    foodLevel = foodLevel + hunted.getFoodValue();
                    return where;
                }
            }
        }
        return null;
    }
    
    public Lion getNewAnimal(Field field, Location loc){
        Lion young = new Lion(false, field, loc);
        return young;
    }

}
