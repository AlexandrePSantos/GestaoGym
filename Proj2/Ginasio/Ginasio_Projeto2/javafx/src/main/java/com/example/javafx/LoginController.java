package com.example.javafx;

import com.AcessoBD.DAO.*;
import com.AcessoBD.BLL.*;
import com.AcessoBD.repository.entities.*;
import com.example.javafx.InstrutorController.instrutor_dashboard;
import com.example.javafx.RececionistaController.rececionista_dashboard;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
    @FXML
    public Label passErrada, mailErrado;
    @FXML
    public Button login_btn;
    @FXML
    public TextField email;
    @FXML
    public PasswordField password;

    @FXML
    protected void login(ActionEvent event) throws IOException {
        FuncionarioDAO fd = new FuncionarioDAO();
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
            FXMLLoader instrutorLoader = new FXMLLoader(getClass().getResource("/com/example/javafx/Instrutor/instrutor_dashboard.fxml"));
            Parent instrutorRoot = instrutorLoader.load();
            instrutor_dashboard inst_dash = instrutorLoader.getController();
            inst_dash.setUserId(f.getId());
            inst_dash.loadPerfil(f.getId());

//            FXMLLoader administradorLoader = new FXMLLoader(getClass().getResource("/com/example/javafx/Administrador/administrador_dashboard.fxml"));
//            Parent administradorRoot = administradorLoader.load();
//            rececionista_dashboard admin_dash = administradorLoader.getController();
//            admin_dash.setUserId(f.getId());
//            admin_dash.loadPerfil(f.getId());

            FXMLLoader rececionistaLoader = new FXMLLoader(getClass().getResource("/com/example/javafx/Rececionista/rececionista_dashboard.fxml"));
            Parent rececionistaRoot = rececionistaLoader.load();
            rececionista_dashboard rec_dash = rececionistaLoader.getController();
            rec_dash.setUserId(f.getId());
            rec_dash.loadPerfil(f.getId());

            Stage stage = new Stage();
            String titulo;

            switch (f.getFuncao()) {
                case "Instrutor":
                    titulo = "Instrutor: Dashboard";
                    Scene instrutorScene = new Scene(instrutorRoot);
                    stage.setScene(instrutorScene);
                    break;
                case "Administrador":
//                    titulo = "Administrador: Dashboard";
//                    Scene AdministradorScene = new Scene(administradorRoot);
//                    stage.setScene(AdministradorScene);
                    break;
                case "Rececionista":
                    titulo = "Rececionista: Dashboard";
                    Scene rececionistaScene = new Scene(rececionistaRoot);
                    stage.setScene(rececionistaScene);
                    break;
                default:
                    System.out.println("Login falhou");
                    return; // Termina o método se o login falhar
            }

            stage.show();
            Node source = (Node) event.getSource();
            Stage stageAtual = (Stage) source.getScene().getWindow();
            stageAtual.close();
        }
    }
}
