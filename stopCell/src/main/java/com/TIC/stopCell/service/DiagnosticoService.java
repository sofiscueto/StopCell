package com.TIC.stopCell.service;

import com.TIC.stopCell.model.Diagnostico;
import com.TIC.stopCell.repository.DiagnosticoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiagnosticoService {
    @Autowired
    private DiagnosticoRepository diagnosticoRepository;

    public Diagnostico registrar(Diagnostico diagnostico){
        return diagnosticoRepository.save(diagnostico);
    }
}
