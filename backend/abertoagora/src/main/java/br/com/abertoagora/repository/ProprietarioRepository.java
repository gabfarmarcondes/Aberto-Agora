package br.com.abertoagora.repository;

import br.com.abertoagora.model.Estabelecimento;
import br.com.abertoagora.model.Proprietario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProprietarioRepository extends JpaRepository<Proprietario, Long> {
    @Query("SELECT p FROM Proprietario p WHERE LOWER(p.nomeProprietario) LIKE LOWER(CONCAT(:nomeProprietario, '%') ) ")
    List<Proprietario> findByNomeProprietario (String nomeProprietario);

    Optional<Proprietario> findByIdProprietario (Long idProprietario);

    Optional<Proprietario> findByCpfProprietario (String cpfProprietario);

    List<Proprietario> findByEstabelecimentoList (List<Estabelecimento> estabelecimentoList);

    // Encontra um proprietário a partir de um estabelecimento
    Optional<Proprietario> findByEstabelecimentoListContaining(Estabelecimento estabelecimento);

    // Retorna todos os proprietários que possuem estabelecimentos
    List<Proprietario> findByEstabelecimentoListIn(List<Estabelecimento> estabelecimentoList);

}
