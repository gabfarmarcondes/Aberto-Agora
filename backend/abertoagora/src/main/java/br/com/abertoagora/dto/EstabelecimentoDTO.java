package br.com.abertoagora.dto;

import br.com.abertoagora.model.Proprietario;
import br.com.abertoagora.model.attributes.Endereco;
import br.com.abertoagora.model.attributes.Status;

public record EstabelecimentoDTO(
        Long idEstabelecimento,
        String cnpj,
        String nomeEstabelecimento,
        String celularEstabelecimento,
        String descricaoEstabelecimento,
        Status status,
        String categoriaEstabelecimento,
        Endereco enderecoEstabelecimento,
        String horarioFuncionamento,
        Proprietario proprietario
)
{ }
