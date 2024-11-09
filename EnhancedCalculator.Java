import java.util.InputMismatchException;
import java.util.Scanner;

public class EnhancedCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nEnhanced Console-based Calculator");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("5. Square Root");
            System.out.println("6. Exponentiation");
            System.out.println("7. Temperature Conversion");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            choice = getValidInteger(scanner); // Get user choice
            switch (choice) {
                case 1:
                    performAddition(scanner);
                    break;
                case 2:
                    performSubtraction(scanner);
                    break;
                case 3:
                    performMultiplication(scanner);
                    break;
                case 4:
                    performDivision(scanner);
                    break;
                case 5:
                    performSquareRoot(scanner);
                    break;
                case 6:
                    performExponentiation(scanner);
                    break;
                case 7:
                    performTemperatureConversion(scanner);
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);

        scanner.close(); // Close the scanner at the end
    }

    private static double getValidDouble(Scanner scanner) {
        while (true) {
            try {
                return scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next(); // Clear the invalid input
            }
        }
    }

    private static int getValidInteger(Scanner scanner) {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.next(); // Clear the invalid input
            }
        }
    }

    private static void performAddition(Scanner scanner) {
        System.out.print("Enter two numbers: ");
        double num1 = getValidDouble(scanner);
        double num2 = getValidDouble(scanner);
        System.out.println("Result: " + (num1 + num2));
    }

    private static void performSubtraction(Scanner scanner) {
        System.out.print("Enter two numbers: ");
        double num1 = getValidDouble(scanner);
        double num2 = getValidDouble(scanner);
        System.out.println("Result: " + (num1 - num2));
    }

    private static void performMultiplication(Scanner scanner) {
        System.out.print("Enter two numbers: ");
        double num1 = getValidDouble(scanner);
        double num2 = getValidDouble(scanner);
        System.out.println("Result: " + (num1 * num2));
    }

    private static void performDivision(Scanner scanner) {
        System.out.print("Enter two numbers: ");
        double num1 = getValidDouble(scanner);
        double num2 = getValidDouble(scanner);
        if (num2 != 0) {
            System.out.println("Result: " + (num1 / num2));
        } else {
            System.out.println("Error: Division by zero is not allowed.");
        }
    }

    private static void performSquareRoot(Scanner scanner) {
        System.out.print("Enter a number: ");
        double num = getValidDouble(scanner);
        if (num >= 0) {
            System.out.println("Result: " + Math.sqrt(num));
        } else {
            System.out.println("Error: Cannot calculate square root of a negative number.");
        }
    }

    private static void performExponentiation(Scanner scanner) {
        System.out.print("Enter base and exponent: ");
        double base = getValidDouble(scanner);
        double exponent = getValidDouble(scanner);
        System.out.println("Result: " + Math.pow(base, exponent));
    }

    private static void performTemperatureConversion(Scanner scanner) {
        System.out.println("1. Celsius to Fahrenheit");
        System.out.println("2. Fahrenheit to Celsius");
        System.out.print("Choose conversion type: ");
        int conversionType = getValidInteger(scanner);

        if (conversionType == 1) {
            System.out.print("Enter temperature in Celsius: ");
            double celsius = getValidDouble(scanner);
            double fahrenheit = (celsius * 9 / 5) + 32;
            System.out.println("Result: " + fahrenheit + " °F");
        } else if (conversionType == 2) {
            System.out.print("Enter temperature in Fahrenheit: ");
            double fahrenheit = getValidDouble(scanner);
            double celsius = (fahrenheit - 32) * 5 / 9;
            System.out.println("Result: " + celsius + " °C");
        } else {
            System.out.println("Invalid conversion type.");
        }
    }
}
