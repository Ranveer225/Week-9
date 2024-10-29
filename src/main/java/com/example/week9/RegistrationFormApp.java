package com.example.week9;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * @throws Exception
 */
public class RegistrationFormApp extends Application {
    /**
     * @param primaryStage
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        TextField firstNameField = new TextField();
        firstNameField.setPromptText("First Name");

        TextField lastNameField = new TextField();
        lastNameField.setPromptText("Last Name");

        TextField emailField = new TextField();
        emailField.setPromptText("Email");

        TextField dobField = new TextField();
        dobField.setPromptText("Date of Birth (MM/DD/YYYY)");

        TextField zipCodeField = new TextField();
        zipCodeField.setPromptText("Zip Code");
       // TextFields for input

        Label feedbackLabel = new Label();
        Button addButton = new Button("Add");
        addButton.setDisable(true); //Add button

        firstNameField.focusedProperty().addListener((obs, wasFocused, isNowFocused) -> {
            if (!isNowFocused) {
                if (!firstNameField.getText().matches("^[A-Za-z]{2,25}$")) {
                    feedbackLabel.setText("First Name must be 3-... letters.");
                } else {
                    feedbackLabel.setText("");
                }
            }
            checkAllFieldsValid(firstNameField, lastNameField, emailField, dobField, zipCodeField, addButton);
        });

        lastNameField.focusedProperty().addListener((obs, wasFocused, isNowFocused) -> {
            if (!isNowFocused) {
                if (!lastNameField.getText().matches("^[A-Za-z]{2,25}$")) {
                    feedbackLabel.setText("Last Name must be 3-... letters.");
                } else {
                    feedbackLabel.setText("");
                }
            }
            checkAllFieldsValid(firstNameField, lastNameField, emailField, dobField, zipCodeField, addButton);
        });
        emailField.focusedProperty().addListener((obs, wasFocused, isNowFocused) -> {
            if (!isNowFocused) {
                if (!emailField.getText().matches("^[\\w.+-]+@farmingdale\\.edu$")) {
                    feedbackLabel.setText("Email must be from Farmingdale.");
                } else {
                    feedbackLabel.setText("");
                }
            }
            checkAllFieldsValid(firstNameField, lastNameField, emailField, dobField, zipCodeField, addButton);
        });
        dobField.focusedProperty().addListener((obs, wasFocused, isNowFocused) -> {
            if (!isNowFocused) {
                if (!dobField.getText().matches("^\\d{2}/\\d{2}/\\d{4}$")) {
                    feedbackLabel.setText("Date of Birth is in MM/DD/YYYY format.");
                } else {
                    feedbackLabel.setText("");
                }
            }
            checkAllFieldsValid(firstNameField, lastNameField, emailField, dobField, zipCodeField, addButton);
        });
        zipCodeField.focusedProperty().addListener((obs, wasFocused, isNowFocused) -> {
            if (!isNowFocused) {
                if (!zipCodeField.getText().matches("^\\d{5}$")) {
                    feedbackLabel.setText("Zip Code is 5 numbers.");
                } else {
                    feedbackLabel.setText("");
                }
            }
            checkAllFieldsValid(firstNameField, lastNameField, emailField, dobField, zipCodeField, addButton);
        });
        addButton.setOnAction(e -> {
            feedbackLabel.setText("Registration Success");
        });
        VBox layout = new VBox(10, firstNameField, lastNameField, emailField, dobField, zipCodeField, addButton, feedbackLabel);
        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout, 300, 400);
        primaryStage.setTitle("Registration Form");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    /**
     * @param firstNameField First Name input
     * @param lastNameField Last Name input
     * @param emailField Email input
     * @param dobField Date of Birth input
     * @param zipCodeField Zip Code input
     * @param addButton fields are valid
     */
    private void checkAllFieldsValid(TextField firstNameField, TextField lastNameField, TextField emailField, TextField dobField, TextField zipCodeField, Button addButton) {
        boolean allValid = firstNameField.getText().matches("^[A-Za-z]{2,25}$") &&
                lastNameField.getText().matches("^[A-Za-z]{2,25}$") &&
                emailField.getText().matches("^[\\w.+-]+@farmingdale\\.edu$") &&
                dobField.getText().matches("^\\d{2}/\\d{2}/\\d{4}$") &&
                zipCodeField.getText().matches("^\\d{5}$");

        addButton.setDisable(!allValid); // Enable button
    }
    public static void main(String[] args) {
        launch(args);
    }
}
