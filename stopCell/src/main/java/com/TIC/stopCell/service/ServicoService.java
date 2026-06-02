package com.TIC.stopCell.service;

import com.TIC.stopCell.model.Servico;
import com.TIC.stopCell.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicoService {
    @Autowired
    private ServicoRepository servicoRepository;

    public Servico cadastrar(Servico servicoNovo) {
        return servicoRepository.save(servicoNovo);
    }

    public Servico atualizar(Long idServico, Servico servicoNovo) {
        if (servicoRepository.existsById(idServico)) {
            servicoNovo.setIdServico(idServico);
            return servicoRepository.save(servicoNovo);
        }
        return null;
    }
}
