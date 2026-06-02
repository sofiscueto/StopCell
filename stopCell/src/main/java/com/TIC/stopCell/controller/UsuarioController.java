package com.TIC.stopCell.controller;

import com.TIC.stopCell.model.Usuario;
import com.TIC.stopCell.service.UsuarioService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/register")
    public ResponseEntity<Usuario> cadastrar(@RequestBody Usuario novoUsuario) {

        Usuario resposta = usuarioService.cadastrar(novoUsuario);

        if (resposta == null) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity
                .created(URI.create("/usuario/" + resposta.getIdUsuario()))
                .body(resposta);
    }

    @PostMapping("/login")
    public ResponseEntity<Boolean> autenticar(@RequestBody Usuario usuario) {
        boolean resposta = usuarioService.autentificar(usuario);
        return ResponseEntity.ok(resposta);
    }
}
