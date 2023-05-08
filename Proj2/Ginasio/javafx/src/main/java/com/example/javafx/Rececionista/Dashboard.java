package com.example.javafx.Rececionista;

import com.example.javafx.HelloApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Dashboard {
    @FXML
    protected void onActionAlterar(Stage stage) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("instrutor_info.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
//        stage.setTitle("Informação");
//        stage.setScene(scene);
//        stage.show();
    }

    @FXML
    protected void onActionMaisInfoSubs(){
        //TODO Abrir Planos
    }

    @FXML
    protected void onActionMaisInfoAula(){
        //TODO Abrir Aulas
    }

    @FXML
    protected void onActionCriarCliente(){
        //TODO Abrir Criar Cliente
    }
}