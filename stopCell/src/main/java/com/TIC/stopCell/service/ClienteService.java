package com.TIC.stopCell.service;

import com.TIC.stopCell.model.Cliente;
import com.TIC.stopCell.model.Usuario;
import com.TIC.stopCell.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente cadastrar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente atualizar(String cpf, Cliente clienteNovo) {
        if (clienteRepository.existsById(cpf)) {
            clienteNovo.setCpf(cpf);
            return clienteRepository.save(clienteNovo);
        }
        return null;
    }

}
