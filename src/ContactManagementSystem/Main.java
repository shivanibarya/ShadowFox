package ContactManagementSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ContactManager contactManager = new ContactManager();
        boolean exit = false;

        while (!exit) {
            System.out.println("\n**** Contact Management System ****");
            System.out.println("1. Add Contact");
            System.out.println("2. View Contacts");
            System.out.println("3. Update Contact");
            System.out.println("4. Delete Contact");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    // Add Contact
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Phone Number: ");
                    String phoneNumber = scanner.nextLine();
                    System.out.print("Enter Email: ");
                    String email = scanner.nextLine();
                    contactManager.addContact(name, phoneNumber, email);
                    break;

                case 2:
                    // View Contacts
                    contactManager.viewContacts();
                    break;

                case 3:
                    // Update Contact
                    contactManager.viewContacts();  // Show all contacts first
                    System.out.print("Enter the contact number to update: ");
                    int updateIndex = scanner.nextInt() - 1;
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter New Name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter New Phone Number: ");
                    String newPhoneNumber = scanner.nextLine();
                    System.out.print("Enter New Email: ");
                    String newEmail = scanner.nextLine();
                    contactManager.updateContact(updateIndex, newName, newPhoneNumber, newEmail);
                    break;

                case 4:
                    // Delete Contact
                    contactManager.viewContacts();  // Show all contacts first
                    System.out.print("Enter the contact number to delete: ");
                    int deleteIndex = scanner.nextInt() - 1;
                    contactManager.deleteContact(deleteIndex);
                    break;

                case 0:
                    // Exit
                    exit = true;
                    System.out.println("Exiting Contact Management System.");
                    break;

                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }
        scanner.close();
    }
}
