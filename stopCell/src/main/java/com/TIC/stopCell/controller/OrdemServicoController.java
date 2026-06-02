package com.TIC.stopCell.controller;

import com.TIC.stopCell.model.OrdemServico;
import com.TIC.stopCell.service.OrdemServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/ordemServico")
public class OrdemServicoController {

    @Autowired
    private OrdemServicoService ordemServicoService;

    @PostMapping
    public ResponseEntity<OrdemServico> abrir(@RequestBody OrdemServico ordemServico) {
        OrdemServico nova = ordemServicoService.abrir(ordemServico);
        URI uri = URI.create("/ordemServico/" + nova.getNumOs());
        return ResponseEntity.created(uri).body(nova);
    }

    @PatchMapping("/{numOs}/status")
    public ResponseEntity<OrdemServico> atualizarStatus(@PathVariable Long numOs, @RequestParam String status) {
        OrdemServico resposta = ordemServicoService.atualizarStatus(numOs, status);
        if (resposta != null) {
            return ResponseEntity.ok(resposta);
        }
        return ResponseEntity.notFound().build();
    }
}
