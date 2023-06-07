package com.example.javafx.InstrutorController;

import com.AcessoBD.repository.entities.*;
import com.AcessoBD.DAO.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

    public Label erroEx;

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
    PlanotreinoDAO pDAO = new PlanotreinoDAO();

    protected void loadChoices() {
        List<Exercicio> exs = exDao.getAll();
        ObservableList<Exercicio> options = FXCollections.observableArrayList(exs);
        options.addAll(exs);
        addExnomePlan.setItems(options);
    }

    protected void setPlanoId(int planoId) {
        this.idEx = planoId;
    }

    protected void loadData(int id) {
        List<Linhaexercicio> exercicios = leDAO.getAllById(id);

        loadChoices();
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
        Planotreino p = pDAO.getById(idEx);
        Exercicio nomeExercicio = addExnomePlan.getValue();
        Exercicio selectedExercicio = exDao.getById(nomeExercicio.getIdExercicio());
        if (nomeExercicio == null) {
            // Verificar se o campo addExnomePlan está vazio
            erroEx.setText("Nome do exercício não foi especificado!");
            return;
        }

        // Verificar se pelo menos uma das restrições é atendida
        boolean hasRepsSets = !addSetPlan.getText().isEmpty() && !AddRepPlan.getText().isEmpty();
        boolean hasDuracao = !addDurPlan.getText().isEmpty();
        boolean hasVelocidadeDuracao = !addVelPlan.getText().isEmpty() && !addDurPlan.getText().isEmpty();
        if (!hasRepsSets && !hasDuracao && !hasVelocidadeDuracao) {
            // Nenhuma das restrições é atendida
            erroEx.setText("Pelo menos uma das restrições deve ser atendida: reps/sets, duração ou velocidade/duração.");
            return;
        }

        // Verificar se os valores são maiores ou iguais a zero
        int sets = addSetPlan.getText().isEmpty() ? -1 : Integer.parseInt(addSetPlan.getText());
        int reps = AddRepPlan.getText().isEmpty() ? -1 : Integer.parseInt(AddRepPlan.getText());
        BigDecimal peso = addPesoPlan.getText().isEmpty() ? BigDecimal.valueOf(-1) : BigDecimal.valueOf(Integer.parseInt(addPesoPlan.getText()));
        BigDecimal duracao = addDurPlan.getText().isEmpty() ? BigDecimal.valueOf(-1) : BigDecimal.valueOf(Integer.parseInt(addDurPlan.getText()));
        int velocidade = addVelPlan.getText().isEmpty() ? -1 : Integer.parseInt(addVelPlan.getText());

        if (sets < -1 || reps < -1 || velocidade < -1) {
            // Um dos valores é menor que -1
            erroEx.setText("Os valores não podem ser menores que -1.");
            return;
        }
        // Retrieve the new ID using the getID() method
        int newId = leDAO.getID();

        // Set the new ID on the linhaexercicio object
        le.setIdLinhaExercicio(newId);
        le.setExercicio(selectedExercicio);
        le.setSets(sets);
        le.setReps(reps);
        le.setPeso(peso);
        le.setDuracao(duracao);
        le.setVelocidade(velocidade);
        le.setPlanoTreino(p);

        addSetPlan.clear();
        AddRepPlan.clear();
        addPesoPlan.clear();
        addDurPlan.clear();
        addVelPlan.clear();

        leDAO.create(le);
        loadData(idEx);
        erroEx.setText("");
    }

    @FXML
    protected void removeEx(ActionEvent event) {
        String numExercicio = rmExPlan.getText();
        if (numExercicio.isEmpty()) {
            // Verificar se o campo rmExPlan está vazio
            erroEx.setText("Número do exercício não foi especificado!");
            return;
        }

        // Verificar se o exercício existe
        le = leDAO.getById(Integer.parseInt(numExercicio));
        if (le == null) {
            erroEx.setText("Exercício inválido!");
            return;
        }

        leDAO.delete(Integer.parseInt(numExercicio));
        loadData(idEx);
        rmExPlan.clear();
    }


    @FXML
    protected void editEx(ActionEvent event) {
        String numExercicio = numEditExPlan.getText();
        if (numExercicio.isEmpty()) {
            // Verificar se o campo numEditExPlan está vazio
            erroEx.setText("Número do exercício não foi especificado!");
            return;
        }

        le = leDAO.getById(Integer.parseInt(numExercicio));

        // Verificar se pelo menos uma das restrições é atendida
        boolean hasRepsSets = !editRepPlan.getText().isEmpty() && !editSetPlan.getText().isEmpty();
        boolean hasDuracao = !editDurPlan.getText().isEmpty();
        boolean hasVelocidadeDuracao = !editVelPlan.getText().isEmpty() && !editDurPlan.getText().isEmpty();
        if (!hasRepsSets && !hasDuracao && !hasVelocidadeDuracao) {
            // Nenhuma das restrições é atendida
            erroEx.setText("Pelo menos uma das restrições deve ser preenchida: Reps e Sets, Duração ou Velocidade e Duração");
            return;
        }

        // Verificar se os valores são maiores ou iguais a zero
        if (hasRepsSets) {
            int sets = Integer.parseInt(editSetPlan.getText());
            int reps = Integer.parseInt(editRepPlan.getText());
            if (sets < 0 || reps < 0) {
                // Um dos valores é menor que zero
                erroEx.setText("Os valores de Reps e Sets devem ser maiores ou iguais a zero!");
                return;
            }
            le.setSets(sets);
            le.setReps(reps);
        }
        if (hasDuracao) {
            BigDecimal duracao = BigDecimal.valueOf(Integer.parseInt(editDurPlan.getText()));
            if (duracao.compareTo(BigDecimal.ZERO) < 0) {
                // O valor é menor que zero
                erroEx.setText("O valor de Duração deve ser maior ou igual a zero!");
                return;
            }
            le.setDuracao(duracao);
        }
        if (hasVelocidadeDuracao) {
            int velocidade = Integer.parseInt(editVelPlan.getText());
            BigDecimal duracao = BigDecimal.valueOf(Integer.parseInt(editDurPlan.getText()));
            if (velocidade < 0 || duracao.compareTo(BigDecimal.ZERO) < 0) {
                // Um dos valores é menor que zero
                erroEx.setText("Os valores de Velocidade e Duração devem ser maiores ou iguais a zero!");
                return;
            }
            le.setVelocidade(velocidade);
            le.setDuracao(duracao);
        }

        if (!editPesoPlan.getText().isEmpty()) {
            BigDecimal peso = BigDecimal.valueOf(Integer.parseInt(editPesoPlan.getText()));
            if (peso.compareTo(BigDecimal.ZERO) < 0) {
                // O valor é menor que zero
                erroEx.setText("O valor de Peso deve ser maior ou igual a zero!");
                return;
            }
            le.setPeso(peso);
        }

        numEditExPlan.clear();
        editSetPlan.clear();
        editRepPlan.clear();
        editPesoPlan.clear();
        editDurPlan.clear();
        editVelPlan.clear();

        leDAO.update(le);
        loadData(idEx);
        erroEx.setText("");
    }

}
