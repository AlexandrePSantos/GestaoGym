package repository.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private int idCliente;

    @Column(name = "nome")
    private String nome;

    @Column(name = "idade")
    private int idade;

    @Column(name = "email")
    private String email;

    @Column(name = "telemovel")
    private String telemovel;

    @Column(name = "nif")
    private String nif;

    @Column(name = "dt_nascimento")
    private LocalDate dataNascimento;

    @Column(name = "cod_postal")
    private String codigoPostal;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_user", referencedColumnName = "id_user")
    private Login login;

    public Cliente() {
    }

    public Cliente(String nome, int idade, String email, String telemovel, String nif, LocalDate dataNascimento, String codigoPostal, Login login) {
        this.nome = nome;
        this.idade = idade;
        this.email = email;
        this.telemovel = telemovel;
        this.nif = nif;
        this.dataNascimento = dataNascimento;
        this.codigoPostal = codigoPostal;
        this.login = login;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
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

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public Login getLogin() { return login; }

    public void setLogin(Login login) { this.login = login; }

    @Override
    public String toString() {
        return "Cliente{" +
                "idCliente=" + idCliente +
                ", nome='" + nome + '\'' +
                ", idade=" + idade +
                ", email='" + email + '\'' +
                ", telemovel='" + telemovel + '\'' +
                ", nif='" + nif + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", codigoPostal='" + codigoPostal + '\'' +
                ", login=" + login +
                '}';
    }
}
