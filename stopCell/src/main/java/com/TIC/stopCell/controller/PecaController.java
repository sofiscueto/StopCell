package com.TIC.stopCell.controller;

import com.TIC.stopCell.model.Peca;
import com.TIC.stopCell.model.Usuario;
import com.TIC.stopCell.service.PecaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/peca")
public class PecaController {
    @Autowired
    private PecaService pecaService;

    @PostMapping
    public ResponseEntity<Peca> cadastrar(@RequestBody Peca peca) {
        Peca novo = pecaService.cadastrar(peca);
        URI uri = URI.create("/peca/" + novo.getIdPeca());
        return ResponseEntity.created(uri).body(novo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Peca> atualizar(@PathVariable Long id, @RequestBody Peca peca) {
        Peca resposta = pecaService.atualizar(id, peca);
        if (resposta != null) {
            return ResponseEntity.ok(resposta);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/estoque")
    public ResponseEntity<List<Peca>> verificarEstoque() {
        List<Peca> resposta = pecaService.verificarEstoque();
        return ResponseEntity.ok(resposta);
    }
}
