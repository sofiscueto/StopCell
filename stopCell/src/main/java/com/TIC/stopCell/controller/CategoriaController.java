package com.TIC.stopCell.controller;

import com.TIC.stopCell.model.Categoria;

import com.TIC.stopCell.model.Checklist;
import com.TIC.stopCell.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;

    @PostMapping
    public ResponseEntity<Categoria> cadastrar(@RequestBody Categoria categoria) {
        Categoria novo = categoriaService.cadastrar(categoria);
        URI uri = URI.create("/categoria/" + novo.getIdCategoria());
        return ResponseEntity.created(uri).body(novo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categoria> atualizar(@PathVariable Long id, @RequestBody Categoria categoria) {

        Categoria resposta = categoriaService.atualizar(id, categoria);
        if (resposta != null) {
            return ResponseEntity.ok(resposta);
        }
        return ResponseEntity.notFound().build();
    }
}
