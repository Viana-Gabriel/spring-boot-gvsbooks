package br.com.gvsbook.api.dto;

import br.com.gvsbook.api.enums.CategoriaLivro;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public record LivroDTO(
        Long id,
        @NotBlank
        String titulo,
        @NotBlank
        String descricao,
        @NotBlank
        String autor,
        @NotNull
        CategoriaLivro categoria,
        @NotNull
        Double preco,
        @NotBlank
        String enderecoImagem) {}
