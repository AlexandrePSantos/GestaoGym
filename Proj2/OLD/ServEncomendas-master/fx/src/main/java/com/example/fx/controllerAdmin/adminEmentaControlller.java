package com.example.fx.controllerAdmin;


import com.bd.BLL.ClienteBLL;
import com.bd.BLL.PratoBLL;

import com.bd.BLL.UsersBLL;
import com.bd.DAL.Clientes;
import com.bd.DAL.Pratos;
import com.bd.DAL.Users;
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
import java.math.BigInteger;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class adminEmentaControlller implements Initializable {


    ObservableList<Pratos> listaPratos = FXCollections.observableArrayList(PratoBLL.readAll(true));


    @FXML
    private Button btnEditar;

    @FXML
    private Button btnLogout;


    @FXML
    private Button btnCriar;

    @FXML
    private Button btnPesquisar;

    @FXML
    private Button btnRemover;

    @FXML
    private Button btnVoltarEs;

    @FXML
    private Button btnAtualizar;


    @FXML
    private TableColumn<Pratos, String > descricao;

    @FXML
    private TableColumn<Pratos, Float> stock;

    @FXML
    private TableColumn<Pratos, Float> valor;
    @FXML
    private TextField pNome;

    @FXML
    void desc(ActionEvent event) {

    }

    @FXML
    void handleBtnEditar(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(loginController.class.getResource("Admin/ementaEditarAdmin.fxml"));
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
        Scene scene = new Scene(fxmlLoader.load(), 960, 600);
        stage.setScene(scene);
        stage.show();

        Node source = (Node) event.getSource();
        Stage stageAtual = (Stage) source.getScene().getWindow();
        stageAtual.close();
    }

    @FXML
    void handleBtnCriar(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(loginController.class.getResource("Admin/ementaRegistoAdmin.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 668 , 407);
        stage.setScene(scene);
        stage.show();

        Node source = (Node)  event.getSource();
        Stage stageAtual  = (Stage) source.getScene().getWindow();
        stageAtual.close();

    }

    @FXML
    void handleBtnPesquisar(ActionEvent event) {
        if (pNome  .getText().length() == 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Campos inválidos");
            alert.setHeaderText("Insira um Nome para iniciar a filtragem!");
            alert.showAndWait();

        }

        int ids = PratoBLL.readByNome(pNome.getText());
        ObservableList<Pratos> listaPratos = FXCollections.observableArrayList(PratoBLL.read(ids));

        descricao.setCellValueFactory(new PropertyValueFactory<Pratos, String>("descricao"));
        stock.setCellValueFactory(new PropertyValueFactory<Pratos, Float>("stockdoses"));
        valor.setCellValueFactory(new PropertyValueFactory<Pratos, Float>("precoatual"));
        tblEmenta.setItems(listaPratos);

    }

    /*
    **  Remover os dados da ementa.
     */
    @FXML
    void handleBtnRemover(ActionEvent event) {
        Pratos pratos = tblEmenta.getSelectionModel().getSelectedItem();
        tblEmenta.getItems();
        int id = pratos.getIdPrato();
        pratos.setEstado(false);
        PratoBLL.update(pratos);


        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Ementa");
        alert.setHeaderText("Prato eliminado com sucesso");
        alert.setContentText("Atualize a página");
        alert.show();

    }


    @FXML
    void handleBtnAtualizar(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(loginController.class.getResource("Admin/ementaAdmin.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 960 , 600);
        stage.setScene(scene);
        stage.show();

        Node source = (Node)  event.getSource();
        Stage stageAtual  = (Stage) source.getScene().getWindow();
        stageAtual.close();

    }

    @FXML
    private TableView<Pratos> tblEmenta;


    @FXML
    void handleBtnVoltarEs(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(loginController.class.getResource("Admin/paginaprincipaladmin.fxml"));
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
         descricao.setCellValueFactory(new PropertyValueFactory<Pratos,String>("descricao"));
         stock.setCellValueFactory(new PropertyValueFactory<Pratos,Float>("stockdoses"));
         valor.setCellValueFactory(new PropertyValueFactory<Pratos,Float>("precoatual"));
         tblEmenta.setItems(listaPratos);

    }


}
