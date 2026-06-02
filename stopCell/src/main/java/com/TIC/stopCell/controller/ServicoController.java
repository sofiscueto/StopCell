package com.TIC.stopCell.controller;

import com.TIC.stopCell.model.Peca;
import com.TIC.stopCell.model.Servico;
import com.TIC.stopCell.service.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/servico")
public class ServicoController {
    @Autowired
    private ServicoService servicoService;

    @PostMapping
    public ResponseEntity<Servico> cadastrar(@RequestBody Servico servico){
        Servico novo = servicoService.cadastrar(servico);
        URI uri = URI.create("/servico/" + novo.getIdServico());
        return ResponseEntity.created(uri).body(novo);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Servico> atualizar(@PathVariable Long id, @RequestBody Servico servicoNovo){
       Servico novo = servicoService.atualizar(id,servicoNovo);
       if( novo != null){
           return ResponseEntity.ok().body(novo);
       }
       return ResponseEntity.notFound().build();
    }
}
