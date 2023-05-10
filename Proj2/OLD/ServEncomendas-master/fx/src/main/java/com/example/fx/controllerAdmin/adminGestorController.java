package com.example.fx.controllerAdmin;

import com.bd.BLL.UsersBLL;
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

public class adminGestorController implements Initializable {

   // ObservableList<Users> list =    FXCollections.observableArrayList();
   ObservableList<Users> listaUser = FXCollections.observableArrayList(UsersBLL.readAllGesAti(true,true));
    @FXML
    private Button btnEditar;

    @FXML
    private Button btnLogout;

    @FXML
    private Button btnNew;

    @FXML
    private Button btnPesquisar;

    @FXML
    private Button btnRemover;

    @FXML
    private Button btnVoltarEs;

    @FXML
    private Button btnAtualizarGestor;


    @FXML
    private Button btnListaEliminados;


    @FXML
    private TableView<Users> tblGestor;

    @FXML
    private TableColumn<Users, String> email;

    @FXML
    private TableColumn<Users, String> username;

    @FXML
    private TableColumn<Users, String> password;

    @FXML
    private TextField nGestor;

    @FXML
    void handleBtnEditar(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(loginController.class.getResource("Admin/gestorUpdateAdmin.fxml"));
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
    void handleBtnNew(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(loginController.class.getResource("Admin/gestorRegistoAdmin.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 668 , 407);
        stage.setScene(scene);
        stage.show();

        Node source = (Node)  event.getSource();
        Stage stageAtual  = (Stage) source.getScene().getWindow();
        stageAtual.close();


    }

    @FXML
    void handleBtnAtualizarGestor(ActionEvent event) throws IOException {
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
    void handleBtnListaEliminados(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(loginController.class.getResource("Admin/gestorEliminadosAdmin.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 960 , 600);
        stage.setScene(scene);
        stage.show();

        Node source = (Node)  event.getSource();
        Stage stageAtual  = (Stage) source.getScene().getWindow();
        stageAtual.close();

    }

    @FXML
    void handleBtnPesquisar(ActionEvent event) {
        if (nGestor.getText().length() == 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Campos inválidos");
            alert.setHeaderText("Insira um Nome para iniciar a filtragem!");
            alert.showAndWait();

        }

        BigInteger ids = UsersBLL.readByNomeGes(nGestor.getText(), true, true);
        ObservableList<Users> listaUser = FXCollections.observableArrayList(UsersBLL.read(ids));

        username.setCellValueFactory(new PropertyValueFactory<Users,String>("nomeuser"));
        email.setCellValueFactory(new PropertyValueFactory<Users,String>("email"));
        password.setCellValueFactory(new PropertyValueFactory<Users,String>("password"));
        tblGestor.setItems(listaUser);


    }

    @FXML
    void handleBtnRemover(ActionEvent event) {

        Users users = tblGestor.getSelectionModel().getSelectedItem();
        tblGestor.getItems();
        BigInteger id = users.getIdUser();
        users.setEstado(false); //alterar o estado de verdadeiro para false
        UsersBLL.update(users);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Gestor");
        alert.setHeaderText("Gestor removido com sucesso");
        alert.setContentText("Atualize a página");
        alert.show();

    }


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

    /**
     * Dados a serem listados do user Gestor
     * @param url
     * @param rb
     */

    public void initialize(URL url, ResourceBundle rb) {
        //UsersBLL users = new UsersBLL();
        username.setCellValueFactory(new PropertyValueFactory<Users,String>("nomeuser"));
        email.setCellValueFactory(new PropertyValueFactory<Users,String>("email"));
        password.setCellValueFactory(new PropertyValueFactory<Users,String>("password"));
        tblGestor.setItems(listaUser);
    }
}
