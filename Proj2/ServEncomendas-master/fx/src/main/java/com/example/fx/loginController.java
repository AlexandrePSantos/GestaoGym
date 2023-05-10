package com.example.fx;
import com.bd.BLL.UsersBLL;
import com.bd.DAL.Users;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;



public class loginController {
    private Label welcomeText;

    @FXML
    private Button btnIniciar;


    @FXML
    private TextField lblEmail;

    @FXML
    private PasswordField lblPassword;

    @FXML
    void handleBtnIniciar(ActionEvent event) throws IOException {
        Stage stage = new Stage();

        Users user = null;
        user = UsersBLL.login(lblEmail.getText(),lblPassword.getText());
            if(user.isAdmin()){
            Parent root =  FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Admin/paginaprincipaladmin.fxml"))); //mudar para a pagina do admin
            stage.setScene(new Scene(root));
            stage.show();
            loginSucess();
            Node  source = (Node)  event.getSource();
            Stage stageAtual  = (Stage) source.getScene().getWindow();
            stageAtual.close();

            }


        else{
          //  loginAlert();
        }
        if(user.isCozinheiro()){
        Parent root =  FXMLLoader.load(Objects.requireNonNull(getClass().getResource("cozinheiro/painelcozi.fxml")));
        stage.setScene(new Scene(root));
        stage.show();
        loginSucess();
        Node  source = (Node)  event.getSource();
        Stage stageAtual  = (Stage) source.getScene().getWindow();
        stageAtual.close();

       }
       else{
        }
        if(user.isGestor()){
            Parent root =  FXMLLoader.load(Objects.requireNonNull(getClass().getResource("gestor/painelGestor.fxml")));
            stage.setScene(new Scene(root));
            stage.show();
            loginSucess();
            Node  source = (Node)  event.getSource();
            Stage stageAtual  = (Stage) source.getScene().getWindow();
            stageAtual.close();

        }



        //Permite abrir a nova pagina e fechar a atual


    }

    @FXML
    void handleLblEmail(ActionEvent event) {

    }

    @FXML
    void handleLblPassword(ActionEvent event) {

    }

    public void loginAlert(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erro!");
        alert.setHeaderText("Username ou Password Errados!");
        alert.setContentText("Tente novamente");
        alert.show();
    }


    public void loginSucess(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Login efetuado com sucesso!");
        alert.setHeaderText("Login inciado com sucesso");
        alert.setContentText("Aproveite a navegação");
        alert.show();
    }
}
