package com.example.fx.controllerGestor;

import com.bd.BLL.ClienteBLL;
import com.bd.DAL.Clientes;
import com.bd.DAL.Codpostais;
import com.example.fx.loginController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.math.BigInteger;

public class gestorClRegistoController {

    Clientes cli = new Clientes();


    @FXML
    private Button btnRegistar;

    @FXML
    private Button btnVoltarEs;

    @FXML
    private TextField codpostal;

    /*
        @FXML
        private TextField localidade;
    */
    @FXML
    private TextField morada;

    @FXML
    private TextField nif;

    @FXML
    private TextField nome;



    @FXML
    private TextField telefone;



    @FXML
    void edEmail(ActionEvent event) {

    }

    @FXML
    void edMorada(ActionEvent event) {

    }

    @FXML
    void edNif(ActionEvent event) {

    }

    @FXML
    void edPasse(ActionEvent event) {

    }

    @FXML
    void codpostal(ActionEvent event) {

    }

    @FXML
    void edTelefone(ActionEvent event) {

    }


    @FXML
    void editNo(ActionEvent event) {

    }
/*
    @FXML
    void edlocalidade(ActionEvent event) {

    }
*/


    @FXML
    void handleBtnRegistar(ActionEvent event) {

        if (isInputValid()) {

            {

                Clientes cl = new Clientes();
                Codpostais codpostais = new Codpostais();

                /*Registo do cliente na tabela cliente*/
                cl.setNumtelemovel(telefone.getText());
                cl.setNome(nome.getText());
                cl.setNif(BigInteger.valueOf(Integer.parseInt(nif.getText())));
                cl.setRua(morada.getText());
                cl.setEstado(true);
                cl.setCodpostal(Integer.parseInt(codpostal.getText()));
                /*Registo do cliente do Codigo postal*/
                // codpostais.setLocalidade(localidade.getText());

                ClienteBLL.create(cl);
                // CodPostaisBLL.create(codpostais);

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
        FXMLLoader fxmlLoader = new FXMLLoader(loginController.class.getResource("gestor/clientesGestor.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 960 , 600);
        stage.setScene(scene);
        stage.show();

        Node source = (Node)  event.getSource();
        Stage stageAtual  = (Stage) source.getScene().getWindow();
        stageAtual.close();

    }


    public void criarCliente (Clientes cli) {

    }

    /*
     *Efetuar a comparação caso exista campos sem dados ou insira dados ja existentes
     * **/
    public boolean isInputValid(){


        String errorMessage = "";

        if (nome.getText().isEmpty() || nome.getText().length() == 0) {
            errorMessage += "Email inválido!\n";
        }

        if (morada.getText() == null || morada.getText().length() == 0) {
            errorMessage += "Username iniválida!\n";
        }
        if (codpostal.getText() == null || codpostal.getText().length() == 0) {
            errorMessage += "Passe inválida!\n";
        }

        /*Verifica se ja existe um nif*/
        if(ClienteBLL.nifRepetidoCliente(BigInteger.valueOf(Integer.parseInt(nif.getText())))){
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
