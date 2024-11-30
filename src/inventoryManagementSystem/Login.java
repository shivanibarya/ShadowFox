package inventoryManagementSystem;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Login extends Application {
    public static List<User> users = new ArrayList<>(); // List to store registered users

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("User Login");

        // Create a GridPane layout
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(10);
        gridPane.setHgap(10);

        // Create UI elements for login form
        Label nameLabel = new Label("Username:");
        TextField nameField = new TextField();
        
        Label passwordLabel = new Label("Password:");
        PasswordField passwordField = new PasswordField();
        
        Button loginButton = new Button("Login");

        // Add elements to gridPane
        gridPane.add(nameLabel, 0, 0);
        gridPane.add(nameField, 1, 0);
        gridPane.add(passwordLabel, 0, 1);
        gridPane.add(passwordField, 1, 1);
        gridPane.add(loginButton, 1, 2);

        // Create a scene with the gridPane
        Scene scene = new Scene(gridPane, 400, 200);
        primaryStage.setScene(scene);
        primaryStage.show();

        // Set action for login button
        loginButton.setOnAction(e -> {
            String username = nameField.getText();
            String password = passwordField.getText();
            
            if (username.isEmpty() || password.isEmpty()) {
                showAlert(Alert.AlertType.ERROR, "Form Error!", "Please fill in all fields.");
                return;
            }

            // Check user credentials
            if (authenticateUser(username, password)) {
                showAlert(Alert.AlertType.INFORMATION, "Login Success", "Welcome " + username);
                MainPage mainPage = new MainPage();
                primaryStage.close(); // Close login window
                mainPage.start(new Stage()); // Open main page
            } else {
                showAlert(Alert.AlertType.ERROR, "Login Error", "Invalid username or password.");
            }
        });
    }

    private boolean authenticateUser(String username, String password) {
        return users.stream().anyMatch(user -> user.getUsername().equals(username) && user.getPassword().equals(password));
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
    // Utility method to add a user (used by Registration class)
    public static void addUser(User user) {
        users.add(user);
    }
}
