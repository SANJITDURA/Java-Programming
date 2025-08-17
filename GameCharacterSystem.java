abstract class Character {
    private String name;
    private int health;
    private String weapon;

    public Character(String name, int health, String weapon) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty.");
        }
        if (health <= 0) {
            throw new IllegalArgumentException("Health must be greater than zero.");
        }
        if (weapon == null || weapon.isEmpty()) {
            throw new IllegalArgumentException("Weapon cannot be null or empty.");
        }
        this.name = name;
        this.health = health;
        this.weapon = weapon;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public String getWeapon() {
        return weapon;
    }

    public abstract void attack();
}

class Warrior extends Character {
    public Warrior(String name, int health, String weapon) {
        super(name, health, weapon);
    }

    @Override
    public void attack() {
        System.out.println(getName() + " the Warrior attacks with " + getWeapon() + "!");
    }
}

class Mage extends Character {
    public Mage(String name, int health, String weapon) {
        super(name, health, weapon);
    }

    @Override
    public void attack() {
        System.out.println(getName() + " the Mage casts a spell with " + getWeapon() + "!");
    }
}

class Archer extends Character {
    public Archer(String name, int health, String weapon) {
        super(name, health, weapon);
    }

    @Override
    public void attack() {
        System.out.println(getName() + " the Archer shoots an arrow with " + getWeapon() + "!");
    }
}
public class GameCharacterSystem {
    public static void main(String[] args) {
        Character[] characters = {
            new Warrior("Thor", 100, "Sword"),
            new Mage("Gandalf", 80, "Staff"),
            new Archer("Legolas", 90, "Bow")
        };

        System.out.println("Game Character Attacks:\n");

        for (Character character : characters) {
            try {
                character.attack();
            } catch (Exception e) {
                System.out.println("Error during attack: " + e.getMessage());
            }
        }
        System.out.println("\nTesting error cases...");
        try {
            Character invalidCharacter = new Warrior("Invalid Warrior", -10, "Axe");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            Character invalidCharacter2 = new Mage("Invalid Mage", 50, "");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
