package controller;

        import javafx.event.ActionEvent;
        import javafx.fxml.FXML;
        import javafx.fxml.FXMLLoader;
        import javafx.scene.Node;
        import javafx.scene.Scene;
        import javafx.scene.control.Label;
        import javafx.stage.Stage;

        import java.io.File;

public class Info {
    @FXML
    protected void onActionAnterior(ActionEvent event) {
        //DONE abrir Dashboard
        try{
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(new File("../Ginasio_Projeto2/javafx/src/main/resources/com/example/javafx/instrutor_dashboard.fxml").toURI().toURL());
            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            stage.setTitle("Dashboard");
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
    protected void onActionGuardar(ActionEvent event) {
        //DONE abrir Dashboard
        //TODO guardar informacao
        try{
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(new File("../Ginasio_Projeto2/javafx/src/main/resources/com/example/javafx/instrutor_dashboard.fxml").toURI().toURL());
            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            stage.setTitle("Dashboard");
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