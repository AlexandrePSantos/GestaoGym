package com.AcessoBD.BLL;

import com.AcessoBD.DAO.AulagrupoDAO;
import com.AcessoBD.repository.entities.Aulagrupo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AulasBLL {
    private AulagrupoDAO aulagrupoDAO = new AulagrupoDAO();

    public List<Aulagrupo> getAulasRealizadas() {
        List<Aulagrupo> aulas = aulagrupoDAO.getAll();
        List<Aulagrupo> aulasRealizadas = new ArrayList<>();

        LocalDate today = LocalDate.now();
        for (Aulagrupo aula : aulas) {
            if (aula.getDataAula().isBefore(today)) {
                aulasRealizadas.add(aula);
            }
        }

        return aulasRealizadas;
    }

    public List<Aulagrupo> getAulasPlaneadas() {
        List<Aulagrupo> aulas = aulagrupoDAO.getAll();
        List<Aulagrupo> aulasPlaneadas = new ArrayList<>();

        LocalDate today = LocalDate.now();
        for (Aulagrupo aula : aulas) {
            if (aula.getDataAula().isAfter(today)) {
                aulasPlaneadas.add(aula);
            }
        }

        return aulasPlaneadas;
    }

}
