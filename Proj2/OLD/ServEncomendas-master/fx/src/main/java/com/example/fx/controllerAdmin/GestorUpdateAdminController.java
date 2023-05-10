package com.example.fx.controllerAdmin;

import com.bd.BLL.PratoBLL;
import com.bd.BLL.UsersBLL;
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
import java.net.URL;
import java.util.ResourceBundle;

public class GestorUpdateAdminController implements Initializable {
    ObservableList<Users> listaUser = FXCollections.observableArrayList(UsersBLL.readAllGesAti(true,true));

    @FXML
    private Button btnEditar;

    @FXML
    private Button btnPesquisar;

    @FXML
    private Button btnVoltarEs;

    @FXML
    private TableView<Users> tblGestor;

    @FXML
    private TableColumn<Users, String> email;

    @FXML
    private TableColumn<Users, String> username;

    @FXML
    private TableColumn<Users, String> password;


    @FXML
    private TextField usernameed;

    @FXML
    private TextField passworded;

    @FXML
    private TableView<Users> tblGestored;


    @FXML
    void handleBtnEditar(ActionEvent event) {
       Users ges = tblGestored.getSelectionModel().getSelectedItem();
       ges.setNomeuser(usernameed.getText());
       ges.setPassword(passworded.getText());
       UsersBLL.update(ges);
       tblGestored.setItems(listaUser);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Gestor");
        alert.setHeaderText("Editado  com sucesso!");
        alert.show();
    }

    @FXML
    void handleBtnPesquisar(ActionEvent event) {

    }

    @FXML
    void handleBtnVoltarEs(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(loginController.class.getResource("Admin/gestorAdmin.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 960 , 600);
        stage.setScene(scene);
        stage.show();

        Node source = (Node)  event.getSource();
        Stage stageAtual  = (Stage) source.getScene().getWindow();
        stageAtual.close();


    }

    @FXML
    void nome(ActionEvent event) {

    }

    @FXML
    void password(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

            //UsersBLL users = new UsersBLL();
            username.setCellValueFactory(new PropertyValueFactory<Users,String>("nomeuser"));
            email.setCellValueFactory(new PropertyValueFactory<Users,String>("email"));
            password.setCellValueFactory(new PropertyValueFactory<Users,String>("password"));
            tblGestored.setItems(listaUser);

    }

    public void usernameed(ActionEvent actionEvent) {
    }

    public void passworded(ActionEvent actionEvent) {
    }
}
