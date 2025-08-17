abstract class Vehicle {
    private String model;
    private double speed;
    
    public Vehicle(String model, double speed) {
        this.model = model;
        setSpeed(speed); // Validates speed
    }
    
    public void setSpeed(double speed) {
        if (speed < 0) {
            throw new IllegalArgumentException("Speed cannot be negative");
        }
        this.speed = speed;
    }
    
    public String getModel() { return model; }
    public double getSpeed() { return speed; }
    
    public abstract void display();
}

class Car extends Vehicle {
    public Car(String model, double speed) {
        super(model, speed);
    }
    
    @Override
    public void display() {
        System.out.println("Car Model: " + getModel());
        System.out.println("Speed: " + getSpeed() + " km/h");
    }
}

class Bike extends Vehicle {
    public Bike(String model, double speed) {
        super(model, speed);
    }
    
    @Override
    public void display() {
        System.out.println("Bike Model: " + getModel());
        System.out.println("Speed: " + getSpeed() + " km/h");
    }
}

public class VehicleInheritanceExample {
    public static void main(String[] args) {
        try {
            Vehicle car = new Car("Toyota Camry", 60.0);
            Vehicle bike = new Bike("Honda CBR", 25.0);
            
            car.display();
            bike.display();
        } catch (IllegalArgumentException e) {
    
            System.out.println("ERROR: " + e.getMessage());
        }
    }
}


