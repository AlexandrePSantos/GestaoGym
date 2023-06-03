package com.example.javafx.InstrutorController;

import com.AcessoBD.DAO.*;
import com.AcessoBD.repository.entities.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

public class instrutor_dashboard {
    @FXML
    public Label nomeLbl, dnLbl, tlmLbl, psswdLbl, funcLbl, nifLbl, mailLbl, slLbl;
    @FXML
    public TextField numAulaEdit;
    @FXML
    public DatePicker dataAulaEdit;
    @FXML
    public TextField horaAulaEdit, duracaoAulaEdit, tipoAulaTextField, horaAulaTextField, duracaoAulaTextField;
    @FXML
    public DatePicker dataAulaDatePicker;
    @FXML
    public ChoiceBox<String> salaAulaChoice;
    @FXML
    public TextField vagasAulaTextField, numAulaText;
    @FXML
    public Button DeleteAula, EditarAula, AddAula;
    @FXML
    public TextField newPass, newTele;
    @FXML
    private TableView<Aulagrupo> tabelaAulasRealizadas;
    @FXML
    private TableColumn<Aulagrupo, Integer> numAulaReal;
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
    private TableColumn<Aulagrupo, Integer> numAulaPlan;
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
    private int idUserAtual;
    AulagrupoDAO aulagrupoDAO = new AulagrupoDAO();
    PlanotreinoDAO planoDAO = new PlanotreinoDAO();
    FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
    SalaDAO salaDAO = new SalaDAO();

//  *******************
//  Inicializar
//  *******************
    @FXML
    private void initialize() {
        // Load tabelas e outros
        loadAulasAgendadas(); loadAulasRealizadas(); loadPlanos();

        // Carrega salas para choicebox
        List<Sala> salas = salaDAO.getAll();
        ObservableList<String> salaOptions = FXCollections.observableArrayList();

        for (Sala sala : salas) salaOptions.add(sala.getIdSala());
        salaAulaChoice.setItems(salaOptions);
    }

//  *******************
//  Aulas de grupo - faltam os participantes (talvez uma window extra tipo pop up com a lista)
//  *******************
    private void loadAulasAgendadas() {
        List<Aulagrupo> aulasAgendadas = aulagrupoDAO.getAll();

        numAulaPlan.setCellValueFactory(new PropertyValueFactory<>("numAula"));
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
        tabelaAulasPlaneadas.setItems(FXCollections.observableArrayList(aulasFiltradas));
    }
    private void loadAulasRealizadas() {
        List<Aulagrupo> aulasRealizadas = aulagrupoDAO.getAll();

        numAulaReal.setCellValueFactory(new PropertyValueFactory<>("numAula"));
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
        tabelaAulasRealizadas.setItems(FXCollections.observableArrayList(aulasFiltradas));
    }

    //DONE
    @FXML
    protected void refreshAula() { loadAulasAgendadas(); }

    //TODO - Falta BLL (Controlo de campos, não permitir determinados tipos de valores e formatos)
    @FXML
    protected void getAddAula() {
//        tipoAula, dataAula, horaAula, duracaoAula, salaAulaChoice, vagasAula;
//        vagasDisp será igual a vagasAula mas á atuaalizado á medida que alunos se inscrevem;
        String tipoAula = tipoAulaTextField.getText(); tipoAulaTextField.clear();
        LocalDate dataAula = dataAulaDatePicker.getValue();
        String horaAula = horaAulaTextField.getText(); horaAulaTextField.clear();
        String duracaoAula = duracaoAulaTextField.getText(); duracaoAulaTextField.clear();
        String salaSelecionada = salaAulaChoice.getValue();
        int vagasAula = Integer.parseInt(vagasAulaTextField.getText()); vagasAulaTextField.clear();

        Sala sala = salaDAO.getById(salaSelecionada); // Recupera a sala selecionada do banco de dados

        Aulagrupo aulagrupo = new Aulagrupo();
        aulagrupo.setTipoAula(tipoAula);
        aulagrupo.setDataAula(dataAula);
        aulagrupo.setHoraAula(LocalTime.parse(horaAula));
        aulagrupo.setDuracao(Integer.parseInt(duracaoAula));
        aulagrupo.setSala(sala);
        aulagrupo.setVagas(vagasAula);
        aulagrupo.setVagasDisp(vagasAula);

        aulagrupoDAO.save(aulagrupo);
        loadAulasAgendadas();
    }

    //TODO - Falta BLL (não apagar aulas já realizadas)
    @FXML
    protected void getDeleteAula() {
        String numAula = numAulaText.getText(); numAulaText.clear();
        int numAulaInt = Integer.parseInt(numAula);

        aulagrupoDAO.delete(numAulaInt);
    }

    //TODO - Falta BLL (não alterar aulas já realizadas nem introduzir valores que não fazem sentido)
    @FXML
    protected void getEditarAula() {
        int numAula = Integer.parseInt(numAulaEdit.getText()); numAulaEdit.clear();
        // Verifique se o número da aula é válido
        if (numAula <= 0) { System.out.println("aula inválida"); return; }
        // Recupere a aula existente com base no número da aula usando o método apropriado do AulaGrupoDAO
        Aulagrupo aulagrupo = aulagrupoDAO.getById(numAula);
        System.out.println(numAula);
        System.out.println();
        // Verifique cada campo de entrada e, se o campo estiver preenchido, atualize o valor correspondente na aula existente
        if (dataAulaEdit.getValue() != null) { aulagrupo.setDataAula(dataAulaEdit.getValue()); }
        if (!horaAulaEdit.getText().isEmpty()) { aulagrupo.setHoraAula(LocalTime.parse(horaAulaEdit.getText())); } horaAulaEdit.clear();
        if (!duracaoAulaEdit.getText().isEmpty()) { aulagrupo.setDuracao(Integer.parseInt(duracaoAulaEdit.getText())); } duracaoAulaEdit.clear();

        // Chame o método update do AulaGrupoDAO para salvar as alterações no banco de dados
        aulagrupoDAO.update(aulagrupo);
        loadAulasAgendadas();
    }

//  *******************
//  Planos de treino
//  *******************

    private void loadPlanos() {
        List<Planotreino> planos = planoDAO.getAll();

        numPlano.setCellValueFactory(new PropertyValueFactory<>("numPlano"));
        dtCriacao.setCellValueFactory(new PropertyValueFactory<>("dtCriacao"));
        estado.setCellValueFactory(new PropertyValueFactory<>("estado"));
        cliente.setCellValueFactory(new PropertyValueFactory<>("cliente"));

        tabelaPlanos.setItems(FXCollections.observableArrayList(planos));
    }

    //TODO
    @FXML
    protected void criarPlano() {

    }
    //TODO
    @FXML
    protected void apagarPlano() {

    }
    //TODO
    @FXML
    protected void pagExercicios(ActionEvent event) throws IOException {}

//  *******************
//  Editar perfil
//  *******************
    public void setUserId(Integer id) { this.idUserAtual = id; }

    public void loadPerfil(int idUserAtual) {
        Funcionario f = funcionarioDAO.getById(idUserAtual);
        if (f != null) {
            nomeLbl.setText("Nome: " + f.getNome());
            dnLbl.setText("Data Nasc.: " + f.getDataNascimento());
            tlmLbl.setText("Telemóvel: " + f.getTelemovel());
            psswdLbl.setText("Password: " + f.getPassword());
            funcLbl.setText("Função: " + f.getFuncao());
            nifLbl.setText("NIF: " + f.getNif());
            mailLbl.setText("Email: " + f.getEmail());
            slLbl.setText("Salário Mensal: " + f.getSalarioLiquido() + " €");
        } else {
            System.out.println("Criar um alerta de erro pah");
        }
    }

    @FXML
    protected void editarPerfil() {
        Funcionario f = funcionarioDAO.getById(idUserAtual);
        // Verifique se o número da aula é válido
        if (idUserAtual <= 0) { System.out.println("Funcionario inválido"); return; }
        // Verifique cada campo de entrada e, se o campo estiver preenchido, atualize o valor correspondente na aula existente
        if (!newPass.getText().isEmpty()) { f.setPassword(newPass.getText()); } newPass.clear();
        if (!newTele.getText().isEmpty()) { f.setTelemovel(newTele.getText()); } newTele.clear();
        // Chame o método update do AulaGrupoDAO para salvar as alterações no banco de dados
        funcionarioDAO.update(f);
        loadPerfil(idUserAtual);
    }

//  *******************
//  Logout
//  *******************
    @FXML
    protected void onActionExit(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/javafx/Login.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.show();

        Node source = (Node) event.getSource();
        Stage stageAtual = (Stage) source.getScene().getWindow();
        stageAtual.close();
    }
}
