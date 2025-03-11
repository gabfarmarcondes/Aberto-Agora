package br.com.abertoagora.repository.elastic;

import br.com.abertoagora.model.EstabelecimentoElastic;
import br.com.abertoagora.model.Proprietario;
import br.com.abertoagora.model.attributes.Status;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EstabelecimentoElasticRepository extends ElasticsearchRepository<EstabelecimentoElastic, String> {
    List<EstabelecimentoElastic> findByCategoriaEstabelecimento (String categoriaEstabelecimento);

    List<EstabelecimentoElastic> findByNomeEstabelecimentoStartingWithIgnoreCase(String nomeEstabelecimento);

    List<EstabelecimentoElastic> findByStatus (Status status);

    Optional<EstabelecimentoElastic> findByCnpj (String cnpj);

    Optional<EstabelecimentoElastic> findByIdEstabelecimento(String idEstabelecimento);

    List<EstabelecimentoElastic> findByProprietario (Proprietario proprietario);
}
