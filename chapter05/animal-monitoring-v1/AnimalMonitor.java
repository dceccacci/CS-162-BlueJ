import java.util.ArrayList;
import java.util.Iterator;
import java.util.*;

/**
 * Monitor counts of different types of animal.
 * Sightings are recorded by spotters.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29 (imperative)
 */
public class AnimalMonitor 
{
    // Records of all the sightings of animals.
    private ArrayList<Sighting> sightings;
    
    /**
     * Create an AnimalMonitor.
     */
    public AnimalMonitor()
    {
        this.sightings = new ArrayList<>();
        addSightings();
    }
    
    /**
     * Add the sightings recorded in the given filename to the current list.
     * @param filename A CSV file of Sighting records.
     * CHANGED to automatically add premade "sightings.csv"
     * took out String filename in the parameter and 
     * changed filename in getSightings(filename)
     */
    public void addSightings()
    {
        SightingReader reader = new SightingReader();
        sightings.addAll(reader.getSightings("sightings.csv"));
    }
    
    /**
     * Print details of all the sightings.
     */
    public void printList()
    {
        sightings.forEach(record ->
        System.out.println(record.getDetails()));
    }
    
    /**
     * Print the details of all the sightings of the given animal.
     * @param animal The type of animal.
     */
    public void printSightingsOf(String animal)
    {
        sightings.stream()
                 .filter(sighting -> animal.equals(sighting.getAnimal()))
                 .forEach(sighting -> System.out.println(sighting.getDetails()));
    }
    
    /**
     * Print all the sightings by the given spotter.
     * @param spotter The ID of the spotter.
     */
    public void printSightingsBy(int spotter)
    {
        sightings.stream()
                 .filter(sighting -> sighting.getSpotter() == spotter)
                 .map(sighting -> sighting.getCount())
                 .forEach(System.out :: println);
    }
    
    /**
     * Print a list of the types of animal considered to be endangered.
     * @param animalNames A list of animals names.
     * @param dangerThreshold Counts less-than or equal-to to this level
     *                        are considered to be dangerous.
     */
    public void printEndangered(ArrayList<String> animalNames, 
                                int dangerThreshold)
    {
        for(String animal : animalNames)
        {
            sightings.stream()
                     .filter(sighting -> animal.equals(sighting.getAnimal()))
                     .filter(sighting -> sighting.getCount() <= dangerThreshold)
                     .map(sighting -> sighting.getAnimal())
                     .forEach(detail -> System.out.println(detail + " is endangered."));
        }
    }
    
    /**
     * Passes parameters to the printEndangered method to test its functionality
     */
    public void endangeredTest()
    {
        ArrayList<String> animalList = new ArrayList<String>();
        animalList.add("Mountain Gorilla");
        animalList.add("Buffalo");
        animalList.add("Elephant");
        animalList.add("Topi");
        printEndangered(animalList, 10);
    }
    
    /**
     * Return a count of the number of sightings of the given animal.
     * @param animal The type of animal.
     * @return The count of sightings of the given animal.
     */
    public int getCount(String animal)
    {
        return sightings.stream()
                        .filter(sighting -> animal.equals(sighting.getAnimal()))
                        .map(sighting -> sighting.getCount())
                        .reduce(0, (total,count) -> total + count);
    }
    
    /**
     * Remove from the sightings list all of those records with
     * a count of zero.
     */
    public void removeZeroCounts()
    {
        sightings.removeIf(sighting -> sighting.getCount() == 0);
    }
    
    /**
     * Return a list of all sightings of the given type of animal
     * in a particular area.
     * @param animal The type of animal.
     * @param area The ID of the area.
     * @return A list of sightings.
     */
    public ArrayList<Sighting> getSightingsInArea(String animal, int area)
    {
        ArrayList<Sighting> records = new ArrayList<>();
        for(Sighting record : sightings) {
            if(animal.equals(record.getAnimal())) {
                if(record.getArea() == area) {
                    records.add(record);
                }
            }
        }
        return records;
    }
    
    /**
     * Return a list of all the sightings of the given animal.
     * @param animal The type of animal.
     * @return A list of all sightings of the given animal.
     */
    public ArrayList<Sighting> getSightingsOf(String animal)
    {
        ArrayList<Sighting> filtered = new ArrayList<>();
        for(Sighting record : sightings) {
            if(animal.equals(record.getAnimal())) {
                filtered.add(record);
            }
        }
        return filtered;
    }
    
    public void printSightingsOnDay(int dayID)
    {
        sightings.stream()
                 .filter(sighting -> sighting.getPeriod() == dayID)
                 .forEach(sighting -> System.out.println(sighting.getDetails()));
    }
    
    public void printAnimalDay(String animal, int dayID)
    {
        sightings.stream()
                 .filter(sighting -> sighting.getPeriod() == dayID)
                 .filter(sighting -> animal.equals(sighting.getAnimal()))
                 .forEach(sighting -> System.out.println(sighting.getDetails()));
    }
    
    public void printCountAnimal(String animal)
    {
        sightings.stream()
                 .filter(sighting -> animal.equals(sighting.getAnimal()))
                 .map(sighting -> sighting.getCount())
                 .forEach(detail -> System.out.println(detail));
    }
    
    public int getCountByAnimalSpotterDay(String animal, int spotterID, int dayID)
    {
        return sightings.stream()
                        .filter(sighting -> animal.equals(sighting.getAnimal()))
                        .filter(sighting -> sighting.getSpotter() == spotterID)
                        .filter(sighting -> sighting.getPeriod() == dayID)
                        .map(sighting -> sighting.getCount())
                        .reduce(0, (total, count) -> total + count);
    }
    
    public String getAnimalNamesBySpotterDay(int spotterID, int dayID)
    {
        return sightings.stream()
                        .filter(sighting -> sighting.getSpotter() == spotterID)
                        .filter(sighting -> sighting.getPeriod() == dayID)
                        .filter(sighting -> sighting.getCount() > 0)
                        .map(sighting -> sighting.getAnimal())
                        .reduce("", (animal, element) -> animal + element);
    }
    
    public void removeSpotter(int spotterID)
    {
        sightings.removeIf(sighting -> sighting.getSpotter() == spotterID);
    }
    
    public long getCountBySpotter(int spotterID)
    {
        return sightings.stream()
                        .filter(sighting -> sighting.getSpotter() == spotterID)
                        .map(sighting -> sighting.getCount())
                        .count();
    }
    
    public int getMaxCountByAnimal(String animal)
    {
        return sightings.stream()
                       .filter(sighting -> animal.equals(sighting.getAnimal()))
                       .map(sighting -> sighting.getCount())
                       .max((maximum, eachSighting) -> maximum.compareTo(eachSighting))
                       .get();
    }
    
    public Sighting getSightingByAnimalSpotter(String animal, int spotterID)
    {
        return sightings.stream()
                        .filter(sighting -> animal.equals(sighting.getAnimal()))
                        .filter(sighting -> sighting.getSpotter() == spotterID)
                        .findFirst()
                        .get();
    }
}
