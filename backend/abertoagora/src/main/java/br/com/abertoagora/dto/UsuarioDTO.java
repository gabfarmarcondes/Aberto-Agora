package br.com.abertoagora.dto;

import java.time.LocalDate;

public record UsuarioDTO(
        Long idUsuario,
        String nomeUsuario,
        String cpfUsuario,
        String emailUsuario,
        String senhaUsuario,
        String roleUsuario,
        LocalDate dataCadastro
)
{ }
