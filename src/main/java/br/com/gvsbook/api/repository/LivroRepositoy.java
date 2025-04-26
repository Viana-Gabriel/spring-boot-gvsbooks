package br.com.gvsbook.api.repository;

import br.com.gvsbook.api.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepositoy extends JpaRepository<Livro,Long> {
}
