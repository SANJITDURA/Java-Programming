abstract class TaxPayer {
    private double income;

    public TaxPayer(double income) {
        if (income < 0) {
            throw new IllegalArgumentException("Income cannot be negative.");
        }
        this.income = income;
    }

    public double getIncome() {
        return income;
    }

    public abstract double calculateTax();
}

class Individual extends TaxPayer {
    private static final double TAX_RATE = 0.15; // 15% tax rate

    public Individual(double income) {
        super(income);
    }

    @Override
    public double calculateTax() {
        return getIncome() * TAX_RATE;
    }
}

class Business extends TaxPayer {
    private static final double TAX_RATE = 0.25; // 25% tax rate

    public Business(double income) {
        super(income);
    }

    @Override
    public double calculateTax() {
        return getIncome() * TAX_RATE;
    }
}

class Freelancer extends TaxPayer {
    private static final double TAX_RATE = 0.20; // 20% tax rate

    public Freelancer(double income) {
        super(income);
    }

    @Override
    public double calculateTax() {
        return getIncome() * TAX_RATE;
    }
}
public class TaxCalculationSystem {
    public static void main(String[] args) {
        TaxPayer[] taxPayers = {
            new Individual(50000),
            new Business(100000),
            new Freelancer(75000)
        };

        System.out.println("Calculating taxes for taxpayers...\n");

        for (TaxPayer taxPayer : taxPayers) {
            try {
                double tax = taxPayer.calculateTax();
                System.out.printf("Taxpayer Type: %s, Income: $%.2f, Tax: $%.2f%n",
                        taxPayer.getClass().getSimpleName(), taxPayer.getIncome(), tax);
            } catch (Exception e) {
                System.out.println("Error calculating tax: " + e.getMessage());
            }
        }
        System.out.println("\nTesting error case...");
        try {
            TaxPayer invalidTaxPayer = new Individual(-30000);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
