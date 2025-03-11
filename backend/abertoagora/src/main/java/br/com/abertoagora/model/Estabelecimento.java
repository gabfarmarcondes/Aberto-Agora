package br.com.abertoagora.model;

import br.com.abertoagora.model.attributes.Endereco;
import br.com.abertoagora.model.attributes.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CNPJ;

@Entity
@Table(name = "estabelecimento")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Estabelecimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEstabelecimento;

    @CNPJ(message = "CNPJ do estabelecimento inválido")
    @Column(name = "estabelecimento_cnpj", nullable = false, unique = true)
    @NotBlank(message = "CNPJ do estabelecimento não pode estar vazio")
    private String cnpj;

    @Column(name = "nome_estabelecimento", nullable = false, length = 50)
    @NotBlank(message = "Nome do estabelecimento não pode estar vazio")
    private String nomeEstabelecimento;

    @Column(name = "estabelecimento_celular", nullable = false, unique = true)
    @NotBlank(message = "Celular do estabelecimento não pode estar vazio")
    private String celularEstabelecimento;

    @Column(name = "estabelecimento_descricao", nullable = false)
    @NotNull(message = "Descrição do estabelecimento não pode estar vazio")
    private String descricaoEstabelecimento;

    @Embedded
    @Column(name = "estabelecimento_endereco", nullable = false)
    @NotBlank(message = "Endereço do estabelecimento não pode estar vazio")
    private Endereco enderecoEstabelecimento;

    @Column(name = "estabelecimento_status", nullable = false)
    @NotBlank(message = "Status do estabelecimento não pode estar vazio")
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "estabelecimento_categoria", nullable = false)
    @NotBlank(message = "Categoria do estabelecimento não pode estar vazio")
    private String categoriaEstabelecimento;

    @Column(name = "estabelecimento_horario", nullable = false)
    @NotBlank(message = "Horário de Funcionamento do estabelecimento não pode estar vazio")
    private String horarioFuncionamento;

    // VÁRIOS estabelecimentos pode ter apenas UM proprietário
    @ManyToOne
    @JoinColumn(name = "proprietario_id")
    @NotBlank(message = "Um proprietário tem que ter um estabelecimento")
    private Proprietario proprietario;

}
