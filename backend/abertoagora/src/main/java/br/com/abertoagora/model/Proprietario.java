package br.com.abertoagora.model;

import br.com.abertoagora.dto.ProprietarioDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "proprietario")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Proprietario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProprietario;

    @Column(name = "nome_proprietario", nullable = false, length = 50)
    @NotBlank(message = "Nome do proprietário não pode estar vazio")
    private String nomeProprietario;

    @CPF(message = "CPF do proprietário inválido")
    @Column(name = "proprietario_cpf", nullable = false, unique = true)
    @NotBlank(message = "CPF do proprietário não pode estar vazio")
    private String cpfProprietario;

    @Column(name = "proprietario_celular", nullable = false, unique = true)
    @NotBlank(message = "Celular do proprietário não pode estar vazio")
    private String celularProprietario;

    @Email(message = "E-mail do proprietario inválido")
    @Column(name = "proprietario_email", nullable = false, unique = true, length = 50)
    @NotBlank(message = "E-mail do proprietário não pode estar vazio")
    private String emailProprietario;

    @Column(name = "proprietario_senha", nullable = false)
    @NotBlank(message = "Senha do proprietário não pode estar vazio")
    private String senhaProprietario;

    // UM proprietário pode ter MAIS DE UM estabelecimento
    @OneToMany(mappedBy = "proprietario", cascade = CascadeType.ALL)
    @Column(name = "proprietario_estabelecimentos")
    @NotBlank(message = "Um proprietário tem que ter um estabelecimento")
    private List<Estabelecimento> estabelecimentoList = new ArrayList<>();

}
