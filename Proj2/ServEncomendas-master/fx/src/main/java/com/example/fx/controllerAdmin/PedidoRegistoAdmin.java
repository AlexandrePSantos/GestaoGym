package com.example.fx.controllerAdmin;

import com.bd.BLL.*;
import com.bd.DAL.*;
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
import javafx.stage.Stage;

import javax.persistence.criteria.CriteriaBuilder;
import java.io.IOException;
import java.math.BigInteger;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class PedidoRegistoAdmin implements Initializable {


    ObservableList<Estadosencomenda> listaEncEst = FXCollections.observableArrayList(EstadosencomendaBLL.readAllMarcadas());


    ObservableList<Tipopagamentos> listTp = FXCollections.observableArrayList(TipoPagamentoBLL.readAll());

    ObservableList<Pratos> listaPratos = FXCollections.observableArrayList(PratoBLL.readAll(true));


    @FXML
    private Button btnRegistar;

    @FXML
    private Button btnVoltarEs;

    @FXML
    private TextField nif;

    @FXML
    private TextField emailEstafeta;


    @FXML
    private TextField quantidade;


    @FXML
    private TextField prTotal;


    @FXML
    void edPrato(ActionEvent event) {

    }

    @FXML
    private ComboBox<Pratos> tpPrato;
    @FXML
    private ComboBox<Estadosencomenda> tpEstado;

    @FXML
    private ComboBox<Tipopagamentos> tpPagamento;

    @FXML
    void editNif(ActionEvent event) {

    }

    @FXML
    void HandleTpEstado(ActionEvent event) {

    }

    @FXML
    void HandleTpPagamento(ActionEvent event) {

    }

    @FXML
    private TextField data;


    @FXML
    void emailEstafeta(ActionEvent event) {

    }

    @FXML
    void quantidade(ActionEvent event) {

    }

    @FXML
    void HandleTpPrato(ActionEvent event) {

    }


    @FXML
    void data(ActionEvent event) {

    }

    @FXML
    void handleBtnRegistar(ActionEvent event) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();


        Encomendas enc = new Encomendas();
        Clientes cl = new Clientes();
        Pratos pr = new Pratos();
        Estadosencomenda es = new Estadosencomenda();
        Tipopagamentos tp = new Tipopagamentos();
        Estafeta est = new Estafeta();
        PratosEncomendados pre = new PratosEncomendados();

        Encomendaestados encEst = new Encomendaestados();

        est = EstafetaBLL.readByEmail(emailEstafeta.getText());
        cl = ClienteBLL.readByNif(BigInteger.valueOf(Integer.parseInt(nif.getText())));
        int qtd = Integer.parseInt(quantidade.getText());
        int qtdAtual = tpPrato.getSelectionModel().getSelectedItem().getStockdoses();
        if (est != null && cl != null && qtdAtual>=qtd){
            enc.setIdEstafeta(est.getIdEstafeta());
            enc.setIdCliente(cl.getIdCliente());

        enc.setValortotal(Integer.parseInt(prTotal.getText()));
        enc.setTipopagamentoid(tpPagamento.getSelectionModel().getSelectedItem().getTipopagamentoid());
        EncomendaBLL.create(enc);
        pre.setIdPrato(tpPrato.getSelectionModel().getSelectedItem().getIdPrato());
        pre.setIdEncomenda(enc.getIdEncomenda());
        pre.setQtddoses(Integer.parseInt(quantidade.getText()));
        float preco = tpPrato.getSelectionModel().getSelectedItem().getPrecoatual();
        int preco2 = ((int) preco);
        pre.setPrecodose(preco2);
        pre.setEstado(true);

        PratosEncomendadosBLL.create(pre);


        encEst.setIdEncomenda(enc.getIdEncomenda());
        int estado = tpEstado.getSelectionModel().getSelectedItem().getIdEstadoencomenda();
        encEst.setIdEstadoencomenda(estado);
        encEst.setData(Date.valueOf(dtf.format(now)));

        EncomendaestadosBLL.create(encEst);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Registo");
            alert.setHeaderText("Registo efetuado com sucesso!");
            alert.show();
    } else {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Registo encomenda");
        alert.setHeaderText("Dados inválidos! Atenção à quantidade pedida ou verifique a disponibilidade do estafeta");
        alert.show();
    }


    }

    @FXML
    void handleBtnVoltarEs(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(loginController.class.getResource("Admin/pedidosAdmin.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 960, 600);
        stage.setScene(scene);
        stage.show();

        Node source = (Node) event.getSource();
        Stage stageAtual = (Stage) source.getScene().getWindow();
        stageAtual.close();

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tpPagamento.setItems(FXCollections.observableArrayList(listTp));
        tpEstado.setItems(FXCollections.observableArrayList(listaEncEst));
        tpPrato.setItems(FXCollections.observableArrayList(listaPratos));

    }


    public void prTotal(ActionEvent actionEvent) {
    }
}
