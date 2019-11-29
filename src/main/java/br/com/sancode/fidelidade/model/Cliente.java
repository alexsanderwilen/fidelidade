package br.com.sancode.fidelidade.model;

import br.com.sancode.fidelidade.model.enums.Perfil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
public class Cliente implements Serializable {
    private static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cli_codigo")
    private Long id;

    @Column(name = "cli_nome", length = 80)
    private String nome;

    @Column(name = "cli_cpf", length = 11, unique = true)
    @CPF
    private String cpf;

    @Column(name = "cli_endereco", length = 80)
    private String endereco;

    @Column(name = "cli_numero", length = 10)
    private String numero;

    @Column(name = "cli_bairro", length = 80)
    private String bairro;

    @Column(name = "cli_cidade", length = 80)
    private String cidade;

    @Column(name = "cli_uf", length = 2)
    private String estado;

    @Column(name = "cli_email", length = 100, unique = true)
    @Email
    private String email;

    @Column(name = "cli_senha", length = 80)
    private String senha;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "Perfil")
    private Set<Integer> perfis = new HashSet<>();

    public Cliente() {
        addPerfil(Perfil.CLIENTE);
    }

    ;

    public Cliente(String nome, String endereco, String numero, String bairro, String cidade, String estado, String email, String senha) {
        this.nome = nome;
        this.endereco = endereco;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.email = email;
        this.senha = senha;
        addPerfil(Perfil.CLIENTE);
    }

    public Set<Perfil> getPerfis() {
        return perfis.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
    }

    public void addPerfil(Perfil perfil) {
        perfis.add(perfil.getCod());
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", endereco='" + endereco + '\'' +
                ", numero='" + numero + '\'' +
                ", bairro='" + bairro + '\'' +
                ", cidade='" + cidade + '\'' +
                ", estado='" + estado + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", perfis=" + perfis +
                '}';
    }
}