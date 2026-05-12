package com.dimas.oracleapi.projetooraclexespringboot.service;

import com.dimas.oracleapi.projetooraclexespringboot.ENUM.StatusRegistroPonto;
import com.dimas.oracleapi.projetooraclexespringboot.entity.RegistroPonto;
import com.dimas.oracleapi.projetooraclexespringboot.entity.User;
import com.dimas.oracleapi.projetooraclexespringboot.repository.ResgitroPontoRepository;
import com.dimas.oracleapi.projetooraclexespringboot.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class RegistroPontoService {

    private ResgitroPontoRepository resgitroPontoRepository;
    private UserRepository userRepository;

    public RegistroPontoService(ResgitroPontoRepository resgitroPontoRepository, UserRepository userRepository) {
        this.resgitroPontoRepository = resgitroPontoRepository;
        this.userRepository = userRepository;
    }

    public RegistroPonto save(Long userId) {

        User user = userRepository
                .findById(userId)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Usuário não encontrado"));

        long quantidadeRegistrosHoje = resgitroPontoRepository.contarRegistroHoje(userId);

        StatusRegistroPonto status;

        if (quantidadeRegistrosHoje == 0) {
            status = StatusRegistroPonto.ENTRADA;
        } else if (quantidadeRegistrosHoje == 1) {
            status = StatusRegistroPonto.ALMOCO;
        } else if (quantidadeRegistrosHoje == 2) {
            status = StatusRegistroPonto.VOLTA_ALMOCO;
        } else {
            status = StatusRegistroPonto.SAIDA;
        }
        RegistroPonto registroPonto = new RegistroPonto();
        registroPonto.setUser(user);
        registroPonto.setDataHora(LocalDateTime.now());
        registroPonto.setTipoRegistro(status);
        return resgitroPontoRepository.save(registroPonto);
    }

}
