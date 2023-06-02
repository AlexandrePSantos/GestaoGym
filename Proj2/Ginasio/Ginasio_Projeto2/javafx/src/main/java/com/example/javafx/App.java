package com.example.javafx;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
//       FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("_login.fxml"));
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/Fxml/Login.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}