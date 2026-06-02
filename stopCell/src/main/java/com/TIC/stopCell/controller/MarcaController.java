package com.TIC.stopCell.controller;

import com.TIC.stopCell.model.Marca;
import com.TIC.stopCell.service.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/marca")
public class MarcaController {
    @Autowired
    private MarcaService marcaService;

    @PostMapping
    public ResponseEntity<Marca> cadastrar(@RequestBody Marca marca){
        Marca novo = marcaService.cadastrar(marca);
        URI uri = URI.create("/marca/" + novo.getIdMarca());
        return ResponseEntity.created(uri).body(novo);
    }
    @PutMapping ("/{id}")
    public ResponseEntity< Marca > atualizar(@PathVariable Long id, @RequestBody Marca marca){
        Marca resposta = marcaService.atualizar(id, marca);
        if(resposta != null){
            return ResponseEntity.ok(resposta);
        }
        return ResponseEntity.notFound().build();
    }
    @GetMapping("/estoque")
    public ResponseEntity<Optional<List<Marca>>> listarAparelhos(@RequestBody Marca marca){
        Optional<List<Marca>> resposta = marcaService.listarAparelhos(marca);
        return ResponseEntity.ok(resposta);
    }
}
