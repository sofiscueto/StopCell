package com.TIC.stopCell.service;

import com.TIC.stopCell.model.Aparelho;
import com.TIC.stopCell.model.OrdemServico;
import com.TIC.stopCell.repository.AparelhoRepository;
import com.TIC.stopCell.repository.OrdemServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdemServicoService {

    @Autowired
    private OrdemServicoRepository ordemServicoRepository;
    @Autowired
    private AparelhoRepository aparelhoRepository;

    public OrdemServico abrir(OrdemServico ordemServico) {

        String imei = ordemServico.getAparelho().getImei();

        System.out.println("IMEI recebido = " + imei);

        Aparelho aparelho = aparelhoRepository
                .findById(imei)
                .orElseThrow(() ->
                        new RuntimeException("Aparelho não encontrado"));

        ordemServico.setAparelho(aparelho);
        System.out.println("Usuario: " + ordemServico.getUsuario());
        return ordemServicoRepository.save(ordemServico);
    }

    public OrdemServico atualizarStatus(Long numOs, String status) {
        return ordemServicoRepository.findById(numOs).map(os -> {
            os.setStatus(status);
            return ordemServicoRepository.save(os);
        }).orElse(null);
    }
}
