package src;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DatabaseHelper.createTables();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Library Management System");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String password = scanner.nextLine();

                    User newUser = new User(name, email, password);
                    LibraryManager.registerUser(newUser);
                    System.out.println("Registration successful.");
                    break;
                case 2:
                    System.out.print("Enter email: ");
                    email = scanner.nextLine();
                    System.out.print("Enter password: ");
                    password = scanner.nextLine();

                    User user = LibraryManager.loginUser(email, password);
                    if (user != null) {
                        System.out.println("Login successful.");
                        userMenu(user, scanner);
                    } else {
                        System.out.println("Invalid email or password.");
                    }
                    break;
                case 3:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void userMenu(User user, Scanner scanner) {
        while (true) {
            System.out.println("\nUser Menu");
            System.out.println("1. View Recommended Books");
            System.out.println("2. Logout");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    List<Book> recommendations = LibraryManager.recommendBooks(user);
                    System.out.println("Recommended Books:");
                    for (Book book : recommendations) {
                        System.out.println("Title: " + book.getTitle());
                        System.out.println("Author: " + book.getAuthor());
                        System.out.println("Genre: " + book.getGenre());
                        System.out.println("Available: " + (book.isAvailable() ? "Yes" : "No"));
                        System.out.println();
                    }
                    break;
                case 2:
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
