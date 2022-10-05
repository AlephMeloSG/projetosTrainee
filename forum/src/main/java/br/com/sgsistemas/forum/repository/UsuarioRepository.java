package br.com.sgsistemas.forum.repository;

import br.com.sgsistemas.forum.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
