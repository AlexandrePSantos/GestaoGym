package com.example.fx.controllerEstafeta;

import com.bd.DAL.Clientes;
import com.bd.BLL.ClienteBLL;
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
import java.util.List;
import java.util.ResourceBundle;

public class clientesEstafetasController implements Initializable {

    ObservableList<Clientes> listaClnome =  FXCollections.observableArrayList(ClienteBLL.readAll());;

    @FXML
    private Button btnLogout;

    @FXML
    private Button btnPesquisar;

    @FXML
    private Button btnVoltarEs;


    @FXML
    private TextField txtSearch;


    @FXML
    private TableColumn<Clientes, String> morada;

    @FXML
    private TableColumn<Clientes, String> nome;

    @FXML
    private TableColumn<Clientes, String> telefone;
    @FXML
    public TableView<Clientes> tblClEstafeta ;




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
    void handleBtnPesquisar(ActionEvent event ) {
/*
   if (txtSearch.getText().equals(""))
        tblClEstafeta.getItems().clear();
        ListCl(ClienteBLL.readAll());

          else {

            ObservableList<Clientes> cl=  FXCollections.observableArrayList(ClienteBLL.readAll(""));;

            for (Clientes cls : ClienteBLL.readAll()){
                if(cls.getNome().equals(txtSearch.getText()) )
                cl.add(cls);

            }
        }

    }


 */
    /*

                List<Clientes> clientes = new ArrayList();

                switch (Clientes.getValue()) {

                    case "Nome":
                      clientes = ClienteBLL.readAll(txtSearch.getText());
                        break;
                    case "E-mail":
                        clientes = ClienteBLL.readAll(txtSearch.getText());
                        break;

                    default:
                        break;
                }

                loadPerson(people);
            }

*/

    }
    @FXML
    void handleBtnVoltarEs(ActionEvent event) throws IOException {
        Node  source = (Node)  event.getSource();
        Stage stageAtual  = (Stage) source.getScene().getWindow();
        stageAtual.close();

    }

    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<Clientes> listaClEst =  FXCollections.observableArrayList(ClienteBLL.readAll());

        nome.setCellValueFactory(new PropertyValueFactory<Clientes,String>("nome"));
        telefone.setCellValueFactory(new PropertyValueFactory<Clientes,String>("numtelemovel"));
        morada.setCellValueFactory(new PropertyValueFactory<Clientes, String>("rua"));
        tblClEstafeta.setItems(listaClEst);
        }


    private void ListCl( List<Clientes> listOfName) {




        }

    }

