import java.util.List;
import java.util.Iterator;

/**
 * This is the Animal "human". The most deadliest animal of all.
 * Human ages, moves, and kills.
 *
 * @author (Devon Ceccacci)
 * @version (May-16-2021)
 */
public class Human extends Animal
{
    // The age at which a human can start to breed.
    private static final int BREEDING_AGE = 100;
    // The age to which a human can live.
    private static final int MAX_AGE = 400;
    // The likelihood of a human breeding.
    private static final double BREEDING_PROBABILITY = 0.0045;
    // The maximum number of births.
    private static final int MAX_LITTER_SIZE = 1;

    /**
     * Constructor for objects of class Human
     */
    public Human(boolean randomAge, Field field, Location location)
    {
        super(randomAge, field, location);
    }
    
    /**
     * @return the max litter size of the human.
     */
    public int getMaxLitter(){
        return MAX_LITTER_SIZE;
    }
    
    /**
     * @return the breeding probability of the human.
     */
    public double getBreedingProbability(){
        return BREEDING_PROBABILITY;
    }
    
    /**
     * @return The age at which a human starts to breed.
     */
    public int getBreedingAge(){
        return BREEDING_AGE;
    }
    
    /**
     * @return The maximum age of the human.
     */
    public int getMaxAge(){
        return MAX_AGE;
    }
    
    /**
     * Causes the human to act.
     */
    public void act(List<Animal> newHuman){
        incrementAge();
        if(isAlive()) {
            giveBirth(newHuman);            
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
     * Human hunts for sport.
     */
    private Location hunt(){
        Field field = getField();
        List<Location> adjacent = field.adjacentLocations(getLocation());
        Iterator<Location> it = adjacent.iterator();
        while(it.hasNext()){
            Location where = it.next();
            Object animal = field.getObjectAt(where);
            if(animal instanceof Rabbit || animal instanceof Fox){
                Animal hunted = (Animal) animal;
                if(hunted.isAlive()){
                    hunted.setDead();
                    return where;
                }
            }
        }
        return null;
    }
    
    public Human getNewAnimal(Field field, Location loc){
        Human young = new Human(false, field, loc);
        return young;
    }

}
