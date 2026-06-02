package com.TIC.stopCell.controller;

import com.TIC.stopCell.model.Aparelho;
import com.TIC.stopCell.model.Checklist;
import com.TIC.stopCell.service.ChecklistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/checklist")
public class ChecklistController {
    @Autowired
    private ChecklistService checklistService;

    @PostMapping
    public ResponseEntity<Checklist> cadastrar(@RequestBody Checklist checklist) {
        Checklist novo = checklistService.registrar(checklist);
        URI uri = URI.create("/checklist/" + novo.getIdChecklist());
        return ResponseEntity.created(uri).body(novo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Checklist> atualizar(@PathVariable Long id, @RequestBody Checklist checklistNovo) {
        Checklist resposta = checklistService.atualizar(id, checklistNovo);
        if (resposta != null) {
            return ResponseEntity.ok(resposta);
        }
        return ResponseEntity.notFound().build();
    }
}
