package com.example.fx.controllerCozinheiro;

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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class  ementaCozinheiro implements Initializable {
    ObservableList<Pratos> listaPratosCoz = FXCollections.observableArrayList(PratoBLL.readAll(true));


    @FXML
    private TableView<Pratos> tblEmentaCoz;

    @FXML
    private Button btnEditarCoz;

    @FXML
    private TextField edStockCoz;
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
    void desc(ActionEvent event) {

    }


    @FXML
    void edStock(ActionEvent event) {

    }
    @FXML
    void handleBtnAtualizar(ActionEvent event) throws IOException {



        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(loginController.class.getResource("cozinheiro/ementa.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1025 , 641);
        stage.setScene(scene);
        stage.show();

        Node source = (Node)  event.getSource();
        Stage stageAtual  = (Stage) source.getScene().getWindow();
        stageAtual.close();


    }

    @FXML
    void handleBtnEditarCoz(ActionEvent event) {
       Pratos pratos = tblEmentaCoz.getSelectionModel().getSelectedItem();
       tblEmentaCoz.getItems();
       int id = pratos.getStockdoses();
       pratos.setStockdoses(Integer.parseInt(edStockCoz.getText()));
       PratoBLL.update(pratos);
       tblEmentaCoz.setItems(listaPratosCoz);
    }

    @FXML
    void handleBtnVoltar(ActionEvent event) throws IOException {

            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(loginController.class.getResource("cozinheiro/painelcozi.fxml"));
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        descricao.setCellValueFactory(new PropertyValueFactory<Pratos,String>("descricao"));
        stock.setCellValueFactory(new PropertyValueFactory<Pratos,Float>("stockdoses"));
        valor.setCellValueFactory(new PropertyValueFactory<Pratos,Float>("precoatual"));
        tblEmentaCoz.setItems(listaPratosCoz);

    }

    public void edStockCoz(ActionEvent actionEvent) {

    }
}
