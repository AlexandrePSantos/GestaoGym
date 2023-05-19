package controller;

import com.AcessoBD.BLL.PlanosBLL;
import com.AcessoBD.DAO.AulagrupoDAO;
import com.AcessoBD.DAO.PlanotreinoDAO;
import com.AcessoBD.repository.entities.Aulagrupo;
import com.AcessoBD.repository.entities.Planotreino;
import com.AcessoBD.repository.entities.Sala;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.stream.Collectors;
import java.util.List;

public class instrutor_dashboard {
    @FXML
    public ImageView exit;
    @FXML
    private Button inst_dash_alt;
    @FXML
    private TableView<Aulagrupo> tabelaAulasRealizadas;
    @FXML
    private TableColumn<Aulagrupo, String> tipoAulaReal;
    @FXML
    private TableColumn<Aulagrupo, LocalDate> dataAulaReal;
    @FXML
    private TableColumn<Aulagrupo, LocalTime> horaAulaReal;
    @FXML
    private TableColumn<Aulagrupo, Integer> duracaoReal;
    @FXML
    private TableColumn<Sala, String> salaAulaReal;
    @FXML
    private TableColumn<Aulagrupo, Integer> vagasReal;
    @FXML
    private TableColumn<Aulagrupo, Integer> vagasDispReal;
    @FXML
    private TableView<Aulagrupo> tabelaAulasPlaneadas;
    @FXML
    private TableColumn<Aulagrupo, String> tipoAulaPlan;
    @FXML
    private TableColumn<Aulagrupo, LocalDate> dataAulaPlan;
    @FXML
    private TableColumn<Aulagrupo, LocalTime> horaAulaPlan;
    @FXML
    private TableColumn<Aulagrupo, Integer> duracaoPlan;
    @FXML
    private TableColumn<Sala, String> salaAulaPlan;
    @FXML
    private TableColumn<Aulagrupo, Integer> vagasPlan;
    @FXML
    private TableColumn<Aulagrupo, Integer> vagasDispPlan;
    @FXML
    private TableView<Planotreino> tabelaPlanos;
    @FXML
    private TableColumn<Planotreino, Integer> numPlano;
    @FXML
    private TableColumn<Planotreino, LocalDate> dtCriacao;
    @FXML
    private TableColumn<Planotreino, String> estado;
    @FXML
    private TableColumn<Planotreino, String> cliente;

    @FXML
    private void initialize() {
        // AULAS DE GRUPO
        loadAulasAgendadas();
        loadAulasRealizadas();
        // PLANOS DE TREINO
        loadPlanos();
    }

    private void loadAulasAgendadas() {
        AulagrupoDAO aulagrupoDAO = new AulagrupoDAO();

        List<Aulagrupo> aulasAgendadas = aulagrupoDAO.getAll();

        tipoAulaPlan.setCellValueFactory(new PropertyValueFactory<>("tipoAula"));
        dataAulaPlan.setCellValueFactory(new PropertyValueFactory<>("dataAula"));
        horaAulaPlan.setCellValueFactory(new PropertyValueFactory<>("horaAula"));
        duracaoPlan.setCellValueFactory(new PropertyValueFactory<>("duracao"));
        salaAulaPlan.setCellValueFactory(new PropertyValueFactory<>("sala"));
        vagasPlan.setCellValueFactory(new PropertyValueFactory<>("vagas"));
        vagasDispPlan.setCellValueFactory(new PropertyValueFactory<>("vagasDisp"));
        // Filtrar apenas as aulas cuja data e hora são posteriores à data atual
        LocalDate dataAtual = LocalDate.now();
        LocalTime horaAtual = LocalTime.now();
        LocalDateTime dataHoraAtual = LocalDateTime.of(dataAtual, horaAtual);

        List<Aulagrupo> aulasFiltradas = aulasAgendadas.stream()
                .filter(aula -> {
                    LocalDateTime dataHoraAula = LocalDateTime.of(aula.getDataAula(), aula.getHoraAula());
                    return dataHoraAula.isAfter(dataHoraAtual);
                })
                .collect(Collectors.toList());

        // Adicione os itens à tabela
        tabelaAulasPlaneadas.setItems(FXCollections.observableArrayList(aulasFiltradas));
    }

    private void loadAulasRealizadas() {
        AulagrupoDAO aulagrupoDAO = new AulagrupoDAO();

        List<Aulagrupo> aulasRealizadas = aulagrupoDAO.getAll();

        tipoAulaReal.setCellValueFactory(new PropertyValueFactory<>("tipoAula"));
        dataAulaReal.setCellValueFactory(new PropertyValueFactory<>("dataAula"));
        horaAulaReal.setCellValueFactory(new PropertyValueFactory<>("horaAula"));
        duracaoReal.setCellValueFactory(new PropertyValueFactory<>("duracao"));
        salaAulaReal.setCellValueFactory(new PropertyValueFactory<>("sala"));
        vagasReal.setCellValueFactory(new PropertyValueFactory<>("vagas"));
        vagasDispReal.setCellValueFactory(new PropertyValueFactory<>("vagasDisp"));

        // Filtrar apenas as aulas cuja data e hora são anteriores à data atual
        LocalDate dataAtual = LocalDate.now();
        LocalTime horaAtual = LocalTime.now();
        LocalDateTime dataHoraAtual = LocalDateTime.of(dataAtual, horaAtual);

        List<Aulagrupo> aulasFiltradas = aulasRealizadas.stream()
                .filter(aula -> {
                    LocalDateTime dataHoraAula = LocalDateTime.of(aula.getDataAula(), aula.getHoraAula());
                    return dataHoraAula.isBefore(dataHoraAtual);
                })
                .collect(Collectors.toList());

        // Adicione os itens à tabela
        tabelaAulasRealizadas.setItems(FXCollections.observableArrayList(aulasFiltradas));
    }

    private void loadPlanos() {
        PlanotreinoDAO planoDAO = new PlanotreinoDAO();

        List<Planotreino> planos = planoDAO.getAll();

        numPlano.setCellValueFactory(new PropertyValueFactory<>("numPlano"));
        dtCriacao.setCellValueFactory(new PropertyValueFactory<>("dtCriacao"));
        estado.setCellValueFactory(new PropertyValueFactory<>("estado"));
        cliente.setCellValueFactory(new PropertyValueFactory<>("cliente"));

        tabelaPlanos.setItems(FXCollections.observableArrayList(planos));
    }
    @FXML
    protected void getAddAula() {}

    @FXML
    protected void refreshAula() {}

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