package controller;

import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.io.*;

import org.example.AcessoBD;

public class _login {
    @FXML
    TextField login_user;
    @FXML
    PasswordField login_password;
    @FXML
    Button login_confirmar;

    @FXML
    protected void onActionConfirmar(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        //TODO se _login der instrutor: vai para instrutor_dashboard
//        if(l.loginFuncionario == 1) {
//            FXMLLoader fxmlLoader = new FXMLLoader(new File("../Ginasio_Projeto2/javafx/src/main/resources/com/example/javafx/rececionista_dashboard.fxml").toURI().toURL());
//            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
//            stage.setTitle("Rececionista: Dashboard");
//            stage.setScene(scene);
//            stage.show();
//
//            Node source = (Node) event.getSource();
//            Stage stageAtual = (Stage) source.getScene().getWindow();
//            stageAtual.close();
//        } else if (l.loginFuncionario == 2) {
//            FXMLLoader fxmlLoader = new FXMLLoader(new File("../Ginasio_Projeto2/javafx/src/main/resources/com/example/javafx/instrutor_dashboard.fxml").toURI().toURL());
//            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
//            stage.setTitle("Instrutor: Dashboard");
//            stage.setScene(scene);
//            stage.show();
//
//            Node source = (Node) event.getSource();
//            Stage stageAtual = (Stage) source.getScene().getWindow();
//            stageAtual.close();
//        } else if (l.loginFuncionario == 0) {
//            //failed
//        }
    }
}
