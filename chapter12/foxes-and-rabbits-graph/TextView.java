import java.util.Map;
import java.awt.Color;

/**
 * Write a description of class TextView here.
 *
 * @author (Devon Ceccacci)
 * @version (a version number or a date)
 */
public class TextView implements SimulatorView
{
    private FieldStats stats;

    /**
     * Constructor for objects of class TextView
     */
    public TextView()
    {
        stats = new FieldStats();
    }
    
    public void reset(){
        stats.reset();
    }
    
    public void showStatus(int step, Field field){
        for(int row = 0; row < field.getDepth(); row++) {
            for(int col = 0; col < field.getWidth(); col++) {
                Object animal = field.getObjectAt(row, col);
                if(animal != null) {
                    Class<?> cls = animal.getClass();
                    stats.incrementCount(cls);
                }
            }
        }
        stats.countFinished();
        System.out.println(stats.getPopulationDetails(field));
        reset();
    }
    
    
    public boolean isViable(Field field){
        return stats.isViable(field);
    }
    
    
    public void setColor(Class<?> animalClass, Color color)
    {
        
    }


}
