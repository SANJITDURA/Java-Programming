abstract class Employee {
    private String name;
    private double baseSalary;

    public Employee(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public abstract double calculateSalary();

    public String getName() {
        return name;
    }

    public double getBaseSalary() {
        return baseSalary;
    }
}

class Manager extends Employee {
    private double bonus;

    public Manager(String name, double baseSalary, double bonus) {
        super(name, baseSalary);
        this.bonus = bonus;
    }

    @Override
    public double calculateSalary() {
        if (bonus < 0) {
            throw new IllegalArgumentException("Bonus cannot be negative");
        }
        return getBaseSalary() + bonus;
    }
}

class Developer extends Employee {
    private int overtimeHours;
    private double overtimeRate;

    public Developer(String name, double baseSalary, int overtimeHours, double overtimeRate) {
        super(name, baseSalary);
        this.overtimeHours = overtimeHours;
        this.overtimeRate = overtimeRate;
    }

    @Override
    public double calculateSalary() {
        if (overtimeHours < 0 || overtimeRate < 0) {
            throw new IllegalArgumentException("Overtime hours/rate cannot be negative");
        }
        return getBaseSalary() + (overtimeHours * overtimeRate);
    }
}

public class EmployeeManagementSystem {
    public static void main(String[] args) {
        try {
            Employee manager = new Manager("John Doe", 75000.0, 10000.0);
            Employee developer = new Developer("Jane Smith", 65000.0, 20, 50.0);
            
            System.out.println(manager.getName() + "'s salary: $" + manager.calculateSalary());
            System.out.println(developer.getName() + "'s salary: $" + developer.calculateSalary());
            
            // Attempt to create an invalid manager
            Employee invalidManager = new Manager("Error Test", 50000.0, -1000.0);
            // This line will throw an exception when calculating salary
            System.out.println(invalidManager.getName() + "'s salary: $" + invalidManager.calculateSalary());
            
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
