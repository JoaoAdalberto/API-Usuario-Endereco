package br.com.cadastro.endereco;

import br.com.cadastro.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/api/enderecos")
public class EnderecoController {

    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody @Valid EnderecoForm enderecoForm, UriComponentsBuilder uriBuilder){

        Endereco endereco = enderecoForm.converter(usuarioRepository);

        enderecoRepository.save(endereco);

        URI uri = uriBuilder.path("/api/enderecos/{id}").buildAndExpand(endereco.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

}
