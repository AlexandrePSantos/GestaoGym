package com.example.javafx.AdministradorController;

import com.AcessoBD.repository.entities.*;
import com.AcessoBD.DAO.*;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class administrador_dashboard {
    // Perfil
    public Label nomeLbl, dnLbl, tlmLbl, psswdLbl, funcLbl, nifLbl, mailLbl;
    public TextField newNome, newPass, newTele;
    public Label errorPerfil;
    // Clientes
    public TableView<Cliente> tblClientes;
    public TableColumn<Cliente, Integer> nCliTbl;
    public TableColumn<Cliente, String> nomeCliTbl;
    public TableColumn<Cliente, String> emailCliTbl;
    public TableColumn<Cliente, String> tlmCliTbl;
    public TableColumn<Cliente, LocalDate> dtCliTbl;
    public TableColumn<Cliente, String> nifCliTbl;
    public TableColumn<Cliente, String> cpCliTbl;
    public TextField nCliDelete;
    public TextField nCliEdit, nomeCliEdit, emailCliEdit, tlmCliEdit, nifCliEdit, cpCliEdit;
    public DatePicker dtCliEdit;
    public TextField nomeCliAdd, emailCliAdd, tlmCliAdd, nifCliAdd, cpCliAdd;
    public DatePicker dtCliAdd;
    public Label errorClientes;
    // Funcionários
    public TableView<Funcionario> tblFuncionarios;
    public TableColumn<Funcionario, Integer> nFuncTbl;
    public TableColumn<Funcionario, String> nomeFuncTbl;
    public TableColumn<Funcionario, String> emailFuncTbl;
    public TableColumn<Funcionario, String> tlmFuncTbl;
    public TableColumn<Funcionario, LocalDate> dtFuncTbl;
    public TableColumn<Funcionario, String> nifFuncTbl;
    public TableColumn<Funcionario, BigDecimal> salFuncTbl;
    public TableColumn<Funcionario, String> funcFuncTbl;
    public TextField nFuncDelete;
    public TextField nFuncEdit, nomeFuncEdit, emailFuncEdit, tlmFuncEdit, nifFuncEdit, salarioFuncEdit, funcaoFuncEdit;
    public DatePicker dtFuncEdit;
    public TextField nomeFuncAdd, emailFuncAdd, tlmFuncAdd, nifFuncAdd, salarioFuncAdd, funcaoFuncAdd;
    public DatePicker dtFuncAdd;
    public Label errorFuncionarios;
    // Outras
    public int idUserAtual;
    Cliente cli = new Cliente();
    Funcionario func = new Funcionario();
    ClienteDAO cliDAO = new ClienteDAO();
    FuncionarioDAO funcDAO = new FuncionarioDAO();

    @FXML
    protected void initialize() {
        loadClientes();
        loadFuncionarios();
    }
    public void setUserId(Integer id) { this.idUserAtual = id; }

//  *******************
//  Clientes e Funcionários
//  *******************
    @FXML
    public void refreshClientes() {
        loadClientes();
    }
    @FXML
    public void refreshFuncionarios() {
        loadFuncionarios();
    }

    @FXML
    public void loadClientes() {
        List<Cliente> cli = cliDAO.getAll();

        nCliTbl.setCellValueFactory(new PropertyValueFactory<>("idCliente"));
        nomeCliTbl.setCellValueFactory(new PropertyValueFactory<>("nome"));
        dtCliTbl.setCellValueFactory(new PropertyValueFactory<>("dataNascimento"));
        cpCliTbl.setCellValueFactory(new PropertyValueFactory<>("codigoPostal"));
        nifCliTbl.setCellValueFactory(new PropertyValueFactory<>("nif"));
        emailCliTbl.setCellValueFactory(new PropertyValueFactory<>("email"));
        tlmCliTbl.setCellValueFactory(new PropertyValueFactory<>("telemovel"));

        tblClientes.setItems(FXCollections.observableArrayList(cli));
    }
    @FXML
    public void loadFuncionarios() {
        List<Funcionario> func = funcDAO.getAll();

        nFuncTbl.setCellValueFactory(new PropertyValueFactory<>("id"));
        nomeFuncTbl.setCellValueFactory(new PropertyValueFactory<>("nome"));
        dtFuncTbl.setCellValueFactory(new PropertyValueFactory<>("dataNascimento"));
        emailFuncTbl.setCellValueFactory(new PropertyValueFactory<>("email"));
        tlmFuncTbl.setCellValueFactory(new PropertyValueFactory<>("telemovel"));
        nifFuncTbl.setCellValueFactory(new PropertyValueFactory<>("nif"));
        salFuncTbl.setCellValueFactory(new PropertyValueFactory<>("salarioLiquido"));
        funcFuncTbl.setCellValueFactory(new PropertyValueFactory<>("funcao"));

        tblFuncionarios.setItems(FXCollections.observableArrayList(func));
    }

    @FXML
    public void addCli() {
        errorClientes.setText(""); // Limpa a mensagem de erro anterior, se houver

        if (nomeCliAdd.getText().isEmpty() || dtCliAdd.getValue() == null || emailCliAdd.getText().isEmpty() ||
                tlmCliAdd.getText().isEmpty() || nifCliAdd.getText().isEmpty() || cpCliAdd.getText().isEmpty()) {
            errorClientes.setText("Tem de preencher todos os campos!");
            return;
        }

        // Obter o próximo ID disponível
        int novoID = cliDAO.getID() + 1;

        cli.setIdCliente(novoID);
        cli.setNome(nomeCliAdd.getText());
        nomeCliAdd.clear();
        cli.setDataNascimento(dtCliAdd.getValue());
        cli.setEmail(emailCliAdd.getText());
        emailCliAdd.clear();
        cli.setTelemovel(tlmCliAdd.getText());
        tlmCliAdd.clear();
        cli.setNif(nifCliAdd.getText());
        nifCliAdd.clear();
        cli.setCodigoPostal(cpCliAdd.getText());
        cpCliAdd.clear();
        cli.setPassword("default");

        cliDAO.create(cli);
        loadClientes();
        errorClientes.setText("");
    }

    @FXML
    public void addFunc() {
        errorFuncionarios.setText(""); // Limpa a mensagem de erro anterior, se houver

        if (nomeFuncAdd.getText().isEmpty() || dtFuncAdd.getValue() == null || emailFuncAdd.getText().isEmpty() ||
                tlmFuncAdd.getText().isEmpty() || nifFuncAdd.getText().isEmpty() || salarioFuncAdd.getText().isEmpty() ||
                funcaoFuncAdd.getText().isEmpty()) {
            errorFuncionarios.setText("Tem de preencher todos os campos!");
            return;
        }

        // Obter o próximo ID disponível
        int novoID = funcDAO.getID() + 1;

        func.setId(novoID);
        func.setNome(nomeFuncAdd.getText());
        nomeFuncAdd.clear();
        func.setDataNascimento(dtFuncAdd.getValue());
        func.setEmail(emailFuncAdd.getText());
        emailFuncAdd.clear();
        func.setTelemovel(tlmFuncAdd.getText());
        tlmFuncAdd.clear();
        func.setNif(nifFuncAdd.getText());
        nifFuncAdd.clear();
        func.setSalarioLiquido(BigDecimal.valueOf(Integer.parseInt(salarioFuncAdd.getText())));
        salarioFuncAdd.clear();
        func.setFuncao(funcaoFuncAdd.getText());
        funcaoFuncAdd.clear();
        func.setPassword("default");

        funcDAO.create(func);
        loadFuncionarios();
    }


    @FXML
    public void editCli() {
        if (nCliEdit.getText().isEmpty()) {
            errorClientes.setText("Especifique um cliente!");
            return; // Terminar o método aqui para evitar exceções desnecessárias
        } else {
            cli = cliDAO.getById(Integer.parseInt(nCliEdit.getText()));
            nCliEdit.clear();

            if (!nomeCliEdit.getText().isEmpty()) {
                cli.setNome(nomeCliEdit.getText());
            }
            nomeCliEdit.clear();
            if (!emailCliEdit.getText().isEmpty()) {
                cli.setEmail(emailCliEdit.getText());
            }
            emailCliEdit.clear();
            if (!tlmCliEdit.getText().isEmpty()) {
                cli.setTelemovel(tlmCliEdit.getText());
            }
            tlmCliEdit.clear();
            if (dtCliEdit.getValue() != null) {
                cli.setDataNascimento(dtCliEdit.getValue());
            }
            if (!nifCliEdit.getText().isEmpty()) {
                cli.setNif(nifCliEdit.getText());
            }
            nifCliEdit.clear();
            if (!cpCliEdit.getText().isEmpty()) {
                cli.setCodigoPostal(cpCliEdit.getText());
            }
            cpCliEdit.clear();
            cliDAO.update(cli);
            loadClientes();
            errorClientes.setText("");
        }
    }
    @FXML
    public void editFunc() {
        if (nFuncEdit.getText().isEmpty()) {
            errorFuncionarios.setText("Especifique um funcionário!");
            errorFuncionarios.setText("");
            return; // Terminar o método aqui para evitar exceções desnecessárias
        } else {
            func = funcDAO.getById(Integer.parseInt(nFuncEdit.getText())); nFuncEdit.clear();
            if (!nomeFuncEdit.getText().isEmpty()) {
                func.setNome(nomeFuncEdit.getText());
            }
            nomeFuncEdit.clear();
            if (!emailFuncEdit.getText().isEmpty()) {
                func.setEmail(emailFuncEdit.getText());
            }
            emailFuncEdit.clear();
            if (!tlmFuncEdit.getText().isEmpty()) {
                func.setTelemovel(tlmFuncEdit.getText());
            }
            tlmFuncEdit.clear();
            if (dtFuncEdit.getValue() != null) {
                func.setDataNascimento(dtFuncEdit.getValue());
            }
            if (!nifFuncEdit.getText().isEmpty()) {
                func.setNif(nifFuncEdit.getText());
            }
            nifFuncEdit.clear();
            if (!salarioFuncEdit.getText().isEmpty()) {
                func.setSalarioLiquido(BigDecimal.valueOf(Integer.parseInt(salarioFuncEdit.getText())));
            }
            salarioFuncEdit.clear();
            if (!funcaoFuncEdit.getText().isEmpty()) {
                func.setFuncao(funcaoFuncEdit.getText());
            }
            funcaoFuncEdit.clear();
            funcDAO.update(func);
            loadFuncionarios();
            errorFuncionarios.setText("");
        }
    }

    @FXML
    public void deleteCli() {
        if (nCliDelete.getText().isEmpty()) {
            errorClientes.setText("Especifique um cliente!");
            return; // Terminar o método aqui para evitar exceções desnecessárias
        } else {
            cliDAO.delete(Integer.parseInt(nCliDelete.getText()));
            nCliDelete.clear();
            loadClientes();
            errorClientes.setText("");
        }
    }
    @FXML
    public void deleteFunc() {
        if (nFuncDelete.getText().isEmpty()) {
            errorFuncionarios.setText("Especifique um funcionário!");
            return; // Terminar o método aqui para evitar exceções desnecessárias
        } else if (funcDAO.getById(Integer.parseInt(nFuncDelete.getText())).equals(idUserAtual)){
            errorFuncionarios.setText("Não pode apagar o próprio perfil!");
            return; // Terminar o método aqui para evitar exceções desnecessárias
        } else {
            funcDAO.delete(Integer.parseInt(nFuncDelete.getText()));
            nFuncDelete.clear();
            loadFuncionarios();
            errorFuncionarios.setText("");
        }
    }

//  *******************
//  Perfil
//  *******************
    @FXML
    public void loadPerfil(int iduser) {
        Funcionario f = funcDAO.getById(iduser);
        if (f != null) {
            nomeLbl.setText("" + f.getNome());
            dnLbl.setText("" + f.getDataNascimento());
            tlmLbl.setText("" + f.getTelemovel());
            psswdLbl.setText("" + f.getPassword());
            funcLbl.setText("" + f.getFuncao());
            nifLbl.setText("" + f.getNif());
            mailLbl.setText("" + f.getEmail());
        }
    }

    @FXML
    public void editarPerfil() {
        func = funcDAO.getById(idUserAtual);

        if(newNome.getText().isEmpty() && newPass.getText().isEmpty() && newTele.getText().isEmpty()) {
            errorPerfil.setText("Prencha pelo menos um campo!");
        } else {
            if (!newNome.getText().isEmpty()) { func.setNome(newNome.getText()); newNome.clear();}
            if (!newPass.getText().isEmpty()) { func.setPassword(newPass.getText()); newPass.clear();}
            if (!newTele.getText().isEmpty()) { func.setTelemovel(newTele.getText()); newTele.clear();}
            funcDAO.update(func);
            loadPerfil(idUserAtual);
        }
    }

//  *******************
//  Outros
//  *******************
    @FXML
    public void showSubscricoes() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/javafx/Administrador/show_subscricoes.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Subscrições");
        stage.setScene(new Scene(root));
        stage.show();
    }
    @FXML
    public void showPagamentos() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/javafx/Administrador/show_pagamento.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Pagamentos");
        stage.setScene(new Scene(root));
        stage.show();
    }
    @FXML
    public void showPlanosTreino() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/javafx/Administrador/show_planos.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Planos de Treino");
        stage.setScene(new Scene(root));
        stage.show();
    }
    @FXML
    public void showAulasGrupo() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/javafx/Administrador/show_aulas.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Aulas de Grupo");
        stage.setScene(new Scene(root));
        stage.show();
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
