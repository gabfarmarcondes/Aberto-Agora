package br.com.abertoagora.dto;

import br.com.abertoagora.model.Estabelecimento;

import java.util.List;

public record ProprietarioDTO(
        Long idProprietario,
        String nomeProprietario,
        String cpfProprietario,
        String celularProprietario,
        String emailProprietario,
        String senhaProprietario,
        List<Estabelecimento> estabelecimentoList
)
{ }
