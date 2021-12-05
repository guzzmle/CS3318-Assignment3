package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Window;



public class FormController {
    @FXML
    private TextField nameField;

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button submitButton;

    @FXML
    protected void buttonHandler() {
        Window wind = submitButton.getScene().getWindow();
        String message = "Welcome " + nameField.getText();
        boolean fieldError = true;

        if((passwordField.getText().length() >= 7) &&
                passwordField.getText().matches(".*[a-zA-Z].*") &&
                passwordField.getText().matches(".*[0-9].*") &&
                (
                        passwordField.getText().contains("*") ||
                                passwordField.getText().contains("^") ||
                                passwordField.getText().contains("&") ||
                                passwordField.getText().contains("@") ||
                                passwordField.getText().contains("!")
                )) {
            fieldError = false;
        } else {
            message = """
                    Please enter a stronger password.\s
                    TIP: a strong password has to be at least 7 characters in length,\s
                    contains at least 1 letter,\s
                    contains at least 1 digit,\s
                    and contains at least 1 character from *^&@!""";
        }

        if(emailField.getText().matches("(.*)@(.*).com") || emailField.getText().matches("(.*)@(.*).ie")) {
            fieldError = false;
        } else {
            message = "Please enter a valid email address";
        }

        if(!(passwordField.getText().isEmpty())) {
            fieldError = false;
        } else {
            message = "Please enter your password";
        }

        if(!(emailField.getText().isEmpty())) {
            fieldError = false;
        } else {
            message = "Please enter your email address";
        }

        if(!(nameField.getText().isEmpty())) {
            fieldError = false;
        } else {
            message = "Please enter your name";
        }

        if(fieldError) {
            AlertHandler.showAlert(Alert.AlertType.ERROR, wind, "Form Error!",
                    message);
            return;
        } else {
            AlertHandler.showAlert(Alert.AlertType.CONFIRMATION, wind, "Registration Successful!",
                    message);
        }
    }
}