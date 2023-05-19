package com.AcessoBD.repository.entities;

import javax.persistence.*;

@Entity
@Table(name = "Sala")
public class Sala {

    @Id
    @Column(name = "id_sala", unique = true)
    private String idSala;

    public Sala() {
    }

    public Sala(String id_sala) {
        this.idSala = id_sala;
    }

    public String getIdSala() {
        return idSala;
    }

    public void setIdSala(String idSala) {
        this.idSala = idSala;
    }

    @Override
    public String toString() {
        return idSala;
    }
}
