import java.util.*;

public class CharacterGeneration {
    private static final Map<String, Map<String, Integer>> races = new HashMap<>();
    private static final Map<String, Map<String, List<String>>> classes = new HashMap<>();

    static {
        races.put("Human", Map.of("strength", 0, "health", 0, "wisdom", 0, "intelligence", 0, "agility", 0, "level_up_speed", 1));
        races.put("Red Cap", Map.of("strength", 0, "health", 0, "wisdom", 0, "intelligence", 0, "agility", 5, "attack_bonus", 1));
        races.put("Spriggan", Map.of("strength", 5, "health", 5, "wisdom", 5, "intelligence", 0, "agility", 0, "fire_damage_multiplier", 2));
        races.put("Goblin", Map.of("strength", 0, "health", 5, "wisdom", 0, "intelligence", 0, "agility", 10));

        classes.put("Warrior", Map.of("spells", List.of(), "equipment", List.of("dagger", "torch", "rations")));
        classes.put("Healer", Map.of("spells", List.of("light heal"), "equipment", List.of("dagger", "torch", "rations")));
        classes.put("Mage", Map.of("spells", List.of("fire arrow"), "equipment", List.of("dagger", "torch", "rations")));
        classes.put("Thief", Map.of("spells", List.of(), "equipment", List.of("dagger", "torch", "rations")));
    }

    public static Character createCharacter() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your character's name: ");
        String name = scanner.nextLine();

        System.out.println("Choose a race: ");
        races.keySet().forEach(System.out::println);
        String race = scanner.nextLine();

        System.out.println("Choose a class: ");
        classes.keySet().forEach(System.out::println);
        String className = scanner.nextLine();

        Map<String, Integer> raceStats = races.get(race);

        Character character = new Character(
                name,
                race,
                className,
                raceStats.getOrDefault("strength", 0),
                raceStats.getOrDefault("health", 0),
                raceStats.getOrDefault("wisdom", 0),
                raceStats.getOrDefault("intelligence", 0),
                raceStats.getOrDefault("agility", 0),
                raceStats.getOrDefault("level_up_speed", 1),
                raceStats.getOrDefault("attack_bonus", 0),
                raceStats.getOrDefault("fire_damage_multiplier", 1)
        );

        return character;
    }
}
