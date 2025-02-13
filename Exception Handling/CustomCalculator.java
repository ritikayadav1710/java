import java.util.Scanner;

// Custom exceptions
class InvalidInputException extends Exception {
    public InvalidInputException(String message) {
        super(message);
    }
}

class CannotDivideByZeroException extends Exception {
    public CannotDivideByZeroException() {
        super("Cannot divide by zero");
    }
}

class MaxInputException extends Exception {
    public MaxInputException() {
        super("Input cannot be greater than 100000");
    }
}

class MaxMultiplierException extends Exception {
    public MaxMultiplierException() {
        super("Multiplication input cannot be greater than 7000");
    }
}

public class CustomCalculator {
    public static double calculate(double a, double b, char operator) throws Exception {
        if (a > 100000 || b > 100000) {
            throw new MaxInputException();
        }
        if (operator == '*' && (a > 7000 || b > 7000)) {
            throw new MaxMultiplierException();
        }
        if (operator == '/' && b == 0) {
            throw new CannotDivideByZeroException();
        }
        
        switch (operator) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/': return a / b;
            default: throw new InvalidInputException("Invalid operator: " + operator);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter first number: ");
            double num1 = scanner.nextDouble();
            System.out.print("Enter operator (+, -, *, /): ");
            char operator = scanner.next().charAt(0);
            System.out.print("Enter second number: ");
            double num2 = scanner.nextDouble();

            double result = calculate(num1, num2, operator);
            System.out.println("Result: " + result);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
