package com.bd.DAL;

import javax.persistence.*;

@Entity
@Table(name = "CODPOSTAIS")
@NamedQueries({
        @NamedQuery(name = "CodPostais.findAll", query = "SELECT c FROM Codpostais c"),
        @NamedQuery(name = "CodPostais.findBycod", query = "SELECT c FROM Codpostais c WHERE c.codpostal = :codpostal"),
        @NamedQuery(name = "CodPostais.findAllByLocalidade", query = "SELECT c FROM Codpostais c WHERE c.localidade LIKE :Localidade"),
})
public class Codpostais {
    private int codpostal;
    private String localidade;

    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "CODPOSTAL", nullable = false, precision = 0)
    public int getCodpostal() {
        return codpostal;
    }

    public void setCodpostal(int codpostal) {
        this.codpostal = codpostal;
    }

    @Basic
    @Column(name = "LOCALIDADE", nullable = false, length = 100)
    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Codpostais that = (Codpostais) o;

        if (codpostal != that.codpostal) return false;
        if (localidade != null ? !localidade.equals(that.localidade) : that.localidade != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = codpostal;
        result = 31 * result + (localidade != null ? localidade.hashCode() : 0);
        return result;
    }
}
