package com.bd.DAL;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Objects;

@Entity
@Table(name = "USERS")
@NamedQueries({
        @NamedQuery(name = "Users.findAll", query = "SELECT c FROM Users c"),
        @NamedQuery(name = "Users.findByUser", query = "SELECT c FROM Users c WHERE c.idUser = :id_user"),
        @NamedQuery(name = "Users.findByLogin", query =  "Select c From Users c WHERE c.email = :emailUser and c.password  = :pass and c.estado = true"),
        @NamedQuery(name = "Users.findByGestorAtivo" , query = "Select c From Users c  where c.gestor = :is_gestor and c.estado = true" ),
        @NamedQuery(name = "Users.findByGestorDesativado" , query = "Select c From Users c  where c.gestor = :is_gestor and c.estado = false" ),
        @NamedQuery(name = "Users.findByCozinheiroAtivo" , query = "Select c From Users c  where c.cozinheiro = :is_cozinheiro and c.estado = true" ),
        @NamedQuery(name = "Users.findByCozinheiroDesativado" , query = "Select c From Users c  where c.cozinheiro = :is_cozinheiro and c.estado = false" ),
        @NamedQuery(name="Users.findAllEmail",query = "Select c from Users c where c.email=:email "),
        @NamedQuery(name = "Users.findAllByGestor" , query = "Select c From Users c  where c.email LIKE :email and c.gestor = true and c.estado = true" ),
        @NamedQuery(name = "Users.findByCozinheiroNome" , query = "Select c From Users c  where  c.nomeuser like :nomeuser" )

})
public class Users {
    private BigInteger idUser;
    private String email;
    private String password;
    private boolean isAdmin;
    private boolean isGestor;
    private boolean isCozinheiro;
    private String nomeuser;
    private Boolean isEstafeta;
    private boolean estado;


    @Basic
    @Column(name = "ESTADO", nullable = false, precision = 0)
    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Basic
    @Column(name = "IS_ESTAFETA", nullable = true, precision = 0)

    public Boolean getEstafeta() {
        return isEstafeta;
    }

    public void setEstafeta(Boolean estafeta) {
        isEstafeta = estafeta;
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_USER", nullable = false, precision = 0)
    public BigInteger getIdUser() {
        return idUser;
    }

    public void setIdUser(BigInteger idUser) {
        this.idUser = idUser;
    }

    @Basic
    @Column(name = "EMAIL", nullable = false, length = 100)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Basic
    @Column(name = "PASSWORD", nullable = false, length = 100)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "IS_ADMIN", nullable = false, precision = 0)
    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    @Basic
    @Column(name = "IS_GESTOR", nullable = false, precision = 0)
    public boolean isGestor() {
        return isGestor;
    }

    public void setGestor(boolean gestor) {
        isGestor = gestor;
    }


    @Basic
    @Column(name = "IS_COZINHEIRO", nullable = false, precision = 0)
    public boolean isCozinheiro() {
        return isCozinheiro;
    }

    public void setCozinheiro(boolean cozinheiro) {
        isCozinheiro = cozinheiro;
    }

    @Basic
    @Column(name = "NOMEUSER", nullable = false, length = 20)
    public String getNomeuser() {
        return nomeuser;
    }

    public void setNomeuser(String nomeuser) {
        this.nomeuser = nomeuser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Users users = (Users) o;

        if (!Objects.equals(idUser, users.idUser)) return false;
        if (!Objects.equals(email, users.email)) return false;
        if (!Objects.equals(password, users.password)) return false;
        if (!Objects.equals(nomeuser, users.nomeuser)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idUser != null ? idUser.hashCode() : 0;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (nomeuser != null ? nomeuser.hashCode() : 0);
        return result;
    }


}