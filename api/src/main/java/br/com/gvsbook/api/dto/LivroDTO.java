package br.com.gvsbook.api.dto;

import br.com.gvsbook.api.enums.CategoriaLivro;


public record LivroDTO(Long id, String titulo, String descricao, String autor, CategoriaLivro categoria,Double preco, String enderecoImagem) {}
