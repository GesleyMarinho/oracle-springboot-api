package com.dimas.oracleapi.projetooraclexespringboot.dto.userDTO;

import com.dimas.oracleapi.projetooraclexespringboot.entity.User;

import java.util.Date;

public class ProductDTO {

    private String nomeProduto;
    private Double preco;
    private Date dataCadastro;
    private Long userID;


    public ProductDTO() {
    }

    public ProductDTO(String nomeProduto, Double preco, Date dataCadastro) {
        this.nomeProduto = nomeProduto;
        this.preco = preco;
        this.dataCadastro = dataCadastro;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
}
