package br.com.abertoagora.controller;

import br.com.abertoagora.dto.UsuarioDTO;
import br.com.abertoagora.services.UsuarioServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioServices usuarioServices;

    public UsuarioController(UsuarioServices usuarioServices) {
        this.usuarioServices = usuarioServices;
    }

    @GetMapping
    public ResponseEntity<UsuarioDTO> listar() {
        return usuarioServices.getAllUsuarios();
    }

}
