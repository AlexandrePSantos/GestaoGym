package com.example.javafx;

import com.AcessoBD.DAO.FuncionarioDAO;
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
    @FXML
    public Label loginSuccess, passErrada, mailErrado;
    @FXML
    public Button login_btn;
    @FXML
    public TextField email;
    @FXML
    public PasswordField password;

    @FXML
    protected void login(ActionEvent event) throws IOException {
        FuncionarioDAO fd = new FuncionarioDAO();
        Stage stage = new Stage();
        LoginBLL l = new LoginBLL();

        // Verificar se os campos de email e senha estão vazios
        if (email.getText().isEmpty() || password.getText().isEmpty()) {
            passErrada.setText("Preencha todos os campos!");
            return; // Terminar o método aqui para evitar exceções desnecessárias
        }

        Funcionario f = fd.getByEmail(email.getText());

        if (f != null && !(password.getText().equals(f.getPassword()))) {
            passErrada.setText("Password errada!");
        } else {
            FXMLLoader fxmlLoader;
            String titulo;

            switch (f.getFuncao()) {
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

            // Load do arquivo FXML
            Parent root = fxmlLoader.load();

            // Obter o controlador para a página de destino
            instrutor_dashboard inst_dash = fxmlLoader.getController();
            // Passar o ID do user para o dashboard controller
            inst_dash.setUserId(f.getId());
            inst_dash.loadPerfil(f.getId());

            Scene scene = new Scene(root);
            stage.setTitle(titulo);
            stage.setScene(scene);
            stage.show();

            Node source = (Node) event.getSource();
            Stage stageAtual = (Stage) source.getScene().getWindow();
            stageAtual.close();
        }
    }
}
