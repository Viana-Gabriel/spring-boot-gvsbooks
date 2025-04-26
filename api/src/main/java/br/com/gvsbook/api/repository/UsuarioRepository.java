package br.com.gvsbook.api.repository;

import br.com.gvsbook.api.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
  List<Usuario> findByStatusTrue();
}
