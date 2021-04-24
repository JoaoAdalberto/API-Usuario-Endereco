package br.com.cadastro.usuario;

import br.com.cadastro.endereco.EnderecoDTO;

import java.util.List;
import java.util.stream.Collectors;

public class UsuarioDTO {

    private String nome;
    private List<EnderecoDTO> enderecos;

    public String getNome() {
        return nome;
    }

    public List<EnderecoDTO> getEnderecos() {
        return enderecos;
    }

    public UsuarioDTO(Usuario usuario) {
        this.nome = usuario.getNome();
        this.enderecos = usuario.getEnderecos().stream().map(EnderecoDTO::new).collect(Collectors.toList());
    }
}
