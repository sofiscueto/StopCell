package com.TIC.stopCell.service;

import com.TIC.stopCell.model.Aparelho;
import com.TIC.stopCell.repository.AparelhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AparelhoService {
    @Autowired
    private AparelhoRepository aparelhoRepository;

    public Aparelho cadastrar(Aparelho aparelhoNovo){
        return aparelhoRepository.save(aparelhoNovo);

    }
    public Aparelho atualizar(String imei, Aparelho aparelhoNovo){
        if(aparelhoRepository.existsById(imei)){
            aparelhoNovo.setImei(imei);
            return aparelhoRepository.save(aparelhoNovo);
        }
        return null;
    }
}
