package br.com.gvsbook.api.model;

import br.com.gvsbook.api.dto.AtualizaLivroDTO;
import br.com.gvsbook.api.dto.LivroDTO;
import br.com.gvsbook.api.enums.CategoriaLivro;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity(name = "livro")
@Table(name = "livros")
public class Livro {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String titulo;
  private String descricao;
  private String autor;

  @Enumerated(EnumType.STRING)
  private CategoriaLivro categoria;
  private Double preco;
  private String enderecoImagem;

  @ManyToMany(mappedBy = "livrosSalvos")
  @JsonIgnore
  private List<Usuario> usuarios = new ArrayList<>();

  public Livro(LivroDTO livro) {

    this.titulo = livro.titulo();
    this.descricao = livro.descricao();
    this.autor = livro.autor();
    this.categoria = livro.categoria();
    this.preco = livro.preco();
    this.enderecoImagem = livro.enderecoImagem();
  }


  public void atualizaInformacoes(@Valid AtualizaLivroDTO livro) {
    if (livro.descricao() != null){
      this.descricao = livro.descricao();
    }
    if (livro.preco() != null){
      this.preco = livro.preco();
    }

  }
}
