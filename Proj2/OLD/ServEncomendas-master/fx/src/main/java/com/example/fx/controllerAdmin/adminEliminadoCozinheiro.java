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

public class adminEliminadoCozinheiro implements Initializable {

    ObservableList<Users> listaUserEli = FXCollections.observableArrayList(UsersBLL.readAllCozDes(true,false));

    @FXML
    private Button btnListCozinheiro;

    @FXML
    private Button btnReativar;


    @FXML
    private TableColumn<Users, String> email;

    @FXML
    private TableColumn<Users, String> username;

    @FXML
    private TableColumn<Users, String> password;


    @FXML
    private TableView<Users> tblCozinheiroEli;

    @FXML
    void handleBtnListCozinheiro(ActionEvent event) throws IOException {


        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(loginController.class.getResource("Admin/cozinheiroAdmin.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 960 , 600);
        stage.setScene(scene);
        stage.show();

        Node source = (Node)  event.getSource();
        Stage stageAtual  = (Stage) source.getScene().getWindow();
        stageAtual.close();

    }
    /*Reativar cozinheiro*/

    @FXML
    void handleBtnReativar(ActionEvent event) {

        Users usersCoEli = tblCozinheiroEli.getSelectionModel().getSelectedItem();
        tblCozinheiroEli.getItems();
        BigInteger id = usersCoEli.getIdUser();
        usersCoEli.setEstado(true); //altera de falso para verdadeiro
        UsersBLL.update(usersCoEli); //altrar o estado

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Cozinheiro");
        alert.setHeaderText("Cozinheiro reativado com sucesso");
        alert.setContentText("Volte para a lista de cozinheiros");
        alert.show();

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        username.setCellValueFactory(new PropertyValueFactory<Users,String>("nomeuser"));
        email.setCellValueFactory(new PropertyValueFactory<Users,String>("email"));
        password.setCellValueFactory(new PropertyValueFactory<Users,String>("password"));
        tblCozinheiroEli.setItems(listaUserEli);
    }
}
