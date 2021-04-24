package br.com.cadastro.endereco;

import br.com.cadastro.usuario.Usuario;
import br.com.cadastro.usuario.UsuarioRepository;

import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Optional;


public class EnderecoForm {
    //logradouro, número, complemento, bairro, cidade, estado e CEP, associando este endereço ao usuário.

    @NotBlank
    private String logradouro;
    @NotBlank
    private String numero;
    @NotBlank
    private String complemento;
    @NotBlank
    private String bairro;
    @NotBlank
    private String cidade;
    @NotBlank
    private String estado;
    @NotBlank
    private String cep;
    @NotNull
    private Long usuarioId;

    public EnderecoForm(@NotBlank String logradouro, @NotBlank String numero, @NotBlank String complemento, @NotBlank String bairro, @NotBlank String cidade, @NotBlank String estado, @NotBlank String cep, @NotNull Long usuarioId) {
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
        this.usuarioId = usuarioId;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    public String getCep() {
        return cep;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public Endereco converter(UsuarioRepository usuarioRepository){
        Optional<Usuario> usuario = usuarioRepository.findById(usuarioId);

        return new Endereco(logradouro, numero, complemento, bairro, cidade, estado, cep, usuario.get());

    }




}
