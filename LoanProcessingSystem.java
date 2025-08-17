abstract class Loan {
    private double loanAmount;
    private double interestRate;

    public Loan(double loanAmount, double interestRate) {
        if (loanAmount <= 0) {
            throw new IllegalArgumentException("Loan amount must be greater than zero.");
        }
        if (interestRate < 0) {
            throw new IllegalArgumentException("Interest rate cannot be negative.");
        }
        this.loanAmount = loanAmount;
        this.interestRate = interestRate;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public abstract double calculateInterest();
}

class HomeLoan extends Loan {
    public HomeLoan(double loanAmount, double interestRate) {
        super(loanAmount, interestRate);
    }

    @Override
    public double calculateInterest() {
        return getLoanAmount() * getInterestRate() / 100;
    }
}
class CarLoan extends Loan {
    public CarLoan(double loanAmount, double interestRate) {
        super(loanAmount, interestRate);
    }

    @Override
    public double calculateInterest() {
        return getLoanAmount() * getInterestRate() / 100;
    }
}
class EducationLoan extends Loan {
    public EducationLoan(double loanAmount, double interestRate) {
        super(loanAmount, interestRate);
    }

    @Override
    public double calculateInterest() {
        return getLoanAmount() * getInterestRate() / 100;
    }
}

public class LoanProcessingSystem {
    public static void main(String[] args) {
        Loan[] loans = {
            new HomeLoan(250000, 3.5),
            new CarLoan(20000, 5.0),
            new EducationLoan(15000, 4.0)
        };

        System.out.println("Calculating interest for loans...\n");

        for (Loan loan : loans) {
            try {
                double interest = loan.calculateInterest();
                System.out.printf("Loan Type: %s, Loan Amount: $%.2f, Interest Rate: %.2f%%, Interest: $%.2f%n",
                        loan.getClass().getSimpleName(), loan.getLoanAmount(), loan.getInterestRate(), interest);
            } catch (Exception e) {
                System.out.println("Error calculating interest: " + e.getMessage());
            }
        }

        System.out.println("\nTesting error case...");
        try {
            Loan invalidLoan = new HomeLoan(-50000, 3.5);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
