package br.com.sgsistemas.forum.repository;

import br.com.sgsistemas.forum.modelo.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CursoRepository extends JpaRepository<Curso,Long> {

    Curso findCursoByNome(String nome);
}
