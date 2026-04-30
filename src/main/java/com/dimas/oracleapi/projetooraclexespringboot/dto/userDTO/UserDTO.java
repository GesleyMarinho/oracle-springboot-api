package com.dimas.oracleapi.projetooraclexespringboot.dto.userDTO;

public class UserDTO {


        public String nome;
        public Integer idade;

        public UserDTO() {
        }

        public UserDTO(String nome, Integer idade) {
            this.nome = nome;
            this.idade = idade;
        }

        public String getnome() {
            return nome;
        }

        public void setnome(String nome) {
            this.nome = nome;
        }

        public Integer getIdade() {
            return idade;
        }

        public void setIdade(Integer idade) {
            this.idade = idade;
        }
    }


