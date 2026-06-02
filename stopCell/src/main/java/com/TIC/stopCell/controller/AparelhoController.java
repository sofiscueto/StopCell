package com.TIC.stopCell.controller;

import com.TIC.stopCell.model.Aparelho;
import com.TIC.stopCell.service.AparelhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/aparelhos")
public class AparelhoController {
    @Autowired
    private AparelhoService aparelhoService;

    @PostMapping
    public ResponseEntity<Aparelho> cadastrar(@RequestBody Aparelho aparelho) {
        Aparelho novo = aparelhoService.cadastrar(aparelho);
        URI uri = URI.create("/aparelhos/" + novo.getImei());
        return ResponseEntity.created(uri).body(novo);
    }

    @PutMapping("/{imei}")
    public ResponseEntity<Aparelho> atualizar(@PathVariable String imei, @RequestBody Aparelho aparelho) {
        Aparelho resposta = aparelhoService.atualizar(imei, aparelho);
        if (resposta != null) {
            return ResponseEntity.ok(resposta);
        }
        return ResponseEntity.notFound().build();
    }
}


