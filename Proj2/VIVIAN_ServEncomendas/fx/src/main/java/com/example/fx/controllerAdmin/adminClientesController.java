package com.example.fx.controllerAdmin;


import com.bd.BLL.ClienteBLL;
import com.bd.BLL.EncomendaBLL;
import com.bd.BLL.EstafetaBLL;
import com.bd.DAL.Clientes;
import com.bd.DAL.listaPedidos;
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
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.math.BigInteger;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class adminClientesController implements Initializable {

    public int selectID;

    private List <Clientes>  clisteList = ClienteBLL.readAll();

   ObservableList<Clientes> listaCl = FXCollections.observableArrayList(ClienteBLL.readAllEstli(true));

    @FXML
    private TableColumn<TableClientAdmin, String> Encomendas;

    @FXML
    private Button btnEditarCl;

    @FXML
    private Button btnLogout;

    @FXML
    private Button btnPesquisar;

    @FXML
    private Button btnRemoverCl;

    @FXML
    private Button btnVoltarEs;

    @FXML
    private Button btncriarCl;
    @FXML
    private Button btnListaEliminados;


    @FXML
    private Button btnAtualizar;


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
    private TableView<Clientes> tblCliente;

    @FXML
    private TextField clNome;

    /**
     * REMOVER
     * @param event
     */
    @FXML
    void clhandleBtnRemover(ActionEvent event) {
        Clientes clientes = tblCliente.getSelectionModel().getSelectedItem();
        tblCliente.getItems();
        int id = clientes.getIdCliente();
        clientes.setEstado(false);
        ClienteBLL.update(clientes);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Cliente");
        alert.setHeaderText("Cliente eliminado com sucesso");
        alert.setContentText("Atualize a página");
        alert.show();

    }

    @FXML
    void handleBtnAtualizar(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(loginController.class.getResource("Admin/clientesAdmin.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 960 , 600);
        stage.setScene(scene);
        stage.show();

        Node source = (Node)  event.getSource();
        Stage stageAtual  = (Stage) source.getScene().getWindow();
        stageAtual.close();

    }

    /**
     * Pagina para criar
     * @param event
     * @throws IOException
     */
    @FXML
    void handleBtnCriarCl(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(loginController.class.getResource("Admin/clienteregistoAdmin.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 960 , 600);
        stage.setScene(scene);
        stage.show();

        Node source = (Node)  event.getSource();
        Stage stageAtual  = (Stage) source.getScene().getWindow();
        stageAtual.close();
    }



    @FXML
    void handlebtnListaEliminados(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(loginController.class.getResource("Admin/clienteseliminadosAdmin.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 960 , 600);
        stage.setScene(scene);
        stage.show();

        Node source = (Node)  event.getSource();
        Stage stageAtual  = (Stage) source.getScene().getWindow();
        stageAtual.close();
    }
    @FXML
    void handleBtnEditarCl(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(loginController.class.getResource("Admin/clienteUpdateAdmin.fxml"));
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
    void handleBtnPesquisar(ActionEvent event) {

            if (clNome.getText().length() == 0) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Campos inválidos");
                alert.setHeaderText("Insira um Nome para iniciar a filtragem!");
                alert.showAndWait();

            }

            int ids  = ClienteBLL.readByNome(clNome.getText());
            ObservableList<Clientes> listaCl = FXCollections.observableArrayList(ClienteBLL.read(ids));

            id.setCellValueFactory(new PropertyValueFactory<Clientes,Number>("IdCliente"));
            nome.setCellValueFactory(new PropertyValueFactory<Clientes,String>("nome"));
            morada.setCellValueFactory(new PropertyValueFactory<Clientes,String>("rua"));
            codigopostal.setCellValueFactory(new PropertyValueFactory<Clientes,String>("codpostal"));
            telefone.setCellValueFactory(new PropertyValueFactory<Clientes,String>("numtelemovel"));
            nif.setCellValueFactory(new PropertyValueFactory<Clientes,Number>("nif"));
            tblCliente.setItems(listaCl);
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
    @FXML
    public void handleBtnVerEncomendas(ActionEvent event) throws IOException {

            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(loginController.class.getResource("Admin/listarEncomendasCliente.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 960, 600);
            stage.setScene(scene);
            stage.show();
       //     ListarEncomendasCliente listarEncomendasCliente = fxmlLoader.getController();
       //     listarEncomendasCliente.selectID = tblCliente.getSelectionModel().getSelectedItem().getIdCliente();
            Node source = (Node) event.getSource();
            Stage stageAtual = (Stage) source.getScene().getWindow();
            stageAtual.close();

    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        /**Listar**/

        id.setCellValueFactory(new PropertyValueFactory<Clientes,Number>("IdCliente"));
        nome.setCellValueFactory(new PropertyValueFactory<Clientes,String>("nome"));
        morada.setCellValueFactory(new PropertyValueFactory<Clientes,String>("rua"));
        codigopostal.setCellValueFactory(new PropertyValueFactory<Clientes,String>("codpostal"));
        telefone.setCellValueFactory(new PropertyValueFactory<Clientes,String>("numtelemovel"));
        nif.setCellValueFactory(new PropertyValueFactory<Clientes,Number>("nif"));
        tblCliente.setItems(listaCl);

   }


}


