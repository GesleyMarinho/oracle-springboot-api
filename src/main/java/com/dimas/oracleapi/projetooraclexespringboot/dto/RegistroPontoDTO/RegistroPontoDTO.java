package com.dimas.oracleapi.projetooraclexespringboot.dto.RegistroPontoDTO;

import com.dimas.oracleapi.projetooraclexespringboot.ENUM.StatusRegistroPonto;


import java.time.LocalDateTime;

public class RegistroPontoDTO {

    //private LocalDateTime dataHora;
    private LocalDateTime entrada;

    private LocalDateTime saidaAlmoco;

    private LocalDateTime voltaAlmoco;

    private LocalDateTime saida;

    private StatusRegistroPonto statusRegistroPonto;

    public RegistroPontoDTO() {
    }

    public RegistroPontoDTO(LocalDateTime entrada, LocalDateTime saidaAlmoco, LocalDateTime voltaAlmoco, LocalDateTime saida, StatusRegistroPonto statusRegistroPonto) {
        this.entrada = entrada;
        this.saidaAlmoco = saidaAlmoco;
        this.voltaAlmoco = voltaAlmoco;
        this.saida = saida;
        this.statusRegistroPonto = statusRegistroPonto;
    }

    public LocalDateTime getEntrada() {
        return entrada;
    }

    public void setEntrada(LocalDateTime entrada) {
        this.entrada = entrada;
    }

    public LocalDateTime getSaidaAlmoco() {
        return saidaAlmoco;
    }

    public void setSaidaAlmoco(LocalDateTime saidaAlmoco) {
        this.saidaAlmoco = saidaAlmoco;
    }

    public LocalDateTime getVoltaAlmoco() {
        return voltaAlmoco;
    }

    public void setVoltaAlmoco(LocalDateTime voltaAlmoco) {
        this.voltaAlmoco = voltaAlmoco;
    }

    public LocalDateTime getSaida() {
        return saida;
    }

    public void setSaida(LocalDateTime saida) {
        this.saida = saida;
    }
    /*public RegistroPontoDTO(LocalDateTime dataHora, StatusRegistroPonto statusRegistroPonto) {

        this.dataHora = dataHora;
        this.statusRegistroPonto = statusRegistroPonto;
    }


    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(
            LocalDateTime dataHora) {

        this.dataHora = dataHora;
    }*/

    public StatusRegistroPonto getStatusRegistroPonto() {
        return statusRegistroPonto;
    }

    public void setStatusRegistroPonto(StatusRegistroPonto statusRegistroPonto) {
        this.statusRegistroPonto = statusRegistroPonto;
    }
}