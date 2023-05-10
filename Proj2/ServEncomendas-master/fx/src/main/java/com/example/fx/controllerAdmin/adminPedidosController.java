package com.example.fx.controllerAdmin;

import com.bd.BLL.EncomendaBLL;
import com.bd.DAL.listaPedidos;
import com.example.fx.loginController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class adminPedidosController implements Initializable {

    public Button btnConcluido;
    public Button btnMarcados;
    public Button btnCancelados;
    @FXML
    private Button btnEditar;

    @FXML
    private Button btnLogout;

    @FXML
    private Button btnNew;

    @FXML
    private Button btnPesquisar;

    @FXML
    private Button btnVoltarEs;

    @FXML
    private TableColumn<listaPedidos, Integer> Qtd;

    @FXML
    private TableColumn<listaPedidos, String> data;

    @FXML
    private TableColumn<listaPedidos, String> descricao;

    @FXML
    private TableColumn<listaPedidos, Integer> estado;

    @FXML
    private TableColumn<listaPedidos, Integer> nCliente;

    @FXML
    private TableColumn<listaPedidos, Integer> nPedido;

    @FXML
    private TableColumn<listaPedidos, Integer> noEstafeta;

    @FXML
    private TableColumn<listaPedidos, Float> valor;


    @FXML
    private TableColumn<listaPedidos, String> tipoPag;

    @FXML
    void handleBtnEditar(ActionEvent event) {

    }

    @FXML
    void handleBtnLogout(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(loginController.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 960, 600);
        stage.setScene(scene);
        stage.show();

        Node source = (Node) event.getSource();
        Stage stageAtual = (Stage) source.getScene().getWindow();
        stageAtual.close();
    }


    @FXML
    private TableView<listaPedidos> tblPedidos;


    @FXML
    void handleBtnNew(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(loginController.class.getResource("Admin/pedidoRegistoAdmin.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 960, 600);
        stage.setScene(scene);
        stage.show();

        Node source = (Node) event.getSource();
        Stage stageAtual = (Stage) source.getScene().getWindow();
        stageAtual.close();
    }

    @FXML
    void handleBtnPesquisar(ActionEvent event) {

    }


    @FXML
    void handleBtnVoltarEs(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(loginController.class.getResource("Admin/paginaprincipaladmin.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 960, 600);
        stage.setScene(scene);
        stage.show();

        Node source = (Node) event.getSource();
        Stage stageAtual = (Stage) source.getScene().getWindow();
        stageAtual.close();
    }

    @FXML
    void handleTipopag(ActionEvent event) {

    }

    @FXML
    void handleBtnCancelados(ActionEvent event) {
        tblPedidos.getItems().clear();

        ObservableList<listaPedidos> listaPedCanc = FXCollections.observableArrayList(EncomendaBLL.readAllCanc());
        descricao.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        estado.setCellValueFactory(new PropertyValueFactory<>("encomendaestados"));
        nPedido.setCellValueFactory(new PropertyValueFactory<>("id_encomenda"));
        nCliente.setCellValueFactory(new PropertyValueFactory<>("id_cliente"));
        noEstafeta.setCellValueFactory(new PropertyValueFactory<>("id_estafeta"));
        valor.setCellValueFactory(new PropertyValueFactory<>("precodose"));
        data.setCellValueFactory(new PropertyValueFactory<>("data"));
        Qtd.setCellValueFactory(new PropertyValueFactory<>("qtd"));
        tipoPag.setCellValueFactory(new PropertyValueFactory<>("tp"));

        tblPedidos.setItems(listaPedCanc);
    }

    @FXML
    void handleBtnMarcados(ActionEvent event) throws IOException {
        tblPedidos.getItems().clear();

        ObservableList<listaPedidos> listaPedMarc = FXCollections.observableArrayList(EncomendaBLL.readAllMarc());
        descricao.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        estado.setCellValueFactory(new PropertyValueFactory<>("encomendaestados"));
        nPedido.setCellValueFactory(new PropertyValueFactory<>("id_encomenda"));
        nCliente.setCellValueFactory(new PropertyValueFactory<>("id_cliente"));
        noEstafeta.setCellValueFactory(new PropertyValueFactory<>("id_estafeta"));
        valor.setCellValueFactory(new PropertyValueFactory<>("precodose"));
        data.setCellValueFactory(new PropertyValueFactory<>("data"));
        Qtd.setCellValueFactory(new PropertyValueFactory<>("qtd"));
        tipoPag.setCellValueFactory(new PropertyValueFactory<>("tp"));

        tblPedidos.setItems(listaPedMarc);

    }


    @FXML
    void handleBtnConcluidos(ActionEvent event) throws IOException {
        tblPedidos.getItems().clear();

        ObservableList<listaPedidos> listaPedConc = FXCollections.observableArrayList(EncomendaBLL.readAllConc());
        descricao.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        estado.setCellValueFactory(new PropertyValueFactory<>("encomendaestados"));
        nPedido.setCellValueFactory(new PropertyValueFactory<>("id_encomenda"));
        nCliente.setCellValueFactory(new PropertyValueFactory<>("id_cliente"));
        noEstafeta.setCellValueFactory(new PropertyValueFactory<>("id_estafeta"));
        valor.setCellValueFactory(new PropertyValueFactory<>("precodose"));
        data.setCellValueFactory(new PropertyValueFactory<>("data"));
        Qtd.setCellValueFactory(new PropertyValueFactory<>("qtd"));
        tipoPag.setCellValueFactory(new PropertyValueFactory<>("tp"));

        tblPedidos.setItems(listaPedConc);

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        ObservableList<listaPedidos> listaPed = FXCollections.observableArrayList(EncomendaBLL.readAll());

        descricao.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        estado.setCellValueFactory(new PropertyValueFactory<>("encomendaestados"));
        nPedido.setCellValueFactory(new PropertyValueFactory<>("id_encomenda"));
        nCliente.setCellValueFactory(new PropertyValueFactory<>("id_cliente"));
        noEstafeta.setCellValueFactory(new PropertyValueFactory<>("id_estafeta"));
        valor.setCellValueFactory(new PropertyValueFactory<>("precodose"));
        data.setCellValueFactory(new PropertyValueFactory<>("data"));
        Qtd.setCellValueFactory(new PropertyValueFactory<>("qtd"));
        tipoPag.setCellValueFactory(new PropertyValueFactory<>("tp"));

        tblPedidos.setItems(listaPed);


    }

}
