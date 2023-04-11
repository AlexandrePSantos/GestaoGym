package entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Entity
public class Cliente {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idcliente", nullable = false)
    private int idcliente;
    @Basic
    @Column(name = "nome", nullable = true, length = 200)
    private String nome;
    @Basic
    @Column(name = "email", nullable = true, length = 100)
    private String email;
    @Basic
    @Column(name = "telemovel", nullable = true, length = 10)
    private String telemovel;
    @Basic
    @Column(name = "nif", nullable = true, length = 10)
    private String nif;
    @Basic
    @Column(name = "dtnascimento", nullable = true)
    private Date dtnascimento;
    @Basic
    @Column(name = "cpostal", nullable = true, length = 8)
    private String cpostal;
    @OneToMany(mappedBy = "clienteByIdcliente")
    private Collection<Linhaparticipante> linhaparticipantesByIdcliente;
    @OneToMany(mappedBy = "clienteByIdcliente")
    private Collection<Linharestricao> linharestricaosByIdcliente;
    @OneToMany(mappedBy = "clienteByIdcliente")
    private Collection<Planotreino> planotreinosByIdcliente;
    @OneToMany(mappedBy = "clienteByIdcliente")
    private Collection<Subscricao> subscricaosByIdcliente;

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelemovel() {
        return telemovel;
    }

    public void setTelemovel(String telemovel) {
        this.telemovel = telemovel;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public Date getDtnascimento() {
        return dtnascimento;
    }

    public void setDtnascimento(Date dtnascimento) {
        this.dtnascimento = dtnascimento;
    }

    public String getCpostal() {
        return cpostal;
    }

    public void setCpostal(String cpostal) {
        this.cpostal = cpostal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cliente cliente = (Cliente) o;

        if (idcliente != cliente.idcliente) return false;
        if (nome != null ? !nome.equals(cliente.nome) : cliente.nome != null) return false;
        if (email != null ? !email.equals(cliente.email) : cliente.email != null) return false;
        if (telemovel != null ? !telemovel.equals(cliente.telemovel) : cliente.telemovel != null) return false;
        if (nif != null ? !nif.equals(cliente.nif) : cliente.nif != null) return false;
        if (dtnascimento != null ? !dtnascimento.equals(cliente.dtnascimento) : cliente.dtnascimento != null)
            return false;
        if (cpostal != null ? !cpostal.equals(cliente.cpostal) : cliente.cpostal != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idcliente;
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (telemovel != null ? telemovel.hashCode() : 0);
        result = 31 * result + (nif != null ? nif.hashCode() : 0);
        result = 31 * result + (dtnascimento != null ? dtnascimento.hashCode() : 0);
        result = 31 * result + (cpostal != null ? cpostal.hashCode() : 0);
        return result;
    }

    public Collection<Linhaparticipante> getLinhaparticipantesByIdcliente() {
        return linhaparticipantesByIdcliente;
    }

    public void setLinhaparticipantesByIdcliente(Collection<Linhaparticipante> linhaparticipantesByIdcliente) {
        this.linhaparticipantesByIdcliente = linhaparticipantesByIdcliente;
    }

    public Collection<Linharestricao> getLinharestricaosByIdcliente() {
        return linharestricaosByIdcliente;
    }

    public void setLinharestricaosByIdcliente(Collection<Linharestricao> linharestricaosByIdcliente) {
        this.linharestricaosByIdcliente = linharestricaosByIdcliente;
    }

    public Collection<Planotreino> getPlanotreinosByIdcliente() {
        return planotreinosByIdcliente;
    }

    public void setPlanotreinosByIdcliente(Collection<Planotreino> planotreinosByIdcliente) {
        this.planotreinosByIdcliente = planotreinosByIdcliente;
    }

    public Collection<Subscricao> getSubscricaosByIdcliente() {
        return subscricaosByIdcliente;
    }

    public void setSubscricaosByIdcliente(Collection<Subscricao> subscricaosByIdcliente) {
        this.subscricaosByIdcliente = subscricaosByIdcliente;
    }
}
