package com.TIC.stopCell.controller;

import com.TIC.stopCell.model.Cliente;
import com.TIC.stopCell.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<Cliente> cadastrar(@RequestBody Cliente cliente) {
        Cliente novo = clienteService.cadastrar(cliente);
        URI uri = URI.create("/clientes/" + novo.getCpf());
        return ResponseEntity.created(uri).body(novo);
    }

    @PatchMapping("/{cpf}")
    public ResponseEntity<Cliente> atualizar(@PathVariable String cpf, @RequestBody Cliente clienteNovo) {
        Cliente resposta = clienteService.atualizar(cpf, clienteNovo);
        if (resposta != null) {
            return ResponseEntity.ok(resposta);
        }
        return ResponseEntity.notFound().build();
    }
}

