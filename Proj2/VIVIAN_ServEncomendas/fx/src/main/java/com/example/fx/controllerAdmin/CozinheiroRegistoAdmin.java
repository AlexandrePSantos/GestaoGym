package com.example.fx.controllerAdmin;

import com.bd.BLL.UsersBLL;
import com.bd.DAL.Users;
import com.example.fx.loginController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class CozinheiroRegistoAdmin {

    @FXML
    private Button btnRegistar;

    @FXML
    private Button btnVoltarEs;

    @FXML
    private TextField email;

    @FXML
    private TextField passe;

    @FXML
    private TextField username;

    @FXML
    void edEmail(ActionEvent event) {

    }

    @FXML
    void edPasse(ActionEvent event) {

    }

    @FXML
    void edUsername(ActionEvent event) {

    }

    @FXML
    void handleBtnRegistar(ActionEvent event) {

        if (isInputValid()) {

            {
                Users user = new Users();
                /*Inserir os dados do cozinheiro*/
                user.setEmail(email.getText());
                user.setNomeuser(username.getText());
                user.setPassword(passe.getText());
                user.setCozinheiro(true);//estado do cozinheiro verdadeiro (is_cozinheiro)
                user.setEstado(true); //estado do cozinheiro verdadeiro
                UsersBLL.create(user); //criar o user cozinehiro


                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Registo");
                alert.setHeaderText("Registo efetuado com sucesso!");
                alert.show();
            }
        }
    }

    @FXML
    void handleBtnVoltarEs(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(loginController.class.getResource("Admin/cozinheiroAdmin.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 960 , 600);
        stage.setScene(scene);
        stage.show();

        Node source = (Node)  event.getSource();
        Stage stageAtual  = (Stage) source.getScene().getWindow();
        stageAtual.close();

    }

    /*
    *   Comparar se existe algum dado igual e se há campos sem dados
    * */
    public boolean isInputValid(){

        String errorMessage = "";

        if (email.getText().isEmpty() || email.getText().length() == 0) {
            errorMessage += "Email inválido!\n";
        }

        if (passe.getText().isEmpty() || passe.getText().length() == 0) {
            errorMessage += "Palavra-passe iniválida!\n";
        }
        if (username.getText().isEmpty() || username.getText().length() == 0) {
            errorMessage += "Username inválido!\n";
        }
       if(UsersBLL.emailRepetido(email.getText())){
            errorMessage += "Email já existe!\n";
        }




        if (errorMessage.length() == 0) {
            return true;
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Campos inválidos");
            alert.setHeaderText("Preencha corretamente os campos!");
            alert.setContentText(errorMessage);
            alert.showAndWait();
            return false;
        }

    }


}
