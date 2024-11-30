import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;
public class EnhancedCalculator {
    private static ArrayList<String> history = new ArrayList<>(); 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            displayMenu();
            choice = getValidInteger(scanner); 
            executeChoice(choice, scanner);  
        } while (choice != 0);

        scanner.close();
    }
    private static void displayMenu() {
        System.out.println("\n--- Enhanced Console-based Calculator ---");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        System.out.println("5. Square Root");
        System.out.println("6. Exponentiation");
        System.out.println("7. Temperature Conversion");
        System.out.println("8. View Operation History");
        System.out.println("0. Exit");
        System.out.print("Choose an option: ");
    }
    private static void executeChoice(int choice, Scanner scanner) {
        switch (choice) {
            case 1: performAddition(scanner); break;
            case 2: performSubtraction(scanner); break;
            case 3: performMultiplication(scanner); break;
            case 4: performDivision(scanner); break;
            case 5: performSquareRoot(scanner); break;
            case 6: performExponentiation(scanner); break;
            case 7: performTemperatureConversion(scanner); break;
            case 8: displayHistory(); break;
            case 0: System.out.println("Exiting..."); break;
            default: System.out.println("Invalid choice. Please try again.");
        }
    }
    private static double getValidDouble(Scanner scanner) {
        while (true) {
            try {
                return scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next(); 
            }
        }
    }
    private static int getValidInteger(Scanner scanner) {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.next(); 
            }
        }
    }
    private static void performAddition(Scanner scanner) {
        System.out.print("Enter two numbers: ");
        double num1 = getValidDouble(scanner);
        double num2 = getValidDouble(scanner);
        double result = num1 + num2;
        System.out.printf("Result: %.2f\n", result);
        history.add("Addition: " + num1 + " + " + num2 + " = " + result);
    }
    private static void performSubtraction(Scanner scanner) {
        System.out.print("Enter two numbers: ");
        double num1 = getValidDouble(scanner);
        double num2 = getValidDouble(scanner);
        double result = num1 - num2;
        System.out.printf("Result: %.2f\n", result);
        history.add("Subtraction: " + num1 + " - " + num2 + " = " + result);
    }
    private static void performMultiplication(Scanner scanner) {
        System.out.print("Enter two numbers: ");
        double num1 = getValidDouble(scanner);
        double num2 = getValidDouble(scanner);
        double result = num1 * num2;
        System.out.printf("Result: %.2f\n", result);
        history.add("Multiplication: " + num1 + " * " + num2 + " = " + result);
    }
    private static void performDivision(Scanner scanner) {
        System.out.print("Enter two numbers: ");
        double num1 = getValidDouble(scanner);
        double num2 = getValidDouble(scanner);
        if (num2 != 0) {
            double result = num1 / num2;
            System.out.printf("Result: %.2f\n", result);
            history.add("Division: " + num1 + " / " + num2 + " = " + result);
        } else {
            System.out.println("Error: Division by zero is not allowed.");
        }
    }
    private static void performSquareRoot(Scanner scanner) {
        System.out.print("Enter a number: ");
        double num = getValidDouble(scanner);
        if (num >= 0) {
            double result = Math.sqrt(num);
            System.out.printf("Result: %.2f\n", result);
            history.add("Square Root: √" + num + " = " + result);
        } else {
            System.out.println("Error: Cannot calculate square root of a negative number.");
        }
    }
    private static void performExponentiation(Scanner scanner) {
        System.out.print("Enter base and exponent: ");
        double base = getValidDouble(scanner);
        double exponent = getValidDouble(scanner);
        double result = Math.pow(base, exponent);
        System.out.printf("Result: %.2f\n", result);
        history.add("Exponentiation: " + base + "^" + exponent + " = " + result);
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
            System.out.printf("Result: %.2f °F\n", fahrenheit);
            history.add("Celsius to Fahrenheit: " + celsius + " °C = " + fahrenheit + " °F");
        } else if (conversionType == 2) {
            System.out.print("Enter temperature in Fahrenheit: ");
            double fahrenheit = getValidDouble(scanner);
            double celsius = (fahrenheit - 32) * 5 / 9;
            System.out.printf("Result: %.2f °C\n", celsius);
            history.add("Fahrenheit to Celsius: " + fahrenheit + " °F = " + celsius + " °C");
        } else {
            System.out.println("Invalid conversion type.");
        }
    }
    private static void displayHistory() {
        if (history.isEmpty()) {
            System.out.println("No operations have been performed yet.");
        } else {
            System.out.println("\n--- Operation History ---");
            for (String record : history) {
                System.out.println(record);
            }
        }
    }
}


  
