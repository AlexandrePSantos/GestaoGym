package entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import java.util.Date;

// Table - Cliente
@Entity
public class Cliente {
    @Id
    @GeneratedValue
    private int idCliente;

    private String nome;
    private int idade;
    private String email;
    private String telemovel;
    private int NIF;
    private Date dtNascimento;
    private String cPostal;

    protected Cliente(){}

    public Cliente(String nome, int idade){
        this.nome = nome;
        this.idade = idade;
    }

    public Cliente(String nome, int idade, String email, String telemovel, int NIF, Date dtNascimento, String cPostal) {
        this.nome = nome;
        this.idade = idade;
        this.email = email;
        this.telemovel = telemovel;
        this.NIF = NIF;
        this.dtNascimento = dtNascimento;
        this.cPostal = cPostal;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getEmail() {
        return email;
    }

    public String getTelemovel() {
        return telemovel;
    }

    public int getNIF() {
        return NIF;
    }

    public Date getDtNascimento() {
        return dtNascimento;
    }

    public String getcPostal() {
        return cPostal;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "idCliente=" + idCliente +
                ", nome='" + nome + '\'' +
                ", idade=" + idade +
                ", email='" + email + '\'' +
                ", telemovel='" + telemovel + '\'' +
                ", NIF=" + NIF +
                ", dtNascimento=" + dtNascimento +
                ", cPostal='" + cPostal + '\'' +
                '}';
    }
}
