package com.example.javafx.InstrutorController;

import com.AcessoBD.DAO.*;
import com.AcessoBD.repository.entities.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.*;
import javafx.stage.*;

import java.io.IOException;
import java.time.*;
import java.util.*;
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
    public ChoiceBox<String> salaAulaChoice, cliPlano;
    @FXML
    public TextField vagasAulaTextField, numAulaText;
    @FXML
    public Button DeleteAula, EditarAula, AddAula;
    @FXML
    public TextField newPass, newTele;
    @FXML
    public TextField nExDelete;

    @FXML
    public TableView<Exercicio> tableExercicio;
    @FXML
    public TableColumn<Exercicio, Integer> numEx;
    @FXML
    public TableColumn<Exercicio, String> Exercicio;
    @FXML
    public TableColumn<Exercicio, String> Equipamento;
    public TextField nomeEquip, nomeEx;

    @FXML
    protected TableView<Aulagrupo> tabelaAulasRealizadas;
    @FXML
    protected TableColumn<Aulagrupo, Integer> numAulaReal;
    @FXML
    protected TableColumn<Aulagrupo, String> tipoAulaReal;
    @FXML
    protected TableColumn<Aulagrupo, LocalDate> dataAulaReal;
    @FXML
    protected TableColumn<Aulagrupo, LocalTime> horaAulaReal;
    @FXML
    protected TableColumn<Aulagrupo, Integer> duracaoReal;
    @FXML
    protected TableColumn<Sala, String> salaAulaReal;
    @FXML
    protected TableColumn<Aulagrupo, Integer> vagasReal;
    @FXML
    protected TableColumn<Aulagrupo, Integer> vagasDispReal;
    @FXML
    protected TableColumn<Aulagrupo, Void> ParticipantesReal;

    @FXML
    protected TableView<Aulagrupo> tabelaAulasPlaneadas;
    @FXML
    protected TableColumn<Aulagrupo, Integer> numAulaPlan;
    @FXML
    protected TableColumn<Aulagrupo, String> tipoAulaPlan;
    @FXML
    protected TableColumn<Aulagrupo, LocalDate> dataAulaPlan;
    @FXML
    protected TableColumn<Aulagrupo, LocalTime> horaAulaPlan;
    @FXML
    protected TableColumn<Aulagrupo, Integer> duracaoPlan;
    @FXML
    protected TableColumn<Sala, String> salaAulaPlan;
    @FXML
    protected TableColumn<Aulagrupo, Integer> vagasPlan;
    @FXML
    protected TableColumn<Aulagrupo, Integer> vagasDispPlan;
    @FXML
    protected TableColumn<Aulagrupo, Void> ParticipantesPlan;

    @FXML
    protected TableView<Planotreino> tabelaPlanos;
    @FXML
    protected TableColumn<Planotreino, Integer> numPlano;
    @FXML
    protected TableColumn<Planotreino, LocalDate> dtCriacao;
    @FXML
    protected TableColumn<Planotreino, String> estado;
    @FXML
    protected TableColumn<Planotreino, String> cliente;
    @FXML
    protected TableColumn<Planotreino, Void> showexercicios;
    public TextField nPlano;

    protected int idUserAtual;

    AulagrupoDAO aulagrupoDAO = new AulagrupoDAO();
    PlanotreinoDAO planoDAO = new PlanotreinoDAO();
    FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
    SalaDAO salaDAO = new SalaDAO();
    ExercicioDAO exercicioDAO = new ExercicioDAO();
    ClienteDAO clienteDAO = new ClienteDAO();


    //  *******************
//  Inicializar
//  *******************
    @FXML
    protected void initialize() {
        // Load tabelas e outros
        loadAulasAgendadas(); loadAulasRealizadas(); loadPlanos(); loadExercicios();

        // Carrega salas para choicebox
        List<Sala> salas = salaDAO.getAll();
        ObservableList<String> salaOptions = FXCollections.observableArrayList();
        for (Sala sala : salas) salaOptions.add(sala.getIdSala());
        salaAulaChoice.setItems(salaOptions);

        List<Cliente> clientes = clienteDAO.getAll();
        ObservableList<String> cliOptions = FXCollections.observableArrayList();
        for (Cliente cli : clientes) cliOptions.add(cli.getIdCliente() + " - " + cli.getNome());
        cliPlano.setItems(cliOptions);
    }

//  *******************
//  Aulas de grupo -- FALTA BLL
//  *******************

    //DONE
    protected void loadAulasAgendadas() {
        List<Aulagrupo> aulasAgendadas = aulagrupoDAO.getAll();

        numAulaPlan.setCellValueFactory(new PropertyValueFactory<>("numAula"));
        tipoAulaPlan.setCellValueFactory(new PropertyValueFactory<>("tipoAula"));
        dataAulaPlan.setCellValueFactory(new PropertyValueFactory<>("dataAula"));
        horaAulaPlan.setCellValueFactory(new PropertyValueFactory<>("horaAula"));
        duracaoPlan.setCellValueFactory(new PropertyValueFactory<>("duracao"));
        salaAulaPlan.setCellValueFactory(new PropertyValueFactory<>("sala"));
        vagasPlan.setCellValueFactory(new PropertyValueFactory<>("vagas"));
        vagasDispPlan.setCellValueFactory(new PropertyValueFactory<>("vagasDisp"));

        ParticipantesPlan.setCellFactory(param -> new TableCell<>() {
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
        tabelaAulasPlaneadas.setItems(FXCollections.observableArrayList(aulasFiltradas));
    }

    //DONE
    protected void loadAulasRealizadas() {
        List<Aulagrupo> aulasRealizadas = aulagrupoDAO.getAll();

        numAulaReal.setCellValueFactory(new PropertyValueFactory<>("numAula"));
        tipoAulaReal.setCellValueFactory(new PropertyValueFactory<>("tipoAula"));
        dataAulaReal.setCellValueFactory(new PropertyValueFactory<>("dataAula"));
        horaAulaReal.setCellValueFactory(new PropertyValueFactory<>("horaAula"));
        duracaoReal.setCellValueFactory(new PropertyValueFactory<>("duracao"));
        salaAulaReal.setCellValueFactory(new PropertyValueFactory<>("sala"));
        vagasReal.setCellValueFactory(new PropertyValueFactory<>("vagas"));
        vagasDispReal.setCellValueFactory(new PropertyValueFactory<>("vagasDisp"));

        ParticipantesReal.setCellFactory(param -> new TableCell<>() {
            private final Button button = new Button("+");

            {
                button.setOnAction(event -> {
                    Aulagrupo aulagrupo = getTableRow().getItem();
                    if (aulagrupo != null) {
                        int aulagrupoId = aulagrupo.getNumAula();
                        try {
                            System.out.println(aulagrupoId);
                            loadParticipantesPage(aulagrupoId);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                });
            }
            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) { setGraphic(null); } else { setGraphic(button); }
            }
        });

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
    protected void loadParticipantesPage(int aulagrupoId) throws IOException {
            // Carregar o arquivo FXML
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/javafx/Instrutor/show_participantes.fxml"));
            Parent root = fxmlLoader.load();

            // Obter o controlador para a página de participantes
            show_participantes participantesController = fxmlLoader.getController();

            // Passar o ID do aulagrupo para o controlador da página de participantes
            participantesController.setAulagrupoId(aulagrupoId);
            participantesController.loadData(aulagrupoId);

            // Criar uma nova janela para exibir a página de participantes
            Stage stage = new Stage();
            stage.setTitle("Participantes");
            stage.setScene(new Scene(root));
            stage.show();
    }

    //TODO - Falta BLL (Controlo de campos, não permitir determinados tipos de valores e formatos)
    @FXML
    protected void getAddAula() {
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
        aulagrupoDAO.delete(Integer.parseInt(numAulaText.getText()));
        numAulaText.clear(); loadAulasAgendadas();
    }

    //TODO - Falta BLL (não alterar aulas já realizadas nem introduzir valores que não fazem sentido)
    @FXML
    protected void getEditarAula() {
        int numAula = Integer.parseInt(numAulaEdit.getText()); numAulaEdit.clear();
        // Verifique se o número da aula é válido
        if (numAula <= 0) { System.out.println("aula inválida"); return; }
        // Recupere a aula existente com base no número da aula usando o método apropriado do AulaGrupoDAO
        Aulagrupo aulagrupo = aulagrupoDAO.getById(numAula);
        // Verifique cada campo de entrada e, se o campo estiver preenchido, atualize o valor correspondente na aula existente
        if (dataAulaEdit.getValue() != null) { aulagrupo.setDataAula(dataAulaEdit.getValue()); }
        if (!horaAulaEdit.getText().isEmpty()) { aulagrupo.setHoraAula(LocalTime.parse(horaAulaEdit.getText())); } horaAulaEdit.clear();
        if (!duracaoAulaEdit.getText().isEmpty()) { aulagrupo.setDuracao(Integer.parseInt(duracaoAulaEdit.getText())); } duracaoAulaEdit.clear();

        // Chame o método update do AulaGrupoDAO para salvar as alterações no banco de dados
        aulagrupoDAO.update(aulagrupo);
        loadAulasAgendadas();
    }

//  *******************
//  Planos de treino -- FALTA BLL
//  *******************

    //DONE
    protected void loadPlanos() {
        List<Planotreino> planos = planoDAO.getAll();

        numPlano.setCellValueFactory(new PropertyValueFactory<>("numPlano"));
        dtCriacao.setCellValueFactory(new PropertyValueFactory<>("dtCriacao"));
        estado.setCellValueFactory(new PropertyValueFactory<>("estado"));
        cliente.setCellValueFactory(cellData -> {
            Planotreino planotreino = cellData.getValue();
            Cliente cliente = planotreino.getCliente();

            // Retorna uma string formatada com o ID e o nome do cliente separados por um traço
            return new SimpleStringProperty(cliente.getIdCliente() + " - " + cliente.getNome());
        });
        showexercicios.setCellFactory(param -> new TableCell<>() {
            private final Button button = new Button("+"); {
                button.setOnAction(event -> {
                    Planotreino planotreino = getTableRow().getItem();
                    if (planotreino != null) {
                        int planoId = planotreino.getNumPlano();
                        try { loadExerciciosPage(planoId); } catch (IOException e) { throw new RuntimeException(e); }
                    }
                });
            }
            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) { setGraphic(null); } else { setGraphic(button); }
            }
        });

        tabelaPlanos.setItems(FXCollections.observableArrayList(planos));
    }

    //DONE
    protected void loadExerciciosPage(int planoId)  throws IOException {
        // Carregar o arquivo FXML
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/javafx/Instrutor/show_exercicios.fxml"));
        Parent root = fxmlLoader.load();

        // Obter o controlador para a página de participantes
        show_exercicios showExerciciosController = fxmlLoader.getController();

        // Passar o ID do aulagrupo para o controlador da página de participantes
        showExerciciosController.setPlanoId(planoId);
        showExerciciosController.loadData();

        // Criar uma nova janela para exibir a página de participantes
        Stage stage = new Stage();
        stage.setTitle("Exercicios");
        stage.setScene(new Scene(root));
        stage.show();
    }

    //TODO - Só pode criar para um cliente que já tenha se os anteriores estiverem inativos
    @FXML
    protected void criarPlano() {
        Funcionario f = funcionarioDAO.getById(idUserAtual);
        Cliente cli = clienteDAO.getById(Integer.parseInt(cliPlano.getValue().split(" - ")[0]));
        Planotreino pt = new Planotreino();

        pt.setDtCriacao(LocalDate.now());
        pt.setEstado("ativo");
        pt.setCliente(cli);
        pt.setFuncionario(f);
        planoDAO.save(pt);loadPlanos();
    }

    //DONE
    @FXML
    protected void apagarPlano() {
        Planotreino pt = planoDAO.getById(Integer.parseInt(nPlano.getText()));
        pt.setEstado("inativo");
        planoDAO.update(pt);
        nPlano.clear(); loadPlanos();
    }

//  *******************
//  Exercicios -- FALTA BLL
//  *******************

    //DONE
    protected void loadExercicios() {
        List<Exercicio> exer = exercicioDAO.getAll();

        numEx.setCellValueFactory(new PropertyValueFactory<>("idExercicio"));
        Exercicio.setCellValueFactory(new PropertyValueFactory<>("nome"));
        Equipamento.setCellValueFactory(new PropertyValueFactory<>("equipamento"));

        tableExercicio.setItems(FXCollections.observableArrayList(exer));
    }

    //TODO - se já existir a combinação de exercicio e equipamento não deixar inserir
    @FXML
    protected void addExercicio() {
        Exercicio ex = new Exercicio();
        ex.setNome(nomeEx.getText());
        ex.setEquipamento(nomeEquip.getText());
        exercicioDAO.save(ex);
        loadExercicios(); nomeEx.clear(); nomeEquip.clear();
    }

    //TODO - remover cascade de planos com esse exercicio
    @FXML
    protected void apagarExercicio() {
        exercicioDAO.delete(Integer.parseInt(nExDelete.getText()));
        nExDelete.clear(); loadExercicios();
    }

//  *******************
//  Editar perfil -- FALTA BLL
//  *******************

    //DONE
    public void setUserId(Integer id) { this.idUserAtual = id; }

    //DONE
    @FXML
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
        }
    }

    //TODO - restriões como password fraca e telemovel com minimo tamanho e a começar em determinados valores
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

    //DONE
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
