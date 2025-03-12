package br.com.abertoagora.repository.jpa;

import br.com.abertoagora.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByIdUsuario (Long idUsuario);

    @Query("SELECT u FROM Usuario u WHERE LOWER(u.nomeUsuario) LIKE LOWER(CONCAT(:nomeUsuario, '%') ) ")
    List<Usuario> findByNomeUsuario (String nomeUsuario);

    Optional<Usuario> findByCpfUsuario (String cpfUsuario);

    Optional<Usuario> findByEmailUsuario (String emailUsuario);

    List<Usuario> findByDataCadastro (LocalDate dataCadastro);

    List<Usuario> findAll();

}
