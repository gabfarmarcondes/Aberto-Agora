package br.com.abertoagora.model;

import br.com.abertoagora.dto.AdminDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "admin_table")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ADMIN {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idADMIN;

    @Email(message = "E-mail do ADMIN inválido")
    @Column(name = "admin_email", unique = true, nullable = false)
    @NotBlank(message = "O E-mail do ADMIN não pode estar vazio")
    private String emailADMIN;

    @Column(name = "admin_senha", unique = true, nullable = false)
    @NotBlank(message = "A Senha do ADMIN não pode estar vazio")
    private String senhADMIN;

    public ADMIN(AdminDTO adminDTO) {
        this.idADMIN = adminDTO.idADMIN();
        this.emailADMIN = adminDTO.emailADMIN();
        this.senhADMIN = adminDTO.senhaADMIN();

    }
}
