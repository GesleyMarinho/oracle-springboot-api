package com.dimas.oracleapi.projetooraclexespringboot.dto.userDTO;

public class UserAuthDTO {

     private String email;
     private String senha;

    public UserAuthDTO() {
    }

    public UserAuthDTO(String email, String senha) {
        this.email = email;
        this.senha = senha;
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
}
