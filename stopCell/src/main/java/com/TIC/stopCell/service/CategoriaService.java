package com.TIC.stopCell.service;

import com.TIC.stopCell.model.Categoria;
import com.TIC.stopCell.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria cadastrar(Categoria categoria){
        return categoriaRepository.save(categoria);
    }
    public Categoria atualizar(Long id, Categoria novaCategoria){
        if(categoriaRepository.existsById(id)){
            novaCategoria.setIdCategoria(id);
            return categoriaRepository.save(novaCategoria);
        }
        return null;
    }
}
