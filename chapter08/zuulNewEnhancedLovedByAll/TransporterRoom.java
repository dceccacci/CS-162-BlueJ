import java.util.ArrayList;
import java.util.Random;

/**
 * Write a description of class TransporterRoom here.
 *
 * @author (Devon Ceccacci)
 * @version (Apr-25-2021)
 */
public class TransporterRoom extends Room
{
    private Random rand = new Random();
    private ArrayList<Room> roomList;

    /**
     * Constructor for the TransporterRoom Class
     */
    public TransporterRoom(String description, String shortName)
    {
        super(description, shortName);
        roomList = new ArrayList<Room>();
    }
    
    /**
     * Return a random room, independent of the direction
     * parameter.
     * @param direction Ignored.
     * @return A random room.
     */
    public Room getExit(String direction) {
        return findRandomRoom();
    }
    
    /**
     * Choose a random room.
     * @return A random room.
     */
    private Room findRandomRoom() {
       return roomList.get(rand.nextInt(roomList.size()));
    }
    
    /**
     * Gets the list of Rooms, then sets it to roomList
     */
    public void setRoomList(ArrayList<Room> allRooms)
    {
        roomList = allRooms;
    }


}
