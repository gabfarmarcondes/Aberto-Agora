package br.com.abertoagora.repository;

import br.com.abertoagora.model.Estabelecimento;
import br.com.abertoagora.model.Proprietario;
import br.com.abertoagora.model.attributes.Status;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;
import java.util.Optional;

@NoRepositoryBean
public interface EstabelecimentoElasticRepository extends ElasticsearchRepository<Estabelecimento, Long> {
    Optional<Estabelecimento> findByCategoriaEstabelecimento (String categoriaEstabelecimento);

    List<Estabelecimento> findByNomeEstabelecimentoStartingWithIgnoreCase(String nomeEstabelecimento);

    List<Estabelecimento> findByStatus (Status status);

    Optional<Estabelecimento> findByCnpj (String cnpj);

    Optional<Estabelecimento> findByIdEstabelecimento(Long idEstabelecimento);

    List<Estabelecimento> findByProprietario (Proprietario proprietario);
}
