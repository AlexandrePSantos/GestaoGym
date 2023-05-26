package com.example.fx.controllerAdmin;

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

public class Adminestafetaeliminados implements Initializable {

     ObservableList<Estafetas> listaEst = FXCollections.observableArrayList(EstafetaBLL.readAllEsta(false));
    //ObservableList<Estafeta> listaEst = FXCollections.observableArrayList(EstafetaBLL.readAllEst(false));

    @FXML
    private Button btnReativar;

    @FXML
    private Button btnListEstafeta;

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
    private TableView<Estafetas> tblEstafetaEli;



    @FXML
    void handleBtnReativar(ActionEvent event) {

/*
        Estafetas estaf =  tblEstafetaEli.getSelectionModel().getSelectedItem();
        tblEstafetaEli.getItems();
        int idEstafeta = estaf.getId_estafeta();
        estaf.setEstado(true);
       // estaf.setEstadous(true);
        EstafetaBLL.updateEstado(estaf);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Estafeta");
        alert.setHeaderText("Estafeta reativado com sucesso");
        alert.setContentText("Volte para a página do estafeta");
        alert.show();

 */
    }

    @FXML
    void handleBtnlistEstafeta(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(loginController.class.getResource("Admin/estafetasAdmin.fxml"));
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
        email.setCellValueFactory(new PropertyValueFactory<Estafetas, String>("email"));
        password.setCellValueFactory(new PropertyValueFactory<Estafetas, String>("password"));
        nif.setCellValueFactory(new PropertyValueFactory<Estafetas, Number>("nif"));
        telefone.setCellValueFactory(new PropertyValueFactory<Estafetas, String>("numtelefone"));
        tblEstafetaEli.setItems(listaEst);


    }
}
