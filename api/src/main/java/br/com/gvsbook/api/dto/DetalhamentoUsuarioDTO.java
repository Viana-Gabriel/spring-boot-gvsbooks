package br.com.gvsbook.api.dto;

import br.com.gvsbook.api.enums.TipoUsuario;
import br.com.gvsbook.api.model.Livro;
import br.com.gvsbook.api.model.Usuario;

import java.util.List;

public record DetalhamentoUsuarioDTO(Long id, String nome, String email, TipoUsuario tipo , List<Livro> livrosSalvos) {
  public DetalhamentoUsuarioDTO(Usuario usuario){
    this(usuario.getId(), usuario.getNome(), usuario.getEmail(), usuario.getTipo(),usuario.getLivrosSalvos());
  }
}
