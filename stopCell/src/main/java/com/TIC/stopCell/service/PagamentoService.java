package com.TIC.stopCell.service;

import com.TIC.stopCell.model.Pagamento;
import com.TIC.stopCell.repository.PagamentoRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PagamentoService {
    @Autowired
    private PagamentoRespository pagamentoRespository;

    public Pagamento registrar(Pagamento pagamento){
        return pagamentoRespository.save(pagamento);
    }
}
