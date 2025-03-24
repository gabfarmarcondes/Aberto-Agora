package br.com.abertoagora.controller;

import br.com.abertoagora.config.ResponseWrapper;
import br.com.abertoagora.dto.UsuarioDTO;
import br.com.abertoagora.model.Usuario;
import br.com.abertoagora.services.UsuarioServices;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioServices usuarioServices;

    public UsuarioController(UsuarioServices usuarioServices) {this.usuarioServices = usuarioServices;}

    @GetMapping("/listar/todosUsuarios")
    public ResponseEntity<List<UsuarioDTO>> getAllUsuarios() {return usuarioServices.getAllUsuarios();}
    

    @GetMapping("/buscar/{idUsuario}")
    public ResponseEntity<UsuarioDTO> getByIdUsuario(@PathVariable Long idUsuario) {return usuarioServices.getByIdUsuario(idUsuario);}

    @GetMapping("/buscar/{cpfUsuario}")
    public ResponseEntity<UsuarioDTO> getByCpfUsuario (@PathVariable String cpfUsuario) {return usuarioServices.getByCpfUsuario(cpfUsuario);}

    @GetMapping("/buscar/{nomeUsuario}")
    public ResponseEntity<List<UsuarioDTO>> getByNomeUsuario (@PathVariable String nomeUsuario) {return usuarioServices.getByNomeUsuario(nomeUsuario);}

    @GetMapping("/buscar/{emailUsuario}")
    public ResponseEntity<UsuarioDTO> getByEmailUsuario(@PathVariable String emailUsuario) {return usuarioServices.getByEmailUsuario(emailUsuario);}

    @GetMapping("/buscar{dataCadastro}")
    public ResponseEntity<List<UsuarioDTO>> getByDataCadastro(@PathVariable LocalDate dataCadastro) {return usuarioServices.getByDataCadastro(dataCadastro);}

    @PostMapping("/criar")
    public ResponseEntity<ResponseWrapper<UsuarioDTO>> createUsuario (@RequestBody UsuarioDTO usuarioDTO) {return usuarioServices.createUsuario(usuarioDTO);}

    @PutMapping("/atualizar/{idUsuario}")
    public ResponseEntity<ResponseWrapper<UsuarioDTO>> updateUsuario (@Valid @RequestBody UsuarioDTO usuarioDTO, @PathVariable Long idUsuario) {return usuarioServices.updateUsuario(usuarioDTO, idUsuario);}

    @DeleteMapping("/deletar/{idUsuario}")
    public ResponseEntity<Usuario> deleteUsuario(@PathVariable Long idUsuario){return usuarioServices.deleteUsuario(idUsuario);}
}
