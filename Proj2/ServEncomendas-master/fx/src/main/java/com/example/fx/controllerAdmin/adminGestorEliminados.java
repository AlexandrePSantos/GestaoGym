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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.math.BigInteger;
import java.net.URL;
import java.util.ResourceBundle;

public class adminGestorEliminados  implements Initializable {
    ObservableList<Users> listaUsers = FXCollections.observableArrayList(UsersBLL.readAllGesDes(true, false));

    @FXML
    private Button btnLista;

    @FXML
    private Button btnReativar;

    @FXML
    private TableView<Users> tblGestorEli;

    @FXML
    private TableColumn<Users, String> email;

    @FXML
    private TableColumn<Users, String> username;

    @FXML
    private TableColumn<Users, String> password;

    @FXML
    void handleBtnLista(ActionEvent event) throws IOException {

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
    void handleBtnReativar(ActionEvent event) {
        Users users = tblGestorEli.getSelectionModel().getSelectedItem();
        tblGestorEli.getItems();
        BigInteger id_gestor = users.getIdUser();
        users.setEstado(true);
        UsersBLL.update(users);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Gestor");
        alert.setHeaderText("Gestor reativado com sucesso");
        alert.setContentText("Volte a página do Gestor");
        alert.show();


    }
         public void initialize(URL url, ResourceBundle rb) {
        //UsersBLL users = new UsersBLL();
        username.setCellValueFactory(new PropertyValueFactory<Users,String>("nomeuser"));
        email.setCellValueFactory(new PropertyValueFactory<Users,String>("email"));
        password.setCellValueFactory(new PropertyValueFactory<Users,String>("password"));
        tblGestorEli.setItems(listaUsers);
    }
}
