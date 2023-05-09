package com.example.javafx.Instrutor;

        import javafx.event.ActionEvent;
        import javafx.fxml.FXML;
        import javafx.fxml.FXMLLoader;
        import javafx.scene.Node;
        import javafx.scene.Scene;
        import javafx.scene.control.Label;
        import javafx.stage.Stage;

        import java.io.File;

public class Aulas {

    @FXML
    protected void onActionAnterior(ActionEvent event) {
        //DONE Abrir Dashboard
        try{
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(new File("C:\\Users\\sofia\\Documents\\_escola\\_este_ano\\2_2_6_Proj2\\GestaoGym\\Proj2\\Ginasio\\javafx\\src\\main\\resources\\com\\example\\javafx\\instrutor_dashboard.fxml").toURI().toURL());
            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            stage.setScene(scene);
            stage.show();

            Node source = (Node) event.getSource();
            Stage stageAtual = (Stage) source.getScene().getWindow();
            stageAtual.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void onActionConfirmar(ActionEvent event) {
        //DONE abrir Dashboard
        //TODO guardar informacao
        try{
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(new File("C:\\Users\\sofia\\Documents\\_escola\\_este_ano\\2_2_6_Proj2\\GestaoGym\\Proj2\\Ginasio\\javafx\\src\\main\\resources\\com\\example\\javafx\\instrutor_dashboard.fxml").toURI().toURL());
            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
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