import java.util.*;

public class ChatRoomGame {
    private Room currentRoom;
    private Room startRoom;
    private Character playerCharacter;
    private Map<Integer, Room> rooms = new HashMap<>();
    private List<Monster> monsters = new ArrayList<>();

    public ChatRoomGame() {
        createRooms();
        createMonsters();
        playerCharacter = CharacterGeneration.createCharacter();
        currentRoom = startRoom;
    }

    private void createRooms() {
        // Define the rooms
        Room room1 = new Room(1, "You are in a small, dimly lit room.");
        Room room2 = new Room(2, "You are in a large hall with high ceilings.");
        Room room3 = new Room(3, "You are in a cozy library filled with books.");
        Room room4 = new Room(4, "You are in a dark cave with eerie sounds.");
        Room room5 = new Room(5, "You are in a bright room with beautiful paintings.");
        Room room6 = new Room(6, "You are in a narrow hallway with flickering lights.");
        Room room7 = new Room(7, "You are in a large garden with exotic plants.");
        Room room8 = new Room(8, "You are in a damp basement with old furniture.");
        Room room9 = new Room(9, "You are in a luxurious bedroom with a grand bed.");
        Room room10 = new Room(10, "You are in a kitchen with the smell of fresh bread.");

        // Define the exits
        room1.setExit("north", room2);
        room1.setExit("east", room3);
        room2.setExit("south", room1);
        room2.setExit("west", room4);
        room3.setExit("west", room1);
        room3.setExit("north", room5);
        room4.setExit("east", room2);
        room4.setExit("north", room6);
        room5.setExit("south", room3);
        room5.setExit("east", room7);
        room6.setExit("south", room4);
        room6.setExit("west", room8);
        room7.setExit("west", room5);
        room7.setExit("north", room9);
        room8.setExit("east", room6);
        room8.setExit("north", room10);
        room9.setExit("south", room7);
        room10.setExit("south", room8);

        // Set the start room
        startRoom = room1;

        // Add rooms to the map
        rooms.put(1, room1);
        rooms.put(2, room2);
        rooms.put(3, room3);
        rooms.put(4, room4);
        rooms.put(5, room5);
        rooms.put(6, room6);
        rooms.put(7, room7);
        rooms.put(8, room8);
        rooms.put(9, room9);
        rooms.put(10, room10);
    }

    private void createMonsters() {
        // Create some monsters
        Monster goblin = new Monster("Goblin", 30, 5);
        Monster orc = new Monster("Orc", 50, 10);
        Monster troll = new Monster("Troll", 100, 15);
        Monster dragon = new Monster("Dragon", 200, 25);

        // Add monsters to specific rooms
        rooms.get(2).monster = goblin;
        rooms.get(4).monster = orc;
        rooms.get(6).monster = troll;
        rooms.get(10).monster = dragon;
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println(currentRoom.description);

            if (currentRoom.monster != null) {
                currentRoom.monster.display();
                currentRoom.monster = null; // Reset monster for this room after encounter
            }

            System.out.print("Exits: ");
            for (String direction : currentRoom.exits.keySet()) {
                System.out.print(direction + " ");
            }
            System.out.println();
            System.out.print("Enter a direction (north, south, east, west): ");
            String direction = scanner.nextLine().toLowerCase();

            if (currentRoom.getExit(direction) != null) {
                currentRoom = currentRoom.getExit(direction);
                if (currentRoom == currentRoom.getExit("north") && direction.equals("north")) {
                    System.out.println("You have been transported back to the start room.");
                    currentRoom = startRoom;
                }
            } else {
                System.out.println("You can't go that way!");
            }
        }
    }

    public static void main(String[] args) {
        ChatRoomGame game = new ChatRoomGame();
        game.play();
    }
}
