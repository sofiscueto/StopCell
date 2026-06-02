package com.TIC.stopCell.service;

import com.TIC.stopCell.model.Peca;
import com.TIC.stopCell.repository.PecaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PecaService {
    @Autowired
    private PecaRepository pecaRepository;

    public Peca cadastrar(Peca peca){
        return pecaRepository.save(peca);
    }
    public Peca atualizar(Long idPeca, Peca pecaNova) {
        if (pecaRepository.existsById(idPeca)) {
            pecaNova.setIdPeca(idPeca);
            return pecaRepository.save(pecaNova); // CORREÇÃO: faltava return
        }
        return null;
    }
    public List<Peca> verificarEstoque(){
        return pecaRepository.findAll();
    }
}
