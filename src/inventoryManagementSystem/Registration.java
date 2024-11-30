package inventoryManagementSystem;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Registration extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("User Registration");

        // Create a GridPane layout
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(10);
        gridPane.setHgap(10);

        // Create UI elements for registration form
        Label nameLabel = new Label("Username:");
        TextField nameField = new TextField();
        
        Label emailLabel = new Label("Email:");
        TextField emailField = new TextField();
        
        Label passwordLabel = new Label("Password:");
        PasswordField passwordField = new PasswordField();

        Label confirmPasswordLabel = new Label("Confirm Password:");
        PasswordField confirmPasswordField = new PasswordField();
        
        Button registerButton = new Button("Register");
        
        // Add elements to gridPane
        gridPane.add(nameLabel, 0, 0);
        gridPane.add(nameField, 1, 0);
        gridPane.add(emailLabel, 0, 1);
        gridPane.add(emailField, 1, 1);
        gridPane.add(passwordLabel, 0, 2);
        gridPane.add(passwordField, 1, 2);
        gridPane.add(confirmPasswordLabel, 0, 3);
        gridPane.add(confirmPasswordField, 1, 3);
        gridPane.add(registerButton, 1, 4);

        // Create a scene with the gridPane
        Scene scene = new Scene(gridPane, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
        
        // Set action for register button
        registerButton.setOnAction(e -> {
            String username = nameField.getText();
            String email = emailField.getText();
            String password = passwordField.getText();
            String confirmPassword = confirmPasswordField.getText();
            
            if (username.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                showAlert(Alert.AlertType.ERROR, "Form Error!", "Please fill in all fields.");
                return;
            }
            
            if (!password.equals(confirmPassword)) {
                showAlert(Alert.AlertType.ERROR, "Form Error!", "Passwords do not match.");
                return;
            }

            // Store user in memory
            if (isUserUnique(username, email)) {
                Login.addUser(new User(username, email, password));
                showAlert(Alert.AlertType.INFORMATION, "Registration Success", "User has been registered successfully.");
            } else {
                showAlert(Alert.AlertType.ERROR, "Registration Error", "Username or email already exists.");
            }
        });
    }

    private boolean isUserUnique(String username, String email) {
        return Login.users.stream().noneMatch(user -> user.getUsername().equals(username) || user.getEmail().equals(email));
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
}
