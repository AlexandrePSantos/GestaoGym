package controller;

import javafx.event.ActionEvent;
        import javafx.fxml.FXML;
        import javafx.fxml.FXMLLoader;
        import javafx.scene.Node;
        import javafx.scene.Scene;
        import javafx.scene.control.Button;
        import javafx.scene.control.TableView;
        import javafx.scene.image.ImageView;
        import javafx.scene.input.MouseEvent;
        import javafx.stage.Stage;

        import java.io.File;
        import java.io.IOException;

public class instrutor_dashboard {
    @FXML
    public ImageView exit;
    public TableView planeado;
    public TableView realizado;
    @FXML
    private Button inst_dash_alt;

    @FXML
    protected void onActionAlterar(ActionEvent event) throws IOException {
        //DONE Abrir instrutor_info
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(new File("../Ginasio_Projeto2/javafx/src/main/resources/com/example/javafx/instrutor_info.fxml").toURI().toURL());
        Scene scene = new Scene(fxmlLoader.load(), 1366, 768);
        stage.setTitle("Instrutor: Perfil");
        stage.setScene(scene);
        stage.show();

        Node source = (Node) event.getSource();
        Stage stageAtual = (Stage) source.getScene().getWindow();
        stageAtual.close();
    }

    @FXML
    protected void onActionMaisInfoPlano(ActionEvent event) throws IOException {
        //DONE Abrir instrutor_planos
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(new File("../Ginasio_Projeto2/javafx/src/main/resources/com/example/javafx/instrutor_planos.fxml").toURI().toURL());
        Scene scene = new Scene(fxmlLoader.load(), 1366, 768);
        stage.setTitle("Instrutor: Planos de Treino");
        stage.setScene(scene);
        stage.show();

        Node source = (Node) event.getSource();
        Stage stageAtual = (Stage) source.getScene().getWindow();
        stageAtual.close();
    }

    @FXML
    protected void onActionMaisInfoAula(ActionEvent event) throws IOException {
        //DONE Abrir instrutor_aulas
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(new File("../Ginasio_Projeto2/javafx/src/main/resources/com/example/javafx/instrutor_aulas.fxml").toURI().toURL());
        Scene scene = new Scene(fxmlLoader.load(), 1366, 768);
        stage.setTitle("Instrutor: Aulas de Grupo");
        stage.setScene(scene);
        stage.show();

        Node source = (Node) event.getSource();
        Stage stageAtual = (Stage) source.getScene().getWindow();
        stageAtual.close();
    }

    @FXML
    protected void onActionExit(MouseEvent event) throws IOException {
        //DONE Abrir instrutor_aulas
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