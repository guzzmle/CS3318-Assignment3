package com.example.demo;

import javafx.event.ActionEvent;
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
    protected void buttonHandler(ActionEvent event) {
        Window wind = submitButton.getScene().getWindow();
        String message = "Welcome " + nameField.getText();
        boolean fieldError = true;

        if(!(nameField.getText().isEmpty())) {
            fieldError = false;
        } else {
            message = "Please enter your name";
        }

        if(!(emailField.getText().isEmpty())) {
            fieldError = false;
        } else {
            message = "Please enter your email address";
        }

        if(!(passwordField.getText().isEmpty())) {
            fieldError = false;
        } else {
            message = "Please enter your password";
        }

        if(emailField.getText().matches("(.*)@(.*).com")) {
            fieldError = false;
        } else {
            message = "Please enter a valid email address";
        }

        if((passwordField.getText().length() >= 7) &&
                passwordField.getText().matches("[abcdefghijklmnopqrstuvwxyz]") &&
                passwordField.getText().matches("[0123456789]") &&
                passwordField.getText().matches("[&@!]")) {
            fieldError = false;
        } else {
            message = "Please enter a stronger password. \n" +
                    "TIP: a strong password has to be at least 7 characters in length, \n" +
                    "contains at least 1 letter, \n" +
                    "contains at least 1 digit, \n" +
                    "and contains at least 1 character from *^&@!";
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