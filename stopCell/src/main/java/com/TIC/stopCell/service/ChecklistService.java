package com.TIC.stopCell.service;

import com.TIC.stopCell.model.Checklist;
import com.TIC.stopCell.repository.ChecklistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChecklistService {
    @Autowired
    private ChecklistRepository checklistRepository;

    public Checklist registrar(Checklist checklistNovo){
        return checklistRepository.save(checklistNovo);
    }
    public Checklist atualizar(Long id, Checklist checklistnovo){
        if(checklistRepository.existsById(id)){
            checklistnovo.setIdChecklist(id);
            return checklistRepository.save(checklistnovo);
        }
        return null;
    }
}
