package com.example.demo;

import javafx.scene.control.Alert;
import javafx.stage.Window;


public class AlertHandler {
    public static void showAlert(Alert.AlertType alertType, Window wind, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(wind);
        alert.show();
    }
}
