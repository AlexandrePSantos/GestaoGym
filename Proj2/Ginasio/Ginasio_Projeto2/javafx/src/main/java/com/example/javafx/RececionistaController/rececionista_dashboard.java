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

    // Perfil
    @FXML
    public Label nomeLbl, dnLbl, tlmLbl, psswdLbl, funcLbl, nifLbl, mailLbl, slLbl;
    @FXML
    public TextField newPass, newTele, newNome;

    protected int idUserAtual;

    AulagrupoDAO aulagrupoDAO = new AulagrupoDAO();
    FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
    SubscricaoDAO subsDAO = new SubscricaoDAO();
    ClienteDAO clienteDAO = new ClienteDAO();

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

    public void refreshAulas(ActionEvent event) {
        loadAulasAgendadas();
        loadAulasRealizadas();
    }

    //DONE
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

    //DONE
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

    //DONE
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

    public void criarSub(ActionEvent event) {
        Subscricao sub = new Subscricao();
        Cliente cli= clienteDAO.getById(Integer.parseInt(nCliSubCriar.getText()));

        //se o cliente já tem uma ativa não deixa
        sub.setDataIni(dtIniSubCriar.getValue());
        sub.setDataFim(dtIniSubCriar.getValue().plusYears(1));
        sub.setEstado("Ativa");
        sub.setValor(BigDecimal.valueOf(Integer.parseInt(valSubCriar.getText())));
        sub.setCliente(cli);

        subsDAO.save(sub);
    }

    //DONE
    @FXML
    protected void desativarSub() {
        Subscricao sub = subsDAO.getByNumSubscricao(Integer.parseInt(nSubEdit.getText()));
        sub.setEstado("Inativa");
        subsDAO.update(sub);
        nSubEdit.clear(); loadSubscricoes();
//    protected Label erroSub; CRIAR A CONDIÇÃO DE ERRO
    }

    //DONE
    @FXML
    protected void ativarSub() {
        Subscricao sub = subsDAO.getByNumSubscricao(Integer.parseInt(nSubEdit.getText()));
        sub.setEstado("Ativa");
        subsDAO.update(sub);
        nSubEdit.clear(); loadSubscricoes();
//    protected Label erroSub; CRIAR A CONDIÇÃO DE ERRO
    }

//  *******************
//  Clientes
//  *******************

    //DONE
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

    public void refreshClientes(ActionEvent event) {
        loadClientes();
    }

    //DONE
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

    //DONE
    @FXML
    protected void deleteCli() {
        clienteDAO.delete(Integer.parseInt(nCliDelete.getText()));
        nCliDelete.clear(); loadClientes();
    }

//  *******************
//  Perfil -- FALTA BLL
//  *******************

    //DONE
    public void setUserId(Integer id) { this.idUserAtual = id; }

    //DONE
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

    //TODO - restrições como password fraca e telemovel com minimo tamanho e a começar em determinados valores
    @FXML
    protected void editarPerfil() {
        Funcionario f = funcionarioDAO.getById(idUserAtual);
        // Verifique se o número da aula é válido
        if (idUserAtual <= 0) { System.out.println("Funcionario inválido"); return; }
        // Verifique cada campo de entrada e, se o campo estiver preenchido, atualize o valor correspondente na aula existente
        if (!newNome.getText().isEmpty()) { f.setNome(newNome.getText()); } newNome.clear();
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
