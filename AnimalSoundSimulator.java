abstract class Animal {
    private String name;

    public Animal(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void makeSound();
}

class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " says: Woof!");
    }
}

class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " says: Meow!");
    }
}

class Cow extends Animal {
    public Cow(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " says: Moo!");
    }
}

public class AnimalSoundSimulator {
    public static void main(String[] args) {
        Animal[] animals = {
            new Dog("Buddy"),
            new Cat("Whiskers"),
            new Cow("Bessie")
        };
        for (Animal animal : animals) {
            animal.makeSound();
        }
    }
}
