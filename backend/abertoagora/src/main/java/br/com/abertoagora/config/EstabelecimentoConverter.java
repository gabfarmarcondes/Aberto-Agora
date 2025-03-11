package br.com.abertoagora.config;

import br.com.abertoagora.model.Estabelecimento;
import br.com.abertoagora.model.EstabelecimentoElastic;

public class EstabelecimentoConverter {
    public static EstabelecimentoElastic toElastic(Estabelecimento estabelecimento) {
        return new EstabelecimentoElastic(
                estabelecimento.getIdEstabelecimento().toString(),
                estabelecimento.getCnpj(),
                estabelecimento.getNomeEstabelecimento(),
                estabelecimento.getCelularEstabelecimento(),
                estabelecimento.getDescricaoEstabelecimento(),
                estabelecimento.getEnderecoEstabelecimento(),
                estabelecimento.getStatus(),
                estabelecimento.getCategoriaEstabelecimento(),
                estabelecimento.getHorarioFuncionamento(),
                estabelecimento.getProprietario()
        );
    }
}
