import java.util.Random;
import java.awt.Color;
import java.util.List;
import java.util.ArrayList;

/**
 * Write a description of class PopulationGenerator here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PopulationGenerator
{
    // The probability that a fox will be created in any given grid position.
    private static final double FOX_CREATION_PROBABILITY = 0.02;
    // The probability that a rabbit will be created in any given position.
    private static final double RABBIT_CREATION_PROBABILITY = 0.08;  
    
    // Current state of the field
    private Field field;
    // a graphical view of the simulation
    private SimulatorView view;

    /**
     * Constructor for objects of class PopulationGenerator
     */
    public PopulationGenerator(SimulatorView view, Field field)
    {
        this.field = field;
        this.view = view;
        view.setColor(Rabbit.class, Color.ORANGE);
        view.setColor(Fox.class, Color.BLUE);
    }
    
    public List<Animal> populate(){
        List<Animal> newAnimals = new ArrayList<>();
        Random rand = Randomizer.getRandom();
        field.clear();
        for(int row = 0; row < field.getDepth(); row++) {
            for(int col = 0; col < field.getWidth(); col++) {
                if(rand.nextDouble() <= FOX_CREATION_PROBABILITY) {
                    Location location = new Location(row, col);
                    Fox fox = new Fox(true, field, location);
                    newAnimals.add(fox);
                }
                else if(rand.nextDouble() <= RABBIT_CREATION_PROBABILITY) {
                    Location location = new Location(row, col);
                    Rabbit rabbit = new Rabbit(true, field, location);
                    newAnimals.add(rabbit);
                }
                // else leave the location empty.
            }
        }
        return newAnimals;
    }
}
