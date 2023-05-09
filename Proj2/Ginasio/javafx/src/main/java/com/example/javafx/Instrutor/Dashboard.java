package com.example.javafx.Instrutor;

        import com.example.javafx.HelloApplication;
        import javafx.fxml.FXML;
        import javafx.fxml.FXMLLoader;
        import javafx.scene.Scene;
        import javafx.scene.control.Button;
        import javafx.scene.control.Label;
        import javafx.stage.Stage;

        import java.io.IOException;

public class Dashboard {
    @FXML
    private Button inst_dash_alt;

    @FXML
    protected void onActionAlterar() throws IOException {
        //TODO Abrir Info
        // Load the FXML files
        FXMLLoader loader1 = new FXMLLoader(Dashboard.class.getResource("instrutor_info.fxml"));

        // Create Scene objects
        Scene scene1 = new Scene(loader1.load());

        // Get the reference to the Stage object from your FXML controller
        Stage stage = (Stage) inst_dash_alt.getScene().getWindow();

        // Switch to Scene 1
        stage.setScene(scene1);
    }

    @FXML
    protected void onActionMaisInfoPlano(){
        //TODO Abrir Planos
    }

    @FXML
    protected void onActionMaisInfoAula(){
        //TODO Abrir Aulas
    }
}