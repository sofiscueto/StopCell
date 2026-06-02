package com.TIC.stopCell.repository;

import com.TIC.stopCell.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<Empresa,String> {
}
