package br.com.gvsbook.api.dto;

import jakarta.validation.constraints.NotNull;

public record AtualizaUsuarioDTO(
        @NotNull
        Long id,
        String email,
        String senha
) {
}
