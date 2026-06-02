package com.TIC.stopCell.controller;

import com.TIC.stopCell.model.Empresa;
import com.TIC.stopCell.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {
    @Autowired
    private EmpresaService empresaService;

    @PostMapping
    public ResponseEntity<Empresa> cadastrar(@RequestBody Empresa empresa) {
        Empresa novo = empresaService.cadastrar(empresa);
        URI uri = URI.create("/empresa/" + novo.getCnpj());
        return ResponseEntity.created(uri).body(novo);
    }

    @PatchMapping("/{cnpj}")
    public ResponseEntity<Empresa> atualizar(@PathVariable String cnpj, @RequestBody Empresa empresaNova) {
        Empresa resposta = empresaService.atualizar(cnpj, empresaNova);
        if (resposta != null) {
            return ResponseEntity.ok(resposta);
        }
        return ResponseEntity.notFound().build();
    }
}
