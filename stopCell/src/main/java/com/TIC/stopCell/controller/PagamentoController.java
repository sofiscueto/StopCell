package com.TIC.stopCell.controller;

import com.TIC.stopCell.model.Pagamento;
import com.TIC.stopCell.service.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/pagamento")
public class PagamentoController {
    @Autowired
    private PagamentoService pagamentoService;

    @PostMapping
    public ResponseEntity<Pagamento> registrar(@RequestBody Pagamento pagamento) {
        Pagamento novo = pagamentoService.registrar(pagamento);
        URI uri = URI.create("/pagamento/" + novo.getIdPagamento());
        return ResponseEntity.created(uri).body(novo);
    }
}
