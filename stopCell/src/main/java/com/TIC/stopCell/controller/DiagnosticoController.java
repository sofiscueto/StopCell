package com.TIC.stopCell.controller;


import com.TIC.stopCell.model.Diagnostico;
import com.TIC.stopCell.service.DiagnosticoService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/diagnostico")
public class DiagnosticoController {
    @Autowired
    private DiagnosticoService diagnosticoService;

    @PostMapping // CORREÇÃO: faltava @PostMapping
    public ResponseEntity<Diagnostico> registrar(@RequestBody Diagnostico diagnostico) {
        Diagnostico novo = diagnosticoService.registrar(diagnostico);
        URI uri = URI.create("/diagnostico/" + novo.getIdDiagnostico());
        return ResponseEntity.created(uri).body(novo);
    }
}
