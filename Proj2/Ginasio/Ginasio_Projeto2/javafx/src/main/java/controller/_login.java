package controller;

import com.AcessoBD.BLL.LoginBLL;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.io.*;

public class _login {
    @FXML
    TextField login_user;
    @FXML
    PasswordField login_password;
    @FXML
    Button login_confirmar;

    @FXML
    protected void onActionConfirmar(MouseEvent event) throws IOException {
        Stage stage = new Stage();
        LoginBLL l = new LoginBLL();
        //TODO se _login der instrutor: vai para instrutor_dashboard
        if(l.loginFuncionario(login_user.getText(), login_password.getText()) == 1) {
            FXMLLoader fxmlLoader = new FXMLLoader(new File("../Ginasio_Projeto2/javafx/src/main/resources/com/example/javafx/instrutor_dashboard.fxml").toURI().toURL());
            Scene scene = new Scene(fxmlLoader.load(), 1366, 768);
            stage.setTitle("Instrutor: Dashboard");
            stage.setScene(scene);
            stage.show();

            Node source = (Node) event.getSource();
            Stage stageAtual = (Stage) source.getScene().getWindow();
            stageAtual.close();
        } else if (l.loginFuncionario(login_user.getText(), login_password.getText()) == 2) {
            FXMLLoader fxmlLoader = new FXMLLoader(new File("../Ginasio_Projeto2/javafx/src/main/resources/com/example/javafx/admin_dashboard.fxml").toURI().toURL());
            Scene scene = new Scene(fxmlLoader.load(), 1366, 768);
            stage.setTitle("Admin: Dashboard");
            stage.setScene(scene);
            stage.show();

            Node source = (Node) event.getSource();
            Stage stageAtual = (Stage) source.getScene().getWindow();
            stageAtual.close();
        } else if (l.loginFuncionario(login_user.getText(), login_password.getText()) == 0) {
            //failed
            System.out.println("login falhou");
        }
    }
}
