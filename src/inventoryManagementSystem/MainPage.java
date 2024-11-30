package inventoryManagementSystem;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MainPage extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Inventory Management System");

        Label label = new Label("Welcome to the Inventory Management System!");
        
        StackPane layout = new StackPane();
        layout.getChildren().add(label);
        
        Scene scene = new Scene(layout, 400, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
