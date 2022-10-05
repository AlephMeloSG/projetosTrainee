package br.com.sgsistemas.trainee.devsg.repository;

import br.com.sgsistemas.trainee.devsg.modelo.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PessoaRepository extends JpaRepository<Pessoa,Long> {
    Optional<Pessoa> findByNome(String nome);
}
