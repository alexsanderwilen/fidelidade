package br.com.sancode.fidelidade.model;


import javax.persistence.*;
import java.io.Serializable;

/*
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
*/
@Entity
public class Estabelecimento implements Serializable {
    private static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "est_codigo")
    private Long id;

    @Column(name = "est_razao_social", length = 80)
    private String razaoSocial;

    @Column(name = "est_cnpj", length = 14)
    private String cnpj;

    @Column(name = "est_endereco", length = 80)
    private String endereco;

    @Column(name = "est_numero", length = 10)
    private String numero;

    @Column(name = "est_bairro", length = 80)
    private String bairro;

    @Column(name = "est_cidade", length = 80)
    private String cidade;

    @Column(name = "est_uf", length = 2)
    private String uf;

    @Column(name = "est_email", length = 100, unique = true)
    private String email;

    public Estabelecimento(String razaoSocial, String cnpj, String endereco, String numero, String bairro, String cidade, String uf, String email) {
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
        this.email = email;
    }

    public Estabelecimento() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
