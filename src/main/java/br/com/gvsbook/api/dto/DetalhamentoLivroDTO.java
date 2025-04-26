package br.com.gvsbook.api.dto;

import br.com.gvsbook.api.model.Livro;

public record DetalhamentoLivroDTO(Long Id, String titulo, String descricao, String autor, Double preco ) {
  public DetalhamentoLivroDTO(Livro livro){
    this(livro.getId(), livro.getTitulo(), livro.getDescricao(), livro.getAutor(), livro.getPreco());
  }
}
