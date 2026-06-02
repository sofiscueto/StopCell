package com.TIC.stopCell.service;

import com.TIC.stopCell.model.LogNotificacao;
import com.TIC.stopCell.repository.LogNotificacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogNotificacaoService {
    @Autowired
    private LogNotificacaoRepository logNotificacaoRepository;

    public LogNotificacao registrar(LogNotificacao logNotificacao){
        return logNotificacaoRepository.save(logNotificacao);
    }
    public LogNotificacao reenviar(Long id, LogNotificacao logNotificacao) {
        if (logNotificacaoRepository.existsById(id)) {
            logNotificacao.setIdLogNotificacao(id);
            return logNotificacaoRepository.save(logNotificacao);
        }
        return null;
    }
}
