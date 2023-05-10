package com.example.fx.controllerGestor;

import com.bd.BLL.EstafetaBLL;
import com.bd.DAL.Estafeta;
import com.bd.DAL.Estafetas;
import com.example.fx.loginController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class gestorEstafetasController implements  Initializable {

    //private List<Estafeta> listEsta = EstafetaBLL.readAll();
    ObservableList<Estafetas> listaEsta =  FXCollections.observableArrayList(EstafetaBLL.readAllEsta(true));

    ObservableList<Estafeta> listaEs =  FXCollections.observableArrayList(EstafetaBLL.readAll());


    @FXML
    private Button btnEditar;

    @FXML
    private Button btnNew;

    @FXML
    private Button btnUpdate;

    @FXML
    private Button btnPesquisar;


    @FXML
    private Button btnVoltarEs;


    @FXML
    private TableColumn<Estafetas, String> email;

    @FXML
    private TableColumn<Estafetas, Number> nif;

    @FXML
    private TableColumn<Estafetas, String> nome;

    @FXML
    private TableColumn<Estafetas, String> password;

    @FXML
    private TableColumn<Estafetas, String> telefone;

    @FXML
    private TableView<Estafetas> tblEstafeta;

    @FXML
    private TableView<Estafeta> tblEstadfeta;

    @FXML
    void handleBtnEditar(ActionEvent event) {


    }


    @FXML
    void handleBtnNew(ActionEvent event) throws IOException {
        Stage stage = new Stage();
       FXMLLoader fxmlLoader = new FXMLLoader(loginController.class.getResource("gestor/estafetaregistoGestor.fxml"));
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

    private List<Estafeta> clisteList = EstafetaBLL.readAll();





    @FXML
    void handleBtnUpdate(ActionEvent event) throws IOException {
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
    void handleBtnVoltarEs(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(loginController.class.getResource("Gestor/painelGestor.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 960 , 600);
        stage.setScene(scene);
        stage.show();

        Node source = (Node)  event.getSource();
        Stage stageAtual  = (Stage) source.getScene().getWindow();
        stageAtual.close();

    }




    @Override
    public void initialize(URL location, ResourceBundle resources) {


        nome.setCellValueFactory(new PropertyValueFactory<Estafetas, String>("nome"));
        email.setCellValueFactory(new PropertyValueFactory<Estafetas, String>("emailEst"));
        password.setCellValueFactory(new PropertyValueFactory<Estafetas, String>("password"));
        nif.setCellValueFactory(new PropertyValueFactory<Estafetas, Number>("nif"));
        telefone.setCellValueFactory(new PropertyValueFactory<Estafetas, String>("telefone"));
        tblEstafeta.setItems(listaEsta);

    }
}
