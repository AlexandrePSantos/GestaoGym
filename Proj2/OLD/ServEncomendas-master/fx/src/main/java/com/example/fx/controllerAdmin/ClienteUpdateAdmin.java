package com.example.fx.controllerAdmin;

import com.bd.BLL.ClienteBLL;
import com.bd.BLL.UsersBLL;
import com.bd.DAL.Clientes;
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
import java.util.ResourceBundle;

public class ClienteUpdateAdmin implements Initializable {


    ObservableList<Clientes> listaCl = FXCollections.observableArrayList(ClienteBLL.readAllEstli(true));

    @FXML
    private Button btnEditarCl;

    @FXML
    private Button btnPesquisar;

    @FXML
    private Button btnVoltarEs;


    @FXML
    private TableColumn<Clientes,String> codigopostal;

    @FXML
    private TableColumn<Clientes, Number> id;

    @FXML
    private TableColumn<Clientes, String> morada;

    @FXML
    private TableColumn<Clientes, String> nome;

    @FXML
    private TableColumn<Clientes, Number> nif;

    @FXML
    private TableColumn<Clientes,String> telefone;

    @FXML
    private TextField nomeed;

    @FXML
    private TableView<Clientes> tblClienteEd;



    @FXML
    private TextField telefoneed;

    @FXML
    private TextField moradaed;

    @FXML
    void handleBtnEditarCl(ActionEvent event) {
        Clientes cl = tblClienteEd.getSelectionModel().getSelectedItem();
        cl.setNome(nomeed.getText());
        cl.setNumtelemovel(telefoneed.getText());
        cl.setRua(moradaed.getText());
        ClienteBLL.update(cl);
        tblClienteEd.setItems(listaCl);


        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Cliente");
        alert.setHeaderText("Editado  com sucesso!");
        alert.show();

    }

    @FXML
    void handleBtnPesquisar(ActionEvent event) {

    }

    @FXML
    void handleBtnVoltarEs(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(loginController.class.getResource("Admin/clientesAdmin.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 960 , 600);
        stage.setScene(scene);
        stage.show();

        Node source = (Node)  event.getSource();
        Stage stageAtual  = (Stage) source.getScene().getWindow();
        stageAtual.close();

    }

    @FXML
    void nomed(ActionEvent event) {

    }

    @FXML
    void telefoneed(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        id.setCellValueFactory(new PropertyValueFactory<Clientes,Number>("IdCliente"));
        nome.setCellValueFactory(new PropertyValueFactory<Clientes,String>("nome"));
        morada.setCellValueFactory(new PropertyValueFactory<Clientes,String>("rua"));
        codigopostal.setCellValueFactory(new PropertyValueFactory<Clientes,String>("codpostal"));
        telefone.setCellValueFactory(new PropertyValueFactory<Clientes,String>("numtelemovel"));
        nif.setCellValueFactory(new PropertyValueFactory<Clientes,Number>("nif"));
        tblClienteEd.setItems(listaCl);
    }


    public boolean isInputValid(){


        String errorMessage = "";

        if (nome.getText().isEmpty() || nomeed.getText().length() == 0) {
            errorMessage += "Nome inválido!\n";
        }

        if (moradaed.getText() == null || moradaed.getText().length() == 0) {
            errorMessage += "Morada iniválida!\n";
        }
        if (telefoneed.getText() == null ||telefoneed.getText().length() == 0) {
            errorMessage += "Telefone inválida!\n";
        }

        /*Verifica se ja existe um telefone*/
        if(ClienteBLL.TelefoneRepetidoCliente(telefoneed.getText())){
            errorMessage += "Telefone já existe!\n";
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


    public void moradaed(ActionEvent actionEvent) {
    }
}
