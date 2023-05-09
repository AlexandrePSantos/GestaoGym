package repository.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcliente", nullable = false)
    private Integer id;

    @Column(name = "nome", length = 200)
    private String nome;

    @Column(name = "idade")
    private Integer idade;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "telemovel", length = 10)
    private String telemovel;

    @Column(name = "nif", length = 10)
    private String nif;

    @Column(name = "dtnascimento")
    private LocalDate dtnascimento;

    @Column(name = "cpostal", length = 8)
    private String cpostal;

    @OneToMany(mappedBy = "idcliente")
    private Set<Planotreino> planotreinos = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idcliente")
    private Set<Linhaparticipante> linhaparticipantes = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idcliente")
    private Set<Subscricao> subscricaos = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
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

    public LocalDate getDtnascimento() {
        return dtnascimento;
    }

    public void setDtnascimento(LocalDate dtnascimento) {
        this.dtnascimento = dtnascimento;
    }

    public String getCpostal() {
        return cpostal;
    }

    public void setCpostal(String cpostal) {
        this.cpostal = cpostal;
    }

    public Set<Planotreino> getPlanotreinos() {
        return planotreinos;
    }

    public void setPlanotreinos(Set<Planotreino> planotreinos) {
        this.planotreinos = planotreinos;
    }

    public Set<Linhaparticipante> getLinhaparticipantes() {
        return linhaparticipantes;
    }

    public void setLinhaparticipantes(Set<Linhaparticipante> linhaparticipantes) {
        this.linhaparticipantes = linhaparticipantes;
    }

    public Set<Subscricao> getSubscricaos() {
        return subscricaos;
    }

    public void setSubscricaos(Set<Subscricao> subscricaos) {
        this.subscricaos = subscricaos;
    }

}