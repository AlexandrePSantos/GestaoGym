package com.example.fx.controllerEstafeta;

import com.example.fx.loginController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;

public class listaPedidosController {


    @FXML
    private TableColumn<?, ?> Qtd;

    @FXML
    private Button btnEstado;

    @FXML
    private Button btnLogout;

    @FXML
    private Button btnPesquisar;

    @FXML
    private Button btnVoltarEs;

    @FXML
    private TableColumn<?, ?> data;

    @FXML
    private TableColumn<?, ?> descricao;

    @FXML
    private TableColumn<?, ?> estado;

    @FXML
    private TableColumn<?, ?> nCliente;

    @FXML
    private TableColumn<?, ?> nPedido;

    @FXML
    void handleBtnEstado(ActionEvent event) {

    }

    @FXML
    void handleBtnLogout(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(loginController.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 960 , 600);
        stage.setScene(scene);
        stage.show();

        Node source = (Node)  event.getSource();
        Stage stageAtual  = (Stage) source.getScene().getWindow();
        stageAtual.close();

    }

    @FXML
    void handleBtnPesquisar(ActionEvent event) {

    }

    @FXML
    void handleBtnVoltarEs(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(loginController.class.getResource("estafeta/painelEstafeta.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 960 , 600);
        stage.setScene(scene);
        stage.show();

        Node source = (Node)  event.getSource();
        Stage stageAtual  = (Stage) source.getScene().getWindow();
        stageAtual.close();

    }

}
