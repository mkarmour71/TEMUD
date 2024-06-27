public class Character {
    private String name;
    private String race;
    private String className;
    private int strength;
    private int health;
    private int wisdom;
    private int intelligence;
    private int agility;
    private int levelUpSpeed;
    private int attackBonus;
    private int fireDamageMultiplier;

    // Constructor
    public Character(String name, String race, String className, int strength, int health, int wisdom, int intelligence, int agility, int levelUpSpeed, int attackBonus, int fireDamageMultiplier) {
        this.name = name;
        this.race = race;
        this.className = className;
        this.strength = strength;
        this.health = health;
        this.wisdom = wisdom;
        this.intelligence = intelligence;
        this.agility = agility;
        this.levelUpSpeed = levelUpSpeed;
        this.attackBonus = attackBonus;
        this.fireDamageMultiplier = fireDamageMultiplier;
    }

    // Getters and toString method
    public String getName() { return name; }
    public String getRace() { return race; }
    public String getClassName() { return className; }
    public int getStrength() { return strength; }
    public int getHealth() { return health; }
    public int getWisdom() { return wisdom; }
    public int getIntelligence() { return intelligence; }
    public int getAgility() { return agility; }
    public int getLevelUpSpeed() { return levelUpSpeed; }
    public int getAttackBonus() { return attackBonus; }
    public int getFireDamageMultiplier() { return fireDamageMultiplier; }

    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", race='" + race + '\'' +
                ", className='" + className + '\'' +
                ", strength=" + strength +
                ", health=" + health +
                ", wisdom=" + wisdom +
                ", intelligence=" + intelligence +
                ", agility=" + agility +
                ", levelUpSpeed=" + levelUpSpeed +
                ", attackBonus=" + attackBonus +
                ", fireDamageMultiplier=" + fireDamageMultiplier +
                '}';
    }
}

