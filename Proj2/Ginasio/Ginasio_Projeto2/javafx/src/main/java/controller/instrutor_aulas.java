package controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import com.AcessoBD.BLL.AulasBLL;
import com.AcessoBD.repository.entities.Aulagrupo;

import java.io.File;
import java.io.IOException;

public class instrutor_aulas {
    private AulasBLL aulasBLL = new AulasBLL();
    @FXML
    private TableView<Aulagrupo> aulasRealizadasTable;
    @FXML
    private TableView<Aulagrupo> aulasPlaneadasTable;

    @FXML
    private void initialize() {
        // Call the getAulasRealizadas method and populate the aulasRealizadasTable
        aulasRealizadasTable.setItems((ObservableList<Aulagrupo>) aulasBLL.getAulasRealizadas());
        // Call the getAulasPlaneadas method and populate the aulasPlaneadasTable
        aulasPlaneadasTable.setItems((ObservableList<Aulagrupo>) aulasBLL.getAulasPlaneadas());
    }

    @FXML
    protected void onActionAnterior(ActionEvent event) throws IOException {
        //DONE Abrir instrutor_dashboard
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(new File("../Ginasio_Projeto2/javafx/src/main/resources/com/example/javafx/instrutor_dashboard.fxml").toURI().toURL());
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Instrutor: Dashboard");
        stage.setScene(scene);
        stage.show();

        Node source = (Node) event.getSource();
        Stage stageAtual = (Stage) source.getScene().getWindow();
        stageAtual.close();
    }

    @FXML
    protected void onActionConfirmar(ActionEvent event) throws IOException {
        //DONE abrir instrutor_dashboard
        //TODO guardar informacao
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(new File("../Ginasio_Projeto2/javafx/src/main/resources/com/example/javafx/instrutor_dashboard.fxml").toURI().toURL());
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Instrutor: Dashboard");
        stage.setScene(scene);
        stage.show();

        Node source = (Node) event.getSource();
        Stage stageAtual = (Stage) source.getScene().getWindow();
        stageAtual.close();
    }

    @FXML
    protected void exit(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(new File("../Ginasio_Projeto2/javafx/src/main/resources/com/example/javafx/_login.fxml").toURI().toURL());
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.show();

        Node source = (Node) event.getSource();
        Stage stageAtual = (Stage) source.getScene().getWindow();
        stageAtual.close();
    }
}