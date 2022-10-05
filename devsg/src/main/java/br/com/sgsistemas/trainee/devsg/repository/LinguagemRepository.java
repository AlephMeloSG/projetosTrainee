package br.com.sgsistemas.trainee.devsg.repository;

import br.com.sgsistemas.trainee.devsg.modelo.Equipe;
import br.com.sgsistemas.trainee.devsg.modelo.Linguagem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LinguagemRepository extends JpaRepository<Linguagem,Long> {
    Optional<Linguagem> findByNome(String nomeLinguagem);
}
