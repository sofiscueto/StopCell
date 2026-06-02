package com.TIC.stopCell.repository;

import com.TIC.stopCell.model.Aparelho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;


public interface AparelhoRepository extends JpaRepository <Aparelho, String> {
}
