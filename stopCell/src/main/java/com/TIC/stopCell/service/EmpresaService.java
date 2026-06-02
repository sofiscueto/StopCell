package com.TIC.stopCell.service;

import com.TIC.stopCell.model.Empresa;
import com.TIC.stopCell.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpresaService {
    @Autowired
    private EmpresaRepository empresaRepository;

    public Empresa cadastrar(Empresa empresa){
        return empresaRepository.save(empresa);
    }

    public Empresa atualizar(String cnpj, Empresa empresaNova){
        if(empresaRepository.existsById(cnpj)){
            empresaNova.setCnpj(cnpj);
            return empresaRepository.save(empresaNova);
        }
        return null;
    }
}
