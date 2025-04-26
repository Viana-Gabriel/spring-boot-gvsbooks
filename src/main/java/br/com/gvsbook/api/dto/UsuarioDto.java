package br.com.gvsbook.api.dto;

import br.com.gvsbook.api.enums.TipoUsuario;
import br.com.gvsbook.api.model.Livro;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record UsuarioDto(
        Long id,
        @NotBlank
        String nome,
        @Email
        String email,
        @NotBlank
        String senha,
        @NotNull
        TipoUsuario tipo,

        List<Livro> livrosSalvos) {
}
