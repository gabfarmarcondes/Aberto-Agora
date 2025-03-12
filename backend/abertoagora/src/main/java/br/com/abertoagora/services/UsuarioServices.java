package br.com.abertoagora.services;

import br.com.abertoagora.dto.UsuarioDTO;
import br.com.abertoagora.model.Usuario;
import br.com.abertoagora.repository.jpa.UsuarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Service
public class UsuarioServices {
    private final UsuarioRepository usuarioRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public UsuarioServices(UsuarioRepository usuarioRepository, ModelMapper modelMapper) {
        this.usuarioRepository = usuarioRepository;
        this.modelMapper = modelMapper;
    }

    public ResponseEntity<UsuarioDTO> getByIdUsuario(Long idUsuario) {
        Optional<Usuario> usuario = usuarioRepository.findByIdUsuario(idUsuario);
        return usuario.map(value -> ResponseEntity.ok().body(modelMapper.map(value, UsuarioDTO.class)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    public ResponseEntity<UsuarioDTO> getByCpfUsuario(String cpfUsuario) {
        Optional<Usuario> usuario = usuarioRepository.findByCpfUsuario(cpfUsuario);
        return usuario.map(value -> ResponseEntity.ok().body(modelMapper.map(value, UsuarioDTO.class)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    public ResponseEntity<UsuarioDTO> getByNomeUsuario (String nomeUsuario) {
        List<Usuario> usuarios = usuarioRepository.findByNomeUsuario(nomeUsuario);
        return usuarios.stream().map(value -> ResponseEntity.ok().body(modelMapper.map(value, UsuarioDTO.class)))
                .findAny().orElseGet(() -> ResponseEntity.notFound().build());
    }

    public ResponseEntity<UsuarioDTO> getByEmailUsuario (String emailUsuario) {
        Optional<Usuario> usuario = usuarioRepository.findByEmailUsuario(emailUsuario);
        return usuario.map(value -> ResponseEntity.ok().body(modelMapper.map(value, UsuarioDTO.class)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    public ResponseEntity<UsuarioDTO> getByDataCadastro (LocalDate dataCadastro) {
        List<Usuario> usuarios = usuarioRepository.findByDataCadastro(dataCadastro);
        return usuarios.stream().map(value -> ResponseEntity.ok().body(modelMapper.map(value, UsuarioDTO.class)))
                .findAny().orElseGet(() -> ResponseEntity.notFound().build());
    }

    public ResponseEntity<UsuarioDTO> getAllUsuarios() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios.stream().map(value -> ResponseEntity.ok().body(modelMapper.map(value, UsuarioDTO.class)))
                .findAny().orElseGet(() -> ResponseEntity.notFound().build());
    }
}
