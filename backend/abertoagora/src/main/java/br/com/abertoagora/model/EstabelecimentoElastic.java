package br.com.abertoagora.model;

import br.com.abertoagora.model.attributes.Endereco;
import br.com.abertoagora.model.attributes.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "estabelecimento")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EstabelecimentoElastic {

    @Id
    private String idEstabelecimento ;

    private String cnpj;
    private String nomeEstabelecimento;
    private String celularEstabelecimento;
    private String descricaoEstabelecimento;
    private Endereco enderecoEstabelecimento;
    private Status status;
    private String categoriaEstabelecimento;
    private String horarioFuncionamento;
    private Proprietario proprietario;
}
