package com.example.javafx.RececionistaController;

import com.AcessoBD.DAO.*;
import com.AcessoBD.repository.entities.*;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.*;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.*;
import java.util.List;
import java.util.stream.Collectors;

public class rececionista_dashboard {
    // Subscrições
    @FXML
    protected TableView<Subscricao> tabelaSubs;
    @FXML
    protected TableColumn<Subscricao, Integer> numSub;
    @FXML
    protected TableColumn<Subscricao, LocalDate> dtIniSub;
    @FXML
    protected TableColumn<Subscricao, LocalDate> dtFimSub;
    @FXML
    protected TableColumn<Subscricao, BigDecimal> valorSub;
    @FXML
    protected TableColumn<Subscricao, String> estadoSub;
    @FXML
    protected TableColumn<Subscricao, Cliente> cliSub;
    @FXML
    protected TableColumn<Subscricao, Void> pagSub;
    @FXML
    protected TextField nSubEdit;
    @FXML
    protected TextField nCliSubCriar, valSubCriar;
    @FXML
    protected DatePicker dtIniSubCriar;
    @FXML
    protected Label erroSub;

    // Aulas de Grupo Realizadas
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
    protected TableColumn<Aulagrupo, Funcionario> InstrutorReal;
    @FXML
    protected TableColumn<Aulagrupo, Void> ParticipantesReal;

    // Aulas de Grupo Planeadas
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
    protected TableColumn<Aulagrupo, Funcionario> InstrutorPlan;
    @FXML
    protected TableColumn<Aulagrupo, Void> ParticipantesPlan;

    // Clientes
    @FXML
    protected TableView<Cliente> tblClientes;
    @FXML
    protected TableColumn<Cliente, Integer> nCliTbl;
    @FXML
    protected TableColumn<Cliente, String> nomeCliTbl;
    @FXML
    protected TableColumn<Cliente, LocalDate> dtnscCliTbl;
    @FXML
    protected TableColumn<Cliente, String> cpCliTbl;
    @FXML
    protected TableColumn<Cliente, String> nifcliTbl;
    @FXML
    protected TableColumn<Cliente, String> mailCliTbl;
    @FXML
    protected TableColumn<Cliente, String> tlmCliTbl;
    @FXML
    protected TextField nCliDelete;
    @FXML
    protected Label errorCli;

    // Perfil
    @FXML
    public Label nomeLbl, dnLbl, tlmLbl, psswdLbl, funcLbl, nifLbl, mailLbl, slLbl, errorPerfil;
    @FXML
    public TextField newPass, newTele, newNome;

    protected int idUserAtual;

    AulagrupoDAO aulagrupoDAO = new AulagrupoDAO();
    FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
    SubscricaoDAO subsDAO = new SubscricaoDAO();
    ClienteDAO clienteDAO = new ClienteDAO();
    PagamentoDAO pagDAO = new PagamentoDAO();

//  *******************
//  Inicializar
//  *******************

    @FXML
    protected void initialize() {
        loadAulasAgendadas();
        loadAulasRealizadas();
        loadSubscricoes();
        loadClientes();
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
        InstrutorPlan.setCellValueFactory(cellData -> {
            Aulagrupo aulagrupo = cellData.getValue();
            Funcionario inst = aulagrupo.getFuncionario();
            ObservableValue<Funcionario> observableValue = new ReadOnlyObjectWrapper<>(inst);
            return observableValue;
        });
        InstrutorPlan.setCellFactory(column -> new TableCell<>() {
            @Override
            protected void updateItem(Funcionario item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) { setText(null); } else { setText(item.getNome()); }
            }
        });
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
        InstrutorReal.setCellValueFactory(cellData -> {
            Aulagrupo aulagrupo = cellData.getValue();
            Funcionario inst = aulagrupo.getFuncionario();
            ObservableValue<Funcionario> observableValue = new ReadOnlyObjectWrapper<>(inst);
            return observableValue;
        });
        InstrutorReal.setCellFactory(column -> new TableCell<>() {
            @Override
            protected void updateItem(Funcionario item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) { setText(null); } else { setText(item.getNome()); }
            }
        });
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

    public void refreshAulas() {
        loadAulasAgendadas();
        loadAulasRealizadas();
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

//  *******************
//  Subsccriçções
//  *******************

    @FXML
    protected void loadSubscricoes() {
        List<Subscricao> subs = subsDAO.getAll();

        numSub.setCellValueFactory(new PropertyValueFactory<>("numSubscricao"));
        dtIniSub.setCellValueFactory(new PropertyValueFactory<>("dataIni"));
        dtFimSub.setCellValueFactory(new PropertyValueFactory<>("dataFim"));
        valorSub.setCellValueFactory(new PropertyValueFactory<>("valor"));
        estadoSub.setCellValueFactory(new PropertyValueFactory<>("estado"));
        cliSub.setCellValueFactory(new PropertyValueFactory<>("cliente"));
        pagSub.setCellFactory(param -> new TableCell<>() {
            private final Button button = new Button("+");
            {
                button.setOnAction(event -> {
                    Subscricao sub = getTableRow().getItem();
                    if (sub != null) {
                        try {
                            System.out.println(sub.getNumSubscricao());
                            loadPagamentosPag(sub.getNumSubscricao());
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
        tabelaSubs.setItems(FXCollections.observableArrayList(subs));
    }

    @FXML
    protected void loadPagamentosPag(int numSub) throws IOException {
        // Carregar o arquivo FXML
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/javafx/Rececionista/show_pagamentos.fxml"));
        Parent root = fxmlLoader.load();

        // Obter o controlador para a página de participantes
        show_pagamentos pagamentosController = fxmlLoader.getController();

        // Passar o ID do aulagrupo para o controlador da página de participantes
        pagamentosController.setSubscricaoId(numSub);
        pagamentosController.loadData(numSub);

        // Criar uma nova janela para exibir a página de participantes
        Stage stage = new Stage();
        stage.setTitle("Pagamentos");
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void criarSub() {
        Subscricao sub = new Subscricao();
        Cliente cli = clienteDAO.getById(Integer.parseInt(nCliSubCriar.getText()));

        // Verificar se os campos obrigatórios foram preenchidos
        if (nCliSubCriar.getText().isEmpty() || dtIniSubCriar.getValue() == null || valSubCriar.getText().isEmpty()) {
            erroSub.setText("Todos os campos devem ser preenchidos!");
            return;
        }

        List<Subscricao> subscricoesAtivas = subsDAO.getSubscricoesAtivasByCliente(cli);
        if (!subscricoesAtivas.isEmpty()) {
            erroSub.setText("O cliente já tem uma subscrição ativa!");
            return;
        }

        // Verificar se a data de início é igual ou após a data atual
        LocalDate dataAtual = LocalDate.now();
        LocalDate dataInicio = dtIniSubCriar.getValue();
        if (dataInicio.isBefore(dataAtual)) {
            erroSub.setText("Data de início igual ou após a data atual!");
            return;
        }

        // Verificar se o valor é maior que zero
        BigDecimal valorSubscricao;
        try {
            valorSubscricao = new BigDecimal(valSubCriar.getText());
        } catch (NumberFormatException e) {
            erroSub.setText("O valor da subscrição deve ser um número válido!");
            return;
        }
        if (valorSubscricao.compareTo(BigDecimal.ZERO) <= 0) {
            erroSub.setText("O valor da subscrição deve ser maior que zero!");
            return;
        }

        int novoID = subsDAO.getID() + 1; // Obter o próximo ID disponível
        sub.setNumSubscricao(novoID);
        sub.setDataIni(dataInicio);
        sub.setDataFim(dataInicio.plusYears(1));
        sub.setEstado("Ativa");
        sub.setValor(valorSubscricao);
        sub.setCliente(cli);

        subsDAO.save(sub);
    }

    @FXML
    protected void desativarSub() {
        Subscricao sub = subsDAO.getByNumSubscricao(Integer.parseInt(nSubEdit.getText()));
        List<Pagamento> pag = pagDAO.getAllById(Integer.parseInt(nSubEdit.getText()));

        if(nSubEdit.getText().isEmpty()) {
            erroSub.setText("Tem de especificar uma subscrição!");
            return;
        }
        for (Pagamento pagamento : pag) {
            if ("Por realizar".equals(pagamento.getEstado())) {
                erroSub.setText("Contem pagamentos por realizar!");
                return;
            }
        }
        sub.setEstado("Inativa");
        subsDAO.update(sub);
        nSubEdit.clear();
        loadSubscricoes();
        erroSub.setText("");
    }

    @FXML
    protected void ativarSub() {
        String numSubscricao = nSubEdit.getText();

        if (numSubscricao.isEmpty()) {
            erroSub.setText("Tem de especificar uma subscrição!");
            return;
        }

        Subscricao sub = subsDAO.getByNumSubscricao(Integer.parseInt(numSubscricao));
        Cliente cliente = sub.getCliente();

        // Consultar todas as subscrições ativas do cliente
        List<Subscricao> subscricoesAtivas = subsDAO.getSubscricoesAtivasByCliente(cliente);

        // Verificar se existem outras subscrições ativas
        if (subscricoesAtivas.size() > 1) {
            erroSub.setText("O cliente já tem uma subscrição ativa!");
            return;
        }

        sub.setEstado("Ativa");
        subsDAO.update(sub);
        nSubEdit.clear();
        loadSubscricoes();
        erroSub.setText("");
    }


//  *******************
//  Clientes
//  *******************

    @FXML
    public void loadClientes() {
        List<Cliente> cli = clienteDAO.getAll();

        nCliTbl.setCellValueFactory(new PropertyValueFactory<>("idCliente"));
        nomeCliTbl.setCellValueFactory(new PropertyValueFactory<>("nome"));
        dtnscCliTbl.setCellValueFactory(new PropertyValueFactory<>("dataNascimento"));
        cpCliTbl.setCellValueFactory(new PropertyValueFactory<>("codigoPostal"));
        nifcliTbl.setCellValueFactory(new PropertyValueFactory<>("nif"));
        mailCliTbl.setCellValueFactory(new PropertyValueFactory<>("email"));
        tlmCliTbl.setCellValueFactory(new PropertyValueFactory<>("telemovel"));

        tblClientes.setItems(FXCollections.observableArrayList(cli));
    }

    public void refreshClientes() {
        loadClientes();
    }

    @FXML
    protected void addCli() throws IOException {
        // Carregar o arquivo FXML
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/javafx/Rececionista/criar_clientes.fxml"));
        Parent root = fxmlLoader.load();

        // Criar uma nova janela para exibir a página de participantes
        Stage stage = new Stage();
        stage.setTitle("Clientes");
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    protected void deleteCli() {
        if (nCliDelete.getText().isEmpty()) {
            errorCli.setText("Especifique um cliente!");
        } else {
            clienteDAO.delete(Integer.parseInt(nCliDelete.getText()));
            nCliDelete.clear(); loadClientes();
            errorCli.setText("");
        }
    }

//  *******************
//  Perfil
//  *******************

    public void setUserId(Integer id) { this.idUserAtual = id; }

    @FXML
    public void loadPerfil(int iduser) {
        Funcionario f = funcionarioDAO.getById(iduser);
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
        Funcionario func = funcionarioDAO.getById(idUserAtual);

        if(newNome.getText().isEmpty() && newPass.getText().isEmpty() && newTele.getText().isEmpty()) {
            errorPerfil.setText("Prencha pelo menos um campo!");
        } else {
            if (!newNome.getText().isEmpty()) { func.setNome(newNome.getText()); newNome.clear();}
            if (!newPass.getText().isEmpty()) { func.setPassword(newPass.getText()); newPass.clear();}
            if (!newTele.getText().isEmpty()) { func.setTelemovel(newTele.getText()); newTele.clear();}
            funcionarioDAO.update(func);
            loadPerfil(idUserAtual);
        }
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
