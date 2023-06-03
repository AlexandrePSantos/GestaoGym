package com.example.javafx;

import com.example.javafx.InstrutorController.instrutor_dashboard;
import com.AcessoBD.BLL.LoginBLL;
import com.AcessoBD.repository.entities.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
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
        Funcionario funcionario = l.loginFuncionario(email.getText(), password.getText());

        if (funcionario != null) {
            FXMLLoader fxmlLoader;
            String titulo;

            switch (funcionario.getFuncao()) {
                case "Instrutor":
                    fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/javafx/Instrutor/instrutor_dashboard.fxml"));
                    titulo = "Instrutor: Dashboard";
                    break;
                case "Administrador":
                    fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/javafx/Adminstrador/administrador_dashboard.fxml"));
                    titulo = "Admin: Dashboard";
                    break;
                case "Rececionista":
                    fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/javafx/Rececionista/rececionista_dashboard.fxml"));
                    titulo = "Rececionista: Dashboard";
                    break;
                default:
                    System.out.println("Login falhou");
                    return; // Termina o método se o login falhar
            }

            // Carregue o arquivo FXML
            Parent root = fxmlLoader.load();

            // Obtenha o controlador para a página de destino
            instrutor_dashboard inst_dash = fxmlLoader.getController();
            // Passe o ID do usuário para o DashboardController
            inst_dash.setUserId(funcionario.getId());
            inst_dash.loadPerfil(funcionario.getId());

            Scene scene = new Scene(root);
            stage.setTitle(titulo);
            stage.setScene(scene);
            stage.show();

            Node source = (Node) event.getSource();
            Stage stageAtual = (Stage) source.getScene().getWindow();
            stageAtual.close();
        }
    }




    //   Alertas precisam de ser apresentados antes do dashboard e com pausa de alguns segundos
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
