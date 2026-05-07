package com.dimas.oracleapi.projetooraclexespringboot.dto.userDTO;

public class UserDTO {


    public String nome;
    public Integer idade;
    public String email;
    public String senha;
    public String confirmaSenha;

    public UserDTO() {
    }

    public UserDTO(String nome, Integer idade, String email, String senha, String confirmaSenha) {
        this.nome = nome;
        this.idade = idade;
        this.email = email;
        this.senha = senha;
        this.confirmaSenha = confirmaSenha;
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

    public String getConfirmaSenha() {
        return confirmaSenha;
    }

    public void setConfirmaSenha(String confirmaSenha) {
        this.confirmaSenha = confirmaSenha;
    }
}


