package asuHelloWorldJavaFX;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ASUHelloWorldJavaFX extends Application {
	
    public void start(Stage primaryStage) {
        primaryStage.setTitle("New Planning Poker");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(5);
        grid.setHgap(5);

        // Title Label
        Label titleLabel = new Label("Title:");
        grid.add(titleLabel, 0, 0);

        // Title Text Field
        TextField titleField = new TextField();
        titleField.setPromptText("Current Planning Poker");
        grid.add(titleField, 1, 0);

        // User Story Label
        Label ageLabel = new Label("User Story:");
        grid.add(ageLabel, 0, 1);

        // User Story Text Field
        TextField storyField = new TextField();
        storyField.setPromptText("As a...I want to...so that");
        grid.add(storyField, 1, 1);
        
        // Keyword Label
        Label managerLabel = new Label("Keywords:");
        grid.add(managerLabel, 0, 2);
        
        // Keyword Text Field
        TextField keywordField = new TextField();
        keywordField.setPromptText("Clients, Location, Time Period");
        keywordField.setPrefHeight(100);
        keywordField.setAlignment(Pos.TOP_LEFT);
        grid.add(keywordField, 1, 2);

        // Submit Button
        Button submitButton = new Button("Submit Planning Poker");
        grid.add(submitButton, 0, 7);
        
        //Fetched Historical Data
        TextField historyField = new TextField();
        historyField.setPromptText("Fetched Historical Data");
        historyField.setPrefHeight(100);
        historyField.setAlignment(Pos.TOP_LEFT);
        grid.add(historyField, 0, 12);

        //Title Result Label
        Label titleResult = new Label();
        grid.add(titleResult, 0, 9, 2, 1);
        
        //User Story Result Label
        Label storyResult = new Label();
        grid.add(storyResult, 0, 10, 2, 1);
        
        //Location ID Result Label
        Label locationResult = new Label();
        grid.add(locationResult, 0, 11, 2, 1);

        int locationID = 1051;
        
        // Submit Button Event Handler
        submitButton.setOnAction(event -> {
            String titleText = titleField.getText();
            String storyText = storyField.getText();
            String keywordText = keywordField.getText();
            
            /* Error Handling
            try {
                int age = Integer.parseInt(ageText);
                // Check compatibility
                if (age >= 18) {
                    ageResult.setText("Age data is compatible!");
                } else {
                    ageResult.setText("Age data is not compatible!");
                }
             
            } catch (NumberFormatException e) {
                ageResult.setText("Invalid age format!");
            } */
            
            // Display Database Submission Content
            titleResult.setText("Title: " + titleText);
            storyResult.setText("User Story: " + storyText);
            locationResult.setText("Location ID: " + locationID);
            
        });
        
        // GUI Dimensions
        Scene scene = new Scene(grid, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
        
        
    }
       
    
    public static void main(String[] args) {
        launch(args);
    }
}
