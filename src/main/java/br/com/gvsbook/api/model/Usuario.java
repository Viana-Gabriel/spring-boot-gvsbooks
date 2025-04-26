package br.com.gvsbook.api.model;

import br.com.gvsbook.api.dto.AtualizaUsuarioDTO;
import br.com.gvsbook.api.dto.UsuarioDto;
import br.com.gvsbook.api.enums.TipoUsuario;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@EqualsAndHashCode(of = "id")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "usuario")
@Table(name = "usuarios")
public class Usuario {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String nome;
  private String email;
  private String senha;
  @Enumerated(EnumType.STRING)
  private TipoUsuario tipo;
  @ManyToMany
  @JoinTable(
          name = "usuario_livros",
          joinColumns = @JoinColumn(name = "usuario_id"),
          inverseJoinColumns = @JoinColumn(name = "livro_id")
  )
  private List<Livro> livrosSalvos;
  private Boolean status;

  public Usuario(UsuarioDto dados) {
    this.nome = dados.nome();
    this.email = dados.email();
    this.senha = dados.senha();
    this.tipo = dados.tipo();
    this.status = true;
    this.livrosSalvos = new ArrayList<>();
  }

  public void adicionarLivro(Livro livro) {
    if (livrosSalvos == null) {
      livrosSalvos = new ArrayList<>();
    }
    if (!livrosSalvos.contains(livro)) {
      livrosSalvos.add(livro);
    }
  }

  public void atualizar(@Valid AtualizaUsuarioDTO usuario) {
    if (usuario.email() != null) {
      this.email = usuario.email();
    }

    if (usuario.senha() != null) {
      this.senha = usuario.senha();
    }
  }

  public void desativar() {
    this.status = false;
  }

}
