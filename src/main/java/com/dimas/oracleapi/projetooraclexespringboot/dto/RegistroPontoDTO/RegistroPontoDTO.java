package com.dimas.oracleapi.projetooraclexespringboot.dto.RegistroPontoDTO;

import com.dimas.oracleapi.projetooraclexespringboot.ENUM.StatusRegistroPonto;

import java.time.LocalDateTime;

public class RegistroPontoDTO {

    private LocalDateTime dataHora;
    private StatusRegistroPonto status;
    private Long userId;

    private String nomeUsuario;

    public RegistroPontoDTO() {
    }

    public RegistroPontoDTO(LocalDateTime dataHora, StatusRegistroPonto status, Long userId, String nomeUsuario) {
        this.dataHora = dataHora;
        this.status = status;
        this.userId = userId;
        this.nomeUsuario = nomeUsuario;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public StatusRegistroPonto getStatus() {
        return status;
    }

    public void setStatus(StatusRegistroPonto status) {
        this.status = status;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }
}