package com.dimas.oracleapi.projetooraclexespringboot.controller;


import com.dimas.oracleapi.projetooraclexespringboot.dto.RegistroPontoDTO.RegistroPontoDTO;
import com.dimas.oracleapi.projetooraclexespringboot.entity.RegistroPonto;
import com.dimas.oracleapi.projetooraclexespringboot.service.RegistroPontoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

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

    @GetMapping
    public ResponseEntity<List<RegistroPontoDTO>> findAllRegistroPonto() {
        List<RegistroPontoDTO> lista = registroPontoService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(lista);
    }

    @GetMapping(value = ("/{id}"))
    public ResponseEntity<List<RegistroPontoDTO>> findAllRegistroPontoById(@PathVariable Long id) {
        List<RegistroPontoDTO> lista = registroPontoService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(lista);
    }
}
