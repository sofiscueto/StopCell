package com.TIC.stopCell.repository;

import com.TIC.stopCell.model.Checklist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChecklistRepository extends JpaRepository<Checklist, Long> {
}
