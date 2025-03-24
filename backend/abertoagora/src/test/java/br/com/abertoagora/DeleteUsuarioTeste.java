package br.com.abertoagora;

import br.com.abertoagora.model.Usuario;
import br.com.abertoagora.repository.jpa.UsuarioRepository;
import br.com.abertoagora.services.UsuarioServices;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class DeleteUsuarioTeste {

    @Mock
    private UsuarioRepository usuarioRepository;

    @InjectMocks
    private UsuarioServices usuarioServices;

    private Usuario usuario;

    @BeforeEach
    void setUp() {
        usuario = new Usuario();
        usuario.setIdUsuario(1L);
    }

    @Test
    void quandoUsuarioEhDeletado_Retorna204(){

        when(usuarioRepository.findByIdUsuario(1L)).thenReturn(Optional.ofNullable(usuario));
        doNothing().when(usuarioRepository).delete(usuario);

        ResponseEntity<Usuario> response = usuarioServices.deleteUsuario(1L);

        assertNotNull(response);
        assertEquals(HttpStatusCode.valueOf(204), response.getStatusCode());

        verify(usuarioRepository, times(1)).findByIdUsuario(1L);
        verify(usuarioRepository, times(1)).delete(usuario);
    }
}
