package com.example.fx.controllerGestor;

import com.bd.BLL.EstafetaBLL;
import com.bd.BLL.UsersBLL;
import com.bd.DAL.Estafeta;
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

public class gestorRegistoEstafeta {
    @FXML
    private Button btnRegistar;

    @FXML
    private Button btnVoltarEs;

    @FXML
    private TextField conEmail;

    @FXML
    private TextField email;

    @FXML
    private TextField nif;

    @FXML
    private TextField nome;

    @FXML
    private TextField passe;

    @FXML
    private TextField telefone;

    @FXML
    private TextField username;

    @FXML
    void edEmail(ActionEvent event) {

    }


    @FXML
    void edConEmail(ActionEvent event) {

    }

    //  @FXML
    //void edMorada(ActionEvent event) {
//    }

    @FXML
    void edNif(ActionEvent event) {

    }

    @FXML
    void edPasse(ActionEvent event) {

    }

    @FXML
    void edTelefone(ActionEvent event) {

    }

    @FXML
    void edUsername(ActionEvent event) {

    }

    @FXML
    void editNo(ActionEvent event) {

    }

    @FXML
    void edcodpostal (ActionEvent event) {

    }

    @FXML
    void edlocalidade(ActionEvent event) {

    }

    @FXML
    void handleBtnRegistar(ActionEvent event) {


        if (isInputValid()) {

            {

                Estafeta est = new Estafeta();

                Users user = new Users();

                /*Inserir os dados no estafeta*/




                /*Inserir os dados no user*/

                user.setPassword(passe.getText());
                user.setEmail(email.getText());
                user.setEstafeta(true);
                user.setNomeuser(nome.getText());
                user.setEstado(true);


                UsersBLL.create(user);

                est.setEmail(conEmail.getText());
                est.setNumtelefone(telefone.getText());
                est.setEstado(true);
                est.setNif(Integer.parseInt(nif.getText()));
                est.setIdUser(user.getIdUser());




                EstafetaBLL.create(est);


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
        FXMLLoader fxmlLoader = new FXMLLoader(loginController.class.getResource("gestor/estafetasGestor.fxml"));
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

        if (nome.getText().isEmpty() || nome.getText().length() == 0) {
            errorMessage += "Email inválido!\n";
        }

        if (username.getText() == null || username.getText().length() == 0) {
            errorMessage += "Username iniválida!\n";
        }
        if (passe.getText() == null || passe.getText().length() == 0) {
            errorMessage += "Passe inválida!\n";
        }

        if(UsersBLL.emailRepetido(email.getText())){
            errorMessage += "Email  já existe!\n";
        }
        if(EstafetaBLL.emailRepetidoEstafetaNif(Integer.parseInt(nif.getText()))){
            errorMessage += "Nif já existe!\n";
        }




        if (errorMessage.length() == 0 ) {
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
