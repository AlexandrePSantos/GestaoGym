package com.example.javafx.AdministradorController;

import com.AcessoBD.DAO.AulagrupoDAO;
import com.AcessoBD.repository.entities.Aulagrupo;
import com.AcessoBD.repository.entities.Funcionario;
import com.AcessoBD.repository.entities.Sala;
import com.example.javafx.RececionistaController.show_clientes;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

public class show_aulas {
    // Planeadas
    @FXML
    public TableView<Aulagrupo> tblAulasPlaneadas;
    @FXML
    public TableColumn<Aulagrupo, Integer> numP;
    @FXML
    public TableColumn<Aulagrupo, LocalDate> dataP;
    @FXML
    public TableColumn<Aulagrupo, LocalTime> horaP;
    @FXML
    public TableColumn<Aulagrupo, Integer> durP;
    @FXML
    public TableColumn<Aulagrupo, Sala> salaP;
    @FXML
    public TableColumn<Aulagrupo, String> tipoP;
    @FXML
    public TableColumn<Aulagrupo, Integer> vagasP;
    @FXML
    public TableColumn<Aulagrupo, Funcionario> funcP;
    @FXML
    protected TableColumn<Aulagrupo, Void> partP;
    // Realizadas
    @FXML
    public TableView<Aulagrupo> tblAulasRealizadas;
    @FXML
    public TableColumn<Aulagrupo, Integer> numR;
    @FXML
    public TableColumn<Aulagrupo, LocalDate> dataR;
    @FXML
    public TableColumn<Aulagrupo, LocalTime> horaR;
    @FXML
    public TableColumn<Aulagrupo, Integer> durR;
    @FXML
    public TableColumn<Aulagrupo, Sala> salaR;
    @FXML
    public TableColumn<Aulagrupo, String> tipoR;
    @FXML
    public TableColumn<Aulagrupo, Integer> vagasR;
    @FXML
    public TableColumn<Aulagrupo, Funcionario> funcR;
    @FXML
    protected TableColumn<Aulagrupo, Void> partR;
    Aulagrupo aulagrupo = new Aulagrupo();
    AulagrupoDAO aulagrupoDAO = new AulagrupoDAO();
    Funcionario funcionario = new Funcionario();
    Sala sala = new Sala();

    @FXML
    protected void initialize() {
        loadAulasAgendadas();
        loadAulasRealizadas();
    }

//  *******************
//  Aulas de grupo
//  *******************

    protected void loadAulasAgendadas() {
        List<Aulagrupo> aulasAgendadas = aulagrupoDAO.getAll();

        numP.setCellValueFactory(new PropertyValueFactory<>("numAula"));
        dataP.setCellValueFactory(new PropertyValueFactory<>("dataAula"));
        horaP.setCellValueFactory(new PropertyValueFactory<>("horaAula"));
        durP.setCellValueFactory(new PropertyValueFactory<>("duracao"));
        salaP.setCellValueFactory(cellData -> {
            aulagrupo = cellData.getValue();
            sala = aulagrupo.getSala();
            ObservableValue<Sala> observableValue = new ReadOnlyObjectWrapper<>(sala);
            return observableValue;
        });
        salaP.setCellFactory(column -> new TableCell<>() {
            @Override
            protected void updateItem(Sala item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) { setText(null); } else { setText(item.getIdSala()); }
            }
        });
        tipoP.setCellValueFactory(new PropertyValueFactory<>("tipoAula"));
        vagasP.setCellValueFactory(new PropertyValueFactory<>("vagas"));
        funcP.setCellValueFactory(cellData -> {
            aulagrupo = cellData.getValue();
            funcionario = aulagrupo.getFuncionario();
            ObservableValue<Funcionario> observableValue = new ReadOnlyObjectWrapper<>(funcionario);
            return observableValue;
        });
        funcP.setCellFactory(column -> new TableCell<>() {
            @Override
            protected void updateItem(Funcionario item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) { setText(null); } else { setText(item.getId() + " - " +item.getNome()); }
            }
        });
        partP.setCellFactory(param -> new TableCell<>() {
            private final Button button = new Button("+");
            {
                button.setOnAction(event -> {
                    Aulagrupo aulagrupo = getTableRow().getItem();
                    if (aulagrupo != null) {
                        int aulagrupoId = aulagrupo.getNumAula();
                        try { loadParticipantesPage(aulagrupoId); } catch (IOException e) { throw new RuntimeException(e); }
                    }
                });
            }
            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) { setGraphic(null); } else { setGraphic(button); }
            }
        });

        // Filtrar apenas as aulas cuja data e hora são posteriores à data atual
        LocalDateTime dataHoraAtual = LocalDateTime.of(LocalDate.now(), LocalTime.now());
        List<Aulagrupo> aulasFiltradas = aulasAgendadas.stream()
                .filter(aula -> {
                    LocalDateTime dataHoraAula = LocalDateTime.of(aula.getDataAula(), aula.getHoraAula());
                    return dataHoraAula.isAfter(dataHoraAtual);
                })
                .collect(Collectors.toList());
        tblAulasPlaneadas.setItems(FXCollections.observableArrayList(aulasFiltradas));
    }
    //DONE
    protected void loadAulasRealizadas() {
        List<Aulagrupo> aulasRealizadas = aulagrupoDAO.getAll();

        numR.setCellValueFactory(new PropertyValueFactory<>("numAula"));
        dataR.setCellValueFactory(new PropertyValueFactory<>("dataAula"));
        horaR.setCellValueFactory(new PropertyValueFactory<>("horaAula"));
        durR.setCellValueFactory(new PropertyValueFactory<>("duracao"));
        salaR.setCellValueFactory(cellData -> {
            aulagrupo = cellData.getValue();
            sala = aulagrupo.getSala();
            ObservableValue<Sala> observableValue = new ReadOnlyObjectWrapper<>(sala);
            return observableValue;
        });
        salaR.setCellFactory(column -> new TableCell<>() {
            @Override
            protected void updateItem(Sala item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) { setText(null); } else { setText(item.getIdSala()); }
            }
        });
        tipoR.setCellValueFactory(new PropertyValueFactory<>("tipoAula"));
        vagasR.setCellValueFactory(new PropertyValueFactory<>("vagas"));
        funcR.setCellValueFactory(cellData -> {
            aulagrupo = cellData.getValue();
            funcionario = aulagrupo.getFuncionario();
            ObservableValue<Funcionario> observableValue = new ReadOnlyObjectWrapper<>(funcionario);
            return observableValue;
        });
        funcR.setCellFactory(column -> new TableCell<>() {
            @Override
            protected void updateItem(Funcionario item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) { setText(null); } else { setText(item.getId() + " - " +item.getNome()); }
            }
        });
        partR.setCellFactory(param -> new TableCell<>() {
            private final Button button = new Button("+");
            {
                button.setOnAction(event -> {
                    Aulagrupo aulagrupo = getTableRow().getItem();
                    if (aulagrupo != null) {
                        int aulagrupoId = aulagrupo.getNumAula();
                        try { loadParticipantesPage(aulagrupoId); } catch (IOException e) { throw new RuntimeException(e); }
                    }
                });
            }
            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) { setGraphic(null); } else { setGraphic(button); }
            }
        });
        // Filtrar apenas as aulas cuja data e hora são posteriores à data atual
        LocalDateTime dataHoraAtual = LocalDateTime.of(LocalDate.now(), LocalTime.now());
        List<Aulagrupo> aulasFiltradas = aulasRealizadas.stream()
                .filter(aula -> {
                    LocalDateTime dataHoraAula = LocalDateTime.of(aula.getDataAula(), aula.getHoraAula());
                    return dataHoraAula.isBefore(dataHoraAtual);
                })
                .collect(Collectors.toList());
        tblAulasRealizadas.setItems(FXCollections.observableArrayList(aulasFiltradas));
    }

    protected void loadParticipantesPage(int aulagrupoId) throws IOException {
        // Carregar o arquivo FXML
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/javafx/Rececionista/show_clientes.fxml"));
        Parent root = fxmlLoader.load();

        // Obter o controlador para a página de participantes
        show_clientes participantesController = fxmlLoader.getController();

        // Passar o ID do aulagrupo para o controlador da página de participantes
        participantesController.setAulagrupoId(aulagrupoId);
        participantesController.loadData(aulagrupoId);

        // Criar uma nova janela para exibir a página de participantes
        Stage stage = new Stage();
        stage.setTitle("Participantes");
        stage.setScene(new Scene(root));
        stage.show();
    }
}
