package br.com.gvsbook.api.controller;


import br.com.gvsbook.api.dto.AtualizaUsuarioDTO;
import br.com.gvsbook.api.dto.DetalhamentoUsuarioDTO;
import br.com.gvsbook.api.dto.UsuarioDto;
import br.com.gvsbook.api.model.Usuario;
import br.com.gvsbook.api.repository.LivroRepositoy;
import br.com.gvsbook.api.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

  @Autowired
  UsuarioRepository repositoryUser;

  @Autowired
  LivroRepositoy repositoyLivro;

  @PostMapping
  @Transactional
  public ResponseEntity cadastrarUsuario(@Valid @RequestBody UsuarioDto dados , UriComponentsBuilder uriBuilder){
    var usuario = new Usuario(dados);
    repositoryUser.save(usuario);
    var uri = uriBuilder.path("/usuarios/{id}").buildAndExpand(usuario.getId()).toUri();
    return ResponseEntity.created(uri).body(usuario);
  }

  @PostMapping("/{usuarioId}/livros/{livroId}")
  @Transactional
  public ResponseEntity<String> salvarLivro(@PathVariable Long usuarioId, @PathVariable Long livroId){

    var usuario = repositoryUser.getReferenceById(usuarioId);
    var livro = repositoyLivro.findById(livroId).orElse(null);

    if (usuario == null || livro == null){
      return ResponseEntity.notFound().build();
    }

    usuario.adicionarLivro(livro);
    repositoryUser.save(usuario);

    return ResponseEntity.ok("livro adicionado ao salvos com sucesso");
  }

  @GetMapping
  public ResponseEntity<List<DetalhamentoUsuarioDTO>> listarUsuarios(){
    var usuarios = repositoryUser.findByStatusTrue();
    return ResponseEntity.ok(usuarios.stream().map(DetalhamentoUsuarioDTO::new).toList());
  }

  @PutMapping
  @Transactional
  public ResponseEntity atualizarUsuario(@RequestBody @Valid AtualizaUsuarioDTO dados){
    var usuario = repositoryUser.getReferenceById(dados.id());
    usuario.atualizar(dados);
    return ResponseEntity.ok(new DetalhamentoUsuarioDTO(usuario));
  }

  @DeleteMapping("/{id}")
  @Transactional
  public ResponseEntity desativarUsuario(@PathVariable Long id){
    var usuario = repositoryUser.getReferenceById(id);
    usuario.desativar();
    return ResponseEntity.noContent().build();
  }

  @GetMapping("/{id}")
  public ResponseEntity listarUsuarioPorId(@PathVariable Long id){
    var usuario = repositoryUser.getReferenceById(id);
    return ResponseEntity.ok(new DetalhamentoUsuarioDTO(usuario));
  }
}
