package com.TIC.stopCell.service;

import com.TIC.stopCell.model.Usuario;
import com.TIC.stopCell.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario cadastrar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public boolean autentificar(Usuario usuario) {
        Optional<Usuario> encontrado = usuarioRepository.findByEmailUsuario(usuario.getEmailUsuario());
        return encontrado.isPresent() && encontrado.get().getSenha().equals(usuario.getSenha());
    }
}