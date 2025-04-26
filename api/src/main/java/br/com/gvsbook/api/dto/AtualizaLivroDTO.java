package br.com.gvsbook.api.dto;


import jakarta.validation.constraints.NotNull;

public record AtualizaLivroDTO(
        @NotNull Long id,
        String descricao,
        Double preco){}
