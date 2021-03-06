import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.Color;

/**
 * A simple predator-prey simulator, based on a rectangular field containing 
 * rabbits and foxes.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29
 */
public class Simulator
{
    // Constants representing configuration information for the simulation.
    // The default width for the grid.
    private static final int DEFAULT_WIDTH = 120;
    // The default depth of the grid.
    private static final int DEFAULT_DEPTH = 80;  

    // Lists of animals in the field.
    private List<Animal> animals;
    // The current state of the field.
    private Field field;
    // The current step of the simulation.
    private int step;
    // A graphical view of the simulation.
    private SimulatorView view;
    
    /**
     * Construct a simulation field with default size.
     */
    public Simulator()
    {
        this(DEFAULT_DEPTH, DEFAULT_WIDTH);
    }
    
    /**
     * Create a simulation field with the given size.
     * @param depth Depth of the field. Must be greater than zero.
     * @param width Width of the field. Must be greater than zero.
     */
    public Simulator(int depth, int width)
    {
        if(width <= 0 || depth <= 0) {
            System.out.println("The dimensions must be >= zero.");
            System.out.println("Using default values.");
            depth = DEFAULT_DEPTH;
            width = DEFAULT_WIDTH;
        }
        
        animals = new ArrayList<>();
        field = new Field(depth, width);

        // Create a view of the state of each location in the field.
        view = new SimulatorView(depth, width);
        
        // Setup a valid starting point.
        reset();
    }
    
    /**
     * Run the simulation from its current state for a reasonably long 
     * period (4000 steps).
     */
    public void runLongSimulation()
    {
        simulate(4000);
    }
    
    /**
     * Run the simulation for the given number of steps.
     * Stop before the given number of steps if it ceases to be viable.
     * @param numSteps The number of steps to run for.
     */
    public void simulate(int numSteps)
    {
        for(int step=1; step <= numSteps && view.isViable(field); step++) {
            simulateOneStep();
            delay(20);   // uncomment this to run more slowly
        }
    }
    
    /**
     * Run the simulation from its current state for a single step. Iterate
     * over the whole field updating the state of each fox and rabbit.
     */
    public void simulateOneStep()
    {
        step++;

        // Provide space for newborn animals.
        List<Animal> newAnimals = new ArrayList<>();        
        // Let all ahimals act.
        for(Iterator<Animal> it = animals.iterator(); it.hasNext(); ) {
            Animal animal = it.next();
            animal.act(newAnimals);
            if(! animal.isAlive()) {
                it.remove();
            }
        }
        
        // Add the newly born foxes and rabbits to the main lists.
        animals.addAll(newAnimals);

        view.showStatus(step, field);
        // testDOA(newFoxes, newRabbits); // work in progress
    }
    
    /**
     * Test to see there is no animal(dead or alive) in the field that is not in 
     * the Fox or Rabbit lists.
     * WORK IN PROGRESS
    
    public void testDOA(List<Fox> newFoxes, List<Rabbit> newRabbits){
        // Tests to see if the Field has the passed in animal yet
        for(int i = 0; i < newFoxes.size(); i++){
            Fox tempFox = newFoxes.get(i);
            if(field.getObjectAt(tempFox.getLocation()) == null){
                field.place(tempFox, tempFox.getLocation());
            }
        }
        for(int i = 0; i < newRabbits.size(); i++){
            Rabbit tempRabbit = newRabbits.get(i);
            if(field.getObjectAt(tempRabbit.getLocation()) == null){
                field.place(tempRabbit, tempRabbit.getLocation());
            }
        }
        
        // Tests to see if the Field has an animal not on the list yet
        List<Object> fieldAnimals = new ArrayList<>(); 
        for(int row = 0; row < field.getDepth(); row++){
            for(int col = 0; col < field.getWidth(); col++){
                Object tempAnimal = field.getObjectAt(row, col);
                if(tempAnimal != null){     //if an animal is in the spot
                    tempAnimal.getLocation();
                    
                }
            }
        }
    }
    */
    
    /**
     * Reset the simulation to a starting position.
     */
    public void reset()
    {
        PopulationGenerator popGen = new PopulationGenerator(view, field);
        step = 0;
        animals = popGen.populate();
        
        // Show the starting state in the view.
        view.showStatus(step, field);
    }
        
    /**
     * Pause for a given time.
     * @param millisec  The time to pause for, in milliseconds
     */
    private void delay(int millisec)
    {
        try {
            Thread.sleep(millisec);
        }
        catch (InterruptedException ie) {
            // wake up
        }
    }
}
