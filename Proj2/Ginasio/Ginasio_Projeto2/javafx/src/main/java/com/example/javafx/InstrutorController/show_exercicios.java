package com.example.javafx.InstrutorController;

import com.AcessoBD.repository.entities.*;
import com.AcessoBD.DAO.*;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.List;

public class show_exercicios {
    // Tabela
    public TableView<Linhaparticipante> tblExerciciosPlan;
    public TableColumn<Linhaparticipante, Integer> nExPlan;
    public TableColumn<Exercicio, String> nomeExPlan;
    public TableColumn<Exercicio, String> equipExPlan;
    public TableColumn<Linhaparticipante, Integer> setsExPlan;
    public TableColumn<Linhaparticipante, Integer> repsExPlan;
    public TableColumn<Linhaparticipante, Integer> pesoExPlan;
    public TableColumn<Linhaparticipante, Integer> durExPlan;
    public TableColumn<Linhaparticipante, Integer> velExPlan;

    // Remover
    public ChoiceBox<Exercicio> rmExPlan;
    public Button removeExPlan;

    // Editar
    public ChoiceBox<Exercicio> editExnomePlan;
    public TextField editSetPlan, editRepPlan, editPesoPlan, editDurPlan, editVelPlan;
    public Button editExPlan;

    // Criar
    public ChoiceBox<Exercicio> addExnomePlan;
    public TextField addSetPlan, AddRepPlan, addPesoPlan, addDurPlan, addVelPlan;
    public Button addExPlan;

    public int idEx;

    Exercicio ex = new Exercicio();
    ExercicioDAO exDao = new ExercicioDAO();
    Linhaexercicio le = new Linhaexercicio();
    LinhaexercicioDAO leDAO = new LinhaexercicioDAO();

    protected void setPlanoId(int planoId) {
        this.idEx = planoId;
    }

    protected void loadData(int id) {
        List<Linhaexercicio> exercicios = leDAO.getAllById(id);

//        nExPlan.setCellValueFactory(cellData -> {
//            Cliente cliente = cellData.getValue().getCliente();
//            Integer numeroCliente = cliente.getIdCliente();
//            return new SimpleIntegerProperty(numeroCliente).asObject();
//        });
//        nomeExPlan.setCellValueFactory(cellData -> {
//            Linhaparticipante linhaparticipante = cellData.getValue();
//            Cliente cliente = cliDAO.getById(linhaparticipante.getCliente().getIdCliente());
//            return new SimpleObjectProperty<>(cliente);
//        });
//        equipExPlan.setCellValueFactory(cellData -> {
//            Linhaparticipante linhaparticipante = cellData.getValue();
//            Cliente cliente = cliDAO.getById(linhaparticipante.getCliente().getIdCliente());
//            return new SimpleObjectProperty<>(cliente);
//        });

//        setsExPlan
//        repsExPlan
//        pesoExPlan
//        durExPlan
//        velExPlan

//        tblExerciciosPlan.setItems(FXCollections.observableArrayList(exercicios));
    }

    @FXML
    protected void addEx(ActionEvent event) {
        // ...
        loadData(idEx);
    }

    @FXML
    protected void removeEx(ActionEvent event) {
        // ...
        loadData(idEx);
    }

    @FXML
    protected void editEx(ActionEvent event) {
        // ...
        loadData(idEx);
    }

}
