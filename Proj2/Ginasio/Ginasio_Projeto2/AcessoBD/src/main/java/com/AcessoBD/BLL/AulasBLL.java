package com.AcessoBD.BLL;

import com.AcessoBD.DAO.AulagrupoDAO;
import com.AcessoBD.repository.entities.Aulagrupo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AulasBLL {
    private AulagrupoDAO aulagrupoDAO;

    public AulasBLL(AulagrupoDAO aulagrupoDAO) {
        this.aulagrupoDAO = aulagrupoDAO;
    }

    public List<Aulagrupo> getAulasRealizadas() {
        LocalDate currentDate = LocalDate.now();
        List<Aulagrupo> allAulas = aulagrupoDAO.getAll();
        List<Aulagrupo> aulasRealizadas = new ArrayList<>();

        for (Aulagrupo aula : allAulas) {
            if (aula.getDataAula().isBefore(currentDate)) {
                aulasRealizadas.add(aula);
            }
        }

        return aulasRealizadas;
    }

    public List<Aulagrupo> getAulasPlaneadas() {
        LocalDate currentDate = LocalDate.now();
        List<Aulagrupo> allAulas = aulagrupoDAO.getAll();
        List<Aulagrupo> aulasPlaneadas = new ArrayList<>();

        for (Aulagrupo aula : allAulas) {
            if (aula.getDataAula().isAfter(currentDate)) {
                aulasPlaneadas.add(aula);
            }
        }

        return aulasPlaneadas;
    }

}
