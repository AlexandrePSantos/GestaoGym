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
import java.time.format.DateTimeParseException;
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
    public TextField newPass, newTele, newNome;
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
    LinhaexercicioDAO linhaexercicioDAO = new LinhaexercicioDAO();
    LinhaparticipanteDAO linhaparticipanteDAO = new LinhaparticipanteDAO();

    public Label erroEx, erroPlano, erroAula, erroPerfil;

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
//  Aulas de grupo
//  *******************

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

    @FXML
    protected void getAddAula() {
        erroAula.setText(""); // Limpa a mensagem de erro anterior, se houver

        String tipoAula = tipoAulaTextField.getText().trim();
        LocalDate dataAula = dataAulaDatePicker.getValue();
        String horaAula = horaAulaTextField.getText().trim();
        String duracaoAula = duracaoAulaTextField.getText().trim();
        String salaSelecionada = salaAulaChoice.getValue();
        String vagasAulaStr = vagasAulaTextField.getText().trim();

        // Verifica se algum campo está vazio
        if (tipoAula.isEmpty() || dataAula == null || horaAula.isEmpty() || duracaoAula.isEmpty()
                || salaSelecionada.isEmpty() || vagasAulaStr.isEmpty()) {
            erroAula.setText("Todos os campos devem ser preenchidos.");
            return;
        }

        // Verifica se algum campo tem valor menor que 0
        int vagasAula;
        try {
            vagasAula = Integer.parseInt(vagasAulaStr);
            if (vagasAula < 0) {
                erroAula.setText("A quantidade de vagas não pode ser menor que 0.");
                return;
            }
        } catch (NumberFormatException e) {
            erroAula.setText("A quantidade de vagas deve ser um número válido.");
            return;
        }

        // Verifica se a data é uma semana após a data atual
        LocalDate dataAtual = LocalDate.now();
        LocalDate dataUmaSemanaDepois = dataAtual.plusWeeks(1);
        if (dataAula.isBefore(dataUmaSemanaDepois)) {
            erroAula.setText("A data da aula deve ser uma semana após a data atual.");
            return;
        }

        // Verifica se a hora da aula está entre 08:00 e 18:00
        LocalTime horaAulaTime;
        try {
            horaAulaTime = LocalTime.parse(horaAula);
            LocalTime horaInicio = LocalTime.of(8, 0);
            LocalTime horaFim = LocalTime.of(18, 0);
            if (horaAulaTime.isBefore(horaInicio) || horaAulaTime.isAfter(horaFim)) {
                erroAula.setText("A hora da aula deve estar entre 08:00 e 18:00.");
                return;
            }
        } catch (DateTimeParseException e) {
            erroAula.setText("A hora da aula deve estar em um formato válido (HH:mm).");
            return;
        }

        // Verifica se a duração está entre 20 e 200
        int duracaoAulaInt;
        try {
            duracaoAulaInt = Integer.parseInt(duracaoAula);
            if (duracaoAulaInt < 20 || duracaoAulaInt > 200) {
                erroAula.setText("A duração da aula deve estar entre 20 e 200 minutos.");
                return;
            }
        } catch (NumberFormatException e) {
            erroAula.setText("A duração da aula deve ser um número válido.");
            return;
        }

        // Restante do código...
        Sala sala = salaDAO.getById(salaSelecionada); // Recupera a sala selecionada do banco de dados

        int novoID = aulagrupoDAO.getID() + 1; // Obter o próximo ID disponível

        Aulagrupo aulagrupo = new Aulagrupo();
        aulagrupo.setNumAula(novoID);
        aulagrupo.setTipoAula(tipoAula);
        aulagrupo.setDataAula(dataAula);
        aulagrupo.setHoraAula(horaAulaTime);
        aulagrupo.setDuracao(duracaoAulaInt);
        aulagrupo.setSala(sala);
        aulagrupo.setVagas(vagasAula);
        aulagrupo.setVagasDisp(vagasAula);

        aulagrupoDAO.save(aulagrupo);
        loadAulasAgendadas();
        erroAula.setText("");
    }

    @FXML
    protected void getDeleteAula() {
        int numAula;
        try {
            numAula = Integer.parseInt(numAulaText.getText().trim());
        } catch (NumberFormatException e) {
            erroAula.setText("O número da aula deve ser um número válido.");
            return;
        }

        Aulagrupo aula = aulagrupoDAO.getById(numAula);
        if (aula == null) {
            erroAula.setText("A aula com esse número não existe.");
            return;
        }

        LocalDate dataAtual = LocalDate.now();
        if (aula.getDataAula().isBefore(dataAtual)) {
            erroAula.setText("Não é possível apagar uma aula realizada.");
            return;
        }

        // Remover as linhas participantes associadas à aula
        List<Linhaparticipante> linhasParticipantes = linhaparticipanteDAO.getAllById(numAula);
        for (Linhaparticipante linhaParticipante : linhasParticipantes) {
            linhaparticipanteDAO.delete(linhaParticipante.getIdLinhaPart());
        }

        aulagrupoDAO.delete(numAula);
        numAulaText.clear();
        loadAulasAgendadas();
        erroAula.setText("");
    }

    @FXML
    protected void getEditarAula() {
        int numAula;
        try {
            numAula = Integer.parseInt(numAulaEdit.getText().trim());
        } catch (NumberFormatException e) {
            erroAula.setText("O número da aula deve ser um número válido.");
            return;
        }

        Aulagrupo aulagrupo = aulagrupoDAO.getById(numAula);
        if (aulagrupo == null) {
            erroAula.setText("A aula com o número informado não existe.");
            return;
        }

        LocalDate dataAtual = LocalDate.now();
        LocalDate dataNova = dataAulaEdit.getValue();
        if (dataNova != null && dataNova.isBefore(dataAtual)) {
            erroAula.setText("Não é possível editar uma aula passada.");
            return;
        }

        LocalTime horaNova = null;
        if (!horaAulaEdit.getText().isEmpty()) {
            try {
                horaNova = LocalTime.parse(horaAulaEdit.getText());
            } catch (DateTimeParseException e) {
                erroAula.setText("O formato da hora da aula está incorreto. Use o formato HH:mm.");
                return;
            }
            if (horaNova.isBefore(LocalTime.of(8, 0)) || horaNova.isAfter(LocalTime.of(18, 0))) {
                erroAula.setText("A hora da aula deve estar entre 8:00 e 18:00.");
                return;
            }
        }

        int duracaoNova = -1;
        if (!duracaoAulaEdit.getText().isEmpty()) {
            try {
                duracaoNova = Integer.parseInt(duracaoAulaEdit.getText());
            } catch (NumberFormatException e) {
                erroAula.setText("A duração da aula deve ser um número válido.");
                return;
            }
            if (duracaoNova < 20 || duracaoNova > 200) {
                erroAula.setText("A duração da aula deve estar entre 20 e 200 minutos.");
                return;
            }
        }

        if (dataNova != null) {
            aulagrupo.setDataAula(dataNova);
        }
        if (horaNova != null) {
            aulagrupo.setHoraAula(horaNova);
        }
        if (duracaoNova != -1) {
            aulagrupo.setDuracao(duracaoNova);
        }

        aulagrupoDAO.update(aulagrupo);
        loadAulasAgendadas();
        erroAula.setText("");
    }

//  *******************
//  Planos de treino
//  *******************

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

    protected void loadExerciciosPage(int planoId)  throws IOException {
        // Carregar o arquivo FXML
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/javafx/Instrutor/show_exercicios.fxml"));
        Parent root = fxmlLoader.load();

        // Obter o controlador para a página de participantes
        show_exercicios showExerciciosController = fxmlLoader.getController();

        // Passar o ID do aulagrupo para o controlador da página de participantes
        showExerciciosController.setPlanoId(planoId);
        showExerciciosController.loadData(planoId);

        // Criar uma nova janela para exibir a página de participantes
        Stage stage = new Stage();
        stage.setTitle("Exercicios");
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    protected void criarPlano() {
        erroPlano.setText(""); // Limpa a mensagem de erro anterior, se houver

        Funcionario f = funcionarioDAO.getById(idUserAtual);

        String cliPlanoValue = cliPlano.getValue();
        if (cliPlanoValue == null) {
            erroPlano.setText("Selecione um cliente válido.");
            return;
        }

        int cliId = Integer.parseInt(cliPlanoValue.split(" - ")[0]);
        Cliente cli = clienteDAO.getById(cliId);
        if (cli == null) {
            erroPlano.setText("O cliente selecionado não existe.");
            return;
        }

        List<Planotreino> planosAtivos = planoDAO.getByClienteAndEstado(cli, "Ativo");
        if (!planosAtivos.isEmpty()) {
            erroPlano.setText("O cliente já possui um plano ativo.");
            return;
        }

        int novoID = planoDAO.getID() + 1; // Obter o próximo ID disponível

        Planotreino pt = new Planotreino();
        pt.setNumPlano(novoID);
        pt.setDtCriacao(LocalDate.now());
        pt.setEstado("ativo");
        pt.setCliente(cli);
        pt.setFuncionario(f);

        planoDAO.save(pt);
        loadPlanos();
        erroPlano.setText("");
    }

    @FXML
    protected void apagarPlano() {
        int planoId = Integer.parseInt(nPlano.getText());
        Planotreino pt = planoDAO.getById(planoId);

        if (pt == null) {
            erroPlano.setText("O plano não existe.");
            return;
        }

        if (pt.getEstado().equals("Inativo")) {
            erroPlano.setText("O plano já está inativo.");
            return;
        }

        pt.setEstado("Inativo");
        planoDAO.update(pt);
        nPlano.clear();
        loadPlanos();
        erroPlano.setText("");
    }


//  *******************
//  Exercicios
//  *******************

    protected void loadExercicios() {
        List<Exercicio> exer = exercicioDAO.getAll();

        numEx.setCellValueFactory(new PropertyValueFactory<>("idExercicio"));
        Exercicio.setCellValueFactory(new PropertyValueFactory<>("nome"));
        Equipamento.setCellValueFactory(new PropertyValueFactory<>("equipamento"));

        tableExercicio.setItems(FXCollections.observableArrayList(exer));
    }

    @FXML
    protected void addExercicio() {
        String nomeExercicio = nomeEx.getText();
        String nomeEquipamento = nomeEquip.getText();

        // Verificar se a combinação de exercício e equipamento já existe
        List<Exercicio> exercicios = exercicioDAO.getAll();
        for (Exercicio exercicio : exercicios) {
            if (exercicio.getNome().equals(nomeExercicio) && exercicio.getEquipamento().equals(nomeEquipamento)) {
                erroEx.setText("A combinação de exercício e equipamento já existe.");
                return;
            }
        }

        int novoID = exercicioDAO.getID() + 1; // Obter o próximo ID disponível

        Exercicio ex = new Exercicio();
        ex.setIdExercicio(novoID);
        ex.setNome(nomeExercicio);
        ex.setEquipamento(nomeEquipamento);
        exercicioDAO.save(ex);
        loadExercicios();
        nomeEx.clear();
        nomeEquip.clear();
        erroEx.setText("");
    }


    @FXML
    protected void apagarExercicio() {
        int idExercicio = Integer.parseInt(nExDelete.getText());

        // Verificar se o exercício existe
        Exercicio exercicio = exercicioDAO.getById(idExercicio);
        if (exercicio == null) {
            erroEx.setText("O exercício não existe.");
            return;
        }

        // Remover os linhaexercicio associados
        List<Linhaexercicio> linhaexercicios = linhaexercicioDAO.getByExercicioId(idExercicio);
        for (Linhaexercicio linhaexercicio : linhaexercicios) {
            linhaexercicioDAO.delete(linhaexercicio.getIdLinhaExercicio());
        }

        // Excluir o exercício
        exercicioDAO.delete(idExercicio);

        nExDelete.clear();
        loadExercicios();
        erroEx.setText("");
    }




//  *******************
//  Editar perfil -- FALTA BLL
//  *******************

    public void setUserId(Integer id) { this.idUserAtual = id; }

    @FXML
    public void loadPerfil(int idUserAtual) {
        Funcionario f = funcionarioDAO.getById(idUserAtual);
        if (f != null) {
            nomeLbl.setText("" + f.getNome());
            dnLbl.setText("" + f.getDataNascimento());
            tlmLbl.setText("" + f.getTelemovel());
            psswdLbl.setText("" + f.getPassword());
            funcLbl.setText("" + f.getFuncao());
            nifLbl.setText("" + f.getNif());
            mailLbl.setText("" + f.getEmail());
            slLbl.setText("" + f.getSalarioLiquido() + " €");
        }
    }

    @FXML
    protected void editarPerfil() {
        Funcionario f = funcionarioDAO.getById(idUserAtual);

        // Verifique se o número do funcionário é válido
        if (idUserAtual <= 0) {
            System.out.println("Funcionário inválido");
            return;
        }

        // Verifique se pelo menos um campo de entrada foi preenchido
        if (newNome.getText().isEmpty() && newPass.getText().isEmpty() && newTele.getText().isEmpty()) {
            erroPerfil.setText("Preencha pelo menos um campo!");
            return;
        }

        // Verifique cada campo de entrada e, se o campo estiver preenchido, atualize o valor correspondente no funcionário existente
        if (!newNome.getText().isEmpty()) {
            f.setNome(newNome.getText());
            newNome.clear();
        }
        if (!newPass.getText().isEmpty()) {
            f.setPassword(newPass.getText());
            newPass.clear();
        }
        if (!newTele.getText().isEmpty()) {
            f.setTelemovel(newTele.getText());
            newTele.clear();
        }

        // Chame o método update do FuncionarioDAO para salvar as alterações no banco de dados
        funcionarioDAO.update(f);
        loadPerfil(idUserAtual);
        erroPerfil.setText("");
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
