package com.example.javafx.Instrutor;

        import com.example.javafx.HelloApplication;
        import javafx.event.ActionEvent;
        import javafx.fxml.FXML;
        import javafx.fxml.FXMLLoader;
        import javafx.scene.Node;
        import javafx.scene.Scene;
        import javafx.scene.control.Button;
        import javafx.scene.control.Label;
        import javafx.stage.Stage;

        import java.io.File;
        import java.io.IOException;

public class Dashboard {
    @FXML
    private Button inst_dash_alt;

    @FXML
    protected void onActionAlterar(ActionEvent event) throws IOException {
        //DONE Abrir Info
        try{
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(new File("C:\\Users\\sofia\\Documents\\_escola\\_este_ano\\2_2_6_Proj2\\GestaoGym\\Proj2\\Ginasio\\javafx\\src\\main\\resources\\com\\example\\javafx\\instrutor_info.fxml").toURI().toURL());
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

    @FXML
    protected void onActionMaisInfoPlano(ActionEvent event) throws IOException {
        //DONE Abrir Planos
        try{
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(new File("C:\\Users\\sofia\\Documents\\_escola\\_este_ano\\2_2_6_Proj2\\GestaoGym\\Proj2\\Ginasio\\javafx\\src\\main\\resources\\com\\example\\javafx\\instrutor_planos.fxml").toURI().toURL());
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

    @FXML
    protected void onActionMaisInfoAula(ActionEvent event) throws IOException {
        //DONE Abrir Aulas
        try{
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(new File("C:\\Users\\sofia\\Documents\\_escola\\_este_ano\\2_2_6_Proj2\\GestaoGym\\Proj2\\Ginasio\\javafx\\src\\main\\resources\\com\\example\\javafx\\instrutor_aulas.fxml").toURI().toURL());
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