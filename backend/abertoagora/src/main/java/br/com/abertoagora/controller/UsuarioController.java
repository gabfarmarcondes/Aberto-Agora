package br.com.abertoagora.controller;

import br.com.abertoagora.config.ResponseWrapper;
import br.com.abertoagora.dto.UsuarioDTO;
import br.com.abertoagora.services.UsuarioServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;


@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioServices usuarioServices;

    public UsuarioController(UsuarioServices usuarioServices) {
        this.usuarioServices = usuarioServices;
    }

    @GetMapping("/listar/todosUsuarios")
    public ResponseEntity<UsuarioDTO> getAllUsuarios() {
        return usuarioServices.getAllUsuarios();
    }

    @GetMapping("/buscar/{idUsuario}")
    public ResponseEntity<UsuarioDTO> getByIdUsuario(@PathVariable Long idUsuario) {return usuarioServices.getByIdUsuario(idUsuario);}

    @GetMapping("/buscar/{cpfUsuario}")
    public ResponseEntity<UsuarioDTO> getByCpfUsuario (@PathVariable String cpfUsuario) {return usuarioServices.getByCpfUsuario(cpfUsuario);}

    @GetMapping("/buscar/{nomeUsuario}")
    public ResponseEntity<UsuarioDTO> getByNomeUsuario (@PathVariable String nomeUsuario) {return usuarioServices.getByNomeUsuario(nomeUsuario);}

    @GetMapping("/buscar/{emailUsuario}")
    public ResponseEntity<UsuarioDTO> getByEmailUsuario(@PathVariable String emailUsuario) {return usuarioServices.getByEmailUsuario(emailUsuario);}

    @GetMapping("/buscar{dataCadastro}")
    public ResponseEntity<UsuarioDTO> getByDataCadastro(@PathVariable LocalDate dataCadastro) {return usuarioServices.getByDataCadastro(dataCadastro);}

    @PostMapping("/criar")
    public ResponseEntity<ResponseWrapper<UsuarioDTO>> createUsuario (@RequestBody UsuarioDTO usuarioDTO) {return usuarioServices.createUsuario(usuarioDTO);}
}
