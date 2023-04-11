package entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Sala {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idsala", nullable = false)
    private int idsala;
    @Basic
    @Column(name = "sala", nullable = true, length = 50)
    private String sala;
    @OneToMany(mappedBy = "salaByIdsala")
    private Collection<Aulagrupo> aulagruposByIdsala;

    public int getIdsala() {
        return idsala;
    }

    public void setIdsala(int idsala) {
        this.idsala = idsala;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sala sala1 = (Sala) o;

        if (idsala != sala1.idsala) return false;
        if (sala != null ? !sala.equals(sala1.sala) : sala1.sala != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idsala;
        result = 31 * result + (sala != null ? sala.hashCode() : 0);
        return result;
    }

    public Collection<Aulagrupo> getAulagruposByIdsala() {
        return aulagruposByIdsala;
    }

    public void setAulagruposByIdsala(Collection<Aulagrupo> aulagruposByIdsala) {
        this.aulagruposByIdsala = aulagruposByIdsala;
    }
}
