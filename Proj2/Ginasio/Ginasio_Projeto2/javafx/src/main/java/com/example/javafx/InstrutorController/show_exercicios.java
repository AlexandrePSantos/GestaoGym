package com.example.javafx.InstrutorController;

import com.AcessoBD.repository.entities.*;
import com.AcessoBD.DAO.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.math.BigDecimal;
import java.util.List;

public class show_exercicios {
    // Tabela
    public TableView<Linhaexercicio> tblExerciciosPlan;
    public TableColumn<Linhaexercicio, Integer> nExPlan;
    public TableColumn<Linhaexercicio, String> nomeExPlan;
    public TableColumn<Linhaexercicio, String> equipExPlan;
    public TableColumn<Linhaexercicio, Integer> setsExPlan;
    public TableColumn<Linhaexercicio, Integer> repsExPlan;
    public TableColumn<Linhaexercicio, Integer> pesoExPlan;
    public TableColumn<Linhaexercicio, Integer> durExPlan;
    public TableColumn<Linhaexercicio, Integer> velExPlan;

    // Remover
    public TextField rmExPlan;

    // Editar
    public TextField numEditExPlan, editSetPlan, editRepPlan, editPesoPlan, editDurPlan, editVelPlan;

    // Criar
    public ChoiceBox<Exercicio> addExnomePlan;
    public TextField addSetPlan, AddRepPlan, addPesoPlan, addDurPlan, addVelPlan;

    public int idEx;

    ExercicioDAO exDao = new ExercicioDAO();
    Linhaexercicio le = new Linhaexercicio();
    LinhaexercicioDAO leDAO = new LinhaexercicioDAO();

    protected void setPlanoId(int planoId) {
        this.idEx = planoId;
    }

    protected void loadData(int id) {
        List<Linhaexercicio> exercicios = leDAO.getAllById(id);

        nExPlan.setCellValueFactory(new PropertyValueFactory<>("idLinhaExercicio"));
        nomeExPlan.setCellValueFactory(cellData -> {
            Linhaexercicio linhaEx = cellData.getValue();
            Exercicio exer = exDao.getById(linhaEx.getExercicio().getIdExercicio());
            return new SimpleStringProperty(exer.getNome());
        });
        equipExPlan.setCellValueFactory(cellData -> {
            Linhaexercicio linhaEx = cellData.getValue();
            Exercicio exer = exDao.getById(linhaEx.getExercicio().getIdExercicio());
            return new SimpleStringProperty(exer.getEquipamento());
        });
        setsExPlan.setCellValueFactory(new PropertyValueFactory<>("sets"));
        repsExPlan.setCellValueFactory(new PropertyValueFactory<>("reps"));
        pesoExPlan.setCellValueFactory(new PropertyValueFactory<>("peso"));
        durExPlan.setCellValueFactory(new PropertyValueFactory<>("duracao"));
        velExPlan.setCellValueFactory(new PropertyValueFactory<>("velocidade"));

        tblExerciciosPlan.setItems(FXCollections.observableArrayList(exercicios));
    }

    @FXML
    protected void addEx(ActionEvent event) {
        le.setExercicio(addExnomePlan.getValue());
        String setPlanText = addSetPlan.getText();
        le.setSets(setPlanText.isEmpty() ? -1 : Integer.parseInt(setPlanText));
        String repPlanText = AddRepPlan.getText();
        le.setReps(repPlanText.isEmpty() ? -1 : Integer.parseInt(repPlanText));
        String pesoPlanText = addPesoPlan.getText();
        le.setPeso(pesoPlanText.isEmpty() ? BigDecimal.valueOf(-1) : BigDecimal.valueOf(Integer.parseInt(pesoPlanText)));
        String durPlanText = addDurPlan.getText();
        le.setDuracao(durPlanText.isEmpty() ? BigDecimal.valueOf(-1) : BigDecimal.valueOf(Integer.parseInt(durPlanText)));
        String velPlanText = addVelPlan.getText();
        le.setVelocidade(velPlanText.isEmpty() ? -1 : Integer.parseInt(velPlanText));

        addSetPlan.clear(); AddRepPlan.clear(); addPesoPlan.clear(); addDurPlan.clear(); addVelPlan.clear();

        leDAO.save(le); loadData(idEx);
    }

    @FXML
    protected void removeEx(ActionEvent event) {
        leDAO.delete(Integer.parseInt(rmExPlan.getText()));
        loadData(idEx); rmExPlan.clear();
    }

    @FXML
    protected void editEx(ActionEvent event) {
        le = leDAO.getById(Integer.parseInt(numEditExPlan.getText()));

        if(!editSetPlan.getText().isEmpty()) {le.setSets(Integer.parseInt(editSetPlan.getText()));} editSetPlan.clear();
        if(!editRepPlan.getText().isEmpty()) {le.setReps(Integer.parseInt(editRepPlan.getText()));} editRepPlan.clear();
        if(!editPesoPlan.getText().isEmpty()) {le.setPeso(BigDecimal.valueOf(Integer.parseInt(editPesoPlan.getText())));} editPesoPlan.clear();
        if(!editDurPlan.getText().isEmpty()) {le.setDuracao(BigDecimal.valueOf(Integer.parseInt(editDurPlan.getText())));} editDurPlan.clear();
        if(!editVelPlan.getText().isEmpty()) {le.setVelocidade(Integer.parseInt(editVelPlan.getText()));} editVelPlan.clear();

        leDAO.update(le); loadData(idEx);
    }
}
