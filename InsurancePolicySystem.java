abstract class InsurancePolicy {
    private String policyHolderName;
    private int age;
    private double coverageAmount;

    public InsurancePolicy(String policyHolderName, int age, double coverageAmount) {
        if (policyHolderName == null || policyHolderName.isEmpty()) {
            throw new IllegalArgumentException("Policy holder name cannot be null or empty.");
        }
        if (age <= 0) {
            throw new IllegalArgumentException("Age must be greater than zero.");
        }
        if (coverageAmount <= 0) {
            throw new IllegalArgumentException("Coverage amount must be greater than zero.");
        }
        this.policyHolderName = policyHolderName;
        this.age = age;
        this.coverageAmount = coverageAmount;
    }

    public String getPolicyHolderName() {
        return policyHolderName;
    }

    public int getAge() {
        return age;
    }

    public double getCoverageAmount() {
        return coverageAmount;
    }

    public abstract double calculatePremium();
}

class HealthInsurance extends InsurancePolicy {
    private static final double BASE_PREMIUM_RATE = 0.05; 

    public HealthInsurance(String policyHolderName, int age, double coverageAmount) {
        super(policyHolderName, age, coverageAmount);
    }

    @Override
    public double calculatePremium() {
        return getCoverageAmount() * BASE_PREMIUM_RATE;
    }
}

class LifeInsurance extends InsurancePolicy {
    private static final double BASE_PREMIUM_RATE = 0.03; 

    public LifeInsurance(String policyHolderName, int age, double coverageAmount) {
        super(policyHolderName, age, coverageAmount);
    }

    @Override
    public double calculatePremium() {
        return getCoverageAmount() * BASE_PREMIUM_RATE;
    }
}

class TravelInsurance extends InsurancePolicy {
    private static final double BASE_PREMIUM_RATE = 0.07; 

    public TravelInsurance(String policyHolderName, int age, double coverageAmount) {
        super(policyHolderName, age, coverageAmount);
    }

    @Override
    public double calculatePremium() {
        return getCoverageAmount() * BASE_PREMIUM_RATE;
    }
}

public class InsurancePolicySystem {
    public static void main(String[] args) {
        InsurancePolicy[] policies = {
            new HealthInsurance("Alice", 30, 100000),
            new LifeInsurance("Bob", 45, 200000),
            new TravelInsurance("Charlie", 25, 50000)
        };

        System.out.println("Calculating premiums for insurance policies...\n");

        for (InsurancePolicy policy : policies) {
            try {
                double premium = policy.calculatePremium();
                System.out.printf("Policy Holder: %s, Age: %d, Coverage Amount: $%.2f, Premium: $%.2f%n",
                        policy.getPolicyHolderName(), policy.getAge(), policy.getCoverageAmount(), premium);
            } catch (Exception e) {
                System.out.println("Error calculating premium: " + e.getMessage());
            }
        }
        System.out.println("\nTesting error case...");
        try {
            InsurancePolicy invalidPolicy = new HealthInsurance("Invalid", -5, 100000);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            InsurancePolicy invalidPolicy2 = new LifeInsurance("Invalid", 30, -20000);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
