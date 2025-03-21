package br.com.abertoagora;


import br.com.abertoagora.config.ResponseWrapper;
import br.com.abertoagora.dto.UsuarioDTO;
import br.com.abertoagora.model.Usuario;
import br.com.abertoagora.repository.jpa.UsuarioRepository;
import br.com.abertoagora.services.UsuarioServices;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.Optional;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class UpdateUsuarioTeste {

    @Mock
    private UsuarioRepository usuarioRepository;

    @InjectMocks
    private UsuarioServices usuarioServices;

    @Mock
    private ModelMapper modelMapper;

    private Usuario usuario;
    private UsuarioDTO usuarioDTO;

    @BeforeEach
    void setUp() {

        usuario = new Usuario();
        usuario.setIdUsuario(1L);
        usuario.setNomeUsuario("Nome Atualizado");
        usuario.setCpfUsuario("12345678900");
        usuario.setEmailUsuario("novo@email.com");
        usuario.setSenhaUsuario("senha123");
        usuario.setRoleUsuario("ADMIN");
        usuario.setDataCadastro(LocalDate.now());

        usuarioDTO = new UsuarioDTO(
                1L,
                "Nome Atualizado",
                "12345678900",
                "novo@email.com",
                "senha123",
                "ADMIN",
                LocalDate.now()
        );
    }

    @Test
    void quandoUsuarioEhAtualizado_Retorna_200() {

        when(usuarioRepository.findByIdUsuario(1L)).thenReturn(Optional.ofNullable(usuario));
        when(usuarioRepository.save(usuario)).thenReturn(usuario);
        when(modelMapper.map(usuario, UsuarioDTO.class)).thenReturn(new UsuarioDTO(
                usuario.getIdUsuario(),
                usuario.getNomeUsuario(),
                usuario.getCpfUsuario(),
                usuario.getEmailUsuario(),
                usuario.getSenhaUsuario(),
                usuario.getRoleUsuario(),
                usuario.getDataCadastro()
        ));

        doAnswer(invocation -> {
            UsuarioDTO dto = invocation.getArgument(0);
            usuario.setNomeUsuario(dto.nomeUsuario());
            return null;
        }).when(modelMapper).map(any(UsuarioDTO.class), any(Usuario.class));

        ResponseEntity<ResponseWrapper<UsuarioDTO>> response = usuarioServices.updateUsuario(usuarioDTO, 1L);

        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals("Usuário Atualizado com Sucesso", response.getBody().getMessage());
        assertEquals("Nome Atualizado", response.getBody().getResponse().nomeUsuario());
        assertNotNull(usuario, "Usuário não deveria ser nulo");
        assertNotNull(usuarioDTO, "UsuarioDTO não deveria ser nulo");
    }
}
