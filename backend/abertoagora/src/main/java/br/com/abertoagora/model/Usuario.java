package br.com.abertoagora.model;

import br.com.abertoagora.dto.UsuarioDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    @Column(name = "nome_usuario", nullable = false, length = 50)
    @NotBlank(message = "Nome do usuário não pode estar vazio")
    private String nomeUsuario;

    @CPF(message = "CPF do usuário inválido")
    @Column(name = "usuario_cpf", nullable = false, unique = true)
    @NotBlank(message = "CPF do usuário não pode estar vazio")
    private String cpfUsuario;

    @Email(message = "E-mail do usuário inválido")
    @Column(name = "usuario_email", nullable = false, unique = true, length = 50)
    @NotBlank(message = "E-mail do usuário não pode estar vazio")
    private String emailUsuario;

    @Column(name = "usuario_senha", nullable = false)
    @NotBlank(message = "Senha do usuário não pode estar vazio")
    private String senhaUsuario;

    @Column(name = "usuario_role", nullable = false)
    @NotBlank(message = "Role do usuário não pode estar vazio")
    private String roleUsuario;

    @Column(name = "usuario_dataCadastro", nullable = false)
    @NotBlank(message = "Data cadastro do usuário não pode estar vazio")
    private LocalDate dataCadastro;

}
