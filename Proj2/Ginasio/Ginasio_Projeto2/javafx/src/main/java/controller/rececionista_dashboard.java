package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class rececionista_dashboard {
    @FXML
    private Button inst_dash_alt;

    @FXML
    protected void onActionAlterar(ActionEvent event) throws IOException {
        //DONE Abrir instrutor_info
        try{
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(new File("../Ginasio_Projeto2/javafx/src/main/resources/com/example/javafx/instrutor_info.fxml").toURI().toURL());
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Perfil");
        stage.setScene(scene);
        stage.show();

        Node source = (Node) event.getSource();
        Stage stageAtual = (Stage) source.getScene().getWindow();
        stageAtual.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void onActionMaisInfoPlano(ActionEvent event) throws IOException {
        //DONE Abrir instrutor_planos
        try{
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(new File("../Ginasio_Projeto2/javafx/src/main/resources/com/example/javafx/instrutor_planos.fxml").toURI().toURL());
            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            stage.setTitle("instrutor_planos de Treino");
            stage.setScene(scene);
            stage.show();

            Node source = (Node) event.getSource();
            Stage stageAtual = (Stage) source.getScene().getWindow();
            stageAtual.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void onActionMaisInfoAula(ActionEvent event) throws IOException {
        //DONE Abrir instrutor_aulas
        try{
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(new File("../Ginasio_Projeto2/javafx/src/main/resources/com/example/javafx/instrutor_aulas.fxml").toURI().toURL());
            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            stage.setTitle("instrutor_aulas de Grupo");
            stage.setScene(scene);
            stage.show();

            Node source = (Node) event.getSource();
            Stage stageAtual = (Stage) source.getScene().getWindow();
            stageAtual.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}