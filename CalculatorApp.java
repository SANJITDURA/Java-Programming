class Calculator {
    public Calculator() {
    }

    public int add(int a, int b) {
        return a + b;
    }

    public int add(int a, int b, int c) {
        return a + b + c;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public double divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }
        return (double) a / b;
    }
}

public class CalculatorApp{
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        try {
            System.out.println("Addition of 5 and 10: " + calculator.add(5, 10));
            System.out.println("Addition of 5, 10, and 15: " + calculator.add(5, 10, 15));

            System.out.println("Subtraction of 10 from 20: " + calculator.subtract(20, 10));

            System.out.println("Multiplication of 5 and 4: " + calculator.multiply(5, 4));

            System.out.println("Division of 20 by 4: " + calculator.divide(20, 4));
            System.out.println("Division of 20 by 0: " + calculator.divide(20, 0));

        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
    }
}
