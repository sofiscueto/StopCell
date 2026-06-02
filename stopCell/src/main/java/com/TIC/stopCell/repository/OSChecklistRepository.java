package com.TIC.stopCell.repository;

import com.TIC.stopCell.model.OsChecklist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OSChecklistRepository extends JpaRepository<OsChecklist, OsChecklist.OsChecklistId> {
}