package com.TIC.stopCell.repository;


import com.TIC.stopCell.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository <Usuario, Long> {
    Optional<Usuario> findByEmailUsuario(String emailUsuario);
    Optional<Usuario> findBySenha(String senha);
}
