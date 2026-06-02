package com.TIC.stopCell.service;

import com.TIC.stopCell.model.Marca;
import com.TIC.stopCell.repository.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MarcaService {
    @Autowired
    private MarcaRepository marcaRepository;

    public Marca cadastrar(Marca marca){
        return marcaRepository.save(marca);
    }
    public Marca atualizar(Long id, Marca marcaNova){
        if(marcaRepository.existsById(id)){
            marcaNova.setIdMarca(id);
            return marcaRepository.save(marcaNova);
        }
        return null;
    }
    public Optional<List<Marca>> listarAparelhos(Marca marca){
         return marcaRepository.findByNmMarca(marca.getNmMarca());

    }
}
