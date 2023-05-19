package com.AcessoBD.BLL;

import com.AcessoBD.DAO.PlanotreinoDAO;
import com.AcessoBD.repository.entities.Planotreino;

import java.util.ArrayList;
import java.util.List;

public class PlanosBLL {

    private PlanotreinoDAO planotreinoDAO;

    public PlanosBLL(PlanotreinoDAO planotreinoDAO) {
        this.planotreinoDAO = planotreinoDAO;
    }

    public List<Planotreino> getPlanosTreino() {
        List<Planotreino> allPlanos = new ArrayList<>();
        PlanotreinoDAO planotreinoDAO = new PlanotreinoDAO();
        allPlanos = planotreinoDAO.getAll();
        return allPlanos;
    }

}
