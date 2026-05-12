package com.dimas.oracleapi.projetooraclexespringboot.entity;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TB_USER")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Integer idade;
    private String email;
    private String senha;
    private String confirmSenha;

    public User() {

    }

    public User(Long id, String nome, Integer idade, String email, String senha, String confirmSenha) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.email = email;
        this.senha = senha;
        this.confirmSenha = confirmSenha;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getConfirmSenha() {
        return confirmSenha;
    }

    public void setConfirmSenha(String confirmSenha) {
        this.confirmSenha = confirmSenha;
    }

    @Override
    public String toString() {
        return "User{id=" + id +
                ", email='" + email + '\'' +
                '}';
    }
}
