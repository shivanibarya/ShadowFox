package ContactManagementSystem;

import java.util.ArrayList;

public class ContactManager {
    // ArrayList to store contacts
    private ArrayList<Contact> contactList = new ArrayList<>();

    // Add new contact
    public void addContact(String name, String phoneNumber, String email) {
        Contact contact = new Contact(name, phoneNumber, email);
        contactList.add(contact);
        System.out.println("Contact added successfully.");
    }

    // View all contacts
    public void viewContacts() {
        if (contactList.isEmpty()) {
            System.out.println("No contacts to display.");
        } else {
            for (int i = 0; i < contactList.size(); i++) {
                System.out.println((i + 1) + ". " + contactList.get(i));
            }
        }
    }

    // Update contact by index
    public void updateContact(int index, String newName, String newPhoneNumber, String newEmail) {
        if (index >= 0 && index < contactList.size()) {
            Contact contact = contactList.get(index);
            contact.setName(newName);
            contact.setPhoneNumber(newPhoneNumber);
            contact.setEmail(newEmail);
            System.out.println("Contact updated successfully.");
        } else {
            System.out.println("Invalid contact index.");
        }
    }

    // Delete contact by index
    public void deleteContact(int index) {
        if (index >= 0 && index < contactList.size()) {
            contactList.remove(index);
            System.out.println("Contact deleted successfully.");
        } else {
            System.out.println("Invalid contact index.");
        }
    }

    // Find a contact by name (optional feature)
    public Contact findContactByName(String name) {
        for (Contact contact : contactList) {
            if (contact.getName().equalsIgnoreCase(name)) {
                return contact;
            }
        }
        System.out.println("Contact not found.");
        return null;
    }
}
