abstract class Payment {
    private double amount;

    public Payment(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than zero.");
        }
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public abstract void processPayment() throws Exception;
}
class CreditCard extends Payment {
    private String cardNumber;
    private String cardHolderName;
    public CreditCard(double amount, String cardNumber, String cardHolderName, String expiryDate) {
        super(amount);
        if (cardNumber == null || cardNumber.length() != 16) {
            throw new IllegalArgumentException("Card number must be 16 digits.");
        }
        if (expiryDate == null || !expiryDate.matches("\\d{2}/\\d{2}")) {
            throw new IllegalArgumentException("Invalid expiry date format (MM/YY).");
        }
        this.cardNumber = cardNumber;
    }
    @Override
    public void processPayment() throws Exception {
        System.out.println("Processing credit card payment...");
        System.out.println("Amount: $" + getAmount());
        System.out.println("Card Holder: " + cardHolderName);
        System.out.println("Last 4 digits: ****" + cardNumber.substring(12));
        System.out.println("Payment processed successfully!\n");
    }
}

class UPI extends Payment {
    private String upiId;
    public UPI(double amount, String upiId, String pin) {
        super(amount);
        if (upiId == null || !upiId.matches(".+@.+")) {
            throw new IllegalArgumentException("Invalid UPI ID format (should be like name@bank).");
        }
        if (pin == null || pin.length() != 4) {
            throw new IllegalArgumentException("PIN must be 4 digits.");
        }
        this.upiId = upiId;
    }

    @Override
    public void processPayment() throws Exception {
        System.out.println("Processing UPI payment...");
        System.out.println("Amount: $" + getAmount());
        System.out.println("UPI ID: " + upiId);
        System.out.println("Payment processed successfully!\n");
    }
}

class NetBanking extends Payment {
    private String bankName;
    private String accountNumber;
    public NetBanking(double amount, String bankName, String accountNumber, String password) {
        super(amount);
        if (accountNumber == null || accountNumber.length() < 8) {
            throw new IllegalArgumentException("Account number must be at least 8 digits.");
        }
        if (password == null || password.length() < 6) {
            throw new IllegalArgumentException("Password must be at least 6 characters.");
        }
        this.bankName = bankName;
        this.accountNumber = accountNumber;
    }

    @Override
    public void processPayment() throws Exception {
        System.out.println("Processing net banking payment...");
        System.out.println("Amount: $" + getAmount());
        System.out.println("Bank: " + bankName);
        System.out.println("Last 4 digits: ****" + accountNumber.substring(accountNumber.length() - 4));
        System.out.println("Payment processed successfully!\n");
    }
}

public class OnlinePaymentGateway {
    public static void main(String[] args) {
        Payment[] payments = {
            new CreditCard(149.99, "4111111111111111", "John Smith", "12/25"),
            new UPI(75.50, "john.smith@icici", "2591"),
            new NetBanking(200.0, "State Bank", "1234567890", "secure123")
        };

        System.out.println("Starting payment processing...\n");
        
        for (Payment payment : payments) {
            try {
                payment.processPayment();
            } catch (Exception e) {
                System.out.println("Payment failed: " + e.getMessage());
            }
        }
        
        System.out.println("\nTesting error cases...");
        try {
        } catch (Exception e) {
            System.out.println("Test 1 Error: " + e.getMessage());
        }
        
        try {
        } catch (Exception e) {
            System.out.println("Test 2 Error: " + e.getMessage());
        }
    }
}
