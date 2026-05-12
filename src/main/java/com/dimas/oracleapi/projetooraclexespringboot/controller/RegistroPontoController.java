package com.dimas.oracleapi.projetooraclexespringboot.controller;


import com.dimas.oracleapi.projetooraclexespringboot.dto.RegistroPontoDTO.RegistroPontoDTO;
import com.dimas.oracleapi.projetooraclexespringboot.entity.RegistroPonto;
import com.dimas.oracleapi.projetooraclexespringboot.service.RegistroPontoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping(value = "/registroPonto")
public class RegistroPontoController {

    private RegistroPontoService registroPontoService;

    public RegistroPontoController(RegistroPontoService registroPontoService) {
        this.registroPontoService = registroPontoService;
    }

    @PostMapping
    public ResponseEntity<?> insertRegistroPonto(@RequestBody RegistroPontoDTO dto) {

        RegistroPonto registroPonto = registroPontoService.save(dto.getUserId());

        RegistroPontoDTO registroPontoDTO = new RegistroPontoDTO();

        registroPontoDTO.setDataHora(LocalDateTime.now());
        registroPontoDTO.setStatus(registroPonto.getTipoRegistro());
        registroPontoDTO.setNomeUsuario(registroPonto.getUser().getNome());
        registroPontoDTO.setUserId(registroPonto.getUser().getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(registroPontoDTO);
    }
}
