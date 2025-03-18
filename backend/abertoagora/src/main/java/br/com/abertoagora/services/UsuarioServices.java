package br.com.abertoagora.services;

import br.com.abertoagora.config.ResponseWrapper;
import br.com.abertoagora.dto.UsuarioDTO;
import br.com.abertoagora.model.Usuario;
import br.com.abertoagora.repository.jpa.UsuarioRepository;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Service
public class UsuarioServices {
    private final UsuarioRepository usuarioRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UsuarioServices(UsuarioRepository usuarioRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
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

    public ResponseEntity<ResponseWrapper<UsuarioDTO>> createUsuario(@Valid @RequestBody UsuarioDTO usuarioDTO) {
        try {
            Usuario usuario = modelMapper.map(usuarioDTO, Usuario.class);
            usuario.setDataCadastro(LocalDate.now());
            usuario.setSenhaUsuario(passwordEncoder.encode(usuario.getSenhaUsuario()));
            usuario = usuarioRepository.save(usuario);
            UsuarioDTO dto = modelMapper.map(usuario, UsuarioDTO.class);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(new ResponseWrapper<>("Usuário criado com sucesso", dto));
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(new ResponseWrapper<>("Erro: CPF ou e-mail já cadastrado", null));
        } catch (ConstraintViolationException e) {
            return ResponseEntity.badRequest()
                    .body(new ResponseWrapper<>("Erro: Dados inválidos", null));
        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                    .body(new ResponseWrapper<>("Erro interno no servidor", null));
        }
    }
}
