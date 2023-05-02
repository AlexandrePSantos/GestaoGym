package com.example.javafx.Instrutor;

        import javafx.fxml.FXML;
        import javafx.scene.control.Label;

public class Planos {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}