package com.example.fx.controllerGestor;

import com.bd.BLL.PratoBLL;
import com.bd.DAL.Pratos;
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

public class ementaRegistoGestor {
    @FXML
    private Button btnRegistar;

    @FXML
    private Button btnVoltarEs;

    @FXML
    private TextField preco;

    @FXML
    private TextField prato;

    @FXML
    private TextField stock;

    @FXML
    void edPrato(ActionEvent event) {

    }

    @FXML
    void edPreco(ActionEvent event) {

    }

    @FXML
    void edStock(ActionEvent event) {

    }

    @FXML
    void handleBtnRegistar(ActionEvent event) {

        if (isInputValid()) {
            {
                Pratos pra = new Pratos();
                /*Adicionar os dados do novo prato*/
                pra.setStockdoses(Integer.parseInt(stock.getText()));
                pra.setPrecoatual(Float.parseFloat(preco.getText()));
                pra.setEstado(true);
                pra.setDescricao(prato.getText());
                PratoBLL.create(pra);


                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Ementa");
                alert.setHeaderText("Prato criado com sucesso");
                alert.setContentText("Atualize a página");
                alert.show();


            }
        }
    }

    @FXML
    void handleBtnVoltarEs(ActionEvent event) throws IOException {

        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(loginController.class.getResource("gestor/ementaGestor.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 960 , 600);
        stage.setScene(scene);
        stage.show();

        Node source = (Node)  event.getSource();
        Stage stageAtual  = (Stage) source.getScene().getWindow();
        stageAtual.close();


    }

    /**
     * Comparar caso exista algum campo sem dado
     * */
    public boolean isInputValid(){


        String errorMessage = "";

        if (preco.getText().isEmpty() || preco.getText().length() == 0) {
            errorMessage += "Preco inválido!\n";
        }

        if (prato.getText() == null || prato.getText().length() == 0) {
            errorMessage += "Prato inválido!\n";
        }
        if (stock.getText() == null || stock.getText().length() == 0) {
            errorMessage += "Stock inválido!\n";
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
