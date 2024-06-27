import java.util.HashMap;
import java.util.Map;

public class Room {
    private int id;
    String description;
    Map<String, Room> exits;
    public Monster monster;

    public Room(int id, String description) {
        this.id = id;
        this.description = description;
        this.exits = new HashMap<>();
    }

    public void setExit(String direction, Room neighbor) {
        exits.put(direction, neighbor);
    }

    public Room getExit(String direction) {
        return exits.get(direction);
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}
