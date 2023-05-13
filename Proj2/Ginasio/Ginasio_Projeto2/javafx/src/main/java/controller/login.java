package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class login {
    @FXML
    TextField login_user;
    @FXML
    PasswordField login_password;
    @FXML
    Button login_confirmar;

    @FXML
    protected void onActionConfirmar(ActionEvent event) throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.println("Qual deles é? 1 - Instrutor, 2 - Rececionista");
        int i = input.nextInt();
        Stage stage = new Stage();
        System.out.println("something");
        System.out.println(login_user.getText());
        //TODO se login der instrutor: vai para instrutor_dashboard
        if((login_user.getText().matches("rececionista")) && login_confirmar.isPressed()) {
            FXMLLoader fxmlLoader = new FXMLLoader(new File("../Ginasio_Projeto2/javafx/src/main/resources/com/example/javafx/rececionista_dashboard.fxml").toURI().toURL());
            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            stage.setTitle("instrutor_dashboard");
            stage.setScene(scene);
            stage.show();

            Node source = (Node) event.getSource();
            Stage stageAtual = (Stage) source.getScene().getWindow();
            stageAtual.close();
        } else if ((login_user.getText().matches("instrutor")) && login_confirmar.isPressed()) {
            FXMLLoader fxmlLoader = new FXMLLoader(new File("../Ginasio_Projeto2/javafx/src/main/resources/com/example/javafx/instrutor_dashboard.fxml").toURI().toURL());
            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            stage.setTitle("instrutor_dashboard");
            stage.setScene(scene);
            stage.show();

            Node source = (Node) event.getSource();
            Stage stageAtual = (Stage) source.getScene().getWindow();
            stageAtual.close();
        }
    }
}
