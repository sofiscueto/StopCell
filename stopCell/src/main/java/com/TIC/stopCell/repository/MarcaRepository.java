package com.TIC.stopCell.repository;

import com.TIC.stopCell.model.Marca;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MarcaRepository extends JpaRepository<Marca, Long> {
    Optional<List<Marca>> findByNmMarca(String nome);
}
