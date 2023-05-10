package com.example.fx.controllerCozinheiro;

import com.bd.BLL.EncomendaBLL;
import com.bd.BLL.EncomendaestadosBLL;
import com.bd.BLL.PratosEncomendadosBLL;
import com.bd.DAL.*;
import com.example.fx.loginController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class pedidoCozinheiro implements Initializable {

    ObservableList<listaPedidos> listPeCoz = FXCollections.observableArrayList(EncomendaBLL.readAllMarc());

    @FXML
    private Button btnAtualizar;

    @FXML
    private Button btnEditarCoz;

    @FXML
    private Button btnVoltar;

    @FXML
    private TableColumn<listaPedidosCozinheiro, String> descricao;
   // private TableColumn<PratosEncomendados, Number> descricao;

    @FXML
    private TextField edStockCoz;



    @FXML
    private TableColumn<listaPedidos, Number> npedido;

    @FXML
    private TableColumn<listaPedidos, Number> quantidade;

    @FXML
    private TableView<listaPedidos> tblPedidosCoz;

    @FXML
    void descricao(ActionEvent event) {

    }

    @FXML
    void edStockCoz(ActionEvent event) {

    }

    @FXML
    void estado(ActionEvent event) {

    }

    @FXML
    void handleBtnAtualizar(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(loginController.class.getResource("cozinheiro/pedidoCozinheiro.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1025 , 641);
        stage.setScene(scene);
        stage.show();

        Node source = (Node)  event.getSource();
        Stage stageAtual  = (Stage) source.getScene().getWindow();
        stageAtual.close();


    }

    @FXML
    void handleBtnEditarCoz(ActionEvent event) {


            Encomendas e = EncomendaBLL.read(tblPedidosCoz.getSelectionModel().getSelectedItem().getId_encomenda());
            int id = e.getIdEncomenda();

            Encomendaestados ee = EncomendaestadosBLL.read(id);
            assert ee != null;

            Encomendaestados encomendaestados = new Encomendaestados();
            encomendaestados.setIdEncomenda(id);
            encomendaestados.setIdEstadoencomenda(2);
            encomendaestados.setData(ee.getData());
            EncomendaestadosBLL.delete(ee);
            EncomendaestadosBLL.create(encomendaestados);
            tblPedidosCoz.getItems().clear();




    }

    @FXML
    void handleBtnVoltar(ActionEvent event) throws IOException {

        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(loginController.class.getResource("cozinheiro/painelcozi.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1025 , 641);
        stage.setScene(scene);
        stage.show();

        Node source = (Node)  event.getSource();
        Stage stageAtual  = (Stage) source.getScene().getWindow();
        stageAtual.close();
    }

    @FXML
    void npedido(ActionEvent event) {

    }

    @FXML
    void quantidade(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {


            descricao.setCellValueFactory(new PropertyValueFactory<>("descricao"));
            npedido.setCellValueFactory(new PropertyValueFactory<>("id_encomenda"));
            quantidade.setCellValueFactory(new PropertyValueFactory<>("qtd"));
            tblPedidosCoz.setItems(listPeCoz);


        }

    }

