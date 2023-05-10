package com.example.fx.controllerGestor;

import com.example.fx.loginController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class painelGestorController {

    @FXML
    private Button btnClientes;

    @FXML
    private Button btnEfPedido;

    @FXML
    private Button btnEmenta;

    @FXML
    private Button btnEstafeta;

    @FXML
    private Button btnLogout;

    @FXML
    private Button btnPagamento;

    @FXML
    private Button btnPedidos;

    @FXML
    void handleBtnClientes(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(loginController.class.getResource("gestor/clientesGestor.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 960 , 600);
        stage.setScene(scene);
        stage.show();

        Node source = (Node)  event.getSource();
        Stage stageAtual  = (Stage) source.getScene().getWindow();
        stageAtual.close();

    }

    @FXML
    void handleBtnEfPedido(ActionEvent event) {

    }

    @FXML
    void handleBtnEmenta(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(loginController.class.getResource("gestor/ementaGestor.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 960 , 600);
        stage.setScene(scene);
        stage.show();

        Node source = (Node)  event.getSource();
        Stage stageAtual  = (Stage) source.getScene().getWindow();
        stageAtual.close();
    }

    @FXML
    void handleBtnEstafeta(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(loginController.class.getResource("gestor/estafetasGestor.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 960 , 600);
        stage.setScene(scene);
        stage.show();

        Node source = (Node)  event.getSource();
        Stage stageAtual  = (Stage) source.getScene().getWindow();
        stageAtual.close();
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
    void handleBtnPagamento(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(loginController.class.getResource("gestor/clientePedidosGestor.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 960 , 600);
        stage.setScene(scene);
        stage.show();

        Node source = (Node)  event.getSource();
        Stage stageAtual  = (Stage) source.getScene().getWindow();
        stageAtual.close();
    }

    @FXML
    void handleBtnPedidos(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(loginController.class.getResource("gestor/pedidosGestor.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 960 , 600);
        stage.setScene(scene);
        stage.show();

        Node source = (Node)  event.getSource();
        Stage stageAtual  = (Stage) source.getScene().getWindow();
        stageAtual.close();
    }

}
