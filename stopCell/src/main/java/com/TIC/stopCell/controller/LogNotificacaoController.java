package com.TIC.stopCell.controller;

import com.TIC.stopCell.model.Diagnostico;
import com.TIC.stopCell.model.LogNotificacao;
import com.TIC.stopCell.service.LogNotificacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/notificacao")
public class LogNotificacaoController {
    @Autowired
    private LogNotificacaoService logNotificacaoService;

    @PostMapping
    public ResponseEntity<LogNotificacao> registrar(@RequestBody LogNotificacao logNotificacao) {
        LogNotificacao novo = logNotificacaoService.registrar(logNotificacao);
        URI uri = URI.create("/notificacao/" + novo.getIdLogNotificacao());
        return ResponseEntity.created(uri).body(novo);
    }
}
