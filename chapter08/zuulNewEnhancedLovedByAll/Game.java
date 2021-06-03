import java.util.ArrayList;
import java.util.Stack;
import java.util.Random;
/**
 *  This class is the main class of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */

public class Game 
{
    private Parser parser;
    private Room currentRoom;
    private Stack<Room> movementTrack;
    private Player playerOne;
    private ArrayList<Room> allRooms = new ArrayList<Room>();
    private TransporterRoom transporter;
    private Random rand = new Random();
    private ArrayList<Character> roamingCharacters = new ArrayList<Character>();
    
    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        createRooms();
        createPlayers();
        createNPC();
        parser = new Parser();
        movementTrack = new Stack<>();
    }

    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms()
    {
        Room outside, theater, pub, lab, office, cellar, teleporter;
      
        // create the rooms
        outside = new Room("outside the main entrance of the university", "outside");
        theater = new Room("in a lecture theater", "theater");
        pub = new Room("in the campus pub", "pub");
        lab = new Room("in a computing lab", "lab");
        office = new Room("in the computing admin office", "office");
        cellar = new Room("in a cellar. You see light in the distance", "cellar");
        teleporter = new TransporterRoom("a teleporter room. Looks very futuristic", "teleporter");
        
        // add rooms to ArrayList Rooms
        allRooms.add(outside);
        allRooms.add(theater);
        allRooms.add(pub);
        allRooms.add(lab);
        allRooms.add(office);
        allRooms.add(cellar);
        allRooms.add(teleporter);
        
        transporter = (TransporterRoom)teleporter;
        
        // initialise room exits
        outside.setExits("east", theater);
        outside.setExits("south", lab);
        outside.setExits("west", pub);
        outside.setExits("north", teleporter);
        theater.setExits("west", outside);
        pub.setExits("east", outside);
        lab.setExits("north", outside);
        lab.setExits("east", office);
        office.setExits("west", lab);
        office.setExits("down", cellar);
        cellar.setExits("up", outside);
        teleporter.setExits("south", outside);
        
        Item bell, flashlight, bucket, anvil, cookie, beamer, key,umbrella;
        
        // create the items
        bell = new Item("bell", 80, "a large brass bell");
        flashlight = new Item("flashlight", 2, "a sturdy flashlight"); 
        bucket = new Item("bucket", 8 , "a wooden bucket");
        anvil = new Item("anvil", 233 , "a large anvil");
        cookie = new Item("cookie", 1 , "a large glowing cookie");
        beamer = new Item("beamer", 5 , "a device used to return a set point");
        key = new Item("key", 0, "a skeleton key");
        umbrella = new Item("umbrella", 6, "a sturdy umbrella");
        
        // add items to rooms.
        pub.setItems(umbrella);
        lab.setItems(bucket);
        lab.setItems(flashlight);
        lab.setItems(cookie);
        lab.setItems(beamer);
        cellar.setItems(anvil);
        pub.setItems(bucket);
        theater.setItems(bell);
        office.setItems(key);
        
        // locks doors: requires a key item to enter.
        cellar.toggleLockDoor();
        
        currentRoom = outside;  // start game outside
        
        // set the transporter room
        setTransporter();
    }
    
    private void setTransporter()
    {
        transporter.setRoomList(allRooms);
    }
    
    /**
     * Creates a new player, and sets current room to default
     * current room from createRooms()
     */
    private void createPlayers()
    {
       playerOne = new Player("Joe", 80, 5);
       playerOne.setCurrentRoom(currentRoom);
    }
    
    /**
     * Creates NPCs
     */
    private void createNPC()
    {
        Character kevin, susan, pat;
        //create NPCs and give them names
        kevin = new Character("kevin");
        susan = new Character("susan");
        pat = new Character("pat");
        
        //set NPC greetings
        kevin.setGreeting("Go Bobcats!");
        susan.setGreeting("Do you think it will rain today? I think it will");
        pat.setGreeting("Please don't touch anything!");
        
        
        //add NPCs to Rooms
        ArrayList<Character> tempCharacterList = new ArrayList<Character>();
        tempCharacterList.add(kevin);
        tempCharacterList.add(susan);
        tempCharacterList.add(pat);
        for(int i=0; i < tempCharacterList.size(); i++)
        {
            Room tempRoom = getRandomRoom();
            Character tempCharacter = tempCharacterList.get(i);
            tempRoom.addCharacter(tempCharacter);
            tempCharacter.setCurrentRoom(tempRoom);
        }
        
        //set NPC trigger items and response
        susan.setTrigger("umbrella");
        susan.setTriggerResponse("Thank you! This will come in handy later");
        
        //adds some NPCs to a roaming Array
        roamingCharacters.add(pat);
        roamingCharacters.add(kevin);
    }
    
    /**
     * test to make sure NPCS populate
     */
    public void testCheckNPC()
    {
        for(Room room : allRooms)
        {
            ArrayList <Character> temp = room.getCharacterList();
            if(temp.size() == 0 || temp == null)
            {
                System.out.println("No characters in " + room.getShortName());
            }
            else{
                for(Character character : temp)
                {
                    System.out.println("In room " + room.getShortName() + ": " + character.getName());
                }
            }
        }
    }
    

    private Room getRandomRoom()
    {
        return allRooms.get(rand.nextInt(allRooms.size()));
    }
    
    public ArrayList<Room> getAllRooms()
    {
        return allRooms;
    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {            
        printWelcome();
        playerOne.resetFatigue();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
                
        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type '" + CommandWord.HELP + "' if you need help.");
        System.out.println();
        printLocationInfo();
    }

    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;
        
        CommandWord commandWord = command.getCommandWord();
        
        switch (commandWord) {
            case UNKNOWN:
                System.out.println("I don't know what you mean...");
                break;

            case HELP:
                printHelp();
                break;

            case GO:
                goRoom(command);
                break;

            case QUIT:
                wantToQuit = quit(command);
                break;
                
            case LOOK:
                look();
                break;
                
            case REST:
                rest();
                break;
                
            case BACK:
                back();
                break;
                
            case TAKE:
                take(command);
                break;
                
            case DROP:
                drop(command);
                break;
                
            case ITEMS:
                playerBackpack();
                break;
                
            case EAT:
                eatCookie();
                break;
            
            case FATIGUE:
                getFatigue();
                break;
            
            case BEAMER:
                beamer();
                break;
            
            case GREET:
                greet(command);
                break;
                
            case GIVE:
                give(command);
                break;
                
        }
        return wantToQuit;
    }

    // implementations of user commands:
    /**
     * Move roaming Characters
     */
    private void moveRoamingNPCs()
    {
        //testCheckNPC(); //TEST to check NPC movement
        for(Character character : roamingCharacters)
        {
            Room currentRoom = character.getCurrentRoom();
            ArrayList<Room> tempExitList = currentRoom.getAllExits();
            tempExitList.add(currentRoom);
            Room nextRandomRoom = tempExitList.get(rand.nextInt(tempExitList.size()));
            character.setCurrentRoom(nextRandomRoom);
            nextRandomRoom.addCharacter(character);
            currentRoom.removeCharacter(character);
        }
    }
    
    /**
     * Command format: give Item Character
     * give an item the player holds to Character in there room.
     */
    private void give(Command command)
    {
        if(!command.hasSecondWord() || !command.hasThirdWord()) {
            // if there is no second word or third word
            System.out.println("Give what to who?");
            return;
        }
        String who = command.getSecondWord();
        String whatItem = command.getThirdWord();
        Character roomCharacter = playerOne.getCurrentRoom().getCharacter(who);
        if(roomCharacter == null)
        {
            System.out.println(who + " is not in the room.");
            return;
        }
        if(playerOne.hasItem(whatItem))
        {
            if(roomCharacter.getTriggerItem().equals(whatItem))
            {
                System.out.println("You gave " + who + " a " + whatItem + ".");
                System.out.println(roomCharacter.getTriggerResponse());
                playerOne.removeItem(playerOne.dropItem(whatItem));
                //
                moveRoamingNPCs();
            }
            else{
                System.out.println(who + " does not want a " + whatItem);
            }
        }
        else{
            System.out.println("You don't have a" + whatItem);
        }
        
    }
    
    private void greet(Command command)
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Greet who?");
            return;
        }
        String who = command.getSecondWord();
        Character greetWho = playerOne.getCurrentRoom().getCharacter(who);
        if(greetWho != null)
        {
          System.out.println(greetWho.getName() + " says, \"" + greetWho.getGreeting() + "\"");
          //
          moveRoamingNPCs();
        }
        else{
            System.out.println("You don't see " + who + " in the room.");
            return;
        }
    }

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private void printHelp() 
    {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands();
    }
     

    /** 
     * Try to go in one direction. If there is an exit, enter
     * the new room, otherwise print an error message.
     */
    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        // check to see if player is in teleporter room
        //if(playerOne.getCurrentRoom().getShortName().equals("teleporter"))
        //{
        //    moveIntoRoom(getRandomRoom());
        //    System.out.println("** The room around you seems to melt away **");
        //    look();
        //}
            // Try to leave current room.
            Room nextRoom = playerOne.getCurrentRoom().getExit(direction);
            if (nextRoom == null) {
                System.out.println("There is no door!");
            }
            // player can move and the room door is UNLOCKED
            else if(playerOne.getCurrentFatigue() < 5 && 
                    !nextRoom.getLockedDoor()){
                moveIntoRoom(nextRoom);
                }
                // player can move and room door is LOCKED and player has a key
            else if (playerOne.getCurrentFatigue() < 5 && 
                     nextRoom.getLockedDoor() &&
                     playerOne.hasItem("key")){
                System.out.println("You unlocked the door and move in");
                nextRoom.toggleLockDoor();
                moveIntoRoom(nextRoom);
            }
            // player can move and room is LOCKED, player does NOT have a key.
            else if (playerOne.getCurrentFatigue() < 5 && 
                    nextRoom.getLockedDoor() &&
                    !playerOne.hasItem("key")){
            System.out.println("You must have a key to enter");
            }
            else{
                toTired();
            }
    }
    
    /**
     * method for entering the passed room parameter
     */
    private void moveIntoRoom(Room nextRoom)
    {
            movementTrack.push(playerOne.getCurrentRoom());
            playerOne.setCurrentRoom(nextRoom);
            printLocationInfo();
            playerOne.increaseFatigue();
            //
            moveRoamingNPCs();
    }
    

    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }
    
    private void printLocationInfo()
    {
        System.out.println(playerOne.getCurrentRoom().getLongDescription());
        if(playerOne.getCurrentRoom().getItemArray() != null)
        {
            ArrayList <Item> roomItems = playerOne.getCurrentRoom().getItemArray();
            String itemDescrip = "You see ";
            String itemName ="Items: ";
            for(Item item : roomItems)
            {
               itemDescrip += item.getDescription() + " ";
               itemName += item.getName() + " ";
            }
            System.out.println(itemDescrip + ".\n" + itemName);
        }
        ArrayList <Character> roomCharacter = playerOne.getCurrentRoom().getCharacterList();
        if(roomCharacter.size() > 0)
        {
            String charDescrip = "You see ";
            for (Character character : roomCharacter)
            {
                System.out.println("charater in room: " + character.getName());
                charDescrip += character.getName() + " ";
            }
            System.out.println(charDescrip + "in the room");
        }
        System.out.println();
    }
    
    /**
     * "look" was entered. Prints out the long description of the room,
     * which will have the room description and the exits.
     */
    private void look()
    {
        System.out.println(playerOne.getCurrentRoom().getLongDescription());
    }
    
    /**
     * "back" was entered. Goes back to a previous room 
     * in the movementTracker ArrayList
     */
    private void back()
    {
        if(playerOne.getCurrentFatigue() < 5)
        {
            if(!movementTrack.empty())
            {
                playerOne.setCurrentRoom(movementTrack.pop());
                playerOne.increaseFatigue();
            }
            printLocationInfo();
            //
            moveRoamingNPCs();
        }
        else{
            toTired();
        }
    }
    
    /**
     * pick up an item from a room and place it into the players
     * backpack.
     */
    private void take(Command command)
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know what to take...
            System.out.println("Take what?");
            return;
        }
        
        String takingItem = command.getSecondWord();
        
        Item itemTook = playerOne.getCurrentRoom().takeItem(takingItem);
        if (itemTook == null)
        {
            System.out.println("You could not find a" + takingItem + ".");
        }
        else if(playerOne.canItemBePickedUp(itemTook)){
            playerOne.addItem(itemTook);
                        //test
            System.out.println(itemTook.getName());
            playerOne.getCurrentRoom().removeItem(itemTook);
            System.out.println("You picked up a " + takingItem + ".");
            System.out.println("");
            //
            moveRoamingNPCs();
        }
        else{
            System.out.println("Error: " + itemTook.getName() + " was to heavy to pick up");
            System.out.println("");
        }
        
    }
    
    /**
     * take an item from the players backpack and place it in the players
     * current room
     */
    private void drop(Command command)
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know what to drop...
            System.out.println("Drop what?");
            return;
        }
        
        String itemToDrop = command.getSecondWord();
        Item droppingItem = playerOne.dropItem(itemToDrop);
        if (droppingItem == null)
        {
            System.out.println("You don't have a " + itemToDrop + " to drop.");
        }
        else{
            playerOne.getCurrentRoom().setItems(droppingItem);
            playerOne.removeItem(droppingItem);
            System.out.println("You dropped a " + itemToDrop + ".");
            System.out.println("");
            //
            moveRoamingNPCs();
        }
    }
    
    /**
     * System print what is in the players backpack.
     */
    private void playerBackpack()
    {
        ArrayList<Item> playerItems = new ArrayList<Item>(playerOne.getBackpack());
        System.out.print(" Items in Backpack: ");
        playerItems.stream()
                   .map(item -> item.getName())
                   .forEach(item -> System.out.print(item + " "));
        int sum = playerItems.stream()
                             .map(item -> item.getWeight())
                             .reduce(0, (total,add) -> total + add);
        System.out.println("\n Total weight: " + sum);
    }
    
    private void eatCookie()
    {
        if(playerOne.magicCookie())
        {
            System.out.println("You ate a magical cookie. You feel stronger!");
            //
            moveRoamingNPCs();
        }
        else{
            System.out.println("You have nothing to eat.");
        }
    }
    
    private void getFatigue()
    {
        switch (playerOne.getCurrentFatigue()) {
            case 0:
                System.out.println("You are energized and ready to go!");
                break;
            
            case 1:
            case 2:
                System.out.println("You are getting a little tired of walking");
                break;
                
            case 3:
            case 4:
                System.out.println("You are tired of walking");
                break;
                
            case 5:
                toTired();
                break;
        }
    }
    
    private void toTired()
    {
        System.out.println("You are tired of walking! You better rest.");
    }
    
    /**
     * "rest" was entered. Prints out a message that you
     * are resting, and sets fatigue value to 0.
     */
    private void rest()
    {
        System.out.println("You take a break to catch your breath");
        playerOne.resetFatigue();
        //
        moveRoamingNPCs();
    }
    
    private void beamer()
    {
        //if returned true, beamer has been charged and ready to use.
        if(playerOne.useBeamer())
        {
            System.out.println("***You seem to be back to where you charged the beamer.***");
            printLocationInfo();
        }
        //if returned false, beamer has started to charge.
        else{
            System.out.println("You begin to charge the beamer item");
        }
        //
        moveRoamingNPCs();
    }
}
