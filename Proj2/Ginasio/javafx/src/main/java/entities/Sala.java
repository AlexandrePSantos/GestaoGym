package entities;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "sala")
public class Sala {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idsala", nullable = false)
    private Integer id;

    @Column(name = "sala", length = 50)
    private String sala;

    @OneToMany(mappedBy = "idsala")
    private Set<Aulagrupo> aulagrupos = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public Set<Aulagrupo> getAulagrupos() {
        return aulagrupos;
    }

    public void setAulagrupos(Set<Aulagrupo> aulagrupos) {
        this.aulagrupos = aulagrupos;
    }

}