package br.com.sancode.fidelidade.dto;

import lombok.*;
import org.hibernate.validator.constraints.br.CNPJ;

import javax.validation.constraints.Email;
import java.io.Serializable;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EstabelecimentoDTO implements Serializable {
    private static final long serialVersionUID = 1l;

    private Long id;

    private String razaoSocial;

    @CNPJ
    private String cnpj;

    private String endereco;

    private String numero;

    private String bairro;

    private String cidade;

    private String uf;

    @Email
    private String email;
}
