class Employee {
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        if (salary < 0) {
            throw new IllegalArgumentException("Salary cannot be negative.");
        }
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public double calculateBonus() {
        return 0;
    }
}

class PermanentEmployee extends Employee {
    private static final double BONUS_PERCENTAGE = 0.10;

    public PermanentEmployee(String name, double salary) {
        super(name, salary);
    }

    @Override
    public double calculateBonus() {
        return getSalary() * BONUS_PERCENTAGE;
    }
}

class ContractEmployee extends Employee {
    private static final double BONUS_PERCENTAGE = 0.05; 

    public ContractEmployee(String name, double salary) {
        super(name, salary);
    }

    @Override
    public double calculateBonus() {
        return getSalary() * BONUS_PERCENTAGE;
    }
}

public class EmployeeBonusSystem {
    public static void main(String[] args) {
        Employee[] employees = {
            new PermanentEmployee("Alice", 60000),
            new ContractEmployee("Bob", 40000),
            new PermanentEmployee("Charlie", 80000),
            new ContractEmployee("Diana", 30000)
        };

        System.out.println("Calculating bonuses for employees...\n");

        for (Employee employee : employees) {
            try {
                double bonus = employee.calculateBonus();
                System.out.printf("Employee: %s, Salary: $%.2f, Bonus: $%.2f%n",
                                  employee.getName(), employee.getSalary(), bonus);
            } catch (Exception e) {
                System.out.println("Error calculating bonus for " + employee.getName() + ": " + e.getMessage());
            }
        }
        System.out.println("\nTesting error case...");
        try {
            Employee invalidEmployee = new PermanentEmployee("Invalid", -5000);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}