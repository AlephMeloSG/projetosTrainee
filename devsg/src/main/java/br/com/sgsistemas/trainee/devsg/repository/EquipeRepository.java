package br.com.sgsistemas.trainee.devsg.repository;

import br.com.sgsistemas.trainee.devsg.modelo.Equipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EquipeRepository extends JpaRepository<Equipe,Long> {
    Optional<Equipe> findByNome(String nome);
}
