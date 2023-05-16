package repository.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "Funcionario")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_funcionario")
    private Integer id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "email")
    private String email;

    @Column(name = "telemovel")
    private String telemovel;

    @Column(name = "nif")
    private String nif;

    @Column(name = "dt_nascimento")
    private LocalDate dataNascimento;

    @Column(name = "salario_liquido")
    private BigDecimal salarioLiquido;

    @Column(name = "funcao")
    private String funcao;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_user", referencedColumnName = "id_user")
    private Login login;

    // default constructor
    public Funcionario() {}

    // constructor with parameters
    public Funcionario(String nome, String email, String telemovel, String nif, LocalDate dataNascimento, BigDecimal salarioLiquido, String funcao, Login login) {
        this.nome = nome;
        this.email = email;
        this.telemovel = telemovel;
        this.nif = nif;
        this.dataNascimento = dataNascimento;
        this.salarioLiquido = salarioLiquido;
        this.funcao = funcao;
        this.login = login;
    }

    // getters and setters
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

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public BigDecimal getSalarioLiquido() {
        return salarioLiquido;
    }

    public void setSalarioLiquido(BigDecimal salarioLiquido) {
        this.salarioLiquido = salarioLiquido;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public Login getLogin() { return login; }

    public void setLogin(Login login) { this.login = login; }

    @Override
    public String toString() {
        return "Funcionario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", telemovel='" + telemovel + '\'' +
                ", nif='" + nif + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", salarioLiquido=" + salarioLiquido +
                ", funcao='" + funcao + '\'' +
                ", login=" + login +
                '}';
    }
}
