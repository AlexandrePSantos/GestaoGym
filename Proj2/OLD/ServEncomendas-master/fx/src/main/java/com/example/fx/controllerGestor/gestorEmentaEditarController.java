package com.example.fx.controllerGestor;

import com.bd.BLL.PratoBLL;
import com.bd.DAL.Pratos;
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
import java.util.ResourceBundle;

public class gestorEmentaEditarController implements Initializable {


    //private List<Pratos> pList = PratoBLL.readAll();
    ObservableList<Pratos> listaPratos = FXCollections.observableArrayList(PratoBLL.readAll(true));

    @FXML
    private Button btnEditar;

    @FXML
    private Button btnPesquisar;



    @FXML
    private Button btnSalvar;

    @FXML
    private Button btnVoltarEs;

    @FXML
    private TextField edPreco;

    @FXML
    private TextField edStock;



    @FXML
    private TableColumn<Pratos, String > descricao;

    @FXML
    private TableColumn<Pratos, Integer> stock;

    @FXML
    private TableColumn<Pratos, Float> valor;

    @FXML
    void desc(ActionEvent event) {

    }
    @FXML
    void edPreco(ActionEvent event) {

    }

    @FXML
    void edDesc(ActionEvent event) {

    }


    @FXML
    void edStock(ActionEvent event) {

    }

    @FXML
    void handleBtnEditar(ActionEvent event) {


    }


    @FXML
    void handleBtnSalvar(ActionEvent event) {
        Pratos pra = tblEmenta.getSelectionModel().getSelectedItem();

        pra.setPrecoatual(Float.parseFloat(edPreco.getText()));
        pra.setStockdoses(Integer.parseInt(edStock.getText()));
        PratoBLL.update(pra);
        tblEmenta.setItems(listaPratos);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Ementa");
        alert.setHeaderText("Editado  com sucesso!");
        alert.show();
    }


    @FXML
    void handleBtnPesquisar(ActionEvent event) {


    }

    /*
     **  Remover os dados da ementa.
     */

    @FXML
    private TableView<Pratos> tblEmenta;


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

    @FXML
    void stock(ActionEvent event) {

    }

    @FXML
    void valor(ActionEvent event) {

    }
    /*
     ** Listar os dados ao abrir a pagina
     */


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //  ObservableList<Pratos> listaPratos = FXCollections.observableArrayList(PratoBLL.readAll());
        //UsersBLL users = new UsersBLL();
        descricao.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        stock.setCellValueFactory(new PropertyValueFactory<>("stockdoses"));
        valor.setCellValueFactory(new PropertyValueFactory<>("precoatual"));
        tblEmenta.setItems(listaPratos);

    }
}
