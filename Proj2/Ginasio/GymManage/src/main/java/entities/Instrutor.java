package entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "instrutor")
public class Instrutor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idinstrutor", nullable = false)
    private Integer id;

    @Column(name = "nome", length = 100)
    private String nome;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "telemovel", length = 10)
    private String telemovel;

    @Column(name = "nif", length = 10)
    private String nif;

    @Column(name = "dtnascimento")
    private LocalDate dtnascimento;

    @Column(name = "salarioliquido", precision = 5, scale = 1)
    private BigDecimal salarioliquido;

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

    public BigDecimal getSalarioliquido() {
        return salarioliquido;
    }

    public void setSalarioliquido(BigDecimal salarioliquido) {
        this.salarioliquido = salarioliquido;
    }

}