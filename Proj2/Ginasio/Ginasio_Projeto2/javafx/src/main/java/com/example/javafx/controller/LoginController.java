package com.example.javafx.controller;

import com.AcessoBD.BLL.LoginBLL;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class LoginController {
    public Label errorLogin;
    public Button login_btn;
    public TextField email;
    public PasswordField password;

    @FXML
    protected void login(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        LoginBLL l = new LoginBLL();
        //TODO se _login der instrutor: vai para instrutor_dashboard
        if (l.loginFuncionario(email.getText(), password.getText()) == 1) {
            loginSuccess();
            FXMLLoader fxmlLoader = new FXMLLoader(new File("../Ginasio_Projeto2/javafx/src/main/resources/com/example/javafx/Instrutor/instrutor_dashboard.fxml").toURI().toURL());
            Scene scene = new Scene(fxmlLoader.load(), 1366, 768);
            stage.setTitle("Instrutor: Dashboard");
            stage.setScene(scene);
            stage.show();

            Node source = (Node) event.getSource();
            Stage stageAtual = (Stage) source.getScene().getWindow();
            stageAtual.close();
        } else if (l.loginFuncionario(email.getText(), password.getText()) == 2) {
            loginSuccess();
            FXMLLoader fxmlLoader = new FXMLLoader(new File("../Ginasio_Projeto2/javafx/src/main/resources/com/example/javafx/admin_dashboard.fxml").toURI().toURL());
            Scene scene = new Scene(fxmlLoader.load(), 1366, 768);
            stage.setTitle("Admin: Dashboard");
            stage.setScene(scene);
            stage.show();

            Node source = (Node) event.getSource();
            Stage stageAtual = (Stage) source.getScene().getWindow();
            stageAtual.close();
            // adicionar elif para o rececionista
        } else if (l.loginFuncionario(email.getText(), password.getText()) == 0) {
            //failed
            System.out.println("login falhou");
            loginAlert();
        }
    }

    public void loginAlert(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Login errado!");
        alert.setHeaderText("Username ou Password Errados!");
        alert.setContentText("Tente novamente");
        alert.show();
    }

    public void loginSuccess() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Login efetuado com sucesso!");
        alert.setHeaderText("Login inciado com sucesso");
        alert.setContentText("Aproveite a navegação");
        alert.show();
    }
}
