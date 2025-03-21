package br.com.abertoagora;

import br.com.abertoagora.config.ResponseWrapper;
import br.com.abertoagora.dto.UsuarioDTO;
import br.com.abertoagora.model.Usuario;
import br.com.abertoagora.repository.jpa.UsuarioRepository;
import br.com.abertoagora.services.UsuarioServices;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;

import static org.mockito.ArgumentMatchers.any;
import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CreateUsuarioTeste {

    @Mock
    private UsuarioRepository usuarioRepository;

    @Spy
    private ModelMapper modelMapper = new ModelMapper();

    @InjectMocks
    private UsuarioServices usuarioServices;

    private Usuario usuario;
    private UsuarioDTO usuarioDTO;

    @Mock
    private PasswordEncoder passwordEncoder;

    @BeforeEach
    void setUp() {
        usuario = new Usuario(
                1L,
                "Nome",
                "123456789",
                "email@email.com",
                "senha123",
                "ROLE_USUARIO",
                LocalDate.now()
        );

        usuarioDTO = new UsuarioDTO(
                usuario.getIdUsuario(),
                usuario.getNomeUsuario(),
                usuario.getCpfUsuario(),
                usuario.getEmailUsuario(),
                usuario.getSenhaUsuario(),
                usuario.getRoleUsuario(),
                usuario.getDataCadastro()
        );
    }

    @Test
    void quandoUsuarioEhCriado_RetornaStatus201(){

        when(passwordEncoder.encode(anyString())).thenReturn("senhaCodificada");
        when(usuarioRepository.save(any(Usuario.class))).thenReturn(usuario);

        doReturn(usuario).when(modelMapper).map(any(UsuarioDTO.class), eq(Usuario.class));
        doReturn(usuarioDTO).when(modelMapper).map(any(Usuario.class), eq(UsuarioDTO.class));

        ResponseEntity<ResponseWrapper<UsuarioDTO>> response = usuarioServices.createUsuario(usuarioDTO);

        assertNotNull(response);
        assertEquals(201, response.getStatusCodeValue());
        assertNotNull(response.getBody());

        verify(passwordEncoder).encode(anyString());
        verify(usuarioRepository, times(1)).save(any(Usuario.class));
    }
}
