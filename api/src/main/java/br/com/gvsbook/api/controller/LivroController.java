package br.com.gvsbook.api.controller;

import br.com.gvsbook.api.dto.AtualizaLivroDTO;
import br.com.gvsbook.api.dto.DetalhamentoLivroDTO;
import br.com.gvsbook.api.dto.LivroDTO;
import br.com.gvsbook.api.model.Livro;
import br.com.gvsbook.api.repository.LivroRepositoy;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;


@RestController
@RequestMapping("/livros")
public class LivroController {

  @Autowired
  LivroRepositoy repositoy;

  @GetMapping
  public ResponseEntity<List<DetalhamentoLivroDTO>> listarLivros() {
    var livros = repositoy.findAll();
    return ResponseEntity.ok(livros.stream().map(DetalhamentoLivroDTO::new).toList());
  }

  @PostMapping
  @Transactional
  public ResponseEntity cadastrarLivros(@RequestBody @Valid LivroDTO dados, UriComponentsBuilder uriBuilder) {
    var livro = new Livro(dados);
    repositoy.save(livro);
    var uri = uriBuilder.path("/livros/{id}").buildAndExpand(livro.getId()).toUri();
    return ResponseEntity.created(uri).body(new DetalhamentoLivroDTO(livro));
  }

  @PutMapping
  @Transactional
  public ResponseEntity atualizaLivro(@RequestBody @Valid AtualizaLivroDTO dados) {
    var livro = repositoy.getReferenceById(dados.id());
    livro.atualizaInformacoes(dados);
    return ResponseEntity.ok(new DetalhamentoLivroDTO(livro));
  }

  @GetMapping("/{id}")
  @Transactional
  public ResponseEntity listarLivroporId(@PathVariable Long id) {
    var livro = repositoy.getReferenceById(id);
    return ResponseEntity.ok(new DetalhamentoLivroDTO(livro));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity excluirLivro(@PathVariable Long id) {
    repositoy.deleteById(id);
    return ResponseEntity.noContent().build();
  }


}


