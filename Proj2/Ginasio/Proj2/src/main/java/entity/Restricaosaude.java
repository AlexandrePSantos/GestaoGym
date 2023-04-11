package entity;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Restricaosaude {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idrestricao", nullable = false)
    private int idrestricao;
    @Basic
    @Column(name = "descricao", nullable = true, length = 200)
    private String descricao;
    @OneToMany(mappedBy = "restricaosaudeByIdrestricao")
    private Collection<Linharestricao> linharestricaosByIdrestricao;

    public int getIdrestricao() {
        return idrestricao;
    }

    public void setIdrestricao(int idrestricao) {
        this.idrestricao = idrestricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Restricaosaude that = (Restricaosaude) o;

        if (idrestricao != that.idrestricao) return false;
        if (descricao != null ? !descricao.equals(that.descricao) : that.descricao != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idrestricao;
        result = 31 * result + (descricao != null ? descricao.hashCode() : 0);
        return result;
    }

    public Collection<Linharestricao> getLinharestricaosByIdrestricao() {
        return linharestricaosByIdrestricao;
    }

    public void setLinharestricaosByIdrestricao(Collection<Linharestricao> linharestricaosByIdrestricao) {
        this.linharestricaosByIdrestricao = linharestricaosByIdrestricao;
    }
}
